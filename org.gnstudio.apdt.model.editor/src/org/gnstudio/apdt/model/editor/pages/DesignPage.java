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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.DefaultOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDModelEditor;
import org.gnstudio.apdt.model.editor.AbstractEditorPage;
import org.gnstudio.apdt.model.editor.EditorLayoutFactory;
import org.gnstudio.apdt.model.editor.handlers.ModelElementCopyCutHandler;
import org.gnstudio.apdt.model.editor.handlers.ModelElementDeleteHandler;
import org.gnstudio.apdt.model.editor.handlers.ModelElementPasteHandler;
import org.gnstudio.apdt.model.editor.handlers.ModelElementRedoHandler;
import org.gnstudio.apdt.model.editor.handlers.ModelElementUndoHandler;
import org.gnstudio.apdt.model.editor.handlers.PageActionHandler;
import org.gnstudio.apdt.model.editor.handlers.PageActionHandlerProvider;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.operations.OperationSupport;
import org.gnstudio.apdt.model.editor.parts.ModelNodeDetailsSection;
import org.gnstudio.apdt.model.editor.parts.ModelTreeSection;

public class DesignPage extends AbstractEditorPage implements
		PageActionHandlerProvider {
	public static final String CONTEXT_ID = "org.gnstudio.apdt.model.editor.APDDesignPage";
	public static final String PAGE_ID = "design"; //$NON-NLS-1$
	private ModelTreeSection treeSection;
	private ModelNodeDetailsSection detailsSection;
	private final IOperationHistory operationHistory = new DefaultOperationHistory();
	private final IUndoContext undoContext;
	private IContextActivation activateContext;
	private final List<IHandlerActivation> activations = new ArrayList<IHandlerActivation>(
			3);

	public DesignPage(final APDModelEditor editor) {
		super(editor, PAGE_ID, APDEditorMessages.DesignPage_title);
		// make sure to refresh action on history changes
		operationHistory
				.addOperationHistoryListener(new IOperationHistoryListener() {

					public void historyNotification(OperationHistoryEvent event) {
						editor.getContributor().refreah();
					}
				});
		undoContext = new ObjectUndoContext(this);
	}

	@Override
	protected String getPageHeader() {
		return APDEditorMessages.DesignPage_header;
	}

	@Override
	protected Image getPageHeaderImage() {
		return APDEditorImages.getImage(APDEditorImages.DESC_MODEL_OVERVIEW);
	}

	@Override
	protected void buildBody(IManagedForm managedForm, FormToolkit toolkit) {
		Composite body = managedForm.getForm().getBody();
		
		//disable focus from going out to toolbar
		managedForm.getForm().getForm().setTabList(
				new Control[] { body });
		body.setLayout(EditorLayoutFactory.createClearFillLayout());
		body.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.GRAB_VERTICAL));
		SashForm form = new SashForm(body, SWT.HORIZONTAL | SWT.NONE);

		form.setLayout(EditorLayoutFactory.createClearGridLayout());
		Composite treeBody = new Composite(form, SWT.NONE);
		treeBody.setLayout(EditorLayoutFactory.createClearGridLayout());
		treeSection = new ModelTreeSection(getEditor(), this, treeBody,
				new OperationSupport() {

					public void execute(IUndoableOperation operation,
							IProgressMonitor monitor) {
						operation.addContext(undoContext);
						try {
							operationHistory.execute(operation, monitor, null);
						} catch (ExecutionException e) {
							APDTLog.log(e);
						}
					}
				});
		Composite detailsBody = new Composite(form, SWT.NONE);
		detailsBody.setLayout(EditorLayoutFactory.createClearGridLayout());
		detailsSection = new ModelNodeDetailsSection(getEditor(), this,
				detailsBody);
		managedForm.addPart(treeSection);
		managedForm.addPart(detailsSection);
		treeSection.setDeatilsViewer(detailsSection);
		form.setTabList(new Control[] { treeBody, detailsBody });
		form.setWeights(new int[] { 60, 40 });
		form.setSashWidth(5);
	}



	@Override
	public IContentOutlinePage getContentOutlinePage() {
		return treeSection != null ? treeSection.getOutlinePage() : null;
	}

	@Override
	public void setFocus() {
		treeSection.setFocus();
	}

	public ModelContext getModelContext() {
		return treeSection != null ? treeSection.getModelContext() : null;
	}

	public PageActionHandler getActionHandler(String commandId) {
		if (ActionFactory.CUT.getCommandId().endsWith(commandId)) {
			return new ModelElementCopyCutHandler(getModelContext(),
					treeSection.getISelectionProvider(), false);
		}
		if (ActionFactory.COPY.getCommandId().endsWith(commandId)) {
			return new ModelElementCopyCutHandler(getModelContext(),
					treeSection.getISelectionProvider(), true);
		}
		if (ActionFactory.PASTE.getCommandId().endsWith(commandId)) {
			return new ModelElementPasteHandler(getModelContext(),
					treeSection.getISelectionProvider());
		}
		if (ActionFactory.DELETE.getCommandId().endsWith(commandId)) {
			return new ModelElementDeleteHandler(getModelContext(),
					treeSection.getISelectionProvider());
		}
		if (ActionFactory.REDO.getCommandId().endsWith(commandId)) {
			return new ModelElementRedoHandler(operationHistory, undoContext);
		}
		if (ActionFactory.UNDO.getCommandId().endsWith(commandId)) {
			return new ModelElementUndoHandler(operationHistory, undoContext);
		}
		return null;
	}

	public boolean isHandlerActive(String commandId) {
		boolean activeView = detailsSection != null
				&& !detailsSection.isActiveForcus();
		if (!activeView) {
			if (ActionFactory.CUT.getCommandId().endsWith(commandId)) {
				return false;
			}
			if (ActionFactory.COPY.getCommandId().endsWith(commandId)) {
				return false;
			}
			if (ActionFactory.PASTE.getCommandId().endsWith(commandId)) {
				return false;
			}
			if (ActionFactory.DELETE.getCommandId().endsWith(commandId)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		IContextService contextService = (IContextService) getSite()
				.getService(IContextService.class);
		if (activateContext != null)
			contextService.deactivateContext(activateContext);

		IHandlerService handlerService = (IHandlerService) getSite()
				.getService(IHandlerService.class);

		if (activations.size() > 0) {
			handlerService.deactivateHandlers(activations);
			// clear after de-activate
			activations.clear();
		}

		if (active) {
			activateContext = contextService.activateContext(CONTEXT_ID);
			activations.add(handlerService.activateHandler(
					"org.gnstudio.apdt.model.editor.add",
					new AbstractHandler() {

						public Object execute(ExecutionEvent event)
								throws ExecutionException {
							treeSection.showContextAddMenu();
							return null;
						}

					}));
			activations.add(handlerService.activateHandler(
					"org.gnstudio.apdt.model.editor.expand",
					new AbstractHandler() {

						public Object execute(ExecutionEvent event)
								throws ExecutionException {
							treeSection.expandNodes();
							return null;
						}

					}));
			activations.add(handlerService.activateHandler(
					"org.gnstudio.apdt.model.editor.collapse",
					new AbstractHandler() {

						public Object execute(ExecutionEvent event)
								throws ExecutionException {
							treeSection.collapseNodes();
							return null;
						}

					}));
			activations.add(handlerService.activateHandler(
					"org.gnstudio.apdt.model.editor.goto.designer",
					new AbstractHandler() {

						public Object execute(ExecutionEvent event)
								throws ExecutionException {
							treeSection.setFocus();
							return null;
						}

					}));
			activations.add(handlerService.activateHandler(
					"org.gnstudio.apdt.model.editor.goto.properties",
					new AbstractHandler() {

						public Object execute(ExecutionEvent event)
								throws ExecutionException {
							detailsSection.setFocus();
							return null;
						}

					}));
			activations.add(handlerService.activateHandler(
					"org.gnstudio.apdt.model.editor.goto.parent",
					new AbstractHandler() {

						public Object execute(ExecutionEvent event)
								throws ExecutionException {
							AbstractNode<?> node = treeSection
									.getSelectedNode();
							if (node != null && node.getParent() != null) {
								ModelContext context = treeSection
										.getModelContext();
								context.selectNodes(false, node.getParent());
							}

							return null;
						}

					}));
		}
	}
}
