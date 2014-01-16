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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gnstudio.apdt.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/gnstudio/apdt/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "apdt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.gnstudio.apdt.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ModelImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.DescriptionImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 1;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.DiscussionImpl <em>Discussion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.DiscussionImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDiscussion()
	 * @generated
	 */
	int DISCUSSION = 2;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.DescriptionProvider <em>Description Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.DescriptionProvider
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDescriptionProvider()
	 * @generated
	 */
	int DESCRIPTION_PROVIDER = 3;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.DiscussionProvider <em>Discussion Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.DiscussionProvider
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDiscussionProvider()
	 * @generated
	 */
	int DISCUSSION_PROVIDER = 4;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ProgramImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 7;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.PackageElementImpl <em>Package Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.PackageElementImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getPackageElement()
	 * @generated
	 */
	int PACKAGE_ELEMENT = 8;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.TypeReferenceImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getTypeReference()
	 * @generated
	 */
	int TYPE_REFERENCE = 12;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl <em>Interface Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.InterfaceElementImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getInterfaceElement()
	 * @generated
	 */
	int INTERFACE_ELEMENT = 9;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ClassElementImpl <em>Class Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ClassElementImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getClassElement()
	 * @generated
	 */
	int CLASS_ELEMENT = 10;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ClassMemberImpl <em>Class Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ClassMemberImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getClassMember()
	 * @generated
	 */
	int CLASS_MEMBER = 11;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.MethodImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 13;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.MethodSignatureImpl <em>Method Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.MethodSignatureImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodSignature()
	 * @generated
	 */
	int METHOD_SIGNATURE = 14;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.MethodArgumentImpl <em>Method Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.MethodArgumentImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodArgument()
	 * @generated
	 */
	int METHOD_ARGUMENT = 15;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.Sequence <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.Sequence
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 16;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.SequenceProvider <em>Sequence Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.SequenceProvider
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSequenceProvider()
	 * @generated
	 */
	int SEQUENCE_PROVIDER = 17;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_PROVIDER__SEQUENCES = 0;

	/**
	 * The number of structural features of the '<em>Sequence Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SEQUENCES = SEQUENCE_PROVIDER__SEQUENCES;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__VERSION = SEQUENCE_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__RELEASE = SEQUENCE_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ENCODING = SEQUENCE_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DESCRIPTION = SEQUENCE_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Programs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PROGRAMS = SEQUENCE_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PACKAGES = SEQUENCE_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Interface Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__INTERFACE_ELEMENT = SEQUENCE_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Class Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CLASS_ELEMENT = SEQUENCE_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__AUTHOR = SEQUENCE_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Updated By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__UPDATED_BY = SEQUENCE_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CREATED = SEQUENCE_PROVIDER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__UPDATED = SEQUENCE_PROVIDER_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = SEQUENCE_PROVIDER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCUSSION__TEXT = DESCRIPTION__TEXT;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCUSSION__AUTHOR = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Discussion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCUSSION_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_PROVIDER__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Description Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Discussions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCUSSION_PROVIDER__DISCUSSIONS = 0;

	/**
	 * The number of structural features of the '<em>Discussion Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCUSSION_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.SourceLinkImpl <em>Source Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.SourceLinkImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSourceLink()
	 * @generated
	 */
	int SOURCE_LINK = 5;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LINK__PATH = 0;

	/**
	 * The number of structural features of the '<em>Source Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LINK_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.SourceLinkProvider <em>Source Link Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.SourceLinkProvider
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSourceLinkProvider()
	 * @generated
	 */
	int SOURCE_LINK_PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LINK_PROVIDER__LINK = 0;

	/**
	 * The number of structural features of the '<em>Source Link Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LINK_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Discussions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__DISCUSSIONS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__LINK = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__PACKAGES = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Discussions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__DISCUSSIONS = DISCUSSION_PROVIDER__DISCUSSIONS;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__LINK = DISCUSSION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__NAME = DISCUSSION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__INTERFACES = DISCUSSION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT__CLASSES = DISCUSSION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Package Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ELEMENT_FEATURE_COUNT = DISCUSSION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Discussions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__DISCUSSIONS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__LINK = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__ACCESS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extends Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__EXTENDS_ELEMENTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT__METHODS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Interface Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_ELEMENT_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Discussions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__DISCUSSIONS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__LINK = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__ACCESS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__ANNOTATION = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__FINAL = DESCRIPTION_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Dynamic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__DYNAMIC = DESCRIPTION_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Implements Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__IMPLEMENTS_ELEMENTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Extends Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__EXTENDS_ELEMENTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__METHODS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT__MEMBERS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Class Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_ELEMENT_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__NOTE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__ACCESS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__ANNOTATION = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__DECLARATION = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__TYPE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Class Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Discussions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DISCUSSIONS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__SEQUENCES = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NOTE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ANNOTATION = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__SIGNATURE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Throws Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__THROWS_ELEMENTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ARGUMENTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE__ACCESS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE__DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>Varargs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE__VARARGS = 4;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE__RETURN_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Method Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_SIGNATURE_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ARGUMENT__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ARGUMENT__TYPE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ARGUMENT__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ARGUMENT_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.VariableImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 18;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DECLARATION = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NOTE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.CommentImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 19;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.SequenceGroupImpl <em>Sequence Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.SequenceGroupImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSequenceGroup()
	 * @generated
	 */
	int SEQUENCE_GROUP = 20;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_GROUP__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_GROUP__SEQUENCES = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_GROUP__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sequence Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_GROUP_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.IterationImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 21;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__DESCRIPTION = SEQUENCE_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__SEQUENCES = SEQUENCE_GROUP__SEQUENCES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__NAME = SEQUENCE_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__TYPE = SEQUENCE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = SEQUENCE_GROUP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.MethodCallImpl <em>Method Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.MethodCallImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodCall()
	 * @generated
	 */
	int METHOD_CALL = 22;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__NAME = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__ARGUMENTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.MethodReturnImpl <em>Method Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.MethodReturnImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodReturn()
	 * @generated
	 */
	int METHOD_RETURN = 23;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RETURN__NOTE = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Method Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RETURN_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.SwitchSequenceImpl <em>Switch Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.SwitchSequenceImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSwitchSequence()
	 * @generated
	 */
	int SWITCH_SEQUENCE = 24;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_SEQUENCE__DESCRIPTION = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_SEQUENCE__NOTE = SEQUENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_SEQUENCE__CASES = SEQUENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_SEQUENCE__DEFAULT_CASE = SEQUENCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Switch Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_SEQUENCE_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ControlSequenceImpl <em>Control Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ControlSequenceImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getControlSequence()
	 * @generated
	 */
	int CONTROL_SEQUENCE = 25;

	/**
	 * The feature id for the '<em><b>If Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SEQUENCE__IF_GROUP = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elseif Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SEQUENCE__ELSEIF_GROUPS = SEQUENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SEQUENCE__ELSE_GROUP = SEQUENCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Control Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SEQUENCE_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.RecursionImpl <em>Recursion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.RecursionImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getRecursion()
	 * @generated
	 */
	int RECURSION = 27;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.PrintImpl <em>Print</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.PrintImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getPrint()
	 * @generated
	 */
	int PRINT = 28;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ReadImpl <em>Read</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ReadImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getRead()
	 * @generated
	 */
	int READ = 29;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.WriteImpl <em>Write</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.WriteImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getWrite()
	 * @generated
	 */
	int WRITE = 30;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.RecoverImpl <em>Recover</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.RecoverImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getRecover()
	 * @generated
	 */
	int RECOVER = 31;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.StoreImpl <em>Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.StoreImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getStore()
	 * @generated
	 */
	int STORE = 32;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.CalculateStoreImpl <em>Calculate Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.CalculateStoreImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getCalculateStore()
	 * @generated
	 */
	int CALCULATE_STORE = 33;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.TrySequenceImpl <em>Try Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.TrySequenceImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getTrySequence()
	 * @generated
	 */
	int TRY_SEQUENCE = 26;

	/**
	 * The feature id for the '<em><b>Try Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_SEQUENCE__TRY_GROUP = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Catch Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_SEQUENCE__CATCH_GROUPS = SEQUENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Finally Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_SEQUENCE__FINALLY_GROUP = SEQUENCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Try Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_SEQUENCE_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Recursion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Print</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Read</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Write</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Recover</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATE_STORE__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Calculate Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALCULATE_STORE_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.ShowImpl <em>Show</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.ShowImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getShow()
	 * @generated
	 */
	int SHOW = 34;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Show</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.impl.PromptImpl <em>Prompt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.impl.PromptImpl
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getPrompt()
	 * @generated
	 */
	int PROMPT = 35;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT__TEXT = DESCRIPTION__TEXT;

	/**
	 * The number of structural features of the '<em>Prompt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_FEATURE_COUNT = DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.AccessType <em>Access Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.AccessType
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getAccessType()
	 * @generated
	 */
	int ACCESS_TYPE = 36;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.DeclarationType <em>Declaration Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.DeclarationType
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDeclarationType()
	 * @generated
	 */
	int DECLARATION_TYPE = 37;

	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.MethodType <em>Method Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.MethodType
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodType()
	 * @generated
	 */
	int METHOD_TYPE = 38;


	/**
	 * The meta object id for the '{@link org.gnstudio.apdt.model.IterationType <em>Iteration Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gnstudio.apdt.model.IterationType
	 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getIterationType()
	 * @generated
	 */
	int ITERATION_TYPE = 39;


	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.gnstudio.apdt.model.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.gnstudio.apdt.model.Model#getVersion()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see org.gnstudio.apdt.model.Model#getRelease()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Release();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.gnstudio.apdt.model.Model#getDescription()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.Model#getPrograms <em>Programs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Programs</em>'.
	 * @see org.gnstudio.apdt.model.Model#getPrograms()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Programs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.Model#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.gnstudio.apdt.model.Model#getPackages()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Packages();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.Model#getInterfaceElement <em>Interface Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interface Element</em>'.
	 * @see org.gnstudio.apdt.model.Model#getInterfaceElement()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_InterfaceElement();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.Model#getClassElement <em>Class Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Class Element</em>'.
	 * @see org.gnstudio.apdt.model.Model#getClassElement()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_ClassElement();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.gnstudio.apdt.model.Model#getAuthor()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getUpdatedBy <em>Updated By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated By</em>'.
	 * @see org.gnstudio.apdt.model.Model#getUpdatedBy()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_UpdatedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.gnstudio.apdt.model.Model#getCreated()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Created();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getUpdated <em>Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated</em>'.
	 * @see org.gnstudio.apdt.model.Model#getUpdated()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Updated();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Model#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see org.gnstudio.apdt.model.Model#getEncoding()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Encoding();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.gnstudio.apdt.model.Description
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Description#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.gnstudio.apdt.model.Description#getText()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Text();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Discussion <em>Discussion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discussion</em>'.
	 * @see org.gnstudio.apdt.model.Discussion
	 * @generated
	 */
	EClass getDiscussion();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Discussion#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.gnstudio.apdt.model.Discussion#getAuthor()
	 * @see #getDiscussion()
	 * @generated
	 */
	EAttribute getDiscussion_Author();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.gnstudio.apdt.model.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Program#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.Program#getName()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.Program#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see org.gnstudio.apdt.model.Program#getPackages()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Packages();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.PackageElement <em>Package Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Element</em>'.
	 * @see org.gnstudio.apdt.model.PackageElement
	 * @generated
	 */
	EClass getPackageElement();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.PackageElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.PackageElement#getName()
	 * @see #getPackageElement()
	 * @generated
	 */
	EAttribute getPackageElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.PackageElement#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interfaces</em>'.
	 * @see org.gnstudio.apdt.model.PackageElement#getInterfaces()
	 * @see #getPackageElement()
	 * @generated
	 */
	EReference getPackageElement_Interfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.PackageElement#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see org.gnstudio.apdt.model.PackageElement#getClasses()
	 * @see #getPackageElement()
	 * @generated
	 */
	EReference getPackageElement_Classes();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.TypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Reference</em>'.
	 * @see org.gnstudio.apdt.model.TypeReference
	 * @generated
	 */
	EClass getTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.TypeReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.TypeReference#getName()
	 * @see #getTypeReference()
	 * @generated
	 */
	EAttribute getTypeReference_Name();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.InterfaceElement <em>Interface Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Element</em>'.
	 * @see org.gnstudio.apdt.model.InterfaceElement
	 * @generated
	 */
	EClass getInterfaceElement();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.InterfaceElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.InterfaceElement#getName()
	 * @see #getInterfaceElement()
	 * @generated
	 */
	EAttribute getInterfaceElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.InterfaceElement#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see org.gnstudio.apdt.model.InterfaceElement#getAccess()
	 * @see #getInterfaceElement()
	 * @generated
	 */
	EAttribute getInterfaceElement_Access();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.InterfaceElement#getExtendsElements <em>Extends Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends Elements</em>'.
	 * @see org.gnstudio.apdt.model.InterfaceElement#getExtendsElements()
	 * @see #getInterfaceElement()
	 * @generated
	 */
	EReference getInterfaceElement_ExtendsElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.InterfaceElement#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.gnstudio.apdt.model.InterfaceElement#getMethods()
	 * @see #getInterfaceElement()
	 * @generated
	 */
	EReference getInterfaceElement_Methods();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.ClassElement <em>Class Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Element</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement
	 * @generated
	 */
	EClass getClassElement();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getName()
	 * @see #getClassElement()
	 * @generated
	 */
	EAttribute getClassElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassElement#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getAccess()
	 * @see #getClassElement()
	 * @generated
	 */
	EAttribute getClassElement_Access();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassElement#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Annotation</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getAnnotation()
	 * @see #getClassElement()
	 * @generated
	 */
	EAttribute getClassElement_Annotation();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassElement#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#isFinal()
	 * @see #getClassElement()
	 * @generated
	 */
	EAttribute getClassElement_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassElement#isDynamic <em>Dynamic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#isDynamic()
	 * @see #getClassElement()
	 * @generated
	 */
	EAttribute getClassElement_Dynamic();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.ClassElement#getImplementsElements <em>Implements Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements Elements</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getImplementsElements()
	 * @see #getClassElement()
	 * @generated
	 */
	EReference getClassElement_ImplementsElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.ClassElement#getExtendsElements <em>Extends Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extends Elements</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getExtendsElements()
	 * @see #getClassElement()
	 * @generated
	 */
	EReference getClassElement_ExtendsElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.ClassElement#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getMethods()
	 * @see #getClassElement()
	 * @generated
	 */
	EReference getClassElement_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.ClassElement#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.gnstudio.apdt.model.ClassElement#getMembers()
	 * @see #getClassElement()
	 * @generated
	 */
	EReference getClassElement_Members();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.ClassMember <em>Class Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Member</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember
	 * @generated
	 */
	EClass getClassMember();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassMember#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember#getNote()
	 * @see #getClassMember()
	 * @generated
	 */
	EAttribute getClassMember_Note();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassMember#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember#getName()
	 * @see #getClassMember()
	 * @generated
	 */
	EAttribute getClassMember_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassMember#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember#getAccess()
	 * @see #getClassMember()
	 * @generated
	 */
	EAttribute getClassMember_Access();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.ClassMember#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember#getType()
	 * @see #getClassMember()
	 * @generated
	 */
	EReference getClassMember_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassMember#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Annotation</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember#getAnnotation()
	 * @see #getClassMember()
	 * @generated
	 */
	EAttribute getClassMember_Annotation();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.ClassMember#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see org.gnstudio.apdt.model.ClassMember#getDeclaration()
	 * @see #getClassMember()
	 * @generated
	 */
	EAttribute getClassMember_Declaration();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see org.gnstudio.apdt.model.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Method#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.gnstudio.apdt.model.Method#getNote()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Note();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Method#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Annotation</em>'.
	 * @see org.gnstudio.apdt.model.Method#getAnnotation()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Annotation();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.Method#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Signature</em>'.
	 * @see org.gnstudio.apdt.model.Method#getSignature()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Signature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.Method#getThrowsElements <em>Throws Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Throws Elements</em>'.
	 * @see org.gnstudio.apdt.model.Method#getThrowsElements()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_ThrowsElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.Method#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.gnstudio.apdt.model.Method#getArguments()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Arguments();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.MethodSignature <em>Method Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Signature</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature
	 * @generated
	 */
	EClass getMethodSignature();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodSignature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature#getName()
	 * @see #getMethodSignature()
	 * @generated
	 */
	EAttribute getMethodSignature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodSignature#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature#getAccess()
	 * @see #getMethodSignature()
	 * @generated
	 */
	EAttribute getMethodSignature_Access();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodSignature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature#getType()
	 * @see #getMethodSignature()
	 * @generated
	 */
	EAttribute getMethodSignature_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodSignature#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature#getDeclaration()
	 * @see #getMethodSignature()
	 * @generated
	 */
	EAttribute getMethodSignature_Declaration();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodSignature#isVarargs <em>Varargs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Varargs</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature#isVarargs()
	 * @see #getMethodSignature()
	 * @generated
	 */
	EAttribute getMethodSignature_Varargs();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.MethodSignature#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.gnstudio.apdt.model.MethodSignature#getReturnType()
	 * @see #getMethodSignature()
	 * @generated
	 */
	EReference getMethodSignature_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.MethodArgument <em>Method Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Argument</em>'.
	 * @see org.gnstudio.apdt.model.MethodArgument
	 * @generated
	 */
	EClass getMethodArgument();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.MethodArgument#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.gnstudio.apdt.model.MethodArgument#getType()
	 * @see #getMethodArgument()
	 * @generated
	 */
	EReference getMethodArgument_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodArgument#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.MethodArgument#getName()
	 * @see #getMethodArgument()
	 * @generated
	 */
	EAttribute getMethodArgument_Name();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.gnstudio.apdt.model.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.SequenceProvider <em>Sequence Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Provider</em>'.
	 * @see org.gnstudio.apdt.model.SequenceProvider
	 * @generated
	 */
	EClass getSequenceProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.SequenceProvider#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see org.gnstudio.apdt.model.SequenceProvider#getSequences()
	 * @see #getSequenceProvider()
	 * @generated
	 */
	EReference getSequenceProvider_Sequences();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.gnstudio.apdt.model.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Variable#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaration</em>'.
	 * @see org.gnstudio.apdt.model.Variable#getDeclaration()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Declaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.gnstudio.apdt.model.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Variable#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.gnstudio.apdt.model.Variable#getNote()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Note();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.gnstudio.apdt.model.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Value();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.gnstudio.apdt.model.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.SequenceGroup <em>Sequence Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Group</em>'.
	 * @see org.gnstudio.apdt.model.SequenceGroup
	 * @generated
	 */
	EClass getSequenceGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.SequenceGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.SequenceGroup#getName()
	 * @see #getSequenceGroup()
	 * @generated
	 */
	EAttribute getSequenceGroup_Name();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see org.gnstudio.apdt.model.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.Iteration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.gnstudio.apdt.model.Iteration#getType()
	 * @see #getIteration()
	 * @generated
	 */
	EAttribute getIteration_Type();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.MethodCall <em>Method Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Call</em>'.
	 * @see org.gnstudio.apdt.model.MethodCall
	 * @generated
	 */
	EClass getMethodCall();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodCall#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gnstudio.apdt.model.MethodCall#getName()
	 * @see #getMethodCall()
	 * @generated
	 */
	EAttribute getMethodCall_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arguments</em>'.
	 * @see org.gnstudio.apdt.model.MethodCall#getArguments()
	 * @see #getMethodCall()
	 * @generated
	 */
	EAttribute getMethodCall_Arguments();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.MethodReturn <em>Method Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Return</em>'.
	 * @see org.gnstudio.apdt.model.MethodReturn
	 * @generated
	 */
	EClass getMethodReturn();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.MethodReturn#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.gnstudio.apdt.model.MethodReturn#getNote()
	 * @see #getMethodReturn()
	 * @generated
	 */
	EAttribute getMethodReturn_Note();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.SwitchSequence <em>Switch Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Sequence</em>'.
	 * @see org.gnstudio.apdt.model.SwitchSequence
	 * @generated
	 */
	EClass getSwitchSequence();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.SwitchSequence#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Note</em>'.
	 * @see org.gnstudio.apdt.model.SwitchSequence#getNote()
	 * @see #getSwitchSequence()
	 * @generated
	 */
	EAttribute getSwitchSequence_Note();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.SwitchSequence#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.gnstudio.apdt.model.SwitchSequence#getCases()
	 * @see #getSwitchSequence()
	 * @generated
	 */
	EReference getSwitchSequence_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.SwitchSequence#getDefaultCase <em>Default Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Case</em>'.
	 * @see org.gnstudio.apdt.model.SwitchSequence#getDefaultCase()
	 * @see #getSwitchSequence()
	 * @generated
	 */
	EReference getSwitchSequence_DefaultCase();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.ControlSequence <em>Control Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Sequence</em>'.
	 * @see org.gnstudio.apdt.model.ControlSequence
	 * @generated
	 */
	EClass getControlSequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.ControlSequence#getIfGroup <em>If Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If Group</em>'.
	 * @see org.gnstudio.apdt.model.ControlSequence#getIfGroup()
	 * @see #getControlSequence()
	 * @generated
	 */
	EReference getControlSequence_IfGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.ControlSequence#getElseifGroups <em>Elseif Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elseif Groups</em>'.
	 * @see org.gnstudio.apdt.model.ControlSequence#getElseifGroups()
	 * @see #getControlSequence()
	 * @generated
	 */
	EReference getControlSequence_ElseifGroups();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.ControlSequence#getElseGroup <em>Else Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Group</em>'.
	 * @see org.gnstudio.apdt.model.ControlSequence#getElseGroup()
	 * @see #getControlSequence()
	 * @generated
	 */
	EReference getControlSequence_ElseGroup();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Recursion <em>Recursion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recursion</em>'.
	 * @see org.gnstudio.apdt.model.Recursion
	 * @generated
	 */
	EClass getRecursion();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print</em>'.
	 * @see org.gnstudio.apdt.model.Print
	 * @generated
	 */
	EClass getPrint();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Read <em>Read</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read</em>'.
	 * @see org.gnstudio.apdt.model.Read
	 * @generated
	 */
	EClass getRead();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Write <em>Write</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write</em>'.
	 * @see org.gnstudio.apdt.model.Write
	 * @generated
	 */
	EClass getWrite();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Recover <em>Recover</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recover</em>'.
	 * @see org.gnstudio.apdt.model.Recover
	 * @generated
	 */
	EClass getRecover();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Store <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Store</em>'.
	 * @see org.gnstudio.apdt.model.Store
	 * @generated
	 */
	EClass getStore();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.CalculateStore <em>Calculate Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Calculate Store</em>'.
	 * @see org.gnstudio.apdt.model.CalculateStore
	 * @generated
	 */
	EClass getCalculateStore();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Show <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show</em>'.
	 * @see org.gnstudio.apdt.model.Show
	 * @generated
	 */
	EClass getShow();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.Prompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prompt</em>'.
	 * @see org.gnstudio.apdt.model.Prompt
	 * @generated
	 */
	EClass getPrompt();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.TrySequence <em>Try Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Sequence</em>'.
	 * @see org.gnstudio.apdt.model.TrySequence
	 * @generated
	 */
	EClass getTrySequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.TrySequence#getTryGroup <em>Try Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Try Group</em>'.
	 * @see org.gnstudio.apdt.model.TrySequence#getTryGroup()
	 * @see #getTrySequence()
	 * @generated
	 */
	EReference getTrySequence_TryGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.TrySequence#getCatchGroups <em>Catch Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catch Groups</em>'.
	 * @see org.gnstudio.apdt.model.TrySequence#getCatchGroups()
	 * @see #getTrySequence()
	 * @generated
	 */
	EReference getTrySequence_CatchGroups();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.TrySequence#getFinallyGroup <em>Finally Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally Group</em>'.
	 * @see org.gnstudio.apdt.model.TrySequence#getFinallyGroup()
	 * @see #getTrySequence()
	 * @generated
	 */
	EReference getTrySequence_FinallyGroup();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.DescriptionProvider <em>Description Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Provider</em>'.
	 * @see org.gnstudio.apdt.model.DescriptionProvider
	 * @generated
	 */
	EClass getDescriptionProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.DescriptionProvider#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.gnstudio.apdt.model.DescriptionProvider#getDescription()
	 * @see #getDescriptionProvider()
	 * @generated
	 */
	EReference getDescriptionProvider_Description();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.DiscussionProvider <em>Discussion Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discussion Provider</em>'.
	 * @see org.gnstudio.apdt.model.DiscussionProvider
	 * @generated
	 */
	EClass getDiscussionProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gnstudio.apdt.model.DiscussionProvider#getDiscussions <em>Discussions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Discussions</em>'.
	 * @see org.gnstudio.apdt.model.DiscussionProvider#getDiscussions()
	 * @see #getDiscussionProvider()
	 * @generated
	 */
	EReference getDiscussionProvider_Discussions();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.SourceLink <em>Source Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Link</em>'.
	 * @see org.gnstudio.apdt.model.SourceLink
	 * @generated
	 */
	EClass getSourceLink();

	/**
	 * Returns the meta object for the attribute '{@link org.gnstudio.apdt.model.SourceLink#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.gnstudio.apdt.model.SourceLink#getPath()
	 * @see #getSourceLink()
	 * @generated
	 */
	EAttribute getSourceLink_Path();

	/**
	 * Returns the meta object for class '{@link org.gnstudio.apdt.model.SourceLinkProvider <em>Source Link Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Link Provider</em>'.
	 * @see org.gnstudio.apdt.model.SourceLinkProvider
	 * @generated
	 */
	EClass getSourceLinkProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.gnstudio.apdt.model.SourceLinkProvider#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see org.gnstudio.apdt.model.SourceLinkProvider#getLink()
	 * @see #getSourceLinkProvider()
	 * @generated
	 */
	EReference getSourceLinkProvider_Link();

	/**
	 * Returns the meta object for enum '{@link org.gnstudio.apdt.model.AccessType <em>Access Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Type</em>'.
	 * @see org.gnstudio.apdt.model.AccessType
	 * @generated
	 */
	EEnum getAccessType();

	/**
	 * Returns the meta object for enum '{@link org.gnstudio.apdt.model.DeclarationType <em>Declaration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Declaration Type</em>'.
	 * @see org.gnstudio.apdt.model.DeclarationType
	 * @generated
	 */
	EEnum getDeclarationType();

	/**
	 * Returns the meta object for enum '{@link org.gnstudio.apdt.model.MethodType <em>Method Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Method Type</em>'.
	 * @see org.gnstudio.apdt.model.MethodType
	 * @generated
	 */
	EEnum getMethodType();

	/**
	 * Returns the meta object for enum '{@link org.gnstudio.apdt.model.IterationType <em>Iteration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Iteration Type</em>'.
	 * @see org.gnstudio.apdt.model.IterationType
	 * @generated
	 */
	EEnum getIterationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ModelImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__VERSION = eINSTANCE.getModel_Version();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__RELEASE = eINSTANCE.getModel_Release();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__DESCRIPTION = eINSTANCE.getModel_Description();

		/**
		 * The meta object literal for the '<em><b>Programs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PROGRAMS = eINSTANCE.getModel_Programs();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PACKAGES = eINSTANCE.getModel_Packages();

		/**
		 * The meta object literal for the '<em><b>Interface Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__INTERFACE_ELEMENT = eINSTANCE.getModel_InterfaceElement();

		/**
		 * The meta object literal for the '<em><b>Class Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__CLASS_ELEMENT = eINSTANCE.getModel_ClassElement();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__AUTHOR = eINSTANCE.getModel_Author();

		/**
		 * The meta object literal for the '<em><b>Updated By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__UPDATED_BY = eINSTANCE.getModel_UpdatedBy();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__CREATED = eINSTANCE.getModel_Created();

		/**
		 * The meta object literal for the '<em><b>Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__UPDATED = eINSTANCE.getModel_Updated();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__ENCODING = eINSTANCE.getModel_Encoding();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.DescriptionImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__TEXT = eINSTANCE.getDescription_Text();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.DiscussionImpl <em>Discussion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.DiscussionImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDiscussion()
		 * @generated
		 */
		EClass DISCUSSION = eINSTANCE.getDiscussion();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCUSSION__AUTHOR = eINSTANCE.getDiscussion_Author();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ProgramImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__NAME = eINSTANCE.getProgram_Name();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__PACKAGES = eINSTANCE.getProgram_Packages();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.PackageElementImpl <em>Package Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.PackageElementImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getPackageElement()
		 * @generated
		 */
		EClass PACKAGE_ELEMENT = eINSTANCE.getPackageElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_ELEMENT__NAME = eINSTANCE.getPackageElement_Name();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_ELEMENT__INTERFACES = eINSTANCE.getPackageElement_Interfaces();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_ELEMENT__CLASSES = eINSTANCE.getPackageElement_Classes();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.TypeReferenceImpl <em>Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.TypeReferenceImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getTypeReference()
		 * @generated
		 */
		EClass TYPE_REFERENCE = eINSTANCE.getTypeReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REFERENCE__NAME = eINSTANCE.getTypeReference_Name();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.InterfaceElementImpl <em>Interface Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.InterfaceElementImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getInterfaceElement()
		 * @generated
		 */
		EClass INTERFACE_ELEMENT = eINSTANCE.getInterfaceElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_ELEMENT__NAME = eINSTANCE.getInterfaceElement_Name();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_ELEMENT__ACCESS = eINSTANCE.getInterfaceElement_Access();

		/**
		 * The meta object literal for the '<em><b>Extends Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_ELEMENT__EXTENDS_ELEMENTS = eINSTANCE.getInterfaceElement_ExtendsElements();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_ELEMENT__METHODS = eINSTANCE.getInterfaceElement_Methods();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ClassElementImpl <em>Class Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ClassElementImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getClassElement()
		 * @generated
		 */
		EClass CLASS_ELEMENT = eINSTANCE.getClassElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_ELEMENT__NAME = eINSTANCE.getClassElement_Name();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_ELEMENT__ACCESS = eINSTANCE.getClassElement_Access();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_ELEMENT__ANNOTATION = eINSTANCE.getClassElement_Annotation();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_ELEMENT__FINAL = eINSTANCE.getClassElement_Final();

		/**
		 * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_ELEMENT__DYNAMIC = eINSTANCE.getClassElement_Dynamic();

		/**
		 * The meta object literal for the '<em><b>Implements Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ELEMENT__IMPLEMENTS_ELEMENTS = eINSTANCE.getClassElement_ImplementsElements();

		/**
		 * The meta object literal for the '<em><b>Extends Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ELEMENT__EXTENDS_ELEMENTS = eINSTANCE.getClassElement_ExtendsElements();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ELEMENT__METHODS = eINSTANCE.getClassElement_Methods();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_ELEMENT__MEMBERS = eINSTANCE.getClassElement_Members();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ClassMemberImpl <em>Class Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ClassMemberImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getClassMember()
		 * @generated
		 */
		EClass CLASS_MEMBER = eINSTANCE.getClassMember();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MEMBER__NOTE = eINSTANCE.getClassMember_Note();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MEMBER__NAME = eINSTANCE.getClassMember_Name();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MEMBER__ACCESS = eINSTANCE.getClassMember_Access();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MEMBER__TYPE = eINSTANCE.getClassMember_Type();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MEMBER__ANNOTATION = eINSTANCE.getClassMember_Annotation();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MEMBER__DECLARATION = eINSTANCE.getClassMember_Declaration();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.MethodImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__NOTE = eINSTANCE.getMethod_Note();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__ANNOTATION = eINSTANCE.getMethod_Annotation();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__SIGNATURE = eINSTANCE.getMethod_Signature();

		/**
		 * The meta object literal for the '<em><b>Throws Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__THROWS_ELEMENTS = eINSTANCE.getMethod_ThrowsElements();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__ARGUMENTS = eINSTANCE.getMethod_Arguments();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.MethodSignatureImpl <em>Method Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.MethodSignatureImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodSignature()
		 * @generated
		 */
		EClass METHOD_SIGNATURE = eINSTANCE.getMethodSignature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_SIGNATURE__NAME = eINSTANCE.getMethodSignature_Name();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_SIGNATURE__ACCESS = eINSTANCE.getMethodSignature_Access();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_SIGNATURE__TYPE = eINSTANCE.getMethodSignature_Type();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_SIGNATURE__DECLARATION = eINSTANCE.getMethodSignature_Declaration();

		/**
		 * The meta object literal for the '<em><b>Varargs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_SIGNATURE__VARARGS = eINSTANCE.getMethodSignature_Varargs();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_SIGNATURE__RETURN_TYPE = eINSTANCE.getMethodSignature_ReturnType();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.MethodArgumentImpl <em>Method Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.MethodArgumentImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodArgument()
		 * @generated
		 */
		EClass METHOD_ARGUMENT = eINSTANCE.getMethodArgument();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_ARGUMENT__TYPE = eINSTANCE.getMethodArgument_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_ARGUMENT__NAME = eINSTANCE.getMethodArgument_Name();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.Sequence <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.Sequence
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.SequenceProvider <em>Sequence Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.SequenceProvider
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSequenceProvider()
		 * @generated
		 */
		EClass SEQUENCE_PROVIDER = eINSTANCE.getSequenceProvider();

		/**
		 * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_PROVIDER__SEQUENCES = eINSTANCE.getSequenceProvider_Sequences();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.VariableImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__DECLARATION = eINSTANCE.getVariable_Declaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NOTE = eINSTANCE.getVariable_Note();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.CommentImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.SequenceGroupImpl <em>Sequence Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.SequenceGroupImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSequenceGroup()
		 * @generated
		 */
		EClass SEQUENCE_GROUP = eINSTANCE.getSequenceGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_GROUP__NAME = eINSTANCE.getSequenceGroup_Name();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.IterationImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION__TYPE = eINSTANCE.getIteration_Type();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.MethodCallImpl <em>Method Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.MethodCallImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodCall()
		 * @generated
		 */
		EClass METHOD_CALL = eINSTANCE.getMethodCall();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_CALL__NAME = eINSTANCE.getMethodCall_Name();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_CALL__ARGUMENTS = eINSTANCE.getMethodCall_Arguments();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.MethodReturnImpl <em>Method Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.MethodReturnImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodReturn()
		 * @generated
		 */
		EClass METHOD_RETURN = eINSTANCE.getMethodReturn();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_RETURN__NOTE = eINSTANCE.getMethodReturn_Note();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.SwitchSequenceImpl <em>Switch Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.SwitchSequenceImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSwitchSequence()
		 * @generated
		 */
		EClass SWITCH_SEQUENCE = eINSTANCE.getSwitchSequence();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH_SEQUENCE__NOTE = eINSTANCE.getSwitchSequence_Note();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_SEQUENCE__CASES = eINSTANCE.getSwitchSequence_Cases();

		/**
		 * The meta object literal for the '<em><b>Default Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_SEQUENCE__DEFAULT_CASE = eINSTANCE.getSwitchSequence_DefaultCase();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ControlSequenceImpl <em>Control Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ControlSequenceImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getControlSequence()
		 * @generated
		 */
		EClass CONTROL_SEQUENCE = eINSTANCE.getControlSequence();

		/**
		 * The meta object literal for the '<em><b>If Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_SEQUENCE__IF_GROUP = eINSTANCE.getControlSequence_IfGroup();

		/**
		 * The meta object literal for the '<em><b>Elseif Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_SEQUENCE__ELSEIF_GROUPS = eINSTANCE.getControlSequence_ElseifGroups();

		/**
		 * The meta object literal for the '<em><b>Else Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_SEQUENCE__ELSE_GROUP = eINSTANCE.getControlSequence_ElseGroup();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.RecursionImpl <em>Recursion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.RecursionImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getRecursion()
		 * @generated
		 */
		EClass RECURSION = eINSTANCE.getRecursion();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.PrintImpl <em>Print</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.PrintImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getPrint()
		 * @generated
		 */
		EClass PRINT = eINSTANCE.getPrint();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ReadImpl <em>Read</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ReadImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getRead()
		 * @generated
		 */
		EClass READ = eINSTANCE.getRead();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.WriteImpl <em>Write</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.WriteImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getWrite()
		 * @generated
		 */
		EClass WRITE = eINSTANCE.getWrite();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.RecoverImpl <em>Recover</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.RecoverImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getRecover()
		 * @generated
		 */
		EClass RECOVER = eINSTANCE.getRecover();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.StoreImpl <em>Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.StoreImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getStore()
		 * @generated
		 */
		EClass STORE = eINSTANCE.getStore();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.CalculateStoreImpl <em>Calculate Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.CalculateStoreImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getCalculateStore()
		 * @generated
		 */
		EClass CALCULATE_STORE = eINSTANCE.getCalculateStore();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.ShowImpl <em>Show</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.ShowImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getShow()
		 * @generated
		 */
		EClass SHOW = eINSTANCE.getShow();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.PromptImpl <em>Prompt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.PromptImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getPrompt()
		 * @generated
		 */
		EClass PROMPT = eINSTANCE.getPrompt();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.TrySequenceImpl <em>Try Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.TrySequenceImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getTrySequence()
		 * @generated
		 */
		EClass TRY_SEQUENCE = eINSTANCE.getTrySequence();

		/**
		 * The meta object literal for the '<em><b>Try Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_SEQUENCE__TRY_GROUP = eINSTANCE.getTrySequence_TryGroup();

		/**
		 * The meta object literal for the '<em><b>Catch Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_SEQUENCE__CATCH_GROUPS = eINSTANCE.getTrySequence_CatchGroups();

		/**
		 * The meta object literal for the '<em><b>Finally Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_SEQUENCE__FINALLY_GROUP = eINSTANCE.getTrySequence_FinallyGroup();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.DescriptionProvider <em>Description Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.DescriptionProvider
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDescriptionProvider()
		 * @generated
		 */
		EClass DESCRIPTION_PROVIDER = eINSTANCE.getDescriptionProvider();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_PROVIDER__DESCRIPTION = eINSTANCE.getDescriptionProvider_Description();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.DiscussionProvider <em>Discussion Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.DiscussionProvider
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDiscussionProvider()
		 * @generated
		 */
		EClass DISCUSSION_PROVIDER = eINSTANCE.getDiscussionProvider();

		/**
		 * The meta object literal for the '<em><b>Discussions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISCUSSION_PROVIDER__DISCUSSIONS = eINSTANCE.getDiscussionProvider_Discussions();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.impl.SourceLinkImpl <em>Source Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.impl.SourceLinkImpl
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSourceLink()
		 * @generated
		 */
		EClass SOURCE_LINK = eINSTANCE.getSourceLink();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_LINK__PATH = eINSTANCE.getSourceLink_Path();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.SourceLinkProvider <em>Source Link Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.SourceLinkProvider
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getSourceLinkProvider()
		 * @generated
		 */
		EClass SOURCE_LINK_PROVIDER = eINSTANCE.getSourceLinkProvider();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_LINK_PROVIDER__LINK = eINSTANCE.getSourceLinkProvider_Link();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.AccessType <em>Access Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.AccessType
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getAccessType()
		 * @generated
		 */
		EEnum ACCESS_TYPE = eINSTANCE.getAccessType();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.DeclarationType <em>Declaration Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.DeclarationType
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getDeclarationType()
		 * @generated
		 */
		EEnum DECLARATION_TYPE = eINSTANCE.getDeclarationType();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.MethodType <em>Method Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.MethodType
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getMethodType()
		 * @generated
		 */
		EEnum METHOD_TYPE = eINSTANCE.getMethodType();

		/**
		 * The meta object literal for the '{@link org.gnstudio.apdt.model.IterationType <em>Iteration Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gnstudio.apdt.model.IterationType
		 * @see org.gnstudio.apdt.model.impl.ModelPackageImpl#getIterationType()
		 * @generated
		 */
		EEnum ITERATION_TYPE = eINSTANCE.getIterationType();

	}

} //ModelPackage
