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
package org.gnstudio.apdt.model.editor.pages;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDModelEditor;
import org.gnstudio.apdt.model.editor.AbstractEditorPage;
import org.gnstudio.apdt.model.editor.EditorLayoutFactory;
import org.gnstudio.apdt.model.editor.parts.ModelDescriptionSection;

public class OverviewPage extends AbstractEditorPage {
	public static final String PAGE_ID = "overview"; //$NON-NLS-1$

	public OverviewPage(APDModelEditor editor) {
		super(editor, PAGE_ID, APDEditorMessages.OverviewPage_title);

	}

	@Override
	protected void buildBody(IManagedForm managedForm, FormToolkit toolkit) {
		Composite body = managedForm.getForm().getBody();
		body.setLayout(EditorLayoutFactory.createFormGridLayout(true, 1));
		managedForm
				.addPart(new ModelDescriptionSection(getEditor(), this, body));

	}

	@Override
	protected String getPageHeader() {
		return APDEditorMessages.OverviewPage_header;
	}

	@Override
	protected Image getPageHeaderImage() {
		return APDEditorImages.getImage(APDEditorImages.DESC_MODEL_OVERVIEW);
	}
}
