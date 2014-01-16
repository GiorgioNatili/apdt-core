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

import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.jface.action.Action;
import org.gnstudio.apdt.model.CalculateStore;
import org.gnstudio.apdt.model.Comment;
import org.gnstudio.apdt.model.ControlSequence;
import org.gnstudio.apdt.model.Iteration;
import org.gnstudio.apdt.model.MethodCall;
import org.gnstudio.apdt.model.MethodReturn;
import org.gnstudio.apdt.model.Print;
import org.gnstudio.apdt.model.Prompt;
import org.gnstudio.apdt.model.Read;
import org.gnstudio.apdt.model.Recover;
import org.gnstudio.apdt.model.Recursion;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.SequenceProvider;
import org.gnstudio.apdt.model.Show;
import org.gnstudio.apdt.model.Store;
import org.gnstudio.apdt.model.SwitchSequence;
import org.gnstudio.apdt.model.TrySequence;
import org.gnstudio.apdt.model.Variable;
import org.gnstudio.apdt.model.Write;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeActions;
import org.gnstudio.apdt.model.editor.nodes.NodeCategory;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class SequenceNode extends AbstractNode<Sequence> implements
		NodeCategory, NodeMoveProvider.Neighbor, NodeMoveProvider.Movable {

	public SequenceNode(AbstractNode<?> parent, Sequence sequence,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, sequence, deleteProvider);
	}

	public int getCategory() {
		return CATEGORY_SEQUENCE;
	}

	public static NodeDeleteProvider<Sequence> createDeleteProvider(
			final AbstractNode<?> node, final SequenceProvider provider) {
		return new NodeDeleteProvider<Sequence>() {

			public void delete(ModelContext context, Sequence sequence) {
				provider.getSequences().remove(sequence);
				context.modelUpdated();
				context.refreah(node);
			}

			public AbstractOperation createDeleteOperation(
					ModelContext context, Sequence t) {
				return AbstractDeleteOperation.create(context, node,
						provider.getSequences(), t);
			}
		};
	}

	public static SequenceNode toSequenceNode(final AbstractNode<?> parent,
			SequenceProvider provider, Sequence sequence) {
		NodeDeleteProvider<Sequence> deleteProvider = createDeleteProvider(
				parent, provider);
		if (sequence instanceof Variable) {
			return new VariableNode(parent, (Variable) sequence, deleteProvider);
		}

		if (sequence instanceof MethodCall) {
			return new MethodCallNode(parent, (MethodCall) sequence,
					deleteProvider);
		}

		if (sequence instanceof MethodReturn) {
			return new MethodReturnNode(parent, (MethodReturn) sequence,
					deleteProvider);
		}

		if (sequence instanceof Comment) {
			return new CommentNode(parent, (Comment) sequence, deleteProvider);
		}

		if (sequence instanceof Recursion) {
			return new RecursionNode(parent, (Recursion) sequence,
					deleteProvider);
		}
		if (sequence instanceof Print) {
			return new PrintNode(parent, (Print) sequence, deleteProvider);
		}
		if (sequence instanceof Show) {
			return new ShowNode(parent, (Show) sequence, deleteProvider);
		}
		if (sequence instanceof Prompt) {
			return new PromptNode(parent, (Prompt) sequence, deleteProvider);
		}

		if (sequence instanceof Write) {
			return new WriteNode(parent, (Write) sequence, deleteProvider);
		}

		if (sequence instanceof Read) {
			return new ReadNode(parent, (Read) sequence, deleteProvider);
		}

		if (sequence instanceof Recover) {
			return new RecoverNode(parent, (Recover) sequence, deleteProvider);
		}

		if (sequence instanceof Store) {
			return new StoreNode(parent, (Store) sequence, deleteProvider);
		}

		if (sequence instanceof CalculateStore) {
			return new CalcStoreNode(parent, (CalculateStore) sequence,
					deleteProvider);
		}

		if (sequence instanceof Iteration) {
			return new IterationNode(parent, (Iteration) sequence,
					deleteProvider);
		}
		if (sequence instanceof SwitchSequence) {
			return new SwitchNode(parent, (SwitchSequence) sequence,
					deleteProvider);
		}
		if (sequence instanceof ControlSequence) {
			return new IfGroupNode(parent, (ControlSequence) sequence,
					deleteProvider);
		}
		if (sequence instanceof TrySequence) {
			return new TryGroupNode(parent, (TrySequence) sequence,
					deleteProvider);
		}
		if (sequence instanceof SequenceGroup) {
			return new GroupNode(parent, (SequenceGroup) sequence,
					deleteProvider);
		}
		// default
		return new SequenceNode(parent, sequence, deleteProvider);
	}

	public static Action newAction(final ModelContext context,
			final AbstractNode<?> node, final NodeType type) {
		Action descAction = new Action() {

			public void run() {
				NodeActions.createNewNode(context, node, type);
			}
		};
		switch (type) {
		case VARIABLE:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_variable);
			break;
		case COMMENT:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_comment);
			break;
		case GROUP:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_group);
			break;
		case ITERATION:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_iteration);
			break;
		case METHOD_CALL:
			descAction
					.setText(APDEditorMessages.TreeNodeAction_new_method_call);
			break;
		case RECURSION:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_recursion);
			break;
		case PRINT:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_print);
			break;
		case SHOW:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_show);
			break;
		case PROMPT:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_prompt);
			break;
		case READ:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_read);
			break;
		case WRITE:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_write);
			break;
		case RECOVER:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_recover);
			break;
		case STORE:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_store);
			break;
		case CALC_STORE:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_calc_store);
			break;
		case METHOD_RETURN:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_return);
			break;
		case SWITCH:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_switch);
			break;
		case IF:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_if);
			break;
		case TRY:
			descAction.setText(APDEditorMessages.TreeNodeAction_new_try);
			break;

		}

		return descAction;
	}

	public static boolean isSequenceType(NodeType type) {
		switch (type) {
		case VARIABLE:
		case COMMENT:
		case GROUP:
		case ITERATION:
		case METHOD_CALL:
		case METHOD_RETURN:
		case SWITCH:
		case IF:
		case TRY:
		case RECURSION:
		case PRINT:
		case PROMPT:
		case SHOW:
		case READ:
		case WRITE:
		case RECOVER:
		case STORE:
		case CALC_STORE:
			return true;
		default:
			return false;
		}
	}

	public static NodeType[] getSequenceNodeTypes() {
		return new NodeType[] { NodeType.VARIABLE, NodeType.COMMENT,
				NodeType.GROUP, NodeType.ITERATION, NodeType.METHOD_CALL,
				NodeType.METHOD_RETURN, NodeType.SWITCH, NodeType.IF,
				NodeType.RECURSION, NodeType.PRINT, NodeType.SHOW,
				NodeType.PROMPT, NodeType.READ, NodeType.WRITE, NodeType.TRY,
				NodeType.RECOVER, NodeType.STORE, NodeType.CALC_STORE };
	}

	public AssociateNodeProvider getAssociateNodeProvider() {
		return null;
	}

	public static interface AssociateNodeProvider {
		List<AbstractNode<?>> getAssociateNodes();
	}

	public Object getNeighborSource() {
		return getSource();
	}

	public boolean canMove() {
		return true;
	}

}
