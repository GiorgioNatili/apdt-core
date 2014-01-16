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
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.Method#getNote <em>Note</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Method#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Method#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Method#getThrowsElements <em>Throws Elements</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Method#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends DescriptionProvider, DiscussionProvider, SequenceProvider {
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
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethod_Note()
	 * @model
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Method#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' attribute.
	 * @see #setAnnotation(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethod_Annotation()
	 * @model
	 * @generated
	 */
	String getAnnotation();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Method#getAnnotation <em>Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' attribute.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' containment reference.
	 * @see #setSignature(MethodSignature)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethod_Signature()
	 * @model containment="true"
	 * @generated
	 */
	MethodSignature getSignature();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Method#getSignature <em>Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' containment reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(MethodSignature value);

	/**
	 * Returns the value of the '<em><b>Throws Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.TypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throws Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throws Elements</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethod_ThrowsElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeReference> getThrowsElements();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.MethodArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethod_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodArgument> getArguments();

} // Method
