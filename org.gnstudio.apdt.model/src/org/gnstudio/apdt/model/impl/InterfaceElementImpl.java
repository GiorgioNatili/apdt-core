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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.DiscussionProvider;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.SourceLink;
import org.gnstudio.apdt.model.SourceLinkProvider;
import org.gnstudio.apdt.model.TypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getDiscussions <em>Discussions</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getLink <em>Link</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getExtendsElements <em>Extends Elements</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceElementImpl extends EObjectImpl implements InterfaceElement {
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected Description description;

	/**
	 * The cached value of the '{@link #getDiscussions() <em>Discussions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscussions()
	 * @generated
	 * @ordered
	 */
	protected EList<Discussion> discussions;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected SourceLink link;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccess() <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected static final AccessType ACCESS_EDEFAULT = AccessType.PUBLIC;

	/**
	 * The cached value of the '{@link #getAccess() <em>Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected AccessType access = ACCESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtendsElements() <em>Extends Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeReference> extendsElements;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.INTERFACE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INTERFACE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(Description newDescription, NotificationChain msgs) {
		Description oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.INTERFACE_ELEMENT__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(Description newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.INTERFACE_ELEMENT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.INTERFACE_ELEMENT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INTERFACE_ELEMENT__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Discussion> getDiscussions() {
		if (discussions == null) {
			discussions = new EObjectContainmentEList<Discussion>(Discussion.class, this, ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS);
		}
		return discussions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceLink getLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(SourceLink newLink, NotificationChain msgs) {
		SourceLink oldLink = link;
		link = newLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.INTERFACE_ELEMENT__LINK, oldLink, newLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(SourceLink newLink) {
		if (newLink != link) {
			NotificationChain msgs = null;
			if (link != null)
				msgs = ((InternalEObject)link).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.INTERFACE_ELEMENT__LINK, null, msgs);
			if (newLink != null)
				msgs = ((InternalEObject)newLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.INTERFACE_ELEMENT__LINK, null, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INTERFACE_ELEMENT__LINK, newLink, newLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType getAccess() {
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccess(AccessType newAccess) {
		AccessType oldAccess = access;
		access = newAccess == null ? ACCESS_EDEFAULT : newAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.INTERFACE_ELEMENT__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeReference> getExtendsElements() {
		if (extendsElements == null) {
			extendsElements = new EObjectContainmentEList<TypeReference>(TypeReference.class, this, ModelPackage.INTERFACE_ELEMENT__EXTENDS_ELEMENTS);
		}
		return extendsElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<Method>(Method.class, this, ModelPackage.INTERFACE_ELEMENT__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.INTERFACE_ELEMENT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS:
				return ((InternalEList<?>)getDiscussions()).basicRemove(otherEnd, msgs);
			case ModelPackage.INTERFACE_ELEMENT__LINK:
				return basicSetLink(null, msgs);
			case ModelPackage.INTERFACE_ELEMENT__EXTENDS_ELEMENTS:
				return ((InternalEList<?>)getExtendsElements()).basicRemove(otherEnd, msgs);
			case ModelPackage.INTERFACE_ELEMENT__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.INTERFACE_ELEMENT__DESCRIPTION:
				return getDescription();
			case ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS:
				return getDiscussions();
			case ModelPackage.INTERFACE_ELEMENT__LINK:
				return getLink();
			case ModelPackage.INTERFACE_ELEMENT__NAME:
				return getName();
			case ModelPackage.INTERFACE_ELEMENT__ACCESS:
				return getAccess();
			case ModelPackage.INTERFACE_ELEMENT__EXTENDS_ELEMENTS:
				return getExtendsElements();
			case ModelPackage.INTERFACE_ELEMENT__METHODS:
				return getMethods();
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
			case ModelPackage.INTERFACE_ELEMENT__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS:
				getDiscussions().clear();
				getDiscussions().addAll((Collection<? extends Discussion>)newValue);
				return;
			case ModelPackage.INTERFACE_ELEMENT__LINK:
				setLink((SourceLink)newValue);
				return;
			case ModelPackage.INTERFACE_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.INTERFACE_ELEMENT__ACCESS:
				setAccess((AccessType)newValue);
				return;
			case ModelPackage.INTERFACE_ELEMENT__EXTENDS_ELEMENTS:
				getExtendsElements().clear();
				getExtendsElements().addAll((Collection<? extends TypeReference>)newValue);
				return;
			case ModelPackage.INTERFACE_ELEMENT__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
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
			case ModelPackage.INTERFACE_ELEMENT__DESCRIPTION:
				setDescription((Description)null);
				return;
			case ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS:
				getDiscussions().clear();
				return;
			case ModelPackage.INTERFACE_ELEMENT__LINK:
				setLink((SourceLink)null);
				return;
			case ModelPackage.INTERFACE_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.INTERFACE_ELEMENT__ACCESS:
				setAccess(ACCESS_EDEFAULT);
				return;
			case ModelPackage.INTERFACE_ELEMENT__EXTENDS_ELEMENTS:
				getExtendsElements().clear();
				return;
			case ModelPackage.INTERFACE_ELEMENT__METHODS:
				getMethods().clear();
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
			case ModelPackage.INTERFACE_ELEMENT__DESCRIPTION:
				return description != null;
			case ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS:
				return discussions != null && !discussions.isEmpty();
			case ModelPackage.INTERFACE_ELEMENT__LINK:
				return link != null;
			case ModelPackage.INTERFACE_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.INTERFACE_ELEMENT__ACCESS:
				return access != ACCESS_EDEFAULT;
			case ModelPackage.INTERFACE_ELEMENT__EXTENDS_ELEMENTS:
				return extendsElements != null && !extendsElements.isEmpty();
			case ModelPackage.INTERFACE_ELEMENT__METHODS:
				return methods != null && !methods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DiscussionProvider.class) {
			switch (derivedFeatureID) {
				case ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS: return ModelPackage.DISCUSSION_PROVIDER__DISCUSSIONS;
				default: return -1;
			}
		}
		if (baseClass == SourceLinkProvider.class) {
			switch (derivedFeatureID) {
				case ModelPackage.INTERFACE_ELEMENT__LINK: return ModelPackage.SOURCE_LINK_PROVIDER__LINK;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DiscussionProvider.class) {
			switch (baseFeatureID) {
				case ModelPackage.DISCUSSION_PROVIDER__DISCUSSIONS: return ModelPackage.INTERFACE_ELEMENT__DISCUSSIONS;
				default: return -1;
			}
		}
		if (baseClass == SourceLinkProvider.class) {
			switch (baseFeatureID) {
				case ModelPackage.SOURCE_LINK_PROVIDER__LINK: return ModelPackage.INTERFACE_ELEMENT__LINK;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", access: ");
		result.append(access);
		result.append(')');
		return result.toString();
	}

} //InterfaceElementImpl
