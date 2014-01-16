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
 * A representation of the model object '<em><b>Method Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.MethodSignature#getName <em>Name</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.MethodSignature#getAccess <em>Access</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.MethodSignature#getType <em>Type</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.MethodSignature#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.MethodSignature#isVarargs <em>Varargs</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.MethodSignature#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature()
 * @model
 * @generated
 */
public interface MethodSignature extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.MethodSignature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Access</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gnstudio.apdt.model.AccessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access</em>' attribute.
	 * @see org.gnstudio.apdt.model.AccessType
	 * @see #setAccess(AccessType)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature_Access()
	 * @model
	 * @generated
	 */
	AccessType getAccess();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.MethodSignature#getAccess <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' attribute.
	 * @see org.gnstudio.apdt.model.AccessType
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(AccessType value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gnstudio.apdt.model.MethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.gnstudio.apdt.model.MethodType
	 * @see #setType(MethodType)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature_Type()
	 * @model
	 * @generated
	 */
	MethodType getType();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.MethodSignature#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.gnstudio.apdt.model.MethodType
	 * @see #getType()
	 * @generated
	 */
	void setType(MethodType value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gnstudio.apdt.model.DeclarationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' attribute.
	 * @see org.gnstudio.apdt.model.DeclarationType
	 * @see #setDeclaration(DeclarationType)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature_Declaration()
	 * @model
	 * @generated
	 */
	DeclarationType getDeclaration();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.MethodSignature#getDeclaration <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' attribute.
	 * @see org.gnstudio.apdt.model.DeclarationType
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(DeclarationType value);

	/**
	 * Returns the value of the '<em><b>Varargs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varargs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varargs</em>' attribute.
	 * @see #setVarargs(boolean)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature_Varargs()
	 * @model
	 * @generated
	 */
	boolean isVarargs();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.MethodSignature#isVarargs <em>Varargs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varargs</em>' attribute.
	 * @see #isVarargs()
	 * @generated
	 */
	void setVarargs(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(TypeReference)
	 * @see org.gnstudio.apdt.model.ModelPackage#getMethodSignature_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	TypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.MethodSignature#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(TypeReference value);

} // MethodSignature
