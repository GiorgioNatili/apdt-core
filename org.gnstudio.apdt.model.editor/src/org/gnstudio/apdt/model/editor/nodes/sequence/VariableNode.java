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
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.DeclarationType;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.Variable;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.DeclarationDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;
import org.gnstudio.apdt.model.editor.nodes.NodeType;

public class VariableNode extends SequenceNode implements NodeOverview {
	private final Variable variable;

	public VariableNode(AbstractNode<?> parent, Variable variable,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, variable, deleteProvider);
		this.variable = variable;
	}

	@Override
	public String getName() {
		String name = variable.getNote();
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_variable;
		}
		return name;
	}


	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.variable");
	}
	
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = APDEditorImages.DESC_MODEL_LOCAL_VAR;
		if (variable.getDeclaration() == DeclarationType.FINAL) {
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_FINAL_OV, IDecoration.TOP_RIGHT);
		}
		return descriptor;
	}

	public boolean isLeaf() {
		return (variable.getDescription() == null);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(0);

		if (variable.getDescription() != null) {
			nodes.add(new DescriptionNode(this, variable.getDescription(),
					DescriptionNode.createDeleteProvider(this, variable)));
		}

		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] { DescriptionNode.newDescripationAction(context,
				this, variable) };
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.DESCRIPTION };
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return variable.getDescription() == null;
		default:
			return false;
		}
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {

		NodeDetailsDescriptor<String> noteDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return variable.getNote();
			}

			@Override
			public void setValue(String value) {
				variable.setNote(value);
				context.modelUpdated();
				// refresh member node as well
				context.refreah(VariableNode.this);

			}
		};
		noteDesc.setText(APDEditorMessages.TreeNode_note);
		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return variable.getName();
			}

			@Override
			public void setValue(String value) {
				variable.setName(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(VariableNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_variable_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_variable_name_dec);

		// Declaration
		DeclarationDescriptor declarationDesc = new DeclarationDescriptor() {

			@Override
			public DeclarationType getValue() {
				return variable.getDeclaration() != null ? variable
						.getDeclaration() : DeclarationType.DEFAULT;
			}

			@Override
			public void setValue(DeclarationType value) {
				variable.setDeclaration(value == null ? DeclarationType.DEFAULT
						: value);
				context.modelUpdated();
				context.refreah(VariableNode.this);

			}

			public DeclarationType[] getOptions() {
				return new DeclarationType[] { DeclarationType.DEFAULT,
						DeclarationType.FINAL };
			}
		};
		declarationDesc
				.setText(APDEditorMessages.TreeNode_variable_declaration);
		declarationDesc.setAdvanced(true);

		// type
		ReferenceDescriptor typeDesc = new ReferenceDescriptor() {

			@Override
			public String getValue() {
				return variable.getType() != null ? variable.getType()
						.getName() : null;
			}

			@Override
			public void setValue(String value) {
				if (value == null || value.length() == 0) {
					variable.setType(null);
				} else {
					TypeReference reference = ModelFactory.eINSTANCE
							.createTypeReference();
					reference.setName(value);
					variable.setType(reference);
				}
				context.modelUpdated();
				// refresh method node as well
				context.refreah(VariableNode.this);

			}

			@Override
			public ModelContext getContext() {
				return context;
			}
		};
		typeDesc.setText(APDEditorMessages.TreeNode_variable_type);
		typeDesc.setTooltip(APDEditorMessages.TreeNode_variable_type_dec);
		typeDesc.setAdvanced(true);

		// value
		NodeDetailsDescriptor<String> valueDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return variable.getValue();
			}

			@Override
			public void setValue(String value) {
				variable.setValue(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(VariableNode.this);

			}
		};
		valueDesc.setText(APDEditorMessages.TreeNode_variable_value);
		valueDesc.setAdvanced(true);
		return new NodeDetailsDescriptor[] { noteDesc, nameDesc,
				declarationDesc, typeDesc, valueDesc };
	}

	public void addOverview(StyledString styledString) {
		boolean hasName = (variable.getName() != null && variable.getName()
				.length() > 0);
		boolean hasType = (variable.getType() != null
				&& variable.getType().getName() != null && variable.getType()
				.getName().length() > 0);
		boolean hasValue = (variable.getValue() != null && variable.getValue()
				.length() > 0);
		if (hasName || hasType || hasValue) {
			styledString.append(" : ", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$

			if (hasName)
				styledString.append(variable.getName(),
						StyledString.DECORATIONS_STYLER);
			if (hasType) {
				styledString.append(" ");
				styledString.append(variable.getType().getName(),
						StyledString.COUNTER_STYLER);
			}
			if (hasValue) {
				styledString.append(" = ", StyledString.QUALIFIER_STYLER);//$NON-NLS-1$
				styledString.append(variable.getValue(),
						StyledString.DECORATIONS_STYLER);
			}
		}

	}

}
