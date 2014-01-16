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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.gnstudio.apdt.APDTImages;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.APDTMessages;
import org.gnstudio.apdt.ui.wizards.NewWizard;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class NewModelDefinitionFile extends NewWizard implements
		IExecutableExtension {

	private IConfigurationElement config;
	private ModelDefinitionWizardPage modelPage;

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.config = config;

	}

	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(APDTMessages.NewModelDefinitionWizard_title);
		setDefaultPageImageDescriptor(APDTImages.DESC_NEWMODEL_WIZ);
		setNeedsProgressMonitor(true);
	}

	public void addPages() {
		modelPage = new ModelDefinitionWizardPage("model", getSelection()); //$NON-NLS-1$
		addPage(modelPage);
	}

	public boolean performFinish() {
		BasicNewProjectResourceWizard.updatePerspective(config);
		assert modelPage != null;
		final IPath location = modelPage.getContainerFullPath();
		final String fileName = modelPage.getFileName();
		final String encoding = modelPage.getEncoding();

		try {
			IRunnableWithProgress op = new NewModelCreationOperation(location,
					fileName, encoding);
			getContainer().run(false, true, op);
		} catch (InvocationTargetException e) {
			APDTLog.logException(e);
			return false;
		} catch (InterruptedException e) {
			return false;
		}

		return true;
	}
}