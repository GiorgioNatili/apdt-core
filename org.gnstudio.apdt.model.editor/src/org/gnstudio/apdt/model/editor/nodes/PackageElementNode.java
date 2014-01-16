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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class PackageElementNode extends AbstractNode<PackageElement> implements
		NodeMoveProvider, NodeMoveProvider.Movable {

	public PackageElementNode(AbstractNode<?> parent,
			PackageElement packageElement,
			NodeDeleteProvider<PackageElement> deleteProvider) {
		super(parent, packageElement, deleteProvider);
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
		return APDNodeHelpMessages.getNLS("editor.help.pakage");
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_PACKAGE;
	}

	@Override
	public Action[] getActions(final ModelContext context) {
		Action interfaceAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, PackageElementNode.this,
						NodeType.INTERFACE);
			}
		};
		interfaceAction.setText(APDEditorMessages.TreeNodeAction_new_interface);
		Action calssAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, PackageElementNode.this,
						NodeType.CLASS);
			}
		};
		calssAction.setText(APDEditorMessages.TreeNodeAction_new_class);
		return new Action[] { interfaceAction, calssAction,
				DiscussionsNode.getNewDiscussionAction(this, context),
				SourceLinkNode.newSourceLinkAction(context, this, source) };
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
				context.refreah(PackageElementNode.this);
				context.refreah(PackageElementNode.this.getParent());

			}
		};
		nameDesc.setRequired(true);
		nameDesc.setText(APDEditorMessages.TreeNode_package_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_package_name_dec);

		return new NodeDetailsDescriptor[] { nameDesc };
	}

	@Override
	public boolean isLeaf() {
		return !(source.getClasses().size() > 0 || source.getLink() != null
				|| source.getInterfaces().size() > 0 || source.getDiscussions()
				.size() > 0);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

		if (source.getDiscussions().size() > 0) {
			nodes.add(new DiscussionsNode(this));
		}

		if (source.getLink() != null) {
			nodes.add(new SourceLinkNode(this, source.getLink(), SourceLinkNode
					.createDeleteProvider(this, source)));
		}

		// interface nodes
		List<InterfaceElement> interfaceElements = new ArrayList<InterfaceElement>(
				source.getInterfaces());
		Collections.sort(interfaceElements, new Comparator<InterfaceElement>() {

			public int compare(InterfaceElement o1, InterfaceElement o2) {
				if (o2.getName() == null) {
					return 1;
				}
				if (o1.getName() == null) {
					return -1;
				}

				return o1.getName().compareTo(o2.getName());
			}
		});
		for (InterfaceElement element : interfaceElements) {
			nodes.add(new InterfaceElementNode(this, element,
					new InterfaceDeleteProvider()));
		}
		// class nodes
		List<ClassElement> classElements = new ArrayList<ClassElement>(
				source.getClasses());
		Collections.sort(classElements, new Comparator<ClassElement>() {

			public int compare(ClassElement o1, ClassElement o2) {
				if (o2.getName() == null) {
					return 1;
				}
				if (o1.getName() == null) {
					return -1;
				}

				return o1.getName().compareTo(o2.getName());
			}
		});
		for (ClassElement element : classElements) {
			nodes.add(new ClassElementNode(this, element,
					new ClassDeleteProvider()));
		}
		return nodes.toArray(new AbstractNode<?>[0]);
	}

	private class ClassDeleteProvider implements
			NodeDeleteProvider<ClassElement> {

		public void delete(final ModelContext context, ClassElement classElement) {
			source.getClasses().remove(classElement);
			context.modelUpdated();
			context.refreah(PackageElementNode.this);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				ClassElement t) {
			return AbstractDeleteOperation.create(context,
					PackageElementNode.this, source.getClasses(), t);
		}
	}

	private class InterfaceDeleteProvider implements
			NodeDeleteProvider<InterfaceElement> {

		public void delete(final ModelContext context,
				InterfaceElement interfaceElement) {
			source.getInterfaces().remove(interfaceElement);
			context.modelUpdated();
			context.refreah(PackageElementNode.this);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				InterfaceElement t) {
			return AbstractDeleteOperation.create(context,
					PackageElementNode.this, source.getInterfaces(), t);
		}
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.CLASS, NodeType.INTERFACE,
				NodeType.DISCUSSION, NodeType.SOURCE_LINK };
	}

	@Override
	public boolean canAddNodeType(NodeType type) {

		return type == NodeType.CLASS || type == NodeType.INTERFACE
				|| type == NodeType.DISCUSSION
				|| (type == NodeType.SOURCE_LINK && source.getLink() == null);
	}

	@Override
	public AbstractNode<?> toNode(NodeType type, Object source) {
		switch (type) {
		case DISCUSSION:
			return DiscussionsNode.toDiscussionNode(this, (Description) source);

		}

		return super.toNode(type, source);
	}

	public boolean canMove(Neighbor relation, NodeType type) {
		return relation == null && canAddNodeType(type);
	}

	public boolean canMove(Neighbor relation, Object source) {

		return (relation == null && ((source instanceof ClassElement) || (source instanceof InterfaceElement)));
	}

	public void move(ModelContext context, Neighbor neighbor, Object source,
			boolean before) {
		if (neighbor == null) {
			if ((source instanceof ClassElement))
				getSource().getClasses().add((ClassElement) source);
			else if ((source instanceof InterfaceElement))
				getSource().getInterfaces().add((InterfaceElement) source);
		}

	}

	public boolean canMove() {
		return true;
	}
}
