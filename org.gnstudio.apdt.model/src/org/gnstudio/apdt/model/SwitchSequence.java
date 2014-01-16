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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.SwitchSequence#getNote <em>Note</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.SwitchSequence#getCases <em>Cases</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.SwitchSequence#getDefaultCase <em>Default Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getSwitchSequence()
 * @model
 * @generated
 */
public interface SwitchSequence extends Sequence, DescriptionProvider {
	/**
	 * Returns the value of the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' attribute.
	 * @see #setNote(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getSwitchSequence_Note()
	 * @model
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.SwitchSequence#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.SequenceGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getSwitchSequence_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceGroup> getCases();

	/**
	 * Returns the value of the '<em><b>Default Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Case</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Case</em>' containment reference.
	 * @see #setDefaultCase(SequenceGroup)
	 * @see org.gnstudio.apdt.model.ModelPackage#getSwitchSequence_DefaultCase()
	 * @model containment="true"
	 * @generated
	 */
	SequenceGroup getDefaultCase();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.SwitchSequence#getDefaultCase <em>Default Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Case</em>' containment reference.
	 * @see #getDefaultCase()
	 * @generated
	 */
	void setDefaultCase(SequenceGroup value);

} // SwitchSequence
