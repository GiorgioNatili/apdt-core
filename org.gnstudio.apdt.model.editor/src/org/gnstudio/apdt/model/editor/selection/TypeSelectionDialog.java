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
package org.gnstudio.apdt.model.editor.selection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.gnstudio.apdt.APDTPlugin;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.nodes.ClassElementNode;
import org.gnstudio.apdt.model.editor.nodes.InterfaceElementNode;

public class TypeSelectionDialog extends FilteredItemsSelectionDialog {
	private static final String DIALOG_SETTINGS = "org.gnstudio.apdt.model.editor.selection.dialogs.TypeSelectionDialog"; //$NON-NLS-1$
	private ReferenceBrowseProvider.FILTER scope;
	private Model model;

	private TypeSelectionDialog(Shell shell, Model model,
			ReferenceBrowseProvider.FILTER scope, String filter) {
		super(shell);
		this.scope = scope;
		this.model = model;
		setListLabelProvider(new TypeLabelProvider());
		setDetailsLabelProvider(new TypeDetailLabelProvider());
		if (filter != null)
			setInitialPattern(filter);
		setTitle("Type");
		setMessage("Enter type name prefix or pattern (*,?):");
	}

	public static TypeSelectionDialog createSearchDialog(Shell shell,
			Model model, ReferenceBrowseProvider.FILTER scope, String filter) {
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
				if (item instanceof Type) {
					Type type = (Type) item;
					return matches(type.getName())
							|| matches(type.getFullyQualifiedName());

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
	protected Comparator<Type> getItemsComparator() {

		return new Comparator<Type>() {

			public int compare(Type arg0, Type arg1) {
				return arg0.getName().compareTo(arg1.getName());
			}
		};
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		boolean addClass = (scope == ReferenceBrowseProvider.FILTER.ALL)
				|| (scope == ReferenceBrowseProvider.FILTER.CLASS);
		boolean addInterface = (scope == ReferenceBrowseProvider.FILTER.ALL)
				|| (scope == ReferenceBrowseProvider.FILTER.INTERFACE);
		List<PackageElement> packages = new ArrayList<PackageElement>();
		EList<Program> programs = model.getPrograms();
		for (Program program : programs) {
			packages.addAll(program.getPackages());
			
		}
        //get model packages
		packages.addAll(model.getPackages());
		
		for (PackageElement pkg : packages) {
			String pkgName = pkg.getName();

			if (addClass) {
				addClasses(contentProvider, itemsFilter, pkg, pkgName);
			}
			if (addInterface) {
				addInterfaces(contentProvider, itemsFilter, pkg, pkgName);
			}

		}
	}

	private void addClasses(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, PackageElement pkg, String pkgName) {
		EList<ClassElement> classes = pkg.getClasses();
		for (ClassElement clazz : classes) {
			String className = clazz.getName();
			if (className != null && className.length() > 0) {
				contentProvider.add(new Type(pkgName, new ClassElementNode(
						null, clazz, null)), itemsFilter);
			}
		}
	}

	private void addInterfaces(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, PackageElement pkg, String pkgName) {
		EList<InterfaceElement> interfaces = pkg.getInterfaces();
		for (InterfaceElement interfaceItem : interfaces) {
			String className = interfaceItem.getName();
			if (className != null && className.length() > 0) {
				contentProvider.add(new Type(pkgName, new InterfaceElementNode(
						null, interfaceItem, null)), itemsFilter);
			}
		}
	}

	@Override
	public String getElementName(Object item) {
		if (item instanceof Type) {
			return ((Type) item).getName();
		}
		return null;
	}

	@Override
	public Type getFirstResult() {
		return (Type) super.getFirstResult();
	}

	private class TypeDetailLabelProvider extends LabelProvider implements
			ILabelProvider {
		@Override
		public Image getImage(Object element) {

			return APDEditorImages.getImage(APDEditorImages.DESC_MODEL_PACKAGE);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof Type) {
				return ((Type) element).getFullyQualifiedName();
			}
			return null;
		}
	}

	private class TypeLabelProvider extends LabelProvider implements
			ILabelProvider,
			DelegatingStyledCellLabelProvider.IStyledLabelProvider {
		public Image getImage(Object element) {
			if (element instanceof Type) {
				return APDEditorImages.getImage(((Type) element).node
						.getImageDescriptor());
			}
			return null;
		}

		@Override
		public String getText(Object element) {
			if (element instanceof Type) {
				return ((Type) element).getName();
			}
			return null;
		}

		public StyledString getStyledText(Object element) {
			StyledString ss = new StyledString();
			if (element instanceof Type) {
				Type type = (Type) element;
				ss.append(type.getName());
				ss.append(" - ", StyledString.QUALIFIER_STYLER);
				ss.append(type.getPkg(), StyledString.QUALIFIER_STYLER);
			}
			return ss;
		}

	}

}
