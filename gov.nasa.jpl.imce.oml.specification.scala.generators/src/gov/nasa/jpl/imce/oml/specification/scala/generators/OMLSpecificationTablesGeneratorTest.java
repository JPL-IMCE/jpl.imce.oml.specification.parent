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
package gov.nasa.jpl.imce.oml.specification.scala.generators;

import junit.framework.TestCase;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Terminology Thing</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMLSpecificationTablesGeneratorTest extends TestCase {

	public OMLSpecificationTablesGeneratorTest(String name) {
		super(name);
	}

	public void testGenerate() {
		new OMLSpecificationTablesGenerator().generate("../gov.nasa.jpl.imce.oml.specification.tables");
	}
	
}