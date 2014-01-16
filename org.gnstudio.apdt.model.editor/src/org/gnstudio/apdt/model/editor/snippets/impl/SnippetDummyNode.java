package org.gnstudio.apdt.model.editor.snippets.impl;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.palette.PaletteItem;
import org.gnstudio.apdt.model.editor.snippets.SnippetHandle;
import org.gnstudio.apdt.model.editor.snippets.SnippetProvider;
import org.gnstudio.apdt.model.editor.snippets.SnippetProvider.ViewerHandle;
import org.gnstudio.apdt.model.editor.snippets.SnippetUtil;

public class SnippetDummyNode extends AbstractNode<Object> implements
		PaletteItem {
	private final SnippetHandle handle;
	private final SnippetProvider provider;

	public SnippetDummyNode(SnippetProvider provider, SnippetHandle handle) {
		super(null, handle.getKey());
		this.provider = provider;
		this.handle = handle;
	}

	@Override
	public String getName() {
		return handle.getName();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_TAG;
	}

	public Object getSource() {
		return provider.getSnippetData(handle);
	}

	public Object getData() {
		return new Object[] { this };
	}

	public Action[] getActions() {
		Action renameAction = new Action() {
			public void run() {

				IInputValidator validator = new IInputValidator() {
					public String isValid(String newText) {
						if (newText == null || "".equals(newText.trim())) //$NON-NLS-1$
							return "";
						//same name
						if (handle.getName().equals(newText.trim())) //$NON-NLS-1$
							return "";

						if (SnippetUtil.getSnippetProvider().hasSnippet(
								newText.trim(), handle))
							return String.format("Snippet '%s' already exists",
									newText.trim());
						return null;
					}
				};

				InputDialog dialog = new InputDialog(null, "Rename Snippet",
						"New Name", handle.getName(), validator);
				if (dialog.open() != Window.CANCEL) {
					provider.renameSnippet(handle, dialog.getValue().trim());
					ViewerHandle viewerHandle = provider.getViewerHandle();
					if (viewerHandle != null)
						viewerHandle.refresh();
				}

			};

		};
		renameAction.setText("Rename...");
		Action dtlAction = new Action() {
			public void run() {

				if (!MessageDialog
						.openConfirm(
								null,
								"Confirm Delete",
								String.format(
										"Are you sure you want to delete snippet '%s'?",
										handle.getName()))) {
					return;
				}
				boolean deleted = provider.deleteSnippet(handle);
				if (deleted) {
					ViewerHandle viewerHandle = provider.getViewerHandle();
					if (viewerHandle != null)
						viewerHandle.refresh();
				}
			}
		};
		dtlAction.setText(APDEditorMessages.TreeNodeAction_delete);
		return new Action[] { renameAction, null, dtlAction };
	}
}
