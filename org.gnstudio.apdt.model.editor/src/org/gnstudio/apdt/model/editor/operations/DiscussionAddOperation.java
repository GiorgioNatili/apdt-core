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
package org.gnstudio.apdt.model.editor.operations;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.gnstudio.apdt.APDTUIConstants;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.DiscussionProvider;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Neighbor;

public class DiscussionAddOperation extends AbstractNodeOperation {
	private Discussion source;

	public DiscussionAddOperation(ModelContext context, Object parent,
			NodeType nodeType, NodeMoveProvider moveProvider,
			Neighbor neighbor, boolean before) {
		super("Description-Operation", context, parent, nodeType, moveProvider,
				neighbor, before);
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		context.selectNodes(false, createNode());
		return Status.OK_STATUS;
	}

	private AbstractNode<?> createNode() {
		final AbstractNode<?> refreshNode = context.findNode(parent);
		if (!(parent instanceof DiscussionProvider))
			return null;

		DiscussionProvider provider = (DiscussionProvider) parent;
		if (source == null) {
			source = ModelFactory.eINSTANCE.createDiscussion();
			source.setAuthor(APDEditorPlugin
					.getDefault()
					.getPreferenceStore()
					.getString(
							APDTUIConstants.PREFERENCES_MODEL_DISCUSSION_AUTHOR));
		}

		provider.getDiscussions().add(source);
		AbstractNode<?> newNode = (refreshNode.toNode(nodeType, source));

		context.modelUpdated();
		context.refreah(refreshNode);
		return newNode;
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		// select node
		context.selectNodes(true, createNode());
		return Status.OK_STATUS;
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		AbstractNode<?> newNode = context.findNode(source);
		if (newNode instanceof DescriptionNode) {
			NodeDeleteProvider<Description> deleteProvider = ((DescriptionNode) newNode)
					.getDeleteProvider();
			if (deleteProvider != null)
				deleteProvider.delete(context, source);
		}
		return Status.OK_STATUS;
	}
}
