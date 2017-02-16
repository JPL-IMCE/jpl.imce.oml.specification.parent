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

case class EntityScalarDataPropertyExistentialRestrictionAxiom private[impl] 
(
 override val tbox: resolver.api.TerminologyBox,
 override val restrictedEntity: resolver.api.Entity,
 override val scalarProperty: resolver.api.EntityScalarDataProperty,
 override val scalarRestriction: resolver.api.DataRange
)
extends resolver.api.EntityScalarDataPropertyExistentialRestrictionAxiom
  with EntityScalarDataPropertyRestrictionAxiom
{
  override def calculateUUID
  ()
  : java.util.UUID
  = {
    
    	val namespace = "EntityScalarDataPropertyExistentialRestrictionAxiom(restrictedEntity="+restrictedEntity.uuid+",scalarProperty="+scalarProperty.calculateUUID()+",scalarRestriction="+scalarRestriction.uuid+")"
    	com.fasterxml.uuid.Generators.nameBasedGenerator(com.fasterxml.uuid.impl.NameBasedGenerator.NAMESPACE_URL).generate(namespace)
  }
  

  override val uuid
  : java.util.UUID
  = {
    calculateUUID()
  }
  


  override def canEqual(that: scala.Any): scala.Boolean = that match {
  	case _: EntityScalarDataPropertyExistentialRestrictionAxiom => true
  	case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, tbox, restrictedEntity, scalarProperty, scalarRestriction).##

  override def equals(other: scala.Any): scala.Boolean = other match {
	  case that: EntityScalarDataPropertyExistentialRestrictionAxiom =>
	    (that canEqual this) &&
	    (this.uuid == that.uuid) &&
	    (this.tbox == that.tbox) &&
	    (this.restrictedEntity == that.restrictedEntity) &&
	    (this.scalarProperty == that.scalarProperty) &&
	    (this.scalarRestriction == that.scalarRestriction)

	  case _ =>
	    false
  }
}
