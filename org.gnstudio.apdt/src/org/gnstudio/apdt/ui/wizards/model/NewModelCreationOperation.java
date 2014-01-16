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
package org.gnstudio.apdt.ui.wizards.model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.APDTMessages;
import org.gnstudio.apdt.APDTPlugin;
import org.gnstudio.apdt.APDTUIConstants;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.util.ModelOperation;
import org.gnstudio.apdt.model.util.ModelOperationException;


public class NewModelCreationOperation extends WorkspaceModifyOperation {
	private final IPath fPath;
	private final String fFileName;
	private final String encoding;

	public NewModelCreationOperation(IPath path, String fileName,
			String encoding) {
		fPath = path;
		fFileName = fileName;
		this.encoding = encoding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core
	 * .runtime.IProgressMonitor)
	 */
	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException,
			InvocationTargetException, InterruptedException {
		monitor.beginTask(APDTMessages.ModelDefinitionWizardPage_creatingModel,
				2);
		try {
			IFile modelFile = createModel();

			monitor.worked(1);
			// open model in editor
			openFile(modelFile);
			monitor.worked(1);
		} catch (IOException e) {
			APDTLog.log(e);
		} catch (ModelOperationException e) {
			APDTLog.log(e);
		}
	}

	private IFile createModel() throws IOException,
			CoreException, ModelOperationException {
		IWorkspaceRoot root = APDTPlugin.getWorkspace().getRoot();

		IPath fFilePath = fPath.append(fFileName);
		IFile modelFile = root.getFile(fFilePath);

		// Create a resource set
		Model model = ModelOperation.createNewModel(modelFile, encoding);
		model.setDescription(APDTMessages.ModelDefinitionWizardPage_creatingModelDescription);
		// Set the default editor
		IDE.setDefaultEditor(modelFile, APDTUIConstants.MODEL_EDITOR_ID);
		return modelFile;
	}

	private void openFile(final IFile file) {
		APDTPlugin.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchWindow ww = APDTPlugin.getActiveWorkbenchWindow();
				if (ww == null) {
					return;
				}
				IWorkbenchPage page = ww.getActivePage();
				if (page == null || !file.exists())
					return;
				IWorkbenchPart focusPart = page.getActivePart();
				if (focusPart instanceof ISetSelectionTarget) {
					ISelection selection = new StructuredSelection(file);
					((ISetSelectionTarget) focusPart).selectReveal(selection);
				}
				try {
					page.openEditor(new FileEditorInput(file),
							APDTUIConstants.MODEL_EDITOR_ID);
				} catch (PartInitException e) {
					APDTLog.log(e);
				}
			}
		});
	}
}
