package org.gnstudio.apdt.model.editor.snippets;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.gnstudio.apdt.APDTLog;

public class SnippetUtil {
	private static volatile SnippetProvider provider;

	private SnippetUtil() {
	}

	public static synchronized SnippetProvider getSnippetProvider() {
		if (provider != null) {
			return provider;
		}
		IConfigurationElement[] config = Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor(SnippetProvider.EXTENSION_POINT_ID);

		try {

			for (IConfigurationElement element : config) {
				final Object impl = element.createExecutableExtension("class");
				if (impl instanceof SnippetProvider) {
					provider = (SnippetProvider) impl;
					break;
				}
			}
		} catch (CoreException ex) {
			APDTLog.log(ex);
		}
		return provider;
	}
}
