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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.CalculateStore;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.ClassMember;
import org.gnstudio.apdt.model.Comment;
import org.gnstudio.apdt.model.ControlSequence;
import org.gnstudio.apdt.model.DeclarationType;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.DescriptionProvider;
import org.gnstudio.apdt.model.Discussion;
import org.gnstudio.apdt.model.DiscussionProvider;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Iteration;
import org.gnstudio.apdt.model.IterationType;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.MethodArgument;
import org.gnstudio.apdt.model.MethodCall;
import org.gnstudio.apdt.model.MethodReturn;
import org.gnstudio.apdt.model.MethodSignature;
import org.gnstudio.apdt.model.MethodType;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.ModelPackage;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Print;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.Prompt;
import org.gnstudio.apdt.model.Read;
import org.gnstudio.apdt.model.Recover;
import org.gnstudio.apdt.model.Recursion;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.SequenceGroup;
import org.gnstudio.apdt.model.SequenceProvider;
import org.gnstudio.apdt.model.Show;
import org.gnstudio.apdt.model.SourceLink;
import org.gnstudio.apdt.model.SourceLinkProvider;
import org.gnstudio.apdt.model.Store;
import org.gnstudio.apdt.model.SwitchSequence;
import org.gnstudio.apdt.model.TrySequence;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.Variable;
import org.gnstudio.apdt.model.Write;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discussionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodReturnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recursionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recoverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculateStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass promptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trySequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass discussionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceLinkProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum declarationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum methodTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum iterationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gnstudio.apdt.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Version() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Release() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Description() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Programs() {
		return (EReference)modelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Packages() {
		return (EReference)modelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_InterfaceElement() {
		return (EReference)modelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_ClassElement() {
		return (EReference)modelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Author() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_UpdatedBy() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Created() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Updated() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModel_Encoding() {
		return (EAttribute)modelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescription() {
		return descriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescription_Text() {
		return (EAttribute)descriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscussion() {
		return discussionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiscussion_Author() {
		return (EAttribute)discussionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgram_Name() {
		return (EAttribute)programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Packages() {
		return (EReference)programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageElement() {
		return packageElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageElement_Name() {
		return (EAttribute)packageElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageElement_Interfaces() {
		return (EReference)packageElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageElement_Classes() {
		return (EReference)packageElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeReference() {
		return typeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeReference_Name() {
		return (EAttribute)typeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceElement() {
		return interfaceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceElement_Name() {
		return (EAttribute)interfaceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceElement_Access() {
		return (EAttribute)interfaceElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceElement_ExtendsElements() {
		return (EReference)interfaceElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceElement_Methods() {
		return (EReference)interfaceElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassElement() {
		return classElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassElement_Name() {
		return (EAttribute)classElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassElement_Access() {
		return (EAttribute)classElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassElement_Annotation() {
		return (EAttribute)classElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassElement_Final() {
		return (EAttribute)classElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassElement_Dynamic() {
		return (EAttribute)classElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassElement_ImplementsElements() {
		return (EReference)classElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassElement_ExtendsElements() {
		return (EReference)classElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassElement_Methods() {
		return (EReference)classElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassElement_Members() {
		return (EReference)classElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassMember() {
		return classMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMember_Note() {
		return (EAttribute)classMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMember_Name() {
		return (EAttribute)classMemberEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMember_Access() {
		return (EAttribute)classMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassMember_Type() {
		return (EReference)classMemberEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMember_Annotation() {
		return (EAttribute)classMemberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassMember_Declaration() {
		return (EAttribute)classMemberEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Note() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Annotation() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Signature() {
		return (EReference)methodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_ThrowsElements() {
		return (EReference)methodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Arguments() {
		return (EReference)methodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodSignature() {
		return methodSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodSignature_Name() {
		return (EAttribute)methodSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodSignature_Access() {
		return (EAttribute)methodSignatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodSignature_Type() {
		return (EAttribute)methodSignatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodSignature_Declaration() {
		return (EAttribute)methodSignatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodSignature_Varargs() {
		return (EAttribute)methodSignatureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodSignature_ReturnType() {
		return (EReference)methodSignatureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodArgument() {
		return methodArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodArgument_Type() {
		return (EReference)methodArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodArgument_Name() {
		return (EAttribute)methodArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceProvider() {
		return sequenceProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceProvider_Sequences() {
		return (EReference)sequenceProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Declaration() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Type() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Note() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Value() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceGroup() {
		return sequenceGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceGroup_Name() {
		return (EAttribute)sequenceGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIteration() {
		return iterationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIteration_Type() {
		return (EAttribute)iterationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodCall() {
		return methodCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodCall_Name() {
		return (EAttribute)methodCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodCall_Arguments() {
		return (EAttribute)methodCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodReturn() {
		return methodReturnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodReturn_Note() {
		return (EAttribute)methodReturnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchSequence() {
		return switchSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchSequence_Note() {
		return (EAttribute)switchSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchSequence_Cases() {
		return (EReference)switchSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchSequence_DefaultCase() {
		return (EReference)switchSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlSequence() {
		return controlSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlSequence_IfGroup() {
		return (EReference)controlSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlSequence_ElseifGroups() {
		return (EReference)controlSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlSequence_ElseGroup() {
		return (EReference)controlSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecursion() {
		return recursionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrint() {
		return printEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRead() {
		return readEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWrite() {
		return writeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecover() {
		return recoverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStore() {
		return storeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalculateStore() {
		return calculateStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShow() {
		return showEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrompt() {
		return promptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrySequence() {
		return trySequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrySequence_TryGroup() {
		return (EReference)trySequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrySequence_CatchGroups() {
		return (EReference)trySequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrySequence_FinallyGroup() {
		return (EReference)trySequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionProvider() {
		return descriptionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionProvider_Description() {
		return (EReference)descriptionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiscussionProvider() {
		return discussionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiscussionProvider_Discussions() {
		return (EReference)discussionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceLink() {
		return sourceLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceLink_Path() {
		return (EAttribute)sourceLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceLinkProvider() {
		return sourceLinkProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceLinkProvider_Link() {
		return (EReference)sourceLinkProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessType() {
		return accessTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDeclarationType() {
		return declarationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMethodType() {
		return methodTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIterationType() {
		return iterationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelEClass = createEClass(MODEL);
		createEAttribute(modelEClass, MODEL__VERSION);
		createEAttribute(modelEClass, MODEL__RELEASE);
		createEAttribute(modelEClass, MODEL__ENCODING);
		createEAttribute(modelEClass, MODEL__DESCRIPTION);
		createEReference(modelEClass, MODEL__PROGRAMS);
		createEReference(modelEClass, MODEL__PACKAGES);
		createEReference(modelEClass, MODEL__INTERFACE_ELEMENT);
		createEReference(modelEClass, MODEL__CLASS_ELEMENT);
		createEAttribute(modelEClass, MODEL__AUTHOR);
		createEAttribute(modelEClass, MODEL__UPDATED_BY);
		createEAttribute(modelEClass, MODEL__CREATED);
		createEAttribute(modelEClass, MODEL__UPDATED);

		descriptionEClass = createEClass(DESCRIPTION);
		createEAttribute(descriptionEClass, DESCRIPTION__TEXT);

		discussionEClass = createEClass(DISCUSSION);
		createEAttribute(discussionEClass, DISCUSSION__AUTHOR);

		descriptionProviderEClass = createEClass(DESCRIPTION_PROVIDER);
		createEReference(descriptionProviderEClass, DESCRIPTION_PROVIDER__DESCRIPTION);

		discussionProviderEClass = createEClass(DISCUSSION_PROVIDER);
		createEReference(discussionProviderEClass, DISCUSSION_PROVIDER__DISCUSSIONS);

		sourceLinkEClass = createEClass(SOURCE_LINK);
		createEAttribute(sourceLinkEClass, SOURCE_LINK__PATH);

		sourceLinkProviderEClass = createEClass(SOURCE_LINK_PROVIDER);
		createEReference(sourceLinkProviderEClass, SOURCE_LINK_PROVIDER__LINK);

		programEClass = createEClass(PROGRAM);
		createEAttribute(programEClass, PROGRAM__NAME);
		createEReference(programEClass, PROGRAM__PACKAGES);

		packageElementEClass = createEClass(PACKAGE_ELEMENT);
		createEAttribute(packageElementEClass, PACKAGE_ELEMENT__NAME);
		createEReference(packageElementEClass, PACKAGE_ELEMENT__INTERFACES);
		createEReference(packageElementEClass, PACKAGE_ELEMENT__CLASSES);

		interfaceElementEClass = createEClass(INTERFACE_ELEMENT);
		createEAttribute(interfaceElementEClass, INTERFACE_ELEMENT__NAME);
		createEAttribute(interfaceElementEClass, INTERFACE_ELEMENT__ACCESS);
		createEReference(interfaceElementEClass, INTERFACE_ELEMENT__EXTENDS_ELEMENTS);
		createEReference(interfaceElementEClass, INTERFACE_ELEMENT__METHODS);

		classElementEClass = createEClass(CLASS_ELEMENT);
		createEAttribute(classElementEClass, CLASS_ELEMENT__NAME);
		createEAttribute(classElementEClass, CLASS_ELEMENT__ACCESS);
		createEAttribute(classElementEClass, CLASS_ELEMENT__ANNOTATION);
		createEAttribute(classElementEClass, CLASS_ELEMENT__FINAL);
		createEAttribute(classElementEClass, CLASS_ELEMENT__DYNAMIC);
		createEReference(classElementEClass, CLASS_ELEMENT__IMPLEMENTS_ELEMENTS);
		createEReference(classElementEClass, CLASS_ELEMENT__EXTENDS_ELEMENTS);
		createEReference(classElementEClass, CLASS_ELEMENT__METHODS);
		createEReference(classElementEClass, CLASS_ELEMENT__MEMBERS);

		classMemberEClass = createEClass(CLASS_MEMBER);
		createEAttribute(classMemberEClass, CLASS_MEMBER__NOTE);
		createEAttribute(classMemberEClass, CLASS_MEMBER__ACCESS);
		createEAttribute(classMemberEClass, CLASS_MEMBER__ANNOTATION);
		createEAttribute(classMemberEClass, CLASS_MEMBER__DECLARATION);
		createEReference(classMemberEClass, CLASS_MEMBER__TYPE);
		createEAttribute(classMemberEClass, CLASS_MEMBER__NAME);

		typeReferenceEClass = createEClass(TYPE_REFERENCE);
		createEAttribute(typeReferenceEClass, TYPE_REFERENCE__NAME);

		methodEClass = createEClass(METHOD);
		createEAttribute(methodEClass, METHOD__NOTE);
		createEAttribute(methodEClass, METHOD__ANNOTATION);
		createEReference(methodEClass, METHOD__SIGNATURE);
		createEReference(methodEClass, METHOD__THROWS_ELEMENTS);
		createEReference(methodEClass, METHOD__ARGUMENTS);

		methodSignatureEClass = createEClass(METHOD_SIGNATURE);
		createEAttribute(methodSignatureEClass, METHOD_SIGNATURE__NAME);
		createEAttribute(methodSignatureEClass, METHOD_SIGNATURE__ACCESS);
		createEAttribute(methodSignatureEClass, METHOD_SIGNATURE__TYPE);
		createEAttribute(methodSignatureEClass, METHOD_SIGNATURE__DECLARATION);
		createEAttribute(methodSignatureEClass, METHOD_SIGNATURE__VARARGS);
		createEReference(methodSignatureEClass, METHOD_SIGNATURE__RETURN_TYPE);

		methodArgumentEClass = createEClass(METHOD_ARGUMENT);
		createEReference(methodArgumentEClass, METHOD_ARGUMENT__TYPE);
		createEAttribute(methodArgumentEClass, METHOD_ARGUMENT__NAME);

		sequenceEClass = createEClass(SEQUENCE);

		sequenceProviderEClass = createEClass(SEQUENCE_PROVIDER);
		createEReference(sequenceProviderEClass, SEQUENCE_PROVIDER__SEQUENCES);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__DECLARATION);
		createEReference(variableEClass, VARIABLE__TYPE);
		createEAttribute(variableEClass, VARIABLE__NOTE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEAttribute(variableEClass, VARIABLE__VALUE);

		commentEClass = createEClass(COMMENT);

		sequenceGroupEClass = createEClass(SEQUENCE_GROUP);
		createEAttribute(sequenceGroupEClass, SEQUENCE_GROUP__NAME);

		iterationEClass = createEClass(ITERATION);
		createEAttribute(iterationEClass, ITERATION__TYPE);

		methodCallEClass = createEClass(METHOD_CALL);
		createEAttribute(methodCallEClass, METHOD_CALL__NAME);
		createEAttribute(methodCallEClass, METHOD_CALL__ARGUMENTS);

		methodReturnEClass = createEClass(METHOD_RETURN);
		createEAttribute(methodReturnEClass, METHOD_RETURN__NOTE);

		switchSequenceEClass = createEClass(SWITCH_SEQUENCE);
		createEAttribute(switchSequenceEClass, SWITCH_SEQUENCE__NOTE);
		createEReference(switchSequenceEClass, SWITCH_SEQUENCE__CASES);
		createEReference(switchSequenceEClass, SWITCH_SEQUENCE__DEFAULT_CASE);

		controlSequenceEClass = createEClass(CONTROL_SEQUENCE);
		createEReference(controlSequenceEClass, CONTROL_SEQUENCE__IF_GROUP);
		createEReference(controlSequenceEClass, CONTROL_SEQUENCE__ELSEIF_GROUPS);
		createEReference(controlSequenceEClass, CONTROL_SEQUENCE__ELSE_GROUP);

		trySequenceEClass = createEClass(TRY_SEQUENCE);
		createEReference(trySequenceEClass, TRY_SEQUENCE__TRY_GROUP);
		createEReference(trySequenceEClass, TRY_SEQUENCE__CATCH_GROUPS);
		createEReference(trySequenceEClass, TRY_SEQUENCE__FINALLY_GROUP);

		recursionEClass = createEClass(RECURSION);

		printEClass = createEClass(PRINT);

		readEClass = createEClass(READ);

		writeEClass = createEClass(WRITE);

		recoverEClass = createEClass(RECOVER);

		storeEClass = createEClass(STORE);

		calculateStoreEClass = createEClass(CALCULATE_STORE);

		showEClass = createEClass(SHOW);

		promptEClass = createEClass(PROMPT);

		// Create enums
		accessTypeEEnum = createEEnum(ACCESS_TYPE);
		declarationTypeEEnum = createEEnum(DECLARATION_TYPE);
		methodTypeEEnum = createEEnum(METHOD_TYPE);
		iterationTypeEEnum = createEEnum(ITERATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelEClass.getESuperTypes().add(this.getSequenceProvider());
		discussionEClass.getESuperTypes().add(this.getDescription());
		programEClass.getESuperTypes().add(this.getDescriptionProvider());
		programEClass.getESuperTypes().add(this.getDiscussionProvider());
		programEClass.getESuperTypes().add(this.getSourceLinkProvider());
		packageElementEClass.getESuperTypes().add(this.getDiscussionProvider());
		packageElementEClass.getESuperTypes().add(this.getSourceLinkProvider());
		interfaceElementEClass.getESuperTypes().add(this.getDescriptionProvider());
		interfaceElementEClass.getESuperTypes().add(this.getDiscussionProvider());
		interfaceElementEClass.getESuperTypes().add(this.getSourceLinkProvider());
		classElementEClass.getESuperTypes().add(this.getDescriptionProvider());
		classElementEClass.getESuperTypes().add(this.getDiscussionProvider());
		classElementEClass.getESuperTypes().add(this.getSourceLinkProvider());
		classMemberEClass.getESuperTypes().add(this.getDescriptionProvider());
		methodEClass.getESuperTypes().add(this.getDescriptionProvider());
		methodEClass.getESuperTypes().add(this.getDiscussionProvider());
		methodEClass.getESuperTypes().add(this.getSequenceProvider());
		methodArgumentEClass.getESuperTypes().add(this.getDescriptionProvider());
		variableEClass.getESuperTypes().add(this.getDescriptionProvider());
		variableEClass.getESuperTypes().add(this.getSequence());
		commentEClass.getESuperTypes().add(this.getDescription());
		commentEClass.getESuperTypes().add(this.getSequence());
		sequenceGroupEClass.getESuperTypes().add(this.getDescriptionProvider());
		sequenceGroupEClass.getESuperTypes().add(this.getSequence());
		sequenceGroupEClass.getESuperTypes().add(this.getSequenceProvider());
		iterationEClass.getESuperTypes().add(this.getSequenceGroup());
		methodCallEClass.getESuperTypes().add(this.getDescriptionProvider());
		methodCallEClass.getESuperTypes().add(this.getSequence());
		methodReturnEClass.getESuperTypes().add(this.getSequence());
		switchSequenceEClass.getESuperTypes().add(this.getSequence());
		switchSequenceEClass.getESuperTypes().add(this.getDescriptionProvider());
		controlSequenceEClass.getESuperTypes().add(this.getSequence());
		trySequenceEClass.getESuperTypes().add(this.getSequence());
		recursionEClass.getESuperTypes().add(this.getDescription());
		recursionEClass.getESuperTypes().add(this.getSequence());
		printEClass.getESuperTypes().add(this.getDescription());
		printEClass.getESuperTypes().add(this.getSequence());
		readEClass.getESuperTypes().add(this.getDescription());
		readEClass.getESuperTypes().add(this.getSequence());
		writeEClass.getESuperTypes().add(this.getDescription());
		writeEClass.getESuperTypes().add(this.getSequence());
		recoverEClass.getESuperTypes().add(this.getDescription());
		recoverEClass.getESuperTypes().add(this.getSequence());
		storeEClass.getESuperTypes().add(this.getDescription());
		storeEClass.getESuperTypes().add(this.getSequence());
		calculateStoreEClass.getESuperTypes().add(this.getDescription());
		calculateStoreEClass.getESuperTypes().add(this.getSequence());
		showEClass.getESuperTypes().add(this.getDescription());
		showEClass.getESuperTypes().add(this.getSequence());
		promptEClass.getESuperTypes().add(this.getDescription());
		promptEClass.getESuperTypes().add(this.getSequence());

		// Initialize classes and features; add operations and parameters
		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModel_Version(), ecorePackage.getEString(), "version", "0.2.0", 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Release(), ecorePackage.getEString(), "release", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Encoding(), ecorePackage.getEString(), "encoding", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Programs(), this.getProgram(), null, "programs", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_Packages(), this.getPackageElement(), null, "packages", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_InterfaceElement(), this.getInterfaceElement(), null, "interfaceElement", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModel_ClassElement(), this.getClassElement(), null, "classElement", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Author(), ecorePackage.getEString(), "author", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_UpdatedBy(), ecorePackage.getEString(), "updatedBy", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Created(), ecorePackage.getEDate(), "created", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModel_Updated(), ecorePackage.getEDate(), "updated", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescription_Text(), ecorePackage.getEString(), "text", "", 0, 1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(discussionEClass, Discussion.class, "Discussion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiscussion_Author(), ecorePackage.getEString(), "author", "", 0, 1, Discussion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionProviderEClass, DescriptionProvider.class, "DescriptionProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionProvider_Description(), this.getDescription(), null, "description", null, 0, 1, DescriptionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(discussionProviderEClass, DiscussionProvider.class, "DiscussionProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiscussionProvider_Discussions(), this.getDiscussion(), null, "discussions", null, 0, -1, DiscussionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceLinkEClass, SourceLink.class, "SourceLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceLink_Path(), ecorePackage.getEString(), "path", "", 0, 1, SourceLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceLinkProviderEClass, SourceLinkProvider.class, "SourceLinkProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceLinkProvider_Link(), this.getSourceLink(), null, "link", null, 0, 1, SourceLinkProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgram_Name(), ecorePackage.getEString(), "name", null, 0, 1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Packages(), this.getPackageElement(), null, "packages", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageElementEClass, PackageElement.class, "PackageElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageElement_Interfaces(), this.getInterfaceElement(), null, "interfaces", null, 0, -1, PackageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageElement_Classes(), this.getClassElement(), null, "classes", null, 0, -1, PackageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceElementEClass, InterfaceElement.class, "InterfaceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, InterfaceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceElement_Access(), this.getAccessType(), "access", null, 0, 1, InterfaceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceElement_ExtendsElements(), this.getTypeReference(), null, "extendsElements", null, 0, -1, InterfaceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceElement_Methods(), this.getMethod(), null, "methods", null, 0, -1, InterfaceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classElementEClass, ClassElement.class, "ClassElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassElement_Access(), this.getAccessType(), "access", null, 0, 1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassElement_Annotation(), ecorePackage.getEString(), "annotation", null, 0, 1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassElement_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassElement_Dynamic(), ecorePackage.getEBoolean(), "dynamic", null, 0, 1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassElement_ImplementsElements(), this.getTypeReference(), null, "implementsElements", null, 0, -1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassElement_ExtendsElements(), this.getTypeReference(), null, "extendsElements", null, 0, -1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassElement_Methods(), this.getMethod(), null, "methods", null, 0, -1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassElement_Members(), this.getClassMember(), null, "members", null, 0, -1, ClassElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classMemberEClass, ClassMember.class, "ClassMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassMember_Note(), ecorePackage.getEString(), "note", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassMember_Access(), this.getAccessType(), "access", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassMember_Annotation(), ecorePackage.getEString(), "annotation", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassMember_Declaration(), this.getDeclarationType(), "declaration", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassMember_Type(), this.getTypeReference(), null, "type", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassMember_Name(), ecorePackage.getEString(), "name", null, 0, 1, ClassMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeReferenceEClass, TypeReference.class, "TypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeReference_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethod_Note(), ecorePackage.getEString(), "note", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_Annotation(), ecorePackage.getEString(), "annotation", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Signature(), this.getMethodSignature(), null, "signature", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_ThrowsElements(), this.getTypeReference(), null, "throwsElements", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Arguments(), this.getMethodArgument(), null, "arguments", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodSignatureEClass, MethodSignature.class, "MethodSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethodSignature_Name(), ecorePackage.getEString(), "name", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodSignature_Access(), this.getAccessType(), "access", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodSignature_Type(), this.getMethodType(), "type", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodSignature_Declaration(), this.getDeclarationType(), "declaration", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodSignature_Varargs(), ecorePackage.getEBoolean(), "varargs", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodSignature_ReturnType(), this.getTypeReference(), null, "returnType", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodArgumentEClass, MethodArgument.class, "MethodArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodArgument_Type(), this.getTypeReference(), null, "type", null, 0, 1, MethodArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodArgument_Name(), ecorePackage.getEString(), "name", null, 0, 1, MethodArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceEClass, Sequence.class, "Sequence", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceProviderEClass, SequenceProvider.class, "SequenceProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceProvider_Sequences(), this.getSequence(), null, "sequences", null, 0, -1, SequenceProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Declaration(), this.getDeclarationType(), "declaration", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Type(), this.getTypeReference(), null, "type", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Note(), ecorePackage.getEString(), "note", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Value(), ecorePackage.getEString(), "value", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sequenceGroupEClass, SequenceGroup.class, "SequenceGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequenceGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, SequenceGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterationEClass, Iteration.class, "Iteration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIteration_Type(), this.getIterationType(), "type", "", 0, 1, Iteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodCallEClass, MethodCall.class, "MethodCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethodCall_Name(), ecorePackage.getEString(), "name", null, 0, 1, MethodCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodCall_Arguments(), ecorePackage.getEString(), "arguments", null, 0, 1, MethodCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodReturnEClass, MethodReturn.class, "MethodReturn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethodReturn_Note(), ecorePackage.getEString(), "note", null, 0, 1, MethodReturn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchSequenceEClass, SwitchSequence.class, "SwitchSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwitchSequence_Note(), ecorePackage.getEString(), "note", null, 0, 1, SwitchSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchSequence_Cases(), this.getSequenceGroup(), null, "cases", null, 0, -1, SwitchSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchSequence_DefaultCase(), this.getSequenceGroup(), null, "defaultCase", null, 0, 1, SwitchSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlSequenceEClass, ControlSequence.class, "ControlSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlSequence_IfGroup(), this.getSequenceGroup(), null, "ifGroup", null, 0, 1, ControlSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getControlSequence_ElseifGroups(), this.getSequenceGroup(), null, "elseifGroups", null, 0, -1, ControlSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getControlSequence_ElseGroup(), this.getSequenceGroup(), null, "elseGroup", null, 0, 1, ControlSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trySequenceEClass, TrySequence.class, "TrySequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrySequence_TryGroup(), this.getSequenceGroup(), null, "tryGroup", null, 0, 1, TrySequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrySequence_CatchGroups(), this.getSequenceGroup(), null, "catchGroups", null, 0, -1, TrySequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrySequence_FinallyGroup(), this.getSequenceGroup(), null, "finallyGroup", null, 0, 1, TrySequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recursionEClass, Recursion.class, "Recursion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(printEClass, Print.class, "Print", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(readEClass, Read.class, "Read", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(writeEClass, Write.class, "Write", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recoverEClass, Recover.class, "Recover", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storeEClass, Store.class, "Store", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(calculateStoreEClass, CalculateStore.class, "CalculateStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(showEClass, Show.class, "Show", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(promptEClass, Prompt.class, "Prompt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(accessTypeEEnum, AccessType.class, "AccessType");
		addEEnumLiteral(accessTypeEEnum, AccessType.PUBLIC);
		addEEnumLiteral(accessTypeEEnum, AccessType.INTERNAL);
		addEEnumLiteral(accessTypeEEnum, AccessType.PROTECTED);
		addEEnumLiteral(accessTypeEEnum, AccessType.PRIVATE);

		initEEnum(declarationTypeEEnum, DeclarationType.class, "DeclarationType");
		addEEnumLiteral(declarationTypeEEnum, DeclarationType.DEFAULT);
		addEEnumLiteral(declarationTypeEEnum, DeclarationType.FINAL);
		addEEnumLiteral(declarationTypeEEnum, DeclarationType.STATIC);
		addEEnumLiteral(declarationTypeEEnum, DeclarationType.OVERRIDDEN);
		addEEnumLiteral(declarationTypeEEnum, DeclarationType.CONSTANT);

		initEEnum(methodTypeEEnum, MethodType.class, "MethodType");
		addEEnumLiteral(methodTypeEEnum, MethodType.STANDARD);
		addEEnumLiteral(methodTypeEEnum, MethodType.GETTER);
		addEEnumLiteral(methodTypeEEnum, MethodType.SETTER);

		initEEnum(iterationTypeEEnum, IterationType.class, "IterationType");
		addEEnumLiteral(iterationTypeEEnum, IterationType.FOR);
		addEEnumLiteral(iterationTypeEEnum, IterationType.FOR_EACH);
		addEEnumLiteral(iterationTypeEEnum, IterationType.WHILE);
		addEEnumLiteral(iterationTypeEEnum, IterationType.DO_WHILE);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
