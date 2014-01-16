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
package org.gnstudio.apdt.model.editor.descriptors;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider.FILTER;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

public abstract class SourceLinkDescriptor extends
		NodeDetailsDescriptor<String> implements ReferenceBrowseSupport {

	public SourceLinkDescriptor() {
		super(NodeDetailsDescriptor.TYPE.REFERENCE);
	}

	public ReferenceBrowseProvider[] getProviders() {

		return new ReferenceBrowseProvider[] { new ReferenceBrowseProvider() {

			public void setup(ModelContext context, IProgressMonitor monitor) {
				// do nothing
			}

			public boolean isSupported(ModelContext context) {
				return true;
			}

			public String getName() {
				return "Resource Link";
			}

			public String browse(FILTER scopeFilter, String filter,
					ModelContext context) {
				ILabelProvider lp = new WorkbenchLabelProvider();
				ITreeContentProvider cp = new WorkbenchContentProvider();

				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
						APDEditorPlugin.getActiveWorkbenchWindow().getShell(),
						lp, cp);
				dialog.setValidator(new ISelectionStatusValidator() {

					public IStatus validate(Object[] selection) {
						if (selection.length == 1) {
							Object obj = selection[0];
							if (obj instanceof IResource
									&& ((IResource) obj).getType() == IResource.FILE) {
								return new Status(IStatus.OK,
										PlatformUI.PLUGIN_ID, IStatus.OK, "",
										null);
							}
						}
						return new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID,
								IStatus.ERROR, "", null);
					}
				});
				dialog.setAllowMultiple(false);
				dialog.setHelpAvailable(false);

				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource selection = null;
				if (getValue() != null) {
					selection = root.findMember(getValue());
				}

				dialog.setInitialSelection(selection);
				dialog.setTitle("Resource"); //$NON-NLS-1$ 
				dialog.setMessage("Select resource to link"); //$NON-NLS-1$ 
				dialog.setInput(root);

				if (dialog.open() == ElementTreeSelectionDialog.OK) {
					Object[] elements = dialog.getResult();
					if (elements.length == 1) {
						return ((IResource) elements[0]).getFullPath()
								.toPortableString();
					}
				}
				return null;
			}
		} };
	}

	public FILTER getFilter() {
		return FILTER.ALL;
	}

	public abstract ModelContext getContext();

	public boolean isSupported() {

		return true;
	}

	@Override
	public void addEditorAssist(Control control) {
		if (control instanceof Text) {
			((Text) control).setEditable(false);
		}
	}
}
