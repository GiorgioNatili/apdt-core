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
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.TrySequence;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Neighbor;
import org.gnstudio.apdt.model.editor.nodes.sequence.CatchGroupNode;
import org.gnstudio.apdt.model.editor.nodes.sequence.FinallyGroupNode;
import org.gnstudio.apdt.model.editor.nodes.sequence.GroupNode;
import org.gnstudio.apdt.model.editor.nodes.sequence.TryGroupNode;

public class TryCatchAddOperation extends AbstractNodeOperation {
	private SequenceGroup source;

	public TryCatchAddOperation(ModelContext context, Object parent,
			NodeType nodeType, NodeMoveProvider moveProvider,
			Neighbor neighbor, boolean before) {
		super("Try-Catch-Operation", context, parent, nodeType, moveProvider,
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
		// catch + finally are associate nodes of tryGroupNode

		final TrySequence trySequence ;
		if (refreshNode instanceof TryGroupNode)
			trySequence = ((TryGroupNode) refreshNode).getTrySequence();
		else
			return null;

		if (source == null) {
			source = ModelFactory.eINSTANCE.createSequenceGroup();
			// XXX: do we need Description by default ?
			// group.setDescription(ModelFactory.eINSTANCE.createDescription());
		}

		if (nodeType == NodeType.CATCH)
			trySequence.getCatchGroups().add(source);
		else
			trySequence.setFinallyGroup(source);

		context.modelUpdated();
		// use super parent as associate nodes

		final AbstractNode<?> parentRefreshNode = (refreshNode.getParent());
		// select newly created node
		GroupNode newNode;
		if (nodeType == NodeType.FINALLY)
			newNode = (new FinallyGroupNode(parentRefreshNode, trySequence,
					source, new NodeDeleteProvider<Sequence>() {

						public void delete(ModelContext context, Sequence t) {
							trySequence.setFinallyGroup(null);
							context.modelUpdated();
							context.refreah(parentRefreshNode);
						}

						public AbstractOperation createDeleteOperation(
								ModelContext context, Sequence t) {
							throw new AssertionError("Delete Operation not supported");
						}
					}));
		else
			newNode = (new CatchGroupNode(parentRefreshNode, trySequence,
					source, new NodeDeleteProvider<Sequence>() {

						public void delete(ModelContext context, Sequence t) {
							trySequence.getCatchGroups().remove(t);
							context.modelUpdated();
							context.refreah(parentRefreshNode);

						}

						public AbstractOperation createDeleteOperation(
								ModelContext context, Sequence t) {
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
			if (nodeType == NodeType.CATCH)
				trySequence.getCatchGroups().add(source);
			else
				trySequence.setFinallyGroup(source);
		}
		context.modelUpdated();
		context.refreah(parentRefreshNode);
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
		if (newNode instanceof GroupNode) {
			NodeDeleteProvider<Sequence> deleteProvider = ((GroupNode) newNode)
					.getDeleteProvider();
			if (deleteProvider != null)
				deleteProvider.delete(context, source);
		}
		return Status.OK_STATUS;
	}
}
