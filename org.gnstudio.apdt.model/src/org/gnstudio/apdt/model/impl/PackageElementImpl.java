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
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.SourceLink;
import org.gnstudio.apdt.model.SourceLinkProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.PackageElementImpl#getDiscussions <em>Discussions</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.PackageElementImpl#getLink <em>Link</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.PackageElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.PackageElementImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.PackageElementImpl#getClasses <em>Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageElementImpl extends EObjectImpl implements PackageElement {
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
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceElement> interfaces;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassElement> classes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PACKAGE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Discussion> getDiscussions() {
		if (discussions == null) {
			discussions = new EObjectContainmentEList<Discussion>(Discussion.class, this, ModelPackage.PACKAGE_ELEMENT__DISCUSSIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PACKAGE_ELEMENT__LINK, oldLink, newLink);
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
				msgs = ((InternalEObject)link).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PACKAGE_ELEMENT__LINK, null, msgs);
			if (newLink != null)
				msgs = ((InternalEObject)newLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PACKAGE_ELEMENT__LINK, null, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PACKAGE_ELEMENT__LINK, newLink, newLink));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PACKAGE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceElement> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EObjectContainmentEList<InterfaceElement>(InterfaceElement.class, this, ModelPackage.PACKAGE_ELEMENT__INTERFACES);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassElement> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<ClassElement>(ClassElement.class, this, ModelPackage.PACKAGE_ELEMENT__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PACKAGE_ELEMENT__DISCUSSIONS:
				return ((InternalEList<?>)getDiscussions()).basicRemove(otherEnd, msgs);
			case ModelPackage.PACKAGE_ELEMENT__LINK:
				return basicSetLink(null, msgs);
			case ModelPackage.PACKAGE_ELEMENT__INTERFACES:
				return ((InternalEList<?>)getInterfaces()).basicRemove(otherEnd, msgs);
			case ModelPackage.PACKAGE_ELEMENT__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PACKAGE_ELEMENT__DISCUSSIONS:
				return getDiscussions();
			case ModelPackage.PACKAGE_ELEMENT__LINK:
				return getLink();
			case ModelPackage.PACKAGE_ELEMENT__NAME:
				return getName();
			case ModelPackage.PACKAGE_ELEMENT__INTERFACES:
				return getInterfaces();
			case ModelPackage.PACKAGE_ELEMENT__CLASSES:
				return getClasses();
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
			case ModelPackage.PACKAGE_ELEMENT__DISCUSSIONS:
				getDiscussions().clear();
				getDiscussions().addAll((Collection<? extends Discussion>)newValue);
				return;
			case ModelPackage.PACKAGE_ELEMENT__LINK:
				setLink((SourceLink)newValue);
				return;
			case ModelPackage.PACKAGE_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PACKAGE_ELEMENT__INTERFACES:
				getInterfaces().clear();
				getInterfaces().addAll((Collection<? extends InterfaceElement>)newValue);
				return;
			case ModelPackage.PACKAGE_ELEMENT__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends ClassElement>)newValue);
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
			case ModelPackage.PACKAGE_ELEMENT__DISCUSSIONS:
				getDiscussions().clear();
				return;
			case ModelPackage.PACKAGE_ELEMENT__LINK:
				setLink((SourceLink)null);
				return;
			case ModelPackage.PACKAGE_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PACKAGE_ELEMENT__INTERFACES:
				getInterfaces().clear();
				return;
			case ModelPackage.PACKAGE_ELEMENT__CLASSES:
				getClasses().clear();
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
			case ModelPackage.PACKAGE_ELEMENT__DISCUSSIONS:
				return discussions != null && !discussions.isEmpty();
			case ModelPackage.PACKAGE_ELEMENT__LINK:
				return link != null;
			case ModelPackage.PACKAGE_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PACKAGE_ELEMENT__INTERFACES:
				return interfaces != null && !interfaces.isEmpty();
			case ModelPackage.PACKAGE_ELEMENT__CLASSES:
				return classes != null && !classes.isEmpty();
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
		if (baseClass == SourceLinkProvider.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PACKAGE_ELEMENT__LINK: return ModelPackage.SOURCE_LINK_PROVIDER__LINK;
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
		if (baseClass == SourceLinkProvider.class) {
			switch (baseFeatureID) {
				case ModelPackage.SOURCE_LINK_PROVIDER__LINK: return ModelPackage.PACKAGE_ELEMENT__LINK;
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
		result.append(')');
		return result.toString();
	}

} //PackageElementImpl
