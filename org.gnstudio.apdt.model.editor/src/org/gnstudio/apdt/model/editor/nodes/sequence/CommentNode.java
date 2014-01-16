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

import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.Comment;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;

public class CommentNode extends SequenceNode {
	private Comment comment;

	public CommentNode(AbstractNode<?> parent, Comment comment,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, comment, deleteProvider);
		this.comment = comment;
	}

	@Override
	public String getName() {
		String name = DescriptionNode.getTextOverview(comment);
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_comment;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.comment");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {

		return APDEditorImages.DESC_MODEL_COMMNET;
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> descriptionDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.DESCRIPTION) {

			@Override
			public String getValue() {
				return comment.getText();
			}

			@Override
			public void setValue(String value) {
				comment.setText(value);
				context.modelUpdated();
				context.refreah(CommentNode.this);

			}
		};
		descriptionDesc.setText(APDEditorMessages.TreeNode_comment_name);

		return new NodeDetailsDescriptor[] { descriptionDesc };
	}
}
