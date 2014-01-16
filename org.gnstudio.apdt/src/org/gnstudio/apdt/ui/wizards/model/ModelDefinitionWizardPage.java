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

import java.nio.charset.Charset;
import java.util.SortedMap;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.gnstudio.apdt.APDTMessages;
import org.gnstudio.apdt.APDTPlugin;

public class ModelDefinitionWizardPage extends WizardNewFileCreationPage {
	private static final String ENCODE_UTF_8 = "UTF-8";//$NON-NLS-1$
	private static String EXTENSION = "pdt"; //$NON-NLS-1$
	private Combo encoding;

	/**
	 * @param pageName
	 * @param selection
	 */
	public ModelDefinitionWizardPage(String pageName,
			IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(APDTMessages.ModelDefinitionWizardPage_title);
		setDescription(APDTMessages.ModelDefinitionWizardPage_des);
		// default the file name to be mymodel.apd
		setFileExtension(EXTENSION);
		setFileName("mymodel"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#validateLinkedResource()
	 */
	protected IStatus validateLinkedResource() {
		return new Status(IStatus.OK, APDTPlugin.getID(), IStatus.OK, "", null); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createLinkTarget()
	 */
	protected void createLinkTarget() {
		// ignore
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createControl()
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		// TODO: add help context
		// PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
		// IHelpContextIds.MODEL_FILE_PAGE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls()
	 */
	protected void createAdvancedControls(final Composite parent) {
		ExpandableComposite expandComposite = new ExpandableComposite(parent,
				ExpandableComposite.COMPACT | ExpandableComposite.TWISTIE
						| ExpandableComposite.EXPANDED);

		expandComposite
				.setText(APDTMessages.ModelDefinitionWizardPage_advanced);

		final Composite advancedComposite = new Composite(expandComposite,
				SWT.NONE);
		expandComposite.setClient(advancedComposite);
		expandComposite.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				Shell shell = parent.getShell();
				Point minSize = shell.getMinimumSize();
				shell.setMinimumSize(shell.getSize().x, minSize.y);
				shell.pack();
				parent.layout();
				shell.setMinimumSize(minSize);
			}
		});
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginLeft = 11;
		gridLayout.numColumns = 2;
		advancedComposite.setLayout(gridLayout);
		Label encodingLabel = new Label(advancedComposite, SWT.NONE);
		encodingLabel.setText(APDTMessages.ModelDefinitionWizardPage_encoding);

		encoding = new Combo(advancedComposite, SWT.READ_ONLY);
		encoding.setLayoutData(new GridData(150, SWT.DEFAULT));

		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for (Charset charset : charsets.values()) {
			encoding.add(charset.name());
		}
		encoding.setText(ENCODE_UTF_8);
	}

	public String getEncoding() {
		return (encoding != null && encoding.getText() != null && encoding
				.getText().length() > 0) ? encoding.getText() : ENCODE_UTF_8;
	}
}
