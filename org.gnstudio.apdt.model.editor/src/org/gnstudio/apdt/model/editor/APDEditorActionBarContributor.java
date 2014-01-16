package org.gnstudio.apdt.model.editor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.texteditor.IUpdate;
import org.gnstudio.apdt.model.editor.handlers.PageActionHandler;
import org.gnstudio.apdt.model.editor.handlers.PageActionHandlerProvider;

public class APDEditorActionBarContributor extends
		MultiPageEditorActionBarContributor {
	protected APDModelEditor editor;

	protected IFormPage page;
	
	private IActionBars actionBars;

	protected Map<String, HandlerAction> actions = new HashMap<String, HandlerAction>();

	@Override
	public void setActiveEditor(IEditorPart part) {
		if (part instanceof APDModelEditor) {
			editor = (APDModelEditor) part;
			setActivePage(editor.getActiveEditor());
		}
	}

	@Override
	public void setActivePage(IEditorPart activeEditor) {
		if (editor != null) {
			page = editor.getActivePageInstance();
		}
		refreah();
	}

	public void init(IActionBars bars) {
		super.init(actionBars = bars);
		createActions();
	}

	public IActionBars getActionBars() {
		return actionBars;
	}
	
	public void refreah() {
		IActionBars actionBars = getActionBars();
		Set<String> keySet = actions.keySet();
		if (page instanceof PageActionHandlerProvider) {
			PageActionHandlerProvider provider = (PageActionHandlerProvider) page;
			for (String commandId : keySet) {
				boolean handlersActive = provider.isHandlerActive(commandId);
				if (handlersActive) {
					HandlerAction action = actions.get(commandId);
					if (action != null)
						action.refreah(provider);

					actionBars.setGlobalActionHandler(commandId, action);
				} else
					actionBars.setGlobalActionHandler(commandId, null);
			}

		} else {
			for (String commandId : keySet) {
				actionBars.setGlobalActionHandler(commandId, null);
			}
		}

		getActionBars().updateActionBars();
	}

	public void addClipboardActions(IMenuManager manager) {
		manager.add(actions.get(ActionFactory.CUT.getId()));
		manager.add(actions.get(ActionFactory.COPY.getId()));
		manager.add(actions.get(ActionFactory.PASTE.getId()));
	}

	public void addCopyAction(IMenuManager manager) {
		manager.add(actions.get(ActionFactory.COPY.getId()));

	}

	public void addDeleteAction(IMenuManager manager) {
		manager.add(actions.get(ActionFactory.DELETE.getId()));

	}

	public void addRedoAction(IMenuManager manager) {
		manager.add(actions.get(ActionFactory.REDO.getId()));

	}

	public void addUndoAction(IMenuManager manager) {
		manager.add(actions.get(ActionFactory.UNDO.getId()));

	}

	public void addPrintAction(IMenuManager manager) {
		manager.add(actions.get(ActionFactory.PRINT.getId()));
		
	}

	private void createActions() {
		actions.put(ActionFactory.CUT.getId(), new CutAction());
		actions.put(ActionFactory.COPY.getId(), new CopyAction());
		actions.put(ActionFactory.PASTE.getId(), new PasteAction());
		actions.put(ActionFactory.DELETE.getId(), new DeleteAction());
		actions.put(ActionFactory.REDO.getId(), new RedoAction());
		actions.put(ActionFactory.UNDO.getId(), new UndoAction());
		actions.put(ActionFactory.PRINT.getId(), new PrintAction());
	}

	class HandlerAction extends Action implements IUpdate {

		public HandlerAction() {
			setEnabled(false);
		}

		public void run() {
			if (page instanceof PageActionHandlerProvider) {
				PageActionHandlerProvider provider = (PageActionHandlerProvider) page;
				PageActionHandler actionHandler = provider
						.getActionHandler(getActionDefinitionId());
				if (actionHandler != null) {
					actionHandler.excecute();
				}
				// do actions refresh
				APDEditorActionBarContributor.this.refreah();
			}
		}

		public void refreah(PageActionHandlerProvider provider) {
			if (provider.isHandlerActive(getActionDefinitionId())) {
				PageActionHandler actionHandler = provider
						.getActionHandler(getActionDefinitionId());
				setEnabled(actionHandler != null && actionHandler.isEnable());
			} else
				setEnabled(false);
		}

		public void update() {
			getActionBars().updateActionBars();
		}
	}

	// Context Actions

	class CutAction extends HandlerAction {

		public CutAction() {

			setText("Cut");
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
			setActionDefinitionId(ActionFactory.CUT.getCommandId());
		}

	}

	class CopyAction extends HandlerAction {

		public CopyAction() {

			setText("Copy");
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
			setActionDefinitionId(ActionFactory.COPY.getCommandId());
		}
	}

	class PasteAction extends HandlerAction {
		public PasteAction() {
			setText("Paste");
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
			setActionDefinitionId(ActionFactory.PASTE.getCommandId());
		}

	}

	class DeleteAction extends HandlerAction {
		public DeleteAction() {
			setText(APDEditorMessages.TreeNodeAction_delete);
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
			setActionDefinitionId(ActionFactory.DELETE.getCommandId());
		}

	}

	class RedoAction extends HandlerAction {
		public RedoAction() {
			setText(APDEditorMessages.TreeNodeAction_redo);
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_REDO_DISABLED));
			setActionDefinitionId(ActionFactory.REDO.getCommandId());
		}

	}

	class UndoAction extends HandlerAction {
		public UndoAction() {
			setText(APDEditorMessages.TreeNodeAction_undo);
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO_DISABLED));
			setActionDefinitionId(ActionFactory.UNDO.getCommandId());
		}

	}

	
	class PrintAction extends HandlerAction {
		public PrintAction() {
			setText("Print");
			ISharedImages sharedImages = getSharedImages();
			setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
			setDisabledImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
			setActionDefinitionId(ActionFactory.PRINT.getCommandId());
		}

	}
	
	public ISharedImages getSharedImages() {
		return getPage().getWorkbenchWindow().getWorkbench().getSharedImages();
	}
}
