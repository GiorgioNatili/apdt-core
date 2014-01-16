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
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.ClassMember;
import org.gnstudio.apdt.model.DeclarationType;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.AccessTypeDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.DeclarationDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceDescriptor;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;

public class ClassMemberNode extends AbstractNode<ClassMember> implements
		NodeOverview, NodeCategory, NodeMoveProvider.Neighbor ,NodeMoveProvider.Movable{

	public ClassMemberNode(AbstractNode<?> parent, ClassMember member,
			NodeDeleteProvider<ClassMember> deleteProvider) {
		super(parent, member, deleteProvider);
	}

	@Override
	public String getName() {
		String note = source.getNote();
		if (note != null && note.length() > 0)
				return note;
		
		String def = source.getName();
		if ((def == null || def.length() == 0)) {
			return APDEditorMessages.TreeNode_class_member;
		}
		
		return "";
		
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.classmember");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = APDEditorImages.DESC_MODEL_CLASS_MEMBER;

		switch (source.getAccess()) {
		case INTERNAL:
			descriptor = APDEditorImages.DESC_MODEL_CLASS_MEMBER_INNER;
			break;
		case PRIVATE:
			descriptor = APDEditorImages.DESC_MODEL_CLASS_MEMBER_PRIVATE;
			break;
		case PROTECTED:
			descriptor = APDEditorImages.DESC_MODEL_CLASS_MEMBER_PROTECTED;
			break;

		}

		switch (source.getDeclaration()) {
		case FINAL:
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_FINAL_OV,
					IDecoration.BOTTOM_RIGHT);
			break;
		case CONSTANT:
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_FINAL_OV,
					IDecoration.BOTTOM_RIGHT);
			descriptor = APDEditorImages
					.createOverlay(descriptor,
							APDEditorImages.DESC_MODEL_STATIC_OV,
							IDecoration.TOP_RIGHT);
			break;
		case STATIC:
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_STATIC_OV,
					IDecoration.BOTTOM_RIGHT);
			break;
		}

		if (source.getAnnotation() != null
				&& source.getAnnotation().length() > 0) {
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_ANNOTATION_OV,
					IDecoration.TOP_LEFT | IDecoration.UNDERLAY);
		}
		return descriptor;
	}

	public boolean isLeaf() {
		return (source.getDescription() == null);
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
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {

		final ClassMember signature = source;

		NodeDetailsDescriptor<String> noteDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return signature.getNote();
			}

			@Override
			public void setValue(String value) {
				signature.setNote(value);
				context.modelUpdated();
				// refresh member node as well
				context.refreah(ClassMemberNode.this);

			}
		};
		noteDesc.setText(APDEditorMessages.TreeNode_note);
		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return signature.getName();
			}

			@Override
			public void setValue(String value) {
				signature.setName(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(ClassMemberNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_class_member_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_class_member_name_dec);

		// type
		ReferenceDescriptor typeDesc = new ReferenceDescriptor() {

			@Override
			public String getValue() {
				return signature.getType() != null ? signature.getType()
						.getName() : null;
			}

			@Override
			public void setValue(String value) {
				if (value == null || value.length() == 0) {
					signature.setType(null);
				} else {
					TypeReference reference = ModelFactory.eINSTANCE
							.createTypeReference();
					reference.setName(value);
					signature.setType(reference);
				}
				context.modelUpdated();
				// refresh method node as well
				context.refreah(ClassMemberNode.this);

			}

			@Override
			public ModelContext getContext() {
				// TODO Auto-generated method stub
				return context;
			}
		};
		typeDesc.setText(APDEditorMessages.TreeNode_class_member_type);
		typeDesc.setTooltip(APDEditorMessages.TreeNode_class_member_type_dec);
		typeDesc.setAdvanced(true);

		// annotation
		NodeDetailsDescriptor<String> annotationDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return source.getAnnotation();
			}

			@Override
			public void setValue(String value) {
				source.setAnnotation(value);
				context.modelUpdated();
				context.refreah(ClassMemberNode.this);

			}
		};
		annotationDesc.setText(APDEditorMessages.TreeNode_annotation);
		annotationDesc.setAdvanced(true);

		// access
		AccessTypeDescriptor accessDesc = new AccessTypeDescriptor() {

			@Override
			public AccessType getValue() {
				return signature.getAccess() != null ? signature.getAccess()
						: AccessType.PUBLIC;
			}

			@Override
			public void setValue(AccessType value) {
				signature.setAccess(value == null ? AccessType.PUBLIC : value);
				context.modelUpdated();
				context.refreah(ClassMemberNode.this);

			}

			public AccessType[] getOptions() {
				return AccessType.values();
			}
		};
		accessDesc.setText(APDEditorMessages.TreeNode_access);
		accessDesc.setAdvanced(true);

		// declaration
		DeclarationDescriptor declarationDesc = new DeclarationDescriptor() {

			@Override
			public DeclarationType getValue() {
				return signature.getDeclaration() != null ? signature
						.getDeclaration() : DeclarationType.DEFAULT;
			}

			@Override
			public void setValue(DeclarationType value) {
				signature
						.setDeclaration(value == null ? DeclarationType.DEFAULT
								: value);
				context.modelUpdated();
				context.refreah(ClassMemberNode.this);

			}

			public DeclarationType[] getOptions() {
				return new DeclarationType[] { DeclarationType.DEFAULT,
						DeclarationType.CONSTANT, DeclarationType.FINAL,
						DeclarationType.STATIC };
			}
		};
		declarationDesc
				.setText(APDEditorMessages.TreeNode_class_member_declaration);
		declarationDesc.setAdvanced(true);

		return new NodeDetailsDescriptor[] { noteDesc, nameDesc,
				annotationDesc, accessDesc, typeDesc, declarationDesc };
	}

	public void addOverview(StyledString styledString) {
		boolean hasName = (source.getName() != null && source.getName()
				.length() > 0);
		boolean hasType = (source.getType() != null
				&& source.getType().getName() != null && source.getType()
				.getName().length() > 0);
		if (hasName || hasType) {
			if(source.getNote()!=null && source.getNote().length()> 0)
				styledString.append(" : ", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$

			if (hasName)
				styledString.append(source.getName(),
						StyledString.DECORATIONS_STYLER);
			if (hasType) {
				styledString.append(" ");
				styledString.append(source.getType().getName(),
						StyledString.COUNTER_STYLER);
				
			}
		}

	}

	public int getCategory() {
		return CATEGORY_CLASS_MEMBER;
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
	
	public Object getNeighborSource() {
		return getSource();
	}

	public boolean canMove() {
		return true;
	}
}
