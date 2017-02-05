/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */
package gov.nasa.jpl.imce.oml.specification.scala.generators

import java.io.File
import java.io.FileOutputStream
import java.nio.file.Paths
import java.util.List
import java.util.Map
import jpl.imce.oml.specification.ecore.OMLPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.util.EcoreUtil

class OMLSpecificationResolverAPIGenerator extends OMLUtilities {
	
	static def main(String[] args) {
		if (1 != args.length) {
			System.err.println("usage: <dir> where <dir> is the directory of the /gov.nasa.jpl.imce.oml.specification.tables project")
			System.exit(1)
		}
		
		new OMLSpecificationResolverAPIGenerator().generate(args.get(0))	
	}
	
	def generate(String targetDir) {
		val omlXcore = "/model/OMLSpecification.xcore"
		val set = createXcoreResourceSet(
			[Map<URI,URI> uriMap | 
			uriMap.put(
				URI.createURI("platform:/resource/jpl.imce.oml.specification.ecore"+omlXcore),
				URI.createURI(OMLPackage.getResource(omlXcore).toURI.toString))
				])
		
      	val sourceURI = URI.createPlatformResourceURI("/jpl.imce.oml.specification.ecore"+omlXcore, false)
      	val sourceResource = set.getResource(sourceURI, true)
      	EcoreUtil.resolveAll(set)
      	val ePackage = sourceResource.getContents().filter(EPackage).get(0)
      	
		val bundlePath = Paths.get(targetDir)
		val targetFolder = "shared/src/main/scala/gov/nasa/jpl/imce/oml/specification/resolver/api"
		val targetPath = bundlePath.resolve(targetFolder)
		targetPath.toFile.mkdirs	
		
      	generate(
      		ePackage, 
      		"gov.nasa.jpl.imce.oml.specification.resolver.api", 
      		targetPath.toAbsolutePath.toString
      	)      	
	}
	
	def generate(EPackage ePackage, String packageQName, String targetFolder) {
		val packageFile = new FileOutputStream(new File(targetFolder + File::separator + "package.scala"))
		packageFile.write(generatePackageFile(ePackage, packageQName).bytes)
		val factoryFile = new FileOutputStream(new File(targetFolder + File::separator + "OMLResolvedFactory.scala"))
		factoryFile.write(generateFactoryFile(ePackage, packageQName).bytes)
		for(eClass : ePackage.EClassifiers.filter(EClass).filter[isAPI])  {
			val classFile = new FileOutputStream(new File(targetFolder + File::separator + eClass.name + ".scala"))
			classFile.write(generateClassFile(eClass).bytes)
		}
	}
	
	def String generatePackageFile(EPackage ePackage, String packageQName) '''
		«copyright»

		package «packageQName.substring(0, packageQName.lastIndexOf('.'))»
		
		package object «packageQName.substring(packageQName.lastIndexOf('.')+1)» {
			
		  «FOR eClass: ePackage.FunctionalAPIClasses.filter[!orderingKeys.isEmpty].sortBy[name]»
		  implicit def «eClass.name.toFirstLower»Ordering
		  : scala.Ordering[«eClass.name»]
		  = new scala.Ordering[«eClass.name»] {
		  	def compare(x: «eClass.name», y: «eClass.name»)
		  	: scala.Int
		  	= «FOR keyFeature: eClass.orderingKeys»«IF (keyFeature.isClassFeature)»«keyFeature.EType.name.toFirstLower»Ordering.compare(x.«keyFeature.name»,y.«keyFeature.name»)«ELSE»x.«keyFeature.columnName».compareTo(y.«keyFeature.columnName»)«ENDIF» match {
		  	 	case c_«keyFeature.name» if 0 != c_«keyFeature.name» => c_«keyFeature.name»
		  	 	case 0 => «ENDFOR»«FOR keyFeature: eClass.orderingKeys BEFORE "0 }" SEPARATOR " }"»«ENDFOR»
		  }
		  
		  «ENDFOR»
		}
	'''
	
	def String generateFactoryFile(EPackage ePackage, String packageQName) '''
		«copyright»
		package «packageQName»
		
		trait OMLResolvedFactory {
			
		  «FOR eClass: ePackage.FunctionalAPIClasses.filter[!isAbstract].sortBy[name]»
		  // «eClass.name»
		  
		  def create«eClass.name»
		  «FOR attr : eClass.getSortedAttributeSignature BEFORE "(" SEPARATOR ",\n " AFTER " )"» «attr.name»: «attr.queryResolverType»«ENDFOR»
		  : «eClass.name»
		  
		  «FOR attr: eClass.lookupCopyConstructorArguments»
		  def copy«eClass.name»_«attr.name»
		  ( that: «eClass.name»,
		    «attr.name»: «attr.queryResolverType» )
		  : «eClass.name»
		  
		  «ENDFOR»
		  «ENDFOR»
		}
	'''
	
	def String generateClassFile(EClass eClass) '''
		«copyright»
		package gov.nasa.jpl.imce.oml.specification.resolver.api
		
		«eClass.doc("")»«eClass.traitDeclaration»
		{
		«FOR f : eClass.APIStructuralFeatures BEFORE "\n  " SEPARATOR "\n  " AFTER "\n"»«f.doc("  ")»«IF (f.isOverride)»override «ENDIF»val «f.name»: «f.queryResolverType»«ENDFOR»
		«FOR op : eClass.APIOperations BEFORE "\n  " SEPARATOR "\n  " AFTER "\n"»«op.doc("  ")»«op.queryResolverName»: «op.queryResolverType»«ENDFOR»
		«IF (eClass.isRootHierarchyClass)»
		  
		  def canEqual(that: scala.Any): scala.Boolean
		«ENDIF»
		}
	'''
	
	static def List<EStructuralFeature> getSortedAttributeSignature(EClass eClass) {
		eClass
		.selfAndAllSupertypes
		.map[EStructuralFeatures]
		.flatten
		.sortWith(new OMLFeatureCompare())
	}
	
	static def List<EStructuralFeature> getSortedAttributes(EClass eClass) {
		eClass
		.selfAndAllSupertypes
		.map[EStructuralFeatures]
		.flatten
		.filter([EStructuralFeature f | isAttributeOrReferenceOrContainer(f) && isSchema(f)])
		.sortWith(new OMLFeatureCompare())
	}
	
	static def Boolean isAuxiliaryClass(EClass eClass) {
		eClass.isAbstract && eClass.ESuperTypes.isEmpty && eClass.EStructuralFeatures.isEmpty
	}
	
	static def Boolean isRootHierarchyClass(EClass eClass) {
		eClass.isAbstract && eClass.ESuperTypes.isEmpty && !eClass.orderingKeys.isEmpty
	}
	
	static def Boolean isSpecializationOfRootClass(EClass eClass) {
		!eClass.ESuperTypes.isEmpty && eClass.selfAndAllSupertypes.exists[isRootHierarchyClass]
	}
	
	static def String traitDeclaration(EClass eClass) '''
		trait «eClass.name»
		«FOR parent : eClass.ESuperTypes BEFORE "  extends " SEPARATOR "\n  with "»«parent.name»«ENDFOR»
	'''
	
	static def Boolean isAttributeOrReferenceOrContainer(EStructuralFeature f) {
		switch f {
			EReference: 
				! f.containment
			default: true
		}
	}
	
	static def String queryName(EStructuralFeature feature) {
		feature.name
	}
	
	static def Boolean isClassFeature(ETypedElement feature) {
		val type = feature.EType
		type instanceof EClass
	}
	
	static def Boolean isOverride(ETypedElement feature) {
		null !== feature.getEAnnotation("http://imce.jpl.nasa.gov/oml/Override")
	}
	
	static def Iterable<EStructuralFeature> lookupCopyConstructorArguments(EClass eClass) {
		eClass.getSortedAttributeSignature.filter[isCopyConstructorArgument]
	}
	
	static def Boolean isCopyConstructorArgument(EStructuralFeature attribute) {
		null !== attribute.getEAnnotation("http://imce.jpl.nasa.gov/oml/CopyConstructor")
	}
	
	static def Iterable<EStructuralFeature> APIStructuralFeatures(EClass eClass) {
		eClass.EStructuralFeatures.filter[isAPI]
	}
    
	static def Iterable<EClass> FunctionalAPIClasses(EPackage ePkg) {
		ePkg.EClassifiers.filter(EClass).filter[isAPI]
	}
    
	static def Iterable<EOperation> APIOperations(EClass eClass) {
		eClass.EOperations.filter[isAPI]
	}
    
}