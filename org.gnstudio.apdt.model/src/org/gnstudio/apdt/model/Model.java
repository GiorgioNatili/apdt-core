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

import java.util.Date;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.Model#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getRelease <em>Release</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getPrograms <em>Programs</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getInterfaceElement <em>Interface Element</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getClassElement <em>Class Element</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getUpdatedBy <em>Updated By</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getCreated <em>Created</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.Model#getUpdated <em>Updated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends SequenceProvider {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"0.2.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Version()
	 * @model default="0.2.0" changeable="false"
	 * @generated
	 */
	String getVersion();

	/**
	 * Returns the value of the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' attribute.
	 * @see #setRelease(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Release()
	 * @model
	 * @generated
	 */
	String getRelease();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' attribute.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Programs</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.Program}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Programs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Programs</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Programs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Program> getPrograms();

	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.gnstudio.apdt.model.PackageElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageElement> getPackages();

	/**
	 * Returns the value of the '<em><b>Interface Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Element</em>' containment reference.
	 * @see #setInterfaceElement(InterfaceElement)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_InterfaceElement()
	 * @model containment="true"
	 * @generated
	 */
	InterfaceElement getInterfaceElement();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getInterfaceElement <em>Interface Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Element</em>' containment reference.
	 * @see #getInterfaceElement()
	 * @generated
	 */
	void setInterfaceElement(InterfaceElement value);

	/**
	 * Returns the value of the '<em><b>Class Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Element</em>' containment reference.
	 * @see #setClassElement(ClassElement)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_ClassElement()
	 * @model containment="true"
	 * @generated
	 */
	ClassElement getClassElement();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getClassElement <em>Class Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Element</em>' containment reference.
	 * @see #getClassElement()
	 * @generated
	 */
	void setClassElement(ClassElement value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Updated By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated By</em>' attribute.
	 * @see #setUpdatedBy(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_UpdatedBy()
	 * @model
	 * @generated
	 */
	String getUpdatedBy();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getUpdatedBy <em>Updated By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated By</em>' attribute.
	 * @see #getUpdatedBy()
	 * @generated
	 */
	void setUpdatedBy(String value);

	/**
	 * Returns the value of the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created</em>' attribute.
	 * @see #setCreated(Date)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Created()
	 * @model
	 * @generated
	 */
	Date getCreated();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getCreated <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created</em>' attribute.
	 * @see #getCreated()
	 * @generated
	 */
	void setCreated(Date value);

	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(Date)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Updated()
	 * @model
	 * @generated
	 */
	Date getUpdated();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #getUpdated()
	 * @generated
	 */
	void setUpdated(Date value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getModel_Encoding()
	 * @model
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.Model#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

} // Model
