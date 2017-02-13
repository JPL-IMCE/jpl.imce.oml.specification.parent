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

 
package gov.nasa.jpl.imce.oml.specification.tables

import scala.annotation.meta.field
import scala.scalajs.js.annotation.JSExport
import scala._
import scala.Predef._

/**
  * @param uuid[1,1]
  * @param singletonInstanceUUID[1,1]
  * @param structuredDataPropertyUUID[1,1]
  * @param structuredPropertyTupleUUID[1,1]
  * @param name[1,1]
  */
@JSExport
case class StructuredDataPropertyValue
(
  @(JSExport @field) uuid: UUID,
  @(JSExport @field) singletonInstanceUUID: UUID,
  @(JSExport @field) structuredDataPropertyUUID: UUID,
  @(JSExport @field) structuredPropertyTupleUUID: UUID,
  @(JSExport @field) name: LocalName
) {
  override val hashCode
  : scala.Int 
  = (uuid, singletonInstanceUUID, structuredDataPropertyUUID, structuredPropertyTupleUUID, name).##
  
  override def equals(other: scala.Any): scala.Boolean = other match {
  	case that: StructuredDataPropertyValue =>
  	  (this.uuid == that.uuid) &&
  	  (this.singletonInstanceUUID == that.singletonInstanceUUID) &&
  	  (this.structuredDataPropertyUUID == that.structuredDataPropertyUUID) &&
  	  (this.structuredPropertyTupleUUID == that.structuredPropertyTupleUUID) &&
  	  (this.name == that.name)
    case _ =>
      false
  }
  
}

@JSExport
object StructuredDataPropertyValueHelper {

  val TABLE_JSON_FILENAME 
  : scala.Predef.String 
  = "StructuredDataPropertyValues.json"
  
  implicit val w
  : upickle.default.Writer[StructuredDataPropertyValue]
  = upickle.default.macroW[StructuredDataPropertyValue]

  @JSExport
  def toJSON(c: StructuredDataPropertyValue)
  : String
  = upickle.default.write(expr=c, indent=0)

  implicit val r
  : upickle.default.Reader[StructuredDataPropertyValue]
  = upickle.default.macroR[StructuredDataPropertyValue]

  @JSExport
  def fromJSON(c: String)
  : StructuredDataPropertyValue
  = upickle.default.read[StructuredDataPropertyValue](c)

}	
