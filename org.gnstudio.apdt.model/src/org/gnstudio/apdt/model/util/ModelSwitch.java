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
package org.gnstudio.apdt.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.gnstudio.apdt.model.*;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.DescriptionProvider;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.MethodSignature;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.TypeReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.gnstudio.apdt.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseSequenceProvider(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DESCRIPTION: {
				Description description = (Description)theEObject;
				T result = caseDescription(description);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DISCUSSION: {
				Discussion discussion = (Discussion)theEObject;
				T result = caseDiscussion(discussion);
				if (result == null) result = caseDescription(discussion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DESCRIPTION_PROVIDER: {
				DescriptionProvider descriptionProvider = (DescriptionProvider)theEObject;
				T result = caseDescriptionProvider(descriptionProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.DISCUSSION_PROVIDER: {
				DiscussionProvider discussionProvider = (DiscussionProvider)theEObject;
				T result = caseDiscussionProvider(discussionProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SOURCE_LINK: {
				SourceLink sourceLink = (SourceLink)theEObject;
				T result = caseSourceLink(sourceLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SOURCE_LINK_PROVIDER: {
				SourceLinkProvider sourceLinkProvider = (SourceLinkProvider)theEObject;
				T result = caseSourceLinkProvider(sourceLinkProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROGRAM: {
				Program program = (Program)theEObject;
				T result = caseProgram(program);
				if (result == null) result = caseDescriptionProvider(program);
				if (result == null) result = caseDiscussionProvider(program);
				if (result == null) result = caseSourceLinkProvider(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PACKAGE_ELEMENT: {
				PackageElement packageElement = (PackageElement)theEObject;
				T result = casePackageElement(packageElement);
				if (result == null) result = caseDiscussionProvider(packageElement);
				if (result == null) result = caseSourceLinkProvider(packageElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.INTERFACE_ELEMENT: {
				InterfaceElement interfaceElement = (InterfaceElement)theEObject;
				T result = caseInterfaceElement(interfaceElement);
				if (result == null) result = caseDescriptionProvider(interfaceElement);
				if (result == null) result = caseDiscussionProvider(interfaceElement);
				if (result == null) result = caseSourceLinkProvider(interfaceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CLASS_ELEMENT: {
				ClassElement classElement = (ClassElement)theEObject;
				T result = caseClassElement(classElement);
				if (result == null) result = caseDescriptionProvider(classElement);
				if (result == null) result = caseDiscussionProvider(classElement);
				if (result == null) result = caseSourceLinkProvider(classElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CLASS_MEMBER: {
				ClassMember classMember = (ClassMember)theEObject;
				T result = caseClassMember(classMember);
				if (result == null) result = caseDescriptionProvider(classMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TYPE_REFERENCE: {
				TypeReference typeReference = (TypeReference)theEObject;
				T result = caseTypeReference(typeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.METHOD: {
				Method method = (Method)theEObject;
				T result = caseMethod(method);
				if (result == null) result = caseDescriptionProvider(method);
				if (result == null) result = caseDiscussionProvider(method);
				if (result == null) result = caseSequenceProvider(method);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.METHOD_SIGNATURE: {
				MethodSignature methodSignature = (MethodSignature)theEObject;
				T result = caseMethodSignature(methodSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.METHOD_ARGUMENT: {
				MethodArgument methodArgument = (MethodArgument)theEObject;
				T result = caseMethodArgument(methodArgument);
				if (result == null) result = caseDescriptionProvider(methodArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SEQUENCE_PROVIDER: {
				SequenceProvider sequenceProvider = (SequenceProvider)theEObject;
				T result = caseSequenceProvider(sequenceProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseDescriptionProvider(variable);
				if (result == null) result = caseSequence(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseDescription(comment);
				if (result == null) result = caseSequence(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SEQUENCE_GROUP: {
				SequenceGroup sequenceGroup = (SequenceGroup)theEObject;
				T result = caseSequenceGroup(sequenceGroup);
				if (result == null) result = caseDescriptionProvider(sequenceGroup);
				if (result == null) result = caseSequence(sequenceGroup);
				if (result == null) result = caseSequenceProvider(sequenceGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ITERATION: {
				Iteration iteration = (Iteration)theEObject;
				T result = caseIteration(iteration);
				if (result == null) result = caseSequenceGroup(iteration);
				if (result == null) result = caseDescriptionProvider(iteration);
				if (result == null) result = caseSequence(iteration);
				if (result == null) result = caseSequenceProvider(iteration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.METHOD_CALL: {
				MethodCall methodCall = (MethodCall)theEObject;
				T result = caseMethodCall(methodCall);
				if (result == null) result = caseDescriptionProvider(methodCall);
				if (result == null) result = caseSequence(methodCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.METHOD_RETURN: {
				MethodReturn methodReturn = (MethodReturn)theEObject;
				T result = caseMethodReturn(methodReturn);
				if (result == null) result = caseSequence(methodReturn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SWITCH_SEQUENCE: {
				SwitchSequence switchSequence = (SwitchSequence)theEObject;
				T result = caseSwitchSequence(switchSequence);
				if (result == null) result = caseSequence(switchSequence);
				if (result == null) result = caseDescriptionProvider(switchSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONTROL_SEQUENCE: {
				ControlSequence controlSequence = (ControlSequence)theEObject;
				T result = caseControlSequence(controlSequence);
				if (result == null) result = caseSequence(controlSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TRY_SEQUENCE: {
				TrySequence trySequence = (TrySequence)theEObject;
				T result = caseTrySequence(trySequence);
				if (result == null) result = caseSequence(trySequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RECURSION: {
				Recursion recursion = (Recursion)theEObject;
				T result = caseRecursion(recursion);
				if (result == null) result = caseDescription(recursion);
				if (result == null) result = caseSequence(recursion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PRINT: {
				Print print = (Print)theEObject;
				T result = casePrint(print);
				if (result == null) result = caseDescription(print);
				if (result == null) result = caseSequence(print);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.READ: {
				Read read = (Read)theEObject;
				T result = caseRead(read);
				if (result == null) result = caseDescription(read);
				if (result == null) result = caseSequence(read);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.WRITE: {
				Write write = (Write)theEObject;
				T result = caseWrite(write);
				if (result == null) result = caseDescription(write);
				if (result == null) result = caseSequence(write);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.RECOVER: {
				Recover recover = (Recover)theEObject;
				T result = caseRecover(recover);
				if (result == null) result = caseDescription(recover);
				if (result == null) result = caseSequence(recover);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.STORE: {
				Store store = (Store)theEObject;
				T result = caseStore(store);
				if (result == null) result = caseDescription(store);
				if (result == null) result = caseSequence(store);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CALCULATE_STORE: {
				CalculateStore calculateStore = (CalculateStore)theEObject;
				T result = caseCalculateStore(calculateStore);
				if (result == null) result = caseDescription(calculateStore);
				if (result == null) result = caseSequence(calculateStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.SHOW: {
				Show show = (Show)theEObject;
				T result = caseShow(show);
				if (result == null) result = caseDescription(show);
				if (result == null) result = caseSequence(show);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PROMPT: {
				Prompt prompt = (Prompt)theEObject;
				T result = casePrompt(prompt);
				if (result == null) result = caseDescription(prompt);
				if (result == null) result = caseSequence(prompt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescription(Description object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discussion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discussion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscussion(Discussion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageElement(PackageElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeReference(TypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceElement(InterfaceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassElement(ClassElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMember(ClassMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethod(Method object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodSignature(MethodSignature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodArgument(MethodArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceProvider(SequenceProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceGroup(SequenceGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteration(Iteration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodCall(MethodCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodReturn(MethodReturn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchSequence(SwitchSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlSequence(ControlSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recursion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recursion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecursion(Recursion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Print</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrint(Print object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRead(Read object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Write</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Write</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWrite(Write object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recover</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recover</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecover(Recover object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStore(Store object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calculate Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calculate Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalculateStore(CalculateStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShow(Show object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prompt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prompt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrompt(Prompt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Try Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Try Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrySequence(TrySequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionProvider(DescriptionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discussion Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discussion Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscussionProvider(DiscussionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceLink(SourceLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Link Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Link Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceLinkProvider(SourceLinkProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ModelSwitch
