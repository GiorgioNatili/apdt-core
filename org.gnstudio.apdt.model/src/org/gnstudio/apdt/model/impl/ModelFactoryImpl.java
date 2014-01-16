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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.gnstudio.apdt.model.*;
import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.DeclarationType;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.MethodSignature;
import org.gnstudio.apdt.model.MethodType;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.TypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/gnstudio/apdt/model.ecore"); 
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.MODEL: return createModel();
			case ModelPackage.DESCRIPTION: return createDescription();
			case ModelPackage.DISCUSSION: return createDiscussion();
			case ModelPackage.SOURCE_LINK: return createSourceLink();
			case ModelPackage.PROGRAM: return createProgram();
			case ModelPackage.PACKAGE_ELEMENT: return createPackageElement();
			case ModelPackage.INTERFACE_ELEMENT: return createInterfaceElement();
			case ModelPackage.CLASS_ELEMENT: return createClassElement();
			case ModelPackage.CLASS_MEMBER: return createClassMember();
			case ModelPackage.TYPE_REFERENCE: return createTypeReference();
			case ModelPackage.METHOD: return createMethod();
			case ModelPackage.METHOD_SIGNATURE: return createMethodSignature();
			case ModelPackage.METHOD_ARGUMENT: return createMethodArgument();
			case ModelPackage.VARIABLE: return createVariable();
			case ModelPackage.COMMENT: return createComment();
			case ModelPackage.SEQUENCE_GROUP: return createSequenceGroup();
			case ModelPackage.ITERATION: return createIteration();
			case ModelPackage.METHOD_CALL: return createMethodCall();
			case ModelPackage.METHOD_RETURN: return createMethodReturn();
			case ModelPackage.SWITCH_SEQUENCE: return createSwitchSequence();
			case ModelPackage.CONTROL_SEQUENCE: return createControlSequence();
			case ModelPackage.TRY_SEQUENCE: return createTrySequence();
			case ModelPackage.RECURSION: return createRecursion();
			case ModelPackage.PRINT: return createPrint();
			case ModelPackage.READ: return createRead();
			case ModelPackage.WRITE: return createWrite();
			case ModelPackage.RECOVER: return createRecover();
			case ModelPackage.STORE: return createStore();
			case ModelPackage.CALCULATE_STORE: return createCalculateStore();
			case ModelPackage.SHOW: return createShow();
			case ModelPackage.PROMPT: return createPrompt();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.ACCESS_TYPE:
				return createAccessTypeFromString(eDataType, initialValue);
			case ModelPackage.DECLARATION_TYPE:
				return createDeclarationTypeFromString(eDataType, initialValue);
			case ModelPackage.METHOD_TYPE:
				return createMethodTypeFromString(eDataType, initialValue);
			case ModelPackage.ITERATION_TYPE:
				return createIterationTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.ACCESS_TYPE:
				return convertAccessTypeToString(eDataType, instanceValue);
			case ModelPackage.DECLARATION_TYPE:
				return convertDeclarationTypeToString(eDataType, instanceValue);
			case ModelPackage.METHOD_TYPE:
				return convertMethodTypeToString(eDataType, instanceValue);
			case ModelPackage.ITERATION_TYPE:
				return convertIterationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Description createDescription() {
		DescriptionImpl description = new DescriptionImpl();
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Discussion createDiscussion() {
		DiscussionImpl discussion = new DiscussionImpl();
		return discussion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceLink createSourceLink() {
		SourceLinkImpl sourceLink = new SourceLinkImpl();
		return sourceLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageElement createPackageElement() {
		PackageElementImpl packageElement = new PackageElementImpl();
		return packageElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeReference createTypeReference() {
		TypeReferenceImpl typeReference = new TypeReferenceImpl();
		return typeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceElement createInterfaceElement() {
		InterfaceElementImpl interfaceElement = new InterfaceElementImpl();
		return interfaceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassElement createClassElement() {
		ClassElementImpl classElement = new ClassElementImpl();
		return classElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMember createClassMember() {
		ClassMemberImpl classMember = new ClassMemberImpl();
		return classMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodSignature createMethodSignature() {
		MethodSignatureImpl methodSignature = new MethodSignatureImpl();
		return methodSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodArgument createMethodArgument() {
		MethodArgumentImpl methodArgument = new MethodArgumentImpl();
		return methodArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceGroup createSequenceGroup() {
		SequenceGroupImpl sequenceGroup = new SequenceGroupImpl();
		return sequenceGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iteration createIteration() {
		IterationImpl iteration = new IterationImpl();
		return iteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodCall createMethodCall() {
		MethodCallImpl methodCall = new MethodCallImpl();
		return methodCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodReturn createMethodReturn() {
		MethodReturnImpl methodReturn = new MethodReturnImpl();
		return methodReturn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchSequence createSwitchSequence() {
		SwitchSequenceImpl switchSequence = new SwitchSequenceImpl();
		return switchSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlSequence createControlSequence() {
		ControlSequenceImpl controlSequence = new ControlSequenceImpl();
		return controlSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recursion createRecursion() {
		RecursionImpl recursion = new RecursionImpl();
		return recursion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Print createPrint() {
		PrintImpl print = new PrintImpl();
		return print;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Read createRead() {
		ReadImpl read = new ReadImpl();
		return read;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Write createWrite() {
		WriteImpl write = new WriteImpl();
		return write;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recover createRecover() {
		RecoverImpl recover = new RecoverImpl();
		return recover;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Store createStore() {
		StoreImpl store = new StoreImpl();
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CalculateStore createCalculateStore() {
		CalculateStoreImpl calculateStore = new CalculateStoreImpl();
		return calculateStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Show createShow() {
		ShowImpl show = new ShowImpl();
		return show;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Prompt createPrompt() {
		PromptImpl prompt = new PromptImpl();
		return prompt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrySequence createTrySequence() {
		TrySequenceImpl trySequence = new TrySequenceImpl();
		return trySequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessType createAccessTypeFromString(EDataType eDataType, String initialValue) {
		AccessType result = AccessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationType createDeclarationTypeFromString(EDataType eDataType, String initialValue) {
		DeclarationType result = DeclarationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDeclarationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodType createMethodTypeFromString(EDataType eDataType, String initialValue) {
		MethodType result = MethodType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationType createIterationTypeFromString(EDataType eDataType, String initialValue) {
		IterationType result = IterationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIterationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
