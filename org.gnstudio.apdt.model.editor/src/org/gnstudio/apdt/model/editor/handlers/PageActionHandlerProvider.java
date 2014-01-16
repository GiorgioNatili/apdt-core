package org.gnstudio.apdt.model.editor.handlers;

public interface PageActionHandlerProvider {

	boolean isHandlerActive(String commandId);

	PageActionHandler getActionHandler(String commandId);

}
