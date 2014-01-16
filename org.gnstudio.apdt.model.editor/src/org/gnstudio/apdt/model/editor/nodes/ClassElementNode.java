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

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.ClassMember;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.AccessTypeDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider.FILTER;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class ClassElementNode extends AbstractNode<ClassElement> implements
		NodeMoveProvider, NodeMoveProvider.Movable {

	public ClassElementNode(AbstractNode<?> parent, ClassElement classElement,
			NodeDeleteProvider<ClassElement> deleteProvider) {
		super(parent, classElement, deleteProvider);
	}

	@Override
	public String getName() {
		String name = source.getName();
		if (name == null || name.length() == 0) {
			return APDEditorMessages.TreeNode_empty;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.class");
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = APDEditorImages.DESC_MODEL_CLASS;
		if (source.getAccess() == AccessType.INTERNAL) {
			descriptor = APDEditorImages.DESC_MODEL_CLASS_INNER;
		}

		if (source.getAnnotation() != null
				&& source.getAnnotation().length() > 0) {
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_ANNOTATION_OV,
					IDecoration.TOP_LEFT);
		}
		
		if(DescriptionNode.todoDescription(source.getDescription())){
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_PINNED_OV,
					IDecoration.TOP_RIGHT);
		}
		return descriptor;
	}

	@Override
	public boolean isLeaf() {
		return !(source.getDescription() != null || source.getLink()!=null
				|| source.getMethods().size() > 0
				|| source.getMembers().size() > 0
				|| source.getDiscussions().size() > 0
				|| source.getExtendsElements().size() > 0 || source
				.getImplementsElements().size() > 0);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(3);

		if (source.getDescription() != null) {
			nodes.add(new DescriptionNode(this, source.getDescription(),
					DescriptionNode.createDeleteProvider(this, source)));
		}
		if (source.getDiscussions().size() > 0)
			nodes.add(new DiscussionsNode(this));


		if (source.getLink() != null) {
			nodes.add(new SourceLinkNode(this, source.getLink(),
					SourceLinkNode.createDeleteProvider(this, source)));
		}
		
		// /add <extends> folder
		if (source.getExtendsElements().size() > 0) {
			nodes.add(new ExtendsNode(this));
		}
		// /add <Implements> folder
		if (source.getImplementsElements().size() > 0) {
			nodes.add(new ImplementsNode(this));
		}

		// add member nodes
		for (ClassMember member : source.getMembers()) {
			nodes.add(new ClassMemberNode(this, member,
					new ClassMemberDeleteProvider()));
		}

		// add method nodes
		for (Method method : source.getMethods()) {
			// use implement MethodNode version
			nodes.add(new MethodNode(this, method, new MethodDeleteProvider(),
					true));
		}
		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] {
				DescriptionNode.newDescripationAction(context, this, source),
				null, getNewMemberAction(this, context),
				getNewMethodAction(this, context),
				getNewExtendsAction(this, context),
				getNewImplementsAction(this, context), null,
				DiscussionsNode.getNewDiscussionAction(this, context) ,SourceLinkNode.newSourceLinkAction(context, this, source)};
	}

	private static Action getNewMethodAction(final ClassElementNode node,
			final ModelContext context) {
		Action methodAction = new Action() {
			public void run() {

				NodeActions.createNewNode(context, node, NodeType.METHOD);
			}
		};
		methodAction.setText(APDEditorMessages.TreeNodeAction_new_method);

		return methodAction;
	}

	private static Action getNewMemberAction(final ClassElementNode node,
			final ModelContext context) {
		Action memberAction = new Action() {
			public void run() {

				NodeActions.createNewNode(context, node, NodeType.CLASS_MEMBER);
			}
		};
		memberAction.setText(APDEditorMessages.TreeNodeAction_new_class_member);

		return memberAction;
	}

	private static Action getNewExtendsAction(final ClassElementNode node,
			final ModelContext context) {
		Action extendsAction = new Action() {
			public void run() {

				NodeActions.createNewNode(context, node, NodeType.EXTENDS);
			}
		};
		extendsAction
				.setText(APDEditorMessages.TreeNodeAction_new_extends_class);

		return extendsAction;
	}

	private static Action getNewImplementsAction(final ClassElementNode node,
			final ModelContext context) {
		Action extendsAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, node, NodeType.IMPLEMENTS);

			}
		};
		extendsAction
				.setText(APDEditorMessages.TreeNodeAction_new_implements_interface);

		return extendsAction;
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return source.getName();
			}

			@Override
			public void setValue(String value) {
				source.setName(value);
				context.modelUpdated();
				context.refreah(ClassElementNode.this);
				context.refreah(ClassElementNode.this.getParent());

			}
		};
		nameDesc.setRequired(true);
		nameDesc.setText(APDEditorMessages.TreeNode_class_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_class_name_dec);

		// access
		AccessTypeDescriptor accessDesc = new AccessTypeDescriptor() {

			@Override
			public AccessType getValue() {
				return source.getAccess() != null ? source.getAccess()
						: AccessType.PUBLIC;
			}

			@Override
			public void setValue(AccessType value) {
				source.setAccess(value == null ? AccessType.PUBLIC : value);
				context.modelUpdated();
				context.refreah(ClassElementNode.this);

			}

			public AccessType[] getOptions() {
				return new AccessType[] { AccessType.PUBLIC,
						AccessType.INTERNAL };
			}
		};
		accessDesc.setText(APDEditorMessages.TreeNode_access);
		accessDesc.setAdvanced(true);
		// final
		NodeDetailsDescriptor<Boolean> finalDesc = new NodeDetailsDescriptor<Boolean>(
				NodeDetailsDescriptor.TYPE.BOOLEAN) {

			@Override
			public Boolean getValue() {
				return source.isFinal();
			}

			@Override
			public void setValue(Boolean value) {
				source.setFinal(value.booleanValue());
				context.modelUpdated();
				context.refreah(ClassElementNode.this);

			}

		};
		finalDesc.setText(APDEditorMessages.TreeNode_final);
		finalDesc.setAdvanced(true);
		// final
		NodeDetailsDescriptor<Boolean> dynamicDesc = new NodeDetailsDescriptor<Boolean>(
				NodeDetailsDescriptor.TYPE.BOOLEAN) {

			@Override
			public Boolean getValue() {
				return source.isDynamic();
			}

			@Override
			public void setValue(Boolean value) {
				source.setDynamic(value.booleanValue());
				context.modelUpdated();
				context.refreah(ClassElementNode.this);

			}

		};
		dynamicDesc.setText(APDEditorMessages.TreeNode_dynamic);
		dynamicDesc.setAdvanced(true);
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
				context.refreah(ClassElementNode.this);

			}
		};
		annotationDesc.setText(APDEditorMessages.TreeNode_annotation);
		annotationDesc.setAdvanced(true);

		return new NodeDetailsDescriptor[] { nameDesc, accessDesc, finalDesc,
				dynamicDesc, annotationDesc };
	}

	// ExtendsNode: category note group extends class together
	// ----------------------------------------------------------
	private static class ExtendsNode extends AbstractNode<ClassElementNode>
			implements NodeCategory, NodeOverview {
		private final ClassElement classElement;

		public ExtendsNode(ClassElementNode parent) {
			super(parent, parent);
			classElement = parent.source;
		}

		public String getName() {

			return APDEditorMessages.TreeNode_Extends;
		}

		@Override
		public String getNote() {
			return APDNodeHelpMessages.getNLS("editor.help.extends");
		}
		
		@Override
		public boolean isLeaf() {
			return false;
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return APDEditorImages.DESC_MODEL_SUPER_TYPES;
		}

		@Override
		public AbstractNode<?>[] getChildren() {
			List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

			for (TypeReference element : classElement.getExtendsElements()) {
				nodes.add(new TypeReferenceNode(this, element,
						new ExtendsDeleteProvider(source), FILTER.CLASS));
			}
			return nodes.toArray(new AbstractNode<?>[0]);
		}

		@Override
		public Action[] getActions(final ModelContext context) {
			return new Action[] { getNewExtendsAction(source, context) };
		}

		public int getCategory() {
			return CATEGORY_EXTENDS;
		}

		public void addOverview(StyledString styledString) {
			if (classElement.getExtendsElements().size() > 0) {
				String mask = " : ";//$NON-NLS-1$
				for (TypeReference reference : classElement
						.getExtendsElements()) {
					if (reference.getName() != null) {
						styledString.append(mask,
								StyledString.DECORATIONS_STYLER);
						styledString.append(getBaseName(reference.getName()),
								StyledString.DECORATIONS_STYLER);
						mask = ", ";//$NON-NLS-1$
					}
				}
			}

		}

		private String getBaseName(String fullname) {
			if (fullname != null && fullname.contains(".")) {
				int lastIndx = fullname.lastIndexOf(".") + 1;
				int fullLength = fullname.length();
				return fullname.substring(lastIndx, fullLength);
			}
			return fullname;
		}
	}

	// ImplementsNode: category note group extends interface together
	// ----------------------------------------------------------
	private static class ImplementsNode extends AbstractNode<ClassElementNode>
			implements NodeCategory, NodeOverview {
		private final ClassElement classElement;

		public ImplementsNode(ClassElementNode parent) {
			super(parent, parent);
			classElement = parent.source;
		}

		public String getName() {

			return APDEditorMessages.TreeNode_Implements;
		}


		@Override
		public String getNote() {
			return APDNodeHelpMessages.getNLS("editor.help.implements");
		}
		
		@Override
		public boolean isLeaf() {
			return false;
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return APDEditorImages.DESC_MODEL_EXTENDS_INTERFACE;
		}

		@Override
		public AbstractNode<?>[] getChildren() {
			List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

			for (TypeReference element : classElement.getImplementsElements()) {
				nodes.add(new TypeReferenceNode(this, element,
						new ImplementsDeleteProvider(source), FILTER.INTERFACE));
			}
			return nodes.toArray(new AbstractNode<?>[0]);
		}

		@Override
		public Action[] getActions(final ModelContext context) {
			return new Action[] { getNewImplementsAction(source, context) };
		}

		public int getCategory() {
			return CATEGORY_IMPLEMENTS;
		}

		public void addOverview(StyledString styledString) {
			if (classElement.getImplementsElements().size() > 0) {
				String mask = " : ";//$NON-NLS-1$
				for (TypeReference reference : classElement
						.getImplementsElements()) {
					if (reference.getName() != null) {
						styledString.append(mask,
								StyledString.DECORATIONS_STYLER);
						styledString.append(getBaseName(reference.getName()),
								StyledString.DECORATIONS_STYLER);
						mask = ", ";//$NON-NLS-1$
					}
				}
			}

		}

		private String getBaseName(String fullname) {
			if (fullname != null && fullname.contains(".")) {
				int lastIndx = fullname.lastIndexOf(".") + 1;
				int fullLength = fullname.length();
				return fullname.substring(lastIndx, fullLength);
			}
			return fullname;
		}
	}

	private class MethodDeleteProvider implements NodeDeleteProvider<Method> {

		public void delete(final ModelContext context, Method method) {
			source.getMethods().remove(method);
			context.modelUpdated();
			context.refreah(ClassElementNode.this);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				Method t) {
			return AbstractDeleteOperation.create(context,
					ClassElementNode.this, source.getMethods(), t);
		}

	}

	private class ClassMemberDeleteProvider implements
			NodeDeleteProvider<ClassMember> {

		public void delete(final ModelContext context, ClassMember member) {
			source.getMembers().remove(member);
			context.modelUpdated();
			context.refreah(ClassElementNode.this);
		}

		public AbstractOperation createDeleteOperation(
				final ModelContext context, final ClassMember member) {

			return AbstractDeleteOperation.create(context,
					ClassElementNode.this, source.getMembers(), member);
		}

	}

	private static class ExtendsDeleteProvider implements
			NodeDeleteProvider<TypeReference> {
		private final AbstractNode<ClassElement> node;

		public ExtendsDeleteProvider(AbstractNode<ClassElement> node) {
			this.node = node;
		}

		public void delete(final ModelContext context, TypeReference ref) {
			node.source.getExtendsElements().remove(ref);
			context.modelUpdated();
			context.refreah(node);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				TypeReference t) {
			return AbstractDeleteOperation.create(context, node,
					node.source.getExtendsElements(), t);
		}

	}

	private static class ImplementsDeleteProvider implements
			NodeDeleteProvider<TypeReference> {
		private final AbstractNode<ClassElement> node;

		public ImplementsDeleteProvider(AbstractNode<ClassElement> node) {
			this.node = node;
		}

		public void delete(final ModelContext context, TypeReference ref) {
			node.source.getImplementsElements().remove(ref);
			context.modelUpdated();
			context.refreah(node);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				TypeReference t) {
			return AbstractDeleteOperation.create(context, node,
					node.source.getImplementsElements(), t);
		}

	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.METHOD, NodeType.CLASS_MEMBER,
				NodeType.DESCRIPTION, NodeType.DISCUSSION, NodeType.IMPLEMENTS,
				NodeType.EXTENDS ,NodeType.SOURCE_LINK};
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case METHOD:
		case CLASS_MEMBER:
		case DISCUSSION:
		case IMPLEMENTS:
		case EXTENDS:
			return true;
		case DESCRIPTION:
			return source.getDescription() == null;
		case SOURCE_LINK:
			return source.getLink() == null;
		default:
			return false;
		}
	}

	@Override
	public AbstractNode<?> toNode(NodeType type, Object source) {
		switch (type) {
		case DISCUSSION:
			return DiscussionsNode.toDiscussionNode(this, (Description) source);
		case IMPLEMENTS:
			return new TypeReferenceNode(new ImplementsNode(this),
					(TypeReference) source, new ImplementsDeleteProvider(this));
		case EXTENDS:
			return new TypeReferenceNode(new ExtendsNode(this),
					(TypeReference) source, new ExtendsDeleteProvider(this));
		}
		return super.toNode(type, source);
	}

	public boolean canMove(Neighbor relation, NodeType type) {
		return (relation.getNeighborSource() instanceof Method && NodeType.METHOD == (type))
				|| (relation.getNeighborSource() instanceof ClassMember && NodeType.CLASS_MEMBER == (type));
	}

	public boolean canMove(Neighbor relation, Object source) {
		boolean canMove = (source instanceof Method || source instanceof ClassMember);
		if (relation != null) {
			Object neighborSource = relation.getNeighborSource();
			EList<Method> methods = getSource().getMethods();
			EList<ClassMember> members = getSource().getMembers();
			return canMove
					&& ((methods.contains(neighborSource)) || (members
							.contains(neighborSource)));
		}
		return canMove;
	}

	public void move(ModelContext context, Neighbor neighbor, Object source,
			boolean before) {
		if ((neighbor == null || neighbor.getNeighborSource() instanceof Method)
				&& source instanceof Method) {
			EList<Method> methods = getSource().getMethods();
			if (neighbor != null) {
				Method methodNeighbor = (Method) neighbor.getNeighborSource();
				if (methods.contains(methodNeighbor)) {
					int index = methods.indexOf(methodNeighbor);
					if (!before)
						index++;

					methods.add(index, (Method) source);
				}
			} else
				methods.add((Method) source);
		} else if ((neighbor == null || neighbor.getNeighborSource() instanceof ClassMember)
				&& source instanceof ClassMember) {
			EList<ClassMember> members = getSource().getMembers();
			if (neighbor != null) {
				ClassMember memberNeighbor = (ClassMember) neighbor
						.getNeighborSource();
				if (members.contains(memberNeighbor)) {
					int index = members.indexOf(memberNeighbor);
					if (!before)
						index++;

					members.add(index, (ClassMember) source);
				}
			} else
				members.add((ClassMember) source);

		}

	}

	public boolean canMove() {
		return true;
	}
}
