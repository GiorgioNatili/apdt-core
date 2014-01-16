package org.gnstudio.apdt.model.editor.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeTransfer;
import org.gnstudio.apdt.model.util.ModelOperation;

public class ModelElementPasteHandler implements PageActionHandler {
	private final ModelContext context;
	private final ISelectionProvider selectionProvider;

	public ModelElementPasteHandler(ModelContext context,
			ISelectionProvider selectionProvider) {
		this.context = context;
		this.selectionProvider = selectionProvider;
	}

	public boolean isEnable() {
		ISelection selection = selectionProvider.getSelection();
		final Clipboard clipboard = new Clipboard(
				APDEditorPlugin.getStandardDisplay());
		Object contents = clipboard.getContents(NodeTransfer.getInstance());
		if (contents != null) {
			NodeMoveProvider provider = null;
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection strutruredSelection = (IStructuredSelection) selection;
				// support one selection only
				if (strutruredSelection.size() > 1)
					return false;

				Object element = strutruredSelection.getFirstElement();
				if (element == null) {
					provider = context.getRootNodeMoveProvider();
				} else if (element instanceof NodeMoveProvider) {

					provider = (NodeMoveProvider) element;
				}
			}
			boolean valid = false;
			if (provider != null && contents instanceof Object[]) {
				Object[] elements = (Object[]) contents;

				for (int i = 0; i < elements.length; i++) {
					Object element = elements[i];
					valid = provider.canMove(null, element);
					if (!valid)
						break;
				}
			}
			return valid;
		}

		return false;
	}

	public void excecute() {
		ISelection selection = selectionProvider.getSelection();
		final Clipboard clipboard = new Clipboard(
				APDEditorPlugin.getStandardDisplay());
		Object contents = clipboard.getContents(NodeTransfer.getInstance());
		if (contents instanceof Object[]) {

			NodeMoveProvider provider = null;

			AbstractNode<?> node = null;
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection strutruredSelection = (IStructuredSelection) selection;
				// support one selection only
				if (strutruredSelection.size() > 1)
					return;

				Object element = strutruredSelection.getFirstElement();
				if (element == null)
					provider = context.getRootNodeMoveProvider();
				else if (element instanceof NodeMoveProvider) {
					provider = (NodeMoveProvider) element;
				}
				if (element instanceof AbstractNode) {
					node = (AbstractNode<?>) element;
				}
			}
			Object[] elements = (Object[]) contents;
			final List<AbstractOperation> operations = new ArrayList<AbstractOperation>(
					elements.length);
			for (int i = 0; i < elements.length; i++) {
				Object element = elements[i];
				if (context != null && provider != null
						&& element instanceof EObject
						&& provider.canMove(null, element)) {

					final Object source = ModelOperation
							.copyElement((EObject) element);
					final NodeMoveProvider moveProvider = provider;
					final AbstractNode<?> parentNode = node;
					AbstractOperation pasteOpration = new AbstractOperation(
							"Paste") {

						@Override
						public IStatus undo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							AbstractNode<?> sourceNode = context
									.findNode(source);
							if (sourceNode != null) {
								@SuppressWarnings("unchecked")
								NodeDeleteProvider<Object> deleteProvider = (NodeDeleteProvider<Object>) sourceNode
										.getDeleteProvider();
								if (deleteProvider != null) {
									deleteProvider.delete(context, source);
								}
								context.modelUpdated();
								context.refreah(parentNode);
							}
							return Status.OK_STATUS;
						}

						@Override
						public IStatus redo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							moveProvider.move(context, null, source, false);
							context.modelUpdated();
							context.refreah(parentNode);
							return Status.OK_STATUS;
						}

						@Override
						public IStatus execute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							return redo(monitor, info);
						}
					};
					operations.add(pasteOpration);
				}
			}
			
			if (operations.size() > 0) {
				if (operations.size() == 1) {
					context.getOperationSupport().execute(operations.get(0),
							null);
				} else {
					AbstractOperation proxyOp = new AbstractOperation("Paste") {

						@Override
						public IStatus undo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							List<AbstractOperation> ops = new ArrayList<AbstractOperation>(
									operations);
							Collections.reverse(ops);
							for (AbstractOperation abstractOperation : ops) {
								abstractOperation.undo(monitor, info);
							}
							return Status.OK_STATUS;
						}

						@Override
						public IStatus redo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {

							for (AbstractOperation abstractOperation : operations) {
								abstractOperation.redo(monitor, info);
							}
							return Status.OK_STATUS;
						}

						@Override
						public IStatus execute(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							return redo(monitor, info);
						}
					};
					context.getOperationSupport().execute(proxyOp, null);
				}
			}
		}

	}

}
