/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.errorhandling.ExceptionUtils;

/**
 * <p>
 * This abstract class defines the APIs to import JARs to TC UML model and diagram.
 * </p>
 * <p>
 * <ul>
 * It defines three steps to achieve this purpose:
 * <li>first, pull all the classes and packages from the JARs;</li>
 * <li>second, import the packages, classes, related external classes, relationships to the model;</li>
 * <li>third, import all the entities pulled from JARs into a specific diagram;</li>
 * </ul>
 * </p>
 * <p>
 * The implementation of them is left to the subclasses.
 * </p>
 * <p>
 * This class also defines many variables to store the state of the importing.
 * </p>
 *
 * <p>
 * Thread-safety: This class and the subclasses are not thread-safe because it has inner state when
 * importing.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public abstract class JarImporter {
    /**
     * <p>
     * Represents the model manager instance in which the model and diagram can be retrieved.
     * </p>
     * <p>
     * Initialized in the constructor, not change after that. Can't be null.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final UMLModelManager modelManager;

    /**
     * <p>
     * Represents the packages pulled from the input JARs.
     * </p>
     * <p>
     * The key is the package name, can't be null, can be empty. The value is the
     * <code>java.lang.Package</code> instance, it is retrieved by reflection, but it can be null.
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final Map<String, java.lang.Package> packages = new HashMap<String, java.lang.Package>();

    /**
     * <p>
     * Represents the classes pulled from the input JARs.
     * </p>
     * <p>
     * The key is the class binary name, can't be null or empty. The value is the Class instance, it
     * is retrieved by reflection, can't be null.
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final Map<String, Class<?>> classes = new HashMap<String, Class<?>>();

    /**
     * <p>
     * Represents the external classes referenced by the classes pulled from the input JARs.
     * </p>
     * <p>
     * The key is the class binary name, can't be null or empty. The value is the Class instance, it
     * is retrieved by reflection, can't be null.
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final Map<String, Class<?>> externalClasses = new HashMap<String, Class<?>>();

    /**
     * <p>
     * Represents the packages added in TC UML Model, the key is the package name, can't be null,
     * can be empty.
     * </p>
     * <p>
     * The value is the <code>com.topcoder.uml.model.modelmanagement.Package</code> instance in TC
     * UML Model. Can't be null. The key can be the package name of 'java.*'
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final Map<String, Package> modelPackages = new HashMap<String, Package>();

    /**
     * <p>
     * Represents the classes added in TC UML Model, the key is the class binary name, can't be null
     * or empty.
     * </p>
     * <p>
     * The value is the <code>Classifier</code> instance in TC UML Model. Can't be null.
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final Map<String, Classifier> modelClasses = new HashMap<String, Classifier>();

    /**
     * <p>
     * Represents the relationships added in Model, the relationships is related to the classes
     * pulled from JARs.
     * </p>
     * <p>
     * The element is the <code>Relationship</code> instance in TC UML Model. Can't be null.
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final List<Relationship> relationships = new ArrayList<Relationship>();

    /**
     * <p>
     * Represents the map from <code>Classifier</code> to a list of <code>Relationship</code>,
     * the key is the <code>Classifier</code> instanced added in Model, can't be null.
     * </p>
     * <p>
     * The value is the relationships related to that <code>Classifier</code> instance. Can't be
     * null, can be empty.
     * </p>
     * <p>
     * Initialized as empty map, not change after that. Can't be null. Can be empty.
     * </p>
     * <p>
     * Accessed by the protected getter.
     * </p>
     */
    private final Map<Classifier, List<Relationship>> classesToRelationships =
        new HashMap<Classifier, List<Relationship>>();

    /**
     * Create a new <code>JarImporter</code> instance with the given <code>UMLModelManager</code>
     * instance.
     *
     * @throws IllegalArgumentException - if the parameter is null.
     * @param modelManager the UMLModelManager instance.
     */
    protected JarImporter(UMLModelManager modelManager) {
        ExceptionUtils.checkNull(modelManager, null, null, "modelManager can not be null.");
        this.modelManager = modelManager;
    }

    /**
     * Convert the given file paths to <code>URL</code> instances.
     *
     * @param strings the array of file paths.
     * @return the convert array of <code>URL</code>.
     * @throws IllegalArgumentException if the parameter is null or contains null or empty string or
     * the length of jarPaths is 0 or any path does not exist.
     * @throws JarImporterException if error when coverting jar path.
     */
    private static final URL[] covertJarPaths(String[] strings) throws JarImporterException {
        ExceptionUtils.checkNull(strings, null, null, "jarPaths can not be null.");
        if (strings.length == 0) {
            throw new IllegalArgumentException("jarPaths can not be empty.");
        }
        URL[] urls = new URL[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ExceptionUtils.checkNullOrEmpty(strings[i], null, null,
                "jarPaths#element can not be null or empty.");
            try {
                urls[i] = new File(strings[i]).toURI().toURL();
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("Error when accessing the url with path '"
                    + strings[i] + "' for " + e.getMessage(), e);
            } catch (SecurityException se) {
                throw new IllegalArgumentException("Error when accessing the path '" + strings[i]
                    + "' for " + se.getMessage(), se);
            }
        }

        return urls;
    }

    /**
     * <p>
     * Import the JARs into the TC UML Model.
     * </p>
     * <p>
     * The given JARs will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model housed in the <code>UMLModelManager</code> instance provided.
     * </p>
     *
     * @param jarPaths the paths of the JARS to be imported.
     * @throws IllegalArgumentException - if the parameter is null or contains null or empty string
     * or the length of jarPaths is 0 or any path does not exist.
     * @throws JarImporterException - if any error occurred when importing the JARs
     */
    public void importJars(String[] jarPaths) throws JarImporterException {
        this.importJars(covertJarPaths(jarPaths));
    }

    /**
     * <p>
     * Import the JARs into the TC UML Model.
     * </p>
     * <p>
     * The given JARs will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model housed in the <code>UMLModelManager</code> instance provided.
     * </p>
     *
     * @param jarURLs the URLs of the JARs to be imported.
     * @throws IllegalArgumentException - if the parameter is null or contains null element or the
     * length of jarPaths is 0 or any URL does not exist.
     * @throws JarImporterException - if any error occurred when importing the JARs
     */
    public void importJars(URL[] jarURLs) throws JarImporterException {
        checkURLs(jarURLs);

        // Clear all the map and list variable in this instance.
        this.packages.clear();
        this.classes.clear();
        this.externalClasses.clear();
        this.modelPackages.clear();
        this.modelClasses.clear();
        this.relationships.clear();
        this.classesToRelationships.clear();

        this.retrievePackagesAndClassesFromJars(jarURLs);
        this.extractExternalClasses();
        this.importPackagesAndClassesToModel();
    }

    /**
     * Check the given array of <code>URL</code> instances are valid.
     *
     * @param jarURLs the given array of <code>URL</code> instances to check.
     */
    private static final void checkURLs(URL[] jarURLs) {
        ExceptionUtils.checkNull(jarURLs, null, null, "jarURLs can not be null.");
        if (jarURLs.length == 0) {
            throw new IllegalArgumentException("jarURLs can not be empty.");
        }
        for (int i = 0; i < jarURLs.length; i++) {
            ExceptionUtils.checkNull(jarURLs[i], null, null, "jarURLs#element can not be null.");
            try {
                if (!new File(jarURLs[i].getFile()).exists()) {
                    throw new IllegalArgumentException("the URL[" + jarURLs[i] + "] elment does not exist.");
                }
            } catch (SecurityException se) {
                throw new IllegalArgumentException("Error checking URL elment exist or not.", se);
            }
        }
    }

    /**
     * <p>
     * Import the JARs into the TC UML Model and the specified diagram.
     * </p>
     * <p>
     * The given JARs will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model and diagram housed in the <code>UMLModelManager</code> instance
     * provided.
     * </p>
     *
     * @param diagramName the name of the diagram to accept the JARs.
     * @param jarURLs the URLs of the JARS to be imported.
     * @throws IllegalArgumentException - if any parameter is null or diagramName is empty or the
     * diagram doesn't exist or the length of jarURLs is 0 or of any URL is null or does not exist.
     * @throws JarImporterException - if any error occurred when importing the JARs
     */
    public void importJarsToDiagram(URL[] jarURLs, String diagramName) throws JarImporterException {
        checkURLs(jarURLs);
        ExceptionUtils.checkNull(diagramName, null, null, "diagramName can not be null or empty.");

        // Find the diagram with the given name. if not found, throw IllegalArgumentException
        Diagram diagram = null;

        // get the diagram
        for (Diagram d : modelManager.getDiagrams()) {
            // Not sure d.getName() will be null or not.
            if (diagramName.equals(d.getName())) {
                diagram = d;

                // the loop should break.
                break;
            }
        }
        if (diagram == null) {
            throw new IllegalArgumentException("the diagram with name '" + diagramName
                + "' is not found.");
        }

        this.importJars(jarURLs);
        this.importToDiagram(diagram);
    }

    /**
     * <p>
     * Import the JARs into the TC UML Model and the specified diagram.
     * </p>
     * <p>
     * The given JARs will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model and diagram housed in the <code>UMLModelManager</code> instance
     * provided.
     * </p>
     *
     * @param diagramName the name of the diagram to accept the JARs
     * @param jarPaths the paths of the JARS to be imported.
     * @throws IllegalArgumentException - if any parameter is null or diagramName is empty or the
     * diagram doesn't exist or the length of jarPaths is 0 or of any path is null or empty or does
     * not exist.
     * @throws JarImporterException - if any error occurred when importing the JARs
     */
    public void importJarsToDiagram(String[] jarPaths, String diagramName)
        throws JarImporterException {
        this.importJarsToDiagram(covertJarPaths(jarPaths), diagramName);
    }

    /**
     * <p>
     * Import the JAR into the TC UML Model.
     * </p>
     * <p>
     * The given JAR will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model housed in the <code>UMLModelManager</code> instance provided.
     * </p>
     *
     * @param jarPath the path of the JAR to be imported
     * @throws IllegalArgumentException - if the parameter is null or empty, or the given jar
     * doesn't exist
     * @throws JarImporterException - if any error occurred when importing the JARs
     */
    public void importJar(String jarPath) throws JarImporterException {
        this.importJars(new String[] {jarPath});
    }

    /**
     * <p>
     * Import the JAR into the TC UML Model.
     * </p>
     * <p>
     * The given JAR will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model housed in the <code>UMLModelManager</code> instance provided.
     * </p>
     *
     * @param jarURL the URL of the JAR to be imported
     * @throws IllegalArgumentException - if the parameter is null, or the given jar doesn't exist
     * @throws JarImporterException - if any error occurred when importing the JARs
     */
    public void importJar(URL jarURL) throws JarImporterException {
        this.importJars(new URL[] {jarURL});
    }

    /**
     * <p>
     * Import the JAR into the TC UML Model and the specified diagram.
     * </p>
     * <p>
     * The given JARs will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model and diagram housed in the <code>UMLModelManager</code> instance
     * provided.
     * </p>
     *
     * @param jarURL the URL of the JAR to be imported.
     * @param diagramName the name of the diagram to accept the JAR
     * @throws IllegalArgumentException - if any parameter is null/empty or the diagram doesn't
     * exist or the jar does not exist.
     * @throws JarImporterException - if any error occurred when importing the JAR
     */
    public void importJarToDiagram(URL jarURL, String diagramName) throws JarImporterException {
        this.importJarsToDiagram(new URL[] {jarURL}, diagramName);
    }

    /**
     * <p>
     * Import the JAR into the TC UML Model and the specified diagram.
     * </p>
     * <p>
     * The given JARs will be processed to pull all interface, class, operation, and attribute
     * information, as well as the corresponding visibility, final, static, and abstract modifiers
     * into the project model and diagram housed in the <code>UMLModelManager</code> instance
     * provided.
     * </p>
     *
     * @param jarPath the path of the JAR to be imported
     * @param diagramName the name of the diagram to accept the JAR
     * @throws IllegalArgumentException - if any parameter is null/empty or the diagram doesn't
     * exist or the path does not exist.
     * @throws JarImporterException - if any error occurred when importing the JAR
     */
    public void importJarToDiagram(String jarPath, String diagramName) throws JarImporterException {
        this.importJarsToDiagram(new String[] {jarPath}, diagramName);
    }

    /**
     * Protected getter for the 'modelManager' field.
     *
     * @return the value of the 'modelManager' field
     */
    protected UMLModelManager getModelManager() {
        return this.modelManager;
    }

    /**
     * Protected getter for the 'packages' field.
     *
     * @return the value of the 'packages' field
     */
    protected Map<String, java.lang.Package> getPackages() {
        return this.packages;
    }

    /**
     * Protected getter for the 'classes' field.
     *
     * @return the value of the 'classes' field
     */
    protected Map<String, Class<?>> getClasses() {
        return this.classes;
    }

    /**
     * Protected getter for the 'externalClasses' field.
     *
     * @return the value of the 'externalClasses' field
     */
    protected Map<String, Class<?>> getExternalClasses() {
        return this.externalClasses;
    }

    /**
     * Protected getter for the 'modelPackages' field.
     *
     * @return the value of the 'modelPackages' field
     */
    protected Map<String, Package> getModelPackages() {
        return this.modelPackages;
    }

    /**
     * Protected getter for the 'modelClasses' field.
     *
     * @return the value of the 'modelClasses' field
     */
    protected Map<String, Classifier> getModelClasses() {
        return this.modelClasses;
    }

    /**
     * Protected getter for the 'relationships' field.
     *
     * @return the value of the 'relationships' field
     */
    protected List<Relationship> getRelationships() {
        return this.relationships;
    }

    /**
     * Protected getter for the 'classesToRelationships' field.
     *
     * @return the value of the 'classesToRelationships' field
     */
    protected Map<Classifier, List<Relationship>> getClassesToRelationships() {
        return this.classesToRelationships;
    }

    /**
     * Pull the packages and classes defined in the given JARs, and store the result in packages and
     * classes variable.
     *
     * @param jarURLs the URLs of the JARS to be imported.
     * @throws JarImporterException - if any error occurred when processing the JARs.
     */
    protected abstract void retrievePackagesAndClassesFromJars(URL[] jarURLs)
        throws JarImporterException;

    /**
     * Extracts the external classes for the classes retrieved from JARs.
     *
     * @throws JarImporterException - if any error occurred when extracting the external classes
     */
    protected abstract void extractExternalClasses() throws JarImporterException;

    /**
     * <p>
     * Import the packages and classes into the TC UML Model.
     * </p>
     * <p>
     * All the external classes and relationships referenced by the classes are also imported into
     * Model.
     * </p>
     * <p>
     * After imported, the externalClasses, modelPackages, modelClasses, relationships and
     * classesToRelationships will be populated.
     * </p>
     *
     * @throws JarImporterException - if any error occurred when importing to Model
     */
    protected abstract void importPackagesAndClassesToModel() throws JarImporterException;

    /**
     * Import all the entities populated in the previous step to a specific diagram.
     *
     * @param diagram the Diagram instance which accept the entities.
     * @throws JarImporterException - if any error occurred when importing entities to diagram
     */
    protected abstract void importToDiagram(Diagram diagram) throws JarImporterException;
}
