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
 * A representation of the model object '<em><b>Source Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.SourceLink#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gnstudio.apdt.model.ModelPackage#getSourceLink()
 * @model
 * @generated
 */
public interface SourceLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.gnstudio.apdt.model.ModelPackage#getSourceLink_Path()
	 * @model default=""
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.gnstudio.apdt.model.SourceLink#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // SourceLink
