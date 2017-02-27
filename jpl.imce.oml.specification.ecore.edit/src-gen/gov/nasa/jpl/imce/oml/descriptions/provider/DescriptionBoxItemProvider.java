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
package gov.nasa.jpl.imce.oml.descriptions.provider;


import gov.nasa.jpl.imce.oml.common.provider.ModuleItemProvider;

import gov.nasa.jpl.imce.oml.descriptions.DescriptionBox;
import gov.nasa.jpl.imce.oml.descriptions.OMLDFactory;
import gov.nasa.jpl.imce.oml.descriptions.OMLDPackage;

import java.util.Collection;
import java.util.List;

import jpl.imce.oml.specification.ecore.edit.provider.OMLEditPlugin;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link gov.nasa.jpl.imce.oml.descriptions.DescriptionBox} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DescriptionBoxItemProvider extends ModuleItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionBoxItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addKindPropertyDescriptor(object);
			addDescriptionExtentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Kind feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addKindPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DescriptionBox_kind_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DescriptionBox_kind_feature", "_UI_DescriptionBox_type"),
				 OMLDPackage.Literals.DESCRIPTION_BOX__KIND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description Extent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionExtentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DescriptionBox_descriptionExtent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DescriptionBox_descriptionExtent_feature", "_UI_DescriptionBox_type"),
				 OMLDPackage.Literals.DESCRIPTION_BOX__DESCRIPTION_EXTENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__CONCEPT_INSTANCES);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES);
			childrenFeatures.add(OMLDPackage.Literals.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DescriptionBox.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DescriptionBox"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DescriptionBox)object).getUuid();
		return label == null || label.length() == 0 ?
			getString("_UI_DescriptionBox_type") :
			getString("_UI_DescriptionBox_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DescriptionBox.class)) {
			case OMLDPackage.DESCRIPTION_BOX__KIND:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OMLDPackage.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS:
			case OMLDPackage.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS:
			case OMLDPackage.DESCRIPTION_BOX__CONCEPT_INSTANCES:
			case OMLDPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES:
			case OMLDPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS:
			case OMLDPackage.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES:
			case OMLDPackage.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__CLOSED_WORLD_DEFINITIONS,
				 OMLDFactory.eINSTANCE.createDescriptionBoxExtendsClosedWorldDefinitions()));

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__DESCRIPTION_BOX_REFINEMENTS,
				 OMLDFactory.eINSTANCE.createDescriptionBoxRefinement()));

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__CONCEPT_INSTANCES,
				 OMLDFactory.eINSTANCE.createConceptInstance()));

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCES,
				 OMLDFactory.eINSTANCE.createReifiedRelationshipInstance()));

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_DOMAINS,
				 OMLDFactory.eINSTANCE.createReifiedRelationshipInstanceDomain()));

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__REIFIED_RELATIONSHIP_INSTANCE_RANGES,
				 OMLDFactory.eINSTANCE.createReifiedRelationshipInstanceRange()));

		newChildDescriptors.add
			(createChildParameter
				(OMLDPackage.Literals.DESCRIPTION_BOX__UNREIFIED_RELATIONSHIP_INSTANCE_TUPLES,
				 OMLDFactory.eINSTANCE.createUnreifiedRelationshipInstanceTuple()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return OMLEditPlugin.INSTANCE;
	}

}