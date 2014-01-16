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
package org.gnstudio.apdt.model.editor.descriptors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

public interface ReferenceBrowseProvider {
	// This is the ID for ReferenceBrowseProvider extension point
	public static final String EXTENSION_POINT_ID = "org.gnstudio.apdt.model.editor.descriptors.referenceBrowseProvider";

	public enum FILTER {
		ALL, CLASS, INTERFACE
	}

	void setup(ModelContext context,IProgressMonitor monitor);

	String browse(FILTER scopeFilter, String filter, ModelContext context);

	String getName();

	boolean isSupported(ModelContext context);
}
