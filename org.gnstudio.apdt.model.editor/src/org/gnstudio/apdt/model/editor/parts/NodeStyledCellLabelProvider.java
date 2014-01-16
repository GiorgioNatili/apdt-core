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

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;

public class NodeStyledCellLabelProvider extends
		DelegatingStyledCellLabelProvider implements ILabelProvider {
	private final TreeLabelProvider provider;

	public NodeStyledCellLabelProvider(TreeLabelProvider labelProvider) {
		super(labelProvider);
		provider = labelProvider;
	}

	public String getText(Object element) {

		return provider.getText(element);
	}

	@Override
	public String getToolTipText(Object element) {
		if (element instanceof AbstractNode) {
			AbstractNode<?> node = (AbstractNode<?>) element;
			String toolTipText = node.getToolTipText();
			if(toolTipText!=null && toolTipText.length()>0)
				return toolTipText;
		}
		return null;
	}
	

}
