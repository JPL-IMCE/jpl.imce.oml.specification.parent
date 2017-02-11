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

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * For the OML tabular interchange representation,
 * an OML AnnotationEntry (for a given OML AnnotationProperty) is a triple:
 * - an OML Context in which the OML AnnotationEntry appears
 * - an annotated OML TerminologyThing subject
 * - a String value as the representation of some information
 *   about the subject in that context.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link jpl.imce.oml.specification.ecore.AnnotationEntry#getContext <em>Context</em>}</li>
 *   <li>{@link jpl.imce.oml.specification.ecore.AnnotationEntry#getSubject <em>Subject</em>}</li>
 *   <li>{@link jpl.imce.oml.specification.ecore.AnnotationEntry#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see jpl.imce.oml.specification.ecore.OMLPackage#getAnnotationEntry()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface AnnotationEntry extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(Context)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getAnnotationEntry_Context()
	 * @model required="true"
	 * @generated
	 */
	Context getContext();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.AnnotationEntry#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Context value);

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' reference.
	 * @see #setSubject(TerminologyThing)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getAnnotationEntry_Subject()
	 * @model required="true"
	 * @generated
	 */
	TerminologyThing getSubject();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.AnnotationEntry#getSubject <em>Subject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' reference.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(TerminologyThing value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see jpl.imce.oml.specification.ecore.OMLPackage#getAnnotationEntry_Value()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link jpl.imce.oml.specification.ecore.AnnotationEntry#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // AnnotationEntry
