/*******************************************************************************
 * Copyright (c) 2010, 2012 GNstudio s.r.l. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 *
 * Contributors:
 *   GNstudio s.r.l. - initial API and implementation
 *******************************************************************************/
package org.gnstudio.apdt.model.editor.descriptors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Control;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider.FILTER;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.selection.TypeAssistProvider;

public abstract class ReferenceDescriptor extends NodeDetailsDescriptor<String>
		implements ReferenceBrowseSupport {
	private List<ReferenceBrowseProvider> providers;

	public ReferenceDescriptor() {
		super(NodeDetailsDescriptor.TYPE.REFERENCE);
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						ReferenceBrowseProvider.EXTENSION_POINT_ID);
		providers = new ArrayList<ReferenceBrowseProvider>(config.length);
		try {
			for (IConfigurationElement e : config) {
				final Object impl = e.createExecutableExtension("class");
				if (impl instanceof ReferenceBrowseProvider) {
					providers.add((ReferenceBrowseProvider) impl);
				}
			}
		} catch (CoreException ex) {
			APDTLog.log(ex);
		}
	}

	public ReferenceBrowseProvider[] getProviders() {
		List<ReferenceBrowseProvider> suppoted = new ArrayList<ReferenceBrowseProvider>(
				providers.size());

		for (ReferenceBrowseProvider provider : providers) {
			if (provider.isSupported(getContext())) {
				suppoted.add(provider);
			}

		}
		return suppoted.toArray(new ReferenceBrowseProvider[0]);
	}

	public FILTER getFilter() {
		return FILTER.ALL;
	}

	public abstract ModelContext getContext();

	public boolean isSupported() {
		for (ReferenceBrowseProvider provider : providers) {
			if (provider.isSupported(getContext()))
				return true;
		}
		return false;
	}

	@Override
	public void addEditorAssist(Control control) {

		TypeAssistProvider.createTypeAssist(control, getContext().getModel(),
				getFilter());
	}
}
