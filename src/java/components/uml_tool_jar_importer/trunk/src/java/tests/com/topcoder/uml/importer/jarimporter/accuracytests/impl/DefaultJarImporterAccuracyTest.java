/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.accuracytests.impl;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.test.TestClassFirst;
import com.topcoder.test.unter.TestClassSecond;
import com.topcoder.uml.importer.jarimporter.JarImporterException;
import com.topcoder.uml.importer.jarimporter.impl.DefaultJarImporter;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Set of accuracy tests for testing DefaultJarImporter class.
 * @author vilain
 * @version 1.0
 */
public class DefaultJarImporterAccuracyTest extends TestCase {

    /**
     * Instance of UMLModelManager for testing.
     */
    private UMLModelManager modelManager;

    /**
     * Instance of DefaultJarImporter for testing.
     */
    private DefaultJarImporterMock defaultJarImporter;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        modelManager = new UMLModelManager();
        Diagram diagram = new Diagram();
        diagram.setName("main");
        modelManager.addDiagram(diagram);
        defaultJarImporter =
            new DefaultJarImporterMock(modelManager,
                new String[] {"test_files/accuracytests/classpath/base_exception.jar" });
    }

    /**
     * Constructor under test DefaultJarImporterMock(UMLModelManager, URL[]).
     * Accuracy testing of successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testDefaultJarImporterUMLModelManagerURLArray() throws Exception {
        // run successfully
        new DefaultJarImporter(modelManager, new URL[] {new File(
            "test_files/accuracytests/classpath/base_exception.jar").toURI().toURL() });
    }

    /**
     * Constructor under test DefaultJarImporterMock(UMLModelManager, String[]).
     * Accuracy testing of successful running.
     */
    public final void testDefaultJarImporterUMLModelManagerStringArray() {
        // run successfully
        new DefaultJarImporter(modelManager, new String[] {"test_files/accuracytests/classpath/base_exception.jar" });
    }

    /**
     * Method under test JarImporter.retrievePackagesAndClassesFromJars(URL[]).
     * Accuracy testing of successfully retrieved classes from jars.
     * @throws Exception wraps all exceptions
     */
    public final void testRetrievePackagesAndClassesFromJarsTestClasses() throws Exception {
        // running successfully
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        Map<String,Class<?>> classes = defaultJarImporter.getClasses();
        // testing of added classes
        checkClass(classes, TestClassFirst.class);
        checkClass(classes, TestClassSecond.class);
    }

    /**
     * Method under test JarImporter.retrievePackagesAndClassesFromJars(URL[]).
     * Accuracy testing of successfully retrieved packages from jars.
     * @throws Exception wraps all exceptions
     */
    public final void testRetrievePackagesAndClassesFromJarsTestPackages() throws Exception {
        // running successfully
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        Map<String,Package> packages = defaultJarImporter.getPackages();
        // testing of added packages
        checkPackage(packages, TestClassFirst.class.getPackage());
        checkPackage(packages, TestClassSecond.class.getPackage());
    }

    /**
     * Method under test JarImporter.extractExternalClasses(). Accuracy testing
     * of successfully retrieved external classes.
     * @throws Exception wraps all exceptions
     */
    public final void testExtractExternalClasses() throws Exception {
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        // running successfully
        defaultJarImporter.extractExternalClasses();
        // getting external classes
        Map<String,Class<?>> externalClasses = defaultJarImporter.getExternalClasses();
        // checking for Serializable
        checkClass(externalClasses, Serializable.class);
        // checking for Runnable
        checkClass(externalClasses, Runnable.class);
        // checking for GregorianCalendar
        checkClass(externalClasses, GregorianCalendar.class);
        // checking for String
        checkClass(externalClasses, String.class);
        // checking for Integer
        checkClass(externalClasses, Integer.class);
        // checking for java.sql.Date
        checkClass(externalClasses, Date.class);
        // checking for long
        checkClass(externalClasses, long.class);
        // checking for java.util.Date
        checkClass(externalClasses, java.util.Date.class);
        // checking for boolean
        checkClass(externalClasses, boolean.class);
        // checking for List
        checkClass(externalClasses, List.class);
    }

    /**
     * Method under test JarImporter.extractExternalClasses(). Accuracy testing
     * of successfully retrieved external packages.
     * @throws Exception wraps all exceptions
     */
    public final void testExtractExternalPackages() throws Exception {
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        // running successfully
        defaultJarImporter.extractExternalClasses();
        // getting packages
        Map<String,Package> packages = defaultJarImporter.getPackages();
        // checking for Serializable
        checkPackage(packages, Serializable.class.getPackage());
        // checking for Runnable
        checkPackage(packages, Runnable.class.getPackage());
        // checking for GregorianCalendar
        checkPackage(packages, GregorianCalendar.class.getPackage());
        // checking for String
        checkPackage(packages, String.class.getPackage());
        // checking for Integer
        checkPackage(packages, Integer.class.getPackage());
        // checking for java.sql.Date
        checkPackage(packages, Date.class.getPackage());
        // checking for java.util.Date
        checkPackage(packages, java.util.Date.class.getPackage());
        // checking for List
        checkPackage(packages, List.class.getPackage());
    }

    /**
     * Checking whether the class is added to classes.
     * @param classes classes for checking
     * @param clazz class for checking
     */
    private void checkClass(Map<String,Class<?>> classes, Class<?> clazz) {
        assertTrue("class must be added", classes.containsKey(clazz.getName()));
        assertTrue("class must be added", classes.containsValue(clazz));
    }

    /**
     * Checking whether the package is added to packages.
     * @param packages packages
     * @param packagge package
     */
    private void checkPackage(Map<String,Package> packages, Package packagge) {
        assertTrue("package must be added", packages.containsKey(packagge.getName()));
        assertTrue("package must be added", packages.containsValue(packagge));
    }

    /**
     * Method under test JarImporter.importPackagesAndClassesToModel(). Accuracy
     * testing of successfully imported packages and classes to model.
     * @throws Exception wraps all exceptions
     */
    public final void testImportPackagesAndClassesToModelPackages() throws Exception {
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        defaultJarImporter.extractExternalClasses();
        // running successfully
        defaultJarImporter.importPackagesAndClassesToModel();
        //
        Map<String,com.topcoder.uml.model.modelmanagement.Package> packages = defaultJarImporter.getModelPackages();
        assertEquals("the number of expected packages is 7", 7, packages.size());

        // check the packages
        assertTrue("the package is missed", packages.containsKey(""));
        assertTrue("the package is missed", packages.containsKey("java.sql"));
        assertTrue("the package is missed", packages.containsKey("com.topcoder.test.unter"));
        assertTrue("the package is missed", packages.containsKey("com.topcoder.test"));
        assertTrue("the package is missed", packages.containsKey("java.util"));
        assertTrue("the package is missed", packages.containsKey("java.lang"));
    }

    /**
     * Method under test JarImporter.importPackagesAndClassesToModel(). Accuracy
     * testing of successfully imported packages and classes to model.
     * @throws Exception wraps all exceptions
     */
    public final void testImportPackagesAndClassesToModelClasses() throws Exception {
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        defaultJarImporter.extractExternalClasses();
        // running successfully
        defaultJarImporter.importPackagesAndClassesToModel();
        // getting classes
        Map<String,Classifier> classes = defaultJarImporter.getModelClasses();
        assertEquals("the number of expected packages is 13", 13, classes.size());
        // checking classes
        checkClassImpl(classes, "java.lang.String");
        checkClassImpl(classes, "java.lang.Object");
        checkInterfaceImpl(classes, "java.lang.Runnable");
        checkClassImpl(classes, "java.util.Date");
        checkClassImpl(classes, "java.sql.Date");
        checkPrimitiveImpl(classes, "boolean");
        checkPrimitiveImpl(classes, "long");
        checkClassImpl(classes, "com.topcoder.test.TestClassFirst");
        checkClassImpl(classes, "com.topcoder.test.unter.TestClassSecond");
        checkClassImpl(classes, "java.lang.Integer");
        checkClassImpl(classes, "java.util.GregorianCalendar");
        checkInterfaceImpl(classes, "java.util.List");
        checkInterfaceImpl(classes, "java.io.Serializable");
    }

    /**
     * Checking for class.
     * @param classes classes
     * @param key key
     */
    private void checkClassImpl(Map<String,Classifier> classes, String key) {
        assertTrue("the class is missed", classes.containsKey(key));
        assertTrue("must be of instance ClassImpl", classes.get(key) instanceof ClassImpl);
    }

    /**
     * Checking for primitive.
     * @param classes classes
     * @param key key
     */
    private void checkPrimitiveImpl(Map<String,Classifier> classes, String key) {
        assertTrue("the class is missed", classes.containsKey(key));
        assertTrue("must be of instance PrimitiveImpl", classes.get(key) instanceof PrimitiveImpl);
    }

    /**
     * Checking for interface.
     * @param classes classes
     * @param key key
     */
    private void checkInterfaceImpl(Map<String,Classifier> classes, String key) {
        assertTrue("the class is missed", classes.containsKey(key));
        assertTrue("must be of instance InterfaceImpl", classes.get(key) instanceof InterfaceImpl);
    }

    /**
     * Method under test JarImporter.importToDiagram(Digram). Accuracy testing
     * of successfully imported packages and classes to diagram.
     * @throws Exception wraps all exceptions
     */
    public void testImportToDiagram() throws Exception {
        defaultJarImporter.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
        defaultJarImporter.extractExternalClasses();
        defaultJarImporter.importPackagesAndClassesToModel();
        // running successfully
        Diagram diagram = new Diagram();
        defaultJarImporter.importToDiagram(diagram);
        // checking for the number of containeds
        assertEquals("the number of containeds must be 6", 6, diagram.getContaineds().size());
    }

    /**
     * Mock implementation of DefaultJarImporter.
     * @author vilain
     */
    public class DefaultJarImporterMock extends DefaultJarImporter {

        public DefaultJarImporterMock(UMLModelManager modelManager, String[] classpath) {
            super(modelManager, classpath);
        }

        public void retrievePackagesAndClassesFromJars(URL[] jarURLs) throws JarImporterException {
            super.retrievePackagesAndClassesFromJars(jarURLs);
        }

        public void extractExternalClasses() throws JarImporterException {
            super.extractExternalClasses();
        }

        public void importPackagesAndClassesToModel() throws JarImporterException {
            super.importPackagesAndClassesToModel();
        }

        public void importToDiagram(Diagram diagram) throws JarImporterException {
            super.importToDiagram(diagram);
        }

        public Map<String,Package> getPackages() {
            return super.getPackages();
        }

        public Map<String,com.topcoder.uml.model.modelmanagement.Package> getModelPackages() {
            return super.getModelPackages();
        }

        public Map<String,Class<?>> getClasses() {
            return super.getClasses();
        }

        public Map<String,Classifier> getModelClasses() {
            return super.getModelClasses();
        }

        public Map<String,Class<?>> getExternalClasses() {
            return super.getExternalClasses();
        }
    }
}