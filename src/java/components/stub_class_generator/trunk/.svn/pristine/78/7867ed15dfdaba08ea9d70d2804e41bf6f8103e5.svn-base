/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.Package;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * This is the main class of this component which represents all its
 * functionality. The class contains the overloaded method
 * <code>generateCode()</code> which provides the ability to write code to a
 * specified location.
 * </p>
 * <p>
 * The class has two configurable parameters:
 * <ul>
 * <li> <b>emptyLocationDirectory:</b> flag to indicate if the location
 * directory should be cleaned before writing the files.</li>
 * <li> <b>createEmptyPackage:</b> flag to indicate if empty packages should be
 * generated or not.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Possible configuration:</b>
 *
 * <pre>
 *   &lt;?xml version=&quot;1.0&quot; ?&gt;
 *      &lt;Config name=&quot;empty_config&quot;&gt;
 *          &lt;Config name=&quot;stub_class_generator&quot;&gt;
 *                   &lt;Property name=&quot;javaLanguage&quot;&gt;
 *                            &lt;Value&gt;Java&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;C#Language&quot;&gt;
 *                            &lt;Value&gt;C#&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;documentation&quot;&gt;
 *                            &lt;Value&gt;doc&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;tagsDocumentation&quot;&gt;
 *                            &lt;Value&gt;doc#&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;new&quot;&gt;
 *                            &lt;Value&gt;new_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;readonly&quot;&gt;
 *                            &lt;Value&gt;readonly_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;virtual&quot;&gt;
 *                            &lt;Value&gt;virtual_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;override&quot;&gt;
 *                            &lt;Value&gt;override_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;sealed&quot;&gt;
 *                            &lt;Value&gt;sealed_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;extern&quot;&gt;
 *                            &lt;Value&gt;extern_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;delegate&quot;&gt;
 *                            &lt;Value&gt;delegate_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;explicit&quot;&gt;
 *                            &lt;Value&gt;explicit_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;implicit&quot;&gt;
 *                            &lt;Value&gt;implicit_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;struct&quot;&gt;
 *                            &lt;Value&gt;struct_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;property_get&quot;&gt;
 *                            &lt;Value&gt;property_get_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;property_set&quot;&gt;
 *                            &lt;Value&gt;property_set_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                  &lt;Property name=&quot;property&quot;&gt;
 *                            &lt;Value&gt;property_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;destructor&quot;&gt;
 *                            &lt;Value&gt;destructor_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *                   &lt;Property name=&quot;protected internal&quot;&gt;
 *                            &lt;Value&gt;protected internal_&lt;/Value&gt;
 *                   &lt;/Property&gt;
 *          &lt;/Config&gt;
 *   &lt;/CMConfig&gt;
 * </pre>
 *
 * </p>
 * <p>
 * <b>Thread safety:</b>Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CodeGenerator {
    /**
     * <p>
     * This static member of the class represents default value of name space
     * for {@link ConfigManager} . It is needed for proper default
     * configuration. This is immutable, only one possible value
     * -&quot;com.topcoder.uml.stubclassgenerator&quot;.
     * </p>
     */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.uml.stubclassgenerator";

    /**
     * Configuration entry for Java language.
     */
    private static final String CONFIG_JAVA_LANG = "javaLanguage";

    /**
     * Configuration entry for C# language.
     */
    private static final String CONFIG_CS_LANG = "C#Language";

    /**
     * The invalid characters for file name.
     */
    private static final char[] INVALID_CHARACTERS = {'<', '>', '/', '\\', '|', ':', '"', '?', '*'};

    /**
     * The substitute for invalid characters.
     */
    private static final char SUBSTITUTE = '_';

    /**
     * <p>
     * This attribute represent configurable name of Java language. This
     * variable is gotten from {@link ConfigManager}. It is used in
     * {@link GeneratorFactory} to choose proper instance of {@link Generator}.
     * It can be added as parameter of some method.
     * </p>
     * <p>
     * Set by constructor, <code>null</code> impossible, immutable. For the
     * other classes it is accessible through the public getter
     * </p>
     */
    private final String languageJava;

    /**
     * <p>
     * This attribute represent configurable name of C# language. This variable
     * is gotten from {@link ConfigManager}. It is used in
     * {@link GeneratorFactory} to choose proper instance of {@link Generator}.
     * It can be added as parameter of some method
     * </p>
     * <p>
     * Set by constructor, <code>null</code> impossible, immutable. For the
     * other classes it is accessible through the public getter
     * </p>
     */
    private final String languageCSharp;

    /**
     * <p>
     * This attribute defines if should be deleted files and directories from
     * location folder. It is used in generateCode() method.
     * </p>
     * <p>
     * If <code>true</code> - delete everything from location,
     * <code>false</code> - do not delete.
     * </p>
     * <p>
     * By default - <code>false</code>. Possible values - <code>true</code>
     * or <code>false</code>.
     * </p>
     * <p>
     * Set by constructor. Immutable
     * </p>
     */
    private final boolean emptyLocationDirectory;

    /**
     * <p>
     * This attribute defines if empty packages should be written.
     * </p>
     * <p>
     * By default - <code>false</code>. It is used in generateCode() method.
     * </p>
     * <p>
     * If <code>true</code> - we write empty packages, <code>false</code> -
     * ignore.
     * </p>
     * <p>
     * Possible values - true or false. Set by constructor. Immutable
     * </p>
     */
    private final boolean createEmptyPackage;

    /**
     * <p>
     * Represented {@link CodeWriter} instance. This attribute is used in
     * generateCode() method to create, delete directories and write files.
     * </p>
     * <p>
     * Default and only possible value - new CodeWriter(); Immutable
     * </p>
     */
    private final CodeWriter codeWriter = new CodeWriter();

    /**
     * <p>
     * This attribute represents name space of {@link ConfigManager}
     * configuration file for the current {@link CodeGenerator}. It is set by
     * constructor. If constructor do not take namespace parameter, this
     * attribute is set to defaultNamespace.
     * </p>
     * <p>
     * Immutable, non <code>null</code>, non empty string
     * </p>
     */
    private final String namespace;

    /**
     * <p>
     * Creates a new {@link CodeGenerator} using the default name space
     * &quot;com.topcoder.uml.stubclassgenerator&quot;. This is the same as
     * <code>new CodeGenerator(false,false);</code>.
     * </p>
     *
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading the configuration
     */
    public CodeGenerator() throws GeneratorConfigurationException {
        this(false, false);
    }

    /**
     * <p>
     * Creates a new {@link CodeGenerator} using the default name space
     * &quot;com.topcoder.uml.stubclassgenerator&quot;.
     * </p>
     *
     * @param emptyLocationDirectory
     *            boolean value, <code>true</code> if user wants to clean
     *            location directory, otherwise <code>false</code>
     * @param createEmptyPackage
     *            boolean value, <code>true</code> if user wants to create
     *            empty packages, otherwise <code>false</code>
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading the configuration
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading the configuration
     */
    public CodeGenerator(boolean emptyLocationDirectory, boolean createEmptyPackage)
        throws GeneratorConfigurationException {
        this(emptyLocationDirectory, createEmptyPackage, DEFAULT_NAMESPACE);
    }

    /**
     * <p>
     * Creates a new {@link CodeGenerator} using the given name space.
     * </p>
     *
     * @param emptyLocationDirectory
     *            <code>true</code> if user wants to clean location directory,
     *            otherwise <code>false</code>
     * @param createEmptyPackage
     *            <code>true</code> if user wants to create empty package
     *            directories, otherwise <code>false</code>
     * @param namespace
     *            name space of configuration file
     * @throws IllegalArgumentException
     *             if namespace is <code>null</code> or empty
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading the configuration
     */
    public CodeGenerator(boolean emptyLocationDirectory, boolean createEmptyPackage, String namespace)
        throws GeneratorConfigurationException {
        if (namespace == null) {
            throw new IllegalArgumentException("Name space must not be null");
        }

        if (namespace.trim().length() == 0) {
            throw new IllegalArgumentException("Name space must not be empty");
        }

        this.languageCSharp = this.getConfigEntry(namespace, CONFIG_CS_LANG);
        this.languageJava = this.getConfigEntry(namespace, CONFIG_JAVA_LANG);
        this.createEmptyPackage = createEmptyPackage;
        this.emptyLocationDirectory = emptyLocationDirectory;
        this.namespace = namespace;
    }

    /**
     * <p>
     * Generates code for a given {@link Classifier} instance. The
     * {@link Classifier} may be one of the following types:
     * <ul>
     * <li> <code>Class</code>
     * <li> <code>Interface</code>
     * <li> <code>Enumeration</code>
     * </ul>
     * </p>
     *
     * @param language
     *            Language to be generated
     * @param location
     *            location for writing generated classes and packages to
     * @param classifier
     *            {@link Classifier} instance to be written
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code>
     * @throws IllegalArgumentException
     *             if language or location is empty
     * @throws CodeGenerationException
     *             When a problem occurs while writing files or if there are
     *             problems with the configuration.
     */
    public void generateCode(String language, String location, Classifier classifier)
        throws CodeGenerationException {
        if (classifier == null) {
            throw new IllegalArgumentException("Classifier must not be null");
        }

        List<Classifier> classList = new ArrayList<Classifier>();
        classList.add(classifier);
        this.generateCodeForClassifiers(language, location, classList);
    }

    /**
     * Checks location and language string.
     *
     * @param language
     *            language string
     * @param location
     *            location string
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code> or empty.
     */
    private void checkLanguageAndLocation(String language, String location) {
        if (language == null) {
            throw new IllegalArgumentException("Language must not be null");
        }

        if (language.trim().length() == 0) {
            throw new IllegalArgumentException("Language must not be empty");
        }

        if (location == null) {
            throw new IllegalArgumentException("Location must not be null");
        }

        if (location.trim().length() == 0) {
            throw new IllegalArgumentException("Location must not be empty");
        }
    }

    /**
     * <p>
     * Generates code for a given list of {@link Classifier} instance. The
     * {@link Classifier}s may be one of the following types:
     * <ul>
     * <li> <code>Class</code>
     * <li> <code>Interface</code>
     * <li> <code>Enumeration</code>
     * </ul>
     * </p>
     *
     * @param language
     *            Language to be generated
     * @param location
     *            location for writing generated classes and packages to
     * @param classifiers
     *            List of {@link Classifier} instances to be written
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code> or {@link Classifier}
     *             list contains <code>null</code> values
     * @throws IllegalArgumentException
     *             if language or location is empty
     * @throws CodeGenerationException
     *             When a problem occurs while writing files or if there are
     *             problems with the configuration.
     */
    public void generateCodeForClassifiers(String language, String location, List<Classifier> classifiers)
        throws CodeGenerationException {
        this.checkLanguageAndLocation(language, location);

        if (classifiers == null) {
            throw new IllegalArgumentException("Classifier list must not be null");
        }

        if (classifiers.contains(null)) {
            throw new IllegalArgumentException("Classifier list must not contain null values");
        }

        this.prepareLocation(location);

        Generator generator = GeneratorFactory.getGeneratorInstance(language, this, this.namespace);

        for (Classifier c : classifiers) {
            if (!generator.checkClassifier(c)) {
                continue;
            }

            this.writeClassifier(location, language, c, generator);
        }
    }

    /**
     * Writes the given {@link Classifier} to location.
     *
     * @param language
     *            Language to be generated
     * @param location
     *            location for writing generated classes and packages to
     * @param c
     *            {@link Classifier} instance to be written
     * @param generator
     *            {@link Generator} to be used
     * @throws CodeGenerationException
     *             When a problem occurs while writing files or if there are
     *             problems with the configuration.
     */
    private void writeClassifier(String location, String language, Classifier c, Generator generator)
        throws CodeGenerationException {
        String packageName = generator.getPackage(c);
        String className = c.getName();

        // Remove invalid characters for creating file
        for (char invalidCharacter : INVALID_CHARACTERS) {
            className = className.replace(invalidCharacter, SUBSTITUTE);
        }

        if ((className == null) || (className.trim().length() == 0)) {
            throw new CodeGenerationException("Could not write class, no name found");
        }

        if (!this.codeWriter.createDirectory(location, packageName)) {
            throw new CodeGenerationException("Could not create directory for package '" + packageName + "'");
        }

        try {
            this.codeWriter.writeFile(location, packageName,
                className + '.' + GeneratorFactory.getExtension(language, this), generator.createClassifierCode(c));
        } catch (IOException e) {
            throw new CodeGenerationException("IO Exception while writing class " + className, e);
        }
    }

    /**
     * <p>
     * Generates a directory structure for the given {@link Package} and
     * generates code for each {@link Classifier} found in the package. The
     * {@link Classifier} may be one of the following types:
     * <ul>
     * <li> <code>Class</code>
     * <li> <code>Interface</code>
     * <li> <code>Enumeration</code>
     * </ul>
     * </p>
     *
     * @param language
     *            Language to be generated
     * @param location
     *            location for writing generated classes and packages to
     * @param pack
     *            {@link Package} to be written
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code>
     * @throws IllegalArgumentException
     *             if language or location is empty
     * @throws CodeGenerationException
     *             When a problem occurs while writing files or if there are
     *             problems with the configuration.
     */
    public void generateCode(String language, String location, Package pack)
        throws CodeGenerationException {
        if (pack == null) {
            throw new IllegalArgumentException("Package must not be null");
        }

        List<Package> packages = new ArrayList<Package>();
        packages.add(pack);
        this.generateCodeForPackages(language, location, packages);
    }

    /**
     * <p>
     * Generates a directory structure for the given {@link List} of
     * {@link Package}s and generates code for each {@link Classifier} found in
     * the packages. The {@link Classifier}s may be one of the following types:
     * <ul>
     * <li> <code>Class</code>
     * <li> <code>Interface</code>
     * <li> <code>Enumeration</code>
     * </ul>
     * </p>
     *
     * @param language
     *            Language to be generated
     * @param location
     *            location for writing generated classes and packages to
     * @param packages
     *            List of {@link Package} instances to be written
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code> or {@link Package}
     *             list contains <code>null</code> values
     * @throws IllegalArgumentException
     *             if language or location is empty
     * @throws CodeGenerationException
     *             When a problem occurs while writing files or if there are
     *             problems with the configuration.
     */
    public void generateCodeForPackages(String language, String location, List<Package> packages)
        throws CodeGenerationException {
        this.checkLanguageAndLocation(language, location);

        if (packages == null) {
            throw new IllegalArgumentException("Package list must not be null");
        }

        if (packages.contains(null)) {
            throw new IllegalArgumentException("Package list must not contain null values");
        }

        this.prepareLocation(location);

        Generator generator = GeneratorFactory.getGeneratorInstance(language, this, this.namespace);

        for (Package p : packages) {
            this.createPackage(language, location, p, generator);
        }
    }

    /**
     * Prepares the location directory.
     *
     * @param location
     *            location for writing generated classes and packages to
     * @throws CodeGenerationException
     *             if an error occurs cleaning the location
     */
    private void prepareLocation(String location) throws CodeGenerationException {
        if (this.emptyLocationDirectory && !this.codeWriter.deleteDirectory(location, false)) {
            throw new CodeGenerationException("Directory '" + location + "' could not be emptied");
        }
    }

    /**
     * <p>
     * Creates {@link Package}s and contained {@link Classifier}s in a
     * recursive manner.
     * </p>
     *
     * @param language
     *            Language to be generated
     * @param location
     *            location for writing generated classes and packages to
     * @param pack
     *            {@link Package} instance to be written
     * @param generator
     *            {@link Generator} to be used
     * @throws CodeGenerationException
     *             When a problem occurs while writing files or creating
     *             directories
     */
    private void createPackage(String language, String location, Package pack, Generator generator)
        throws CodeGenerationException {
        // make sure the location exists
        new File(location).mkdirs();

        for (ModelElement me : pack.getOwnedElements()) {
            if (me instanceof Package) {
                if (this.createEmptyPackage) {
                    this.codeWriter.createDirectory(location, generator.getPackage((Package) me));
                }

                // recurse to next package
                this.createPackage(language, location, (Package) me, generator);
            } else if (me instanceof Classifier && generator.checkClassifier((Classifier) me)) {
                // we need to create code for classifier
                this.writeClassifier(location, language, (Classifier) me, generator);
            }
        }
    }

    /**
     * <p>
     * Returns the configured property for the Java language.
     * <p>
     *
     * @return the configured property for the Java language.
     */
    public String getLanguageJava() {
        return this.languageJava;
    }

    /**
     * <p>
     * Returns the configured property for the C# language.
     * <p>
     *
     * @return the configured property for the C# language.
     */
    public String getLanguageCSharp() {
        return this.languageCSharp;
    }

    /**
     * <p>
     * Gets an entry form the configuration.
     * </p>
     *
     * @param namesapce
     *            name space to be used
     * @param entry
     *            name of the configuration entry
     * @return the value of the configuration entry
     * @throws GeneratorConfigurationException
     *             if the entry could not be found
     */
    private String getConfigEntry(String namesapce, String entry)
        throws GeneratorConfigurationException {
        try {
            String value = ConfigManager.getInstance().getString(namesapce, entry);

            if ((value == null) || (value.trim().length() == 0)) {
                throw new GeneratorConfigurationException("Could not get " + entry);
            }

            return value;
        } catch (UnknownNamespaceException e) {
            throw new GeneratorConfigurationException("Could not get " + entry, e);
        }
    }
}
