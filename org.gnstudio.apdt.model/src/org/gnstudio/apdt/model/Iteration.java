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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.Iteration#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getIteration()
 * @model
 * @generated
 */
public interface Iteration extends SequenceGroup {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * The literals are from the enumeration {@link org.gnstudio.apdt.model.IterationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.gnstudio.apdt.model.IterationType
	 * @see #setType(IterationType)
	 * @see org.gnstudio.apdt.model.ModelPackage#getIteration_Type()
	 * @model default=""
	 * @generated
	 */
	IterationType getType();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Iteration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.gnstudio.apdt.model.IterationType
	 * @see #getType()
	 * @generated
	 */
	void setType(IterationType value);

} // Iteration
