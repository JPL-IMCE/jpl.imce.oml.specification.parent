/**
 * generated by Xtext 2.10.0
 */
package jpl.imce.oml.specification.web;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import javax.servlet.annotation.WebServlet;
import org.eclipse.xtext.web.servlet.XtextServlet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = "XtextServices", urlPatterns = "/xtext-service/*")
@SuppressWarnings("all")
public class OntologicalModelingLanguageServlet extends XtextServlet {
  private final List<ExecutorService> executorServices = CollectionLiterals.<ExecutorService>newArrayList();
  
  public void init() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createInjectorAndDoEMFRegistration() is undefined for the type OntologicalModelingLanguageWebSetup");
  }
  
  public void destroy() {
    final Consumer<ExecutorService> _function = new Consumer<ExecutorService>() {
      public void accept(final ExecutorService it) {
        it.shutdown();
      }
    };
    this.executorServices.forEach(_function);
    this.executorServices.clear();
    super.destroy();
  }
}
