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

case class TimeScalarRestriction private[impl] 
(
 override val uuid: java.util.UUID,
 override val tbox: TerminologyBox,
 override val restrictedRange: DataRange,
 override val minExclusive: scala.Option[gov.nasa.jpl.imce.oml.specification.tables.LexicalTime],
 override val minInclusive: scala.Option[gov.nasa.jpl.imce.oml.specification.tables.LexicalTime],
 override val maxExclusive: scala.Option[gov.nasa.jpl.imce.oml.specification.tables.LexicalTime],
 override val maxInclusive: scala.Option[gov.nasa.jpl.imce.oml.specification.tables.LexicalTime],
 override val name: gov.nasa.jpl.imce.oml.specification.tables.LocalName
)
extends resolver.api.TimeScalarRestriction
  with RestrictedDataRange
{

  override def canEqual(that: scala.Any): scala.Boolean = that match {
  	case _: TimeScalarRestriction => true
  	case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, tbox, restrictedRange, minExclusive, minInclusive, maxExclusive, maxInclusive, name).##

  override def equals(other: scala.Any): scala.Boolean = other match {
	  case that: TimeScalarRestriction =>
	    (that canEqual this) &&
	    (this.uuid == that.uuid) &&
	    (this.tbox == that.tbox) &&
	    (this.restrictedRange == that.restrictedRange) &&
	    (this.minExclusive == that.minExclusive) &&
	    (this.minInclusive == that.minInclusive) &&
	    (this.maxExclusive == that.maxExclusive) &&
	    (this.maxInclusive == that.maxInclusive) &&
	    (this.name == that.name)

	  case _ =>
	    false
  }
}
