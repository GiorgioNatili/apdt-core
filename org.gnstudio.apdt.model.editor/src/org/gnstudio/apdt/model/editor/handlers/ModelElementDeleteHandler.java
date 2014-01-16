package org.gnstudio.apdt.model.editor.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeDeleteProvider;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class ModelElementDeleteHandler implements PageActionHandler {
	private final ModelContext context;
	private final ISelectionProvider selectionProvider;

	public ModelElementDeleteHandler(ModelContext context,
			ISelectionProvider selectionProvider) {
		this.context = context;
		this.selectionProvider = selectionProvider;
	}

	public boolean isEnable() {
		ISelection selection = selectionProvider.getSelection();

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strutruredSelection = (IStructuredSelection) selection;
			if (strutruredSelection.isEmpty())
				return false;

			for (Iterator<?> iterator = strutruredSelection.iterator(); iterator
					.hasNext();) {
				Object type = iterator.next();
				if (!(type instanceof AbstractNode)
						|| ((AbstractNode<?>) type).getDeleteProvider() == null)
					return false;
			}

			return true;

		}

		return false;
	}

	public void excecute() {
		ISelection selection = selectionProvider.getSelection();

		if (context != null && selection instanceof IStructuredSelection) {
			IStructuredSelection strutruredSelection = (IStructuredSelection) selection;

			if (strutruredSelection.size() == 1) {
				Object type = strutruredSelection.getFirstElement();
				if ((type instanceof AbstractNode)) {
					AbstractNode<?> node = ((AbstractNode<?>) type);
					@SuppressWarnings("unchecked")
					NodeDeleteProvider<Object> deleteProvider = (NodeDeleteProvider<Object>) node
							.getDeleteProvider();
					if (deleteProvider != null) {
						context.getOperationSupport().execute(
								deleteProvider.createDeleteOperation(context,
										node.getSource()), null);
					}
				}

			} else {
				final List<AbstractOperation> operations = new ArrayList<AbstractOperation>();
				for (Iterator<?> iterator = strutruredSelection.iterator(); iterator
						.hasNext();) {
					Object type = iterator.next();
					if ((type instanceof AbstractNode)) {
						AbstractNode<?> node = ((AbstractNode<?>) type);
						@SuppressWarnings("unchecked")
						NodeDeleteProvider<Object> deleteProvider = (NodeDeleteProvider<Object>) node
								.getDeleteProvider();
						if (deleteProvider != null) {
							operations.add(deleteProvider
									.createDeleteOperation(context,
											node.getSource()));
						}
					}

				}
				AbstractDeleteOperation deleteOp = new AbstractDeleteOperation() {

					@Override
					public IStatus undo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						for (AbstractOperation abstractOperation : operations) {
							abstractOperation.undo(monitor, info);
						}
						return Status.OK_STATUS;
					}

					@Override
					public IStatus redo(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						List<AbstractOperation> ops = new ArrayList<AbstractOperation>(
								operations);
						Collections.reverse(ops);
						for (AbstractOperation abstractOperation : ops) {
							abstractOperation.redo(monitor, info);
						}
						return Status.OK_STATUS;
					}
				};
				context.getOperationSupport().execute(deleteOp, null);

			}
		}

	}
}
