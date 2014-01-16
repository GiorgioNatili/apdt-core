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
package org.gnstudio.apdt.model.util;

public class ModelOperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4759264485569468926L;

	public ModelOperationException() {
		super();
	}

	public ModelOperationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ModelOperationException(String arg0) {
		super(arg0);
	}

	public ModelOperationException(Throwable arg0) {
		super(arg0);
	}

}
