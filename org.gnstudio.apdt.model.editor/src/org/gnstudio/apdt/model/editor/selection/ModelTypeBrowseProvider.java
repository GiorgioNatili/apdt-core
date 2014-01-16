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
package org.gnstudio.apdt.model.editor.selection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.window.Window;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

public class ModelTypeBrowseProvider implements ReferenceBrowseProvider {

	public String browse(FILTER scopeFilter, String filter, ModelContext context) {
		TypeSelectionDialog dialog = TypeSelectionDialog.createSearchDialog(
				APDEditorPlugin.getActiveWorkbenchWindow().getShell(),
				context.getModel(), scopeFilter, filter);
		
		if (dialog.open() == Window.OK) {
			Type type = (Type) dialog.getFirstResult();
			return type.getFullyQualifiedName();
		}
		return null;
	}

	public boolean isSupported(ModelContext context) {
		return true;
	}

	public String getName() {
		
		return "Model Types";
	}
	public void setup(ModelContext context, IProgressMonitor monitor) {
		//IGNORE
	}
}
