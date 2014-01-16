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

import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.TrySequence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.TrySequenceImpl#getTryGroup <em>Try Group</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.TrySequenceImpl#getCatchGroups <em>Catch Groups</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.TrySequenceImpl#getFinallyGroup <em>Finally Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrySequenceImpl extends EObjectImpl implements TrySequence {
	/**
	 * The cached value of the '{@link #getTryGroup() <em>Try Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTryGroup()
	 * @generated
	 * @ordered
	 */
	protected SequenceGroup tryGroup;

	/**
	 * The cached value of the '{@link #getCatchGroups() <em>Catch Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatchGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceGroup> catchGroups;

	/**
	 * The cached value of the '{@link #getFinallyGroup() <em>Finally Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinallyGroup()
	 * @generated
	 * @ordered
	 */
	protected SequenceGroup finallyGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrySequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TRY_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceGroup getTryGroup() {
		return tryGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTryGroup(SequenceGroup newTryGroup, NotificationChain msgs) {
		SequenceGroup oldTryGroup = tryGroup;
		tryGroup = newTryGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TRY_SEQUENCE__TRY_GROUP, oldTryGroup, newTryGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTryGroup(SequenceGroup newTryGroup) {
		if (newTryGroup != tryGroup) {
			NotificationChain msgs = null;
			if (tryGroup != null)
				msgs = ((InternalEObject)tryGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TRY_SEQUENCE__TRY_GROUP, null, msgs);
			if (newTryGroup != null)
				msgs = ((InternalEObject)newTryGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TRY_SEQUENCE__TRY_GROUP, null, msgs);
			msgs = basicSetTryGroup(newTryGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRY_SEQUENCE__TRY_GROUP, newTryGroup, newTryGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceGroup> getCatchGroups() {
		if (catchGroups == null) {
			catchGroups = new EObjectContainmentEList<SequenceGroup>(SequenceGroup.class, this, ModelPackage.TRY_SEQUENCE__CATCH_GROUPS);
		}
		return catchGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceGroup getFinallyGroup() {
		return finallyGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinallyGroup(SequenceGroup newFinallyGroup, NotificationChain msgs) {
		SequenceGroup oldFinallyGroup = finallyGroup;
		finallyGroup = newFinallyGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TRY_SEQUENCE__FINALLY_GROUP, oldFinallyGroup, newFinallyGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinallyGroup(SequenceGroup newFinallyGroup) {
		if (newFinallyGroup != finallyGroup) {
			NotificationChain msgs = null;
			if (finallyGroup != null)
				msgs = ((InternalEObject)finallyGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TRY_SEQUENCE__FINALLY_GROUP, null, msgs);
			if (newFinallyGroup != null)
				msgs = ((InternalEObject)newFinallyGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TRY_SEQUENCE__FINALLY_GROUP, null, msgs);
			msgs = basicSetFinallyGroup(newFinallyGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRY_SEQUENCE__FINALLY_GROUP, newFinallyGroup, newFinallyGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TRY_SEQUENCE__TRY_GROUP:
				return basicSetTryGroup(null, msgs);
			case ModelPackage.TRY_SEQUENCE__CATCH_GROUPS:
				return ((InternalEList<?>)getCatchGroups()).basicRemove(otherEnd, msgs);
			case ModelPackage.TRY_SEQUENCE__FINALLY_GROUP:
				return basicSetFinallyGroup(null, msgs);
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
			case ModelPackage.TRY_SEQUENCE__TRY_GROUP:
				return getTryGroup();
			case ModelPackage.TRY_SEQUENCE__CATCH_GROUPS:
				return getCatchGroups();
			case ModelPackage.TRY_SEQUENCE__FINALLY_GROUP:
				return getFinallyGroup();
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
			case ModelPackage.TRY_SEQUENCE__TRY_GROUP:
				setTryGroup((SequenceGroup)newValue);
				return;
			case ModelPackage.TRY_SEQUENCE__CATCH_GROUPS:
				getCatchGroups().clear();
				getCatchGroups().addAll((Collection<? extends SequenceGroup>)newValue);
				return;
			case ModelPackage.TRY_SEQUENCE__FINALLY_GROUP:
				setFinallyGroup((SequenceGroup)newValue);
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
			case ModelPackage.TRY_SEQUENCE__TRY_GROUP:
				setTryGroup((SequenceGroup)null);
				return;
			case ModelPackage.TRY_SEQUENCE__CATCH_GROUPS:
				getCatchGroups().clear();
				return;
			case ModelPackage.TRY_SEQUENCE__FINALLY_GROUP:
				setFinallyGroup((SequenceGroup)null);
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
			case ModelPackage.TRY_SEQUENCE__TRY_GROUP:
				return tryGroup != null;
			case ModelPackage.TRY_SEQUENCE__CATCH_GROUPS:
				return catchGroups != null && !catchGroups.isEmpty();
			case ModelPackage.TRY_SEQUENCE__FINALLY_GROUP:
				return finallyGroup != null;
		}
		return super.eIsSet(featureID);
	}

} //TrySequenceImpl
