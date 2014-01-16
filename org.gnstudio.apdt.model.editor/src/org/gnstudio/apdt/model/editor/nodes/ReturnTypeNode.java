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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;

public class ReturnTypeNode extends TypeReferenceNode implements NodeOverview {

	public ReturnTypeNode(AbstractNode<?> parent, TypeReference element,NodeDeleteProvider<TypeReference> deleteProvider) {
		super(parent, element,deleteProvider);
	}

	@Override
	public String getName() {
		return APDEditorMessages.TreeNode_retrun;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_RETURN;
	}

	public void addOverview(StyledString styledString) {
		if (source.getName() != null) {
			styledString.append(" : ", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
			styledString.append(source.getName(),
					StyledString.DECORATIONS_STYLER);
		}

	}
}
