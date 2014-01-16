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
package org.gnstudio.apdt.model.editor.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ClassElementNode;
import org.gnstudio.apdt.model.editor.nodes.InterfaceElementNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.PackageElementNode;
import org.gnstudio.apdt.model.editor.nodes.ProgramNode;
import org.gnstudio.apdt.model.editor.nodes.sequence.SequenceNode;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class TreeContent implements ITreeContentProvider {

	public void dispose() {
		// ignore
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// ignore
	}

	public Object[] getElements(Object inputElement) {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();
		if (inputElement instanceof Model) {
			Model model = (Model) inputElement;
			List<Program> programs = model.getPrograms();
			for (Program program : programs) {
				nodes.add(new ProgramNode(program));
			}

			// if Sequence mode add Sequence nodes
			for (Sequence sequence : model.getSequences()) {
				SequenceNode node = SequenceNode.toSequenceNode(null, model,
						sequence);
				assert node != null;
				nodes.add(node);
				SequenceNode.AssociateNodeProvider nodeProvider = node
						.getAssociateNodeProvider();
				if (nodeProvider != null) {
					nodes.addAll(nodeProvider.getAssociateNodes());
				}
			}
			// if PackageElement mode add packages
			EList<PackageElement> packages = model.getPackages();
			for (PackageElement pkg : packages) {
				nodes.add(new PackageElementNode(null, pkg,
						new NodeDeleteProvider<PackageElement>() {

							public void delete(ModelContext context,
									PackageElement packageElement) {
								context.getModel().getPackages()
										.remove(packageElement);
								context.modelUpdated();
								context.refreahAll();
							}

							public AbstractOperation createDeleteOperation(
									ModelContext context, PackageElement t) {
								return AbstractDeleteOperation.create(context,
										null, context.getModel().getPackages(),
										t);
							}
						}));
			}

			// if ClassElement mode add ClassElement node
			if (model.getClassElement() != null) {
				nodes.add(new ClassElementNode(null, model.getClassElement(),
						new NodeDeleteProvider<ClassElement>() {

							public void delete(ModelContext context,
									ClassElement t) {
								context.getModel().setClassElement(null);
								context.modelUpdated();
								context.refreahAll();
							}

							public AbstractOperation createDeleteOperation(
									final ModelContext context,
									final ClassElement t) {
								// TODO Auto-generated method stub
								return new AbstractDeleteOperation() {

									@Override
									public IStatus undo(
											IProgressMonitor monitor,
											IAdaptable info) {
										context.getModel().setClassElement(t);
										context.modelUpdated();
										context.refreahAll();
										return Status.OK_STATUS;
									}

									@Override
									public IStatus redo(
											IProgressMonitor monitor,
											IAdaptable info) {
										delete(context, t);
										return Status.OK_STATUS;
									}
								};
							}
						}));
			}

			// if InterfaceElement mode add InterfaceElement node
			if (model.getInterfaceElement() != null) {
				nodes.add(new InterfaceElementNode(null, model
						.getInterfaceElement(),
						new NodeDeleteProvider<InterfaceElement>() {

							public void delete(ModelContext context,
									InterfaceElement t) {
								context.getModel().setInterfaceElement(null);
								context.modelUpdated();
								context.refreahAll();

							}

							public AbstractOperation createDeleteOperation(
									final ModelContext context,
									final InterfaceElement t) {
								return new AbstractDeleteOperation() {

									@Override
									public IStatus undo(
											IProgressMonitor monitor,
											IAdaptable info) {
										context.getModel().setInterfaceElement(
												t);
										context.modelUpdated();
										context.refreahAll();
										return Status.OK_STATUS;
									}

									@Override
									public IStatus redo(
											IProgressMonitor monitor,
											IAdaptable info) {
										delete(context, t);
										return Status.OK_STATUS;
									}
								};
							}
						}));
			}
		}

		return nodes.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof AbstractNode) {
			AbstractNode<?> node = (AbstractNode<?>) parentElement;
			return node.getChildren();
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if (element instanceof AbstractNode) {
			AbstractNode<?> node = (AbstractNode<?>) element;
			return node.getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof AbstractNode) {
			AbstractNode<?> node = (AbstractNode<?>) element;
			return !node.isLeaf();
		}
		return false;
	}

}