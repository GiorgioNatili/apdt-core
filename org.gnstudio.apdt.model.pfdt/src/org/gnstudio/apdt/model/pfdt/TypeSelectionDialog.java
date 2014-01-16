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
package org.gnstudio.apdt.model.pfdt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.gnstudio.apdt.APDTPlugin;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;

import com.powerflasher.fdt.core.outermodel.IClassModel;
import com.powerflasher.fdt.core.outermodel.IInterfaceModel;
import com.powerflasher.fdt.core.outermodel.IMasterModel;
import com.powerflasher.fdt.core.outermodel.ITypeModel;
import com.powerflasher.fdt.core.outermodel.ProjectModel;
import com.powerflasher.fdt.ui.FDTLabelProvider;

public class TypeSelectionDialog extends FilteredItemsSelectionDialog {
	private static final String DIALOG_SETTINGS = "org.gnstudio.apdt.model.editor.selection.dialogs.TypeSelectionDialog"; //$NON-NLS-1$
	private ReferenceBrowseProvider.FILTER scope;
	private ProjectModel model;

	private TypeSelectionDialog(Shell shell, ProjectModel model,
			ReferenceBrowseProvider.FILTER scope, String filter) {
		super(shell);
		this.scope = scope;
		this.model = model;
		setListLabelProvider(new FDTLabelProvider());
		setDetailsLabelProvider(new FDTLabelProvider());
		if (filter != null)
			setInitialPattern(filter);
		setTitle("Type");
		setMessage("Enter type name prefix or pattern (*,?):");
	}

	public static TypeSelectionDialog createSearchDialog(Shell shell,
			ProjectModel model, ReferenceBrowseProvider.FILTER scope,
			String filter) {
		return new TypeSelectionDialog(shell, model, scope, filter);
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = APDTPlugin.getDefault().getDialogSettings()
				.getSection(DIALOG_SETTINGS);

		if (settings == null) {
			settings = APDTPlugin.getDefault().getDialogSettings()
					.addNewSection(DIALOG_SETTINGS);
		}

		return settings;
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected ItemsFilter createFilter() {
		return new ItemsFilter() {

			@Override
			public boolean matchItem(Object item) {
				if (item instanceof IMasterModel) {
					IMasterModel type = (IMasterModel) item;
					return matches(type.getName())
							|| matches(type.getQualifiedName());

				}
				return false;
			}

			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}
		};
	}

	@Override
	protected Comparator<IMasterModel> getItemsComparator() {

		return new Comparator<IMasterModel>() {

			public int compare(IMasterModel arg0, IMasterModel arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		};
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		List<ITypeModel> itms = new ArrayList<ITypeModel>();
		switch (scope) {
		case CLASS: {
			Collection<IClassModel> classes = model
					.getAllModels(IClassModel.class);
			itms.addAll(classes);
			break;
		}
		case INTERFACE: {
			Collection<IInterfaceModel> interfaces = model
					.getAllModels(IInterfaceModel.class);
			itms.addAll(interfaces);
			break;
		}
		default: {
			Collection<IClassModel> classes = model
					.getAllModels(IClassModel.class);
			itms.addAll(classes);
			Collection<IInterfaceModel> interfaces = model
					.getAllModels(IInterfaceModel.class);
			itms.addAll(interfaces);
		}
		}
		for (ITypeModel iTypeModel : itms) {
			contentProvider.add(iTypeModel, itemsFilter);
		}

	}

	@Override
	public String getElementName(Object item) {
		if (item instanceof IMasterModel) {
			return ((IMasterModel) item).getName();
		}
		return null;
	}

	@Override
	public IMasterModel getFirstResult() {
		return (IMasterModel) super.getFirstResult();
	}

}
