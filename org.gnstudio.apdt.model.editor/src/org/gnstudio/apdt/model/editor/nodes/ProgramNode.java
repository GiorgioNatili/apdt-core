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
import org.eclipse.jface.viewers.IDecoration;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Movable;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class ProgramNode extends AbstractNode<Program> implements
		NodeMoveProvider, Movable {

	public ProgramNode(Program source) {
		super(source, new ProgramDeleteProvider());
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
		return APDNodeHelpMessages.getNLS("editor.help.program");
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = APDEditorImages.DESC_MODEL_PROGRAM;
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
				|| source.getPackages().size() > 0 || source.getDiscussions()
				.size() > 0);
	}

	@Override
	public AbstractNode<?>[] getChildren() {

		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();
		if (source.getDescription() != null) {
			nodes.add(new DescriptionNode(this, source.getDescription(),
					DescriptionNode.createDeleteProvider(this, source)));
		}
		if (source.getDiscussions().size() > 0) {
			nodes.add(new DiscussionsNode(this));
		}
		
		if (source.getLink() != null) {
			nodes.add(new SourceLinkNode(this, source.getLink(),
					SourceLinkNode.createDeleteProvider(this, source)));
		}
		
		List<PackageElement> elements = new ArrayList<PackageElement>(
				source.getPackages());
		Collections.sort(elements, new Comparator<PackageElement>() {

			public int compare(PackageElement o1, PackageElement o2) {
				if (o2.getName() == null) {
					return 1;
				}
				if (o1.getName() == null) {
					return -1;
				}

				return o1.getName().compareTo(o2.getName());
			}
		});
		for (PackageElement element : elements) {
			nodes.add(new PackageElementNode(this, element,
					new PkgDeleteProvider()));
		}

		return nodes.toArray(new AbstractNode<?>[0]);
	}

	@Override
	public Action[] getActions(final ModelContext context) {
		Action packageAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, ProgramNode.this,
						NodeType.PACKAGE);
			}
		};
		packageAction.setText(APDEditorMessages.TreeNodeAction_new_package);

		return new Action[] {
				DescriptionNode.newDescripationAction(context, this, source),
				packageAction,
				DiscussionsNode.getNewDiscussionAction(this, context),SourceLinkNode.newSourceLinkAction(context, this, source) };
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
				context.refreah(ProgramNode.this);

			}
		};
		nameDesc.setRequired(true);
		nameDesc.setText(APDEditorMessages.TreeNode_program_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_program_name_dec);

		return new NodeDetailsDescriptor[] { nameDesc };
	}

	private static class ProgramDeleteProvider implements
			NodeDeleteProvider<Program> {

		public void delete(final ModelContext context, Program program) {
			Model model = context.getModel();
			model.getPrograms().remove(program);
			context.modelUpdated();
			context.refreahAll();
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				Program t) {
			Model model = context.getModel();
			return AbstractDeleteOperation.create(context, null,
					model.getPrograms(), t);
		}

	}

	private class PkgDeleteProvider implements
			NodeDeleteProvider<PackageElement> {

		public void delete(final ModelContext context, PackageElement pkj) {
			source.getPackages().remove(pkj);
			context.modelUpdated();
			context.refreah(ProgramNode.this);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				PackageElement t) {

			return AbstractDeleteOperation.create(context, ProgramNode.this,
					source.getPackages(), t);
		}

	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.PACKAGE, NodeType.DESCRIPTION,
				NodeType.DISCUSSION, NodeType.SOURCE_LINK };
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case PACKAGE:
			return true;
		case DESCRIPTION:
			return source.getDescription() == null;
		case SOURCE_LINK:
			return source.getLink() == null;
		case DISCUSSION:
			return true;
		default:
			return false;
		}
	}

	@Override
	public AbstractNode<?> toNode(NodeType type, Object source) {
		switch (type) {
		case DISCUSSION:
			return DiscussionsNode.toDiscussionNode(this, (Description) source);
		}
		return super.toNode(type, source);
	}

	public static Action createNewProgramAction(final ModelContext context) {
		Action action = new Action() {
			public void run() {
				NodeActions.createNewNode(context, null, NodeType.PROGRAM);
			}
		};
		action.setText(APDEditorMessages.TreeNodeAction_new_program);
		return action;
	}

	public boolean canMove(Neighbor relation, NodeType type) {

		return relation == null && type == NodeType.PACKAGE;
	}

	public boolean canMove(Neighbor relation, Object source) {
		return relation == null && source instanceof PackageElement;
	}

	public void move(ModelContext context, Neighbor neighbor, Object source,
			boolean before) {
		if (neighbor == null && source instanceof PackageElement) {
			getSource().getPackages().add((PackageElement) source);
		}

	}

	public boolean canMove() {
		return true;
	}
}
