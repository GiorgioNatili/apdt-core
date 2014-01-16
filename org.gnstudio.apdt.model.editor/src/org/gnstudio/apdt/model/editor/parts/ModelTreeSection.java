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
package org.gnstudio.apdt.model.editor.parts;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.progress.WorkbenchJob;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.gnstudio.apdt.APDTImages;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.APDModelEditor;
import org.gnstudio.apdt.model.editor.EditorLayoutFactory;
import org.gnstudio.apdt.model.editor.handlers.ModelElementDeleteHandler;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeActions;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.ProgramNode;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeDragAdapter;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Movable;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeTransfer;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeViewDropAdapter;
import org.gnstudio.apdt.model.editor.nodes.sequence.SequenceNode;
import org.gnstudio.apdt.model.editor.operations.OperationSupport;
import org.gnstudio.apdt.model.editor.snippets.SnippetUtil;

public class ModelTreeSection extends SectionPart {
	private static final int EXPAND_LEVEL = 2;
	private APDModelEditor editor;
	private FilteredTree filteredTree;
	private final ModelContext modelContext = new ContextProvider();
	private NodeDeatilsViewer deatilsViewer;
	private OutlinePage outlinePage;
	private final OperationSupport operationSupport;
	private Menu addElementMenu;

	public ModelTreeSection(APDModelEditor editor, FormPage page,
			Composite parent, OperationSupport operationSupport) {
		super(parent, page.getManagedForm().getToolkit(), Section.DESCRIPTION
				| ExpandableComposite.TITLE_BAR);
		this.editor = editor;
		this.operationSupport = operationSupport;
		buildBody(getSection(), page.getEditor().getToolkit());
		createSectionToolbar(getSection(), page.getEditor().getToolkit());

	}

	public void setDeatilsViewer(NodeDeatilsViewer deatilsViewer) {
		this.deatilsViewer = deatilsViewer;
	}

	public ModelContext getModelContext() {
		return modelContext;
	}

	protected Model getModel() {
		return editor.getModel();
	}

	public OutlinePage getOutlinePage() {
		return outlinePage;
	}

	@Override
	public void refresh() {
		TreeViewer treeview = filteredTree.getViewer();
		Object[] expanded = treeview.getExpandedElements();

		treeview.getControl().setRedraw(false);
		treeview.setInput(getModel());
		treeview.setExpandedElements(expanded);
		treeview.getControl().setRedraw(true);
		treeview.refresh();
		getManagedForm().fireSelectionChanged(ModelTreeSection.this,
				treeview.getSelection());
		showNodeDetails();
		outlinePage.refresh();
		super.refresh();
	}

	@Override
	public void setFocus() {
		if (filteredTree != null)
			filteredTree.getViewer().getControl().setFocus();
	}

	protected void buildBody(Section section, FormToolkit toolkit) {
		section.setLayout(EditorLayoutFactory.createClearTableWrapLayout(false,
				1));
		GridData sectionData = new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL);
		section.setLayoutData(sectionData);

		section.setText(APDEditorMessages.TreeSection_title);
		section.setDescription(APDEditorMessages.TreeSection_dec);

		Composite body = toolkit.createComposite(section);
		body.setLayout(EditorLayoutFactory.createSectionClientGridLayout(false,
				2));
		body.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL));

		filteredTree = new FilteredTree(body, SWT.VIRTUAL | SWT.V_SCROLL
				| SWT.BORDER | SWT.MULTI, new PatternFilter(), true) {

			// Workaround to support Ticket #252
			ISelection selection;
			Object[] expanded;

			protected WorkbenchJob doCreateRefreshJob() {
				WorkbenchJob refreshJob2 = super.doCreateRefreshJob();
				refreshJob2.addJobChangeListener(new JobChangeAdapter() {
					public void done(IJobChangeEvent event) {
						if (!event.getResult().isOK())
							return;

						String text = getFilterString();
						if (text != null && text.length() > 0)
							return;

						TreeViewer treeview = getViewer();
						if (expanded != null) {
							treeview.getControl().setRedraw(false);
							treeview.setExpandedElements(expanded);
							treeview.getControl().setRedraw(true);

							expanded = null;
						}
						if (selection != null) {
							getViewer().setSelection(selection, true);
							getManagedForm().fireSelectionChanged(
									ModelTreeSection.this, selection);
							selection = null;
						}
					};
				});
				return refreshJob2;

			};

			protected void textChanged() {
				if (selection == null)
					selection = getViewer().getSelection();

				if (expanded == null)
					expanded = getViewer().getExpandedElements();

				super.textChanged();

			}
		};

		GridData treeGD = new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL);
		treeGD.widthHint = 200;
		treeGD.heightHint = 100;
		filteredTree.setLayoutData(treeGD);
		final TreeViewer viewer = filteredTree.getViewer();
		viewer.setLabelProvider(new NodeStyledCellLabelProvider(
				new TreeLabelProvider()));
		viewer.setContentProvider(new TreeContent());
		new ViewerToolTipSupport(viewer);
		viewer.setAutoExpandLevel(EXPAND_LEVEL);
		viewer.setInput(getModel());
		outlinePage = new OutlinePage();
		editor.getSite().setSelectionProvider(viewer);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				showNodeDetails();
				if (outlinePage.isLinked())
					outlinePage.setSelection(viewer.getSelection());

				_showNodeNote();
				editor.getContributor().refreah();
			}

			private void _showNodeNote() {
				IActionBars actionBars = editor.getContributor().getActionBars();
				if(actionBars!=null){
					AbstractNode<?> node = getSelectedNode();
					
					if(node!=null ){
						actionBars.getStatusLineManager().setMessage(APDTImages.getImage(node.getImageDescriptor()),
									node.getName());
					}
						
				}
			}

		});

		// connect outline view
		outlinePage
				.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						if (outlinePage.isLinked())
							viewer.setSelection(outlinePage.getSelection());
					}

				});
		// add default double click support to tree
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				boolean expandedState = viewer.getExpandedState(selection
						.getFirstElement());
				viewer.setExpandedState(selection.getFirstElement(),
						!expandedState);

			}
		});

		// see #193
		viewer.getTree().addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				TreeItem item = viewer.getTree().getItem(point);
				if (item == null) {
					viewer.setSelection(null);
				}
			}
		});

		// node move via DND
		Transfer[] transfers = new Transfer[] { NodeTransfer.getInstance() };
		viewer.addDragSupport(DND.DROP_LINK | DND.DROP_MOVE | DND.DROP_COPY,
				new Transfer[] { NodeTransfer.getInstance() },
				new NodeDragAdapter(viewer));

		DropTarget dropTaget = new DropTarget(viewer.getControl(),
				DND.DROP_LINK | DND.DROP_COPY | DND.DROP_MOVE);
		dropTaget.setTransfer(transfers);
		dropTaget
				.addDropListener(new NodeViewDropAdapter(modelContext, viewer));

		connectContextMenu();
		connectAddContextMenu();
		toolkit.paintBordersFor(body);
		section.setTabList(new Control[] { body });
		section.setClient(body);

	}

	private void createSectionToolbar(Section section, FormToolkit toolkit) {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		final ToolBar toolbar = toolBarManager.createControl(section);
		final Cursor handCursor = new Cursor(Display.getCurrent(),
				SWT.CURSOR_HAND);
		toolbar.setCursor(handCursor);
		// Cursor needs to be explicitly disposed
		toolbar.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if ((handCursor != null) && (handCursor.isDisposed() == false)) {
					handCursor.dispose();
				}
			}
		});

		// create add item Action
		MenuManager popupMenuManager = new MenuManager();
		IMenuListener listener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager mng) {
				fillContextMenu(mng, modelContext, filteredTree.getViewer(),
						true);
				// if empty, add dummy action item show no actions available
				if (mng.getItems().length == 0) {
					mng.add(new Action("no actions available") {
					});
				}
			}
		};
		popupMenuManager.addMenuListener(listener);
		popupMenuManager.setRemoveAllWhenShown(true);
		final Menu menu = popupMenuManager.createContextMenu(toolbar);

		Action addAction = new Action(
				APDEditorMessages.TreeNodeAction_add_item,
				IAction.AS_DROP_DOWN_MENU) {

			@Override
			public void runWithEvent(Event event) {

				Rectangle rect = event.getBounds();
				Point pt;
				if (event.detail != SWT.ARROW)
					pt = new Point(rect.x, rect.y + toolbar.getBounds().height);
				else
					pt = new Point(rect.x, rect.y + rect.height);
				pt = toolbar.toDisplay(pt);
				menu.setLocation(pt.x, pt.y);
				menu.setVisible(true);
			}

		};
		addAction.setImageDescriptor(APDEditorImages.DESC_ADD_ITEM);
		toolBarManager.add(addAction);
		final ModelElementDeleteHandler deleteHandler = new ModelElementDeleteHandler(
				getModelContext(), getISelectionProvider());

		// create delete Action
		final Action deleteAction = new Action(
				APDEditorMessages.TreeNodeAction_delete, IAction.AS_PUSH_BUTTON) {

			@Override
			public void run() {
				deleteHandler.excecute();
			}

		};
		deleteAction.setImageDescriptor(APDEditorImages.DESC_DELETE_ITEM);
		deleteAction
				.setDisabledImageDescriptor(APDEditorImages.DESC_DELETE_ITEM_DISABLED);
		deleteAction.setEnabled(false);
		toolBarManager.add(deleteAction);

		toolBarManager.add(new Separator());
		// create expand Action
		final Action expnadAllAction = new Action(
				APDEditorMessages.TreeNodeAction_expand_all,
				IAction.AS_PUSH_BUTTON) {

			@Override
			public void run() {
				expandNodes();
			}

		};
		expnadAllAction.setImageDescriptor(APDEditorImages.DESC_EXPAND_ALL);
		toolBarManager.add(expnadAllAction);
		// create collapse Action
		final Action collapseAllAction = new Action(
				APDEditorMessages.TreeNodeAction_collapse_all,
				IAction.AS_PUSH_BUTTON) {

			@Override
			public void run() {
				collapseNodes();
			}
		};
		collapseAllAction.setImageDescriptor(APDEditorImages.DESC_COLLAPSE_ALL);
		toolBarManager.add(collapseAllAction);

		toolBarManager.update(true);

		// update toolbar depend on context
		assert filteredTree != null;
		filteredTree.getViewer().addSelectionChangedListener(
				new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						// validate can delete
						deleteAction.setEnabled(deleteHandler.isEnable());
						AbstractNode<?> node = getSelectedNode(filteredTree
								.getViewer());
						if (node != null) {

							collapseAllAction
									.setText(APDEditorMessages.TreeNodeAction_collapse);
							expnadAllAction
									.setText(APDEditorMessages.TreeNodeAction_expand);
						} else {
							collapseAllAction
									.setText(APDEditorMessages.TreeNodeAction_collapse_all);
							expnadAllAction
									.setText(APDEditorMessages.TreeNodeAction_expand_all);
						}

					}
				});

		section.setTextClient(toolbar);
	}

	private void showNodeDetails() {
		if (deatilsViewer != null) {
			AbstractNode<?> node = null;
			ISelection selection = filteredTree.getViewer().getSelection();
			IStructuredSelection strutruredSelection = (IStructuredSelection) selection;
			if (strutruredSelection.size() == 1
					&& strutruredSelection.getFirstElement() instanceof AbstractNode<?>) {
				node = (AbstractNode<?>) strutruredSelection.getFirstElement();
			}
			deatilsViewer.showDetails(modelContext, node);
		}
	}

	private void connectAddContextMenu() {
		MenuManager popupMenuManager = new MenuManager();
		IMenuListener listener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager mng) {
				fillContextMenu(mng, modelContext, filteredTree.getViewer(),
						true);
				// if empty, add dummy action item show no actions available
				if (mng.getItems().length == 0) {
					mng.add(new Action("no actions available") {
					});
				}
			}
		};
		popupMenuManager.addMenuListener(listener);
		popupMenuManager.setRemoveAllWhenShown(true);
		addElementMenu = popupMenuManager.createContextMenu(filteredTree);
	}

	private void connectContextMenu() {
		MenuManager popupMenuManager = new MenuManager();
		IMenuListener listener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager mng) {
				fillContextMenu(mng, modelContext, filteredTree.getViewer(),
						false);
			}
		};
		popupMenuManager.addMenuListener(listener);
		popupMenuManager.setRemoveAllWhenShown(true);
		Control control = filteredTree.getViewer().getControl();
		Menu menu = popupMenuManager.createContextMenu(control);
		control.setMenu(menu);

	}

	public void showContextAddMenu() {
		if (addElementMenu != null && !addElementMenu.isDisposed()) {

			TreeItem[] selection = filteredTree.getViewer().getTree()
					.getSelection();
			Point pt;
			if (selection.length > 0) {
				Rectangle rect = selection[0].getBounds();
				pt = new Point((rect.x + 5), (rect.y + rect.height));
			} else {
				Rectangle rect = filteredTree.getViewer().getTree().getBounds();
				pt = new Point((rect.x + rect.width) / 2,
						(rect.y + rect.height) / 2);
			}

			pt = filteredTree.getViewer().getTree().toDisplay(pt);
			addElementMenu.setLocation(pt);

			addElementMenu.setVisible(true);

		}
	}

	protected void fillContextMenu(IMenuManager manager,
			final ModelContext modelContext, Viewer viewer, boolean addMode) {

		final AbstractNode<?> node = getSelectedNode(viewer);
		if (node != null) {
			if (node.getParent() == null
					&& modelContext.isRootTypes(NodeType.PROGRAM)) {
				manager.add(ProgramNode.createNewProgramAction(modelContext));
				manager.add(new Separator());
			} else if (node.getParent() == null
					&& modelContext.isRootTypes(NodeType.PACKAGE)) {

				Action packageAction = new Action() {
					public void run() {
						NodeActions.createNewNode(modelContext, null,
								NodeType.PACKAGE);
					}
				};
				packageAction
						.setText(APDEditorMessages.TreeNodeAction_new_package);
				manager.add(packageAction);
				manager.add(new Separator());
			}

			Action[] actions = node.getActions(modelContext);
			for (Action action : actions) {
				if (action == null) {
					manager.add(new Separator());
				} else {
					manager.add(action);
				}
			}
			if (!addMode) {
				if (SnippetUtil.getSnippetProvider() != null
						&& node instanceof Movable
						&& ((Movable) node).canMove()
						&& node.getSource() instanceof EObject) {
					manager.add(new Separator());
					Action snippetAction = new Action() {
						public void run() {
							


			        IInputValidator validator = new IInputValidator(){
						public String isValid(String newText) {
							if (newText == null || "".equals(newText.trim()) ) //$NON-NLS-1$
								return "";
							
							if(SnippetUtil.getSnippetProvider().hasSnippet(newText.trim(),null))
								return String.format("Snippet '%s' already exists", newText.trim());
							return null;
						}
					};
					
					InputDialog dialog= new InputDialog(getSection().getShell(),"Add to Snippets" , "Snippet name", null, validator) ;
					if (dialog.open() != Window.CANCEL)	
							
								SnippetUtil.getSnippetProvider().addSnippet(
										dialog.getValue().trim(),
										(EObject) node.getSource());
							if (SnippetUtil.getSnippetProvider()
									.getViewerHandle() != null) {
								SnippetUtil.getSnippetProvider()
										.getViewerHandle().refresh();
							}
						}
					};
					snippetAction.setText("Add to Snippets");

					manager.add(snippetAction);
				}

				manager.add(new Separator());
				editor.getContributor().addUndoAction(manager);
				editor.getContributor().addRedoAction(manager);
				manager.add(new Separator());
				editor.getContributor().addClipboardActions(manager);
				manager.add(new Separator());
				editor.getContributor().addDeleteAction(manager);

			}

		} else {

			ISelection selection = viewer.getSelection();
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.isEmpty()) {

				boolean sequenceOnly = true;
				if (modelContext.isRootTypes(NodeType.PROGRAM)) {
					manager.add(ProgramNode
							.createNewProgramAction(modelContext));

				}
				if (modelContext.isRootTypes(NodeType.PACKAGE)) {

					Action packageAction = new Action() {
						public void run() {
							NodeActions.createNewNode(modelContext, null,
									NodeType.PACKAGE);
						}
					};
					packageAction
							.setText(APDEditorMessages.TreeNodeAction_new_package);
					manager.add(packageAction);

					sequenceOnly = false;
				}
				if (modelContext.isRootTypes(NodeType.INTERFACE)) {
					Action interfaceAction = new Action() {
						public void run() {
							NodeActions.createNewNode(modelContext, null,
									NodeType.INTERFACE);
						}
					};
					interfaceAction
							.setText(APDEditorMessages.TreeNodeAction_new_interface);
					manager.add(interfaceAction);

					sequenceOnly = false;
				}
				if (modelContext.isRootTypes(NodeType.CLASS)) {

					Action classAction = new Action() {
						public void run() {
							NodeActions.createNewNode(modelContext, null,
									NodeType.CLASS);
						}
					};
					classAction
							.setText(APDEditorMessages.TreeNodeAction_new_class);
					manager.add(classAction);
					manager.add(new Separator());
					sequenceOnly = false;
				}

				// FIX ME: if sub menu approved add I18n key to sub-menu
				IMenuManager subManager = null;
				if (sequenceOnly)
					subManager = manager;

				for (NodeType type : SequenceNode.getSequenceNodeTypes()) {

					if (modelContext.isRootTypes(type)) {
						if (subManager == null) {
							subManager = new MenuManager("Add Sequence");
							manager.add(subManager);
						}
						subManager.add(SequenceNode.newAction(modelContext,
								null, type));
					}
				}
			}
			if (!addMode) {
				manager.add(new Separator());
				editor.getContributor().addUndoAction(manager);
				editor.getContributor().addRedoAction(manager);
				manager.add(new Separator());
				editor.getContributor().addClipboardActions(manager);
				manager.add(new Separator());
				editor.getContributor().addDeleteAction(manager);
			}

		}

	}

	public void expandNodes() {
		if (filteredTree != null) {
			AbstractNode<?> node = getSelectedNode(filteredTree.getViewer());
			if (node == null)
				filteredTree.getViewer().expandAll();
			else
				filteredTree.getViewer().expandToLevel(node,
						TreeViewer.ALL_LEVELS);
		}
	}

	public void collapseNodes() {
		if (filteredTree != null) {
			AbstractNode<?> node = getSelectedNode(filteredTree.getViewer());
			if (node == null)
				filteredTree.getViewer().collapseAll();
			else
				filteredTree.getViewer().collapseToLevel(node,
						TreeViewer.ALL_LEVELS);
		}
	}

	public AbstractNode<?> getSelectedNode() {
		return filteredTree != null ? getSelectedNode(filteredTree.getViewer())
				: null;
	}

	private static AbstractNode<?> getSelectedNode(Viewer viewer) {
		ISelection selection = viewer.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;

		// support one selection only
		if (structuredSelection.size() > 1)
			return null;

		if (!structuredSelection.isEmpty()) {
			Object element = structuredSelection.getFirstElement();
			if (element instanceof AbstractNode) {
				return (AbstractNode<?>) element;
			}
		}
		return null;
	}

	public ISelectionProvider getISelectionProvider() {
		return filteredTree != null ? filteredTree.getViewer() : null;
	}

	class OutlinePage extends ContentOutlinePage {
		private boolean linked;
		private boolean sorted;
		private static final String LINK_STORE = "OutlineView_ToggleLinkWithEditorAction.isChecked";//$NON-NLS-1$;
		private static final String SORTED_STORE = "OutlineView_SortAction.isChecked";//$NON-NLS-1$;
		private NodeViewerComparator comparator;

		public OutlinePage() {
			APDEditorPlugin.getDefault().getPreferenceStore()
					.setDefault(LINK_STORE, true);
			linked = APDEditorPlugin.getDefault().getPreferenceStore()
					.getBoolean(LINK_STORE);
			sorted = APDEditorPlugin.getDefault().getPreferenceStore()
					.getBoolean(SORTED_STORE);
		}

		public boolean isLinked() {
			return linked;
		}

		public void setLinked(boolean linked) {
			this.linked = linked;
			// sync with
			if (linked) {
				setSelection(filteredTree.getViewer().getSelection());
			}
			APDEditorPlugin.getDefault().getPreferenceStore()
					.setValue(LINK_STORE, linked);
		}

		public boolean isSorted() {
			return sorted;
		}

		public void setSorted(boolean sorted) {
			this.sorted = sorted;
			if (sorted && comparator == null) {
				comparator = new NodeViewerComparator();
			} else {
				comparator = null;
			}
			if (getTreeViewer() != null)
				getTreeViewer().setComparator(comparator);
			APDEditorPlugin.getDefault().getPreferenceStore()
					.setValue(SORTED_STORE, sorted);
		}

		@Override
		public void setSelection(ISelection selection) {
			// select only if really selection changed
			if (!getSelection().equals(selection))
				super.setSelection(selection);
		}

		@Override
		public void createControl(Composite parent) {

			super.createControl(parent);
			final TreeViewer viewer = getTreeViewer();
			viewer.setLabelProvider(new NodeStyledCellLabelProvider(
					new TreeLabelProvider()));
			viewer.setContentProvider(new TreeContent());
			new ViewerToolTipSupport(viewer);
			viewer.setAutoExpandLevel(EXPAND_LEVEL);
			viewer.setInput(getModel());

			// connect popup menu
			MenuManager popupMenuManager = new MenuManager();
			IMenuListener listener = new IMenuListener() {
				public void menuAboutToShow(IMenuManager mng) {
					fillContextMenu(mng, modelContext, viewer, false);
				}
			};
			popupMenuManager.addMenuListener(listener);
			popupMenuManager.setRemoveAllWhenShown(true);
			Control control = viewer.getControl();
			control.setMenu(popupMenuManager.createContextMenu(control));
		}

		@Override
		public void setActionBars(IActionBars actionBars) {
			IToolBarManager toolBarManager = actionBars.getToolBarManager();
			if (toolBarManager != null) {
				toolBarManager.add(new SortAction());
				toolBarManager.add(new ToggleLinkWithEditorAction());

			}
			super.setActionBars(actionBars);
		}

		public void refresh() {
			TreeViewer treeview = getTreeViewer();
			if (treeview != null) {
				Object[] expanded = treeview.getExpandedElements();
				treeview.getControl().setRedraw(false);
				treeview.setInput(getModel());
				treeview.setExpandedElements(expanded);
				treeview.getControl().setRedraw(true);
				treeview.refresh();
			}

		}

		public void refreah(AbstractNode<?> node) {
			if (getTreeViewer() != null)
				getTreeViewer().refresh(node);

		}

		public void refreahAll() {
			if (getTreeViewer() != null)
				getTreeViewer().refresh();
		}

		public void selectNodes(AbstractNode<?>... nodes) {

			TreeViewer viewer = getTreeViewer();
			if (viewer != null) {
				IStructuredSelection selection = new StructuredSelection(nodes);
				viewer.setSelection(selection, true);
			}
		}
	}

	class ToggleLinkWithEditorAction extends Action {
		ToggleLinkWithEditorAction() {
			super(APDEditorMessages.ToggleLinkWithEditorAction_label);
			setChecked(outlinePage.isLinked());
			setToolTipText(APDEditorMessages.ToggleLinkWithEditorAction_toolTip);
			setDescription(APDEditorMessages.ToggleLinkWithEditorAction_description);
			setImageDescriptor(APDEditorImages.DESC_LINK_WITH_EDITOR);

		}

		@Override
		public void run() {
			outlinePage.setLinked(isChecked());
		}
	}

	class SortAction extends Action {
		SortAction() {
			super(APDEditorMessages.SortingAction_label);
			setChecked(outlinePage.isSorted());
			setToolTipText(APDEditorMessages.SortingAction_toolTip);
			setDescription(APDEditorMessages.SortingAction_description);
			setImageDescriptor(APDEditorImages.DESC_ALPHAB_SORT_CO);

		}

		@Override
		public void run() {
			outlinePage.setSorted(isChecked());
		}
	}

	class ContextProvider implements ModelContext {

		public void modelUpdated() {
			markDirty();
		}

		public Model getModel() {
			return ModelTreeSection.this.getModel();
		}

		public void refreah(AbstractNode<?> node) {
			if (node == null) {
				refreahAll();
			} else {
				filteredTree.getViewer().refresh(node);
				outlinePage.refreah(node);
			}
		}

		public void refreahAll() {
			filteredTree.getViewer().refresh();
			outlinePage.refreahAll();
		}

		public void selectNodes(boolean focusDeatils, AbstractNode<?>... nodes) {
			TreeViewer viewer = filteredTree.getViewer();
			IStructuredSelection selection = new StructuredSelection(nodes);
			viewer.setSelection(selection, true);
			if (focusDeatils && deatilsViewer != null) {
				APDEditorPlugin.getStandardDisplay().asyncExec(new Runnable() {

					public void run() {
						deatilsViewer.setFocus();

					}
				});
			}

			outlinePage.selectNodes(nodes);
		}

		public boolean isRootTypes(NodeType type) {
			Model model = getModel();
			switch (type) {
			case PROGRAM:
				return (model.getClassElement() == null
						&& model.getInterfaceElement() == null
						&& model.getSequences().size() == 0 && model
						.getPackages().size() == 0);
			case CLASS:
				return (model.getClassElement() == null
						&& model.getInterfaceElement() == null
						&& model.getSequences().size() == 0
						&& model.getPrograms().size() == 0 && model
						.getPackages().size() == 0);
			case INTERFACE:
				return (model.getClassElement() == null
						&& model.getInterfaceElement() == null
						&& model.getSequences().size() == 0
						&& model.getPrograms().size() == 0 && model
						.getPackages().size() == 0);
			case PACKAGE:
				return (model.getClassElement() == null
						&& model.getInterfaceElement() == null
						&& model.getSequences().size() == 0 && model
						.getPrograms().size() == 0);

			default:
				return (model.getClassElement() == null
						&& model.getInterfaceElement() == null
						&& SequenceNode.isSequenceType(type)
						&& model.getPrograms().size() == 0 && model
						.getPackages().size() == 0);
			}

		}

		private boolean isModelEmpty() {
			Model model = getModel();
			return (model.getClassElement() == null
					&& model.getInterfaceElement() == null
					&& model.getSequences().size() == 0
					&& model.getPrograms().size() == 0 && model.getPackages()
					.size() == 0);
		}

		public IResource getModelResource() {
			return editor.getModelFile();
		}

		public NodeMoveProvider getRootNodeMoveProvider() {
			final Model model = getModel();

			return new NodeMoveProvider() {

				public void move(ModelContext context, Neighbor relation,
						Object source, boolean before) {
					final boolean emptyModel = isModelEmpty();
					if (emptyModel || model.getSequences().size() > 0) {
						if ((relation == null || relation.getNeighborSource() instanceof Sequence)
								&& source instanceof Sequence) {
							EList<Sequence> sequences = model.getSequences();
							if (relation != null) {
								Sequence neighbor = (Sequence) relation
										.getNeighborSource();
								if (sequences.contains(neighbor)) {

									int index = sequences.indexOf(neighbor);

									if (!before)
										index++;

									sequences.add(index, (Sequence) source);
								}
							} else
								sequences.add((Sequence) source);
						}
					}
					// check is class mode
					if ((emptyModel || model.getClassElement() == null)
							&& source instanceof ClassElement)
						model.setClassElement((ClassElement) source);

					// check is interface mode
					if ((emptyModel || model.getInterfaceElement() == null)
							&& source instanceof InterfaceElement)
						model.setInterfaceElement((InterfaceElement) source);

					// check is package mode
					if ((emptyModel || model.getPackages().size() > 0)
							&& source instanceof PackageElement)
						model.getPackages().add((PackageElement) source);

					// check is program mode
					if ((emptyModel || model.getPrograms().size() > 0)
							&& source instanceof Program)
						model.getPrograms().add((Program) source);
				}

				public boolean canMove(Neighbor relation, NodeType type) {
					final boolean emptyModel = isModelEmpty();
					// check is on sequence mode
					if ((emptyModel || model.getSequences().size() > 0)
							&& (relation.getNeighborSource() instanceof Sequence && SequenceNode
									.isSequenceType(type)))
						return true;
					// check is class mode
					if ((emptyModel || model.getClassElement() == null)
							&& type == NodeType.CLASS)
						return true;
					// check is interface mode
					if ((emptyModel || model.getInterfaceElement() == null)
							&& type == NodeType.INTERFACE)
						return true;

					// check is package mode
					if ((emptyModel || model.getPackages().size() > 0)
							&& type == NodeType.PACKAGE)
						return true;

					// check is program mode
					if ((emptyModel || model.getPrograms().size() > 0)
							&& type == NodeType.PROGRAM)
						return true;
					return false;
				}

				public boolean canMove(Neighbor relation, Object source) {
					final boolean emptyModel = isModelEmpty();
					// check is on sequence mode
					if ((emptyModel || model.getSequences().size() > 0)
							&& source instanceof Sequence
							&& (relation == null || model.getSequences()
									.contains(relation.getNeighborSource())))
						return true;

					// check is class mode
					if ((emptyModel || model.getClassElement() == null)
							&& source instanceof ClassElement)
						return true;
					// check is interface mode
					if ((emptyModel || model.getInterfaceElement() == null)
							&& source instanceof InterfaceElement)
						return true;

					// check is package mode
					if ((emptyModel || model.getPackages().size() > 0)
							&& source instanceof PackageElement)
						return true;

					// check is program mode
					if ((emptyModel || model.getPrograms().size() > 0)
							&& source instanceof Program)
						return true;
					return false;
				}
			};

		}

		public OperationSupport getOperationSupport() {
			return operationSupport;
		}

		public AbstractNode<?> findNode(Object source) {
			if (source == null)
				return null;
			TreeItem[] items = filteredTree.getViewer().getTree().getItems();
			for (TreeItem treeItem : items) {
				AbstractNode<?> findNode = findNode(source, treeItem);
				if (findNode != null)
					return findNode;
			}
			return null;
		}

		private AbstractNode<?> findNode(Object source, TreeItem item) {
			Object data = item.getData();
			if (data instanceof AbstractNode) {
				AbstractNode<?> node = (AbstractNode<?>) data;
				if (source.equals(node.getSource())
						|| (node instanceof NodeMoveProvider.Neighbor && source
								.equals(((NodeMoveProvider.Neighbor) node)
										.getNeighborSource())))
					return (AbstractNode<?>) data;
			}
			TreeItem[] items = item.getItems();
			for (TreeItem treeItem : items) {
				AbstractNode<?> findNode = findNode(source, treeItem);
				if (findNode != null)
					return findNode;
			}
			return null;
		}
	}

	class ViewerToolTipSupport extends ColumnViewerToolTipSupport {

		protected ViewerToolTipSupport(ColumnViewer viewer) {
			super(viewer, ToolTip.NO_RECREATE, false);
		}

		protected Composite createToolTipContentArea(Event event,
				final Composite parent) {
			Composite comp = new Composite(parent, SWT.NONE);
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			gridLayout.marginWidth = 5;
			gridLayout.marginHeight = 2;
			comp.setLayout(gridLayout);
			Image image = getImage(event);
			Image bgImage = getBackgroundImage(event);
			String text = getText(event);
			Color fgColor = getForegroundColor(event);
			Color bgColor = getBackgroundColor(event);
			Font font = getFont(event);

			Label label = new Label(comp, getStyle(event));
			if (text != null)
				label.setText(text);

			if (image != null)
				label.setImage(image);

			if (fgColor != null)
				label.setForeground(fgColor);

			if (bgColor != null)
				label.setBackground(bgColor);

			if (bgImage != null)
				label.setBackgroundImage(image);

			if (font != null)
				label.setFont(font);

			comp.setBackground(label.getBackground());

			return comp;
		}
	}
}
