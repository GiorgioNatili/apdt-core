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
package org.gnstudio.apdt.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gnstudio.apdt.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = org.gnstudio.apdt.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description</em>'.
	 * @generated
	 */
	Description createDescription();

	/**
	 * Returns a new object of class '<em>Discussion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Discussion</em>'.
	 * @generated
	 */
	Discussion createDiscussion();

	/**
	 * Returns a new object of class '<em>Source Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Link</em>'.
	 * @generated
	 */
	SourceLink createSourceLink();

	/**
	 * Returns a new object of class '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program</em>'.
	 * @generated
	 */
	Program createProgram();

	/**
	 * Returns a new object of class '<em>Package Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Element</em>'.
	 * @generated
	 */
	PackageElement createPackageElement();

	/**
	 * Returns a new object of class '<em>Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Reference</em>'.
	 * @generated
	 */
	TypeReference createTypeReference();

	/**
	 * Returns a new object of class '<em>Interface Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Element</em>'.
	 * @generated
	 */
	InterfaceElement createInterfaceElement();

	/**
	 * Returns a new object of class '<em>Class Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Element</em>'.
	 * @generated
	 */
	ClassElement createClassElement();

	/**
	 * Returns a new object of class '<em>Class Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Member</em>'.
	 * @generated
	 */
	ClassMember createClassMember();

	/**
	 * Returns a new object of class '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method</em>'.
	 * @generated
	 */
	Method createMethod();

	/**
	 * Returns a new object of class '<em>Method Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Signature</em>'.
	 * @generated
	 */
	MethodSignature createMethodSignature();

	/**
	 * Returns a new object of class '<em>Method Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Argument</em>'.
	 * @generated
	 */
	MethodArgument createMethodArgument();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Sequence Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Group</em>'.
	 * @generated
	 */
	SequenceGroup createSequenceGroup();

	/**
	 * Returns a new object of class '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration</em>'.
	 * @generated
	 */
	Iteration createIteration();

	/**
	 * Returns a new object of class '<em>Method Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Call</em>'.
	 * @generated
	 */
	MethodCall createMethodCall();

	/**
	 * Returns a new object of class '<em>Method Return</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Return</em>'.
	 * @generated
	 */
	MethodReturn createMethodReturn();

	/**
	 * Returns a new object of class '<em>Switch Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Sequence</em>'.
	 * @generated
	 */
	SwitchSequence createSwitchSequence();

	/**
	 * Returns a new object of class '<em>Control Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Sequence</em>'.
	 * @generated
	 */
	ControlSequence createControlSequence();

	/**
	 * Returns a new object of class '<em>Recursion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recursion</em>'.
	 * @generated
	 */
	Recursion createRecursion();

	/**
	 * Returns a new object of class '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Print</em>'.
	 * @generated
	 */
	Print createPrint();

	/**
	 * Returns a new object of class '<em>Read</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read</em>'.
	 * @generated
	 */
	Read createRead();

	/**
	 * Returns a new object of class '<em>Write</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write</em>'.
	 * @generated
	 */
	Write createWrite();

	/**
	 * Returns a new object of class '<em>Recover</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recover</em>'.
	 * @generated
	 */
	Recover createRecover();

	/**
	 * Returns a new object of class '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Store</em>'.
	 * @generated
	 */
	Store createStore();

	/**
	 * Returns a new object of class '<em>Calculate Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Calculate Store</em>'.
	 * @generated
	 */
	CalculateStore createCalculateStore();

	/**
	 * Returns a new object of class '<em>Show</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show</em>'.
	 * @generated
	 */
	Show createShow();

	/**
	 * Returns a new object of class '<em>Prompt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prompt</em>'.
	 * @generated
	 */
	Prompt createPrompt();

	/**
	 * Returns a new object of class '<em>Try Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Try Sequence</em>'.
	 * @generated
	 */
	TrySequence createTrySequence();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
