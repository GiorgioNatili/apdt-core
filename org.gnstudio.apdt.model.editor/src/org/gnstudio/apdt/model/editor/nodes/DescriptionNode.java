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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.DescriptionProvider;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class DescriptionNode extends AbstractNode<Description> implements
		NodeCategory {
	private static final Pattern TODO_PATTERN = Pattern.compile(
			"[tT][oO][dD][oO]", Pattern.MULTILINE);

	public DescriptionNode(AbstractNode<?> parent, Description description,
			NodeDeleteProvider<Description> deleteProvider) {
		super(parent, description, deleteProvider);
	}

	public String getName() {
		String name = getTextOverview(source);
		if (name == null || name.length() == 0) {
			name = APDEditorMessages.TreeNode_description;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.description");
	}
	
	@Override
	public String getToolTipText() {
		return source.getText();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return APDEditorImages.DESC_MODEL_COMMNETS;
	}

	public int getCategory() {
		return CATEGORY_DESCRIPTION;
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		NodeDetailsDescriptor<String> descriptionDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.DESCRIPTION) {

			@Override
			public String getValue() {
				return source.getText();
			}

			@Override
			public void setValue(String value) {
				source.setText(value);
				context.modelUpdated();
				if (DescriptionNode.this.getParent() != null)
					context.refreah(DescriptionNode.this.getParent());
				context.refreah(DescriptionNode.this);

			}
		};
		descriptionDesc.setText(APDEditorMessages.TreeNode_description_name);
		descriptionDesc.setTooltip(APDEditorMessages.TreeNode_description_dec);

		return new NodeDetailsDescriptor[] { descriptionDesc };
	}

	public static String getTextOverview(Description description) {
		String overview = description.getText();
		// remove all line breaks from a description
		overview = overview.replaceAll("\\r\\n|\\r|\\n", " ");//$NON-NLS-1$
		if (overview != null && overview.length() > 100) {
			overview = overview.substring(0, 100);
			overview += "...";//$NON-NLS-1$
		}
		return overview;
	}

	public static NodeDeleteProvider<Description> createDeleteProvider(
			final AbstractNode<?> node, final DescriptionProvider provider) {
		return new NodeDeleteProvider<Description>() {

			public void delete(ModelContext context, Description sequence) {
				provider.setDescription(null);
				context.modelUpdated();
				context.refreah(node);
			}

			public AbstractOperation createDeleteOperation(
					final ModelContext context, final Description t) {
				return new AbstractDeleteOperation() {

					@Override
					public IStatus undo(IProgressMonitor monitor,
							IAdaptable info) {
						provider.setDescription(t);
						context.modelUpdated();
						context.refreahAll();
						return Status.OK_STATUS;
					}

					@Override
					public IStatus redo(IProgressMonitor monitor,
							IAdaptable info) {
						delete(context, t);
						return Status.OK_STATUS;
					}
				};
			}
		};
	}

	public static Action newDescripationAction(final ModelContext context,
			final AbstractNode<?> node, final DescriptionProvider provider) {
		Action descAction = new Action() {
			@Override
			public boolean isEnabled() {
				return (provider.getDescription() == null);
			}

			public void run() {
				NodeActions.createNewNode(context, node, NodeType.DESCRIPTION);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_description);
		return descAction;
	}

	public static boolean todoDescription(Description description) {

		if (description != null && description.getText() != null) {
			String text = description.getText();
			Matcher matcher = TODO_PATTERN.matcher(text);
			return matcher.find();
		}
		return false;
	}
}