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
import org.gnstudio.apdt.model.ControlSequence;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;

public class ElseIfGroupNode extends ElseGroupNode {

	public ElseIfGroupNode(AbstractNode<?> parent,
			ControlSequence controlSequence, final SequenceGroup provider,
			final NodeDeleteProvider<Sequence> deleteProvider) {
		super(parent, controlSequence, provider, deleteProvider);
	}

	@Override
	public String getName() {
		return APDEditorMessages.TreeNode_elseif;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.elseif");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_SEQN_ELSE_IF;
	}

}
