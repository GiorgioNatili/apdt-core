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
import org.gnstudio.apdt.model.ControlSequence;
import org.gnstudio.apdt.model.Iteration;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.SequenceProvider;
import org.gnstudio.apdt.model.SwitchSequence;
import org.gnstudio.apdt.model.TrySequence;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Neighbor;
import org.gnstudio.apdt.model.editor.nodes.sequence.SequenceNode;

public class SequenceAddOperation extends AbstractNodeOperation {
	private Sequence source;

	public SequenceAddOperation(ModelContext context, Object parent,
			NodeType nodeType, NodeMoveProvider moveProvider,
			Neighbor neighbor, boolean before) {
		super("Sequence-Operation", context, parent, nodeType, moveProvider,
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
		SequenceProvider provider = null;
		if (parent != null && parent instanceof SequenceProvider) {
			provider = (SequenceProvider) parent;

		} else
			provider = context.getModel();
		if (source == null) {

			switch (nodeType) {
			case VARIABLE:
				source = ModelFactory.eINSTANCE.createVariable();
				break;
			case COMMENT:
				source = ModelFactory.eINSTANCE.createComment();
				break;
			case RECURSION:
				source = ModelFactory.eINSTANCE.createRecursion();
				break;
			case PRINT:
				source = ModelFactory.eINSTANCE.createPrint();
				break;
			case SHOW:
				source = ModelFactory.eINSTANCE.createShow();
				break;
			case PROMPT:
				source = ModelFactory.eINSTANCE.createPrompt();
				break;
			case READ:
				source = ModelFactory.eINSTANCE.createRead();
				break;
			case WRITE:
				source = ModelFactory.eINSTANCE.createWrite();
				break;
			case RECOVER:
				source = ModelFactory.eINSTANCE.createRecover();
				break;
			case STORE:
				source = ModelFactory.eINSTANCE.createStore();
				break;
			case CALC_STORE:
				source = ModelFactory.eINSTANCE.createCalculateStore();
				break;
			case METHOD_CALL:
				source = ModelFactory.eINSTANCE.createMethodCall();
				break;
			case METHOD_RETURN:
				source = ModelFactory.eINSTANCE.createMethodReturn();
				break;
			case GROUP: {
				SequenceGroup group = ModelFactory.eINSTANCE
						.createSequenceGroup();
				// group.setDescription(ModelFactory.eINSTANCE.createDescription());
				source = group;
				break;
			}
			case ITERATION: {
				Iteration iteration = ModelFactory.eINSTANCE.createIteration();
				iteration.setDescription(ModelFactory.eINSTANCE
						.createDescription());
				source = iteration;
				break;
			}
			case SWITCH: {
				SwitchSequence switchSequence = ModelFactory.eINSTANCE
						.createSwitchSequence();
				switchSequence.setDescription(ModelFactory.eINSTANCE
						.createDescription());
				SequenceGroup caseGroup = ModelFactory.eINSTANCE
						.createSequenceGroup();
				switchSequence.getCases().add(caseGroup);
				source = switchSequence;
				break;
			}
			case IF: {
				ControlSequence controlSequence = ModelFactory.eINSTANCE
						.createControlSequence();

				SequenceGroup ifGroup = ModelFactory.eINSTANCE
						.createSequenceGroup();

				controlSequence.setIfGroup(ifGroup);
				source = controlSequence;
				break;
			}
			case TRY: {
				TrySequence trySequence = ModelFactory.eINSTANCE
						.createTrySequence();

				SequenceGroup tryGroup = ModelFactory.eINSTANCE
						.createSequenceGroup();

				trySequence.setTryGroup(tryGroup);
				trySequence.getCatchGroups().add(
						ModelFactory.eINSTANCE.createSequenceGroup());
				source = trySequence;
				break;
			}

			default:
				throw new AssertionError("not a Sequence type :" + nodeType);
			}
		}

		SequenceNode newNode = (SequenceNode.toSequenceNode(refreshNode,
				provider, source));

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
			provider.getSequences().add(source);
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
		if (newNode instanceof SequenceNode) {
			NodeDeleteProvider<Sequence> deleteProvider = ((SequenceNode) newNode)
					.getDeleteProvider();
			if (deleteProvider != null)
				deleteProvider.delete(context, source);
		}
		return Status.OK_STATUS;
	}
}
