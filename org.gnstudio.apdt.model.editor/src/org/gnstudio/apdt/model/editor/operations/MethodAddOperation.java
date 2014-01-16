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
package org.gnstudio.apdt.model.editor.operations;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.MethodNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Neighbor;

public class MethodAddOperation extends AbstractNodeOperation {
	private Method source;

	public MethodAddOperation(ModelContext context, Object parent,
			NodeType nodeType, NodeMoveProvider moveProvider,
			Neighbor neighbor, boolean before) {
		super("Method-Operation", context, parent, nodeType, moveProvider,
				neighbor, before);
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		context.selectNodes(false, createNode());
		return Status.OK_STATUS;
	}

	private AbstractNode<?> createNode() {
		final AbstractNode<?> refreshNode = context.findNode(parent);
		EList<Method> methods = null;
		if (parent instanceof ClassElement)
			methods = ((ClassElement) parent).getMethods();
		else if (parent instanceof InterfaceElement)
			methods = ((InterfaceElement) parent).getMethods();

		if (methods == null)
			return null;

		if (source == null) {
			source = ModelFactory.eINSTANCE.createMethod();
			source.setSignature(ModelFactory.eINSTANCE.createMethodSignature());
		}

		// select newly created node
		final EList<Method> deleteList = methods;
		MethodNode newNode = (new MethodNode(refreshNode, source,
				new NodeDeleteProvider<Method>() {

					public void delete(ModelContext context, Method t) {
						deleteList.remove(t);

					}

					public AbstractOperation createDeleteOperation(
							ModelContext context, Method t) {
						throw new AssertionError("Delete Operation not supported");
					}
				}));

		if (neighbor != null && moveProvider != null
				&& moveProvider.canMove(neighbor, nodeType)) {
			Object source;
			if (newNode instanceof NodeMoveProvider.Neighbor)
				source = ((NodeMoveProvider.Neighbor) newNode)
						.getNeighborSource();
			else
				source = newNode.getSource();

			moveProvider.move(context, neighbor, source, before);

		} else {
			methods.add(source);
		}
		context.modelUpdated();
		context.refreah(refreshNode);
		return newNode;
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		// select node
		context.selectNodes(true, createNode());
		return Status.OK_STATUS;
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		AbstractNode<?> newNode = context.findNode(source);
		if (newNode instanceof MethodNode) {
			NodeDeleteProvider<Method> deleteProvider = ((MethodNode) newNode)
					.getDeleteProvider();
			if (deleteProvider != null)
				deleteProvider.delete(context, source);
		}
		return Status.OK_STATUS;
	}
}
