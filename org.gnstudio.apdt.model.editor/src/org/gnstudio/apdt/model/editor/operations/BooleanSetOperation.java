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
import org.gnstudio.apdt.model.editor.nodes.ModelContext;

public abstract class BooleanSetOperation extends AbstractOperation {

	protected final boolean oldValue;
	private boolean newValue;
	private boolean init = true;

	public BooleanSetOperation(boolean oldValue) {
		super("Boolean->Set");
		this.oldValue = oldValue;
	}

	@Override
	public IStatus execute(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		setBoolean(newValue);
		return Status.OK_STATUS;
	}

	@Override
	public IStatus redo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		
		return execute(monitor, info);
	}

	@Override
	public IStatus undo(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		setBoolean(oldValue);
		return Status.OK_STATUS;
	}

	public void updateBoolean(final ModelContext context,boolean newValue) {
		this.newValue = newValue;
		if (init) {
			init = false;
			context.getOperationSupport().execute(this, null);
		}else{
			setBoolean(newValue);
		}
		
	}


	public abstract void setBoolean(boolean b);

}
