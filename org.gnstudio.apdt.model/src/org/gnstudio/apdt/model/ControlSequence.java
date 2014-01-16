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
 * A representation of the model object '<em><b>Control Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.ControlSequence#getIfGroup <em>If Group</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ControlSequence#getElseifGroups <em>Elseif Groups</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ControlSequence#getElseGroup <em>Else Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getControlSequence()
 * @model
 * @generated
 */
public interface ControlSequence extends Sequence {
	/**
	 * Returns the value of the '<em><b>If Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Group</em>' containment reference.
	 * @see #setIfGroup(SequenceGroup)
	 * @see org.gnstudio.apdt.model.ModelPackage#getControlSequence_IfGroup()
	 * @model containment="true"
	 * @generated
	 */
	SequenceGroup getIfGroup();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ControlSequence#getIfGroup <em>If Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Group</em>' containment reference.
	 * @see #getIfGroup()
	 * @generated
	 */
	void setIfGroup(SequenceGroup value);

	/**
	 * Returns the value of the '<em><b>Elseif Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.SequenceGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elseif Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elseif Groups</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getControlSequence_ElseifGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceGroup> getElseifGroups();

	/**
	 * Returns the value of the '<em><b>Else Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Group</em>' containment reference.
	 * @see #setElseGroup(SequenceGroup)
	 * @see org.gnstudio.apdt.model.ModelPackage#getControlSequence_ElseGroup()
	 * @model containment="true"
	 * @generated
	 */
	SequenceGroup getElseGroup();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ControlSequence#getElseGroup <em>Else Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Group</em>' containment reference.
	 * @see #getElseGroup()
	 * @generated
	 */
	void setElseGroup(SequenceGroup value);

} // ControlSequence
