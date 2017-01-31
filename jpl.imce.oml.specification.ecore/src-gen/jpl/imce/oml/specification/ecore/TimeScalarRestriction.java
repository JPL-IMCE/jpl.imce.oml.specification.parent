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
 * A representation of the model object '<em><b>Time Scalar Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A data range that specifies how one time scalar adds facet restrictions to another.
 * Applies when the restricted scalar represents time instants (OWL2: 4.7)
 * i.e., when it is one of the following scalars (or their transitively restricted ones):
 * xsd:dateTime
 * xsd:dateTimeStamp
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}</li>
 *   <li>{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMinExclusive <em>Min Exclusive</em>}</li>
 *   <li>{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}</li>
 * </ul>
 *
 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTimeScalarRestriction()
 * @model
 * @generated
 */
public interface TimeScalarRestriction extends RestrictedDataRange {
	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' attribute.
	 * @see #setMinInclusive(String)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTimeScalarRestriction_MinInclusive()
	 * @model unique="false" dataType="jpl.imce.oml.specification.ecore.LexicalTime"
	 * @generated
	 */
	String getMinInclusive();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMinInclusive <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' attribute.
	 * @see #getMinInclusive()
	 * @generated
	 */
	void setMinInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' attribute.
	 * @see #setMaxInclusive(String)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTimeScalarRestriction_MaxInclusive()
	 * @model unique="false" dataType="jpl.imce.oml.specification.ecore.LexicalTime"
	 * @generated
	 */
	String getMaxInclusive();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMaxInclusive <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' attribute.
	 * @see #getMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(String value);

	/**
	 * Returns the value of the '<em><b>Min Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive minimum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Exclusive</em>' attribute.
	 * @see #setMinExclusive(String)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTimeScalarRestriction_MinExclusive()
	 * @model unique="false" dataType="jpl.imce.oml.specification.ecore.LexicalTime"
	 * @generated
	 */
	String getMinExclusive();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMinExclusive <em>Min Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Exclusive</em>' attribute.
	 * @see #getMinExclusive()
	 * @generated
	 */
	void setMinExclusive(String value);

	/**
	 * Returns the value of the '<em><b>Max Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The exclusive maximum value in the range
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max Exclusive</em>' attribute.
	 * @see #setMaxExclusive(String)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getTimeScalarRestriction_MaxExclusive()
	 * @model unique="false" dataType="jpl.imce.oml.specification.ecore.LexicalTime"
	 * @generated
	 */
	String getMaxExclusive();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.TimeScalarRestriction#getMaxExclusive <em>Max Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Exclusive</em>' attribute.
	 * @see #getMaxExclusive()
	 * @generated
	 */
	void setMaxExclusive(String value);

} // TimeScalarRestriction