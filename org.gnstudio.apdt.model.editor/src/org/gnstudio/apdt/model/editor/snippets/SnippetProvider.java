package org.gnstudio.apdt.model.editor.snippets;

import org.eclipse.emf.ecore.EObject;

public interface SnippetProvider {
	public static final String EXTENSION_POINT_ID = "org.gnstudio.apdt.model.editor.snippetProvider";
	EObject getSnippetData(SnippetHandle handle);
	
	SnippetHandle [] getSnippets();
	
	void setViewerHandle(ViewerHandle handle);
	ViewerHandle getViewerHandle();
	
	public static interface ViewerHandle{
		void refresh();
	}
	
	void addSnippet(String name,EObject data);
	
	boolean deleteSnippet(SnippetHandle handle);
	
	void renameSnippet(SnippetHandle handle,String name);
	
	boolean hasSnippet(String name ,SnippetHandle current);
}
