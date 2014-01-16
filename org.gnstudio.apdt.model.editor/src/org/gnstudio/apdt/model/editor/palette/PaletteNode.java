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
package org.gnstudio.apdt.model.editor.palette;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.editor.nodes.NodeType;

 public class PaletteNode implements PaletteItem {
	private final String name;
	private final ImageDescriptor imageDescriptor;
	private final NodeType type;

	public PaletteNode(String name, ImageDescriptor imageDescriptor, NodeType type) {
		this.name = name;
		this.imageDescriptor = imageDescriptor;
		this.type = type;
	}

	public String getName() {

		return name;
	}

	public ImageDescriptor getImageDescriptor() {

		return imageDescriptor;
	}

	public Action[] getActions() {
		return new Action[0];
	}

	public Object getData() {
		return type;
	}
}
