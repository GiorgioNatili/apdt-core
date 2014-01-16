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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Movable;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeTransfer;

public class ModelElementCopyCutHandler implements PageActionHandler {
	private final ModelContext context;
	private final ISelectionProvider selectionProvider;
	private final boolean copyMode;

	public ModelElementCopyCutHandler(ModelContext context,
			ISelectionProvider selectionProvider, boolean copyMode) {
		this.context = context;
		this.selectionProvider = selectionProvider;
		this.copyMode = copyMode;
	}

	public boolean isEnable() {
		ISelection selection = selectionProvider.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strutruredSelection = (IStructuredSelection) selection;
			// support one selection only
			if (strutruredSelection.size() == 0)
				return false;
			boolean valid = false;
			Object[] elements = strutruredSelection.toArray();

			for (int i = 0; i < elements.length; i++) {
				Object element = elements[i];
				valid = (element instanceof AbstractNode
						&& element instanceof Movable && ((Movable) element)
						.canMove());
				if (!valid)
					break;
			}

			return valid;
		}
		return false;
	}

	public void excecute() {
		ISelection selection = selectionProvider.getSelection();

		if (selection instanceof IStructuredSelection) {

			IStructuredSelection strutruredSelection = (IStructuredSelection) selection;
			// support one selection only
			if (strutruredSelection.size() == 0)
				return;

			Object[] elements = strutruredSelection.toArray();
			Object[] sources = new Object[elements.length];

			final List<AbstractOperation> operations = new ArrayList<AbstractOperation>(
					elements.length);
			for (int i = 0; i < elements.length; i++) {
				Object object = elements[i];
				if (context != null && object instanceof AbstractNode<?>
						&& object instanceof Movable
						&& ((Movable) object).canMove()) {
					AbstractNode<?> node = (AbstractNode<?>) object;
					if (!copyMode) {
						@SuppressWarnings("unchecked")
						NodeDeleteProvider<Object> deleteProvider = (NodeDeleteProvider<Object>) node
								.getDeleteProvider();
						if (deleteProvider != null)
							operations.add(deleteProvider
									.createDeleteOperation(context,
											node.getSource()));
					}

					Object source;
					if (node instanceof NodeMoveProvider.Neighbor)
						source = ((NodeMoveProvider.Neighbor) node)
								.getNeighborSource();
					else
						source = node.getSource();

					sources[i] = source;

				} else {
					return;
				}
			}

			if (operations.size() > 0) {
				if (operations.size() == 1) {
					context.getOperationSupport().execute(operations.get(0),
							null);
				} else {
					AbstractOperation proxyOp = new AbstractOperation("Delete") {

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

			Clipboard clipboard = new Clipboard(
					APDEditorPlugin.getStandardDisplay());
			clipboard.setContents(new Object[] { sources },
					new Transfer[] { NodeTransfer.getInstance() },
					DND.CLIPBOARD);

		}

	}
}
