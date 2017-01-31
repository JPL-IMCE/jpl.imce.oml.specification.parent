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
 * A representation of the model object '<em><b>Entity Scalar Data Property Restriction Axiom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: OWL2 Data Property Restrictions
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jpl.imce.oml.specification.ecore.EntityScalarDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}</li>
 *   <li>{@link jpl.imce.oml.specification.ecore.EntityScalarDataPropertyRestrictionAxiom#getScalarProperty <em>Scalar Property</em>}</li>
 * </ul>
 *
 * @see jpl.imce.oml.specification.ecore.OMLPackage#getEntityScalarDataPropertyRestrictionAxiom()
 * @model abstract="true"
 * @generated
 */
public interface EntityScalarDataPropertyRestrictionAxiom extends TermAxiom {
	/**
	 * Returns the value of the '<em><b>Restricted Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Entity</em>' reference.
	 * @see #setRestrictedEntity(Entity)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getEntityScalarDataPropertyRestrictionAxiom_RestrictedEntity()
	 * @model required="true"
	 * @generated
	 */
	Entity getRestrictedEntity();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.EntityScalarDataPropertyRestrictionAxiom#getRestrictedEntity <em>Restricted Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Entity</em>' reference.
	 * @see #getRestrictedEntity()
	 * @generated
	 */
	void setRestrictedEntity(Entity value);

	/**
	 * Returns the value of the '<em><b>Scalar Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scalar Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scalar Property</em>' reference.
	 * @see #setScalarProperty(EntityScalarDataProperty)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getEntityScalarDataPropertyRestrictionAxiom_ScalarProperty()
	 * @model required="true"
	 * @generated
	 */
	EntityScalarDataProperty getScalarProperty();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.EntityScalarDataPropertyRestrictionAxiom#getScalarProperty <em>Scalar Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scalar Property</em>' reference.
	 * @see #getScalarProperty()
	 * @generated
	 */
	void setScalarProperty(EntityScalarDataProperty value);

} // EntityScalarDataPropertyRestrictionAxiom