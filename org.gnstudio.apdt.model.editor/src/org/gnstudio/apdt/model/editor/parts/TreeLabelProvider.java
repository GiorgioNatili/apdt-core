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
package org.gnstudio.apdt.model.editor.parts;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.NodeOverview;

public class TreeLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider{
	public String getText(Object obj) {
		if (obj instanceof AbstractNode) {
			AbstractNode<?> node = (AbstractNode<?>) obj;
			return node.getName();
		}
		return obj.toString();
	}

	public Image getImage(Object obj) {
		if (obj instanceof AbstractNode) {
			AbstractNode<?> node = (AbstractNode<?>) obj;
			ImageDescriptor imageDes = node.getImageDescriptor();
			if (imageDes != null) {
				return APDEditorImages.getImage(imageDes);
			}
		}
		return null;
	}

	/* (non-Javadoc)
     * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
     */
	public StyledString getStyledText(Object element) {
		StyledString ss = new StyledString();
		ss.append(getText(element));
		if(element instanceof NodeOverview){
			NodeOverview overview = (NodeOverview) element;
			overview.addOverview(ss);
		}
			
		return ss;
	}
}
