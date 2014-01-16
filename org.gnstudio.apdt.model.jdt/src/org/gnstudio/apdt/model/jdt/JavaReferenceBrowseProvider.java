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
package org.gnstudio.apdt.model.jdt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

public class JavaReferenceBrowseProvider implements ReferenceBrowseProvider{

	public String browse(FILTER scopeFilter,String filter,ModelContext context) {
		IJavaSearchScope scope = getSearchScope(context);

		if (scope != null) {
			
			if (filter == null) {
				filter = "";//$NON-NLS-1$
			}
			int typeFilter;
			switch (scopeFilter) {
			case CLASS:
				typeFilter = IJavaElementSearchConstants.CONSIDER_CLASSES;
				break;
			case INTERFACE:
				typeFilter = IJavaElementSearchConstants.CONSIDER_INTERFACES;
				break;

			default:
				typeFilter = IJavaElementSearchConstants.CONSIDER_CLASSES_AND_INTERFACES;
				break;
			}
			try {
				SelectionDialog dialog = JavaUI.createTypeDialog(
						APDEditorPlugin.getActiveWorkbenchWindow().getShell(),
						PlatformUI.getWorkbench().getProgressService(), scope,
						typeFilter, false, filter);
				dialog.setTitle("Type");
				if (dialog.open() == Window.OK) {
					IType type = (IType) dialog.getResult()[0];
					return type.getFullyQualifiedName('$');
				}
			} catch (JavaModelException e) {
				APDTLog.log(e);
			}
		}
		return null;

	}

	public IJavaSearchScope getSearchScope(ModelContext context) {
		IResource resource = context.getModelResource();
		if (resource != null) {
			IProject project = resource.getProject();
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject != null) {
				try {
					return SearchEngine.createJavaSearchScope(javaProject
							.getChildren());
				} catch (JavaModelException e) {
					// ignore - this is not java type project

				}
			}
		}
		return null;
	}

	public boolean isSupported(ModelContext context) {
		return getSearchScope(context) != null;
	}

	public String getName() {
		return "Java Types";
	}

	public void setup(ModelContext context, IProgressMonitor monitor) {
		//IGNORE
	}

}
