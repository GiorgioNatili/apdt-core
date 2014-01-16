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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.DiscussionProvider;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class DiscussionsNode extends
		AbstractNode<AbstractNode<? extends DiscussionProvider>> implements
		NodeCategory, NodeOverview {
	private final DiscussionProvider discussions;

	public DiscussionsNode(
			final AbstractNode<? extends DiscussionProvider> parent) {
		super(parent, parent, new DiscussionsDeleteProvider());
		discussions = parent.source;
	}

	public String getName() {

		return APDEditorMessages.TreeNode_discussions;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_DISCUSSIONS;
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

		for (Description element : discussions.getDiscussions()) {
			nodes.add(new DiscussionNode(this, element,
					new DiscussionDeleteProvider()));
		}
		return nodes.toArray(new AbstractNode<?>[0]);
	}

	@Override
	public Action[] getActions(final ModelContext context) {
		return new Action[] { getNewDiscussionAction(source, context) };
	}

	public int getCategory() {
		return CATEGORY_DISCUSSION;
	}

	public void addOverview(StyledString styledString) {

	}

	private static class DiscussionsDeleteProvider implements
			NodeDeleteProvider<AbstractNode<? extends DiscussionProvider>> {
		public void delete(ModelContext context,
				AbstractNode<? extends DiscussionProvider> t) {
			t.source.getDiscussions().clear();
			context.modelUpdated();
			context.refreah(t);

		}

		public AbstractOperation createDeleteOperation(
				final ModelContext context,
				final AbstractNode<? extends DiscussionProvider> t) {

			return new DiscussionsDeleteOperation(context, t);
		}
	}

	private static class DiscussionsDeleteOperation extends
			AbstractDeleteOperation {
		private final ModelContext context;
		private final AbstractNode<? extends DiscussionProvider> t;
		private List<Discussion> list = null;

		private DiscussionsDeleteOperation(ModelContext context,
				AbstractNode<? extends DiscussionProvider> t) {
			this.context = context;
			this.t = t;
		}

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			if (list != null) {
				t.source.getDiscussions().addAll(list);
			}
			context.modelUpdated();
			context.refreah(t);
			return Status.OK_STATUS;

		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			list = new ArrayList<Discussion>(t.source.getDiscussions());
			t.source.getDiscussions().clear();
			context.modelUpdated();
			context.refreah(t);
			return Status.OK_STATUS;
		}
	}

	private class DiscussionDeleteProvider implements
			NodeDeleteProvider<Description> {

		public void delete(final ModelContext context, Description pkj) {
			discussions.getDiscussions().remove(pkj);
			context.modelUpdated();
			context.refreah(source);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				Description t) {
			return AbstractDeleteOperation.create(context, source,
					discussions.getDiscussions(), t);
		}

	}

	public static Action getNewDiscussionAction(
			final AbstractNode<? extends DiscussionProvider> node,
			final ModelContext context) {
		Action descAction = new Action() {

			public void run() {
				NodeActions.createNewNode(context, node, NodeType.DISCUSSION);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_discussion);

		return descAction;
	}

	private static class DiscussionNode extends DescriptionNode implements
			NodeOverview {

		public DiscussionNode(AbstractNode<?> parent, Description description,
				DiscussionDeleteProvider deleteProvider) {
			super(parent, description, deleteProvider);

		}

		public String getName() {
			return ((Discussion) source).getAuthor();
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return APDEditorImages.DESC_MODEL_DISCUSSION;
		}

		public void addOverview(StyledString styledString) {
			if (source.getText() != null) {
				styledString.append(": ", StyledString.DECORATIONS_STYLER);
				styledString.append(getTextOverview(source),
						StyledString.DECORATIONS_STYLER);
			}

		}
	}

	public static AbstractNode<?> toDiscussionNode(
			AbstractNode<? extends DiscussionProvider> parent,
			Description discussion) {

		return new DiscussionNode(new DiscussionsNode(parent), discussion, null);
	}
}