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
package org.gnstudio.apdt.model.editor.nodes.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.TrySequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeActions;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.sequence.SequenceNode.AssociateNodeProvider;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class TryGroupNode extends GroupNode implements NodeOverview,
		AssociateNodeProvider {
	private final TrySequence trySequence;

	public TryGroupNode(AbstractNode<?> parent, final TrySequence provider,
			final NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, toTryGroup(provider), new NodeDeleteProvider<Sequence>() {

			public void delete(ModelContext context, Sequence t) {
				if (t.equals(provider) || toTryGroup(provider).equals(t)) {
					deleteProvider.delete(context, provider);
				}

			}

			public AbstractOperation createDeleteOperation(
					ModelContext context, Sequence t) {
				// TODO Auto-generated method stub
				return deleteProvider.createDeleteOperation(context, provider);
			}
		});
		this.trySequence = provider;
	}

	public TrySequence getTrySequence() {
		return trySequence;
	}

	private static SequenceGroup toTryGroup(TrySequence controlSequence) {
		if (controlSequence.getTryGroup() != null) {
			return controlSequence.getTryGroup();
		} else {
			SequenceGroup ifGroup = ModelFactory.eINSTANCE
					.createSequenceGroup();
			ifGroup.setDescription(ModelFactory.eINSTANCE.createDescription());
			controlSequence.setTryGroup(ifGroup);
			return ifGroup;
		}
	}

	@Override
	public String getName() {
		return APDEditorMessages.TreeNode_try;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.try");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_SEQN_TRY;
	}

	public void addOverview(StyledString styledString) {
		if (group.getName() != null && group.getName().length() > 0) {
			styledString.append(group.getName(),
					StyledString.DECORATIONS_STYLER);
		}

	}

	public Action[] getActions(final ModelContext context) {
		return new Action[] {
				DescriptionNode.newDescripationAction(context, this, group),
				null, newCatchAction(context), newFinallyAction(context), null,
				SequenceNode.newAction(context, this, NodeType.VARIABLE),
				SequenceNode.newAction(context, this, NodeType.COMMENT),
				SequenceNode.newAction(context, this, NodeType.ITERATION),
				SequenceNode.newAction(context, this, NodeType.IF),
				SequenceNode.newAction(context, this, NodeType.SWITCH),
				SequenceNode.newAction(context, this, NodeType.GROUP),
				SequenceNode.newAction(context, this, NodeType.TRY),
				SequenceNode.newAction(context, this, NodeType.METHOD_CALL),
				SequenceNode.newAction(context, this, NodeType.RECURSION),
				SequenceNode.newAction(context, this, NodeType.PRINT),
				SequenceNode.newAction(context, this, NodeType.SHOW),
				SequenceNode.newAction(context, this, NodeType.PROMPT),
				SequenceNode.newAction(context, this, NodeType.READ),
				SequenceNode.newAction(context, this, NodeType.WRITE),
				SequenceNode.newAction(context, this, NodeType.RECOVER),
				SequenceNode.newAction(context, this, NodeType.STORE),
				SequenceNode.newAction(context, this, NodeType.CALC_STORE),
				SequenceNode.newAction(context, this, NodeType.METHOD_RETURN) };
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		List<NodeType> types = new ArrayList<NodeType>();
		types.add(NodeType.DESCRIPTION);
		types.add(NodeType.CATCH);
		types.add(NodeType.FINALLY);
		types.addAll(Arrays.asList(SequenceNode.getSequenceNodeTypes()));
		return types.toArray(new NodeType[0]);
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return group.getDescription() == null;
		case FINALLY:
			return trySequence.getFinallyGroup() == null;
		case CATCH:
			return true;
		default:
			return SequenceNode.isSequenceType(type);
		}
	}

	public List<AbstractNode<?>> getAssociateNodes() {
		if (!(trySequence.getCatchGroups().size() > 0 || trySequence
				.getFinallyGroup() != null)) {
			return Collections.emptyList();
		}
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();
		for (SequenceGroup catchGroup : trySequence.getCatchGroups()) {

			nodes.add(new CatchGroupNode(getParent(), trySequence, catchGroup,
					new NodeDeleteProvider<Sequence>() {
						public void delete(ModelContext context,
								Sequence sequence) {

							if (trySequence.getCatchGroups().size() == 1
									&& trySequence.getFinallyGroup() == null) {
								TryGroupNode.this.getDeleteProvider().delete(
										context, TryGroupNode.this.source);
							} else {
								trySequence.getCatchGroups().remove(sequence);
								context.modelUpdated();
								context.refreah(getParent());
							}
						}

						public AbstractOperation createDeleteOperation(
								ModelContext context, Sequence t) {
							if (trySequence.getCatchGroups().size() == 1
									&& trySequence.getFinallyGroup() == null) {
								return TryGroupNode.this.getDeleteProvider()
										.createDeleteOperation(context,
												TryGroupNode.this.source);
							}
							return AbstractDeleteOperation.create(context,
									getParent(), trySequence.getCatchGroups(),
									t);
						}
					}));

		}
		if (trySequence.getFinallyGroup() != null) {
			nodes.add(new FinallyGroupNode(getParent(), trySequence,
					trySequence.getFinallyGroup(),
					new NodeDeleteProvider<Sequence>() {

						public void delete(ModelContext context,
								Sequence sequence) {

							if (trySequence.getCatchGroups().size() == 0) {
								TryGroupNode.this.getDeleteProvider().delete(
										context, TryGroupNode.this.source);
							} else {
								trySequence.setFinallyGroup(null);
								context.modelUpdated();
								context.refreah(getParent());
							}
						}

						public AbstractOperation createDeleteOperation(
								final ModelContext context, final Sequence t) {
							if (trySequence.getCatchGroups().size() == 0) {
								return TryGroupNode.this.getDeleteProvider()
										.createDeleteOperation(context, t);
							}
							return new AbstractDeleteOperation() {

								@Override
								public IStatus undo(IProgressMonitor monitor,
										IAdaptable info) {
									trySequence
											.setFinallyGroup((SequenceGroup) t);
									context.modelUpdated();
									context.refreah(getParent());
									return Status.OK_STATUS;
								}

								@Override
								public IStatus redo(IProgressMonitor monitor,
										IAdaptable info) {
									delete(context, t);
									return Status.OK_STATUS;
								}
							};
						}
					}));
		}
		return nodes;
	}

	private Action newFinallyAction(final ModelContext context) {
		Action descAction = new Action() {
			@Override
			public boolean isEnabled() {
				return (trySequence.getFinallyGroup() == null);
			}

			public void run() {
				NodeActions.createNewNode(context, TryGroupNode.this,
						NodeType.FINALLY);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_finally);
		return descAction;
	}

	private Action newCatchAction(final ModelContext context) {
		Action descAction = new Action() {

			public void run() {
				NodeActions.createNewNode(context, TryGroupNode.this,
						NodeType.CATCH);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_catch);
		return descAction;
	}

	@Override
	public AssociateNodeProvider getAssociateNodeProvider() {
		return this;
	}

	@Override
	public Object getNeighborSource() {
		return trySequence;
	}
}
