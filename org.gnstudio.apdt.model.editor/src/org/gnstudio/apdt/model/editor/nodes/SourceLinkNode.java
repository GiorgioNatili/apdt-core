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

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.gnstudio.apdt.APDTLog;
import org.gnstudio.apdt.model.SourceLink;
import org.gnstudio.apdt.model.SourceLinkProvider;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.SourceLinkDescriptor;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class SourceLinkNode extends AbstractNode<SourceLink> implements
		NodeCategory {

	public SourceLinkNode(AbstractNode<?> parent, SourceLink link,
			NodeDeleteProvider<SourceLink> deleteProvider) {
		super(parent, link, deleteProvider);
	}

	public String getName() {
		String name = source.getPath();
		if (name == null || name.length() == 0 || getLinkIResource() == null) {
			name = APDEditorMessages.TreeNode_link;
		}
		return name;
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.resource");
	}
	
	@Override
	public Action[] getActions(ModelContext context) {
		Action linkOpenAction = new Action() {
			public void run() {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource linkIResource = getLinkIResource();
				IWorkbenchPage page = APDEditorPlugin
						.getActiveWorkbenchWindow().getActivePage();
				IFile file = root.getFile(linkIResource.getFullPath());
				IEditorDescriptor desc = PlatformUI.getWorkbench()
						.getEditorRegistry().getDefaultEditor(file.getName());

				try {
					page.openEditor(new FileEditorInput(file),
							desc != null ? desc.getId()
									: IEditorRegistry.SYSTEM_EXTERNAL_EDITOR_ID);
				} catch (PartInitException e) {
					APDTLog.log(e);
				}
			}

			@Override
			public boolean isEnabled() {
				return getLinkIResource() != null;
			}
		};
		linkOpenAction.setText("Open Link Resource");
		return new Action[] { linkOpenAction };
	}

	@Override
	public String getToolTipText() {
		return source.getPath();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		String name = source.getPath();
		// TODO: try to verify is it on workspace
		if (name == null || name.length() == 0) {
			return APDEditorImages.createOverlay(
					APDEditorImages.DESC_MODEL_LINK,
					APDEditorImages.DESC_MODEL_UNCONFIGURED_OV,
					IDecoration.TOP_LEFT);
		}
		return APDEditorImages.DESC_MODEL_LINK;
	}

	public int getCategory() {
		return CATEGORY_LINK;
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		// name
		SourceLinkDescriptor nameDesc = new SourceLinkDescriptor() {

			@Override
			public String getValue() {
				return source.getPath();
			}

			@Override
			public void setValue(String value) {
				source.setPath(value);
				context.modelUpdated();
				context.refreah(SourceLinkNode.this);

			}

			public ModelContext getContext() {
				return context;
			}

		};
		nameDesc.setRequired(true);
		nameDesc.setText("Link Resource");// TODO : add key
		// nameDesc.setTooltip(APDEditorMessages.TreeNode_type_ref_name_dec);

		return new NodeDetailsDescriptor[] { nameDesc };
	}

	public static NodeDeleteProvider<SourceLink> createDeleteProvider(
			final AbstractNode<?> node, final SourceLinkProvider provider) {
		return new NodeDeleteProvider<SourceLink>() {

			public void delete(ModelContext context, SourceLink sequence) {
				provider.setLink(null);
				context.modelUpdated();
				context.refreah(node);
			}

			public AbstractOperation createDeleteOperation(
					final ModelContext context, final SourceLink t) {
				return new AbstractDeleteOperation() {

					@Override
					public IStatus undo(IProgressMonitor monitor,
							IAdaptable info) {
						provider.setLink(t);
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

	public static Action newSourceLinkAction(final ModelContext context,
			final AbstractNode<?> node, final SourceLinkProvider provider) {
		Action descAction = new Action() {
			@Override
			public boolean isEnabled() {
				return (provider.getLink() == null);
			}

			public void run() {
				NodeActions.createNewNode(context, node, NodeType.SOURCE_LINK);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_link);
		return descAction;
	}

	private IResource getLinkIResource() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource selection = null;
		if (source.getPath() != null) {
			selection = root.findMember(source.getPath());
		}
		return selection;
	}
}