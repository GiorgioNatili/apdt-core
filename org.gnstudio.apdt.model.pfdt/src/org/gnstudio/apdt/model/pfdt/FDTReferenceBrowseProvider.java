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
package org.gnstudio.apdt.model.pfdt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.window.Window;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

import com.powerflasher.fdt.core.outermodel.FDTModel2;
import com.powerflasher.fdt.core.outermodel.IMasterModel;
import com.powerflasher.fdt.core.outermodel.ProjectModel;
import com.powerflasher.fdt.core.resources.IFlashProject;
import com.powerflasher.fdt.ui.FDTUIPlugin;

public class FDTReferenceBrowseProvider implements ReferenceBrowseProvider {
	public String browse(FILTER scopeFilter, String filter, ModelContext context) {
		ProjectModel scope = getProjectModel(context);

		if (scope != null) {

			TypeSelectionDialog dialog = TypeSelectionDialog.createSearchDialog(
					APDEditorPlugin.getActiveWorkbenchWindow().getShell(),
					scope, scopeFilter, filter);
			
			if (dialog.open() == Window.OK) {
				IMasterModel type = dialog.getFirstResult();
				return type.getQualifiedName();
			}
		}
		return null;

	}



	public boolean isSupported(ModelContext context) {
		return getProjectModel(context) != null ;
	}

	public String getName() {
		return "ActionScript Types";
	}

	public void setup(ModelContext context, IProgressMonitor monitor) {
		IResource resource = context.getModelResource();
		if (resource != null) {
			IProject project = resource.getProject();
			FDTUIPlugin.ifProjectIsUnbuildBuildComplete(project, monitor);
		}
	}

	private ProjectModel getProjectModel(ModelContext context) {
		IResource resource = context.getModelResource();
		if (resource != null) {
			IProject project = resource.getProject();
			Object adapter = project.getAdapter(IFlashProject.class);
			return FDTModel2.getInstance().getProjectModel(project);
		}
		return null;
	}
}
