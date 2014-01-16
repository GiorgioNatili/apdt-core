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
package org.gnstudio.apdt.model.editor.export;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.gnstudio.apdt.model.Model;

public interface ModelExportProvider {
	public static final String EXTENSION_POINT_ID = "org.gnstudio.apdt.model.editor.exportProvider";
	public void export(IProgressMonitor monitor,String name, Model model, File target);
	
	public String getProviderName();
	
	public String getProviderId();
	
	public boolean isSupported(Model model);
}
