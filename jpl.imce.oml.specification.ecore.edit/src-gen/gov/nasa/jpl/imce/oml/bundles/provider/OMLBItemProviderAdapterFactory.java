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
package gov.nasa.jpl.imce.oml.bundles.provider;

import gov.nasa.jpl.imce.oml.bundles.OMLBFactory;

import gov.nasa.jpl.imce.oml.bundles.util.OMLBAdapterFactory;

import gov.nasa.jpl.imce.oml.extents.OMLEPackage;
import gov.nasa.jpl.imce.oml.extents.TerminologyExtent;

import gov.nasa.jpl.imce.oml.extents.util.OMLESwitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jpl.imce.oml.specification.ecore.edit.provider.OMLEditPlugin;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OMLBItemProviderAdapterFactory extends OMLBAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMLBItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.bundles.Bundle} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleItemProvider bundleItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.bundles.Bundle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBundleAdapter() {
		if (bundleItemProvider == null) {
			bundleItemProvider = new BundleItemProvider(this);
		}

		return bundleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.bundles.SpecificDisjointConceptAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificDisjointConceptAxiomItemProvider specificDisjointConceptAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.bundles.SpecificDisjointConceptAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSpecificDisjointConceptAxiomAdapter() {
		if (specificDisjointConceptAxiomItemProvider == null) {
			specificDisjointConceptAxiomItemProvider = new SpecificDisjointConceptAxiomItemProvider(this);
		}

		return specificDisjointConceptAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.bundles.AnonymousConceptTaxonomyAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnonymousConceptTaxonomyAxiomItemProvider anonymousConceptTaxonomyAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.bundles.AnonymousConceptTaxonomyAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAnonymousConceptTaxonomyAxiomAdapter() {
		if (anonymousConceptTaxonomyAxiomItemProvider == null) {
			anonymousConceptTaxonomyAxiomItemProvider = new AnonymousConceptTaxonomyAxiomItemProvider(this);
		}

		return anonymousConceptTaxonomyAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.bundles.RootConceptTaxonomyAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootConceptTaxonomyAxiomItemProvider rootConceptTaxonomyAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.bundles.RootConceptTaxonomyAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRootConceptTaxonomyAxiomAdapter() {
		if (rootConceptTaxonomyAxiomItemProvider == null) {
			rootConceptTaxonomyAxiomItemProvider = new RootConceptTaxonomyAxiomItemProvider(this);
		}

		return rootConceptTaxonomyAxiomItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link gov.nasa.jpl.imce.oml.bundles.BundledTerminologyAxiom} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundledTerminologyAxiomItemProvider bundledTerminologyAxiomItemProvider;

	/**
	 * This creates an adapter for a {@link gov.nasa.jpl.imce.oml.bundles.BundledTerminologyAxiom}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBundledTerminologyAxiomAdapter() {
		if (bundledTerminologyAxiomItemProvider == null) {
			bundledTerminologyAxiomItemProvider = new BundledTerminologyAxiomItemProvider(this);
		}

		return bundledTerminologyAxiomItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (bundleItemProvider != null) bundleItemProvider.dispose();
		if (specificDisjointConceptAxiomItemProvider != null) specificDisjointConceptAxiomItemProvider.dispose();
		if (anonymousConceptTaxonomyAxiomItemProvider != null) anonymousConceptTaxonomyAxiomItemProvider.dispose();
		if (rootConceptTaxonomyAxiomItemProvider != null) rootConceptTaxonomyAxiomItemProvider.dispose();
		if (bundledTerminologyAxiomItemProvider != null) bundledTerminologyAxiomItemProvider.dispose();
	}

	/**
	 * A child creation extender for the {@link OMLEPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class OMLEChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends OMLESwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseTerminologyExtent(TerminologyExtent object) {
				newChildDescriptors.add
					(createChildParameter
						(OMLEPackage.Literals.TERMINOLOGY_EXTENT__BUNDLES,
						 OMLBFactory.eINSTANCE.createBundle()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return OMLEditPlugin.INSTANCE;
		}
	}

}
