/**
 * 
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package jpl.imce.oml.specification.ecore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminology Box Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML TerminologyBoxStatement is a logical axiom about an OML TerminologyThing
 * asserted in the context of an OML TerminologyBox.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jpl.imce.oml.specification.ecore.TerminologyBoxStatement#getTbox <em>Tbox</em>}</li>
 * </ul>
 *
 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTerminologyBoxStatement()
 * @model abstract="true"
 * @generated
 */
public interface TerminologyBoxStatement extends TerminologyThing {
	/**
	 * Returns the value of the '<em><b>Tbox</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link jpl.imce.oml.specification.ecore.TerminologyBox#getBoxStatements <em>Box Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tbox</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tbox</em>' container reference.
	 * @see #setTbox(TerminologyBox)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTerminologyBoxStatement_Tbox()
	 * @see jpl.imce.oml.specification.ecore.TerminologyBox#getBoxStatements
	 * @model opposite="boxStatements" required="true" transient="false"
	 * @generated
	 */
	TerminologyBox getTbox();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.TerminologyBoxStatement#getTbox <em>Tbox</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tbox</em>' container reference.
	 * @see #getTbox()
	 * @generated
	 */
	void setTbox(TerminologyBox value);

} // TerminologyBoxStatement
