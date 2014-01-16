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
package org.gnstudio.apdt.model.impl;

import java.util.Collection;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.Sequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getSequences <em>Sequences</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getPrograms <em>Programs</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getInterfaceElement <em>Interface Element</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getClassElement <em>Class Element</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getUpdatedBy <em>Updated By</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ModelImpl#getUpdated <em>Updated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends EObjectImpl implements Model {
	/**
	 * The cached value of the '{@link #getSequences() <em>Sequences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<Sequence> sequences;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "0.2.0";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected String release = RELEASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrograms() <em>Programs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrograms()
	 * @generated
	 * @ordered
	 */
	protected EList<Program> programs;

	/**
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageElement> packages;

	/**
	 * The cached value of the '{@link #getInterfaceElement() <em>Interface Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceElement()
	 * @generated
	 * @ordered
	 */
	protected InterfaceElement interfaceElement;

	/**
	 * The cached value of the '{@link #getClassElement() <em>Class Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassElement()
	 * @generated
	 * @ordered
	 */
	protected ClassElement classElement;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpdatedBy() <em>Updated By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String UPDATED_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdatedBy() <em>Updated By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatedBy()
	 * @generated
	 * @ordered
	 */
	protected String updatedBy = UPDATED_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected Date created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date updated = UPDATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelease(String newRelease) {
		String oldRelease = release;
		release = newRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__RELEASE, oldRelease, release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Program> getPrograms() {
		if (programs == null) {
			programs = new EObjectContainmentEList<Program>(Program.class, this, ModelPackage.MODEL__PROGRAMS);
		}
		return programs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageElement> getPackages() {
		if (packages == null) {
			packages = new EObjectContainmentEList<PackageElement>(PackageElement.class, this, ModelPackage.MODEL__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceElement getInterfaceElement() {
		return interfaceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterfaceElement(InterfaceElement newInterfaceElement, NotificationChain msgs) {
		InterfaceElement oldInterfaceElement = interfaceElement;
		interfaceElement = newInterfaceElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__INTERFACE_ELEMENT, oldInterfaceElement, newInterfaceElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceElement(InterfaceElement newInterfaceElement) {
		if (newInterfaceElement != interfaceElement) {
			NotificationChain msgs = null;
			if (interfaceElement != null)
				msgs = ((InternalEObject)interfaceElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MODEL__INTERFACE_ELEMENT, null, msgs);
			if (newInterfaceElement != null)
				msgs = ((InternalEObject)newInterfaceElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MODEL__INTERFACE_ELEMENT, null, msgs);
			msgs = basicSetInterfaceElement(newInterfaceElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__INTERFACE_ELEMENT, newInterfaceElement, newInterfaceElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassElement getClassElement() {
		return classElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassElement(ClassElement newClassElement, NotificationChain msgs) {
		ClassElement oldClassElement = classElement;
		classElement = newClassElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__CLASS_ELEMENT, oldClassElement, newClassElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassElement(ClassElement newClassElement) {
		if (newClassElement != classElement) {
			NotificationChain msgs = null;
			if (classElement != null)
				msgs = ((InternalEObject)classElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MODEL__CLASS_ELEMENT, null, msgs);
			if (newClassElement != null)
				msgs = ((InternalEObject)newClassElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.MODEL__CLASS_ELEMENT, null, msgs);
			msgs = basicSetClassElement(newClassElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__CLASS_ELEMENT, newClassElement, newClassElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdatedBy(String newUpdatedBy) {
		String oldUpdatedBy = updatedBy;
		updatedBy = newUpdatedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__UPDATED_BY, oldUpdatedBy, updatedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Date newCreated) {
		Date oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__CREATED, oldCreated, created));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdated(Date newUpdated) {
		Date oldUpdated = updated;
		updated = newUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__UPDATED, oldUpdated, updated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sequence> getSequences() {
		if (sequences == null) {
			sequences = new EObjectContainmentEList<Sequence>(Sequence.class, this, ModelPackage.MODEL__SEQUENCES);
		}
		return sequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding) {
		String oldEncoding = encoding;
		encoding = newEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.MODEL__ENCODING, oldEncoding, encoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.MODEL__SEQUENCES:
				return ((InternalEList<?>)getSequences()).basicRemove(otherEnd, msgs);
			case ModelPackage.MODEL__PROGRAMS:
				return ((InternalEList<?>)getPrograms()).basicRemove(otherEnd, msgs);
			case ModelPackage.MODEL__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case ModelPackage.MODEL__INTERFACE_ELEMENT:
				return basicSetInterfaceElement(null, msgs);
			case ModelPackage.MODEL__CLASS_ELEMENT:
				return basicSetClassElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.MODEL__SEQUENCES:
				return getSequences();
			case ModelPackage.MODEL__VERSION:
				return getVersion();
			case ModelPackage.MODEL__RELEASE:
				return getRelease();
			case ModelPackage.MODEL__ENCODING:
				return getEncoding();
			case ModelPackage.MODEL__DESCRIPTION:
				return getDescription();
			case ModelPackage.MODEL__PROGRAMS:
				return getPrograms();
			case ModelPackage.MODEL__PACKAGES:
				return getPackages();
			case ModelPackage.MODEL__INTERFACE_ELEMENT:
				return getInterfaceElement();
			case ModelPackage.MODEL__CLASS_ELEMENT:
				return getClassElement();
			case ModelPackage.MODEL__AUTHOR:
				return getAuthor();
			case ModelPackage.MODEL__UPDATED_BY:
				return getUpdatedBy();
			case ModelPackage.MODEL__CREATED:
				return getCreated();
			case ModelPackage.MODEL__UPDATED:
				return getUpdated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.MODEL__SEQUENCES:
				getSequences().clear();
				getSequences().addAll((Collection<? extends Sequence>)newValue);
				return;
			case ModelPackage.MODEL__RELEASE:
				setRelease((String)newValue);
				return;
			case ModelPackage.MODEL__ENCODING:
				setEncoding((String)newValue);
				return;
			case ModelPackage.MODEL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.MODEL__PROGRAMS:
				getPrograms().clear();
				getPrograms().addAll((Collection<? extends Program>)newValue);
				return;
			case ModelPackage.MODEL__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends PackageElement>)newValue);
				return;
			case ModelPackage.MODEL__INTERFACE_ELEMENT:
				setInterfaceElement((InterfaceElement)newValue);
				return;
			case ModelPackage.MODEL__CLASS_ELEMENT:
				setClassElement((ClassElement)newValue);
				return;
			case ModelPackage.MODEL__AUTHOR:
				setAuthor((String)newValue);
				return;
			case ModelPackage.MODEL__UPDATED_BY:
				setUpdatedBy((String)newValue);
				return;
			case ModelPackage.MODEL__CREATED:
				setCreated((Date)newValue);
				return;
			case ModelPackage.MODEL__UPDATED:
				setUpdated((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.MODEL__SEQUENCES:
				getSequences().clear();
				return;
			case ModelPackage.MODEL__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case ModelPackage.MODEL__ENCODING:
				setEncoding(ENCODING_EDEFAULT);
				return;
			case ModelPackage.MODEL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.MODEL__PROGRAMS:
				getPrograms().clear();
				return;
			case ModelPackage.MODEL__PACKAGES:
				getPackages().clear();
				return;
			case ModelPackage.MODEL__INTERFACE_ELEMENT:
				setInterfaceElement((InterfaceElement)null);
				return;
			case ModelPackage.MODEL__CLASS_ELEMENT:
				setClassElement((ClassElement)null);
				return;
			case ModelPackage.MODEL__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case ModelPackage.MODEL__UPDATED_BY:
				setUpdatedBy(UPDATED_BY_EDEFAULT);
				return;
			case ModelPackage.MODEL__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case ModelPackage.MODEL__UPDATED:
				setUpdated(UPDATED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.MODEL__SEQUENCES:
				return sequences != null && !sequences.isEmpty();
			case ModelPackage.MODEL__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ModelPackage.MODEL__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case ModelPackage.MODEL__ENCODING:
				return ENCODING_EDEFAULT == null ? encoding != null : !ENCODING_EDEFAULT.equals(encoding);
			case ModelPackage.MODEL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.MODEL__PROGRAMS:
				return programs != null && !programs.isEmpty();
			case ModelPackage.MODEL__PACKAGES:
				return packages != null && !packages.isEmpty();
			case ModelPackage.MODEL__INTERFACE_ELEMENT:
				return interfaceElement != null;
			case ModelPackage.MODEL__CLASS_ELEMENT:
				return classElement != null;
			case ModelPackage.MODEL__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case ModelPackage.MODEL__UPDATED_BY:
				return UPDATED_BY_EDEFAULT == null ? updatedBy != null : !UPDATED_BY_EDEFAULT.equals(updatedBy);
			case ModelPackage.MODEL__CREATED:
				return CREATED_EDEFAULT == null ? created != null : !CREATED_EDEFAULT.equals(created);
			case ModelPackage.MODEL__UPDATED:
				return UPDATED_EDEFAULT == null ? updated != null : !UPDATED_EDEFAULT.equals(updated);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (version: ");
		result.append(version);
		result.append(", release: ");
		result.append(release);
		result.append(", encoding: ");
		result.append(encoding);
		result.append(", description: ");
		result.append(description);
		result.append(", author: ");
		result.append(author);
		result.append(", updatedBy: ");
		result.append(updatedBy);
		result.append(", created: ");
		result.append(created);
		result.append(", updated: ");
		result.append(updated);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
