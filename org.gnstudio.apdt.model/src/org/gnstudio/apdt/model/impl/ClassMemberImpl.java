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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.ClassMember;
import org.gnstudio.apdt.model.DeclarationType;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.TypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ClassMemberImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassMemberImpl extends EObjectImpl implements ClassMember {
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
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;

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
	 * The default value of the '{@link #getDeclaration() <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected static final DeclarationType DECLARATION_EDEFAULT = DeclarationType.DEFAULT;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected DeclarationType declaration = DECLARATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeReference type;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CLASS_MEMBER;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_MEMBER__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_MEMBER__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__NOTE, oldNote, note));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeReference getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeReference newType, NotificationChain msgs) {
		TypeReference oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeReference newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_MEMBER__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS_MEMBER__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__TYPE, newType, newType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__ANNOTATION, oldAnnotation, annotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationType getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(DeclarationType newDeclaration) {
		DeclarationType oldDeclaration = declaration;
		declaration = newDeclaration == null ? DECLARATION_EDEFAULT : newDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS_MEMBER__DECLARATION, oldDeclaration, declaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.CLASS_MEMBER__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case ModelPackage.CLASS_MEMBER__TYPE:
				return basicSetType(null, msgs);
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
			case ModelPackage.CLASS_MEMBER__DESCRIPTION:
				return getDescription();
			case ModelPackage.CLASS_MEMBER__NOTE:
				return getNote();
			case ModelPackage.CLASS_MEMBER__ACCESS:
				return getAccess();
			case ModelPackage.CLASS_MEMBER__ANNOTATION:
				return getAnnotation();
			case ModelPackage.CLASS_MEMBER__DECLARATION:
				return getDeclaration();
			case ModelPackage.CLASS_MEMBER__TYPE:
				return getType();
			case ModelPackage.CLASS_MEMBER__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.CLASS_MEMBER__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case ModelPackage.CLASS_MEMBER__NOTE:
				setNote((String)newValue);
				return;
			case ModelPackage.CLASS_MEMBER__ACCESS:
				setAccess((AccessType)newValue);
				return;
			case ModelPackage.CLASS_MEMBER__ANNOTATION:
				setAnnotation((String)newValue);
				return;
			case ModelPackage.CLASS_MEMBER__DECLARATION:
				setDeclaration((DeclarationType)newValue);
				return;
			case ModelPackage.CLASS_MEMBER__TYPE:
				setType((TypeReference)newValue);
				return;
			case ModelPackage.CLASS_MEMBER__NAME:
				setName((String)newValue);
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
			case ModelPackage.CLASS_MEMBER__DESCRIPTION:
				setDescription((Description)null);
				return;
			case ModelPackage.CLASS_MEMBER__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ModelPackage.CLASS_MEMBER__ACCESS:
				setAccess(ACCESS_EDEFAULT);
				return;
			case ModelPackage.CLASS_MEMBER__ANNOTATION:
				setAnnotation(ANNOTATION_EDEFAULT);
				return;
			case ModelPackage.CLASS_MEMBER__DECLARATION:
				setDeclaration(DECLARATION_EDEFAULT);
				return;
			case ModelPackage.CLASS_MEMBER__TYPE:
				setType((TypeReference)null);
				return;
			case ModelPackage.CLASS_MEMBER__NAME:
				setName(NAME_EDEFAULT);
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
			case ModelPackage.CLASS_MEMBER__DESCRIPTION:
				return description != null;
			case ModelPackage.CLASS_MEMBER__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ModelPackage.CLASS_MEMBER__ACCESS:
				return access != ACCESS_EDEFAULT;
			case ModelPackage.CLASS_MEMBER__ANNOTATION:
				return ANNOTATION_EDEFAULT == null ? annotation != null : !ANNOTATION_EDEFAULT.equals(annotation);
			case ModelPackage.CLASS_MEMBER__DECLARATION:
				return declaration != DECLARATION_EDEFAULT;
			case ModelPackage.CLASS_MEMBER__TYPE:
				return type != null;
			case ModelPackage.CLASS_MEMBER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (note: ");
		result.append(note);
		result.append(", access: ");
		result.append(access);
		result.append(", annotation: ");
		result.append(annotation);
		result.append(", declaration: ");
		result.append(declaration);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ClassMemberImpl
