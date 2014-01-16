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
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.Iteration;
import org.gnstudio.apdt.model.IterationType;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.IterationTypeDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;

public class IterationNode extends GroupNode implements NodeOverview {
	private final Iteration iteration;

	public IterationNode(AbstractNode<?> parent, Iteration iteration,
			NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, iteration, deleteProvider);
		this.iteration = iteration;
	}

	@Override
	public String getName() {
		return APDEditorMessages.TreeNode_iteration;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.iteration");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_SEQN_ITERATION;
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
				context.refreah(IterationNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_note);
		// type
		IterationTypeDescriptor typeDesc = new IterationTypeDescriptor() {

			@Override
			public IterationType getValue() {
				return iteration.getType() != null ? iteration.getType()
						: IterationType.FOR;
			}

			@Override
			public void setValue(IterationType value) {
				iteration.setType(value == null ? IterationType.FOR : value);
				context.modelUpdated();
				context.refreah(IterationNode.this);

			}

			public IterationType[] getOptions() {
				return IterationType.values();
			}
		};
		typeDesc.setText(APDEditorMessages.TreeNode_iteration_type);
		return new NodeDetailsDescriptor<?>[] {nameDesc, typeDesc };
	}

	public void addOverview(StyledString styledString) {
		styledString.append(" (", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
		styledString.append(iteration.getType().getLiteral(),
				StyledString.DECORATIONS_STYLER);
		styledString.append(")", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
		
			if (iteration.getName() != null && iteration.getName().length() > 0) {
				styledString.append(" : ", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
				styledString.append(iteration.getName(),
						StyledString.DECORATIONS_STYLER);
				
			}
		
	}

}
