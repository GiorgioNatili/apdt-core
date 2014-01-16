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
package org.gnstudio.apdt.model.editor.nodes;

import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.operations.ArgumentAddOperation;
import org.gnstudio.apdt.model.editor.operations.ClassAddOperation;
import org.gnstudio.apdt.model.editor.operations.ClassMemberAddOperation;
import org.gnstudio.apdt.model.editor.operations.ConditionElseAddOperation;
import org.gnstudio.apdt.model.editor.operations.DescriptionAddOperation;
import org.gnstudio.apdt.model.editor.operations.DiscussionAddOperation;
import org.gnstudio.apdt.model.editor.operations.ExtendsAddOperation;
import org.gnstudio.apdt.model.editor.operations.ImplementsAddOperation;
import org.gnstudio.apdt.model.editor.operations.InterfaceAddOperation;
import org.gnstudio.apdt.model.editor.operations.MethodAddOperation;
import org.gnstudio.apdt.model.editor.operations.PackageAddOperation;
import org.gnstudio.apdt.model.editor.operations.ProgramAddOperation;
import org.gnstudio.apdt.model.editor.operations.SequenceAddOperation;
import org.gnstudio.apdt.model.editor.operations.SourceLinkAddOperation;
import org.gnstudio.apdt.model.editor.operations.SwitchCaseAddOperation;
import org.gnstudio.apdt.model.editor.operations.ThrowsAddOperation;
import org.gnstudio.apdt.model.editor.operations.TryCatchAddOperation;

public final class NodeActions {
	private NodeActions() {
		// ignore
		throw new AssertionError();
	}

	public static void createNewNode(ModelContext context,
			AbstractNode<?> parent, NodeType nodeType) {
		createNewNode(context, parent, nodeType, null, null, false);
	}

	public static void createNewNode(ModelContext context,
			AbstractNode<?> parent, NodeType nodeType,
			NodeMoveProvider moveProvider, NodeMoveProvider.Neighbor neighbor,
			boolean before) {
		final Object parentSource = parent != null ? parent.getSource() : null;

		switch (nodeType) {
		case PROGRAM: {
			context.getOperationSupport().execute(
					new ProgramAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case PACKAGE: {
			context.getOperationSupport().execute(
					new PackageAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case INTERFACE: {
			context.getOperationSupport().execute(
					new InterfaceAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case CLASS: {
			context.getOperationSupport().execute(
					new ClassAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case IMPLEMENTS: {
			context.getOperationSupport().execute(
					new ImplementsAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case EXTENDS: {
			context.getOperationSupport().execute(
					new ExtendsAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case METHOD: {
			context.getOperationSupport().execute(
					new MethodAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case CLASS_MEMBER: {
			context.getOperationSupport().execute(
					new ClassMemberAddOperation(context, parentSource,
							nodeType, moveProvider, neighbor, before), null);
			return;
		}
		case ARGUMRNT: {
			context.getOperationSupport().execute(
					new ArgumentAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case THROWS: {
			context.getOperationSupport().execute(
					new ThrowsAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case DESCRIPTION: {
			context.getOperationSupport().execute(
					new DescriptionAddOperation(context, parentSource,
							nodeType, moveProvider, neighbor, before), null);
			return;
		}
		case SOURCE_LINK: {
			context.getOperationSupport().execute(
					new SourceLinkAddOperation(context, parentSource,
							nodeType, moveProvider, neighbor, before), null);
			return;
		}
		case DISCUSSION: {
			context.getOperationSupport().execute(
					new DiscussionAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case VARIABLE:
		case GROUP:
		case ITERATION:
		case METHOD_CALL:
		case METHOD_RETURN:
		case SWITCH:
		case IF:
		case TRY:
		case RECURSION:
		case PRINT:
		case SHOW:
		case PROMPT:
		case READ:
		case WRITE:
		case RECOVER:
		case STORE:
		case CALC_STORE:
		case COMMENT: {
			context.getOperationSupport().execute(
					new SequenceAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case CASE:
		case DEFAULT_CASE: {
			context.getOperationSupport().execute(
					new SwitchCaseAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}
		case ELSE_IF:
		case ELSE: {
			context.getOperationSupport().execute(
					new ConditionElseAddOperation(context, parentSource,
							nodeType, moveProvider, neighbor, before), null);
			return;
		}
		case CATCH:
		case FINALLY: {
			context.getOperationSupport().execute(
					new TryCatchAddOperation(context, parentSource, nodeType,
							moveProvider, neighbor, before), null);
			return;
		}

		}

	}
}
