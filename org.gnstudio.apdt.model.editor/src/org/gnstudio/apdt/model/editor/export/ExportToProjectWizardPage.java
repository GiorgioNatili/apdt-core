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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.gnstudio.apdt.APDTImages;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;

public class ExportToProjectWizardPage extends WizardPage {
	private static final String PATH = "ExportToProjectWizardPage.outputPath";//$NON-NLS-1$;

	public final static String PAGE_NAME = "org.gnstudio.apdt.model.editor.export.exportPage";
	public final static String PROVIDER_ID = "org.gnstudio.apdt.model.editor.export.providerId";

	private ComboViewer comboViewer = null;
	private TargetSelectionGroup targetGroup;

	public ExportToProjectWizardPage() {
		super(PAGE_NAME, "Export To Project", APDTImages.DESC_EXPORT_MODEL_WIZ);
		setPageComplete(false);
	}

	/**
	 * Create the widgets on the page
	 */
	public void createControl(Composite parent) {
		try {
			final Composite container = new Composite(parent, SWT.NONE);
			final GridLayout layout = new GridLayout(1, false);
			container.setLayout(layout);
			createTargetSelection(container);
			createExportSelection(container);
			setControl(container);
			setPageComplete(validate());
		} catch (final RuntimeException e) {
			e.printStackTrace();
		}
	}

	private void createTargetSelection(final Composite container) {
		// target dir selection
		Listener listener = new Listener() {
			public void handleEvent(Event event) {

				setPageComplete(validate());

			}
		};
		targetGroup = new TargetSelectionGroup(container, listener, false,
				"Specify the Target folder :", false);

		try {
			IPath path = Path.fromPortableString(APDEditorPlugin.getDefault()
					.getPreferenceStore().getString(PATH));
			IResource resource = ResourcesPlugin.getWorkspace().getRoot()
					.findMember(path);
			final IContainer folder = ResourcesPlugin.getWorkspace().getRoot()
					.getContainerForLocation(resource.getLocation());
			if (folder != null) {
				targetGroup.setSelectedContainer(folder);
			}
		} catch (Exception e) {
			// ignore
		}
	}

	private void createExportSelection(final Composite container) {
		// add export provider selection
		new Label(container, SWT.NONE).setText("Export Provider :");
		comboViewer = new ComboViewer(container);
		comboViewer.getCombo().setLayoutData(
				new GridData(GridData.FILL_HORIZONTAL));
		comboViewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof ModelExportProvider) {
					return ((ModelExportProvider) element).getProviderName();
				}
				return super.getText(element);
			}

		});
		final List<ModelExportProvider> exportProviders = new ArrayList<ModelExportProvider>();
		comboViewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				exportProviders.clear();
				IConfigurationElement[] config = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								ModelExportProvider.EXTENSION_POINT_ID);

				try {
					for (IConfigurationElement element : config) {
						final Object impl = element
								.createExecutableExtension("class");
						if (impl instanceof ModelExportProvider) {
							exportProviders.add((ModelExportProvider) impl);

						}
					}
				} catch (CoreException ex) {
					APDTLog.log(ex);
				}
				return exportProviders.toArray();
			}
		});
		comboViewer.setInput(new Object());
		String lastProvider = APDEditorPlugin.getDefault().getPreferenceStore()
				.getString(PROVIDER_ID);
		if (lastProvider != null && lastProvider.length() > 0)
			for (ModelExportProvider provider : exportProviders) {
				if (provider.getProviderId().equals(lastProvider)) {
					comboViewer.setSelection(new StructuredSelection(provider));
					break;
				}
			}

		if (comboViewer.getCombo().getItemCount() > 0
				&& comboViewer.getCombo().getSelectionIndex() == -1)
			comboViewer.getCombo().select(0);
	}

	/** Returns the directory where data files are to be saved */
	public IResource getDestinationDirectory() {
		IPath targetPath = targetGroup.getContainerFullPath();
		assert targetPath instanceof IFolder : "Output Detractory should exists";
		IResource resource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(targetPath);
		return resource;
	}

	public ModelExportProvider getModelExportProvider() {
		if (comboViewer != null
				&& comboViewer.getSelection() instanceof IStructuredSelection)
			return (ModelExportProvider) ((IStructuredSelection) comboViewer
					.getSelection()).getFirstElement();

		return null;
	}

	@Override
	public String getName() {
		return PAGE_NAME;
	}

	/** Returns true if the information entered by the user is valid */
	protected boolean validate() {
		setMessage("export model  into a target folder");
		setErrorMessage(null);

		IPath targetPath = targetGroup.getContainerFullPath();
		if (targetPath == null
				|| ResourcesPlugin.getWorkspace().getRoot()
						.findMember(targetPath) == null) {
			setErrorMessage("Please select valid target folder");
			return false;
		} else
			APDEditorPlugin.getDefault().getPreferenceStore()
					.putValue(PATH, targetPath.toPortableString());

		if (getModelExportProvider() == null) {
			setErrorMessage("Export Provider not available");
			return false;
		}

		return true;
	}

}
