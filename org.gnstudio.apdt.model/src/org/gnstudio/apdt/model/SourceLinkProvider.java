/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.gnstudio.apdt.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Link Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.SourceLinkProvider#getLink <em>Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getSourceLinkProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SourceLinkProvider extends EObject {
	/**
	 * Returns the value of the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link</em>' containment reference.
	 * @see #setLink(SourceLink)
	 * @see org.gnstudio.apdt.model.ModelPackage#getSourceLinkProvider_Link()
	 * @model containment="true"
	 * @generated
	 */
	SourceLink getLink();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.SourceLinkProvider#getLink <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link</em>' containment reference.
	 * @see #getLink()
	 * @generated
	 */
	void setLink(SourceLink value);

} // SourceLinkProvider
