/**
 * generated by Xtext 2.10.0
 */
package jpl.imce.oml.specification.web;

import com.google.inject.Injector;
import com.google.inject.Provider;
import java.util.concurrent.ExecutorService;
import jpl.imce.oml.specification.OntologicalModelingLanguageStandaloneSetup;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class OntologicalModelingLanguageWebSetup extends OntologicalModelingLanguageStandaloneSetup {
  private final Provider<ExecutorService> executorServiceProvider;
  
  public Injector createInjector() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from OntologicalModelingLanguageRuntimeModule to Iterable<? extends Module>");
  }
  
  public OntologicalModelingLanguageWebSetup(final Provider<ExecutorService> executorServiceProvider) {
    super();
    this.executorServiceProvider = executorServiceProvider;
  }
}
