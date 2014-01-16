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
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeType;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider.Neighbor;

public abstract class AbstractNodeOperation extends AbstractOperation {
	protected ModelContext context;
	protected Object parent;
	protected NodeType nodeType;
	protected NodeMoveProvider moveProvider;
	protected NodeMoveProvider.Neighbor neighbor;
	protected boolean before;
	

	protected AbstractNodeOperation(String label, ModelContext context,
			Object parent, NodeType nodeType,
			NodeMoveProvider moveProvider, Neighbor neighbor, boolean before) {
		super(label);
		this.context = context;
		this.parent = parent;
		this.nodeType = nodeType;
		this.moveProvider = moveProvider;
		this.neighbor = neighbor;
		this.before = before;
	}

	

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		// expect by default execute() = redo()
		return redo(monitor, info);
	}

	

}
