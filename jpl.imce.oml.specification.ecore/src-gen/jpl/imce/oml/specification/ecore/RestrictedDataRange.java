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
 * A representation of the model object '<em><b>Restricted Data Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An OML RestrictedDataRange corresponds to an [OWL2 DataRange] defined in terms of some kind of restriction of some other OML DataRange.
 * Instead of arbitrary OWL2 FacetRestrictionAxioms as constructors of [OWL2 DataRange]s,
 * the specializations of RestrictedDataRange correspond to the allowed restrictions in OWL2-DL datatype maps.
 * Node that the vocabulary of XSD fundamental facets is not included in OWL2-DL, consequently,
 * there is no support in OML for specifying datatype restrictions involving XSD fundamental facets as well.
 * @see https://www.w3.org/TR/owl2-syntax/#Data_Ranges
 * @see https://www.w3.org/TR/owl2-syntax/#Datatype_Maps
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jpl.imce.oml.specification.ecore.RestrictedDataRange#getRestrictedRange <em>Restricted Range</em>}</li>
 * </ul>
 *
 * @see jpl.imce.oml.specification.ecore.OMLPackage#getRestrictedDataRange()
 * @model abstract="true"
 * @generated
 */
public interface RestrictedDataRange extends DataRange {
	/**
	 * Returns the value of the '<em><b>Restricted Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The restricted (general) data range of this data range (specific)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Restricted Range</em>' reference.
	 * @see #setRestrictedRange(DataRange)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getRestrictedDataRange_RestrictedRange()
	 * @model required="true"
	 * @generated
	 */
	DataRange getRestrictedRange();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.RestrictedDataRange#getRestrictedRange <em>Restricted Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Range</em>' reference.
	 * @see #getRestrictedRange()
	 * @generated
	 */
	void setRestrictedRange(DataRange value);

} // RestrictedDataRange
