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
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;

public class ExportToProjectWizard extends Wizard implements IExportWizard {

	private Model model;
    private IFile modelPath;
	private ExportToProjectWizardPage exportPage = null;

	public ExportToProjectWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle("Export Model");
	}

	public void init(Model model,IFile modelPath) {
		this.model = model;
		this.modelPath = modelPath;
	}

	@Override
	public void addPages() {
		exportPage = new ExportToProjectWizardPage();
		exportPage.setWizard(this);
		addPage(exportPage);
	}

	@Override
	public boolean canFinish() {
		return exportPage.isPageComplete();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// no initialization needed
	}

	/**
	 * Called when the user clicks finish. Saves the connection data. Waits
	 * until all overwrite decisions have been made before starting to save
	 * files. If any overwrite is canceled, no files are saved and the user must
	 * adjust the dialog.
	 */
	@Override
	public boolean performFinish() {

		final IResource folder = exportPage.getDestinationDirectory();
		assert folder != null;
		final ModelExportProvider exportProvider = exportPage
				.getModelExportProvider();
		assert exportProvider != null;
		if (!exportProvider.isSupported(model))
			return false;

		APDEditorPlugin
				.getDefault()
				.getPreferenceStore()
				.setValue(ExportToProjectWizardPage.PROVIDER_ID,
						exportProvider.getProviderId());
		try {
			final IRunnableWithProgress job = new IRunnableWithProgress() {
				void deleteStubs(File f) {
					if (f.isDirectory()) {
						for (File c : f.listFiles())
							deleteStubs(c);
					} else if (f.getName().equals("__apd_stub_")) {
						if (!f.delete())
							f.deleteOnExit();
					}

				}

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					File target = folder.getLocation().toFile();
					String name = modelPath.getName();
					int dot = name.lastIndexOf('.');
					if(dot>0)
					{
						name = name.substring(0, dot);
					}
					exportProvider.export(monitor,name, model, target);
					deleteStubs(target);
					try {
						IContainer containerForLocation = ResourcesPlugin
								.getWorkspace().getRoot()
								.getContainerForLocation(folder.getLocation());
						if (containerForLocation == null)
							containerForLocation = folder.getParent();

						if (containerForLocation != null)
							containerForLocation.refreshLocal(
									IResource.DEPTH_INFINITE, monitor);
					} catch (CoreException e) {
						APDTLog.logException(e);
					}finally
					{
						model = null;
						modelPath = null;
					}
				}

			};
			getContainer().run(true, true, job);
		} catch (final InvocationTargetException e) {
			APDTLog.logException(e);
		} catch (final InterruptedException e) {
			APDTLog.logException(e);
		}
		return true;
	}
}
