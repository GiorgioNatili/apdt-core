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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.DescriptionProvider#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getDescriptionProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DescriptionProvider extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference.
	 * @see #setDescription(Description)
	 * @see org.gnstudio.apdt.model.ModelPackage#getDescriptionProvider_Description()
	 * @model containment="true"
	 * @generated
	 */
	Description getDescription();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.DescriptionProvider#getDescription <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' containment reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(Description value);

} // DescriptionProvider
