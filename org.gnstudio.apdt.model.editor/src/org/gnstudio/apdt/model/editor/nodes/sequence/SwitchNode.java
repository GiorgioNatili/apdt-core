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

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.SwitchSequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeActions;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class SwitchNode extends SequenceNode implements NodeOverview {
	private final SwitchSequence switchSequence;

	public SwitchNode(AbstractNode<?> parent, SwitchSequence switchSequence,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, switchSequence, deleteProvider);
		this.switchSequence = switchSequence;
	}

	@Override
	public String getName() {
		return APDEditorMessages.TreeNode_switch;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.switch");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_SEQN_SWITCH;
	}

	public boolean isLeaf() {
		return !(switchSequence.getDescription() != null
				|| switchSequence.getCases().size() > 0 || switchSequence
				.getDefaultCase() != null);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(0);

		if (switchSequence.getDescription() != null) {
			nodes.add(new DescriptionNode(this,
					switchSequence.getDescription(), DescriptionNode
							.createDeleteProvider(this, switchSequence)));
		}

		for (SequenceGroup group : switchSequence.getCases()) {
			nodes.add(new CaseGroupNode(this, group,
					new NodeDeleteProvider<Sequence>() {

						public void delete(ModelContext context,
								Sequence sequence) {
							switchSequence.getCases().remove(sequence);
							context.modelUpdated();
							context.refreah(SwitchNode.this);
						}

						public AbstractOperation createDeleteOperation(
								ModelContext context, Sequence t) {

							return AbstractDeleteOperation.create(context,
									SwitchNode.this, switchSequence.getCases(),
									t);
						}
					}));
		}
		if (switchSequence.getDefaultCase() != null) {
			nodes.add(new DefaultCaseGroupNode(this, switchSequence
					.getDefaultCase(), new NodeDeleteProvider<Sequence>() {

				public void delete(ModelContext context, Sequence sequence) {
					switchSequence.setDefaultCase(null);
					context.modelUpdated();
					context.refreah(SwitchNode.this);
				}

				public AbstractOperation createDeleteOperation(
						final ModelContext context, final Sequence t) {
					return new AbstractDeleteOperation() {

						@Override
						public IStatus undo(IProgressMonitor monitor,
								IAdaptable info) {
							switchSequence.setDefaultCase((SequenceGroup) t);
							context.modelUpdated();
							context.refreah(SwitchNode.this);
							return Status.OK_STATUS;
						}

						@Override
						public IStatus redo(IProgressMonitor monitor,
								IAdaptable info) {
							delete(context, t);
							return Status.OK_STATUS;
						}
					};
				}
			}));

		}
		return nodes.toArray(new AbstractNode<?>[0]);

	}

	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return switchSequence.getNote();
			}

			@Override
			public void setValue(String value) {
				switchSequence.setNote(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(SwitchNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_note);
		return new NodeDetailsDescriptor<?>[] { nameDesc };
	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] {
				DescriptionNode.newDescripationAction(context, this,
						switchSequence), null, getCaseAction(context),
				getDefaultCaseAction(context) };
	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.DESCRIPTION, NodeType.CASE,
				NodeType.DEFAULT_CASE };
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return switchSequence.getDescription() == null;
		case CASE:
			return true;
		case DEFAULT_CASE:
			return switchSequence.getDefaultCase() == null;

		default:
			return false;
		}
	}

	public void addOverview(StyledString styledString) {
		if (switchSequence.getNote() != null
				&& switchSequence.getNote().length() > 0) {
			styledString.append(switchSequence.getNote(),
					StyledString.DECORATIONS_STYLER);
		}

	}

	private Action getCaseAction(final ModelContext context) {
		Action descAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, SwitchNode.this,
						NodeType.CASE);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_case);

		return descAction;
	}

	private Action getDefaultCaseAction(final ModelContext context) {
		Action descAction = new Action() {
			@Override
			public boolean isEnabled() {
				return switchSequence.getDefaultCase() == null;
			}

			public void run() {
				NodeActions.createNewNode(context, SwitchNode.this,
						NodeType.DEFAULT_CASE);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_default_case);

		return descAction;
	}
}
