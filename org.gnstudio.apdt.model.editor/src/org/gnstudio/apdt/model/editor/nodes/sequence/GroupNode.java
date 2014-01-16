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
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;

public class GroupNode extends SequenceNode implements NodeMoveProvider {
	protected final SequenceGroup group;

	public GroupNode(AbstractNode<?> parent, SequenceGroup group,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, group, deleteProvider);
		this.group = group;
	}

	@Override
	public String getName() {
		String name = group.getName();
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_group;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.group");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_SEQN_GROUP;
	}

	public boolean isLeaf() {
		return !(group.getDescription() != null || group.getSequences().size() > 0);

	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(0);

		if (group.getDescription() != null) {
			nodes.add(new DescriptionNode(this, group.getDescription(),
					DescriptionNode.createDeleteProvider(this, group)));
		}
		for (Sequence sequence : group.getSequences()) {

			SequenceNode node = SequenceNode.toSequenceNode(this, group,
					sequence);
			assert node != null;
			nodes.add(node);
			SequenceNode.AssociateNodeProvider nodeProvider = node
					.getAssociateNodeProvider();
			if (nodeProvider != null) {
				nodes.addAll(nodeProvider.getAssociateNodes());
			}
		}
		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] {
				DescriptionNode.newDescripationAction(context, this, group),
				null, SequenceNode.newAction(context, this, NodeType.VARIABLE),
				SequenceNode.newAction(context, this, NodeType.COMMENT),
				SequenceNode.newAction(context, this, NodeType.ITERATION),
				SequenceNode.newAction(context, this, NodeType.IF),
				SequenceNode.newAction(context, this, NodeType.SWITCH),
				SequenceNode.newAction(context, this, NodeType.GROUP),
				SequenceNode.newAction(context, this, NodeType.TRY),
				SequenceNode.newAction(context, this, NodeType.METHOD_CALL),
				SequenceNode.newAction(context, this, NodeType.RECURSION),
				SequenceNode.newAction(context, this, NodeType.PRINT),
				SequenceNode.newAction(context, this, NodeType.SHOW),
				SequenceNode.newAction(context, this, NodeType.PROMPT),
				SequenceNode.newAction(context, this, NodeType.READ),
				SequenceNode.newAction(context, this, NodeType.WRITE),
				SequenceNode.newAction(context, this, NodeType.RECOVER),
				SequenceNode.newAction(context, this, NodeType.STORE),
				SequenceNode.newAction(context, this, NodeType.CALC_STORE),
				SequenceNode.newAction(context, this, NodeType.METHOD_RETURN) };
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		List<NodeType> types = new ArrayList<NodeType>();
		types.add(NodeType.DESCRIPTION);
		types.addAll(Arrays.asList(SequenceNode.getSequenceNodeTypes()));
		return types.toArray(new NodeType[0]);
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return group.getDescription() == null;
		default:
			return SequenceNode.isSequenceType(type);
		}
	}

	@Override
	public AbstractNode<?> toNode(NodeType type, Object source) {

		if (SequenceNode.isSequenceType(type)) {
			return SequenceNode.toSequenceNode(this, group, (Sequence) source);
		}
		return super.toNode(type, source);
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return group.getName();
			}

			@Override
			public void setValue(String value) {
				group.setName(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(GroupNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_note);
		return new NodeDetailsDescriptor<?>[] { nameDesc };
	}

	public boolean canMove(Neighbor relation, NodeType type) {
		return relation.getNeighborSource() instanceof Sequence
				&& SequenceNode.isSequenceType(type);
	}

	public void move(ModelContext context, Neighbor relation, Object source,
			boolean before) {
		if ((relation == null || relation.getNeighborSource() instanceof Sequence)
				&& source instanceof Sequence) {
			EList<Sequence> sequences = group.getSequences();
			if (relation != null) {
				Sequence neighbor = (Sequence) relation.getNeighborSource();
				if (sequences.contains(neighbor)) {
					int index = sequences.indexOf(neighbor);
					if (!before)
						index++;

					sequences.add(index, (Sequence) source);
				}
			} else
				sequences.add((Sequence) source);
		}

	}

	public boolean canMove(Neighbor relation, Object source) {

		EList<Sequence> sequences = group.getSequences();
		return source instanceof Sequence
				&& (relation == null || sequences.contains(relation
						.getNeighborSource())) ;
	}
}
