package jpl.imce.oml.specification.scoping

import com.google.common.base.Function
import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.ArrayList
import jpl.imce.oml.specification.ecore.Annotation
import jpl.imce.oml.specification.ecore.AspectSpecializationAxiom
import jpl.imce.oml.specification.ecore.BundledTerminologyAxiom
import jpl.imce.oml.specification.ecore.ConceptDesignationTerminologyAxiom
import jpl.imce.oml.specification.ecore.EntityRelationship
import jpl.imce.oml.specification.ecore.Resource
import jpl.imce.oml.specification.ecore.TerminologyBox
import jpl.imce.oml.specification.ecore.TerminologyExtensionAxiom
import jpl.imce.oml.specification.ecore.TerminologyThing
import jpl.imce.oml.specification.ecore.extensions.OMLExtensions
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SimpleScope

class OMLScopeExtensions {
	
	@Inject extension OMLExtensions
	
	@Inject IQualifiedNameConverter qnc
	
	/*
	 * The syntax of Annotation involves "@<annotation property abbrev IRI> = <annotation value>".
	 * Therefore, construct the resolvable scope of AnnotationProperties
	 * in terms of the abbrevIRI of each AnnotationProperty in the TerminologyExtent.
	 */
	def scope_Annotation_property(Annotation context, EReference eRef) {
		Scopes.scopeFor(
			context.terminology.extent.annotationProperties,
			[ qnc.toQualifiedName(it.abbrevIRI) ],
			IScope.NULLSCOPE)	
	}
	
	def scope_AspectSpecializationAxiom_subEntity(AspectSpecializationAxiom context) {
		context.graph.allEntitiesScope
	}
	
	def scope_AspectSpecializationAxiom_superAspect(AspectSpecializationAxiom context) {
		context.graph.allAspectsScope
	}
	
	def scope_BundledTerminologyAxiom_bundledTerminology(BundledTerminologyAxiom context) {
		Scopes.scopeFor(
			context.terminologyBundle.extent.terminologies,
			[ qnc.toQualifiedName(it.nsPrefix) ],
			IScope.NULLSCOPE)	
	}
	
	def scope_ConceptDesignationTerminologyAxiom_designatedTerminology(ConceptDesignationTerminologyAxiom context) {
		Scopes.scopeFor(
			context.terminology.extent.terminologies,
			[ qnc.toQualifiedName(it.nsPrefix) ],
			IScope.NULLSCOPE)	
	}
	
	def scope_ConceptDesignationTerminologyAxiom_designatedConcept(ConceptDesignationTerminologyAxiom context) {
		context.designatedTerminology.allConceptsScope
	}
	
	def scope_EntityRelationship(EntityRelationship context) {
		context.graph.allEntitiesScope
	}
	
	
	/*
	 * The syntax of TerminologyExtensionAxioms involves "extends <extended terminology prefix>".
	 * Therefore, construct the resolvable scope of TerminologyBoxes
	 * in terms of the nsPrefix of each TerminologyBox in the TerminologyExtent.
	 */
	def scope_TerminologyExtensionAxiom_extendedTerminology(TerminologyExtensionAxiom context, EReference eRef) {
		val ext = context.terminology.extent
		val tboxes = ext.terminologyGraphs + ext.bundles
		Scopes.scopeFor(
			tboxes,
			[qnc.toQualifiedName(it.nsPrefix) ], 
			IScope.NULLSCOPE)
	}
	
	// =================================================
	
	/*
	 * Computes an IScope for 
	 */
	def <T extends TerminologyThing> IScope terminologyScope(
		TerminologyBox tbox,
		Function<TerminologyBox, Iterable<T>> localScopeFunction,
		Function<Pair<TerminologyBox, T>, QualifiedName> nameFunction
	) {
		val ArrayList<IEObjectDescription> result = Lists.newArrayList()
		result.addAll(Scopes.scopedElementsFor(localScopeFunction.apply(tbox)))
		result.addAll(tbox.allImportedTerminologies.map[importedTbox|
			Scopes.scopedElementsFor(
				localScopeFunction.apply(importedTbox), 
				[importedThing| nameFunction.apply(Pair.of(importedTbox, importedThing)) ]
			)
		].flatten)
		new SimpleScope(result)
	}
	
	def <T extends Resource> QualifiedName importedResourceNameFunction(Pair<TerminologyBox, T> p) {
		qnc.toQualifiedName(p.key.nsPrefix + ":" + p.value.name())
	}
	
	def IScope allEntitiesScope(TerminologyBox tbox) {
		terminologyScope(tbox, [localEntities], [importedResourceNameFunction])
	}
	
	def IScope allAspectsScope(TerminologyBox tbox) {
		terminologyScope(tbox, [localAspects], [importedResourceNameFunction])
	}
	
	def IScope allConceptsScope(TerminologyBox tbox) {
		terminologyScope(tbox, [localConcepts], [importedResourceNameFunction])
	}
	
	def IScope allReifiedRelationshipsScope(TerminologyBox tbox) {
		terminologyScope(tbox, [localReifiedRelationships], [importedResourceNameFunction])
	}
	
}