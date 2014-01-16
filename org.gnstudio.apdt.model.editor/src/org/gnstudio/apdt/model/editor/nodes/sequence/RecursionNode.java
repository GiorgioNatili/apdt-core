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
import org.gnstudio.apdt.model.Recursion;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.DescriptionNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;

public class RecursionNode extends SequenceNode {
	private Recursion recursion;

	public RecursionNode(AbstractNode<?> parent, Recursion recursion,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, recursion, deleteProvider);
		this.recursion = recursion;
	}

	@Override
	public String getName() {
		String name = DescriptionNode.getTextOverview(recursion);
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_recursion;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.recursion");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {

		return APDEditorImages.DESC_MODEL_SEQN_RECURSION;
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> descriptionDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.DESCRIPTION) {

			@Override
			public String getValue() {
				return recursion.getText();
			}

			@Override
			public void setValue(String value) {
				recursion.setText(value);
				context.modelUpdated();
				context.refreah(RecursionNode.this);

			}
		};
		descriptionDesc.setText(APDEditorMessages.TreeNode_description_name);

		return new NodeDetailsDescriptor[] { descriptionDesc };
	}
}
