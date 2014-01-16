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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.TypeReferenceNode;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Neighbor;

public class ThrowsAddOperation extends AbstractNodeOperation {
	private TypeReference source;

	public ThrowsAddOperation(ModelContext context, Object parent,
			NodeType nodeType, NodeMoveProvider moveProvider,
			Neighbor neighbor, boolean before) {
		super("Throws-Operation", context, parent, nodeType, moveProvider,
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
		Method method = null;
		if (parent instanceof Method)
			method = ((Method) parent);

		if (method == null)
			return null;
		if (source == null)
			source = ModelFactory.eINSTANCE.createTypeReference();
		
		// select newly created node
		AbstractNode<?> newNode = (refreshNode.toNode(nodeType, source));

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
			method.getThrowsElements().add(source);
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
		if (newNode instanceof TypeReferenceNode) {
			NodeDeleteProvider<TypeReference> deleteProvider = ((TypeReferenceNode) newNode)
					.getDeleteProvider();
			if (deleteProvider != null)
				deleteProvider.delete(context, source);
		}
		return Status.OK_STATUS;
	}
}
