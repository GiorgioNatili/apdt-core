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
package org.gnstudio.apdt.model.editor.operations;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

public abstract class AbstractDeleteOperation extends AbstractOperation {

	protected AbstractDeleteOperation() {
		super("Delete Node");

	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		// expect by default execute() = redo()
		return redo(monitor, info);
	}

	public static AbstractOperation create(ModelContext context, AbstractNode<?> node,
			EList<? extends EObject> eList, EObject source) {
		return new ListDelete(context, node, eList, source);
	}

	private static class ListDelete extends AbstractDeleteOperation {
		private final ModelContext context;
		private final EList<EObject> eList;
		private final EObject source;
		private final AbstractNode<?> node;

		@SuppressWarnings("unchecked")
		public ListDelete(ModelContext context, AbstractNode<?> node,
				EList<? extends EObject> eList, EObject source) {
			this.context = context;
			this.node = node;
			this.eList = (EList<EObject>) eList;
			this.source = source;
		}

		private int index;

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			if (index > -1 && eList.size() > index)
				eList.add(index, source);
			else
				eList.add(source);
			context.modelUpdated();
			context.refreah(node);
			return Status.OK_STATUS;
		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			index = eList.indexOf(source);
			eList.remove(source);
			context.modelUpdated();
			context.refreah(node);
			return Status.OK_STATUS;
		}

	}
}
