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
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.MethodCall;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;
import org.gnstudio.apdt.model.editor.nodes.NodeType;

public class MethodCallNode extends SequenceNode implements NodeOverview {
	private final MethodCall methodCall;

	public MethodCallNode(AbstractNode<?> parent, MethodCall call,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, call, deleteProvider);
		this.methodCall = call;
	}

	@Override
	public String getName() {
		String name = methodCall.getName();
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_method_call;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.methodcall");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_METHOD_CALL;
	}

	public boolean isLeaf() {
		return (methodCall.getDescription() == null);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(0);

		if (methodCall.getDescription() != null) {
			nodes.add(new DescriptionNode(this, methodCall.getDescription(),
					DescriptionNode.createDeleteProvider(this, methodCall)));
		}

		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] { DescriptionNode.newDescripationAction(context,
				this, methodCall) };
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.DESCRIPTION };
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return methodCall.getDescription() == null;
		default:
			return false;
		}
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {

		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return methodCall.getName();
			}

			@Override
			public void setValue(String value) {
				methodCall.setName(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodCallNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_method_call_name);
		// args
		NodeDetailsDescriptor<String> argsDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return methodCall.getArguments();
			}

			@Override
			public void setValue(String value) {
				methodCall.setArguments(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodCallNode.this);

			}
		};
		argsDesc.setText(APDEditorMessages.TreeNode_method_call_args);
		argsDesc.setAdvanced(true);

		return new NodeDetailsDescriptor[] { nameDesc, argsDesc };
	}

	public void addOverview(StyledString styledString) {

		if (methodCall.getName() != null && methodCall.getName().length() > 0) {
			styledString.append("( ", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
			if (methodCall.getArguments() != null
					&& methodCall.getArguments().length() > 0)
				styledString.append(methodCall.getArguments(),
						StyledString.DECORATIONS_STYLER);
			styledString.append(" )", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
		}

	}

}
