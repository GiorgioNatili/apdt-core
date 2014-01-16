package org.gnstudio.apdt.model.editor.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.gnstudio.apdt.APDTLog;

public class ModelElementRedoHandler implements PageActionHandler {
	private final IOperationHistory operationHistory;
	private final IUndoContext undoContext;

	public ModelElementRedoHandler(IOperationHistory operationHistory,
			IUndoContext undoContext) {
		this.operationHistory = operationHistory;
		this.undoContext = undoContext;
	}

	public boolean isEnable() {
		return operationHistory.canRedo(undoContext);
	}

	public void excecute() {
		try {
			operationHistory.redo(undoContext, null, null);
		} catch (ExecutionException e) {
			APDTLog.log(e);
		}

	}

}
