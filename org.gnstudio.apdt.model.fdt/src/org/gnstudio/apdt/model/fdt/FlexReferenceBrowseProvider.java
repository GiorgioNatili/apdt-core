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
package org.gnstudio.apdt.model.fdt;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.window.Window;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

import com.adobe.flexbuilder.codemodel.common.CMFactory;
import com.adobe.flexbuilder.codemodel.definitions.IDefinition;
import com.adobe.flexbuilder.codemodel.project.IProject;
import com.adobe.flexbuilder.project.FlexProjectManager;
import com.adobe.flexbuilder.project.actionscript.IActionScriptProject;
import com.adobe.flexide.as.core.ui.dialogs.SmartOpenTypeDialog;

public class FlexReferenceBrowseProvider implements ReferenceBrowseProvider {

	public String browse(FILTER scopeFilter, String filter, ModelContext context) {
		IResource resource = context.getModelResource();
		SmartOpenTypeDialog dialog = null;
		if (resource != null) {
			IActionScriptProject flexProject = FlexProjectManager
					.getActionScriptOrFlexProject(resource);
			if (flexProject != null) {
				
				IProject project = CMFactory.getManager().getProjectFor(
						flexProject.getProject());
				if (project != null)
					switch (scopeFilter) {
					case CLASS:
						dialog = SmartOpenTypeDialog
								.createClassesDialog(APDEditorPlugin
										.getActiveWorkbenchWindow().getShell(),
										project.getSpecification());
						break;
					case INTERFACE:
						dialog = SmartOpenTypeDialog
								.createInterfacesDialog(APDEditorPlugin
										.getActiveWorkbenchWindow().getShell(),
										project.getSpecification());
						break;

					default:
						dialog = SmartOpenTypeDialog
								.createTypesDialog(APDEditorPlugin
										.getActiveWorkbenchWindow().getShell(),
										project.getSpecification());
						break;
					}
			}
		}
		if (dialog != null) {
			dialog.setTitle("Type");
			if (dialog.open() == Window.OK) {

				IDefinition result = (IDefinition) dialog.getFirstResult();
				return result.getQualifiedName();
			}
		}
		return null;
	}

	public boolean isSupported(ModelContext context) {
		IResource resource = context.getModelResource();
		IActionScriptProject iFlexProject = null;
		if (resource != null)
			iFlexProject = FlexProjectManager.getActionScriptOrFlexProject(resource);

		return iFlexProject != null;

	}
	public void setup(ModelContext context, IProgressMonitor monitor) {
		IResource resource = context.getModelResource();
		
		if (resource != null) {
			monitor.beginTask("Registraring ActionScript Projects", 2);
			IActionScriptProject flexProject = FlexProjectManager
					.getActionScriptOrFlexProject(resource);
			monitor.worked(1);
			if (flexProject != null) {
				CMFactory.getRegistrar().registerProject(
						flexProject.getProject(), null);
			}
			monitor.worked(2);
		}
	}
	public String getName() {
		return "ActionScript Types";
	}
}
