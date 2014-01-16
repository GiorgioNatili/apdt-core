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

import org.eclipse.jface.viewers.ViewerComparator;
import org.gnstudio.apdt.model.editor.nodes.NodeCategory;

public class NodeViewerComparator extends ViewerComparator {
	@Override
	public int category(Object element) {
		if(element instanceof NodeCategory){
			return ((NodeCategory)element).getCategory();
		}
		return Integer.MAX_VALUE;
	}
}
