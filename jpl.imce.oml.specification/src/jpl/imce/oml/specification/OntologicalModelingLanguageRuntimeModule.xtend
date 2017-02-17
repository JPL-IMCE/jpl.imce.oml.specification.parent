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
package jpl.imce.oml.specification

import jpl.imce.oml.specification.linking.OWLLinkingService
import jpl.imce.oml.specification.scoping.OMLImportedNamespaceAwareLocalScopeProvider
import jpl.imce.oml.specification.util.OMLQualifiedNameConverter
import jpl.imce.oml.specification.util.OMLQualifiedNameProvider
import jpl.imce.oml.specification.util.OMLValueConverterService
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.linking.ILinkingService
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.formatting2.IFormatter2
import jpl.imce.oml.specification.formatting2.OntologicalModelingLanguageFormatter
import org.eclipse.xtext.IGrammarAccess
import jpl.imce.oml.specification.services.OntologicalModelingLanguageGrammarAccess

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class OntologicalModelingLanguageRuntimeModule extends AbstractOntologicalModelingLanguageRuntimeModule {
	
	override def Class<? extends ILinkingService> bindILinkingService() {
		OWLLinkingService
	}
	
	override def Class<? extends IScopeProvider> bindIScopeProvider() {
		OMLImportedNamespaceAwareLocalScopeProvider
	}
	
    override def Class<? extends IValueConverterService> bindIValueConverterService() {
        OMLValueConverterService
    }

    override def Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
        OMLQualifiedNameProvider
    }

	def Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
	    OMLQualifiedNameConverter
	}
	
	override def Class<? extends IGrammarAccess> bindIGrammarAccess() {
		OntologicalModelingLanguageGrammarAccess
	}
	
	override def Class<? extends IFormatter2> bindIFormatter2() {
		OntologicalModelingLanguageFormatter
	}
}
