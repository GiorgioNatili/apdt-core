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
import org.gnstudio.apdt.model.ControlSequence;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.SequenceGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.ControlSequenceImpl#getIfGroup <em>If Group</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ControlSequenceImpl#getElseifGroups <em>Elseif Groups</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.ControlSequenceImpl#getElseGroup <em>Else Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlSequenceImpl extends EObjectImpl implements ControlSequence {
	/**
	 * The cached value of the '{@link #getIfGroup() <em>If Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfGroup()
	 * @generated
	 * @ordered
	 */
	protected SequenceGroup ifGroup;

	/**
	 * The cached value of the '{@link #getElseifGroups() <em>Elseif Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseifGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceGroup> elseifGroups;

	/**
	 * The cached value of the '{@link #getElseGroup() <em>Else Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseGroup()
	 * @generated
	 * @ordered
	 */
	protected SequenceGroup elseGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CONTROL_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceGroup getIfGroup() {
		return ifGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIfGroup(SequenceGroup newIfGroup, NotificationChain msgs) {
		SequenceGroup oldIfGroup = ifGroup;
		ifGroup = newIfGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CONTROL_SEQUENCE__IF_GROUP, oldIfGroup, newIfGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfGroup(SequenceGroup newIfGroup) {
		if (newIfGroup != ifGroup) {
			NotificationChain msgs = null;
			if (ifGroup != null)
				msgs = ((InternalEObject)ifGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTROL_SEQUENCE__IF_GROUP, null, msgs);
			if (newIfGroup != null)
				msgs = ((InternalEObject)newIfGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTROL_SEQUENCE__IF_GROUP, null, msgs);
			msgs = basicSetIfGroup(newIfGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTROL_SEQUENCE__IF_GROUP, newIfGroup, newIfGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceGroup> getElseifGroups() {
		if (elseifGroups == null) {
			elseifGroups = new EObjectContainmentEList<SequenceGroup>(SequenceGroup.class, this, ModelPackage.CONTROL_SEQUENCE__ELSEIF_GROUPS);
		}
		return elseifGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceGroup getElseGroup() {
		return elseGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseGroup(SequenceGroup newElseGroup, NotificationChain msgs) {
		SequenceGroup oldElseGroup = elseGroup;
		elseGroup = newElseGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP, oldElseGroup, newElseGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseGroup(SequenceGroup newElseGroup) {
		if (newElseGroup != elseGroup) {
			NotificationChain msgs = null;
			if (elseGroup != null)
				msgs = ((InternalEObject)elseGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP, null, msgs);
			if (newElseGroup != null)
				msgs = ((InternalEObject)newElseGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP, null, msgs);
			msgs = basicSetElseGroup(newElseGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP, newElseGroup, newElseGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.CONTROL_SEQUENCE__IF_GROUP:
				return basicSetIfGroup(null, msgs);
			case ModelPackage.CONTROL_SEQUENCE__ELSEIF_GROUPS:
				return ((InternalEList<?>)getElseifGroups()).basicRemove(otherEnd, msgs);
			case ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP:
				return basicSetElseGroup(null, msgs);
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
			case ModelPackage.CONTROL_SEQUENCE__IF_GROUP:
				return getIfGroup();
			case ModelPackage.CONTROL_SEQUENCE__ELSEIF_GROUPS:
				return getElseifGroups();
			case ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP:
				return getElseGroup();
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
			case ModelPackage.CONTROL_SEQUENCE__IF_GROUP:
				setIfGroup((SequenceGroup)newValue);
				return;
			case ModelPackage.CONTROL_SEQUENCE__ELSEIF_GROUPS:
				getElseifGroups().clear();
				getElseifGroups().addAll((Collection<? extends SequenceGroup>)newValue);
				return;
			case ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP:
				setElseGroup((SequenceGroup)newValue);
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
			case ModelPackage.CONTROL_SEQUENCE__IF_GROUP:
				setIfGroup((SequenceGroup)null);
				return;
			case ModelPackage.CONTROL_SEQUENCE__ELSEIF_GROUPS:
				getElseifGroups().clear();
				return;
			case ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP:
				setElseGroup((SequenceGroup)null);
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
			case ModelPackage.CONTROL_SEQUENCE__IF_GROUP:
				return ifGroup != null;
			case ModelPackage.CONTROL_SEQUENCE__ELSEIF_GROUPS:
				return elseifGroups != null && !elseifGroups.isEmpty();
			case ModelPackage.CONTROL_SEQUENCE__ELSE_GROUP:
				return elseGroup != null;
		}
		return super.eIsSet(featureID);
	}

} //ControlSequenceImpl
