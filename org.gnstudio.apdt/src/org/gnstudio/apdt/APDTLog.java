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
package org.gnstudio.apdt;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;

public class APDTLog {
	private APDTLog() {
	}

	public static void log(IStatus status) {
		ResourcesPlugin.getPlugin().getLog().log(status);
	}

	public static void logErrorMessage(String message) {
		log(new Status(IStatus.ERROR, APDTPlugin.getID(), IStatus.ERROR,
				message, null));
	}

	public static void logInfoMessage(String message) {
		log(new Status(IStatus.INFO, APDTPlugin.getID(), IStatus.INFO, message,
				null));
	}

	public static void logWarnningMessage(String message) {
		log(new Status(IStatus.WARNING, APDTPlugin.getID(), IStatus.WARNING,
				message, null));
	}

	public static void logException(Throwable e, final String title,
			String message) {
		if (e instanceof InvocationTargetException) {
			e = ((InvocationTargetException) e).getTargetException();
		}
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException) e).getStatus();
		} else {
			if (message == null)
				message = e.getMessage();
			if (message == null)
				message = e.toString();
			status = new Status(IStatus.ERROR, APDTPlugin.getID(), IStatus.OK,
					message, e);
		}
		ResourcesPlugin.getPlugin().getLog().log(status);
		Display display = APDTPlugin.getStandardDisplay();
		final IStatus fstatus = status;
		display.asyncExec(new Runnable() {
			public void run() {
				ErrorDialog.openError(null, title, null, fstatus);
			}
		});
	}

	public static void logException(Throwable e) {
		logException(e, null, null);
	}

	public static void log(Throwable e) {
		if (e instanceof InvocationTargetException) {
			e = ((InvocationTargetException) e).getTargetException();
		}

		IStatus status = null;

		if (e instanceof CoreException) {
			status = ((CoreException) e).getStatus();
		} else {
			status = new Status(IStatus.ERROR, APDTPlugin.getID(), IStatus.OK,
					e.getMessage(), e);
		}

		log(status);
	}
}
