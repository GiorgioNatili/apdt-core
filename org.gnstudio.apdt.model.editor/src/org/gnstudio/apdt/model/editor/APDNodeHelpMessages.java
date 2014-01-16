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
package org.gnstudio.apdt.model.editor;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class APDNodeHelpMessages  {
	private static final String BUNDLE_NAME = "org.gnstudio.apdt.model.editor.nodehelp"; //$NON-NLS-1$

	 private static final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
	   
     public static String getNLS(String key) {
      try {
         return bundle.getString(key);
      } catch (MissingResourceException e) {
         return key;
      }
      }

	private APDNodeHelpMessages() {
	}
}
