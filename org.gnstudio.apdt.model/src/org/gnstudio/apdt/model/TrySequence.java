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
 * A representation of the model object '<em><b>Try Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.TrySequence#getTryGroup <em>Try Group</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.TrySequence#getCatchGroups <em>Catch Groups</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.TrySequence#getFinallyGroup <em>Finally Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getTrySequence()
 * @model
 * @generated
 */
public interface TrySequence extends Sequence {
	/**
	 * Returns the value of the '<em><b>Try Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Try Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Try Group</em>' containment reference.
	 * @see #setTryGroup(SequenceGroup)
	 * @see org.gnstudio.apdt.model.ModelPackage#getTrySequence_TryGroup()
	 * @model containment="true"
	 * @generated
	 */
	SequenceGroup getTryGroup();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.TrySequence#getTryGroup <em>Try Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Try Group</em>' containment reference.
	 * @see #getTryGroup()
	 * @generated
	 */
	void setTryGroup(SequenceGroup value);

	/**
	 * Returns the value of the '<em><b>Catch Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.SequenceGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch Groups</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getTrySequence_CatchGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceGroup> getCatchGroups();

	/**
	 * Returns the value of the '<em><b>Finally Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally Group</em>' containment reference.
	 * @see #setFinallyGroup(SequenceGroup)
	 * @see org.gnstudio.apdt.model.ModelPackage#getTrySequence_FinallyGroup()
	 * @model containment="true"
	 * @generated
	 */
	SequenceGroup getFinallyGroup();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.TrySequence#getFinallyGroup <em>Finally Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally Group</em>' containment reference.
	 * @see #getFinallyGroup()
	 * @generated
	 */
	void setFinallyGroup(SequenceGroup value);

} // TrySequence
