/*******************************************************************************
 * Copyright (c) 2010, 2012 GNstudio s.r.l. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 *
 * NOTE: to avoid internal api usage this impl is base on
 * org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup with minor changes
 *******************************************************************************/
package org.gnstudio.apdt.model.editor.export;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.DrillDownComposite;

public class TargetSelectionGroup extends Composite {
	// The listener to notify of events
	private Listener listener;

	// Enable user to type in new container name
	private boolean allowNewContainerName = true;

	// show all projects by default
	private boolean showClosedProjects = true;

	// Last selection made by user
	private IContainer selectedContainer;

	// handle on parts
	private Text containerNameField;

	TreeViewer treeViewer;

	// sizing constants
	private static final int SIZING_SELECTION_PANE_WIDTH = 320;

	private static final int SIZING_SELECTION_PANE_HEIGHT = 300;

	/**
	 * Creates a new instance of the widget.
	 * 
	 * @param parent
	 *            The parent widget of the group.
	 * @param listener
	 *            A listener to forward events to. Can be null if no listener is
	 *            required.
	 * @param allowNewContainerName
	 *            Enable the user to type in a new container name instead of
	 *            just selecting from the existing ones.
	 */
	public TargetSelectionGroup(Composite parent, Listener listener,
			boolean allowNewContainerName) {
		this(parent, listener, allowNewContainerName, null);
	}

	/**
	 * Creates a new instance of the widget.
	 * 
	 * @param parent
	 *            The parent widget of the group.
	 * @param listener
	 *            A listener to forward events to. Can be null if no listener is
	 *            required.
	 * @param allowNewContainerName
	 *            Enable the user to type in a new container name instead of
	 *            just selecting from the existing ones.
	 * @param message
	 *            The text to present to the user.
	 */
	public TargetSelectionGroup(Composite parent, Listener listener,
			boolean allowNewContainerName, String message) {
		this(parent, listener, allowNewContainerName, message, true);
	}

	/**
	 * Creates a new instance of the widget.
	 * 
	 * @param parent
	 *            The parent widget of the group.
	 * @param listener
	 *            A listener to forward events to. Can be null if no listener is
	 *            required.
	 * @param allowNewContainerName
	 *            Enable the user to type in a new container name instead of
	 *            just selecting from the existing ones.
	 * @param message
	 *            The text to present to the user.
	 * @param showClosedProjects
	 *            Whether or not to show closed projects.
	 */
	public TargetSelectionGroup(Composite parent, Listener listener,
			boolean allowNewContainerName, String message,
			boolean showClosedProjects) {
		this(parent, listener, allowNewContainerName, message,
				showClosedProjects, SIZING_SELECTION_PANE_HEIGHT,
				SIZING_SELECTION_PANE_WIDTH);
	}

	/**
	 * Creates a new instance of the widget.
	 * 
	 * @param parent
	 *            The parent widget of the group.
	 * @param listener
	 *            A listener to forward events to. Can be null if no listener is
	 *            required.
	 * @param allowNewContainerName
	 *            Enable the user to type in a new container name instead of
	 *            just selecting from the existing ones.
	 * @param message
	 *            The text to present to the user.
	 * @param showClosedProjects
	 *            Whether or not to show closed projects.
	 * @param heightHint
	 *            height hint for the drill down composite
	 * @param widthHint
	 *            width hint for the drill down composite
	 */
	public TargetSelectionGroup(Composite parent, Listener listener,
			boolean allowNewContainerName, String message,
			boolean showClosedProjects, int heightHint, int widthHint) {
		super(parent, SWT.NONE);
		this.listener = listener;
		this.allowNewContainerName = allowNewContainerName;
		this.showClosedProjects = showClosedProjects;
		if (message != null) {
			createContents(message, heightHint, widthHint);
		}
	}

	/**
	 * The container selection has changed in the tree view. Update the
	 * container name field value and notify all listeners.
	 * 
	 * @param container
	 *            The container that changed
	 */
	public void containerSelectionChanged(IContainer container) {
		selectedContainer = container;

		if (allowNewContainerName) {
			if (container == null) {
				containerNameField.setText("");//$NON-NLS-1$
			} else {
				String text = TextProcessor.process(container.getFullPath()
						.makeRelative().toString());
				containerNameField.setText(text);
				containerNameField.setToolTipText(text);
			}
		}

		// fire an event so the parent can update its controls
		if (listener != null) {
			Event changeEvent = new Event();
			changeEvent.type = SWT.Selection;
			changeEvent.widget = this;
			listener.handleEvent(changeEvent);
		}
	}

	/**
	 * Creates the contents of the composite.
	 * 
	 * @param message
	 */
	public void createContents(String message) {
		createContents(message, SIZING_SELECTION_PANE_HEIGHT,
				SIZING_SELECTION_PANE_WIDTH);
	}

	/**
	 * Creates the contents of the composite.
	 * 
	 * @param message
	 * @param heightHint
	 * @param widthHint
	 */
	public void createContents(String message, int heightHint, int widthHint) {
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		setLayout(layout);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label label = new Label(this, SWT.WRAP);
		label.setText(message);
		label.setFont(this.getFont());

		if (allowNewContainerName) {
			containerNameField = new Text(this, SWT.SINGLE | SWT.BORDER);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.widthHint = widthHint;
			containerNameField.setLayoutData(gd);
			containerNameField.addListener(SWT.Modify, listener);
			containerNameField.setFont(this.getFont());
		}

		createTreeViewer(heightHint);
		Dialog.applyDialogFont(this);
	}

	/**
	 * Returns a new drill down viewer for this dialog.
	 * 
	 * @param heightHint
	 *            height hint for the drill down composite
	 */
	protected void createTreeViewer(int heightHint) {
		// Create drill down.
		DrillDownComposite drillDown = new DrillDownComposite(this, SWT.BORDER);
		GridData spec = new GridData(SWT.FILL, SWT.FILL, true, true);
		spec.widthHint = SIZING_SELECTION_PANE_WIDTH;
		spec.heightHint = heightHint;
		drillDown.setLayoutData(spec);

		// Create tree viewer inside drill down.
		treeViewer = new TreeViewer(drillDown, SWT.NONE);
		drillDown.setChildTree(treeViewer);
		ContainerContentProvider cp = new ContainerContentProvider();
		cp.showClosedProjects(showClosedProjects);
		treeViewer.setContentProvider(cp);
		treeViewer.setLabelProvider(WorkbenchLabelProvider
				.getDecoratingWorkbenchLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		treeViewer.setUseHashlookup(true);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				containerSelectionChanged((IContainer) selection
						.getFirstElement()); // allow null
			}
		});
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object item = ((IStructuredSelection) selection)
							.getFirstElement();
					if (item == null) {
						return;
					}
					if (treeViewer.getExpandedState(item)) {
						treeViewer.collapseToLevel(item, 1);
					} else {
						treeViewer.expandToLevel(item, 1);
					}
				}
			}
		});

		// This has to be done after the viewer has been laid out
		treeViewer.setInput(ResourcesPlugin.getWorkspace());
	}

	/**
	 * Returns the currently entered container name. Null if the field is empty.
	 * Note that the container may not exist yet if the user entered a new
	 * container name in the field.
	 * 
	 * @return IPath
	 */
	public IPath getContainerFullPath() {
		if (allowNewContainerName) {
			String pathName = containerNameField.getText();
			if (pathName == null || pathName.length() < 1) {
				return null;
			}
			// The user may not have made this absolute so do it for them
			return (new Path(TextProcessor.deprocess(pathName))).makeAbsolute();

		}
		if (selectedContainer == null)
			return null;
		return selectedContainer.getFullPath();

	}

	/**
	 * Gives focus to one of the widgets in the group, as determined by the
	 * group.
	 */
	public void setInitialFocus() {
		if (allowNewContainerName) {
			containerNameField.setFocus();
		} else {
			treeViewer.getTree().setFocus();
		}
	}

	/**
	 * Sets the selected existing container.
	 * 
	 * @param container
	 */
	public void setSelectedContainer(IContainer container) {
		selectedContainer = container;

		// expand to and select the specified container
		List<IContainer> itemsToExpand = new ArrayList<IContainer>();
		IContainer parent = container.getParent();
		while (parent != null) {
			itemsToExpand.add(0, parent);
			parent = parent.getParent();
		}
		treeViewer.setExpandedElements(itemsToExpand.toArray());
		treeViewer.setSelection(new StructuredSelection(container), true);
	}

	class ContainerContentProvider implements ITreeContentProvider {
		private boolean showClosedProjects = true;

		/**
		 * Creates a new ContainerContentProvider.
		 */
		public ContainerContentProvider() {
		}

		/**
		 * The visual part that is using this content provider is about to be
		 * disposed. Deallocate all allocated SWT resources.
		 */
		public void dispose() {
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang
		 * .Object)
		 */
		public Object[] getChildren(Object element) {
			if (element instanceof IWorkspace) {
				// check if closed projects should be shown
				IProject[] allProjects = ((IWorkspace) element).getRoot()
						.getProjects();
				if (showClosedProjects) {
					return allProjects;
				}

				List<IProject> accessibleProjects = new ArrayList<IProject>();
				for (int i = 0; i < allProjects.length; i++) {
					if (allProjects[i].isOpen()) {
						accessibleProjects.add(allProjects[i]);
					}
				}
				return accessibleProjects.toArray();
			} else if (element instanceof IContainer) {
				IContainer container = (IContainer) element;
				if (container.isAccessible()) {
					try {
						List<IResource> children = new ArrayList<IResource>();
						IResource[] members = container.members();
						for (int i = 0; i < members.length; i++) {
							if (members[i].getType() != IResource.FILE) {
								children.add(members[i]);
							}
						}
						return children.toArray();
					} catch (CoreException e) {
						// this should never happen because we call
						// #isAccessible before invoking #members
					}
				}
			}
			return new Object[0];
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
		 * java.lang.Object)
		 */
		public Object[] getElements(Object element) {
			return getChildren(element);
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang
		 * .Object)
		 */
		public Object getParent(Object element) {
			if (element instanceof IResource) {
				return ((IResource) element).getParent();
			}
			return null;
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang
		 * .Object)
		 */
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		/*
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * Specify whether or not to show closed projects in the tree viewer.
		 * Default is to show closed projects.
		 * 
		 * @param show
		 *            boolean if false, do not show closed projects in the tree
		 */
		public void showClosedProjects(boolean show) {
			showClosedProjects = show;
		}
	}
}
