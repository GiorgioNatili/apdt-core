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

public abstract class AbstractPaletteCategory implements PaletteCategory {
	private final String name;
	private final ImageDescriptor imageDescriptor;

	public AbstractPaletteCategory(String name, ImageDescriptor imageDescriptor) {
		this.name = name;
		this.imageDescriptor = imageDescriptor;
	}

	public String getName() {
		return name;
	}

	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}

	public Object getData() {
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPaletteCategory other = (AbstractPaletteCategory) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Action[] getActions() {
		return new Action[0];
	}
	
}
