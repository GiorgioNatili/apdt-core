package org.gnstudio.apdt.model.editor;

public interface EditorPageProvider {
	// This is the ID for EditorPageProvider extension point
	public static final String EXTENSION_POINT_ID = "org.gnstudio.apdt.model.editor.editorPageProvider";

	AbstractEditorPage[] createPages(APDModelEditor editor);
}
