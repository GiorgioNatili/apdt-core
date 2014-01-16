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
package org.gnstudio.apdt.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Discussion Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.DiscussionProvider#getDiscussions <em>Discussions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getDiscussionProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DiscussionProvider extends EObject {
	/**
	 * Returns the value of the '<em><b>Discussions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.Discussion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discussions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discussions</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getDiscussionProvider_Discussions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Discussion> getDiscussions();

} // DiscussionProvider
