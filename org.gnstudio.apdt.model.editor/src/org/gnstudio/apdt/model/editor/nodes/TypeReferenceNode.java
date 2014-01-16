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
package org.gnstudio.apdt.model.editor.nodes;

import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider.FILTER;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceDescriptor;

public class TypeReferenceNode extends AbstractNode<TypeReference> {
	private final FILTER typeFilter;

	public TypeReferenceNode(AbstractNode<?> parent, TypeReference element,
			NodeDeleteProvider<TypeReference> deleteProvider) {
		this(parent, element, deleteProvider, FILTER.ALL);
	}

	public TypeReferenceNode(AbstractNode<?> parent, TypeReference element,
			NodeDeleteProvider<TypeReference> deleteProvider, FILTER typeFilter) {
		super(parent, element, deleteProvider);
		this.typeFilter = typeFilter;
	}

	@Override
	public String getName() {
		String name = source.getName();
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_empty;
		}
		return name;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_TAG;
	}

	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		ReferenceDescriptor nameDesc = new ReferenceDescriptor() {

			@Override
			public String getValue() {
				return source.getName();
			}

			@Override
			public void setValue(String value) {
				source.setName(value);
				context.modelUpdated();
				context.refreah(TypeReferenceNode.this);
				context.refreah(TypeReferenceNode.this.getParent());

			}

			public ModelContext getContext() {
				return context;
			}

			@Override
			public FILTER getFilter() {
				return typeFilter;
			}
		};
		nameDesc.setRequired(true);
		nameDesc.setText(APDEditorMessages.TreeNode_type_ref_name);
		nameDesc.setTooltip(APDEditorMessages.TreeNode_type_ref_name_dec);

		return new NodeDetailsDescriptor[] { nameDesc };
	}

}