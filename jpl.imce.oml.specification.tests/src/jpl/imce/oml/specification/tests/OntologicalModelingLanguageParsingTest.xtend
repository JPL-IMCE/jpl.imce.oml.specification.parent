/*
 * generated by Xtext 2.10.0
 */
package jpl.imce.oml.specification.tests

import com.google.inject.Inject
import jpl.imce.oml.specification.ecore.TerminologyExtent
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(OntologicalModelingLanguageInjectorProvider)
class OntologicalModelingLanguageParsingTest{

	@Inject
	ParseHelper<TerminologyExtent> parseHelper

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
	}

}