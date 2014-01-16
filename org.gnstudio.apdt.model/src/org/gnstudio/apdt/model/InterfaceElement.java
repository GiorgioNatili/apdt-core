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
 * A representation of the model object '<em><b>Interface Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.InterfaceElement#getName <em>Name</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.InterfaceElement#getAccess <em>Access</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.InterfaceElement#getExtendsElements <em>Extends Elements</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.InterfaceElement#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getInterfaceElement()
 * @model
 * @generated
 */
public interface InterfaceElement extends DescriptionProvider, DiscussionProvider, SourceLinkProvider {
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
	 * @see org.gnstudio.apdt.model.ModelPackage#getInterfaceElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.InterfaceElement#getName <em>Name</em>}' attribute.
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
	 * @see org.gnstudio.apdt.model.ModelPackage#getInterfaceElement_Access()
	 * @model
	 * @generated
	 */
	AccessType getAccess();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.InterfaceElement#getAccess <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access</em>' attribute.
	 * @see org.gnstudio.apdt.model.AccessType
	 * @see #getAccess()
	 * @generated
	 */
	void setAccess(AccessType value);

	/**
	 * Returns the value of the '<em><b>Extends Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.TypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Elements</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getInterfaceElement_ExtendsElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeReference> getExtendsElements();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getInterfaceElement_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Method> getMethods();

} // InterfaceElement
