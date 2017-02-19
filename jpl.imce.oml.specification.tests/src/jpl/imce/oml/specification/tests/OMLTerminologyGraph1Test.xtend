/*
 * Copyright 2016 California Institute of Technology (\"Caltech\").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jpl.imce.oml.specification.tests

import com.google.inject.Inject
import jpl.imce.oml.specification.ecore.Concept
import jpl.imce.oml.specification.ecore.TerminologyExtent
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(XtextRunner)
@InjectWith(OntologicalModelingLanguageInjectorProvider)
class OMLTerminologyGraph1Test{

	@Inject
	ParseHelper<TerminologyExtent> parseHelper

	@Test 
	def void terminologyGraph1() {
		
		val result = parseHelper.parse(
'''
annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>

open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission>
{
	abstract concept PerformingElement
	@rdfs:label = "Performing Element"
}
''')
		assertNotNull(result)
		val errors = result.eResource.errors
		assertTrue(errors.empty)
		
		val r = result.eResource
		EcoreUtil.resolveAll(r)
		
		val ap = result.annotationProperties.head
		
		val tbox = result.terminologyGraphs.head
		tbox.nsPrefix.assertEquals("mission")
		
		val c = tbox.boxStatements.filter(Concept).head
		c.name().assertEquals("PerformingElement")
		
		val a = tbox.annotations.head
		val a_prop = a.property
		val a_subj = a.subject
		val a_value = a.value
		
		"Performing Element".assertEquals(a_value)
		ap.assertSame(a_prop)
		c.assertSame(a_subj)
		
		System.out.println(this.class.name + " OK!")
	}

}
