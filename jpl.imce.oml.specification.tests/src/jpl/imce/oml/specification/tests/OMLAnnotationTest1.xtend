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
import gov.nasa.jpl.imce.oml.common.Extent
import gov.nasa.jpl.imce.oml.terminologies.Aspect
import gov.nasa.jpl.imce.oml.terminologies.TerminologyBox
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(OntologicalModelingLanguageInjectorProvider)
class OMLAnnotationTest1 {

	@Inject
	ParseHelper<Extent> parseHelper

	@Inject 
	extension ValidationTestHelper
	
	@Test 
	def void test() {
		
		
		val result = parseHelper.parse(
'''
annotationProperty rdfs:label=<http://www.w3.org/2000/01/rdf-schema#label>

open terminology <http://imce.jpl.nasa.gov/foundation/mission/mission>
{	
 aspect PerformingElement
 @rdfs:label = "Performing Element"
}
''')
		assertNotNull(result)
		result.assertNoErrors
		
		val r = result.eResource
		EcoreUtil.resolveAll(r)
		
		val ap = result.annotationProperties.head
		
		val tbox = result.modules.filter(TerminologyBox).head
		tbox.nsPrefix.assertEquals("mission")
		
		val pe = tbox.boxStatements.filter(Aspect).head
		pe.name().assertEquals("PerformingElement")
		
		val a = tbox.annotations.head
		val a_prop = a.property
		val a_subj = a.subject
		val a_value = a.value
		
		"Performing Element".assertEquals(a_value)
		ap.assertSame(a_prop)
		pe.assertSame(a_subj)
		
		System.out.println(this.class.name + " OK!")
	}

}
