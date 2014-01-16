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
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.DiscussionProvider;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.MethodArgument;
import org.gnstudio.apdt.model.MethodSignature;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceProvider;
import org.gnstudio.apdt.model.TypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getDiscussions <em>Discussions</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getSequences <em>Sequences</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getNote <em>Note</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getThrowsElements <em>Throws Elements</em>}</li>
 *   <li>{@link org.gnstudio.apdt.model.impl.MethodImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends EObjectImpl implements Method {
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
	 * The cached value of the '{@link #getSequences() <em>Sequences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<Sequence> sequences;

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
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected MethodSignature signature;

	/**
	 * The cached value of the '{@link #getThrowsElements() <em>Throws Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowsElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeReference> throwsElements;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<MethodArgument> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.METHOD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METHOD__NOTE, oldNote, note));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METHOD__ANNOTATION, oldAnnotation, annotation));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.METHOD__DESCRIPTION, oldDescription, newDescription);
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
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.METHOD__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.METHOD__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METHOD__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Discussion> getDiscussions() {
		if (discussions == null) {
			discussions = new EObjectContainmentEList<Discussion>(Discussion.class, this, ModelPackage.METHOD__DISCUSSIONS);
		}
		return discussions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sequence> getSequences() {
		if (sequences == null) {
			sequences = new EObjectContainmentEList<Sequence>(Sequence.class, this, ModelPackage.METHOD__SEQUENCES);
		}
		return sequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodSignature getSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSignature(MethodSignature newSignature, NotificationChain msgs) {
		MethodSignature oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.METHOD__SIGNATURE, oldSignature, newSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(MethodSignature newSignature) {
		if (newSignature != signature) {
			NotificationChain msgs = null;
			if (signature != null)
				msgs = ((InternalEObject)signature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.METHOD__SIGNATURE, null, msgs);
			if (newSignature != null)
				msgs = ((InternalEObject)newSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.METHOD__SIGNATURE, null, msgs);
			msgs = basicSetSignature(newSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.METHOD__SIGNATURE, newSignature, newSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeReference> getThrowsElements() {
		if (throwsElements == null) {
			throwsElements = new EObjectContainmentEList<TypeReference>(TypeReference.class, this, ModelPackage.METHOD__THROWS_ELEMENTS);
		}
		return throwsElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodArgument> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<MethodArgument>(MethodArgument.class, this, ModelPackage.METHOD__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.METHOD__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case ModelPackage.METHOD__DISCUSSIONS:
				return ((InternalEList<?>)getDiscussions()).basicRemove(otherEnd, msgs);
			case ModelPackage.METHOD__SEQUENCES:
				return ((InternalEList<?>)getSequences()).basicRemove(otherEnd, msgs);
			case ModelPackage.METHOD__SIGNATURE:
				return basicSetSignature(null, msgs);
			case ModelPackage.METHOD__THROWS_ELEMENTS:
				return ((InternalEList<?>)getThrowsElements()).basicRemove(otherEnd, msgs);
			case ModelPackage.METHOD__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.METHOD__DESCRIPTION:
				return getDescription();
			case ModelPackage.METHOD__DISCUSSIONS:
				return getDiscussions();
			case ModelPackage.METHOD__SEQUENCES:
				return getSequences();
			case ModelPackage.METHOD__NOTE:
				return getNote();
			case ModelPackage.METHOD__ANNOTATION:
				return getAnnotation();
			case ModelPackage.METHOD__SIGNATURE:
				return getSignature();
			case ModelPackage.METHOD__THROWS_ELEMENTS:
				return getThrowsElements();
			case ModelPackage.METHOD__ARGUMENTS:
				return getArguments();
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
			case ModelPackage.METHOD__DESCRIPTION:
				setDescription((Description)newValue);
				return;
			case ModelPackage.METHOD__DISCUSSIONS:
				getDiscussions().clear();
				getDiscussions().addAll((Collection<? extends Discussion>)newValue);
				return;
			case ModelPackage.METHOD__SEQUENCES:
				getSequences().clear();
				getSequences().addAll((Collection<? extends Sequence>)newValue);
				return;
			case ModelPackage.METHOD__NOTE:
				setNote((String)newValue);
				return;
			case ModelPackage.METHOD__ANNOTATION:
				setAnnotation((String)newValue);
				return;
			case ModelPackage.METHOD__SIGNATURE:
				setSignature((MethodSignature)newValue);
				return;
			case ModelPackage.METHOD__THROWS_ELEMENTS:
				getThrowsElements().clear();
				getThrowsElements().addAll((Collection<? extends TypeReference>)newValue);
				return;
			case ModelPackage.METHOD__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends MethodArgument>)newValue);
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
			case ModelPackage.METHOD__DESCRIPTION:
				setDescription((Description)null);
				return;
			case ModelPackage.METHOD__DISCUSSIONS:
				getDiscussions().clear();
				return;
			case ModelPackage.METHOD__SEQUENCES:
				getSequences().clear();
				return;
			case ModelPackage.METHOD__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ModelPackage.METHOD__ANNOTATION:
				setAnnotation(ANNOTATION_EDEFAULT);
				return;
			case ModelPackage.METHOD__SIGNATURE:
				setSignature((MethodSignature)null);
				return;
			case ModelPackage.METHOD__THROWS_ELEMENTS:
				getThrowsElements().clear();
				return;
			case ModelPackage.METHOD__ARGUMENTS:
				getArguments().clear();
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
			case ModelPackage.METHOD__DESCRIPTION:
				return description != null;
			case ModelPackage.METHOD__DISCUSSIONS:
				return discussions != null && !discussions.isEmpty();
			case ModelPackage.METHOD__SEQUENCES:
				return sequences != null && !sequences.isEmpty();
			case ModelPackage.METHOD__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ModelPackage.METHOD__ANNOTATION:
				return ANNOTATION_EDEFAULT == null ? annotation != null : !ANNOTATION_EDEFAULT.equals(annotation);
			case ModelPackage.METHOD__SIGNATURE:
				return signature != null;
			case ModelPackage.METHOD__THROWS_ELEMENTS:
				return throwsElements != null && !throwsElements.isEmpty();
			case ModelPackage.METHOD__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
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
				case ModelPackage.METHOD__DISCUSSIONS: return ModelPackage.DISCUSSION_PROVIDER__DISCUSSIONS;
				default: return -1;
			}
		}
		if (baseClass == SequenceProvider.class) {
			switch (derivedFeatureID) {
				case ModelPackage.METHOD__SEQUENCES: return ModelPackage.SEQUENCE_PROVIDER__SEQUENCES;
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
				case ModelPackage.DISCUSSION_PROVIDER__DISCUSSIONS: return ModelPackage.METHOD__DISCUSSIONS;
				default: return -1;
			}
		}
		if (baseClass == SequenceProvider.class) {
			switch (baseFeatureID) {
				case ModelPackage.SEQUENCE_PROVIDER__SEQUENCES: return ModelPackage.METHOD__SEQUENCES;
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
		result.append(", annotation: ");
		result.append(annotation);
		result.append(')');
		return result.toString();
	}

} //MethodImpl
