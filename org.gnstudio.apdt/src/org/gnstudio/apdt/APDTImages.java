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
package org.gnstudio.apdt;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

public class APDTImages {
	private APDTImages() {
	}

	public final static String ICONS_PATH = "icons/"; //$NON-NLS-1$
	private static final String PATH_WIZBAN = ICONS_PATH + "wizban/"; //$NON-NLS-1$

	private final static ImageRegistry PLUGIN_REGISTRY = new ImageRegistry();
	public static final ImageDescriptor DESC_NEWMODEL_WIZ = create(PATH_WIZBAN,
			"newmodel_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_EXPORT_MODEL_WIZ = create(
			PATH_WIZBAN, "model_export_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_APDT_ICON = create(ICONS_PATH,
			"gnstudio-apdt.png"); //$NON-NLS-1$

	private static ImageDescriptor create(String prefix, String name) {
		return ImageDescriptor.createFromURL(makeImageURL(prefix, name));
	}

	private static URL makeImageURL(String prefix, String name) {
		String path = "$nl$/" + prefix + name; //$NON-NLS-1$
		return FileLocator.find(APDTPlugin.getDefault().getBundle(), new Path(
				path), null);
	}

	public static Image getImage(ImageDescriptor desc) {
		String key = String.valueOf(desc.hashCode());
		Image image = PLUGIN_REGISTRY.get(key);
		if (image == null) {
			image = desc.createImage();
			PLUGIN_REGISTRY.put(key, image);
		}
		return image;
	}
}
