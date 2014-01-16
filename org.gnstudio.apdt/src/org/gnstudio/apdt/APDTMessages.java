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
package org.gnstudio.apdt;

import org.eclipse.osgi.util.NLS;

public class APDTMessages extends NLS {
	private static final String BUNDLE_NAME = "org.gnstudio.apdt.resources"; //$NON-NLS-1$
	public static String ModelDefinitionWizardPage_advanced;
	public static String ModelDefinitionWizardPage_des;
	public static String ModelDefinitionWizardPage_encoding;
	public static String ModelDefinitionWizardPage_title;
	public static String ModelDefinitionWizardPage_creatingModel;
	public static String ModelDefinitionWizardPage_creatingModelDescription;
	public static String NewModelDefinitionWizard_title;
	public static String NewWizard_wtitle;
	public static String PreferencesPage_summary;
	public static String PreferencesPage_summary_dtl;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, APDTMessages.class);
	}

	private APDTMessages() {
	}
}
