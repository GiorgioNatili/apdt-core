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
import org.gnstudio.apdt.model.MethodReturn;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;

public class MethodReturnNode extends SequenceNode {
	private MethodReturn methodReturn;

	public MethodReturnNode(AbstractNode<?> parent, MethodReturn methodReturn,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, methodReturn, deleteProvider);
		this.methodReturn = methodReturn;
	}

	@Override
	public String getName() {
		String name = methodReturn.getNote();
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_method_return;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.methodreturn");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {

		return APDEditorImages.DESC_MODEL_RETURN;
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> noteDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return methodReturn.getNote();
			}

			@Override
			public void setValue(String value) {
				methodReturn.setNote(value);
				context.modelUpdated();
				context.refreah(MethodReturnNode.this);

			}
		};
		noteDesc.setText(APDEditorMessages.TreeNode_method_return_note);

		return new NodeDetailsDescriptor[] { noteDesc };
	}
}
