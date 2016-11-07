package gov.nasa.jpl.imce.omf.schema.generators;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.osgi.framework.Bundle;

@SuppressWarnings("all")
public class OMFSchemaTableGenerator {
  public static class OMFFeatureCompare implements Comparator<EStructuralFeature> {
    private final List<String> knownAttributes = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("graphUUID", "uuid", "kind", "isAbstract", "asymmetric", "essential", "functional", "inverseEssential", "inverseFunctional", "irreflexive", "reflexive", "symmetric", "transitive", "name", "iri"));
    
    @Override
    public int compare(final EStructuralFeature o1, final EStructuralFeature o2) {
      int _xblockexpression = (int) 0;
      {
        final String name1 = OMFSchemaTableGenerator.columnName(o1);
        final String name2 = OMFSchemaTableGenerator.columnName(o2);
        final int i1 = this.knownAttributes.indexOf(name1);
        final int i2 = this.knownAttributes.indexOf(name2);
        int _xifexpression = (int) 0;
        if (((i1 > (-1)) && (i2 > (-1)))) {
          _xifexpression = Integer.valueOf(i1).compareTo(Integer.valueOf(i2));
        } else {
          int _xifexpression_1 = (int) 0;
          if (((i1 > (-1)) && (i2 == (-1)))) {
            _xifexpression_1 = (-1);
          } else {
            int _xifexpression_2 = (int) 0;
            if (((i1 == (-1)) && (i2 > (-1)))) {
              _xifexpression_2 = 1;
            } else {
              _xifexpression_2 = name1.compareTo(name2);
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    }
  }
  
  public void generate() {
    try {
      final String sourceFile = "/gov.nasa.jpl.imce.omf.schema.specification/model/OMFSchema.xcore";
      final String targetBundle = "jpl.omf.schema.tables";
      final XtextResourceSet set = new XtextResourceSet();
      URIConverter _uRIConverter = set.getURIConverter();
      Map<URI, URI> _uRIMap = _uRIConverter.getURIMap();
      Map<URI, URI> _computePlatformURIMap = EcorePlugin.computePlatformURIMap(true);
      _uRIMap.putAll(_computePlatformURIMap);
      set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
      final URI sourceURI = URI.createPlatformResourceURI(sourceFile, false);
      final Resource sourceResource = set.getResource(sourceURI, true);
      EList<EObject> _contents = sourceResource.getContents();
      Iterable<EPackage> _filter = Iterables.<EPackage>filter(_contents, EPackage.class);
      final EPackage ePackage = ((EPackage[])Conversions.unwrapArray(_filter, EPackage.class))[0];
      final String targetFolder = "/shared/src/main/scala/gov/nasa/jpl/imce/omf/schema/tables";
      Bundle _bundle = Platform.getBundle(targetBundle);
      URL _entry = _bundle.getEntry(targetFolder);
      final URL folder = FileLocator.toFileURL(_entry);
      String _path = folder.getPath();
      this.generate(ePackage, _path);
      final String targetJSFolder = "/js/src/main/scala/gov/nasa/jpl/imce/omf/schema/tables";
      Bundle _bundle_1 = Platform.getBundle(targetBundle);
      URL _entry_1 = _bundle_1.getEntry(targetJSFolder);
      final URL folderJS = FileLocator.toFileURL(_entry_1);
      String _path_1 = folderJS.getPath();
      this.generateJS(ePackage, _path_1);
      final String targetJVMFolder = "/jvm/src/main/scala/gov/nasa/jpl/imce/omf/schema/tables";
      Bundle _bundle_2 = Platform.getBundle(targetBundle);
      URL _entry_2 = _bundle_2.getEntry(targetJVMFolder);
      final URL folderJVM = FileLocator.toFileURL(_entry_2);
      String _path_2 = folderJVM.getPath();
      this.generateJVM(ePackage, _path_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void generate(final EPackage ePackage, final String targetFolder) {
    try {
      File _file = new File(((targetFolder + File.separator) + "package.scala"));
      final FileOutputStream packageFile = new FileOutputStream(_file);
      String _generatePackageFile = this.generatePackageFile(ePackage);
      byte[] _bytes = _generatePackageFile.getBytes();
      packageFile.write(_bytes);
      File _file_1 = new File(((targetFolder + File.separator) + "OMFTables.scala"));
      final FileOutputStream tablesFile = new FileOutputStream(_file_1);
      String _generateTablesFile = this.generateTablesFile(ePackage);
      byte[] _bytes_1 = _generateTablesFile.getBytes();
      tablesFile.write(_bytes_1);
      EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      final Function1<EClass, Boolean> _function = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(_filter, _function);
      for (final EClass eClass : _filter_1) {
        {
          String _name = eClass.getName();
          String _plus = ((targetFolder + File.separator) + _name);
          String _plus_1 = (_plus + ".scala");
          File _file_2 = new File(_plus_1);
          final FileOutputStream classFile = new FileOutputStream(_file_2);
          String _generateClassFile = this.generateClassFile(eClass);
          byte[] _bytes_2 = _generateClassFile.getBytes();
          classFile.write(_bytes_2);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String generateTablesFile(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package gov.nasa.jpl.imce.omf.schema.tables");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.{File,InputStream}");
    _builder.newLine();
    _builder.append("import org.apache.commons.compress.archivers.zip.{ZipArchiveEntry, ZipFile}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import scala.collection.immutable.Seq");
    _builder.newLine();
    _builder.append("import scala.collection.JavaConversions._");
    _builder.newLine();
    _builder.append("import scala.Unit");
    _builder.newLine();
    _builder.append("import scala.util.control.Exception._");
    _builder.newLine();
    _builder.append("import scala.util.{Failure,Success,Try}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("case class OMFTables private[tables]");
    _builder.newLine();
    {
      EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      final Function1<EClass, Boolean> _function = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(_filter, _function);
      final Function1<EClass, String> _function_1 = (EClass it) -> {
        return it.getName();
      };
      List<EClass> _sortBy = IterableExtensions.<EClass, String>sortBy(_filter_1, _function_1);
      boolean _hasElements = false;
      for(final EClass eClass : _sortBy) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("(\n  ", "");
        } else {
          _builder.appendImmediate(",\n  ", "");
        }
        String _tableVariable = OMFSchemaTableGenerator.tableVariable(eClass);
        _builder.append(_tableVariable, "");
      }
      if (_hasElements) {
        _builder.append("\n)", "");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    {
      EList<EClassifier> _eClassifiers_1 = ePackage.getEClassifiers();
      Iterable<EClass> _filter_2 = Iterables.<EClass>filter(_eClassifiers_1, EClass.class);
      final Function1<EClass, Boolean> _function_2 = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<EClass> _filter_3 = IterableExtensions.<EClass>filter(_filter_2, _function_2);
      final Function1<EClass, String> _function_3 = (EClass it) -> {
        return it.getName();
      };
      List<EClass> _sortBy_1 = IterableExtensions.<EClass, String>sortBy(_filter_3, _function_3);
      boolean _hasElements_1 = false;
      for(final EClass eClass_1 : _sortBy_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
          _builder.append("{\n", "");
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _tableReader = OMFSchemaTableGenerator.tableReader(eClass_1);
        _builder.append(_tableReader, "");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements_1) {
        _builder.append("\n}", "");
      }
    }
    _builder.newLine();
    _builder.append("object OMFTables {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def loadOMFTables(omfSchemaJsonZipFile: File)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": Try[OMFTables]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= nonFatalCatch[Try[OMFTables]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(".withApply {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("(cause: java.lang.Throwable) =>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("cause.fillInStackTrace()");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Failure(cause)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(".apply {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("val zipFile = new ZipFile(omfSchemaJsonZipFile)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("val omfTables =");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("zipFile");
    _builder.newLine();
    _builder.append("        ");
    _builder.append(".getEntries");
    _builder.newLine();
    _builder.append("        ");
    _builder.append(".toIterable");
    _builder.newLine();
    _builder.append("        ");
    _builder.append(".par");
    _builder.newLine();
    _builder.append("         ");
    _builder.append(".aggregate(OMFTables())(seqop = readZipArchive(zipFile), combop = mergeTables)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("zipFile.close()");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("Success(omfTables)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private[tables] def mergeTables");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(t1: OMFTables, t2: OMFTables)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": OMFTables");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= ");
    {
      EList<EClassifier> _eClassifiers_2 = ePackage.getEClassifiers();
      Iterable<EClass> _filter_4 = Iterables.<EClass>filter(_eClassifiers_2, EClass.class);
      final Function1<EClass, Boolean> _function_4 = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<EClass> _filter_5 = IterableExtensions.<EClass>filter(_filter_4, _function_4);
      final Function1<EClass, String> _function_5 = (EClass it) -> {
        return it.getName();
      };
      List<EClass> _sortBy_2 = IterableExtensions.<EClass, String>sortBy(_filter_5, _function_5);
      boolean _hasElements_2 = false;
      for(final EClass eClass_2 : _sortBy_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
          _builder.append("OMFTables(\n    ", "  ");
        } else {
          _builder.appendImmediate(",\n    ", "  ");
        }
        String _tableVariableName = OMFSchemaTableGenerator.tableVariableName(eClass_2);
        _builder.append(_tableVariableName, "  ");
        _builder.append(" = t1.");
        String _tableVariableName_1 = OMFSchemaTableGenerator.tableVariableName(eClass_2);
        _builder.append(_tableVariableName_1, "  ");
        _builder.append(" ++ t2.");
        String _tableVariableName_2 = OMFSchemaTableGenerator.tableVariableName(eClass_2);
        _builder.append(_tableVariableName_2, "  ");
      }
      if (_hasElements_2) {
        _builder.append(")", "  ");
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("private[tables] def readZipArchive");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(zipFile: ZipFile)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(tables: OMFTables, ze: ZipArchiveEntry)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": OMFTables");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("val is = zipFile.getInputStream(ze)");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("ze.getName match {");
    _builder.newLine();
    {
      EList<EClassifier> _eClassifiers_3 = ePackage.getEClassifiers();
      Iterable<EClass> _filter_6 = Iterables.<EClass>filter(_eClassifiers_3, EClass.class);
      final Function1<EClass, Boolean> _function_6 = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<EClass> _filter_7 = IterableExtensions.<EClass>filter(_filter_6, _function_6);
      final Function1<EClass, String> _function_7 = (EClass it) -> {
        return it.getName();
      };
      List<EClass> _sortBy_3 = IterableExtensions.<EClass, String>sortBy(_filter_7, _function_7);
      for(final EClass eClass_3 : _sortBy_3) {
        _builder.append("  \t  ");
        _builder.append("case ");
        String _name = eClass_3.getName();
        _builder.append(_name, "  \t  ");
        _builder.append("Helper.TABLE_JSON_FILENAME =>");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t  ");
        _builder.append("  ");
        _builder.append("tables.");
        String _tableReaderName = OMFSchemaTableGenerator.tableReaderName(eClass_3);
        _builder.append(_tableReaderName, "  \t    ");
        _builder.append("(is)");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def saveOMFTables");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(tables: OMFTables,");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("omfSchemaJsonZipFile: File)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": Try[Unit]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= nonFatalCatch[Try[Unit]]");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(".withApply {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("(cause: java.lang.Throwable) =>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("cause.fillInStackTrace()");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Failure(cause)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append(".apply {");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("// @see http://www.oracle.com/technetwork/articles/java/compress-1565076.html");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("val fos = new java.io.FileOutputStream(omfSchemaJsonZipFile)");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("val bos = new java.io.BufferedOutputStream(fos, 100000)");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("val cos = new java.util.zip.CheckedOutputStream(bos, new java.util.zip.Adler32())");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("val zos = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(cos))");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("zos.setMethod(java.util.zip.ZipOutputStream.DEFLATED)");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    {
      EList<EClassifier> _eClassifiers_4 = ePackage.getEClassifiers();
      Iterable<EClass> _filter_8 = Iterables.<EClass>filter(_eClassifiers_4, EClass.class);
      final Function1<EClass, Boolean> _function_8 = (EClass it) -> {
        boolean _isAbstract = it.isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<EClass> _filter_9 = IterableExtensions.<EClass>filter(_filter_8, _function_8);
      final Function1<EClass, String> _function_9 = (EClass it) -> {
        return it.getName();
      };
      List<EClass> _sortBy_4 = IterableExtensions.<EClass, String>sortBy(_filter_9, _function_9);
      for(final EClass eClass_4 : _sortBy_4) {
        _builder.append("      ");
        _builder.append("zos.putNextEntry(new java.util.zip.ZipEntry(");
        String _name_1 = eClass_4.getName();
        _builder.append(_name_1, "      ");
        _builder.append("Helper.TABLE_JSON_FILENAME))");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("tables.");
        String _tableVariableName_3 = OMFSchemaTableGenerator.tableVariableName(eClass_4);
        _builder.append(_tableVariableName_3, "      ");
        _builder.append(".foreach { t =>");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("   ");
        _builder.append("val line = ");
        String _name_2 = eClass_4.getName();
        _builder.append(_name_2, "         ");
        _builder.append("Helper.toJSON(t)+\"\\n\"");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("   ");
        _builder.append("zos.write(line.getBytes(java.nio.charset.Charset.forName(\"UTF-8\")))");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("zos.closeEntry()");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("zos.close()");
    _builder.newLine();
    _builder.append("  \t  ");
    _builder.append("Success(())");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String tableReaderName(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("read");
    String _name = eClass.getName();
    _builder.append(_name, "");
    _builder.append("s");
    return _builder.toString();
  }
  
  public static String tableVariableName(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = eClass.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    _builder.append(_firstLower, "");
    _builder.append("s");
    return _builder.toString();
  }
  
  public static String tableVariable(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    String _tableVariableName = OMFSchemaTableGenerator.tableVariableName(eClass);
    _builder.append(_tableVariableName, "");
    _builder.append(" : Seq[");
    String _name = eClass.getName();
    _builder.append(_name, "");
    _builder.append("] = Seq.empty");
    return _builder.toString();
  }
  
  public static String tableReader(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def ");
    String _tableReaderName = OMFSchemaTableGenerator.tableReaderName(eClass);
    _builder.append(_tableReaderName, "");
    _builder.append("(is: InputStream)");
    _builder.newLineIfNotEmpty();
    _builder.append(": OMFTables");
    _builder.newLine();
    _builder.append("= copy(");
    String _tableVariableName = OMFSchemaTableGenerator.tableVariableName(eClass);
    _builder.append(_tableVariableName, "");
    _builder.append(" = readJSonTable(is, ");
    String _name = eClass.getName();
    _builder.append(_name, "");
    _builder.append("Helper.fromJSON))");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public void generateJS(final EPackage ePackage, final String targetJSFolder) {
    try {
      EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      final Function1<EClass, Boolean> _function = (EClass it) -> {
        return Boolean.valueOf(((!it.isAbstract()) && (OMFSchemaTableGenerator.hasOptionalAttributes(it)).booleanValue()));
      };
      Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(_filter, _function);
      for (final EClass eClass : _filter_1) {
        {
          String _name = eClass.getName();
          String _plus = ((targetJSFolder + File.separator) + _name);
          String _plus_1 = (_plus + "JS.scala");
          File _file = new File(_plus_1);
          final FileOutputStream classFile = new FileOutputStream(_file);
          String _generateJSClassFile = this.generateJSClassFile(eClass);
          byte[] _bytes = _generateJSClassFile.getBytes();
          classFile.write(_bytes);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void generateJVM(final EPackage ePackage, final String targetJVMFolder) {
    try {
      EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      final Function1<EClass, Boolean> _function = (EClass it) -> {
        return Boolean.valueOf(((!it.isAbstract()) && (OMFSchemaTableGenerator.hasOptionalAttributes(it)).booleanValue()));
      };
      Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(_filter, _function);
      for (final EClass eClass : _filter_1) {
        {
          String _name = eClass.getName();
          String _plus = ((targetJVMFolder + File.separator) + _name);
          String _plus_1 = (_plus + "Java.scala");
          File _file = new File(_plus_1);
          final FileOutputStream classFile = new FileOutputStream(_file);
          String _generateJVMClassFile = this.generateJVMClassFile(eClass);
          byte[] _bytes = _generateJVMClassFile.getBytes();
          classFile.write(_bytes);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String generatePackageFile(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package gov.nasa.jpl.imce.omf.schema");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.InputStream");
    _builder.newLine();
    _builder.append("import scala.collection.immutable.Seq");
    _builder.newLine();
    _builder.append("import scala.io");
    _builder.newLine();
    _builder.append("import scala.Predef.String");
    _builder.newLine();
    _builder.newLine();
    _builder.append("package object tables {");
    _builder.newLine();
    {
      EList<EClassifier> _eClassifiers = ePackage.getEClassifiers();
      Iterable<EDataType> _filter = Iterables.<EDataType>filter(_eClassifiers, EDataType.class);
      final Function1<EDataType, Boolean> _function = (EDataType t) -> {
        return Boolean.valueOf((!(t instanceof EEnum)));
      };
      Iterable<EDataType> _filter_1 = IterableExtensions.<EDataType>filter(_filter, _function);
      final Function1<EDataType, String> _function_1 = (EDataType it) -> {
        return it.getName();
      };
      List<EDataType> _sortBy = IterableExtensions.<EDataType, String>sortBy(_filter_1, _function_1);
      for(final EDataType type : _sortBy) {
        _builder.append("\t");
        _builder.append("type ");
        String _name = type.getName();
        _builder.append(_name, "\t");
        _builder.append(" = String");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  \t");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def readJSonTable[T](is: InputStream, fromJSon: String => T)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": Seq[T]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= io.Source.fromInputStream(is).getLines.map(fromJSon).to[Seq]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String generateClassFile(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("package gov.nasa.jpl.imce.omf.schema.tables");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import scala.annotation.meta.field");
    _builder.newLine();
    _builder.append("import scala.scalajs.js.annotation.JSExport");
    _builder.newLine();
    _builder.append("import scala._");
    _builder.newLine();
    _builder.append("import scala.Predef._");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    {
      List<EStructuralFeature> _sortedAttributes = OMFSchemaTableGenerator.getSortedAttributes(eClass);
      for(final EStructuralFeature attr : _sortedAttributes) {
        _builder.append("  ");
        _builder.append("* @param ");
        String _columnName = OMFSchemaTableGenerator.columnName(attr);
        _builder.append(_columnName, "  ");
        _builder.append("[");
        int _lowerBound = attr.getLowerBound();
        _builder.append(_lowerBound, "  ");
        _builder.append(",");
        int _upperBound = attr.getUpperBound();
        _builder.append(_upperBound, "  ");
        _builder.append("]");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("*/");
    _builder.newLine();
    {
      Boolean _hasOptionalAttributes = OMFSchemaTableGenerator.hasOptionalAttributes(eClass);
      boolean _not = (!(_hasOptionalAttributes).booleanValue());
      if (_not) {
        _builder.append("@JSExport");
        _builder.newLine();
      }
    }
    _builder.append("case class ");
    String _name = eClass.getName();
    _builder.append(_name, "");
    _builder.newLineIfNotEmpty();
    _builder.append("(");
    _builder.newLine();
    {
      List<EStructuralFeature> _sortedAttributes_1 = OMFSchemaTableGenerator.getSortedAttributes(eClass);
      boolean _hasElements = false;
      for(final EStructuralFeature attr_1 : _sortedAttributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", " ");
        }
        _builder.append(" ");
        _builder.append("@(JSExport @field) ");
        String _columnName_1 = OMFSchemaTableGenerator.columnName(attr_1);
        _builder.append(_columnName_1, " ");
        _builder.append(": ");
        String _constructorTypeName = OMFSchemaTableGenerator.constructorTypeName(attr_1);
        _builder.append(_constructorTypeName, " ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(")");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@JSExport");
    _builder.newLine();
    _builder.append("object ");
    String _name_1 = eClass.getName();
    _builder.append(_name_1, "");
    _builder.append("Helper {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val TABLE_JSON_FILENAME ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": scala.Predef.String ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= \"");
    String _name_2 = eClass.getName();
    _builder.append(_name_2, "  ");
    _builder.append("s.json\"");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("implicit val w");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": upickle.default.Writer[");
    String _name_3 = eClass.getName();
    _builder.append(_name_3, "  ");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("= upickle.default.macroW[");
    String _name_4 = eClass.getName();
    _builder.append(_name_4, "  ");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@JSExport");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def toJSON(c: ");
    String _name_5 = eClass.getName();
    _builder.append(_name_5, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append(": String");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("= upickle.default.write(expr=c, indent=0)");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("implicit val r");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": upickle.default.Reader[");
    String _name_6 = eClass.getName();
    _builder.append(_name_6, "  ");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("= upickle.default.macroR[");
    String _name_7 = eClass.getName();
    _builder.append(_name_7, "  ");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@JSExport");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def fromJSON(c: String)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(": ");
    String _name_8 = eClass.getName();
    _builder.append(_name_8, "  ");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("= upickle.default.read[");
    String _name_9 = eClass.getName();
    _builder.append(_name_9, "  ");
    _builder.append("](c)");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}\t");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String generateJSClassFile(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("package gov.nasa.jpl.imce.omf.schema.tables");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import scala.scalajs.js.annotation.JSExport");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@JSExport");
    _builder.newLine();
    _builder.append("object ");
    String _name = eClass.getName();
    _builder.append(_name, "");
    _builder.append("JS {");
    _builder.newLineIfNotEmpty();
    {
      Boolean _hasOptionalAttributes = OMFSchemaTableGenerator.hasOptionalAttributes(eClass);
      if ((_hasOptionalAttributes).booleanValue()) {
        _builder.append("  ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("@JSExport");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("def js");
        String _name_1 = eClass.getName();
        _builder.append(_name_1, "  ");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          List<EStructuralFeature> _sortedAttributes = OMFSchemaTableGenerator.getSortedAttributes(eClass);
          boolean _hasElements = false;
          for(final EStructuralFeature attr : _sortedAttributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "    ");
            }
            _builder.append("  ");
            _builder.append("  ");
            String _columnName = OMFSchemaTableGenerator.columnName(attr);
            _builder.append(_columnName, "    ");
            _builder.append(": ");
            String _jsTypeName = OMFSchemaTableGenerator.jsTypeName(attr);
            _builder.append(_jsTypeName, "    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append(")");
        _builder.newLine();
        _builder.append("  ");
        _builder.append(": ");
        String _name_2 = eClass.getName();
        _builder.append(_name_2, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("= ");
        String _name_3 = eClass.getName();
        _builder.append(_name_3, "  ");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          List<EStructuralFeature> _sortedAttributes_1 = OMFSchemaTableGenerator.getSortedAttributes(eClass);
          boolean _hasElements_1 = false;
          for(final EStructuralFeature attr_1 : _sortedAttributes_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",", "    ");
            }
            _builder.append("  ");
            _builder.append("  ");
            String _jsArgName = OMFSchemaTableGenerator.jsArgName(attr_1);
            _builder.append(_jsArgName, "    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append(")");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.newLine();
    _builder.append("}\t");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String generateJVMClassFile(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright, "");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("package gov.nasa.jpl.imce.omf.schema.tables");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Optional");
    _builder.newLine();
    _builder.append("import scala.compat.java8.OptionConverters._");
    _builder.newLine();
    _builder.newLine();
    _builder.append("object ");
    String _name = eClass.getName();
    _builder.append(_name, "");
    _builder.append("Java {");
    _builder.newLineIfNotEmpty();
    {
      Boolean _hasOptionalAttributes = OMFSchemaTableGenerator.hasOptionalAttributes(eClass);
      if ((_hasOptionalAttributes).booleanValue()) {
        _builder.append("  ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("def java");
        String _name_1 = eClass.getName();
        _builder.append(_name_1, "  ");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          List<EStructuralFeature> _sortedAttributes = OMFSchemaTableGenerator.getSortedAttributes(eClass);
          boolean _hasElements = false;
          for(final EStructuralFeature attr : _sortedAttributes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "    ");
            }
            _builder.append("  ");
            _builder.append("  ");
            String _columnName = OMFSchemaTableGenerator.columnName(attr);
            _builder.append(_columnName, "    ");
            _builder.append(": ");
            String _javaTypeName = OMFSchemaTableGenerator.javaTypeName(attr);
            _builder.append(_javaTypeName, "    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append(")");
        _builder.newLine();
        _builder.append("  ");
        _builder.append(": ");
        String _name_2 = eClass.getName();
        _builder.append(_name_2, "  ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("= ");
        String _name_3 = eClass.getName();
        _builder.append(_name_3, "  ");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          List<EStructuralFeature> _sortedAttributes_1 = OMFSchemaTableGenerator.getSortedAttributes(eClass);
          boolean _hasElements_1 = false;
          for(final EStructuralFeature attr_1 : _sortedAttributes_1) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",", "    ");
            }
            _builder.append("  ");
            _builder.append("  ");
            String _javaArgName = OMFSchemaTableGenerator.javaArgName(attr_1);
            _builder.append(_javaArgName, "    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append(")");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.newLine();
    _builder.append("}\t");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static Boolean hasOptionalAttributes(final EClass eClass) {
    List<EStructuralFeature> _sortedAttributes = OMFSchemaTableGenerator.getSortedAttributes(eClass);
    final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature a) -> {
      int _lowerBound = a.getLowerBound();
      return Boolean.valueOf((_lowerBound == 0));
    };
    return Boolean.valueOf(IterableExtensions.<EStructuralFeature>exists(_sortedAttributes, _function));
  }
  
  public static List<EStructuralFeature> getSortedAttributes(final EClass eClass) {
    List<EClass> _selfAndAllSupertypes = OMFSchemaTableGenerator.selfAndAllSupertypes(eClass);
    final Function1<EClass, EList<EStructuralFeature>> _function = (EClass it) -> {
      return it.getEStructuralFeatures();
    };
    List<EList<EStructuralFeature>> _map = ListExtensions.<EClass, EList<EStructuralFeature>>map(_selfAndAllSupertypes, _function);
    Iterable<EStructuralFeature> _flatten = Iterables.<EStructuralFeature>concat(_map);
    final Function1<EStructuralFeature, Boolean> _function_1 = (EStructuralFeature f) -> {
      return Boolean.valueOf(((OMFSchemaTableGenerator.isAttributeOrReferenceOrContainer(f)).booleanValue() && (OMFSchemaTableGenerator.isSchema(f)).booleanValue()));
    };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_flatten, _function_1);
    OMFSchemaTableGenerator.OMFFeatureCompare _oMFFeatureCompare = new OMFSchemaTableGenerator.OMFFeatureCompare();
    return IterableExtensions.<EStructuralFeature>sortWith(_filter, _oMFFeatureCompare);
  }
  
  public static Boolean isAttributeOrReferenceOrContainer(final EStructuralFeature f) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (f instanceof EReference) {
      _matched=true;
      boolean _isContainment = ((EReference)f).isContainment();
      _switchResult = (!_isContainment);
    }
    if (!_matched) {
      _switchResult = true;
    }
    return Boolean.valueOf(_switchResult);
  }
  
  public static List<EClass> selfAndAllSupertypes(final EClass eClass) {
    ArrayList<EClass> _xblockexpression = null;
    {
      EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
      final ArrayList<EClass> parents = new ArrayList<EClass>(_eAllSuperTypes);
      parents.add(eClass);
      _xblockexpression = parents;
    }
    return _xblockexpression;
  }
  
  public static String columnName(final EStructuralFeature feature) {
    String _xifexpression = null;
    if ((feature instanceof EReference)) {
      String _name = ((EReference)feature).getName();
      _xifexpression = (_name + "UUID");
    } else {
      _xifexpression = feature.getName();
    }
    return _xifexpression;
  }
  
  public static String scalaTypeName(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final EClassifier type = feature.getEType();
      String _switchResult = null;
      String _name = type.getName();
      boolean _matched = false;
      if (Objects.equal(_name, "EInt")) {
        _matched=true;
        _switchResult = "scala.Int";
      }
      if (!_matched) {
        if (Objects.equal(_name, "EBoolean")) {
          _matched=true;
          _switchResult = "scala.Boolean";
        }
      }
      if (!_matched) {
        if (Objects.equal(_name, "EString")) {
          _matched=true;
          _switchResult = "scala.Predef.String";
        }
      }
      if (!_matched) {
        if ((type instanceof EClass)) {
          _matched=true;
          _switchResult = "UUID";
        }
      }
      if (!_matched) {
        _switchResult = type.getName();
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public static String constructorTypeName(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final String scalaType = OMFSchemaTableGenerator.scalaTypeName(feature);
      String _xifexpression = null;
      int _lowerBound = feature.getLowerBound();
      boolean _equals = (_lowerBound == 0);
      if (_equals) {
        _xifexpression = (("scala.Option[" + scalaType) + "]");
      } else {
        _xifexpression = scalaType;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static String jsTypeName(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final String scalaType = OMFSchemaTableGenerator.scalaTypeName(feature);
      String _xifexpression = null;
      int _lowerBound = feature.getLowerBound();
      boolean _equals = (_lowerBound == 0);
      if (_equals) {
        _xifexpression = (("scala.scalajs.js.UndefOr[" + scalaType) + "]");
      } else {
        _xifexpression = scalaType;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static String jsArgName(final EStructuralFeature feature) {
    String _xifexpression = null;
    int _lowerBound = feature.getLowerBound();
    boolean _equals = (_lowerBound == 0);
    if (_equals) {
      String _columnName = OMFSchemaTableGenerator.columnName(feature);
      _xifexpression = (_columnName + ".toOption");
    } else {
      _xifexpression = OMFSchemaTableGenerator.columnName(feature);
    }
    return _xifexpression;
  }
  
  public static String javaTypeName(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final String scalaType = OMFSchemaTableGenerator.scalaTypeName(feature);
      String _xifexpression = null;
      int _lowerBound = feature.getLowerBound();
      boolean _equals = (_lowerBound == 0);
      if (_equals) {
        _xifexpression = (("Optional[" + scalaType) + "]");
      } else {
        _xifexpression = scalaType;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static String javaArgName(final EStructuralFeature feature) {
    String _xifexpression = null;
    int _lowerBound = feature.getLowerBound();
    boolean _equals = (_lowerBound == 0);
    if (_equals) {
      String _columnName = OMFSchemaTableGenerator.columnName(feature);
      _xifexpression = (_columnName + ".asScala");
    } else {
      _xifexpression = OMFSchemaTableGenerator.columnName(feature);
    }
    return _xifexpression;
  }
  
  public static Boolean isSchema(final ENamedElement e) {
    EAnnotation _eAnnotation = e.getEAnnotation("http://imce.jpl.nasa.gov/omf/NotSchema");
    return Boolean.valueOf(Objects.equal(null, _eAnnotation));
  }
  
  public static String doc(final ENamedElement e, final String indent) {
    String _xblockexpression = null;
    {
      String _elvis = null;
      EAnnotation _eAnnotation = e.getEAnnotation("http://www.eclipse.org/emf/2002/GenModel");
      EMap<String, String> _details = null;
      if (_eAnnotation!=null) {
        _details=_eAnnotation.getDetails();
      }
      String _get = null;
      if (_details!=null) {
        _get=_details.get("documentation");
      }
      if (_get != null) {
        _elvis = _get;
      } else {
        _elvis = "";
      }
      final String doc = _elvis;
      String _xifexpression = null;
      boolean _isEmpty = doc.isEmpty();
      if (_isEmpty) {
        _xifexpression = doc;
      } else {
        String _replaceAll = doc.replaceAll("\n", (("\n" + indent) + " * "));
        String _plus = ((("/*\n" + indent) + " * ") + _replaceAll);
        String _plus_1 = (_plus + "\n");
        String _plus_2 = (_plus_1 + indent);
        String _plus_3 = (_plus_2 + " */\n");
        _xifexpression = (_plus_3 + indent);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence copyright() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright 2016 California Institute of Technology (\"Caltech\").");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* U.S. Government sponsorship acknowledged.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Licensed under the Apache License, Version 2.0 (the \"License\");");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* you may not use this file except in compliance with the License.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* You may obtain a copy of the License at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*     http://www.apache.org/licenses/LICENSE-2.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Unless required by applicable law or agreed to in writing, software");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* distributed under the License is distributed on an \"AS IS\" BASIS,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* See the License for the specific language governing permissions and");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* limitations under the License.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* License Terms");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    return _builder;
  }
}
