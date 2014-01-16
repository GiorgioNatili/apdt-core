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

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.APDTPlugin;
import org.gnstudio.apdt.APDTUIConstants;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.editor.pages.DesignPage;
import org.gnstudio.apdt.model.editor.pages.OverviewPage;
import org.gnstudio.apdt.model.util.ModelOperation;
import org.gnstudio.apdt.model.util.ModelOperationException;

public class APDModelEditor extends FormEditor {

	private Model model;
	private boolean dirty;
	private APDFileMonitor fileMonitor;
	private OverviewPage overviewPage;

	@Override
	protected void addPages() {
		setActiveEditor(this);
		setPartName(getEditorInput().getName());
		// add basic pages
		try {
			addPage(overviewPage = new OverviewPage(this));
			addPage(new DesignPage(this));
		} catch (PartInitException ex) {
			APDTLog.log(ex);
		}
		// try to get contributed parts
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						EditorPageProvider.EXTENSION_POINT_ID);

		try {
			for (IConfigurationElement element : config) {
				final Object impl = element.createExecutableExtension("class");
				if (impl instanceof EditorPageProvider) {
					EditorPageProvider pageProvider = (EditorPageProvider) impl;
					for (AbstractEditorPage page : pageProvider
							.createPages(this)) {
						try {
							addPage(page);
						} catch (PartInitException ex) {
							APDTLog.log(ex);
						}
					}
				}
			}
		} catch (CoreException ex) {
			APDTLog.log(ex);
		}

		setActivePage(DesignPage.PAGE_ID);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		commitPages(true);
		dirty = false;
		Model model = getModel();
		if(model.getAuthor()==null){
			model.setCreated(new Date());
			model.setAuthor(APDEditorPlugin
				.getDefault()
				.getPreferenceStore()
				.getString(
						APDTUIConstants.PREFERENCES_MODEL_DISCUSSION_AUTHOR));
		}
		model.setUpdated(new Date());
		model.setUpdatedBy(APDEditorPlugin
			.getDefault()
			.getPreferenceStore()
			.getString(
					APDTUIConstants.PREFERENCES_MODEL_DISCUSSION_AUTHOR));
		
		IFile modelFile = getModelFile();
		try {
			setFileMonitor(false);
			if (modelFile != null) {
				ModelOperation.writeModel(model, modelFile);
			} else {
				// try to load External file base on input
				File externalModelFile = getExternalModelFile();
				if (externalModelFile == null) {
					APDTLog.logErrorMessage("modelFile is null");
					return;
				}
				ModelOperation.writeModel(model, externalModelFile);
			}
		} catch (ModelOperationException e) {
			APDTLog.log(e);
		} catch (IOException e) {
			APDTLog.log(e);
		} finally {
			if(overviewPage!=null)
				overviewPage.refresh();
			setFileMonitor(true);
		}
		editorDirtyStateChanged();
	}

	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());

		saveAsDialog.setOriginalFile(getModelFile());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {

			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				//remove old file change monitor
				if (fileMonitor != null) {
					APDTPlugin.getWorkspace().removeResourceChangeListener(
							fileMonitor);
				}
				setInput(new FileEditorInput(file));
				setPartName(getEditorInput().getName());
				doSave(new NullProgressMonitor());
			}
		}

	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.editor.FormEditor#isDirty()
	 */
	public boolean isDirty() {
		return dirty || super.isDirty();
	}

	protected void setDirty(boolean dirty) {
		this.dirty = this.dirty || dirty;
		editorDirtyStateChanged();
	}

	private void setFileMonitor(boolean enable) {
		if (fileMonitor != null)
			fileMonitor.enable = enable;
	}

	/**
	 * Returns the APD model backing this editor
	 * 
	 * @return APD model
	 */
	public Model getModel() {
		if (model == null) {
			IFile modelFile = getModelFile();
			try {
				if (modelFile != null) {

					model = ModelOperation.readModel(modelFile);

				} else {
					// try to load External file base on input
					File externalModelFile = getExternalModelFile();
					if (externalModelFile != null && externalModelFile.exists())
						model = ModelOperation.readModel(externalModelFile);
				}
			} catch (ModelOperationException e) {
				APDTLog.log(e);
			}
			if (model == null) {
				model = ModelFactory.eINSTANCE.createModel();
				
			}
			
			
		}

		return model;
	}

	public IFile getModelFile() {
		IEditorInput input = getEditorInput();
		IFile modelFile = null;
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileEditorInput = (IFileEditorInput) input;
			modelFile = fileEditorInput.getFile();
			// hook file with monitor
			if (modelFile != null && fileMonitor == null) {
				fileMonitor = new APDFileMonitor(modelFile);
				APDTPlugin.getWorkspace().addResourceChangeListener(
						fileMonitor, IResourceChangeEvent.POST_CHANGE);
			}
		}

		return modelFile;
	}

	/**
	 * External model file
	 * 
	 * @return
	 */
	public File getExternalModelFile() {
		IEditorInput input = getEditorInput();
		File modelFile = null;
		if (input instanceof IURIEditorInput) {
			IURIEditorInput iuriEditorInput = (IURIEditorInput) input;
			modelFile = URIUtil.toFile(iuriEditorInput.getURI());
		}

		return modelFile;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (IContentOutlinePage.class.equals(adapter)) {
			IFormPage activePageInstance = getActivePageInstance();
			if (activePageInstance instanceof AbstractEditorPage) {
				return ((AbstractEditorPage) activePageInstance)
						.getContentOutlinePage();
			}

		}
		return super.getAdapter(adapter);
	}

	@Override
	public void dispose() {
		if (fileMonitor != null) {
			APDTPlugin.getWorkspace().removeResourceChangeListener(fileMonitor);
		}
		super.dispose();
	}

	private void resetModel() {
		model = null;
		// remove fileMonitor
		if (fileMonitor != null) {
			APDTPlugin.getWorkspace().removeResourceChangeListener(fileMonitor);
			fileMonitor = null;
		}

		// call getModel() reload model and hook fileMonitor
		getModel();
	}

	private void refresh() {

		// mark model reload
		resetModel();
		for (Object page : pages) {
			if (page instanceof AbstractEditorPage) {
				((AbstractEditorPage) page).refresh();
			}
		}
		// when refresh remove all pending changes
		dirty = false;
		editorDirtyStateChanged();

	}

	/**
	 * Resource change listener for the .apd file input to this editor in case
	 * it is deleted or moved.
	 */
	private class APDFileMonitor implements IResourceChangeListener,
			IResourceDeltaVisitor {
		IFile apdfile;
		boolean enable = true;

		public APDFileMonitor(IFile apdfile) {
			this.apdfile = apdfile;
		}

		public void resourceChanged(IResourceChangeEvent event) {
			if (enable) {
				IResourceDelta delta = event.getDelta();

				try {
					delta.accept(this);
				} catch (CoreException e) {
					APDTLog.logException(e);
				}
			}

		}

		public boolean visit(IResourceDelta delta) throws CoreException {
			// if monitor not enable do not continue
			if (!enable) {
				return false;
			}
			IResource resource = delta.getResource();
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if (file.equals(apdfile)) {
					switch (delta.getKind()) {
					case IResourceDelta.REMOVED:
					case IResourceDelta.REPLACED: {
						Display display = getSite().getShell().getDisplay();
						display.asyncExec(new Runnable() {
							public void run() {
								// file has been deleted/moved close editor
								getSite().getPage().closeEditor(
										APDModelEditor.this, false);
							}
						});
						break;
					}
					case IResourceDelta.CHANGED: {
						if ((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
							Display display = getSite().getShell().getDisplay();
							display.asyncExec(new Runnable() {
								public void run() {
									refresh();
								}
							});
						}
						break;
					}
					}

					return false;
				}
			}
			return true;
		}
	}

	public APDEditorActionBarContributor getContributor() {
		return (APDEditorActionBarContributor) getEditorSite()
				.getActionBarContributor();
	}
}
