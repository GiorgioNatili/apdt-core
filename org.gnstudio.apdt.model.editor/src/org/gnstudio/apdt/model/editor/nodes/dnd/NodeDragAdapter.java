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
package org.gnstudio.apdt.model.editor.nodes.dnd;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

public class NodeDragAdapter implements DragSourceListener {

	protected Viewer viewer;

	protected IStructuredSelection selection;

	public NodeDragAdapter(Viewer viewer) {
		super();
		this.viewer = viewer;
	}

	public void dragStart(DragSourceEvent event) {
		selection = (IStructuredSelection) viewer.getSelection();
		// support one selection only
		if (selection.size() == 0) {
			event.doit = false;
			return;
		}

		Object[] elements = selection.toArray();
		
		for (int i = 0; i < elements.length; i++) {
			Object element = elements[i];
			event.doit = element != null
					&& element instanceof NodeMoveProvider.Movable
					&& ((NodeMoveProvider.Movable) element).canMove();
			if (!event.doit)
				break;
		}

		if (event.doit)
			NodeTransfer.getInstance().javaToNative(elements, event.dataType);
	}

	public void dragFinished(DragSourceEvent event) {
		selection = null;
		NodeTransfer.getInstance().javaToNative(null, null);
	}

	public void dragSetData(DragSourceEvent event) {
		if (NodeTransfer.getInstance().isSupportedType(event.dataType)) {
			event.data = selection.toArray();
		}
	}
}
