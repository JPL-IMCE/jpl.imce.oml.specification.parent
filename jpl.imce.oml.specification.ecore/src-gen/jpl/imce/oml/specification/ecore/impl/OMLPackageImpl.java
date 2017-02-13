/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package jpl.imce.oml.specification.ecore.impl;

import java.util.Map;

import jpl.imce.oml.specification.ecore.Annotation;
import jpl.imce.oml.specification.ecore.AnnotationEntry;
import jpl.imce.oml.specification.ecore.AnnotationProperty;
import jpl.imce.oml.specification.ecore.AnnotationSubjectPropertyValue;
import jpl.imce.oml.specification.ecore.AnonymousConceptTaxonomyAxiom;
import jpl.imce.oml.specification.ecore.Aspect;
import jpl.imce.oml.specification.ecore.AspectSpecializationAxiom;
import jpl.imce.oml.specification.ecore.Axiom;
import jpl.imce.oml.specification.ecore.BinaryScalarRestriction;
import jpl.imce.oml.specification.ecore.Bundle;
import jpl.imce.oml.specification.ecore.BundledTerminologyAxiom;
import jpl.imce.oml.specification.ecore.Concept;
import jpl.imce.oml.specification.ecore.ConceptDesignationTerminologyAxiom;
import jpl.imce.oml.specification.ecore.ConceptInstance;
import jpl.imce.oml.specification.ecore.ConceptSpecializationAxiom;
import jpl.imce.oml.specification.ecore.ConceptTreeDisjunction;
import jpl.imce.oml.specification.ecore.ConceptualEntity;
import jpl.imce.oml.specification.ecore.ConceptualEntitySingletonInstance;
import jpl.imce.oml.specification.ecore.Context;
import jpl.imce.oml.specification.ecore.DataRange;
import jpl.imce.oml.specification.ecore.DataRelationship;
import jpl.imce.oml.specification.ecore.DataRelationshipDomain;
import jpl.imce.oml.specification.ecore.DataRelationshipFromEntity;
import jpl.imce.oml.specification.ecore.DataRelationshipFromStructure;
import jpl.imce.oml.specification.ecore.DataRelationshipRange;
import jpl.imce.oml.specification.ecore.DataRelationshipToScalar;
import jpl.imce.oml.specification.ecore.DataRelationshipToStructure;
import jpl.imce.oml.specification.ecore.DataStructureTuple;
import jpl.imce.oml.specification.ecore.Datatype;
import jpl.imce.oml.specification.ecore.DescriptionBox;
import jpl.imce.oml.specification.ecore.DescriptionBoxExtendsClosedWorldDefinitions;
import jpl.imce.oml.specification.ecore.DescriptionBoxRefinement;
import jpl.imce.oml.specification.ecore.DescriptionBoxRelationship;
import jpl.imce.oml.specification.ecore.DescriptionKind;
import jpl.imce.oml.specification.ecore.DirectedBinaryRelationshipKind;
import jpl.imce.oml.specification.ecore.DisjointUnionOfConceptsAxiom;
import jpl.imce.oml.specification.ecore.Entity;
import jpl.imce.oml.specification.ecore.EntityExistentialRestrictionAxiom;
import jpl.imce.oml.specification.ecore.EntityRelationship;
import jpl.imce.oml.specification.ecore.EntityRestrictionAxiom;
import jpl.imce.oml.specification.ecore.EntityScalarDataProperty;
import jpl.imce.oml.specification.ecore.EntityScalarDataPropertyExistentialRestrictionAxiom;
import jpl.imce.oml.specification.ecore.EntityScalarDataPropertyParticularRestrictionAxiom;
import jpl.imce.oml.specification.ecore.EntityScalarDataPropertyRestrictionAxiom;
import jpl.imce.oml.specification.ecore.EntityScalarDataPropertyUniversalRestrictionAxiom;
import jpl.imce.oml.specification.ecore.EntityStructuredDataProperty;
import jpl.imce.oml.specification.ecore.EntityUniversalRestrictionAxiom;
import jpl.imce.oml.specification.ecore.IRIScalarRestriction;
import jpl.imce.oml.specification.ecore.NumericScalarRestriction;
import jpl.imce.oml.specification.ecore.OMLFactory;
import jpl.imce.oml.specification.ecore.OMLPackage;
import jpl.imce.oml.specification.ecore.PlainLiteralScalarRestriction;
import jpl.imce.oml.specification.ecore.ReifiedRelationship;
import jpl.imce.oml.specification.ecore.ReifiedRelationshipInstance;
import jpl.imce.oml.specification.ecore.ReifiedRelationshipInstanceDomain;
import jpl.imce.oml.specification.ecore.ReifiedRelationshipInstanceRange;
import jpl.imce.oml.specification.ecore.ReifiedRelationshipSpecializationAxiom;
import jpl.imce.oml.specification.ecore.Resource;
import jpl.imce.oml.specification.ecore.RestrictedDataRange;
import jpl.imce.oml.specification.ecore.RootConceptTaxonomyAxiom;
import jpl.imce.oml.specification.ecore.Scalar;
import jpl.imce.oml.specification.ecore.ScalarDataProperty;
import jpl.imce.oml.specification.ecore.ScalarDataPropertyValue;
import jpl.imce.oml.specification.ecore.ScalarOneOfLiteralAxiom;
import jpl.imce.oml.specification.ecore.ScalarOneOfRestriction;
import jpl.imce.oml.specification.ecore.SingletonInstance;
import jpl.imce.oml.specification.ecore.SpecializationAxiom;
import jpl.imce.oml.specification.ecore.SpecificDisjointConceptAxiom;
import jpl.imce.oml.specification.ecore.StringScalarRestriction;
import jpl.imce.oml.specification.ecore.Structure;
import jpl.imce.oml.specification.ecore.StructuredDataProperty;
import jpl.imce.oml.specification.ecore.StructuredDataPropertyValue;
import jpl.imce.oml.specification.ecore.SynonymScalarRestriction;
import jpl.imce.oml.specification.ecore.Term;
import jpl.imce.oml.specification.ecore.TermAxiom;
import jpl.imce.oml.specification.ecore.TerminologyAxiom;
import jpl.imce.oml.specification.ecore.TerminologyBox;
import jpl.imce.oml.specification.ecore.TerminologyBoxAxiom;
import jpl.imce.oml.specification.ecore.TerminologyBoxStatement;
import jpl.imce.oml.specification.ecore.TerminologyBundleAxiom;
import jpl.imce.oml.specification.ecore.TerminologyBundleStatement;
import jpl.imce.oml.specification.ecore.TerminologyExtensionAxiom;
import jpl.imce.oml.specification.ecore.TerminologyExtent;
import jpl.imce.oml.specification.ecore.TerminologyGraph;
import jpl.imce.oml.specification.ecore.TerminologyGraphKind;
import jpl.imce.oml.specification.ecore.TerminologyInstanceAssertion;
import jpl.imce.oml.specification.ecore.TerminologyNestingAxiom;
import jpl.imce.oml.specification.ecore.TerminologyThing;
import jpl.imce.oml.specification.ecore.TimeScalarRestriction;
import jpl.imce.oml.specification.ecore.UnaryTermKind;
import jpl.imce.oml.specification.ecore.UnreifiedRelationship;
import jpl.imce.oml.specification.ecore.UnreifiedRelationshipInstanceTuple;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMLPackageImpl extends EPackageImpl implements OMLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyThingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationPropertyTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationSubjectTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationSubjectPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyExtentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBoxStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBundleStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryTermKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directedBinaryRelationshipKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptualEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass datatypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipFromEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipFromStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipToScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataRelationshipToStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityStructuredDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBoxAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyBundleAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptTreeDisjunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disjointUnionOfConceptsAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificDisjointConceptAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anonymousConceptTaxonomyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootConceptTaxonomyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundledTerminologyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptDesignationTerminologyAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyExtensionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyNestingAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityExistentialRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityUniversalRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aspectSpecializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptSpecializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipSpecializationAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyExistentialRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyUniversalRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityScalarDataPropertyParticularRestrictionAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restrictedDataRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iriScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plainLiteralScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synonymScalarRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarOneOfRestrictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarOneOfLiteralAxiomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxExtendsClosedWorldDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionBoxRefinementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminologyInstanceAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singletonInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarDataPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredDataPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStructureTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptualEntitySingletonInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInstanceDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reifiedRelationshipInstanceRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unreifiedRelationshipInstanceTupleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum terminologyGraphKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum descriptionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType localNameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lexicalValueEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lexicalNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lexicalTimeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType patternEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uuidEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType langRangeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType abbrevIRIEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType namespacePrefixEDataType = null;

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
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OMLPackageImpl() {
		super(eNS_URI, OMLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OMLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OMLPackage init() {
		if (isInited) return (OMLPackage)EPackage.Registry.INSTANCE.getEPackage(OMLPackage.eNS_URI);

		// Obtain or create and register package
		OMLPackageImpl theOMLPackage = (OMLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OMLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OMLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOMLPackage.createPackageContents();

		// Initialize created meta-data
		theOMLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOMLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OMLPackage.eNS_URI, theOMLPackage);
		return theOMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResource__Iri() {
		return resourceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getResource__Name() {
		return resourceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyThing() {
		return terminologyThingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminologyThing_Uuid() {
		return (EAttribute)terminologyThingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyThing__CalculateUUID() {
		return terminologyThingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationProperty() {
		return annotationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationProperty_Iri() {
		return (EAttribute)annotationPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationProperty_AbbrevIRI() {
		return (EAttribute)annotationPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAnnotationProperty__Uuid() {
		return annotationPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationPropertyTable() {
		return annotationPropertyTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationPropertyTable_Key() {
		return (EReference)annotationPropertyTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationPropertyTable_Value() {
		return (EReference)annotationPropertyTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationEntry() {
		return annotationEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationEntry_Context() {
		return (EReference)annotationEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationEntry_Subject() {
		return (EReference)annotationEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationEntry_Value() {
		return (EAttribute)annotationEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationSubjectTable() {
		return annotationSubjectTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationSubjectTable_Key() {
		return (EReference)annotationSubjectTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationSubjectTable_Value() {
		return (EReference)annotationSubjectTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationSubjectPropertyValue() {
		return annotationSubjectPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationSubjectPropertyValue_Property() {
		return (EReference)annotationSubjectPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationSubjectPropertyValue_Value() {
		return (EAttribute)annotationSubjectPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Context() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Property() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_Subject() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_Value() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyExtent() {
		return terminologyExtentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyExtent_AnnotationProperties() {
		return (EReference)terminologyExtentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyExtent_TerminologyGraphs() {
		return (EReference)terminologyExtentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyExtent_Bundles() {
		return (EReference)terminologyExtentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyExtent_Descriptions() {
		return (EReference)terminologyExtentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContext_Iri() {
		return (EAttribute)contextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_Annotations() {
		return (EReference)contextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__Extent() {
		return contextEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__CalculateUUID() {
		return contextEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__Iri() {
		return contextEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__NsPrefix() {
		return contextEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__Name() {
		return contextEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__AnnotationsBySubject() {
		return contextEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__AnnotationsByProperty() {
		return contextEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContext__WithAnnotations__EMap() {
		return contextEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBox() {
		return terminologyBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminologyBox_Kind() {
		return (EAttribute)terminologyBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBox_TerminologyBoxAxioms() {
		return (EReference)terminologyBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBox_BoxStatements() {
		return (EReference)terminologyBoxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__WithBoxStatements__EList() {
		return terminologyBoxEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Entities() {
		return terminologyBoxEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Aspects() {
		return terminologyBoxEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Concepts() {
		return terminologyBoxEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__ReifiedRelationships() {
		return terminologyBoxEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__UnreifiedRelationships() {
		return terminologyBoxEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__DataRelationships() {
		return terminologyBoxEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__EntityScalarDataProperties() {
		return terminologyBoxEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Dataranges() {
		return terminologyBoxEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Scalars() {
		return terminologyBoxEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Structures() {
		return terminologyBoxEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__TermAxioms() {
		return terminologyBoxEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyBox__Everything() {
		return terminologyBoxEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundle() {
		return bundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundle_BundleExtent() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundle_BundleStatements() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundle_TerminologyBundleAxioms() {
		return (EReference)bundleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__Extent() {
		return bundleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__WithAnnotations__EMap() {
		return bundleEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__AnnotationsByProperty() {
		return bundleEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__WithBundleStatements__EList() {
		return bundleEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__WithBoxStatements__EList() {
		return bundleEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundle__Everything() {
		return bundleEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyGraph() {
		return terminologyGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyGraph_GraphExtent() {
		return (EReference)terminologyGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyGraph__Extent() {
		return terminologyGraphEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyGraph__WithAnnotations__EMap() {
		return terminologyGraphEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyGraph__AnnotationsByProperty() {
		return terminologyGraphEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyGraph__WithBoxStatements__EList() {
		return terminologyGraphEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBoxStatement() {
		return terminologyBoxStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBoxStatement_Tbox() {
		return (EReference)terminologyBoxStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBundleStatement() {
		return terminologyBundleStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBundleStatement_Bundle() {
		return (EReference)terminologyBundleStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerm_Name() {
		return (EAttribute)termEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__CalculateUUID() {
		return termEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__Iri() {
		return termEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerm__Name() {
		return termEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryTermKind() {
		return unaryTermKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectedBinaryRelationshipKind() {
		return directedBinaryRelationshipKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDirectedBinaryRelationshipKind__RelationshipSubject() {
		return directedBinaryRelationshipKindEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDirectedBinaryRelationshipKind__RelationRange() {
		return directedBinaryRelationshipKindEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptualEntity() {
		return conceptualEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConceptualEntity_IsAbstract() {
		return (EAttribute)conceptualEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAspect() {
		return aspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcept() {
		return conceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityRelationship() {
		return entityRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRelationship_Source() {
		return (EReference)entityRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRelationship_Target() {
		return (EReference)entityRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsFunctional() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsInverseFunctional() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsEssential() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsInverseEssential() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsSymmetric() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsAsymmetric() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsReflexive() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsIrreflexive() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityRelationship_IsTransitive() {
		return (EAttribute)entityRelationshipEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityRelationship__RelationDomain() {
		return entityRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityRelationship__RelationRange() {
		return entityRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationship() {
		return reifiedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReifiedRelationship_UnreifiedPropertyName() {
		return (EAttribute)reifiedRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReifiedRelationship_UnreifiedInversePropertyName() {
		return (EAttribute)reifiedRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnreifiedRelationship() {
		return unreifiedRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatatype() {
		return datatypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRange() {
		return dataRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalar() {
		return scalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationship() {
		return dataRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__Source() {
		return dataRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__RelationDomain() {
		return dataRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__Target() {
		return dataRelationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataRelationship__RelationRange() {
		return dataRelationshipEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipDomain() {
		return dataRelationshipDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipFromEntity() {
		return dataRelationshipFromEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipFromEntity_Domain() {
		return (EReference)dataRelationshipFromEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataRelationshipFromEntity_IsIdentityCriteria() {
		return (EAttribute)dataRelationshipFromEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipFromStructure() {
		return dataRelationshipFromStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipFromStructure_Domain() {
		return (EReference)dataRelationshipFromStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipRange() {
		return dataRelationshipRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipToScalar() {
		return dataRelationshipToScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipToScalar_Range() {
		return (EReference)dataRelationshipToScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataRelationshipToStructure() {
		return dataRelationshipToStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataRelationshipToStructure_Range() {
		return (EReference)dataRelationshipToStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityStructuredDataProperty() {
		return entityStructuredDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataProperty__Source() {
		return entityStructuredDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityStructuredDataProperty__Target() {
		return entityStructuredDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataProperty() {
		return entityScalarDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataProperty__Source() {
		return entityScalarDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntityScalarDataProperty__Target() {
		return entityScalarDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredDataProperty() {
		return structuredDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataProperty__Source() {
		return structuredDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getStructuredDataProperty__Target() {
		return structuredDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarDataProperty() {
		return scalarDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataProperty__Source() {
		return scalarDataPropertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScalarDataProperty__Target() {
		return scalarDataPropertyEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAxiom() {
		return axiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyAxiom() {
		return terminologyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyAxiom__Source() {
		return terminologyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyAxiom__Target() {
		return terminologyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBoxAxiom() {
		return terminologyBoxAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBoxAxiom_Tbox() {
		return (EReference)terminologyBoxAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyBundleAxiom() {
		return terminologyBundleAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyBundleAxiom_TerminologyBundle() {
		return (EReference)terminologyBundleAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptTreeDisjunction() {
		return conceptTreeDisjunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisjointUnionOfConceptsAxiom() {
		return disjointUnionOfConceptsAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent() {
		return (EReference)disjointUnionOfConceptsAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificDisjointConceptAxiom() {
		return specificDisjointConceptAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificDisjointConceptAxiom_DisjointLeaf() {
		return (EReference)specificDisjointConceptAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnonymousConceptTaxonomyAxiom() {
		return anonymousConceptTaxonomyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootConceptTaxonomyAxiom() {
		return rootConceptTaxonomyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootConceptTaxonomyAxiom_Root() {
		return (EReference)rootConceptTaxonomyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBundledTerminologyAxiom() {
		return bundledTerminologyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBundledTerminologyAxiom_BundledTerminology() {
		return (EReference)bundledTerminologyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundledTerminologyAxiom__Source() {
		return bundledTerminologyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBundledTerminologyAxiom__Target() {
		return bundledTerminologyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptDesignationTerminologyAxiom() {
		return conceptDesignationTerminologyAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptDesignationTerminologyAxiom_DesignatedTerminology() {
		return (EReference)conceptDesignationTerminologyAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptDesignationTerminologyAxiom_DesignatedConcept() {
		return (EReference)conceptDesignationTerminologyAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__Source() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptDesignationTerminologyAxiom__Target() {
		return conceptDesignationTerminologyAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyExtensionAxiom() {
		return terminologyExtensionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyExtensionAxiom_ExtendedTerminology() {
		return (EReference)terminologyExtensionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__CalculateUUID() {
		return terminologyExtensionAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__ExtendingTerminology() {
		return terminologyExtensionAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__Source() {
		return terminologyExtensionAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyExtensionAxiom__Target() {
		return terminologyExtensionAxiomEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyNestingAxiom() {
		return terminologyNestingAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyNestingAxiom_NestingTerminology() {
		return (EReference)terminologyNestingAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTerminologyNestingAxiom_NestingContext() {
		return (EReference)terminologyNestingAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__NestedTerminology() {
		return terminologyNestingAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__Source() {
		return terminologyNestingAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyNestingAxiom__Target() {
		return terminologyNestingAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTermAxiom() {
		return termAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityRestrictionAxiom() {
		return entityRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRestrictionAxiom_RestrictedRelation() {
		return (EReference)entityRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRestrictionAxiom_RestrictedRange() {
		return (EReference)entityRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityRestrictionAxiom_RestrictedDomain() {
		return (EReference)entityRestrictionAxiomEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityExistentialRestrictionAxiom() {
		return entityExistentialRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityUniversalRestrictionAxiom() {
		return entityUniversalRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecializationAxiom() {
		return specializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSpecializationAxiom__Child() {
		return specializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSpecializationAxiom__Parent() {
		return specializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAspectSpecializationAxiom() {
		return aspectSpecializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAspectSpecializationAxiom_SubEntity() {
		return (EReference)aspectSpecializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAspectSpecializationAxiom_SuperAspect() {
		return (EReference)aspectSpecializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectSpecializationAxiom__CalculateUUID() {
		return aspectSpecializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectSpecializationAxiom__Child() {
		return aspectSpecializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAspectSpecializationAxiom__Parent() {
		return aspectSpecializationAxiomEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptSpecializationAxiom() {
		return conceptSpecializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptSpecializationAxiom_SubConcept() {
		return (EReference)conceptSpecializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptSpecializationAxiom_SuperConcept() {
		return (EReference)conceptSpecializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptSpecializationAxiom__Child() {
		return conceptSpecializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptSpecializationAxiom__Parent() {
		return conceptSpecializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipSpecializationAxiom() {
		return reifiedRelationshipSpecializationAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipSpecializationAxiom_SubRelationship() {
		return (EReference)reifiedRelationshipSpecializationAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipSpecializationAxiom_SuperRelationship() {
		return (EReference)reifiedRelationshipSpecializationAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSpecializationAxiom__Child() {
		return reifiedRelationshipSpecializationAxiomEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipSpecializationAxiom__Parent() {
		return reifiedRelationshipSpecializationAxiomEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyRestrictionAxiom() {
		return entityScalarDataPropertyRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity() {
		return (EReference)entityScalarDataPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty() {
		return (EReference)entityScalarDataPropertyRestrictionAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyExistentialRestrictionAxiom() {
		return entityScalarDataPropertyExistentialRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction() {
		return (EReference)entityScalarDataPropertyExistentialRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyUniversalRestrictionAxiom() {
		return entityScalarDataPropertyUniversalRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction() {
		return (EReference)entityScalarDataPropertyUniversalRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityScalarDataPropertyParticularRestrictionAxiom() {
		return entityScalarDataPropertyParticularRestrictionAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue() {
		return (EAttribute)entityScalarDataPropertyParticularRestrictionAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestrictedDataRange() {
		return restrictedDataRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRestrictedDataRange_RestrictedRange() {
		return (EReference)restrictedDataRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryScalarRestriction() {
		return binaryScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryScalarRestriction_Length() {
		return (EAttribute)binaryScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryScalarRestriction_MinLength() {
		return (EAttribute)binaryScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryScalarRestriction_MaxLength() {
		return (EAttribute)binaryScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIRIScalarRestriction() {
		return iriScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_Length() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_MinLength() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_MaxLength() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIRIScalarRestriction_Pattern() {
		return (EAttribute)iriScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericScalarRestriction() {
		return numericScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MinInclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MaxInclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MinExclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericScalarRestriction_MaxExclusive() {
		return (EAttribute)numericScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlainLiteralScalarRestriction() {
		return plainLiteralScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_Length() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_MinLength() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_MaxLength() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_Pattern() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlainLiteralScalarRestriction_LangRange() {
		return (EAttribute)plainLiteralScalarRestrictionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringScalarRestriction() {
		return stringScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_Length() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_MinLength() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_MaxLength() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringScalarRestriction_Pattern() {
		return (EAttribute)stringScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeScalarRestriction() {
		return timeScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MinInclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MaxInclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MinExclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeScalarRestriction_MaxExclusive() {
		return (EAttribute)timeScalarRestrictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynonymScalarRestriction() {
		return synonymScalarRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarOneOfRestriction() {
		return scalarOneOfRestrictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarOneOfLiteralAxiom() {
		return scalarOneOfLiteralAxiomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarOneOfLiteralAxiom_Axiom() {
		return (EReference)scalarOneOfLiteralAxiomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarOneOfLiteralAxiom_Value() {
		return (EAttribute)scalarOneOfLiteralAxiomEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBox() {
		return descriptionBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionBox_Kind() {
		return (EAttribute)descriptionBoxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_TerminologyExtent() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ClosedWorldDefinitions() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_DescriptionBoxRefinements() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ConceptInstances() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ReifiedRelationshipInstances() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ReifiedRelationshipInstanceDomains() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_ReifiedRelationshipInstanceRanges() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBox_UnreifiedRelationshipInstanceTuples() {
		return (EReference)descriptionBoxEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBoxRelationship() {
		return descriptionBoxRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRelationship__DescriptionDomain() {
		return descriptionBoxRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRelationship__ContextTarget() {
		return descriptionBoxRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBoxExtendsClosedWorldDefinitions() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox() {
		return (EReference)descriptionBoxExtendsClosedWorldDefinitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions() {
		return (EReference)descriptionBoxExtendsClosedWorldDefinitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxExtendsClosedWorldDefinitions__ContextTarget() {
		return descriptionBoxExtendsClosedWorldDefinitionsEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionBoxRefinement() {
		return descriptionBoxRefinementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxRefinement_RefiningDescriptionBox() {
		return (EReference)descriptionBoxRefinementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionBoxRefinement_RefinedDescriptionBox() {
		return (EReference)descriptionBoxRefinementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRefinement__DescriptionDomain() {
		return descriptionBoxRefinementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDescriptionBoxRefinement__ContextTarget() {
		return descriptionBoxRefinementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminologyInstanceAssertion() {
		return terminologyInstanceAssertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTerminologyInstanceAssertion_Name() {
		return (EAttribute)terminologyInstanceAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyInstanceAssertion__DescriptionBox() {
		return terminologyInstanceAssertionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyInstanceAssertion__CalculateUUID() {
		return terminologyInstanceAssertionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyInstanceAssertion__Iri() {
		return terminologyInstanceAssertionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTerminologyInstanceAssertion__Name() {
		return terminologyInstanceAssertionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingletonInstance() {
		return singletonInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstance_ScalarDataPropertyValues() {
		return (EReference)singletonInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingletonInstance_StructuredDataPropertyValues() {
		return (EReference)singletonInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarDataPropertyValue() {
		return scalarDataPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarDataPropertyValue_SingletonInstance() {
		return (EReference)scalarDataPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarDataPropertyValue_ScalarDataProperty() {
		return (EReference)scalarDataPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarDataPropertyValue_ScalarPropertyValue() {
		return (EAttribute)scalarDataPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuredDataPropertyValue() {
		return structuredDataPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredDataPropertyValue_SingletonInstance() {
		return (EReference)structuredDataPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredDataPropertyValue_StructuredDataProperty() {
		return (EReference)structuredDataPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuredDataPropertyValue_StructuredPropertyTuple() {
		return (EReference)structuredDataPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataStructureTuple() {
		return dataStructureTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataStructureTuple_StructuredDataPropertyValue() {
		return (EReference)dataStructureTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataStructureTuple_DataStructureType() {
		return (EReference)dataStructureTupleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptualEntitySingletonInstance() {
		return conceptualEntitySingletonInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__IdentifyingScalarValues() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptualEntitySingletonInstance__IdentifyingStructuredTuples() {
		return conceptualEntitySingletonInstanceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConceptInstance() {
		return conceptInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptInstance_DescriptionBox() {
		return (EReference)conceptInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConceptInstance_SingletonConceptClassifier() {
		return (EReference)conceptInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConceptInstance__ConceptualEntitySingletonClassifier() {
		return conceptInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInstance() {
		return reifiedRelationshipInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstance_DescriptionBox() {
		return (EReference)reifiedRelationshipInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstance_SingletonReifiedRelationshipClassifier() {
		return (EReference)reifiedRelationshipInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier() {
		return reifiedRelationshipInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInstanceDomain() {
		return reifiedRelationshipInstanceDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceDomain_DescriptionBox() {
		return (EReference)reifiedRelationshipInstanceDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance() {
		return (EReference)reifiedRelationshipInstanceDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceDomain_Domain() {
		return (EReference)reifiedRelationshipInstanceDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReifiedRelationshipInstanceRange() {
		return reifiedRelationshipInstanceRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceRange_DescriptionBox() {
		return (EReference)reifiedRelationshipInstanceRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceRange_ReifiedRelationshipInstance() {
		return (EReference)reifiedRelationshipInstanceRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReifiedRelationshipInstanceRange_Range() {
		return (EReference)reifiedRelationshipInstanceRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnreifiedRelationshipInstanceTuple() {
		return unreifiedRelationshipInstanceTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_DescriptionBox() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_UnreifiedRelationship() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_Domain() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnreifiedRelationshipInstanceTuple_Range() {
		return (EReference)unreifiedRelationshipInstanceTupleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTerminologyGraphKind() {
		return terminologyGraphKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDescriptionKind() {
		return descriptionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIRI() {
		return iriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLocalName() {
		return localNameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLexicalValue() {
		return lexicalValueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLexicalNumber() {
		return lexicalNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLexicalTime() {
		return lexicalTimeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPattern() {
		return patternEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUUID() {
		return uuidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLangRange() {
		return langRangeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAbbrevIRI() {
		return abbrevIRIEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNamespacePrefix() {
		return namespacePrefixEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLFactory getOMLFactory() {
		return (OMLFactory)getEFactoryInstance();
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
		resourceEClass = createEClass(RESOURCE);
		createEOperation(resourceEClass, RESOURCE___IRI);
		createEOperation(resourceEClass, RESOURCE___NAME);

		terminologyThingEClass = createEClass(TERMINOLOGY_THING);
		createEAttribute(terminologyThingEClass, TERMINOLOGY_THING__UUID);
		createEOperation(terminologyThingEClass, TERMINOLOGY_THING___CALCULATE_UUID);

		annotationPropertyEClass = createEClass(ANNOTATION_PROPERTY);
		createEAttribute(annotationPropertyEClass, ANNOTATION_PROPERTY__IRI);
		createEAttribute(annotationPropertyEClass, ANNOTATION_PROPERTY__ABBREV_IRI);
		createEOperation(annotationPropertyEClass, ANNOTATION_PROPERTY___UUID);

		annotationPropertyTableEClass = createEClass(ANNOTATION_PROPERTY_TABLE);
		createEReference(annotationPropertyTableEClass, ANNOTATION_PROPERTY_TABLE__KEY);
		createEReference(annotationPropertyTableEClass, ANNOTATION_PROPERTY_TABLE__VALUE);

		annotationEntryEClass = createEClass(ANNOTATION_ENTRY);
		createEReference(annotationEntryEClass, ANNOTATION_ENTRY__CONTEXT);
		createEReference(annotationEntryEClass, ANNOTATION_ENTRY__SUBJECT);
		createEAttribute(annotationEntryEClass, ANNOTATION_ENTRY__VALUE);

		annotationSubjectTableEClass = createEClass(ANNOTATION_SUBJECT_TABLE);
		createEReference(annotationSubjectTableEClass, ANNOTATION_SUBJECT_TABLE__KEY);
		createEReference(annotationSubjectTableEClass, ANNOTATION_SUBJECT_TABLE__VALUE);

		annotationSubjectPropertyValueEClass = createEClass(ANNOTATION_SUBJECT_PROPERTY_VALUE);
		createEReference(annotationSubjectPropertyValueEClass, ANNOTATION_SUBJECT_PROPERTY_VALUE__PROPERTY);
		createEAttribute(annotationSubjectPropertyValueEClass, ANNOTATION_SUBJECT_PROPERTY_VALUE__VALUE);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__CONTEXT);
		createEReference(annotationEClass, ANNOTATION__PROPERTY);
		createEReference(annotationEClass, ANNOTATION__SUBJECT);
		createEAttribute(annotationEClass, ANNOTATION__VALUE);

		terminologyExtentEClass = createEClass(TERMINOLOGY_EXTENT);
		createEReference(terminologyExtentEClass, TERMINOLOGY_EXTENT__ANNOTATION_PROPERTIES);
		createEReference(terminologyExtentEClass, TERMINOLOGY_EXTENT__TERMINOLOGY_GRAPHS);
		createEReference(terminologyExtentEClass, TERMINOLOGY_EXTENT__BUNDLES);
		createEReference(terminologyExtentEClass, TERMINOLOGY_EXTENT__DESCRIPTIONS);

		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__IRI);
		createEReference(contextEClass, CONTEXT__ANNOTATIONS);
		createEOperation(contextEClass, CONTEXT___EXTENT);
		createEOperation(contextEClass, CONTEXT___CALCULATE_UUID);
		createEOperation(contextEClass, CONTEXT___IRI);
		createEOperation(contextEClass, CONTEXT___NS_PREFIX);
		createEOperation(contextEClass, CONTEXT___NAME);
		createEOperation(contextEClass, CONTEXT___ANNOTATIONS_BY_SUBJECT);
		createEOperation(contextEClass, CONTEXT___ANNOTATIONS_BY_PROPERTY);
		createEOperation(contextEClass, CONTEXT___WITH_ANNOTATIONS__EMAP);

		terminologyBoxEClass = createEClass(TERMINOLOGY_BOX);
		createEAttribute(terminologyBoxEClass, TERMINOLOGY_BOX__KIND);
		createEReference(terminologyBoxEClass, TERMINOLOGY_BOX__TERMINOLOGY_BOX_AXIOMS);
		createEReference(terminologyBoxEClass, TERMINOLOGY_BOX__BOX_STATEMENTS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___WITH_BOX_STATEMENTS__ELIST);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___ENTITIES);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___ASPECTS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___CONCEPTS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___REIFIED_RELATIONSHIPS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___UNREIFIED_RELATIONSHIPS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___DATA_RELATIONSHIPS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___ENTITY_SCALAR_DATA_PROPERTIES);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___DATARANGES);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___SCALARS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___STRUCTURES);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___TERM_AXIOMS);
		createEOperation(terminologyBoxEClass, TERMINOLOGY_BOX___EVERYTHING);

		bundleEClass = createEClass(BUNDLE);
		createEReference(bundleEClass, BUNDLE__BUNDLE_EXTENT);
		createEReference(bundleEClass, BUNDLE__BUNDLE_STATEMENTS);
		createEReference(bundleEClass, BUNDLE__TERMINOLOGY_BUNDLE_AXIOMS);
		createEOperation(bundleEClass, BUNDLE___EXTENT);
		createEOperation(bundleEClass, BUNDLE___WITH_ANNOTATIONS__EMAP);
		createEOperation(bundleEClass, BUNDLE___ANNOTATIONS_BY_PROPERTY);
		createEOperation(bundleEClass, BUNDLE___WITH_BUNDLE_STATEMENTS__ELIST);
		createEOperation(bundleEClass, BUNDLE___WITH_BOX_STATEMENTS__ELIST);
		createEOperation(bundleEClass, BUNDLE___EVERYTHING);

		terminologyGraphEClass = createEClass(TERMINOLOGY_GRAPH);
		createEReference(terminologyGraphEClass, TERMINOLOGY_GRAPH__GRAPH_EXTENT);
		createEOperation(terminologyGraphEClass, TERMINOLOGY_GRAPH___EXTENT);
		createEOperation(terminologyGraphEClass, TERMINOLOGY_GRAPH___WITH_ANNOTATIONS__EMAP);
		createEOperation(terminologyGraphEClass, TERMINOLOGY_GRAPH___ANNOTATIONS_BY_PROPERTY);
		createEOperation(terminologyGraphEClass, TERMINOLOGY_GRAPH___WITH_BOX_STATEMENTS__ELIST);

		terminologyBoxStatementEClass = createEClass(TERMINOLOGY_BOX_STATEMENT);
		createEReference(terminologyBoxStatementEClass, TERMINOLOGY_BOX_STATEMENT__TBOX);

		terminologyBundleStatementEClass = createEClass(TERMINOLOGY_BUNDLE_STATEMENT);
		createEReference(terminologyBundleStatementEClass, TERMINOLOGY_BUNDLE_STATEMENT__BUNDLE);

		termEClass = createEClass(TERM);
		createEAttribute(termEClass, TERM__NAME);
		createEOperation(termEClass, TERM___CALCULATE_UUID);
		createEOperation(termEClass, TERM___IRI);
		createEOperation(termEClass, TERM___NAME);

		unaryTermKindEClass = createEClass(UNARY_TERM_KIND);

		directedBinaryRelationshipKindEClass = createEClass(DIRECTED_BINARY_RELATIONSHIP_KIND);
		createEOperation(directedBinaryRelationshipKindEClass, DIRECTED_BINARY_RELATIONSHIP_KIND___RELATIONSHIP_SUBJECT);
		createEOperation(directedBinaryRelationshipKindEClass, DIRECTED_BINARY_RELATIONSHIP_KIND___RELATION_RANGE);

		entityEClass = createEClass(ENTITY);

		conceptualEntityEClass = createEClass(CONCEPTUAL_ENTITY);
		createEAttribute(conceptualEntityEClass, CONCEPTUAL_ENTITY__IS_ABSTRACT);

		aspectEClass = createEClass(ASPECT);

		conceptEClass = createEClass(CONCEPT);

		entityRelationshipEClass = createEClass(ENTITY_RELATIONSHIP);
		createEReference(entityRelationshipEClass, ENTITY_RELATIONSHIP__SOURCE);
		createEReference(entityRelationshipEClass, ENTITY_RELATIONSHIP__TARGET);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_FUNCTIONAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_INVERSE_FUNCTIONAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_ESSENTIAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_INVERSE_ESSENTIAL);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_SYMMETRIC);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_ASYMMETRIC);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_REFLEXIVE);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_IRREFLEXIVE);
		createEAttribute(entityRelationshipEClass, ENTITY_RELATIONSHIP__IS_TRANSITIVE);
		createEOperation(entityRelationshipEClass, ENTITY_RELATIONSHIP___RELATION_DOMAIN);
		createEOperation(entityRelationshipEClass, ENTITY_RELATIONSHIP___RELATION_RANGE);

		reifiedRelationshipEClass = createEClass(REIFIED_RELATIONSHIP);
		createEAttribute(reifiedRelationshipEClass, REIFIED_RELATIONSHIP__UNREIFIED_PROPERTY_NAME);
		createEAttribute(reifiedRelationshipEClass, REIFIED_RELATIONSHIP__UNREIFIED_INVERSE_PROPERTY_NAME);

		unreifiedRelationshipEClass = createEClass(UNREIFIED_RELATIONSHIP);

		datatypeEClass = createEClass(DATATYPE);

		dataRangeEClass = createEClass(DATA_RANGE);

		scalarEClass = createEClass(SCALAR);

		dataRelationshipEClass = createEClass(DATA_RELATIONSHIP);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___SOURCE);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___RELATION_DOMAIN);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___TARGET);
		createEOperation(dataRelationshipEClass, DATA_RELATIONSHIP___RELATION_RANGE);

		dataRelationshipDomainEClass = createEClass(DATA_RELATIONSHIP_DOMAIN);

		dataRelationshipFromEntityEClass = createEClass(DATA_RELATIONSHIP_FROM_ENTITY);
		createEReference(dataRelationshipFromEntityEClass, DATA_RELATIONSHIP_FROM_ENTITY__DOMAIN);
		createEAttribute(dataRelationshipFromEntityEClass, DATA_RELATIONSHIP_FROM_ENTITY__IS_IDENTITY_CRITERIA);

		dataRelationshipFromStructureEClass = createEClass(DATA_RELATIONSHIP_FROM_STRUCTURE);
		createEReference(dataRelationshipFromStructureEClass, DATA_RELATIONSHIP_FROM_STRUCTURE__DOMAIN);

		dataRelationshipRangeEClass = createEClass(DATA_RELATIONSHIP_RANGE);

		dataRelationshipToScalarEClass = createEClass(DATA_RELATIONSHIP_TO_SCALAR);
		createEReference(dataRelationshipToScalarEClass, DATA_RELATIONSHIP_TO_SCALAR__RANGE);

		dataRelationshipToStructureEClass = createEClass(DATA_RELATIONSHIP_TO_STRUCTURE);
		createEReference(dataRelationshipToStructureEClass, DATA_RELATIONSHIP_TO_STRUCTURE__RANGE);

		entityStructuredDataPropertyEClass = createEClass(ENTITY_STRUCTURED_DATA_PROPERTY);
		createEOperation(entityStructuredDataPropertyEClass, ENTITY_STRUCTURED_DATA_PROPERTY___SOURCE);
		createEOperation(entityStructuredDataPropertyEClass, ENTITY_STRUCTURED_DATA_PROPERTY___TARGET);

		entityScalarDataPropertyEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY);
		createEOperation(entityScalarDataPropertyEClass, ENTITY_SCALAR_DATA_PROPERTY___SOURCE);
		createEOperation(entityScalarDataPropertyEClass, ENTITY_SCALAR_DATA_PROPERTY___TARGET);

		structuredDataPropertyEClass = createEClass(STRUCTURED_DATA_PROPERTY);
		createEOperation(structuredDataPropertyEClass, STRUCTURED_DATA_PROPERTY___SOURCE);
		createEOperation(structuredDataPropertyEClass, STRUCTURED_DATA_PROPERTY___TARGET);

		scalarDataPropertyEClass = createEClass(SCALAR_DATA_PROPERTY);
		createEOperation(scalarDataPropertyEClass, SCALAR_DATA_PROPERTY___SOURCE);
		createEOperation(scalarDataPropertyEClass, SCALAR_DATA_PROPERTY___TARGET);

		structureEClass = createEClass(STRUCTURE);

		axiomEClass = createEClass(AXIOM);

		terminologyAxiomEClass = createEClass(TERMINOLOGY_AXIOM);
		createEOperation(terminologyAxiomEClass, TERMINOLOGY_AXIOM___SOURCE);
		createEOperation(terminologyAxiomEClass, TERMINOLOGY_AXIOM___TARGET);

		terminologyBoxAxiomEClass = createEClass(TERMINOLOGY_BOX_AXIOM);
		createEReference(terminologyBoxAxiomEClass, TERMINOLOGY_BOX_AXIOM__TBOX);

		terminologyBundleAxiomEClass = createEClass(TERMINOLOGY_BUNDLE_AXIOM);
		createEReference(terminologyBundleAxiomEClass, TERMINOLOGY_BUNDLE_AXIOM__TERMINOLOGY_BUNDLE);

		conceptTreeDisjunctionEClass = createEClass(CONCEPT_TREE_DISJUNCTION);

		disjointUnionOfConceptsAxiomEClass = createEClass(DISJOINT_UNION_OF_CONCEPTS_AXIOM);
		createEReference(disjointUnionOfConceptsAxiomEClass, DISJOINT_UNION_OF_CONCEPTS_AXIOM__DISJOINT_TAXONOMY_PARENT);

		specificDisjointConceptAxiomEClass = createEClass(SPECIFIC_DISJOINT_CONCEPT_AXIOM);
		createEReference(specificDisjointConceptAxiomEClass, SPECIFIC_DISJOINT_CONCEPT_AXIOM__DISJOINT_LEAF);

		anonymousConceptTaxonomyAxiomEClass = createEClass(ANONYMOUS_CONCEPT_TAXONOMY_AXIOM);

		rootConceptTaxonomyAxiomEClass = createEClass(ROOT_CONCEPT_TAXONOMY_AXIOM);
		createEReference(rootConceptTaxonomyAxiomEClass, ROOT_CONCEPT_TAXONOMY_AXIOM__ROOT);

		bundledTerminologyAxiomEClass = createEClass(BUNDLED_TERMINOLOGY_AXIOM);
		createEReference(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM__BUNDLED_TERMINOLOGY);
		createEOperation(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM___SOURCE);
		createEOperation(bundledTerminologyAxiomEClass, BUNDLED_TERMINOLOGY_AXIOM___TARGET);

		conceptDesignationTerminologyAxiomEClass = createEClass(CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM);
		createEReference(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_TERMINOLOGY);
		createEReference(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM__DESIGNATED_CONCEPT);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___DESIGNATION_TERMINOLOGY_GRAPH);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___SOURCE);
		createEOperation(conceptDesignationTerminologyAxiomEClass, CONCEPT_DESIGNATION_TERMINOLOGY_AXIOM___TARGET);

		terminologyExtensionAxiomEClass = createEClass(TERMINOLOGY_EXTENSION_AXIOM);
		createEReference(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM__EXTENDED_TERMINOLOGY);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___CALCULATE_UUID);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___EXTENDING_TERMINOLOGY);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___SOURCE);
		createEOperation(terminologyExtensionAxiomEClass, TERMINOLOGY_EXTENSION_AXIOM___TARGET);

		terminologyNestingAxiomEClass = createEClass(TERMINOLOGY_NESTING_AXIOM);
		createEReference(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM__NESTING_TERMINOLOGY);
		createEReference(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM__NESTING_CONTEXT);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___NESTED_TERMINOLOGY);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___SOURCE);
		createEOperation(terminologyNestingAxiomEClass, TERMINOLOGY_NESTING_AXIOM___TARGET);

		termAxiomEClass = createEClass(TERM_AXIOM);

		entityRestrictionAxiomEClass = createEClass(ENTITY_RESTRICTION_AXIOM);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_RELATION);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_RANGE);
		createEReference(entityRestrictionAxiomEClass, ENTITY_RESTRICTION_AXIOM__RESTRICTED_DOMAIN);

		entityExistentialRestrictionAxiomEClass = createEClass(ENTITY_EXISTENTIAL_RESTRICTION_AXIOM);

		entityUniversalRestrictionAxiomEClass = createEClass(ENTITY_UNIVERSAL_RESTRICTION_AXIOM);

		specializationAxiomEClass = createEClass(SPECIALIZATION_AXIOM);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___CHILD);
		createEOperation(specializationAxiomEClass, SPECIALIZATION_AXIOM___PARENT);

		aspectSpecializationAxiomEClass = createEClass(ASPECT_SPECIALIZATION_AXIOM);
		createEReference(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM__SUB_ENTITY);
		createEReference(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM__SUPER_ASPECT);
		createEOperation(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM___CALCULATE_UUID);
		createEOperation(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM___CHILD);
		createEOperation(aspectSpecializationAxiomEClass, ASPECT_SPECIALIZATION_AXIOM___PARENT);

		conceptSpecializationAxiomEClass = createEClass(CONCEPT_SPECIALIZATION_AXIOM);
		createEReference(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM__SUB_CONCEPT);
		createEReference(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM__SUPER_CONCEPT);
		createEOperation(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM___CHILD);
		createEOperation(conceptSpecializationAxiomEClass, CONCEPT_SPECIALIZATION_AXIOM___PARENT);

		reifiedRelationshipSpecializationAxiomEClass = createEClass(REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM);
		createEReference(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUB_RELATIONSHIP);
		createEReference(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM__SUPER_RELATIONSHIP);
		createEOperation(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___CHILD);
		createEOperation(reifiedRelationshipSpecializationAxiomEClass, REIFIED_RELATIONSHIP_SPECIALIZATION_AXIOM___PARENT);

		entityScalarDataPropertyRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__RESTRICTED_ENTITY);
		createEReference(entityScalarDataPropertyRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_RESTRICTION_AXIOM__SCALAR_PROPERTY);

		entityScalarDataPropertyExistentialRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyExistentialRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_EXISTENTIAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION);

		entityScalarDataPropertyUniversalRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM);
		createEReference(entityScalarDataPropertyUniversalRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_UNIVERSAL_RESTRICTION_AXIOM__SCALAR_RESTRICTION);

		entityScalarDataPropertyParticularRestrictionAxiomEClass = createEClass(ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM);
		createEAttribute(entityScalarDataPropertyParticularRestrictionAxiomEClass, ENTITY_SCALAR_DATA_PROPERTY_PARTICULAR_RESTRICTION_AXIOM__LITERAL_VALUE);

		restrictedDataRangeEClass = createEClass(RESTRICTED_DATA_RANGE);
		createEReference(restrictedDataRangeEClass, RESTRICTED_DATA_RANGE__RESTRICTED_RANGE);

		binaryScalarRestrictionEClass = createEClass(BINARY_SCALAR_RESTRICTION);
		createEAttribute(binaryScalarRestrictionEClass, BINARY_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(binaryScalarRestrictionEClass, BINARY_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(binaryScalarRestrictionEClass, BINARY_SCALAR_RESTRICTION__MAX_LENGTH);

		iriScalarRestrictionEClass = createEClass(IRI_SCALAR_RESTRICTION);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__MAX_LENGTH);
		createEAttribute(iriScalarRestrictionEClass, IRI_SCALAR_RESTRICTION__PATTERN);

		numericScalarRestrictionEClass = createEClass(NUMERIC_SCALAR_RESTRICTION);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MIN_INCLUSIVE);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MAX_INCLUSIVE);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
		createEAttribute(numericScalarRestrictionEClass, NUMERIC_SCALAR_RESTRICTION__MAX_EXCLUSIVE);

		plainLiteralScalarRestrictionEClass = createEClass(PLAIN_LITERAL_SCALAR_RESTRICTION);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__MAX_LENGTH);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__PATTERN);
		createEAttribute(plainLiteralScalarRestrictionEClass, PLAIN_LITERAL_SCALAR_RESTRICTION__LANG_RANGE);

		stringScalarRestrictionEClass = createEClass(STRING_SCALAR_RESTRICTION);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__LENGTH);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__MIN_LENGTH);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__MAX_LENGTH);
		createEAttribute(stringScalarRestrictionEClass, STRING_SCALAR_RESTRICTION__PATTERN);

		timeScalarRestrictionEClass = createEClass(TIME_SCALAR_RESTRICTION);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MIN_INCLUSIVE);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MAX_INCLUSIVE);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MIN_EXCLUSIVE);
		createEAttribute(timeScalarRestrictionEClass, TIME_SCALAR_RESTRICTION__MAX_EXCLUSIVE);

		synonymScalarRestrictionEClass = createEClass(SYNONYM_SCALAR_RESTRICTION);

		scalarOneOfRestrictionEClass = createEClass(SCALAR_ONE_OF_RESTRICTION);

		scalarOneOfLiteralAxiomEClass = createEClass(SCALAR_ONE_OF_LITERAL_AXIOM);
		createEReference(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__AXIOM);
		createEAttribute(scalarOneOfLiteralAxiomEClass, SCALAR_ONE_OF_LITERAL_AXIOM__VALUE);

		descriptionBoxEClass = createEClass(DESCRIPTION_BOX);
		createEAttribute(descriptionBoxEClass, DESCRIPTION_BOX__KIND);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__TERMINOLOGY_EXTENT);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__CONCEPT_INSTANCES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES);
		createEReference(descriptionBoxEClass, DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES);

		descriptionBoxRelationshipEClass = createEClass(DESCRIPTION_BOX_RELATIONSHIP);
		createEOperation(descriptionBoxRelationshipEClass, DESCRIPTION_BOX_RELATIONSHIP___DESCRIPTION_DOMAIN);
		createEOperation(descriptionBoxRelationshipEClass, DESCRIPTION_BOX_RELATIONSHIP___CONTEXT_TARGET);

		descriptionBoxExtendsClosedWorldDefinitionsEClass = createEClass(DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS);
		createEReference(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__DESCRIPTION_BOX);
		createEReference(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS__CLOSED_WORLD_DEFINITIONS);
		createEOperation(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___DESCRIPTION_DOMAIN);
		createEOperation(descriptionBoxExtendsClosedWorldDefinitionsEClass, DESCRIPTION_BOX_EXTENDS_CLOSED_WORLD_DEFINITIONS___CONTEXT_TARGET);

		descriptionBoxRefinementEClass = createEClass(DESCRIPTION_BOX_REFINEMENT);
		createEReference(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT__REFINING_DESCRIPTION_BOX);
		createEReference(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT__REFINED_DESCRIPTION_BOX);
		createEOperation(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT___DESCRIPTION_DOMAIN);
		createEOperation(descriptionBoxRefinementEClass, DESCRIPTION_BOX_REFINEMENT___CONTEXT_TARGET);

		terminologyInstanceAssertionEClass = createEClass(TERMINOLOGY_INSTANCE_ASSERTION);
		createEAttribute(terminologyInstanceAssertionEClass, TERMINOLOGY_INSTANCE_ASSERTION__NAME);
		createEOperation(terminologyInstanceAssertionEClass, TERMINOLOGY_INSTANCE_ASSERTION___DESCRIPTION_BOX);
		createEOperation(terminologyInstanceAssertionEClass, TERMINOLOGY_INSTANCE_ASSERTION___CALCULATE_UUID);
		createEOperation(terminologyInstanceAssertionEClass, TERMINOLOGY_INSTANCE_ASSERTION___IRI);
		createEOperation(terminologyInstanceAssertionEClass, TERMINOLOGY_INSTANCE_ASSERTION___NAME);

		singletonInstanceEClass = createEClass(SINGLETON_INSTANCE);
		createEReference(singletonInstanceEClass, SINGLETON_INSTANCE__SCALAR_DATA_PROPERTY_VALUES);
		createEReference(singletonInstanceEClass, SINGLETON_INSTANCE__STRUCTURED_DATA_PROPERTY_VALUES);

		scalarDataPropertyValueEClass = createEClass(SCALAR_DATA_PROPERTY_VALUE);
		createEReference(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE);
		createEReference(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__SCALAR_DATA_PROPERTY);
		createEAttribute(scalarDataPropertyValueEClass, SCALAR_DATA_PROPERTY_VALUE__SCALAR_PROPERTY_VALUE);

		structuredDataPropertyValueEClass = createEClass(STRUCTURED_DATA_PROPERTY_VALUE);
		createEReference(structuredDataPropertyValueEClass, STRUCTURED_DATA_PROPERTY_VALUE__SINGLETON_INSTANCE);
		createEReference(structuredDataPropertyValueEClass, STRUCTURED_DATA_PROPERTY_VALUE__STRUCTURED_DATA_PROPERTY);
		createEReference(structuredDataPropertyValueEClass, STRUCTURED_DATA_PROPERTY_VALUE__STRUCTURED_PROPERTY_TUPLE);

		dataStructureTupleEClass = createEClass(DATA_STRUCTURE_TUPLE);
		createEReference(dataStructureTupleEClass, DATA_STRUCTURE_TUPLE__STRUCTURED_DATA_PROPERTY_VALUE);
		createEReference(dataStructureTupleEClass, DATA_STRUCTURE_TUPLE__DATA_STRUCTURE_TYPE);

		conceptualEntitySingletonInstanceEClass = createEClass(CONCEPTUAL_ENTITY_SINGLETON_INSTANCE);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IDENTIFYING_SCALAR_VALUES);
		createEOperation(conceptualEntitySingletonInstanceEClass, CONCEPTUAL_ENTITY_SINGLETON_INSTANCE___IDENTIFYING_STRUCTURED_TUPLES);

		conceptInstanceEClass = createEClass(CONCEPT_INSTANCE);
		createEReference(conceptInstanceEClass, CONCEPT_INSTANCE__DESCRIPTION_BOX);
		createEReference(conceptInstanceEClass, CONCEPT_INSTANCE__SINGLETON_CONCEPT_CLASSIFIER);
		createEOperation(conceptInstanceEClass, CONCEPT_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER);

		reifiedRelationshipInstanceEClass = createEClass(REIFIED_RELATIONSHIP_INSTANCE);
		createEReference(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE__DESCRIPTION_BOX);
		createEReference(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE__SINGLETON_REIFIED_RELATIONSHIP_CLASSIFIER);
		createEOperation(reifiedRelationshipInstanceEClass, REIFIED_RELATIONSHIP_INSTANCE___CONCEPTUAL_ENTITY_SINGLETON_CLASSIFIER);

		reifiedRelationshipInstanceDomainEClass = createEClass(REIFIED_RELATIONSHIP_INSTANCE_DOMAIN);
		createEReference(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DESCRIPTION_BOX);
		createEReference(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__REIFIED_RELATIONSHIP_INSTANCE);
		createEReference(reifiedRelationshipInstanceDomainEClass, REIFIED_RELATIONSHIP_INSTANCE_DOMAIN__DOMAIN);

		reifiedRelationshipInstanceRangeEClass = createEClass(REIFIED_RELATIONSHIP_INSTANCE_RANGE);
		createEReference(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE__DESCRIPTION_BOX);
		createEReference(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE__REIFIED_RELATIONSHIP_INSTANCE);
		createEReference(reifiedRelationshipInstanceRangeEClass, REIFIED_RELATIONSHIP_INSTANCE_RANGE__RANGE);

		unreifiedRelationshipInstanceTupleEClass = createEClass(UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DESCRIPTION_BOX);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__UNREIFIED_RELATIONSHIP);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__DOMAIN);
		createEReference(unreifiedRelationshipInstanceTupleEClass, UNREIFIED_RELATIONSHIP_INSTANCE_TUPLE__RANGE);

		// Create enums
		terminologyGraphKindEEnum = createEEnum(TERMINOLOGY_GRAPH_KIND);
		descriptionKindEEnum = createEEnum(DESCRIPTION_KIND);

		// Create data types
		iriEDataType = createEDataType(IRI);
		localNameEDataType = createEDataType(LOCAL_NAME);
		lexicalValueEDataType = createEDataType(LEXICAL_VALUE);
		lexicalNumberEDataType = createEDataType(LEXICAL_NUMBER);
		lexicalTimeEDataType = createEDataType(LEXICAL_TIME);
		patternEDataType = createEDataType(PATTERN);
		uuidEDataType = createEDataType(UUID);
		langRangeEDataType = createEDataType(LANG_RANGE);
		abbrevIRIEDataType = createEDataType(ABBREV_IRI);
		namespacePrefixEDataType = createEDataType(NAMESPACE_PREFIX);
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

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		contextEClass.getESuperTypes().add(this.getTerminologyThing());
		contextEClass.getESuperTypes().add(this.getResource());
		terminologyBoxEClass.getESuperTypes().add(this.getContext());
		bundleEClass.getESuperTypes().add(this.getTerminologyBox());
		terminologyGraphEClass.getESuperTypes().add(this.getTerminologyBox());
		terminologyBoxStatementEClass.getESuperTypes().add(this.getTerminologyThing());
		terminologyBundleStatementEClass.getESuperTypes().add(this.getTerminologyThing());
		termEClass.getESuperTypes().add(this.getTerminologyBoxStatement());
		termEClass.getESuperTypes().add(this.getResource());
		entityEClass.getESuperTypes().add(this.getTerm());
		aspectEClass.getESuperTypes().add(this.getEntity());
		aspectEClass.getESuperTypes().add(this.getUnaryTermKind());
		conceptEClass.getESuperTypes().add(this.getEntity());
		conceptEClass.getESuperTypes().add(this.getConceptualEntity());
		conceptEClass.getESuperTypes().add(this.getUnaryTermKind());
		entityRelationshipEClass.getESuperTypes().add(this.getTerm());
		entityRelationshipEClass.getESuperTypes().add(this.getDirectedBinaryRelationshipKind());
		reifiedRelationshipEClass.getESuperTypes().add(this.getEntityRelationship());
		reifiedRelationshipEClass.getESuperTypes().add(this.getEntity());
		reifiedRelationshipEClass.getESuperTypes().add(this.getConceptualEntity());
		unreifiedRelationshipEClass.getESuperTypes().add(this.getEntityRelationship());
		datatypeEClass.getESuperTypes().add(this.getTerm());
		dataRangeEClass.getESuperTypes().add(this.getDatatype());
		scalarEClass.getESuperTypes().add(this.getDataRange());
		scalarEClass.getESuperTypes().add(this.getUnaryTermKind());
		dataRelationshipEClass.getESuperTypes().add(this.getTerm());
		dataRelationshipEClass.getESuperTypes().add(this.getDirectedBinaryRelationshipKind());
		dataRelationshipFromEntityEClass.getESuperTypes().add(this.getDataRelationshipDomain());
		dataRelationshipFromStructureEClass.getESuperTypes().add(this.getDataRelationshipDomain());
		dataRelationshipToScalarEClass.getESuperTypes().add(this.getDataRelationshipRange());
		dataRelationshipToStructureEClass.getESuperTypes().add(this.getDataRelationshipRange());
		entityStructuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		entityStructuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromEntity());
		entityStructuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToStructure());
		entityScalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		entityScalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromEntity());
		entityScalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToScalar());
		structuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		structuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromStructure());
		structuredDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToStructure());
		scalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationship());
		scalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipFromStructure());
		scalarDataPropertyEClass.getESuperTypes().add(this.getDataRelationshipToScalar());
		structureEClass.getESuperTypes().add(this.getDatatype());
		structureEClass.getESuperTypes().add(this.getUnaryTermKind());
		axiomEClass.getESuperTypes().add(this.getTerminologyBoxStatement());
		terminologyAxiomEClass.getESuperTypes().add(this.getTerminologyThing());
		terminologyBoxAxiomEClass.getESuperTypes().add(this.getTerminologyAxiom());
		terminologyBundleAxiomEClass.getESuperTypes().add(this.getTerminologyAxiom());
		disjointUnionOfConceptsAxiomEClass.getESuperTypes().add(this.getTerminologyBundleStatement());
		specificDisjointConceptAxiomEClass.getESuperTypes().add(this.getDisjointUnionOfConceptsAxiom());
		anonymousConceptTaxonomyAxiomEClass.getESuperTypes().add(this.getDisjointUnionOfConceptsAxiom());
		anonymousConceptTaxonomyAxiomEClass.getESuperTypes().add(this.getConceptTreeDisjunction());
		rootConceptTaxonomyAxiomEClass.getESuperTypes().add(this.getTerminologyBundleStatement());
		rootConceptTaxonomyAxiomEClass.getESuperTypes().add(this.getConceptTreeDisjunction());
		bundledTerminologyAxiomEClass.getESuperTypes().add(this.getTerminologyBundleAxiom());
		conceptDesignationTerminologyAxiomEClass.getESuperTypes().add(this.getTerminologyBoxAxiom());
		terminologyExtensionAxiomEClass.getESuperTypes().add(this.getTerminologyBoxAxiom());
		terminologyNestingAxiomEClass.getESuperTypes().add(this.getTerminologyBoxAxiom());
		termAxiomEClass.getESuperTypes().add(this.getAxiom());
		entityRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityExistentialRestrictionAxiomEClass.getESuperTypes().add(this.getEntityRestrictionAxiom());
		entityUniversalRestrictionAxiomEClass.getESuperTypes().add(this.getEntityRestrictionAxiom());
		specializationAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		aspectSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		conceptSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		reifiedRelationshipSpecializationAxiomEClass.getESuperTypes().add(this.getSpecializationAxiom());
		entityScalarDataPropertyRestrictionAxiomEClass.getESuperTypes().add(this.getTermAxiom());
		entityScalarDataPropertyExistentialRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyUniversalRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		entityScalarDataPropertyParticularRestrictionAxiomEClass.getESuperTypes().add(this.getEntityScalarDataPropertyRestrictionAxiom());
		restrictedDataRangeEClass.getESuperTypes().add(this.getDataRange());
		binaryScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		iriScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		numericScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		plainLiteralScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		stringScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		timeScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		synonymScalarRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		scalarOneOfRestrictionEClass.getESuperTypes().add(this.getRestrictedDataRange());
		scalarOneOfLiteralAxiomEClass.getESuperTypes().add(this.getAxiom());
		descriptionBoxEClass.getESuperTypes().add(this.getContext());
		descriptionBoxRelationshipEClass.getESuperTypes().add(this.getTerminologyThing());
		descriptionBoxExtendsClosedWorldDefinitionsEClass.getESuperTypes().add(this.getDescriptionBoxRelationship());
		descriptionBoxRefinementEClass.getESuperTypes().add(this.getDescriptionBoxRelationship());
		terminologyInstanceAssertionEClass.getESuperTypes().add(this.getTerminologyThing());
		terminologyInstanceAssertionEClass.getESuperTypes().add(this.getResource());
		singletonInstanceEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		scalarDataPropertyValueEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		structuredDataPropertyValueEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		dataStructureTupleEClass.getESuperTypes().add(this.getSingletonInstance());
		conceptualEntitySingletonInstanceEClass.getESuperTypes().add(this.getSingletonInstance());
		conceptInstanceEClass.getESuperTypes().add(this.getConceptualEntitySingletonInstance());
		reifiedRelationshipInstanceEClass.getESuperTypes().add(this.getConceptualEntitySingletonInstance());
		reifiedRelationshipInstanceDomainEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		reifiedRelationshipInstanceRangeEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());
		unreifiedRelationshipInstanceTupleEClass.getESuperTypes().add(this.getTerminologyInstanceAssertion());

		// Initialize classes, features, and operations; add parameters
		initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getResource__Iri(), this.getIRI(), "iri", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getResource__Name(), this.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyThingEClass, TerminologyThing.class, "TerminologyThing", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminologyThing_Uuid(), this.getUUID(), "uuid", null, 1, 1, TerminologyThing.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyThing__CalculateUUID(), this.getUUID(), "calculateUUID", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(annotationPropertyEClass, AnnotationProperty.class, "AnnotationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotationProperty_Iri(), this.getIRI(), "iri", null, 1, 1, AnnotationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationProperty_AbbrevIRI(), this.getAbbrevIRI(), "abbrevIRI", null, 1, 1, AnnotationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAnnotationProperty__Uuid(), this.getUUID(), "uuid", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(annotationPropertyTableEClass, Map.Entry.class, "AnnotationPropertyTable", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationPropertyTable_Key(), this.getAnnotationProperty(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationPropertyTable_Value(), this.getAnnotationEntry(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEntryEClass, AnnotationEntry.class, "AnnotationEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationEntry_Context(), this.getContext(), null, "context", null, 1, 1, AnnotationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationEntry_Subject(), this.getTerminologyThing(), null, "subject", null, 1, 1, AnnotationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationEntry_Value(), theEcorePackage.getEString(), "value", null, 1, 1, AnnotationEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationSubjectTableEClass, Map.Entry.class, "AnnotationSubjectTable", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationSubjectTable_Key(), this.getTerminologyThing(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationSubjectTable_Value(), this.getAnnotationSubjectPropertyValue(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationSubjectPropertyValueEClass, AnnotationSubjectPropertyValue.class, "AnnotationSubjectPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationSubjectPropertyValue_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, AnnotationSubjectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationSubjectPropertyValue_Value(), theEcorePackage.getEString(), "value", null, 1, 1, AnnotationSubjectPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Context(), this.getContext(), this.getContext_Annotations(), "context", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_Property(), this.getAnnotationProperty(), null, "property", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_Subject(), this.getTerminologyThing(), null, "subject", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_Value(), theEcorePackage.getEString(), "value", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyExtentEClass, TerminologyExtent.class, "TerminologyExtent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyExtent_AnnotationProperties(), this.getAnnotationProperty(), null, "annotationProperties", null, 0, -1, TerminologyExtent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyExtent_TerminologyGraphs(), this.getTerminologyGraph(), this.getTerminologyGraph_GraphExtent(), "terminologyGraphs", null, 0, -1, TerminologyExtent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyExtent_Bundles(), this.getBundle(), this.getBundle_BundleExtent(), "bundles", null, 0, -1, TerminologyExtent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyExtent_Descriptions(), this.getDescriptionBox(), this.getDescriptionBox_TerminologyExtent(), "descriptions", null, 0, -1, TerminologyExtent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_Iri(), this.getIRI(), "iri", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Annotations(), this.getAnnotation(), this.getAnnotation_Context(), "annotations", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getContext__Extent(), this.getTerminologyExtent(), "extent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContext__CalculateUUID(), this.getUUID(), "calculateUUID", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContext__Iri(), this.getIRI(), "iri", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContext__NsPrefix(), this.getNamespacePrefix(), "nsPrefix", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContext__Name(), this.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContext__AnnotationsBySubject(), this.getAnnotationSubjectTable(), "annotationsBySubject", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContext__AnnotationsByProperty(), this.getAnnotationPropertyTable(), "annotationsByProperty", 0, -1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getContext__WithAnnotations__EMap(), this.getContext(), "withAnnotations", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnnotationPropertyTable(), "a", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyBoxEClass, TerminologyBox.class, "TerminologyBox", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminologyBox_Kind(), this.getTerminologyGraphKind(), "kind", null, 1, 1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyBox_TerminologyBoxAxioms(), this.getTerminologyBoxAxiom(), this.getTerminologyBoxAxiom_Tbox(), "terminologyBoxAxioms", null, 0, -1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyBox_BoxStatements(), this.getTerminologyBoxStatement(), this.getTerminologyBoxStatement_Tbox(), "boxStatements", null, 0, -1, TerminologyBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTerminologyBox__WithBoxStatements__EList(), this.getTerminologyBox(), "withBoxStatements", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTerminologyBoxStatement(), "s", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Entities(), this.getEntity(), "entities", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Aspects(), this.getAspect(), "aspects", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Concepts(), this.getConcept(), "concepts", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__ReifiedRelationships(), this.getReifiedRelationship(), "reifiedRelationships", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__UnreifiedRelationships(), this.getUnreifiedRelationship(), "unreifiedRelationships", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__DataRelationships(), this.getDataRelationship(), "dataRelationships", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__EntityScalarDataProperties(), this.getEntityScalarDataProperty(), "entityScalarDataProperties", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Dataranges(), this.getDataRange(), "dataranges", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Scalars(), this.getScalar(), "scalars", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Structures(), this.getStructure(), "structures", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__TermAxioms(), this.getTermAxiom(), "termAxioms", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyBox__Everything(), this.getTerminologyThing(), "everything", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBundle_BundleExtent(), this.getTerminologyExtent(), this.getTerminologyExtent_Bundles(), "bundleExtent", null, 1, 1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBundle_BundleStatements(), this.getTerminologyBundleStatement(), this.getTerminologyBundleStatement_Bundle(), "bundleStatements", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBundle_TerminologyBundleAxioms(), this.getTerminologyBundleAxiom(), this.getTerminologyBundleAxiom_TerminologyBundle(), "terminologyBundleAxioms", null, 0, -1, Bundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBundle__Extent(), this.getTerminologyExtent(), "extent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBundle__WithAnnotations__EMap(), this.getBundle(), "withAnnotations", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnnotationPropertyTable(), "a", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBundle__AnnotationsByProperty(), this.getAnnotationPropertyTable(), "annotationsByProperty", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBundle__WithBundleStatements__EList(), this.getBundle(), "withBundleStatements", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTerminologyBundleStatement(), "s", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBundle__WithBoxStatements__EList(), this.getBundle(), "withBoxStatements", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTerminologyBoxStatement(), "s", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBundle__Everything(), this.getTerminologyThing(), "everything", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyGraphEClass, TerminologyGraph.class, "TerminologyGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyGraph_GraphExtent(), this.getTerminologyExtent(), this.getTerminologyExtent_TerminologyGraphs(), "graphExtent", null, 1, 1, TerminologyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyGraph__Extent(), this.getTerminologyExtent(), "extent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTerminologyGraph__WithAnnotations__EMap(), this.getTerminologyGraph(), "withAnnotations", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAnnotationPropertyTable(), "a", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyGraph__AnnotationsByProperty(), this.getAnnotationPropertyTable(), "annotationsByProperty", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTerminologyGraph__WithBoxStatements__EList(), this.getTerminologyGraph(), "withBoxStatements", 1, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTerminologyBoxStatement(), "s", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyBoxStatementEClass, TerminologyBoxStatement.class, "TerminologyBoxStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBoxStatement_Tbox(), this.getTerminologyBox(), this.getTerminologyBox_BoxStatements(), "tbox", null, 1, 1, TerminologyBoxStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyBundleStatementEClass, TerminologyBundleStatement.class, "TerminologyBundleStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBundleStatement_Bundle(), this.getBundle(), this.getBundle_BundleStatements(), "bundle", null, 1, 1, TerminologyBundleStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerm_Name(), this.getLocalName(), "name", null, 1, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerm__CalculateUUID(), this.getUUID(), "calculateUUID", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerm__Iri(), this.getIRI(), "iri", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerm__Name(), this.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(unaryTermKindEClass, UnaryTermKind.class, "UnaryTermKind", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directedBinaryRelationshipKindEClass, DirectedBinaryRelationshipKind.class, "DirectedBinaryRelationshipKind", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDirectedBinaryRelationshipKind__RelationshipSubject(), this.getTerm(), "relationshipSubject", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDirectedBinaryRelationshipKind__RelationRange(), this.getTerm(), "relationRange", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptualEntityEClass, ConceptualEntity.class, "ConceptualEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConceptualEntity_IsAbstract(), theEcorePackage.getEBoolean(), "isAbstract", null, 1, 1, ConceptualEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aspectEClass, Aspect.class, "Aspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conceptEClass, Concept.class, "Concept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityRelationshipEClass, EntityRelationship.class, "EntityRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityRelationship_Source(), this.getEntity(), null, "source", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRelationship_Target(), this.getEntity(), null, "target", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsFunctional(), theEcorePackage.getEBoolean(), "isFunctional", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsInverseFunctional(), theEcorePackage.getEBoolean(), "isInverseFunctional", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsEssential(), theEcorePackage.getEBoolean(), "isEssential", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsInverseEssential(), theEcorePackage.getEBoolean(), "isInverseEssential", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsSymmetric(), theEcorePackage.getEBoolean(), "isSymmetric", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsAsymmetric(), theEcorePackage.getEBoolean(), "isAsymmetric", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsReflexive(), theEcorePackage.getEBoolean(), "isReflexive", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsIrreflexive(), theEcorePackage.getEBoolean(), "isIrreflexive", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityRelationship_IsTransitive(), theEcorePackage.getEBoolean(), "isTransitive", null, 1, 1, EntityRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEntityRelationship__RelationDomain(), this.getTerm(), "relationDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityRelationship__RelationRange(), this.getTerm(), "relationRange", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipEClass, ReifiedRelationship.class, "ReifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReifiedRelationship_UnreifiedPropertyName(), this.getLocalName(), "unreifiedPropertyName", null, 1, 1, ReifiedRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReifiedRelationship_UnreifiedInversePropertyName(), this.getLocalName(), "unreifiedInversePropertyName", null, 0, 1, ReifiedRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unreifiedRelationshipEClass, UnreifiedRelationship.class, "UnreifiedRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(datatypeEClass, Datatype.class, "Datatype", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRangeEClass, DataRange.class, "DataRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarEClass, Scalar.class, "Scalar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRelationshipEClass, DataRelationship.class, "DataRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDataRelationship__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataRelationship__RelationDomain(), this.getTerm(), "relationDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataRelationship__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataRelationship__RelationRange(), this.getTerm(), "relationRange", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(dataRelationshipDomainEClass, DataRelationshipDomain.class, "DataRelationshipDomain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRelationshipFromEntityEClass, DataRelationshipFromEntity.class, "DataRelationshipFromEntity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipFromEntity_Domain(), this.getEntity(), null, "domain", null, 1, 1, DataRelationshipFromEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataRelationshipFromEntity_IsIdentityCriteria(), theEcorePackage.getEBoolean(), "isIdentityCriteria", null, 1, 1, DataRelationshipFromEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataRelationshipFromStructureEClass, DataRelationshipFromStructure.class, "DataRelationshipFromStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipFromStructure_Domain(), this.getStructure(), null, "domain", null, 1, 1, DataRelationshipFromStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataRelationshipRangeEClass, DataRelationshipRange.class, "DataRelationshipRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataRelationshipToScalarEClass, DataRelationshipToScalar.class, "DataRelationshipToScalar", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipToScalar_Range(), this.getDataRange(), null, "range", null, 1, 1, DataRelationshipToScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataRelationshipToStructureEClass, DataRelationshipToStructure.class, "DataRelationshipToStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataRelationshipToStructure_Range(), this.getStructure(), null, "range", null, 1, 1, DataRelationshipToStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityStructuredDataPropertyEClass, EntityStructuredDataProperty.class, "EntityStructuredDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityStructuredDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityStructuredDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyEClass, EntityScalarDataProperty.class, "EntityScalarDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntityScalarDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getEntityScalarDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(structuredDataPropertyEClass, StructuredDataProperty.class, "StructuredDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getStructuredDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getStructuredDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(scalarDataPropertyEClass, ScalarDataProperty.class, "ScalarDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getScalarDataProperty__Source(), this.getTerm(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getScalarDataProperty__Target(), this.getDatatype(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(axiomEClass, Axiom.class, "Axiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(terminologyAxiomEClass, TerminologyAxiom.class, "TerminologyAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTerminologyAxiom__Source(), this.getTerminologyBox(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyBoxAxiomEClass, TerminologyBoxAxiom.class, "TerminologyBoxAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBoxAxiom_Tbox(), this.getTerminologyBox(), this.getTerminologyBox_TerminologyBoxAxioms(), "tbox", null, 1, 1, TerminologyBoxAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminologyBundleAxiomEClass, TerminologyBundleAxiom.class, "TerminologyBundleAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyBundleAxiom_TerminologyBundle(), this.getBundle(), this.getBundle_TerminologyBundleAxioms(), "terminologyBundle", null, 1, 1, TerminologyBundleAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptTreeDisjunctionEClass, ConceptTreeDisjunction.class, "ConceptTreeDisjunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(disjointUnionOfConceptsAxiomEClass, DisjointUnionOfConceptsAxiom.class, "DisjointUnionOfConceptsAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisjointUnionOfConceptsAxiom_DisjointTaxonomyParent(), this.getConceptTreeDisjunction(), null, "disjointTaxonomyParent", null, 1, 1, DisjointUnionOfConceptsAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificDisjointConceptAxiomEClass, SpecificDisjointConceptAxiom.class, "SpecificDisjointConceptAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificDisjointConceptAxiom_DisjointLeaf(), this.getConcept(), null, "disjointLeaf", null, 1, 1, SpecificDisjointConceptAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anonymousConceptTaxonomyAxiomEClass, AnonymousConceptTaxonomyAxiom.class, "AnonymousConceptTaxonomyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rootConceptTaxonomyAxiomEClass, RootConceptTaxonomyAxiom.class, "RootConceptTaxonomyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootConceptTaxonomyAxiom_Root(), this.getConcept(), null, "root", null, 1, 1, RootConceptTaxonomyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bundledTerminologyAxiomEClass, BundledTerminologyAxiom.class, "BundledTerminologyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBundledTerminologyAxiom_BundledTerminology(), this.getTerminologyBox(), null, "bundledTerminology", null, 1, 1, BundledTerminologyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBundledTerminologyAxiom__Source(), this.getTerminologyBox(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBundledTerminologyAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptDesignationTerminologyAxiomEClass, ConceptDesignationTerminologyAxiom.class, "ConceptDesignationTerminologyAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptDesignationTerminologyAxiom_DesignatedTerminology(), this.getTerminologyBox(), null, "designatedTerminology", null, 1, 1, ConceptDesignationTerminologyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptDesignationTerminologyAxiom_DesignatedConcept(), this.getConcept(), null, "designatedConcept", null, 1, 1, ConceptDesignationTerminologyAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), this.getTerminologyGraph(), "designationTerminologyGraph", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__Source(), this.getTerminologyBox(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptDesignationTerminologyAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyExtensionAxiomEClass, TerminologyExtensionAxiom.class, "TerminologyExtensionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyExtensionAxiom_ExtendedTerminology(), this.getTerminologyBox(), null, "extendedTerminology", null, 1, 1, TerminologyExtensionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__CalculateUUID(), this.getUUID(), "calculateUUID", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__ExtendingTerminology(), this.getTerminologyBox(), "extendingTerminology", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__Source(), this.getTerminologyBox(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyExtensionAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyNestingAxiomEClass, TerminologyNestingAxiom.class, "TerminologyNestingAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTerminologyNestingAxiom_NestingTerminology(), this.getTerminologyBox(), null, "nestingTerminology", null, 1, 1, TerminologyNestingAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTerminologyNestingAxiom_NestingContext(), this.getConcept(), null, "nestingContext", null, 1, 1, TerminologyNestingAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__NestedTerminology(), this.getTerminologyGraph(), "nestedTerminology", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__Source(), this.getTerminologyBox(), "source", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyNestingAxiom__Target(), this.getTerminologyBox(), "target", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(termAxiomEClass, TermAxiom.class, "TermAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityRestrictionAxiomEClass, EntityRestrictionAxiom.class, "EntityRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityRestrictionAxiom_RestrictedRelation(), this.getEntityRelationship(), null, "restrictedRelation", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRestrictionAxiom_RestrictedRange(), this.getEntity(), null, "restrictedRange", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityRestrictionAxiom_RestrictedDomain(), this.getEntity(), null, "restrictedDomain", null, 1, 1, EntityRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityExistentialRestrictionAxiomEClass, EntityExistentialRestrictionAxiom.class, "EntityExistentialRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityUniversalRestrictionAxiomEClass, EntityUniversalRestrictionAxiom.class, "EntityUniversalRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(specializationAxiomEClass, SpecializationAxiom.class, "SpecializationAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(aspectSpecializationAxiomEClass, AspectSpecializationAxiom.class, "AspectSpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAspectSpecializationAxiom_SubEntity(), this.getEntity(), null, "subEntity", null, 1, 1, AspectSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAspectSpecializationAxiom_SuperAspect(), this.getAspect(), null, "superAspect", null, 1, 1, AspectSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAspectSpecializationAxiom__CalculateUUID(), this.getUUID(), "calculateUUID", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAspectSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAspectSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptSpecializationAxiomEClass, ConceptSpecializationAxiom.class, "ConceptSpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptSpecializationAxiom_SubConcept(), this.getConcept(), null, "subConcept", null, 1, 1, ConceptSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptSpecializationAxiom_SuperConcept(), this.getConcept(), null, "superConcept", null, 1, 1, ConceptSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipSpecializationAxiomEClass, ReifiedRelationshipSpecializationAxiom.class, "ReifiedRelationshipSpecializationAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipSpecializationAxiom_SubRelationship(), this.getReifiedRelationship(), null, "subRelationship", null, 1, 1, ReifiedRelationshipSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipSpecializationAxiom_SuperRelationship(), this.getReifiedRelationship(), null, "superRelationship", null, 1, 1, ReifiedRelationshipSpecializationAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipSpecializationAxiom__Child(), this.getEntity(), "child", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getReifiedRelationshipSpecializationAxiom__Parent(), this.getEntity(), "parent", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(entityScalarDataPropertyRestrictionAxiomEClass, EntityScalarDataPropertyRestrictionAxiom.class, "EntityScalarDataPropertyRestrictionAxiom", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity(), this.getEntity(), null, "restrictedEntity", null, 1, 1, EntityScalarDataPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty(), this.getEntityScalarDataProperty(), null, "scalarProperty", null, 1, 1, EntityScalarDataPropertyRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityScalarDataPropertyExistentialRestrictionAxiomEClass, EntityScalarDataPropertyExistentialRestrictionAxiom.class, "EntityScalarDataPropertyExistentialRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyExistentialRestrictionAxiom_ScalarRestriction(), this.getDataRange(), null, "scalarRestriction", null, 1, 1, EntityScalarDataPropertyExistentialRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityScalarDataPropertyUniversalRestrictionAxiomEClass, EntityScalarDataPropertyUniversalRestrictionAxiom.class, "EntityScalarDataPropertyUniversalRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntityScalarDataPropertyUniversalRestrictionAxiom_ScalarRestriction(), this.getDataRange(), null, "scalarRestriction", null, 1, 1, EntityScalarDataPropertyUniversalRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityScalarDataPropertyParticularRestrictionAxiomEClass, EntityScalarDataPropertyParticularRestrictionAxiom.class, "EntityScalarDataPropertyParticularRestrictionAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntityScalarDataPropertyParticularRestrictionAxiom_LiteralValue(), this.getLexicalValue(), "literalValue", null, 1, 1, EntityScalarDataPropertyParticularRestrictionAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(restrictedDataRangeEClass, RestrictedDataRange.class, "RestrictedDataRange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRestrictedDataRange_RestrictedRange(), this.getDataRange(), null, "restrictedRange", null, 1, 1, RestrictedDataRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryScalarRestrictionEClass, BinaryScalarRestriction.class, "BinaryScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, BinaryScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iriScalarRestrictionEClass, IRIScalarRestriction.class, "IRIScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIRIScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIRIScalarRestriction_Pattern(), this.getPattern(), "pattern", null, 0, 1, IRIScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericScalarRestrictionEClass, NumericScalarRestriction.class, "NumericScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericScalarRestriction_MinInclusive(), this.getLexicalNumber(), "minInclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericScalarRestriction_MaxInclusive(), this.getLexicalNumber(), "maxInclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericScalarRestriction_MinExclusive(), this.getLexicalNumber(), "minExclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericScalarRestriction_MaxExclusive(), this.getLexicalNumber(), "maxExclusive", null, 0, 1, NumericScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plainLiteralScalarRestrictionEClass, PlainLiteralScalarRestriction.class, "PlainLiteralScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlainLiteralScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_Pattern(), this.getPattern(), "pattern", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlainLiteralScalarRestriction_LangRange(), this.getLangRange(), "langRange", null, 0, 1, PlainLiteralScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringScalarRestrictionEClass, StringScalarRestriction.class, "StringScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringScalarRestriction_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_MinLength(), theEcorePackage.getEInt(), "minLength", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_MaxLength(), theEcorePackage.getEInt(), "maxLength", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringScalarRestriction_Pattern(), this.getPattern(), "pattern", null, 0, 1, StringScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeScalarRestrictionEClass, TimeScalarRestriction.class, "TimeScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeScalarRestriction_MinInclusive(), this.getLexicalTime(), "minInclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeScalarRestriction_MaxInclusive(), this.getLexicalTime(), "maxInclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeScalarRestriction_MinExclusive(), this.getLexicalTime(), "minExclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeScalarRestriction_MaxExclusive(), this.getLexicalTime(), "maxExclusive", null, 0, 1, TimeScalarRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synonymScalarRestrictionEClass, SynonymScalarRestriction.class, "SynonymScalarRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarOneOfRestrictionEClass, ScalarOneOfRestriction.class, "ScalarOneOfRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarOneOfLiteralAxiomEClass, ScalarOneOfLiteralAxiom.class, "ScalarOneOfLiteralAxiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarOneOfLiteralAxiom_Axiom(), this.getScalarOneOfRestriction(), null, "axiom", null, 1, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarOneOfLiteralAxiom_Value(), this.getLexicalValue(), "value", null, 1, 1, ScalarOneOfLiteralAxiom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionBoxEClass, DescriptionBox.class, "DescriptionBox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionBox_Kind(), this.getDescriptionKind(), "kind", null, 1, 1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_TerminologyExtent(), this.getTerminologyExtent(), this.getTerminologyExtent_Descriptions(), "terminologyExtent", null, 1, 1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ClosedWorldDefinitions(), this.getDescriptionBoxExtendsClosedWorldDefinitions(), this.getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox(), "closedWorldDefinitions", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_DescriptionBoxRefinements(), this.getDescriptionBoxRefinement(), this.getDescriptionBoxRefinement_RefiningDescriptionBox(), "descriptionBoxRefinements", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ConceptInstances(), this.getConceptInstance(), this.getConceptInstance_DescriptionBox(), "conceptInstances", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ReifiedRelationshipInstances(), this.getReifiedRelationshipInstance(), this.getReifiedRelationshipInstance_DescriptionBox(), "reifiedRelationshipInstances", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ReifiedRelationshipInstanceDomains(), this.getReifiedRelationshipInstanceDomain(), this.getReifiedRelationshipInstanceDomain_DescriptionBox(), "reifiedRelationshipInstanceDomains", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_ReifiedRelationshipInstanceRanges(), this.getReifiedRelationshipInstanceRange(), this.getReifiedRelationshipInstanceRange_DescriptionBox(), "reifiedRelationshipInstanceRanges", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBox_UnreifiedRelationshipInstanceTuples(), this.getUnreifiedRelationshipInstanceTuple(), this.getUnreifiedRelationshipInstanceTuple_DescriptionBox(), "unreifiedRelationshipInstanceTuples", null, 0, -1, DescriptionBox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionBoxRelationshipEClass, DescriptionBoxRelationship.class, "DescriptionBoxRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDescriptionBoxRelationship__DescriptionDomain(), this.getDescriptionBox(), "descriptionDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxRelationship__ContextTarget(), this.getContext(), "contextTarget", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionBoxExtendsClosedWorldDefinitionsEClass, DescriptionBoxExtendsClosedWorldDefinitions.class, "DescriptionBoxExtendsClosedWorldDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionBoxExtendsClosedWorldDefinitions_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ClosedWorldDefinitions(), "descriptionBox", null, 1, 1, DescriptionBoxExtendsClosedWorldDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBoxExtendsClosedWorldDefinitions_ClosedWorldDefinitions(), this.getTerminologyBox(), null, "closedWorldDefinitions", null, 1, 1, DescriptionBoxExtendsClosedWorldDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain(), this.getDescriptionBox(), "descriptionDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxExtendsClosedWorldDefinitions__ContextTarget(), this.getContext(), "contextTarget", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(descriptionBoxRefinementEClass, DescriptionBoxRefinement.class, "DescriptionBoxRefinement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDescriptionBoxRefinement_RefiningDescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_DescriptionBoxRefinements(), "refiningDescriptionBox", null, 1, 1, DescriptionBoxRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionBoxRefinement_RefinedDescriptionBox(), this.getDescriptionBox(), null, "refinedDescriptionBox", null, 1, 1, DescriptionBoxRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDescriptionBoxRefinement__DescriptionDomain(), this.getDescriptionBox(), "descriptionDomain", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDescriptionBoxRefinement__ContextTarget(), this.getContext(), "contextTarget", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(terminologyInstanceAssertionEClass, TerminologyInstanceAssertion.class, "TerminologyInstanceAssertion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTerminologyInstanceAssertion_Name(), this.getLocalName(), "name", null, 1, 1, TerminologyInstanceAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTerminologyInstanceAssertion__DescriptionBox(), this.getDescriptionBox(), "descriptionBox", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyInstanceAssertion__CalculateUUID(), this.getUUID(), "calculateUUID", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyInstanceAssertion__Iri(), this.getIRI(), "iri", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getTerminologyInstanceAssertion__Name(), this.getLocalName(), "name", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(singletonInstanceEClass, SingletonInstance.class, "SingletonInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingletonInstance_ScalarDataPropertyValues(), this.getScalarDataPropertyValue(), this.getScalarDataPropertyValue_SingletonInstance(), "scalarDataPropertyValues", null, 0, -1, SingletonInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingletonInstance_StructuredDataPropertyValues(), this.getStructuredDataPropertyValue(), this.getStructuredDataPropertyValue_SingletonInstance(), "structuredDataPropertyValues", null, 0, -1, SingletonInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scalarDataPropertyValueEClass, ScalarDataPropertyValue.class, "ScalarDataPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarDataPropertyValue_SingletonInstance(), this.getSingletonInstance(), this.getSingletonInstance_ScalarDataPropertyValues(), "singletonInstance", null, 1, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScalarDataPropertyValue_ScalarDataProperty(), this.getDataRelationshipToScalar(), null, "scalarDataProperty", null, 1, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScalarDataPropertyValue_ScalarPropertyValue(), theEcorePackage.getEString(), "scalarPropertyValue", null, 1, 1, ScalarDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuredDataPropertyValueEClass, StructuredDataPropertyValue.class, "StructuredDataPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredDataPropertyValue_SingletonInstance(), this.getSingletonInstance(), this.getSingletonInstance_StructuredDataPropertyValues(), "singletonInstance", null, 1, 1, StructuredDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredDataPropertyValue_StructuredDataProperty(), this.getDataRelationshipToStructure(), null, "structuredDataProperty", null, 1, 1, StructuredDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuredDataPropertyValue_StructuredPropertyTuple(), this.getDataStructureTuple(), this.getDataStructureTuple_StructuredDataPropertyValue(), "structuredPropertyTuple", null, 1, 1, StructuredDataPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataStructureTupleEClass, DataStructureTuple.class, "DataStructureTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataStructureTuple_StructuredDataPropertyValue(), this.getStructuredDataPropertyValue(), this.getStructuredDataPropertyValue_StructuredPropertyTuple(), "structuredDataPropertyValue", null, 1, 1, DataStructureTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataStructureTuple_DataStructureType(), this.getStructure(), null, "dataStructureType", null, 1, 1, DataStructureTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptualEntitySingletonInstanceEClass, ConceptualEntitySingletonInstance.class, "ConceptualEntitySingletonInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier(), this.getConceptualEntity(), "conceptualEntitySingletonClassifier", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__IdentifyingScalarValues(), this.getScalarDataPropertyValue(), "identifyingScalarValues", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getConceptualEntitySingletonInstance__IdentifyingStructuredTuples(), this.getStructuredDataPropertyValue(), "identifyingStructuredTuples", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(conceptInstanceEClass, ConceptInstance.class, "ConceptInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConceptInstance_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ConceptInstances(), "descriptionBox", null, 1, 1, ConceptInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConceptInstance_SingletonConceptClassifier(), this.getConcept(), null, "singletonConceptClassifier", null, 1, 1, ConceptInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConceptInstance__ConceptualEntitySingletonClassifier(), this.getConceptualEntity(), "conceptualEntitySingletonClassifier", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipInstanceEClass, ReifiedRelationshipInstance.class, "ReifiedRelationshipInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInstance_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ReifiedRelationshipInstances(), "descriptionBox", null, 1, 1, ReifiedRelationshipInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstance_SingletonReifiedRelationshipClassifier(), this.getReifiedRelationship(), null, "singletonReifiedRelationshipClassifier", null, 1, 1, ReifiedRelationshipInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier(), this.getConceptualEntity(), "conceptualEntitySingletonClassifier", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(reifiedRelationshipInstanceDomainEClass, ReifiedRelationshipInstanceDomain.class, "ReifiedRelationshipInstanceDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInstanceDomain_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ReifiedRelationshipInstanceDomains(), "descriptionBox", null, 1, 1, ReifiedRelationshipInstanceDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceDomain_ReifiedRelationshipInstance(), this.getReifiedRelationshipInstance(), null, "reifiedRelationshipInstance", null, 1, 1, ReifiedRelationshipInstanceDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceDomain_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, ReifiedRelationshipInstanceDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reifiedRelationshipInstanceRangeEClass, ReifiedRelationshipInstanceRange.class, "ReifiedRelationshipInstanceRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReifiedRelationshipInstanceRange_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_ReifiedRelationshipInstanceRanges(), "descriptionBox", null, 1, 1, ReifiedRelationshipInstanceRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceRange_ReifiedRelationshipInstance(), this.getReifiedRelationshipInstance(), null, "reifiedRelationshipInstance", null, 1, 1, ReifiedRelationshipInstanceRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReifiedRelationshipInstanceRange_Range(), this.getConceptualEntitySingletonInstance(), null, "range", null, 1, 1, ReifiedRelationshipInstanceRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unreifiedRelationshipInstanceTupleEClass, UnreifiedRelationshipInstanceTuple.class, "UnreifiedRelationshipInstanceTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnreifiedRelationshipInstanceTuple_DescriptionBox(), this.getDescriptionBox(), this.getDescriptionBox_UnreifiedRelationshipInstanceTuples(), "descriptionBox", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnreifiedRelationshipInstanceTuple_UnreifiedRelationship(), this.getUnreifiedRelationship(), null, "unreifiedRelationship", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnreifiedRelationshipInstanceTuple_Domain(), this.getConceptualEntitySingletonInstance(), null, "domain", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnreifiedRelationshipInstanceTuple_Range(), this.getConceptualEntitySingletonInstance(), null, "range", null, 1, 1, UnreifiedRelationshipInstanceTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(terminologyGraphKindEEnum, TerminologyGraphKind.class, "TerminologyGraphKind");
		addEEnumLiteral(terminologyGraphKindEEnum, TerminologyGraphKind.OPEN_WORLD_DEFINITIONS);
		addEEnumLiteral(terminologyGraphKindEEnum, TerminologyGraphKind.CLOSED_WORLD_DESIGNATIONS);

		initEEnum(descriptionKindEEnum, DescriptionKind.class, "DescriptionKind");
		addEEnumLiteral(descriptionKindEEnum, DescriptionKind.FINAL);
		addEEnumLiteral(descriptionKindEEnum, DescriptionKind.PARTIAL);

		// Initialize data types
		initEDataType(iriEDataType, String.class, "IRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(localNameEDataType, String.class, "LocalName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalValueEDataType, String.class, "LexicalValue", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalNumberEDataType, String.class, "LexicalNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lexicalTimeEDataType, String.class, "LexicalTime", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(patternEDataType, String.class, "Pattern", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uuidEDataType, String.class, "UUID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(langRangeEDataType, String.class, "LangRange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(abbrevIRIEDataType, String.class, "AbbrevIRI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(namespacePrefixEDataType, String.class, "NamespacePrefix", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http://imce.jpl.nasa.gov/oml/Glossary
		createGlossaryAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotSchema
		createNotSchemaAnnotations();
		// http://imce.jpl.nasa.gov/oml/IsOrderingKey
		createIsOrderingKeyAnnotations();
		// http://imce.jpl.nasa.gov/oml/Collection
		createCollectionAnnotations();
		// http://imce.jpl.nasa.gov/oml/ValueTable
		createValueTableAnnotations();
		// http://imce.jpl.nasa.gov/oml/NotFunctionalAPI
		createNotFunctionalAPIAnnotations();
		// http://imce.jpl.nasa.gov/oml/CopyConstructor
		createCopyConstructorAnnotations();
		// http://imce.jpl.nasa.gov/oml/Override
		createOverrideAnnotations();
		// http://imce.jpl.nasa.gov/oml/Scala
		createScalaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "Collection", "http://imce.jpl.nasa.gov/oml/Collection",
			 "Override", "http://imce.jpl.nasa.gov/oml/Override",
			 "NotFunctionalAPI", "http://imce.jpl.nasa.gov/oml/NotFunctionalAPI",
			 "NotSchema", "http://imce.jpl.nasa.gov/oml/NotSchema",
			 "ValueTable", "http://imce.jpl.nasa.gov/oml/ValueTable",
			 "Scala", "http://imce.jpl.nasa.gov/oml/Scala",
			 "IsOrderingKey", "http://imce.jpl.nasa.gov/oml/IsOrderingKey",
			 "CopyConstructor", "http://imce.jpl.nasa.gov/oml/CopyConstructor",
			 "Glossary", "http://imce.jpl.nasa.gov/oml/Glossary"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Glossary</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGlossaryAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Glossary";	
		addAnnotation
		  (resourceEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyThingEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationEntryEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyExtentEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (contextEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBoxEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (bundleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyGraphKindEEnum, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyGraphEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBoxStatementEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBundleStatementEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (termEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unaryTermKindEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (directedBinaryRelationshipKindEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptualEntityEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (aspectEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unreifiedRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (datatypeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipDomainEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipFromEntityEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationshipFromEntity_IsIdentityCriteria(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipFromStructureEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipToScalarEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataRelationshipToStructureEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityStructuredDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (structuredDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarDataPropertyEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (structureEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (axiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBoxAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyBundleAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptTreeDisjunctionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (disjointUnionOfConceptsAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (specificDisjointConceptAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (anonymousConceptTaxonomyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (rootConceptTaxonomyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (bundledTerminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptDesignationTerminologyAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyExtensionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyNestingAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (termAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityExistentialRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityUniversalRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (specializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (aspectSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipSpecializationAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyExistentialRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyUniversalRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (entityScalarDataPropertyParticularRestrictionAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (restrictedDataRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (binaryScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (iriScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (numericScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (plainLiteralScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (stringScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (timeScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (synonymScalarRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarOneOfRestrictionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarOneOfLiteralAxiomEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (descriptionKindEEnum, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (descriptionBoxEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (descriptionBoxRelationshipEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (descriptionBoxExtendsClosedWorldDefinitionsEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (descriptionBoxRefinementEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyInstanceAssertionEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (singletonInstanceEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (scalarDataPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (structuredDataPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (dataStructureTupleEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptualEntitySingletonInstanceEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (conceptInstanceEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipInstanceEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipInstanceDomainEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (reifiedRelationshipInstanceRangeEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (unreifiedRelationshipInstanceTupleEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/NotSchema</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNotSchemaAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/NotSchema";	
		addAnnotation
		  (getResource__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getResource__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyThing__CalculateUUID(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationPropertyTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (terminologyExtentEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__Extent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__CalculateUUID(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__NsPrefix(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__AnnotationsByProperty(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext_Annotations(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Entities(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Aspects(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Concepts(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__ReifiedRelationships(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__UnreifiedRelationships(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__DataRelationships(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__EntityScalarDataProperties(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Dataranges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Scalars(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Structures(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__TermAxioms(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox__Everything(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox_TerminologyBoxAxioms(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBox_BoxStatements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__Extent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__AnnotationsByProperty(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__WithBundleStatements__EList(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__Everything(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle_BundleExtent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle_BundleStatements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle_TerminologyBundleAxioms(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__Extent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__AnnotationsByProperty(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph_GraphExtent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__CalculateUUID(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDirectedBinaryRelationshipKind__RelationshipSubject(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDirectedBinaryRelationshipKind__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRelationship__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityRelationship__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__RelationDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDataRelationship__RelationRange(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom_DesignatedTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__CalculateUUID(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__ExtendingTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__NestedTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__CalculateUUID(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_TerminologyExtent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBoxRelationship__DescriptionDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBoxRelationship__ContextTarget(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__DescriptionDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBoxExtendsClosedWorldDefinitions__ContextTarget(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBoxRefinement__DescriptionDomain(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBoxRefinement__ContextTarget(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion__DescriptionBox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion__CalculateUUID(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion__Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__ConceptualEntitySingletonClassifier(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__IdentifyingScalarValues(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__IdentifyingStructuredTuples(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptInstance__ConceptualEntitySingletonClassifier(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/IsOrderingKey</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createIsOrderingKeyAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/IsOrderingKey";	
		addAnnotation
		  (getTerminologyThing_Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationProperty__Uuid(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationPropertyTable_Key(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationEntry_Context(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationEntry_Subject(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotationEntry_Value(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Context(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Property(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Subject(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAnnotation_Value(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Collection";	
		addAnnotation
		  (getAnnotationPropertyTable_Value(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyExtent_AnnotationProperties(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyExtent_TerminologyGraphs(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyExtent_Bundles(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyExtent_Descriptions(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getContext__AnnotationsByProperty(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getContext__WithAnnotations__EMap()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getContext_Annotations(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getTerminologyBox__WithBoxStatements__EList()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Entities(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Aspects(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Concepts(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__ReifiedRelationships(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__UnreifiedRelationships(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__DataRelationships(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__EntityScalarDataProperties(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Dataranges(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Scalars(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Structures(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__TermAxioms(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox__Everything(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox_TerminologyBoxAxioms(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyBox_BoxStatements(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getBundle__WithAnnotations__EMap()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getBundle__AnnotationsByProperty(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getBundle__WithBundleStatements__EList()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getBundle__WithBoxStatements__EList()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getBundle__Everything(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getBundle_BundleStatements(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getBundle_TerminologyBundleAxioms(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getTerminologyGraph__WithAnnotations__EMap()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getTerminologyGraph__AnnotationsByProperty(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  ((getTerminologyGraph__WithBoxStatements__EList()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_ClosedWorldDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_DescriptionBoxRefinements(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_ConceptInstances(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstances(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceDomains(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceRanges(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getDescriptionBox_UnreifiedRelationshipInstanceTuples(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getSingletonInstance_ScalarDataPropertyValues(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getSingletonInstance_StructuredDataPropertyValues(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__IdentifyingScalarValues(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__IdentifyingStructuredTuples(), 
		   source, 
		   new String[] {
			 "kind", "SortedSet"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/ValueTable</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createValueTableAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/ValueTable";	
		addAnnotation
		  (annotationEntryEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/NotFunctionalAPI</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNotFunctionalAPIAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/NotFunctionalAPI";	
		addAnnotation
		  (annotationSubjectTableEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (annotationSubjectPropertyValueEClass, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getContext__AnnotationsBySubject(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/CopyConstructor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCopyConstructorAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/CopyConstructor";	
		addAnnotation
		  (getTerminologyExtent_AnnotationProperties(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtent_TerminologyGraphs(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtent_Bundles(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtent_Descriptions(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBoxAxiom_Tbox(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyBundleAxiom_TerminologyBundle(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom_BundledTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom_DesignatedTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom_ExtendedTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom_NestingTerminology(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_ClosedWorldDefinitions(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_DescriptionBoxRefinements(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_ConceptInstances(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstances(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceDomains(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_ReifiedRelationshipInstanceRanges(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getDescriptionBox_UnreifiedRelationshipInstanceTuples(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSingletonInstance_ScalarDataPropertyValues(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSingletonInstance_StructuredDataPropertyValues(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Override</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOverrideAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Override";	
		addAnnotation
		  (getContext_Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__AnnotationsByProperty(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundle__Everything(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__AnnotationsByProperty(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyGraph__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerm_Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getEntityScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getStructuredDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getScalarDataProperty__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getBundledTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyExtensionAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Source(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__Target(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAspectSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Child(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipSpecializationAxiom__Parent(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion__Iri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion_Name(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getConceptInstance__ConceptualEntitySingletonClassifier(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReifiedRelationshipInstance__ConceptualEntitySingletonClassifier(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://imce.jpl.nasa.gov/oml/Scala</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createScalaAnnotations() {
		String source = "http://imce.jpl.nasa.gov/oml/Scala";	
		addAnnotation
		  (getTerminologyBox__Entities(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case e: Entity => e }"
		   });	
		addAnnotation
		  (getTerminologyBox__Aspects(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case a: Aspect => a }"
		   });	
		addAnnotation
		  (getTerminologyBox__Concepts(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case c: Concept => c }"
		   });	
		addAnnotation
		  (getTerminologyBox__ReifiedRelationships(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case rr: ReifiedRelationship => rr }"
		   });	
		addAnnotation
		  (getTerminologyBox__UnreifiedRelationships(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case ur: UnreifiedRelationship => ur }"
		   });	
		addAnnotation
		  (getTerminologyBox__DataRelationships(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case dr: DataRelationship => dr }"
		   });	
		addAnnotation
		  (getTerminologyBox__EntityScalarDataProperties(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case dp: EntityScalarDataProperty => dp }"
		   });	
		addAnnotation
		  (getTerminologyBox__Dataranges(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case dr: DataRange => dr }"
		   });	
		addAnnotation
		  (getTerminologyBox__Scalars(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case s: Scalar => s }"
		   });	
		addAnnotation
		  (getTerminologyBox__Structures(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case s: Structure => s }"
		   });	
		addAnnotation
		  (getTerminologyBox__TermAxioms(), 
		   source, 
		   new String[] {
			 "code", "boxStatements.selectByKindOf { case tx: TermAxiom => tx }"
		   });	
		addAnnotation
		  (getTerminologyBox__Everything(), 
		   source, 
		   new String[] {
			 "code", "scala.collection.immutable.SortedSet.empty[resolver.api.TerminologyThing] ++ boxStatements + this"
		   });	
		addAnnotation
		  (getBundle__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
			 "code", "copy(annotations = this.annotations ++ resolver.convertToAnnotations(a))"
		   });	
		addAnnotation
		  (getBundle__AnnotationsByProperty(), 
		   source, 
		   new String[] {
			 "code", "resolver.groupAnnotationsByProperty(annotations)"
		   });	
		addAnnotation
		  (getBundle__WithBundleStatements__EList(), 
		   source, 
		   new String[] {
			 "code", "copy(bundleStatements = this.bundleStatements ++ s)"
		   });	
		addAnnotation
		  (getBundle__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
			 "code", "copy(boxStatements = this.boxStatements ++ s)"
		   });	
		addAnnotation
		  (getBundle__Everything(), 
		   source, 
		   new String[] {
			 "code", "super.everything() ++ bundleStatements + this"
		   });	
		addAnnotation
		  (getTerminologyGraph__WithAnnotations__EMap(), 
		   source, 
		   new String[] {
			 "code", "copy(annotations = this.annotations ++ resolver.convertToAnnotations(a))"
		   });	
		addAnnotation
		  (getTerminologyGraph__AnnotationsByProperty(), 
		   source, 
		   new String[] {
			 "code", "resolver.groupAnnotationsByProperty(annotations)"
		   });	
		addAnnotation
		  (getTerminologyGraph__WithBoxStatements__EList(), 
		   source, 
		   new String[] {
			 "code", "copy(boxStatements = this.boxStatements ++ s)"
		   });	
		addAnnotation
		  (getTerm__Iri(), 
		   source, 
		   new String[] {
			 "code", "graph.iri + \"#\" + name"
		   });	
		addAnnotation
		  (getConceptDesignationTerminologyAxiom__DesignationTerminologyGraph(), 
		   source, 
		   new String[] {
			 "code", "terminology match { case g: TerminologyGraph => g }"
		   });	
		addAnnotation
		  (getTerminologyNestingAxiom__NestedTerminology(), 
		   source, 
		   new String[] {
			 "code", "terminology match { case g: TerminologyGraph => g }"
		   });	
		addAnnotation
		  (getTerminologyInstanceAssertion__Iri(), 
		   source, 
		   new String[] {
			 "code", "descriptionBox.iri + \"#\" + name"
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__IdentifyingScalarValues(), 
		   source, 
		   new String[] {
			 "code", "scalarDataPropertyValues.filter{ v =>\n\t  v.scalarDataProperty match {\n\t    case ep: EntityScalarDataProperty =>\n\t\t  ep.isIdentityCriteria\n\t    case _ =>\n\t      false\n\t  }}"
		   });	
		addAnnotation
		  (getConceptualEntitySingletonInstance__IdentifyingStructuredTuples(), 
		   source, 
		   new String[] {
			 "code", "structuredDataPropertyValues.filter{ v =>\n\t  v.structuredDataProperty match {\n\t    case ep: EntityStructuredDataProperty =>\n\t\t  ep.isIdentityCriteria\n\t    case _ =>\n\t      false\n\t  }}"
		   });
	}

} //OMLPackageImpl
