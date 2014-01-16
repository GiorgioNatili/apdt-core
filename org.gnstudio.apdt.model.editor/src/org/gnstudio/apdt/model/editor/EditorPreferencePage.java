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
package org.gnstudio.apdt.model.editor;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.gnstudio.apdt.APDTUIConstants;

public class EditorPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public EditorPreferencePage() {
		super(FLAT);

	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(APDEditorPlugin.getDefault().getPreferenceStore());
		setDescription(APDEditorMessages.Preference_title);
	}

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor(
				APDTUIConstants.PREFERENCES_MODEL_DEAFULT_PKG,
				APDEditorMessages.Preference_deafult_pkg,
				getFieldEditorParent()));
		addField(new StringFieldEditor(
				APDTUIConstants.PREFERENCES_MODEL_DISCUSSION_AUTHOR,
				APDEditorMessages.Preference_discussion_author,
				getFieldEditorParent()));

	}
    
}
