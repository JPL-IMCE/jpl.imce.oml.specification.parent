/**
 * generated by Xtext 2.10.0
 */
package jpl.imce.oml.specification.idea;

import com.google.inject.Injector;
import jpl.imce.oml.specification.idea.OntologicalModelingLanguageStandaloneSetupIdea;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries;

@SuppressWarnings("all")
public class OntologicalModelingLanguageIdeaSetup implements ISetup {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Injector _xblockexpression = null;
    {
      EcoreGlobalRegistries.ensureInitialized();
      OntologicalModelingLanguageStandaloneSetupIdea _ontologicalModelingLanguageStandaloneSetupIdea = new OntologicalModelingLanguageStandaloneSetupIdea();
      _xblockexpression = _ontologicalModelingLanguageStandaloneSetupIdea.createInjector();
    }
    return _xblockexpression;
  }
}
