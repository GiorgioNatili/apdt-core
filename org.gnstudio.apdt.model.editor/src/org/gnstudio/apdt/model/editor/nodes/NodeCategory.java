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

public interface NodeCategory {
	int getCategory();

	public static final int CATEGORY_DESCRIPTION = 0;
	public static final int CATEGORY_DISCUSSION = 1;
	public static final int CATEGORY_LINK = 2;
	public static final int CATEGORY_METHOD_ARGS = 5;
	public static final int CATEGORY_THROWS = 10;
	public static final int CATEGORY_EXTENDS = 15;
	public static final int CATEGORY_IMPLEMENTS = 20;
	public static final int CATEGORY_INTERFACE = 50;
	public static final int CATEGORY_CLASS = 100;
	public static final int CATEGORY_CLASS_MEMBER = 500;
	public static final int CATEGORY_METHOD = 1000;
	public static final int CATEGORY_SEQUENCE = 2000;
}
