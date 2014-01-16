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
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.ClassMember;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.DiscussionProvider;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.SourceLink;
import org.gnstudio.apdt.model.SourceLinkProvider;
import org.gnstudio.apdt.model.TypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getDiscussions <em>Discussions</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getLink <em>Link</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getImplementsElements <em>Implements Elements</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getExtendsElements <em>Extends Elements</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassElementImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassElementImpl extends EObjectImpl implements ClassElement {
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
	 * The default value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String annotation = ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean final_ = FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DYNAMIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDynamic() <em>Dynamic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDynamic()
	 * @generated
	 * @ordered
	 */
	protected boolean dynamic = DYNAMIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplementsElements() <em>Implements Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementsElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeReference> implementsElements;

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
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassMember> members;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CLASS_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_ELEMENT__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_ELEMENT__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Discussion> getDiscussions() {
		if (discussions == null) {
			discussions = new EObjectContainmentEList<Discussion>(Discussion.class, this, ModelPackage.CLASS_ELEMENT__DISCUSSIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__LINK, oldLink, newLink);
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
				msgs = ((InternalEObject)link).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_ELEMENT__LINK, null, msgs);
			if (newLink != null)
				msgs = ((InternalEObject)newLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_ELEMENT__LINK, null, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__LINK, newLink, newLink));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnnotation() {
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotation(String newAnnotation) {
		String oldAnnotation = annotation;
		annotation = newAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__ANNOTATION, oldAnnotation, annotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFinal() {
		return final_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinal(boolean newFinal) {
		boolean oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__FINAL, oldFinal, final_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDynamic() {
		return dynamic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamic(boolean newDynamic) {
		boolean oldDynamic = dynamic;
		dynamic = newDynamic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_ELEMENT__DYNAMIC, oldDynamic, dynamic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeReference> getImplementsElements() {
		if (implementsElements == null) {
			implementsElements = new EObjectContainmentEList<TypeReference>(TypeReference.class, this, ModelPackage.CLASS_ELEMENT__IMPLEMENTS_ELEMENTS);
		}
		return implementsElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeReference> getExtendsElements() {
		if (extendsElements == null) {
			extendsElements = new EObjectContainmentEList<TypeReference>(TypeReference.class, this, ModelPackage.CLASS_ELEMENT__EXTENDS_ELEMENTS);
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
			methods = new EObjectContainmentEList<Method>(Method.class, this, ModelPackage.CLASS_ELEMENT__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassMember> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList<ClassMember>(ClassMember.class, this, ModelPackage.CLASS_ELEMENT__MEMBERS);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.CLASS_ELEMENT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case ModelPackage.CLASS_ELEMENT__DISCUSSIONS:
				return ((InternalEList<?>)getDiscussions()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS_ELEMENT__LINK:
				return basicSetLink(null, msgs);
			case ModelPackage.CLASS_ELEMENT__IMPLEMENTS_ELEMENTS:
				return ((InternalEList<?>)getImplementsElements()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS_ELEMENT__EXTENDS_ELEMENTS:
				return ((InternalEList<?>)getExtendsElements()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS_ELEMENT__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS_ELEMENT__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.CLASS_ELEMENT__DESCRIPTION:
				return getDescription();
			case ModelPackage.CLASS_ELEMENT__DISCUSSIONS:
				return getDiscussions();
			case ModelPackage.CLASS_ELEMENT__LINK:
				return getLink();
			case ModelPackage.CLASS_ELEMENT__NAME:
				return getName();
			case ModelPackage.CLASS_ELEMENT__ACCESS:
				return getAccess();
			case ModelPackage.CLASS_ELEMENT__ANNOTATION:
				return getAnnotation();
			case ModelPackage.CLASS_ELEMENT__FINAL:
				return isFinal();
			case ModelPackage.CLASS_ELEMENT__DYNAMIC:
				return isDynamic();
			case ModelPackage.CLASS_ELEMENT__IMPLEMENTS_ELEMENTS:
				return getImplementsElements();
			case ModelPackage.CLASS_ELEMENT__EXTENDS_ELEMENTS:
				return getExtendsElements();
			case ModelPackage.CLASS_ELEMENT__METHODS:
				return getMethods();
			case ModelPackage.CLASS_ELEMENT__MEMBERS:
				return getMembers();
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
			case ModelPackage.CLASS_ELEMENT__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__DISCUSSIONS:
				getDiscussions().clear();
				getDiscussions().addAll((Collection<? extends Discussion>)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__LINK:
				setLink((SourceLink)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__ACCESS:
				setAccess((AccessType)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__ANNOTATION:
				setAnnotation((String)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__FINAL:
				setFinal((Boolean)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__DYNAMIC:
				setDynamic((Boolean)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__IMPLEMENTS_ELEMENTS:
				getImplementsElements().clear();
				getImplementsElements().addAll((Collection<? extends TypeReference>)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__EXTENDS_ELEMENTS:
				getExtendsElements().clear();
				getExtendsElements().addAll((Collection<? extends TypeReference>)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case ModelPackage.CLASS_ELEMENT__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends ClassMember>)newValue);
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
			case ModelPackage.CLASS_ELEMENT__DESCRIPTION:
				setDescription((Description)null);
				return;
			case ModelPackage.CLASS_ELEMENT__DISCUSSIONS:
				getDiscussions().clear();
				return;
			case ModelPackage.CLASS_ELEMENT__LINK:
				setLink((SourceLink)null);
				return;
			case ModelPackage.CLASS_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.CLASS_ELEMENT__ACCESS:
				setAccess(ACCESS_EDEFAULT);
				return;
			case ModelPackage.CLASS_ELEMENT__ANNOTATION:
				setAnnotation(ANNOTATION_EDEFAULT);
				return;
			case ModelPackage.CLASS_ELEMENT__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case ModelPackage.CLASS_ELEMENT__DYNAMIC:
				setDynamic(DYNAMIC_EDEFAULT);
				return;
			case ModelPackage.CLASS_ELEMENT__IMPLEMENTS_ELEMENTS:
				getImplementsElements().clear();
				return;
			case ModelPackage.CLASS_ELEMENT__EXTENDS_ELEMENTS:
				getExtendsElements().clear();
				return;
			case ModelPackage.CLASS_ELEMENT__METHODS:
				getMethods().clear();
				return;
			case ModelPackage.CLASS_ELEMENT__MEMBERS:
				getMembers().clear();
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
			case ModelPackage.CLASS_ELEMENT__DESCRIPTION:
				return description != null;
			case ModelPackage.CLASS_ELEMENT__DISCUSSIONS:
				return discussions != null && !discussions.isEmpty();
			case ModelPackage.CLASS_ELEMENT__LINK:
				return link != null;
			case ModelPackage.CLASS_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.CLASS_ELEMENT__ACCESS:
				return access != ACCESS_EDEFAULT;
			case ModelPackage.CLASS_ELEMENT__ANNOTATION:
				return ANNOTATION_EDEFAULT == null ? annotation != null : !ANNOTATION_EDEFAULT.equals(annotation);
			case ModelPackage.CLASS_ELEMENT__FINAL:
				return final_ != FINAL_EDEFAULT;
			case ModelPackage.CLASS_ELEMENT__DYNAMIC:
				return dynamic != DYNAMIC_EDEFAULT;
			case ModelPackage.CLASS_ELEMENT__IMPLEMENTS_ELEMENTS:
				return implementsElements != null && !implementsElements.isEmpty();
			case ModelPackage.CLASS_ELEMENT__EXTENDS_ELEMENTS:
				return extendsElements != null && !extendsElements.isEmpty();
			case ModelPackage.CLASS_ELEMENT__METHODS:
				return methods != null && !methods.isEmpty();
			case ModelPackage.CLASS_ELEMENT__MEMBERS:
				return members != null && !members.isEmpty();
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
				case ModelPackage.CLASS_ELEMENT__DISCUSSIONS: return ModelPackage.DISCUSSION_PROVIDER__DISCUSSIONS;
				default: return -1;
			}
		}
		if (baseClass == SourceLinkProvider.class) {
			switch (derivedFeatureID) {
				case ModelPackage.CLASS_ELEMENT__LINK: return ModelPackage.SOURCE_LINK_PROVIDER__LINK;
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
				case ModelPackage.DISCUSSION_PROVIDER__DISCUSSIONS: return ModelPackage.CLASS_ELEMENT__DISCUSSIONS;
				default: return -1;
			}
		}
		if (baseClass == SourceLinkProvider.class) {
			switch (baseFeatureID) {
				case ModelPackage.SOURCE_LINK_PROVIDER__LINK: return ModelPackage.CLASS_ELEMENT__LINK;
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
		result.append(", annotation: ");
		result.append(annotation);
		result.append(", final: ");
		result.append(final_);
		result.append(", dynamic: ");
		result.append(dynamic);
		result.append(')');
		return result.toString();
	}

} //ClassElementImpl
