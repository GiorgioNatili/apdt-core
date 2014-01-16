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
package org.gnstudio.apdt.preferences;

import java.net.URL;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.gnstudio.apdt.APDTImages;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.APDTMessages;

public class BasePreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	public void init(IWorkbench workbench) {
		noDefaultAndApplyButton();
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite body = new Composite(parent, SWT.NULL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		body.setLayoutData(data);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		body.setLayout(layout);
		Label apdtIcon = new Label(body, SWT.NONE);
		apdtIcon.setAlignment(SWT.RIGHT);
		Label lblInfo = new Label(body, SWT.NONE);
		apdtIcon.setImage(APDTImages.getImage(APDTImages.DESC_APDT_ICON));
		lblInfo.setText(String.format(APDTMessages.PreferencesPage_summary,
				"1.1.0"));
		new Label(body, SWT.NONE);
		Link link = new Link(body, SWT.NONE);
		link.setText("<A>http://www.modeling.io</A>");
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent evet) {
				try {
					PlatformUI.getWorkbench().getBrowserSupport()
							.getExternalBrowser()
							.openURL(new URL("http://www.modeling.io"));
				} catch (Exception e) {
					APDTLog.log(e);
				}
			}
		});
		new Label(body, SWT.NONE);
		Label details = new Label(body, SWT.NONE);
		details.setText(APDTMessages.PreferencesPage_summary_dtl);
		return body;
	}

}
