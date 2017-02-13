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

package gov.nasa.jpl.imce.oml.specification.resolver.impl

import gov.nasa.jpl.imce.oml.specification._

case class DescriptionBox private[impl] 
(
 override val uuid: java.util.UUID,
 override val closedWorldDefinitions: scala.collection.immutable.SortedSet[DescriptionBoxExtendsClosedWorldDefinitions],
 override val kind: resolver.api.DescriptionKind,
 override val iri: gov.nasa.jpl.imce.oml.specification.tables.IRI,
 override val annotations: scala.collection.immutable.SortedSet[Annotation],
 override val conceptInstances: scala.collection.immutable.SortedSet[ConceptInstance],
 override val descriptionBoxRefinements: scala.collection.immutable.SortedSet[DescriptionBoxRefinement],
 override val reifiedRelationshipInstanceDomains: scala.collection.immutable.SortedSet[ReifiedRelationshipInstanceDomain],
 override val reifiedRelationshipInstanceRanges: scala.collection.immutable.SortedSet[ReifiedRelationshipInstanceRange],
 override val reifiedRelationshipInstances: scala.collection.immutable.SortedSet[ReifiedRelationshipInstance],
 override val terminologyExtent: TerminologyExtent,
 override val unreifiedRelationshipInstanceTuples: scala.collection.immutable.SortedSet[UnreifiedRelationshipInstanceTuple]
)
extends resolver.api.DescriptionBox
  with Context
{

  override def canEqual(that: scala.Any): scala.Boolean = that match {
  	case _: DescriptionBox => true
  	case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, closedWorldDefinitions, kind, iri, annotations, conceptInstances, descriptionBoxRefinements, reifiedRelationshipInstanceDomains, reifiedRelationshipInstanceRanges, reifiedRelationshipInstances, terminologyExtent, unreifiedRelationshipInstanceTuples).##

  override def equals(other: scala.Any): scala.Boolean = other match {
	  case that: DescriptionBox =>
	    (that canEqual this) &&
	    (this.uuid == that.uuid) &&
	    (this.closedWorldDefinitions == that.closedWorldDefinitions) &&
	    (this.kind == that.kind) &&
	    (this.iri == that.iri) &&
	    (this.annotations == that.annotations) &&
	    (this.conceptInstances == that.conceptInstances) &&
	    (this.descriptionBoxRefinements == that.descriptionBoxRefinements) &&
	    (this.reifiedRelationshipInstanceDomains == that.reifiedRelationshipInstanceDomains) &&
	    (this.reifiedRelationshipInstanceRanges == that.reifiedRelationshipInstanceRanges) &&
	    (this.reifiedRelationshipInstances == that.reifiedRelationshipInstances) &&
	    (this.terminologyExtent == that.terminologyExtent) &&
	    (this.unreifiedRelationshipInstanceTuples == that.unreifiedRelationshipInstanceTuples)

	  case _ =>
	    false
  }
}