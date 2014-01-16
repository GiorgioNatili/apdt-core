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
package org.gnstudio.apdt.ui.wizards;

import java.util.Dictionary;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.gnstudio.apdt.APDTMessages;

public class NewWizard extends Wizard implements INewWizard {
	private org.eclipse.ui.IWorkbench workbench;
	private org.eclipse.jface.viewers.IStructuredSelection selection;
	private Dictionary<String, String> defaultValues;

	public NewWizard() {
		super();
		setWindowTitle(APDTMessages.NewWizard_wtitle);
	}

	public org.eclipse.jface.viewers.IStructuredSelection getSelection() {
		return selection;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}

	public boolean performFinish() {
		return true;
	}

	public final String getDefaultValue(String key) {
		if (defaultValues == null)
			return null;
		return (String) defaultValues.get(key);
	}

	public final void init(Dictionary<String, String> defaultValues) {
		this.defaultValues = defaultValues;
	}
}
