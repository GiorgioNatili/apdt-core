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
 * A representation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.ClassMember#getNote <em>Note</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ClassMember#getAccess <em>Access</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ClassMember#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ClassMember#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ClassMember#getType <em>Type</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.ClassMember#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember()
 * @model
 * @generated
 */
public interface ClassMember extends DescriptionProvider {
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
	 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember_Note()
	 * @model
	 * @generated
	 */
	String getNote();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ClassMember#getNote <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' attribute.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(String value);

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
	 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ClassMember#getName <em>Name</em>}' attribute.
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
	 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember_Access()
	 * @model
	 * @generated
	 */
	AccessType getAccess();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ClassMember#getAccess <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' attribute.
	 * @see org.gnstudio.apdt.model.AccessType
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(AccessType value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeReference)
	 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeReference getType();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ClassMember#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeReference value);

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
	 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember_Annotation()
	 * @model
	 * @generated
	 */
	String getAnnotation();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ClassMember#getAnnotation <em>Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' attribute.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(String value);

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
	 * @see org.gnstudio.apdt.model.ModelPackage#getClassMember_Declaration()
	 * @model
	 * @generated
	 */
	DeclarationType getDeclaration();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.ClassMember#getDeclaration <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' attribute.
	 * @see org.gnstudio.apdt.model.DeclarationType
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(DeclarationType value);

} // ClassMember
