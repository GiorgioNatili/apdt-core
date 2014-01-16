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
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.InterfaceElement;
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

public class InterfaceElementNode extends AbstractNode<InterfaceElement>
		implements NodeMoveProvider, NodeMoveProvider.Movable {

	public InterfaceElementNode(AbstractNode<?> parent,
			InterfaceElement interfaceElement,
			NodeDeleteProvider<InterfaceElement> deleteProvider) {
		super(parent, interfaceElement, deleteProvider);
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
		return APDNodeHelpMessages.getNLS("editor.help.interface");
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor ;
		if (source.getAccess() == AccessType.INTERNAL) {
			descriptor =  APDEditorImages.DESC_MODEL_INTERFACE_INNER;
		}else
			descriptor = APDEditorImages.DESC_MODEL_INTERFACE;
		
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
				|| source.getExtendsElements().size() > 0
				|| source.getMethods().size() > 0 || source.getDiscussions()
				.size() > 0);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(2);

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
		
		// add <extends> folder
		if (source.getExtendsElements().size() > 0) {
			nodes.add(new ExtendsNode(this));
		}

		// add method nodes
		for (Method method : source.getMethods()) {
			nodes.add(new MethodNode(this, method, new MethodDeleteProvider()));
		}
		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {

		return new Action[] {
				DescriptionNode.newDescripationAction(context, this, source),
				null, getNewMethodAction(this, context),
				getNewExtendsAction(this, context), null,
				DiscussionsNode.getNewDiscussionAction(this, context) ,SourceLinkNode.newSourceLinkAction(context, this, source)};
	}

	private static Action getNewExtendsAction(final InterfaceElementNode node,
			final ModelContext context) {
		Action extendsAction = new Action() {
			public void run() {

				NodeActions.createNewNode(context, node, NodeType.EXTENDS);

			}
		};
		extendsAction
				.setText(APDEditorMessages.TreeNodeAction_new_extends_interface);

		return extendsAction;
	}

	private static Action getNewMethodAction(final InterfaceElementNode node,
			final ModelContext context) {
		Action newMethodAction = new Action() {
			public void run() {

				NodeActions.createNewNode(context, node, NodeType.METHOD);
			}
		};
		newMethodAction.setText(APDEditorMessages.TreeNodeAction_new_method);

		return newMethodAction;
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
				context.refreah(InterfaceElementNode.this);
				context.refreah(InterfaceElementNode.this.getParent());

			}
		};
		nameDesc.setRequired(true);
		nameDesc.setText(APDEditorMessages.TreeNode_interface_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_interface_name_dec);
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
				context.refreah(InterfaceElementNode.this);

			}

			public AccessType[] getOptions() {
				return new AccessType[] { AccessType.PUBLIC,
						AccessType.INTERNAL };
			}
		};
		accessDesc.setText(APDEditorMessages.TreeNode_access);

		return new NodeDetailsDescriptor[] { nameDesc, accessDesc };
	}

	// ExtendsNode: category note group extends interface together
	// ----------------------------------------------------------
	private static class ExtendsNode extends AbstractNode<InterfaceElementNode>
			implements NodeCategory, NodeOverview {
		private final InterfaceElement interfaceElement;

		public ExtendsNode(InterfaceElementNode parent) {
			super(parent, parent);
			interfaceElement = parent.source;
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
			return APDEditorImages.DESC_MODEL_EXTENDS_INTERFACE;
		}

		@Override
		public AbstractNode<?>[] getChildren() {
			List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

			for (TypeReference element : interfaceElement.getExtendsElements()) {
				nodes.add(new TypeReferenceNode(this, element,
						new ExtendsDeleteProvider(source), FILTER.INTERFACE));
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
			if (interfaceElement.getExtendsElements().size() > 0) {
				String mask = " : ";//$NON-NLS-1$
				for (TypeReference reference : interfaceElement
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
		
		private String getBaseName(String fullname){
			if(fullname!=null && fullname.contains(".")){
				int lastIndx = fullname.lastIndexOf(".")+1;
				int fullLength = fullname.length();
				return fullname.substring(lastIndx,fullLength);
			}
			return fullname;
		}
	}

	private static class ExtendsDeleteProvider implements
			NodeDeleteProvider<TypeReference> {
		private final AbstractNode<InterfaceElement> node;

		public ExtendsDeleteProvider(AbstractNode<InterfaceElement> node) {
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

	private class MethodDeleteProvider implements NodeDeleteProvider<Method> {

		public void delete(final ModelContext context, Method method) {
			source.getMethods().remove(method);
			context.modelUpdated();
			context.refreah(InterfaceElementNode.this);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				Method t) {
			return AbstractDeleteOperation.create(context,
					InterfaceElementNode.this, source.getMethods(), t);
		}

	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.METHOD, NodeType.DESCRIPTION,
				NodeType.DESCRIPTION, NodeType.EXTENDS ,NodeType.SOURCE_LINK};
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case METHOD:
		case DISCUSSION:
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
		case EXTENDS:
			return new TypeReferenceNode(new ExtendsNode(this),
					(TypeReference) source, new ExtendsDeleteProvider(this));
		}
		return super.toNode(type, source);
	}

	public boolean canMove(Neighbor relation, NodeType type) {
		return relation.getNeighborSource() instanceof Method
				&& NodeType.METHOD == (type);
	}

	public boolean canMove(Neighbor relation, Object source) {
		boolean canMove = (source instanceof Method);
		if (relation != null) {
			Object neighborSource = relation.getNeighborSource();
			EList<Method> methods = getSource().getMethods();
			return canMove && methods.contains(neighborSource);
		}
		return canMove;
	}

	public void move(ModelContext context, Neighbor neighbor, Object source,
			boolean before) {
		if ((neighbor == null || neighbor.getNeighborSource() instanceof Method)
				&& source instanceof Method) {
			EList<Method> methods = getSource().getMethods();
			if (neighbor != null) {
				Method Methodneighbor = (Method) neighbor.getNeighborSource();
				if (methods.contains(Methodneighbor)) {
					int index = methods.indexOf(Methodneighbor);
					if (!before)
						index++;

					methods.add(index, (Method) source);
				}
			} else
				methods.add((Method) source);
		}

	}

	public boolean canMove() {
		return true;
	}
}
