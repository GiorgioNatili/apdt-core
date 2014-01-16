/*******************************************************************************
 * Copyright (c) 2010, 2012 GNstudio s.r.l. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 *
 * Contributors:
 *   GNstudio s.r.l. - initial API and implementation
 *******************************************************************************/
package org.gnstudio.apdt.model.editor.nodes.dnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeActions;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.util.ModelOperation;

public class NodeViewDropAdapter extends ViewerDropAdapter {
	private final ModelContext context;

	public NodeViewDropAdapter(ModelContext context, Viewer viewer) {
		super(viewer);
		this.context = context;
		setFeedbackEnabled(true);
	}

	public void dragEnter(DropTargetEvent event) {
		if ((NodeTransfer.getInstance().isSupportedType(event.currentDataType))
				&& (event.detail == DND.DROP_DEFAULT || event.detail == DND.DROP_MOVE)) {
			Object dndData = NodeTransfer.getInstance().nativeToJava(
					event.currentDataType);
			if (dndData instanceof NodeType)
				event.detail = DND.DROP_COPY;

		}
		super.dragEnter(event);
	}

	public void dragOperationChanged(DropTargetEvent event) {
		if ((NodeTransfer.getInstance().isSupportedType(event.currentDataType))
				&& (event.detail == DND.DROP_DEFAULT || event.detail == DND.DROP_MOVE)) {
			Object dndData = NodeTransfer.getInstance().nativeToJava(
					event.currentDataType);
			if (dndData instanceof NodeType)
				event.detail = DND.DROP_COPY;

		}
		super.dragOperationChanged(event);
	}

	@Override
	public boolean performDrop(Object data) {
		final int location = getCurrentLocation();
		Object target = getCurrentTarget();
		if (data instanceof NodeType) {
			NodeType dropType = (NodeType) data;

			if (target instanceof AbstractNode<?>) {
				AbstractNode<?> node = (AbstractNode<?>) target;

				if (location == LOCATION_ON) {
					NodeActions.createNewNode(context,
							(AbstractNode<?>) getCurrentTarget(), dropType);
				} else {
					NodeMoveProvider.Neighbor neighbor = null;
					if (node instanceof NodeMoveProvider.Neighbor) {
						neighbor = (NodeMoveProvider.Neighbor) node;
					} else
						return false;

					NodeMoveProvider provider = null;
					if (node.getParent() == null) {
						provider = context.getRootNodeMoveProvider();
					} else if (node.getParent() instanceof NodeMoveProvider) {
						provider = (NodeMoveProvider) node.getParent();
					}
					if (provider != null && neighbor != null) {
						NodeActions.createNewNode(context, node.getParent(),
								dropType, provider, neighbor,
								location == LOCATION_BEFORE);
						return true;
					}
				}
			} else if (context.isRootTypes(dropType))
				NodeActions.createNewNode(context, null, dropType);
			return true;
		}
		if (data instanceof Object[]) {

			Object[] sourceNodes = (Object[]) data;
			final List<AbstractOperation> operations = new ArrayList<AbstractOperation>(
					sourceNodes.length);
			for (Object object : sourceNodes) {
				if (object instanceof AbstractNode<?>) {
					final AbstractNode<?> sourceNode = (AbstractNode<?>) object;
					final AbstractNode<?> node;
					if (target instanceof AbstractNode<?>)
						node = (AbstractNode<?>) target;
					else
						node = null;

					if ((location == LOCATION_BEFORE || location == LOCATION_AFTER)) {
						final NodeMoveProvider.Neighbor neighbor;
						if (node instanceof NodeMoveProvider.Neighbor) {
							neighbor = (NodeMoveProvider.Neighbor) node;
						} else
							return false;

						NodeMoveProvider provider = null;
						if (node.getParent() == null) {
							provider = context.getRootNodeMoveProvider();
						} else if (node.getParent() instanceof NodeMoveProvider) {
							provider = (NodeMoveProvider) node.getParent();
						}

						if (provider != null && neighbor != null) {
							final NodeMoveProvider moveProvider = provider;
							final Object source;
							if (sourceNode instanceof NodeMoveProvider.Neighbor)
								source = ((NodeMoveProvider.Neighbor) sourceNode)
										.getNeighborSource();
							else
								source = sourceNode.getSource();

							AbstractOperation pasteOpration = new AbstractOperation(
									"Move") {

								private AbstractOperation undoDelOperation;

								@Override
								public IStatus undo(IProgressMonitor monitor,
										IAdaptable info)
										throws ExecutionException {
									AbstractNode<?> sourceNode = context
											.findNode(source);
									if (sourceNode != null) {
										@SuppressWarnings("unchecked")
										NodeDeleteProvider<Object> deleteProvider = (NodeDeleteProvider<Object>) sourceNode
												.getDeleteProvider();
										if (deleteProvider != null) {
											deleteProvider.delete(context,
													source);
										}
										if (undoDelOperation != null) {
											undoDelOperation.undo(null, null);
										}
										context.modelUpdated();
										context.refreah(sourceNode.getParent());
									}
									return Status.OK_STATUS;
								}

								@Override
								public IStatus redo(IProgressMonitor monitor,
										IAdaptable info)
										throws ExecutionException {
									@SuppressWarnings("unchecked")
									NodeDeleteProvider<Object> sourceDelProvider = (NodeDeleteProvider<Object>) sourceNode
											.getDeleteProvider();
									if (sourceDelProvider != null) {
										undoDelOperation = sourceDelProvider
												.createDeleteOperation(context,
														sourceNode.getSource());
										undoDelOperation.execute(null, null);
									}

									moveProvider
											.move(context, neighbor, source,
													location == LOCATION_BEFORE);
									context.modelUpdated();

									context.refreah(node != null ? node
											.getParent() : null);
									context.selectNodes(false, sourceNode);
									return Status.OK_STATUS;
								}

								@Override
								public IStatus execute(
										IProgressMonitor monitor,
										IAdaptable info)
										throws ExecutionException {
									return redo(monitor, info);
								}
							};
							operations.add(pasteOpration);
						}

					} else if (location == LOCATION_ON
							|| location == LOCATION_NONE) {
						NodeMoveProvider tagetProvider = null;
						if (node == null)
							tagetProvider = context.getRootNodeMoveProvider();
						else if (node instanceof NodeMoveProvider) {
							tagetProvider = (NodeMoveProvider) node;
						}
						final NodeMoveProvider provider = tagetProvider;

						final Object source;
						if (sourceNode instanceof NodeMoveProvider.Neighbor)
							source = ((NodeMoveProvider.Neighbor) sourceNode)
									.getNeighborSource();
						else
							source = sourceNode.getSource();

						if (provider != null) {

							AbstractOperation pasteOpration = new AbstractOperation(
									"Move") {

								private AbstractOperation undoDelOperation;

								@Override
								public IStatus undo(IProgressMonitor monitor,
										IAdaptable info)
										throws ExecutionException {
									AbstractNode<?> sourceNode = context
											.findNode(source);
									if (sourceNode != null) {
										@SuppressWarnings("unchecked")
										NodeDeleteProvider<Object> deleteProvider = (NodeDeleteProvider<Object>) sourceNode
												.getDeleteProvider();
										if (deleteProvider != null) {
											deleteProvider.delete(context,
													source);
										}
										if (undoDelOperation != null) {
											undoDelOperation.undo(null, null);
										}
										context.modelUpdated();
										context.refreah(sourceNode.getParent());
									}
									return Status.OK_STATUS;
								}

								@Override
								public IStatus redo(IProgressMonitor monitor,
										IAdaptable info)
										throws ExecutionException {
									@SuppressWarnings("unchecked")
									NodeDeleteProvider<Object> sourceDelProvider = (NodeDeleteProvider<Object>) sourceNode
											.getDeleteProvider();
									if (sourceDelProvider != null) {
										undoDelOperation = sourceDelProvider
												.createDeleteOperation(context,
														sourceNode.getSource());
										undoDelOperation.execute(null, null);
									}

									provider.move(context, null, source, false);
									context.modelUpdated();

									context.refreah(node);
									sourceNode.setParent(node);
									context.selectNodes(false, sourceNode);
									return Status.OK_STATUS;
								}

								@Override
								public IStatus execute(
										IProgressMonitor monitor,
										IAdaptable info)
										throws ExecutionException {
									return redo(monitor, info);
								}
							};
							operations.add(pasteOpration);

						}
					}
				}
			}
			if (operations.size() == 1) {
				context.getOperationSupport().execute(operations.get(0), null);
			} else {
				AbstractOperation proxyOp = new AbstractOperation("Move") {

					@Override
					public IStatus undo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						List<AbstractOperation> ops = new ArrayList<AbstractOperation>(
								operations);
						Collections.reverse(ops);
						for (AbstractOperation abstractOperation : ops) {
							abstractOperation.undo(monitor, info);
						}
						return Status.OK_STATUS;
					}

					@Override
					public IStatus redo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {

						for (AbstractOperation abstractOperation : operations) {
							abstractOperation.redo(monitor, info);
						}
						return Status.OK_STATUS;
					}

					@Override
					public IStatus execute(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						return redo(monitor, info);
					}
				};
				context.getOperationSupport().execute(proxyOp, null);
			}
		}
		return false;
	}

	@Override
	public boolean validateDrop(Object target, int operation,
			TransferData transferType) {
		if (NodeTransfer.getInstance().isSupportedType(transferType)) {
			Object dndData = NodeTransfer.getInstance().nativeToJava(
					transferType);
			final int location = getCurrentLocation();
			if (dndData instanceof NodeType) {
				NodeType dropType = (NodeType) dndData;

				if (target instanceof AbstractNode) {
					AbstractNode<?> node = (AbstractNode<?>) target;

					if (location == LOCATION_ON)
						return node.canAddNodeType(dropType);

					NodeMoveProvider.Neighbor relation = null;
					if (node instanceof NodeMoveProvider.Neighbor) {
						relation = (NodeMoveProvider.Neighbor) node;
					} else
						return false;

					AbstractNode<?> parent = node.getParent();
					boolean valid = false;
					if (parent == null)
						valid = context.isRootTypes(dropType);
					else
						valid = parent.canAddNodeType(dropType);

					if (valid) {
						NodeMoveProvider provider = null;
						if (parent == null) {
							provider = context.getRootNodeMoveProvider();
						} else if (parent instanceof NodeMoveProvider) {
							provider = (NodeMoveProvider) parent;
						}
						valid = provider != null
								&& provider.canMove(relation, dropType);
						// if (location == LOCATION_BEFORE)
						// System.out.println("before  - " + target);
						// if (location == LOCATION_AFTER)
						// System.out.println("after  - " + target);
					}

					return valid;

				}
				return context.isRootTypes(dropType);
			}
			if (dndData instanceof Object[]) {
				Object[] sourceNodes = (Object[]) dndData;
				AbstractNode<?> node = (AbstractNode<?>) target;
				boolean valid = false;
				for (Object element : sourceNodes) {
					if (!(element instanceof AbstractNode<?>)) {
						valid = false;
						break;
					}

					AbstractNode<?> sourceNode = (AbstractNode<?>) element;

					if ((location == LOCATION_BEFORE || location == LOCATION_AFTER)) {
						NodeMoveProvider.Neighbor relation = null;
						if (node instanceof NodeMoveProvider.Neighbor) {
							relation = (NodeMoveProvider.Neighbor) node;
						} else
							return false;

						AbstractNode<?> parent = node.getParent();

						NodeMoveProvider provider = null;
						if (parent == null) {
							provider = context.getRootNodeMoveProvider();
						} else if (parent instanceof NodeMoveProvider) {
							provider = (NodeMoveProvider) parent;
						}
						Object source;
						if (sourceNode instanceof NodeMoveProvider.Neighbor)
							source = ((NodeMoveProvider.Neighbor) sourceNode)
									.getNeighborSource();
						else
							source = sourceNode.getSource();

						if (parent != null && source instanceof EObject
								&& parent.getSource() instanceof EObject) {
							if (ModelOperation.isAncestor((EObject) source,
									(EObject) parent.getSource()))
								return false;
						}
						valid = provider != null
								&& !relation.getNeighborSource().equals(source)
								&& provider.canMove(relation, source);

					} else if (location == LOCATION_ON
							|| location == LOCATION_NONE) {
						NodeMoveProvider provider = null;
						if (node == null)
							provider = context.getRootNodeMoveProvider();
						else if (node instanceof NodeMoveProvider) {
							provider = (NodeMoveProvider) node;
						}
						if (provider == null) {
							return false;
						}
						Object source;
						if (sourceNode instanceof NodeMoveProvider.Neighbor)
							source = ((NodeMoveProvider.Neighbor) sourceNode)
									.getNeighborSource();
						else
							source = sourceNode.getSource();
						if (source instanceof EObject && node != null
								&& node.getSource() instanceof EObject) {
							if (ModelOperation.isAncestor((EObject) source,
									(EObject) node.getSource()))
								valid = false;
						}
						valid = provider != null
								&& provider.canMove(null, source);
					}
					if (!valid)
						break;
				}
				return valid;

			}

		}
		return false;
	}

}
