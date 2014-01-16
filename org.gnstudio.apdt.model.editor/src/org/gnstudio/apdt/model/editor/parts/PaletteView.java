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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.ViewPart;
import org.gnstudio.apdt.APDTUIConstants;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeDragAdapter;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeTransfer;
import org.gnstudio.apdt.model.editor.palette.AbstractPaletteCategory;
import org.gnstudio.apdt.model.editor.palette.PaletteCategory;
import org.gnstudio.apdt.model.editor.palette.PaletteItem;
import org.gnstudio.apdt.model.editor.palette.PaletteNode;
import org.gnstudio.apdt.model.editor.snippets.SnippetHandle;
import org.gnstudio.apdt.model.editor.snippets.SnippetProvider;
import org.gnstudio.apdt.model.editor.snippets.SnippetUtil;
import org.gnstudio.apdt.model.editor.snippets.impl.SnippetDummyNode;

public class PaletteView extends ViewPart implements
		SnippetProvider.ViewerHandle {
	public static final String ID = APDTUIConstants.MODEL_PALETTE_ID;
	// private static final int EXPAND_LEVEL = 2;
	private TreeViewer viewer;

	// -------------------------------------------------------------------
	// TODO: add i18n keys to PaletteNodes
	private final PaletteNode programNode = new PaletteNode("Program",
			APDEditorImages.DESC_MODEL_PROGRAM, NodeType.PROGRAM);

	private final PaletteNode packageNode = new PaletteNode("Package",
			APDEditorImages.DESC_MODEL_PACKAGE, NodeType.PACKAGE);

	private final PaletteNode interfaceNode = new PaletteNode("Interface",
			APDEditorImages.DESC_MODEL_INTERFACE, NodeType.INTERFACE);

	private final PaletteNode classNode = new PaletteNode("Class",
			APDEditorImages.DESC_MODEL_CLASS, NodeType.CLASS);
	private final PaletteNode implementsNode = new PaletteNode("Implements",
			APDEditorImages.DESC_MODEL_EXTENDS_INTERFACE, NodeType.IMPLEMENTS);
	private final PaletteNode extendsNode = new PaletteNode("Extends",
			APDEditorImages.DESC_MODEL_SUPER_TYPES, NodeType.EXTENDS);

	private final PaletteNode classMemberNode = new PaletteNode("Class Member",
			APDEditorImages.DESC_MODEL_CLASS_MEMBER, NodeType.CLASS_MEMBER);

	private final PaletteNode variableNode = new PaletteNode("Variable",
			APDEditorImages.DESC_MODEL_LOCAL_VAR, NodeType.VARIABLE);

	private final PaletteNode methodNode = new PaletteNode("Method",
			APDEditorImages.DESC_MODEL_METHOD, NodeType.METHOD);
	private final PaletteNode methodCallNode = new PaletteNode("Method Call",
			APDEditorImages.DESC_MODEL_METHOD_CALL, NodeType.METHOD_CALL);
	private final PaletteNode recursionNode = new PaletteNode("Recursion",
			APDEditorImages.DESC_MODEL_SEQN_RECURSION, NodeType.RECURSION);
	private final PaletteNode printNode = new PaletteNode("Print",
			APDEditorImages.DESC_MODEL_SEQN_PRINT, NodeType.PRINT);
	private final PaletteNode showNode = new PaletteNode("Show",
			APDEditorImages.DESC_MODEL_SEQN_SHOW, NodeType.SHOW);
	private final PaletteNode promptNode = new PaletteNode("Prompt",
			APDEditorImages.DESC_MODEL_SEQN_PROMPT, NodeType.PROMPT);
	private final PaletteNode readNode = new PaletteNode("Read",
			APDEditorImages.DESC_MODEL_SEQN_READ, NodeType.READ);
	private final PaletteNode writeNode = new PaletteNode("Write",
			APDEditorImages.DESC_MODEL_SEQN_WRITE, NodeType.WRITE);
	private final PaletteNode recoverNode = new PaletteNode("Recover",
			APDEditorImages.DESC_MODEL_SEQN_RECOVER, NodeType.RECOVER);
	private final PaletteNode storeNode = new PaletteNode("Set",
			APDEditorImages.DESC_MODEL_SEQN_STORE, NodeType.STORE);
	private final PaletteNode calcStoreNode = new PaletteNode("Calculate->Set",
			APDEditorImages.DESC_MODEL_SEQN_CALC_STORE, NodeType.CALC_STORE);

	private final PaletteNode methodReturnNode = new PaletteNode(
			"Method Return", APDEditorImages.DESC_MODEL_RETURN,
			NodeType.METHOD_RETURN);

	private final PaletteNode methodArgNode = new PaletteNode(
			"Method Arguments", APDEditorImages.DESC_MODEL_ARGUMENT,
			NodeType.ARGUMRNT);
	
	private final PaletteNode methodThrowsNode = new PaletteNode(
			"Method Throws", APDEditorImages.DESC_MODEL_ARGUMENT,
			NodeType.THROWS);

	private final PaletteNode descriptionNode = new PaletteNode("Description",
			APDEditorImages.DESC_MODEL_COMMNETS, NodeType.DESCRIPTION);
	private final PaletteNode sourceLinkNode = new PaletteNode("Source Link",
			APDEditorImages.DESC_MODEL_LINK, NodeType.SOURCE_LINK);
	private final PaletteNode discussionNode = new PaletteNode("Discussion",
			APDEditorImages.DESC_MODEL_DISCUSSION, NodeType.DISCUSSION);

	private final PaletteNode commentNode = new PaletteNode("Comment",
			APDEditorImages.DESC_MODEL_COMMNET, NodeType.COMMENT);
	private final PaletteNode groupNode = new PaletteNode("Group",
			APDEditorImages.DESC_MODEL_SEQN_GROUP, NodeType.GROUP);
	private final PaletteNode iterationNode = new PaletteNode("Iteration",
			APDEditorImages.DESC_MODEL_SEQN_ITERATION, NodeType.ITERATION);
	private final PaletteNode switchNode = new PaletteNode("Switch",
			APDEditorImages.DESC_MODEL_SEQN_SWITCH, NodeType.SWITCH);
	private final PaletteNode caseNode = new PaletteNode("Case",
			APDEditorImages.DESC_MODEL_SEQN_CASE, NodeType.CASE);
	private final PaletteNode defaultCaseNode = new PaletteNode("Default",
			APDEditorImages.DESC_MODEL_SEQN_DEFAULT_CASE, NodeType.DEFAULT_CASE);

	private final PaletteNode ifNode = new PaletteNode("If",
			APDEditorImages.DESC_MODEL_SEQN_IF, NodeType.IF);
	private final PaletteNode elseifNode = new PaletteNode("Else if",
			APDEditorImages.DESC_MODEL_SEQN_ELSE_IF, NodeType.ELSE_IF);
	private final PaletteNode elseNode = new PaletteNode("Else",
			APDEditorImages.DESC_MODEL_SEQN_ELSE, NodeType.ELSE);

	private final PaletteNode tryNode = new PaletteNode("Try",
			APDEditorImages.DESC_MODEL_SEQN_TRY, NodeType.TRY);
	private final PaletteNode catchNode = new PaletteNode("Catch",
			APDEditorImages.DESC_MODEL_SEQN_CATCH, NodeType.CATCH);
	private final PaletteNode finallyNode = new PaletteNode("Finally",
			APDEditorImages.DESC_MODEL_SEQN_FINALLY, NodeType.FINALLY);

	// -------------------------------------------------------------------
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.SINGLE | SWT.V_SCROLL);
		viewer.setLabelProvider(new PaletteLabelProvider());
		viewer.setContentProvider(new PaletteContent());
		// viewer.setAutoExpandLevel(EXPAND_LEVEL);
		// provide dummy object as input PaletteContent will provide contents
		viewer.setInput(new Object());
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
		viewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK,
				new Transfer[] { NodeTransfer.getInstance() },
				new NodeDragAdapter(viewer) {
					@Override
					public void dragStart(DragSourceEvent event) {

						super.dragStart(event);
						Object element = selection.getFirstElement();
						event.doit = element != null
								&& element instanceof PaletteItem;

						event.image = event.doit ? APDEditorImages
								.getImage(((PaletteItem) element)
										.getImageDescriptor()) : null;
						if (event.doit) {
							NodeTransfer.getInstance().javaToNative(
									((PaletteItem) element).getData(),
									event.dataType);
						}
					}

					@Override
					public void dragSetData(DragSourceEvent event) {
						super.dragSetData(event);
						if (event.data instanceof Object[]) {
							Object data = ((Object[]) event.data)[0];
							if (data instanceof PaletteItem) {
								event.data = ((PaletteItem) data).getData();
							}
						}
					}
				});
		// viewer.setExpandedState(allCategory, false);
		connectContextMenu();
	}

	@Override
	public void setFocus() {
		if (viewer != null) {
			viewer.getControl().setFocus();
		}

	}

	private void connectContextMenu() {
		MenuManager popupMenuManager = new MenuManager();
		IMenuListener listener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager mng) {
				fillContextMenu(mng);
			}
		};
		popupMenuManager.addMenuListener(listener);
		popupMenuManager.setRemoveAllWhenShown(true);
		Control control = viewer.getControl();
		Menu menu = popupMenuManager.createContextMenu(control);
		control.setMenu(menu);

	}

	protected void fillContextMenu(IMenuManager mng) {
		PaletteItem node = getSelectedNode();
		if (node != null) {
			Action[] actions = node.getActions();
			for (Action action : actions) {
				if (action == null) {
					mng.add(new Separator());
				} else {
					mng.add(action);
				}
			}
		}

	}

	private PaletteItem getSelectedNode() {
		ISelection selection = viewer.getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;

		// support one selection only
		if (structuredSelection.size() > 1)
			return null;

		if (!structuredSelection.isEmpty()) {
			Object element = structuredSelection.getFirstElement();
			if (element instanceof PaletteItem) {
				return (PaletteItem) element;
			}
		}
		return null;
	}

	private class PaletteContent implements ITreeContentProvider {

		public void dispose() {
			// ignore
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// ignore
		}

		public Object[] getElements(Object inputElement) {
			List<PaletteCategory> categories = new ArrayList<PaletteCategory>();
			categories.add(getStructureCategory());
			categories.add(getConditionCategory());
			categories.add(getLoopCategory());
			categories.add(getDocTypeCategory());
			categories.add(getAllCategory());

			// create snippet category

			final SnippetProvider provider = SnippetUtil.getSnippetProvider();
			if (provider != null) {
				provider.setViewerHandle(PaletteView.this);
				final List<PaletteItem> items = new ArrayList<PaletteItem>();
				for (SnippetHandle handle : provider.getSnippets()) {
					items.add(new SnippetDummyNode(provider, handle));
				}

				PaletteCategory snippetCategory = new AbstractPaletteCategory(
						"Snippets", APDEditorImages.DESC_PALETTE_CATEGORY) {

					public PaletteItem[] getItems() {

						return items.toArray(new PaletteItem[items.size()]);
					}

					public Action[] getActions() {
						// FIXME: add refresh
						return new Action[0];
					}
				};
				categories.add(snippetCategory);
			}

			return categories.toArray(new Object[categories.size()]);
		}

		private PaletteCategory getAllCategory() {
			PaletteCategory allCategory = new AbstractPaletteCategory("All",
					APDEditorImages.DESC_PALETTE_CATEGORY) {
				public PaletteItem[] getItems() {
					return new PaletteItem[] { programNode, packageNode,
							interfaceNode, classNode, implementsNode,
							extendsNode, classMemberNode, methodNode,
							methodArgNode,methodThrowsNode, variableNode, descriptionNode,
							discussionNode, commentNode, groupNode,
							iterationNode, switchNode, caseNode,
							defaultCaseNode, ifNode, elseifNode, elseNode,
							methodCallNode, methodReturnNode, recursionNode,
							tryNode, catchNode, finallyNode, printNode,
							showNode, promptNode, readNode, writeNode,
							recoverNode, storeNode, calcStoreNode };
				}

			};
			return allCategory;
		}

		private PaletteCategory getDocTypeCategory() {
			PaletteCategory docCategory = new AbstractPaletteCategory(
					"Documenting", APDEditorImages.DESC_PALETTE_CATEGORY) {

				public PaletteItem[] getItems() {
					return new PaletteItem[] { descriptionNode, discussionNode,
							commentNode, groupNode, sourceLinkNode };
				}
			};
			return docCategory;
		}

		private PaletteCategory getLoopCategory() {
			PaletteCategory loopsCategory = new AbstractPaletteCategory(
					"Loops", APDEditorImages.DESC_PALETTE_CATEGORY) {

				public PaletteItem[] getItems() {
					return new PaletteItem[] { iterationNode };
				}
			};
			return loopsCategory;
		}

		private PaletteCategory getConditionCategory() {
			PaletteCategory conditionCategory = new AbstractPaletteCategory(
					"Conditions", APDEditorImages.DESC_PALETTE_CATEGORY) {

				public PaletteItem[] getItems() {
					return new PaletteItem[] { switchNode, caseNode,
							defaultCaseNode, ifNode, elseifNode, elseNode };
				}
			};
			return conditionCategory;
		}

		private PaletteCategory getStructureCategory() {
			PaletteCategory structureCategory = new AbstractPaletteCategory(
					"Structure", APDEditorImages.DESC_PALETTE_CATEGORY) {
				public PaletteItem[] getItems() {
					return new PaletteItem[] { programNode, packageNode,
							interfaceNode, classNode, implementsNode,
							extendsNode, classMemberNode, methodNode,
							methodArgNode,methodThrowsNode, variableNode, methodCallNode,
							methodReturnNode, recursionNode, tryNode,
							catchNode, finallyNode, printNode, showNode,
							promptNode, readNode, writeNode, recoverNode,
							storeNode, calcStoreNode };
				}
			};
			return structureCategory;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof PaletteCategory) {
				return ((PaletteCategory) parentElement).getItems();
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			// no need to have expand on palette
			return null;
		}

		public boolean hasChildren(Object element) {
			return element instanceof PaletteCategory;
		}

	}

	private class PaletteLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof PaletteItem) {
				return ((PaletteItem) element).getName();
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof PaletteItem) {
				return APDEditorImages.getImage(((PaletteItem) element)
						.getImageDescriptor());
			}
			return super.getImage(element);
		}
	}

	public void refresh() {

		Object[] expanded = viewer.getExpandedElements();

		viewer.getControl().setRedraw(false);
		viewer.setInput(new Object());
		viewer.setExpandedElements(expanded);
		viewer.getControl().setRedraw(true);
		viewer.refresh();

	}
}
