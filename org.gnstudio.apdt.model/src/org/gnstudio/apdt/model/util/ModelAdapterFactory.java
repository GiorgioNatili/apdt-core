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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gnstudio.apdt.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch =
		new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseDescription(Description object) {
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseDiscussion(Discussion object) {
				return createDiscussionAdapter();
			}
			@Override
			public Adapter caseDescriptionProvider(DescriptionProvider object) {
				return createDescriptionProviderAdapter();
			}
			@Override
			public Adapter caseDiscussionProvider(DiscussionProvider object) {
				return createDiscussionProviderAdapter();
			}
			@Override
			public Adapter caseSourceLink(SourceLink object) {
				return createSourceLinkAdapter();
			}
			@Override
			public Adapter caseSourceLinkProvider(SourceLinkProvider object) {
				return createSourceLinkProviderAdapter();
			}
			@Override
			public Adapter caseProgram(Program object) {
				return createProgramAdapter();
			}
			@Override
			public Adapter casePackageElement(PackageElement object) {
				return createPackageElementAdapter();
			}
			@Override
			public Adapter caseInterfaceElement(InterfaceElement object) {
				return createInterfaceElementAdapter();
			}
			@Override
			public Adapter caseClassElement(ClassElement object) {
				return createClassElementAdapter();
			}
			@Override
			public Adapter caseClassMember(ClassMember object) {
				return createClassMemberAdapter();
			}
			@Override
			public Adapter caseTypeReference(TypeReference object) {
				return createTypeReferenceAdapter();
			}
			@Override
			public Adapter caseMethod(Method object) {
				return createMethodAdapter();
			}
			@Override
			public Adapter caseMethodSignature(MethodSignature object) {
				return createMethodSignatureAdapter();
			}
			@Override
			public Adapter caseMethodArgument(MethodArgument object) {
				return createMethodArgumentAdapter();
			}
			@Override
			public Adapter caseSequence(Sequence object) {
				return createSequenceAdapter();
			}
			@Override
			public Adapter caseSequenceProvider(SequenceProvider object) {
				return createSequenceProviderAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseComment(Comment object) {
				return createCommentAdapter();
			}
			@Override
			public Adapter caseSequenceGroup(SequenceGroup object) {
				return createSequenceGroupAdapter();
			}
			@Override
			public Adapter caseIteration(Iteration object) {
				return createIterationAdapter();
			}
			@Override
			public Adapter caseMethodCall(MethodCall object) {
				return createMethodCallAdapter();
			}
			@Override
			public Adapter caseMethodReturn(MethodReturn object) {
				return createMethodReturnAdapter();
			}
			@Override
			public Adapter caseSwitchSequence(SwitchSequence object) {
				return createSwitchSequenceAdapter();
			}
			@Override
			public Adapter caseControlSequence(ControlSequence object) {
				return createControlSequenceAdapter();
			}
			@Override
			public Adapter caseTrySequence(TrySequence object) {
				return createTrySequenceAdapter();
			}
			@Override
			public Adapter caseRecursion(Recursion object) {
				return createRecursionAdapter();
			}
			@Override
			public Adapter casePrint(Print object) {
				return createPrintAdapter();
			}
			@Override
			public Adapter caseRead(Read object) {
				return createReadAdapter();
			}
			@Override
			public Adapter caseWrite(Write object) {
				return createWriteAdapter();
			}
			@Override
			public Adapter caseRecover(Recover object) {
				return createRecoverAdapter();
			}
			@Override
			public Adapter caseStore(Store object) {
				return createStoreAdapter();
			}
			@Override
			public Adapter caseCalculateStore(CalculateStore object) {
				return createCalculateStoreAdapter();
			}
			@Override
			public Adapter caseShow(Show object) {
				return createShowAdapter();
			}
			@Override
			public Adapter casePrompt(Prompt object) {
				return createPromptAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Description
	 * @generated
	 */
	public Adapter createDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Discussion <em>Discussion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Discussion
	 * @generated
	 */
	public Adapter createDiscussionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.PackageElement <em>Package Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.PackageElement
	 * @generated
	 */
	public Adapter createPackageElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.TypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.TypeReference
	 * @generated
	 */
	public Adapter createTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.InterfaceElement <em>Interface Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.InterfaceElement
	 * @generated
	 */
	public Adapter createInterfaceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.ClassElement <em>Class Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.ClassElement
	 * @generated
	 */
	public Adapter createClassElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.ClassMember <em>Class Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.ClassMember
	 * @generated
	 */
	public Adapter createClassMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Method
	 * @generated
	 */
	public Adapter createMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.MethodSignature <em>Method Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.MethodSignature
	 * @generated
	 */
	public Adapter createMethodSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.MethodArgument <em>Method Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.MethodArgument
	 * @generated
	 */
	public Adapter createMethodArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.SequenceProvider <em>Sequence Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.SequenceProvider
	 * @generated
	 */
	public Adapter createSequenceProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Comment
	 * @generated
	 */
	public Adapter createCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.SequenceGroup <em>Sequence Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.SequenceGroup
	 * @generated
	 */
	public Adapter createSequenceGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Iteration
	 * @generated
	 */
	public Adapter createIterationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.MethodCall <em>Method Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.MethodCall
	 * @generated
	 */
	public Adapter createMethodCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.MethodReturn <em>Method Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.MethodReturn
	 * @generated
	 */
	public Adapter createMethodReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.SwitchSequence <em>Switch Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.SwitchSequence
	 * @generated
	 */
	public Adapter createSwitchSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.ControlSequence <em>Control Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.ControlSequence
	 * @generated
	 */
	public Adapter createControlSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Recursion <em>Recursion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Recursion
	 * @generated
	 */
	public Adapter createRecursionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Print
	 * @generated
	 */
	public Adapter createPrintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Read <em>Read</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Read
	 * @generated
	 */
	public Adapter createReadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Write <em>Write</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Write
	 * @generated
	 */
	public Adapter createWriteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Recover <em>Recover</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Recover
	 * @generated
	 */
	public Adapter createRecoverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Store
	 * @generated
	 */
	public Adapter createStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.CalculateStore <em>Calculate Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.CalculateStore
	 * @generated
	 */
	public Adapter createCalculateStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Show <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Show
	 * @generated
	 */
	public Adapter createShowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.Prompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.Prompt
	 * @generated
	 */
	public Adapter createPromptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.TrySequence <em>Try Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.TrySequence
	 * @generated
	 */
	public Adapter createTrySequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.DescriptionProvider <em>Description Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.DescriptionProvider
	 * @generated
	 */
	public Adapter createDescriptionProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.DiscussionProvider <em>Discussion Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.DiscussionProvider
	 * @generated
	 */
	public Adapter createDiscussionProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.SourceLink <em>Source Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.SourceLink
	 * @generated
	 */
	public Adapter createSourceLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gnstudio.apdt.model.SourceLinkProvider <em>Source Link Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gnstudio.apdt.model.SourceLinkProvider
	 * @generated
	 */
	public Adapter createSourceLinkProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModelAdapterFactory
