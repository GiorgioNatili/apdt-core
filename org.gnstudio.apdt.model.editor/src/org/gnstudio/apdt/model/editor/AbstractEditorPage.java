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

import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.editor.export.ExportToProjectWizard;

public abstract class AbstractEditorPage extends FormPage {

	private final APDModelEditor editor;

	public AbstractEditorPage(APDModelEditor editor, String pageId, String title) {
		super(editor, pageId, title);
		this.editor = editor;
	}

	public APDModelEditor getEditor() {
		return editor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui
	 * .forms.IManagedForm)
	 */
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(getPageHeader());
		form.setImage(getPageHeaderImage());
		toolkit.decorateFormHeading(form.getForm());
		createPageToolbar(managedForm.getForm(), toolkit);
		buildBody(managedForm, toolkit);
		
		form.updateToolBar();
	}

	protected Image getPageHeaderImage() {
		return null;
	}

	protected abstract void buildBody(IManagedForm managedForm,
			FormToolkit toolkit);

	protected abstract String getPageHeader();

	@Override
	public void dispose() {
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormPage#canLeaveThePage()
	 */
	public boolean canLeaveThePage() {
		editor.setDirty(isDirty());
		return true;
	}

	protected Action[] getPageToolbarActions(ScrolledForm form,
			FormToolkit toolkit) {

		return new Action[0];
	}

	private void createPageToolbar(final ScrolledForm form, FormToolkit toolkit) {
		Action[] actions = getPageToolbarActions(form, toolkit);
		IToolBarManager toolBarManager = form.getToolBarManager();
		for (Action action : actions) {
			toolBarManager.add(action);
		}

		addExportAction(toolBarManager);
		final String helpContextId = getHelpContextId();
		Action helpAction;
		if (helpContextId != null) {
			helpAction = new Action("help") { //$NON-NLS-1$
				public void run() {
					BusyIndicator.showWhile(form.getForm().getDisplay(),
							new Runnable() {
								public void run() {
									PlatformUI.getWorkbench().getHelpSystem()
											.displayHelp(helpContextId);
								}
							});
				}
			};
			
		}else{
			helpAction = new Action("help") { //$NON-NLS-1$
				public void run() {
					BusyIndicator.showWhile(form.getForm().getDisplay(),
							new Runnable() {
								public void run() {
									try {
										PlatformUI.getWorkbench().getBrowserSupport()
												.getExternalBrowser()
												.openURL(new URL("http://www.modeling.io/support"));
									} catch (Exception e) {
										APDTLog.log(e);
									}
								}
							});
				}
			};
		}
		
		helpAction.setImageDescriptor(APDEditorImages.DESC_HELP);
		helpAction.setToolTipText(APDEditorMessages.TreeNodeAction_help);
		toolBarManager.add(helpAction);

		form.updateToolBar();
	}

	public String getHelpContextId() {
		return null;
	}

	public void refresh() {
		IManagedForm managedForm = getManagedForm();
		if (managedForm != null) {
			IFormPart[] parts = managedForm.getParts();
			for (IFormPart iFormPart : parts) {
				iFormPart.refresh();
			}
		}
	}

	public IContentOutlinePage getContentOutlinePage() {
		return null;
	}

	private void addExportAction(IToolBarManager toolBarManager) {
		toolBarManager.add(new Action(APDEditorMessages.ExportAction_label,
				APDEditorImages.DESC_EXPORT_TO_PRJ) {
			@Override
			public void run() {
				ExportToProjectWizard wizard = new ExportToProjectWizard();
				wizard.init(getEditor().getModel(),getEditor().getModelFile());
				WizardDialog dialog = new WizardDialog(getSite().getShell(),
						wizard);
				dialog.create();
				dialog.open();
			}

		});
	}
}