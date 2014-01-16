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

import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.DescriptionProvider;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.SwitchSequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.SwitchSequenceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.SwitchSequenceImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.SwitchSequenceImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.SwitchSequenceImpl#getDefaultCase <em>Default Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchSequenceImpl extends EObjectImpl implements SwitchSequence {
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
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceGroup> cases;

	/**
	 * The cached value of the '{@link #getDefaultCase() <em>Default Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultCase()
	 * @generated
	 * @ordered
	 */
	protected SequenceGroup defaultCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SWITCH_SEQUENCE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SWITCH_SEQUENCE__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SWITCH_SEQUENCE__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SWITCH_SEQUENCE__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SWITCH_SEQUENCE__DESCRIPTION, newDescription, newDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SWITCH_SEQUENCE__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceGroup> getCases() {
		if (cases == null) {
			cases = new EObjectContainmentEList<SequenceGroup>(SequenceGroup.class, this, ModelPackage.SWITCH_SEQUENCE__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceGroup getDefaultCase() {
		return defaultCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultCase(SequenceGroup newDefaultCase, NotificationChain msgs) {
		SequenceGroup oldDefaultCase = defaultCase;
		defaultCase = newDefaultCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE, oldDefaultCase, newDefaultCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultCase(SequenceGroup newDefaultCase) {
		if (newDefaultCase != defaultCase) {
			NotificationChain msgs = null;
			if (defaultCase != null)
				msgs = ((InternalEObject)defaultCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE, null, msgs);
			if (newDefaultCase != null)
				msgs = ((InternalEObject)newDefaultCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE, null, msgs);
			msgs = basicSetDefaultCase(newDefaultCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE, newDefaultCase, newDefaultCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SWITCH_SEQUENCE__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case ModelPackage.SWITCH_SEQUENCE__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
			case ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE:
				return basicSetDefaultCase(null, msgs);
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
			case ModelPackage.SWITCH_SEQUENCE__DESCRIPTION:
				return getDescription();
			case ModelPackage.SWITCH_SEQUENCE__NOTE:
				return getNote();
			case ModelPackage.SWITCH_SEQUENCE__CASES:
				return getCases();
			case ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE:
				return getDefaultCase();
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
			case ModelPackage.SWITCH_SEQUENCE__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case ModelPackage.SWITCH_SEQUENCE__NOTE:
				setNote((String)newValue);
				return;
			case ModelPackage.SWITCH_SEQUENCE__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends SequenceGroup>)newValue);
				return;
			case ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE:
				setDefaultCase((SequenceGroup)newValue);
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
			case ModelPackage.SWITCH_SEQUENCE__DESCRIPTION:
				setDescription((Description)null);
				return;
			case ModelPackage.SWITCH_SEQUENCE__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ModelPackage.SWITCH_SEQUENCE__CASES:
				getCases().clear();
				return;
			case ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE:
				setDefaultCase((SequenceGroup)null);
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
			case ModelPackage.SWITCH_SEQUENCE__DESCRIPTION:
				return description != null;
			case ModelPackage.SWITCH_SEQUENCE__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ModelPackage.SWITCH_SEQUENCE__CASES:
				return cases != null && !cases.isEmpty();
			case ModelPackage.SWITCH_SEQUENCE__DEFAULT_CASE:
				return defaultCase != null;
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
		if (baseClass == DescriptionProvider.class) {
			switch (derivedFeatureID) {
				case ModelPackage.SWITCH_SEQUENCE__DESCRIPTION: return ModelPackage.DESCRIPTION_PROVIDER__DESCRIPTION;
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
		if (baseClass == DescriptionProvider.class) {
			switch (baseFeatureID) {
				case ModelPackage.DESCRIPTION_PROVIDER__DESCRIPTION: return ModelPackage.SWITCH_SEQUENCE__DESCRIPTION;
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
		result.append(" (note: ");
		result.append(note);
		result.append(')');
		return result.toString();
	}

} //SwitchSequenceImpl
