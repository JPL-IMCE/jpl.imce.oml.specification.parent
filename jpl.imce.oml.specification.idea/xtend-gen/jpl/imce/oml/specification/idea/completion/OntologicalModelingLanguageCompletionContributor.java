/**
 * generated by Xtext 2.10.0
 */
package jpl.imce.oml.specification.idea.completion;

import jpl.imce.oml.specification.idea.completion.AbstractOntologicalModelingLanguageCompletionContributor;
import jpl.imce.oml.specification.idea.lang.OntologicalModelingLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class OntologicalModelingLanguageCompletionContributor extends AbstractOntologicalModelingLanguageCompletionContributor {
  public OntologicalModelingLanguageCompletionContributor() {
    this(OntologicalModelingLanguageLanguage.INSTANCE);
  }
  
  public OntologicalModelingLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}