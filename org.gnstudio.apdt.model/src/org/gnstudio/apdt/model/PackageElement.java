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
 * A representation of the model object '<em><b>Package Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.PackageElement#getName <em>Name</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.PackageElement#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.PackageElement#getClasses <em>Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getPackageElement()
 * @model
 * @generated
 */
public interface PackageElement extends DiscussionProvider, SourceLinkProvider {
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
	 * @see org.gnstudio.apdt.model.ModelPackage#getPackageElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.PackageElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.InterfaceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getPackageElement_Interfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<InterfaceElement> getInterfaces();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.ClassElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getPackageElement_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassElement> getClasses();

} // PackageElement
