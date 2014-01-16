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
import org.gnstudio.apdt.model.ControlSequence;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;

public class ElseGroupNode extends GroupNode implements NodeOverview {
	private final ControlSequence controlSequence;

	public ElseGroupNode(AbstractNode<?> parent,
			ControlSequence controlSequence, final SequenceGroup provider,
			final NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, provider, deleteProvider);
		this.controlSequence = controlSequence;
	}

	@Override
	public String getName() {
		return APDEditorMessages.TreeNode_else;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.else");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_SEQN_ELSE;
	}

	public void addOverview(StyledString styledString) {
		if (group.getName() != null && group.getName().length() > 0) {
			styledString.append(group.getName(),
					StyledString.DECORATIONS_STYLER);
		}

	}

	@Override
	public Object getNeighborSource() {
		return controlSequence;
	}

	@Override
	public boolean canMove() {
		return false;
	}
}
