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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.MethodArgument;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceDescriptor;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Movable;

public class MethodArgNode extends AbstractNode<MethodArgument> implements
		NodeOverview ,Movable{

	public MethodArgNode(AbstractNode<?> parent, MethodArgument source,
			NodeDeleteProvider<MethodArgument> deleteProvider) {
		super(parent, source, deleteProvider);
	}

	@Override
	public String getName() {
		String name = source.getName();
		if (name == null || name.length() == 0) {
			return APDEditorMessages.TreeNode_method_arg;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.arguments");
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_ARGUMENT;
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(0);

		if (source.getDescription() != null) {
			nodes.add(new DescriptionNode(this, source.getDescription(),
					DescriptionNode.createDeleteProvider(this, source)));
		}

		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] { DescriptionNode.newDescripationAction(context,
				this, source) };
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.DESCRIPTION };
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return source.getDescription() == null;
		default:
			return false;
		}
	}

	public void addOverview(StyledString styledString) {

		boolean hasType = (source.getType() != null
				&& source.getType().getName() != null && source.getType()
				.getName().length() > 0);
		if (hasType) {
			if (hasType) {
				styledString.append(" [", StyledString.QUALIFIER_STYLER);//$NON-NLS-1$
				styledString.append(source.getType().getName(),
						StyledString.QUALIFIER_STYLER);
				styledString.append("]", StyledString.QUALIFIER_STYLER);//$NON-NLS-1$

			}
		}
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {

		final MethodArgument argument = source;

		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return argument.getName();
			}

			@Override
			public void setValue(String value) {
				argument.setName(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodArgNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_method_arg_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_method_arg_name_dec);

		// type
		ReferenceDescriptor typeDesc = new ReferenceDescriptor() {

			@Override
			public String getValue() {
				return argument.getType() != null ? argument.getType()
						.getName() : null;
			}

			@Override
			public void setValue(String value) {
				if (value == null || value.length() == 0) {
					argument.setType(null);
				} else {
					TypeReference reference = ModelFactory.eINSTANCE
							.createTypeReference();
					reference.setName(value);
					argument.setType(reference);
				}
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodArgNode.this);

			}

			@Override
			public ModelContext getContext() {
				return context;
			}
		};
		typeDesc.setText(APDEditorMessages.TreeNode_method_arg_type);
		typeDesc.setTooltip(APDEditorMessages.TreeNode_method_arg_type_dec);
		typeDesc.setAdvanced(true);

		return new NodeDetailsDescriptor[] { nameDesc, typeDesc };
	}

	public boolean canMove() {
		return false;
	}

}
