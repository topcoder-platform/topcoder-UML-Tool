/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.accuracytests;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.JarImporter;
import com.topcoder.uml.importer.jarimporter.JarImporterException;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Set of tests for testing JarImporter class.
 * @author vilain
 * @version 1.0
 */
public class JarImporterAccuracyTest extends TestCase {

    /**
     * Instance of UMLModelManager for testing.
     */
    private UMLModelManager modelManager;

    /**
     * Instance of JarImporter for testing.
     */
    private JarImporterMock jarImporter;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        modelManager = new UMLModelManager();
        Diagram diagram = new Diagram();
        diagram.setName("main");
        modelManager.addDiagram(diagram);
        jarImporter = new JarImporterMock(modelManager);
    }

    /**
     * Constructor under test JarImporter(UMLModelManager). Accuracy testing of
     * correctly set modelManager.
     */
    public final void testJarImporter() {
        JarImporterMock currentJarImporter = new JarImporterMock(modelManager);
        // testing
        assertNotNull("JarImport was not initialized successfully", currentJarImporter);
        assertSame("modelManagers must be the same", modelManager, currentJarImporter.getModelManager());
    }

    /**
     * Method under test JarImporter.importJars(String[]). Accuracy testing of
     * successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarsStringArray() throws Exception {
        // run successfully
        jarImporter.importJars(new String[] {"test_files/accuracytests/classpath/test_1.jar" });
    }

    /**
     * Method under test JarImporter.importJars(URL[]). Accuracy testing of
     * successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarsURLArray() throws Exception {
        // run successfully
        jarImporter.importJars(new URL[] {new File("test_files/accuracytests/classpath/test_1.jar").toURI().toURL() });
    }

    /**
     * Method under test JarImporter.importJarsToDiagram(String[], String).
     * Accuracy testing of successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarsToDiagramURLArrayString() throws Exception {
        // run successfully
        jarImporter.importJarsToDiagram(new String[] {"test_files/accuracytests/classpath/test_1.jar" }, "main");
    }

    /**
     * Method under test JarImporter.importJarsToDiagram(URL[], String).
     * Accuracy testing of successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarsToDiagramStringArrayString() throws Exception {
        // run successfully
        jarImporter.importJarsToDiagram(new URL[] {new File("test_files/accuracytests/classpath/test_1.jar").toURI()
            .toURL() }, "main");
    }

    /**
     * Method under test JarImporter.getModelManager(). Accuracy testing of
     * correctly retrieved modelManager.
     */
    public final void testGetModelManager() {
        assertSame("modelManagers must be the same", modelManager, jarImporter.getModelManager());
    }

    /**
     * Method under test JarImporter.getPackages(). Accuracy testing of
     * correctly retrieved packages.
     */
    public final void testGetPackages() {
        assertNotNull("packages must not be null", jarImporter.getPackages());
        assertTrue("packages must be empty", jarImporter.getPackages().isEmpty());
    }

    /**
     * Method under test JarImporter.getClasses(). Accuracy testing of correctly
     * retrieved classes.
     */
    public final void testGetClasses() {
        assertNotNull("classes must not be null", jarImporter.getClasses());
        assertTrue("classes must be empty", jarImporter.getClasses().isEmpty());
    }

    /**
     * Method under test JarImporter.getExternalClasses(). Accuracy testing of
     * correctly retrieved externalClasses.
     */
    public final void testGetExternalClasses() {
        assertNotNull("externalClasses must not be null", jarImporter.getExternalClasses());
        assertTrue("externalClasses must be empty", jarImporter.getExternalClasses().isEmpty());
    }

    /**
     * Method under test JarImporter.getModelPackages(). Accuracy testing of
     * correctly retrieved modelPackages.
     */
    public final void testGetModelPackages() {
        assertNotNull("modelPackages must not be null", jarImporter.getModelPackages());
        assertTrue("modelPackages must be empty", jarImporter.getModelPackages().isEmpty());
    }

    /**
     * Method under test JarImporter.getModelClasses(). Accuracy testing of
     * correctly retrieved modelClasses.
     */
    public final void testGetModelClasses() {
        assertNotNull("modelClasses must not be null", jarImporter.getModelClasses());
        assertTrue("modelClasses must be empty", jarImporter.getModelClasses().isEmpty());
    }

    /**
     * Method under test JarImporter.getRelationships(). Accuracy testing of
     * correctly retrieved relationships.
     */
    public final void testGetRelationships() {
        assertNotNull("relationships must not be null", jarImporter.getRelationships());
        assertTrue("relationships must be empty", jarImporter.getRelationships().isEmpty());
    }

    /**
     * Method under test JarImporter.getClassesToRelationships(). Accuracy
     * testing of correctly retrieved classesToRelationships.
     */
    public final void testGetClassesToRelationships() {
        assertNotNull("classesToRelationships must not be null", jarImporter.getClassesToRelationships());
        assertTrue("classesToRelationships must be empty", jarImporter.getClassesToRelationships().isEmpty());
    }

    /**
     * Method under test JarImporter.importJars(String). Accuracy testing of
     * successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarStringArray() throws Exception {
        // run successfully
        jarImporter.importJar("test_files/accuracytests/classpath/test_1.jar");
    }

    /**
     * Method under test JarImporter.importJars(URL). Accuracy testing of
     * successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarURLArray() throws Exception {
        // run successfully
        jarImporter.importJar(new File("test_files/accuracytests/classpath/test_1.jar").toURI().toURL());
    }

    /**
     * Method under test JarImporter.importJarsToDiagram(String, String).
     * Accuracy testing of successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarToDiagramURLArrayString() throws Exception {
        // run successfully
        jarImporter.importJarToDiagram("test_files/accuracytests/classpath/test_1.jar", "main");
    }

    /**
     * Method under test JarImporter.importJarsToDiagram(URL, String). Accuracy
     * testing of successful running.
     * @throws Exception wraps all exceptions
     */
    public final void testImportJarToDiagramStringArrayString() throws Exception {
        // run successfully
        jarImporter.importJarToDiagram(new File("test_files/accuracytests/classpath/test_1.jar").toURI().toURL(),
            "main");
    }

    /**
     * Mock implementation of JarImporter.
     * @author vilain
     */
    public class JarImporterMock extends JarImporter {

        public JarImporterMock(UMLModelManager modelManager) {
            super(modelManager);
        }

        public UMLModelManager getModelManager() {
            return super.getModelManager();
        }

        public Map<String,java.lang.Package> getPackages() {
            return super.getPackages();
        }

        public Map<String,Class<?>> getClasses() {
            return super.getClasses();
        }

        public Map<String,Class<?>> getExternalClasses() {
            return super.getExternalClasses();
        }

        public Map<String,com.topcoder.uml.model.modelmanagement.Package> getModelPackages() {
            return super.getModelPackages();
        }

        public Map<String,Classifier> getModelClasses() {
            return super.getModelClasses();
        }

        public List<Relationship> getRelationships() {
            return super.getRelationships();
        }

        public Map<Classifier,List<Relationship>> getClassesToRelationships() {
            return super.getClassesToRelationships();
        }

        protected void extractExternalClasses() {
        }

        protected void importPackagesAndClassesToModel() {
        }

        protected void importToDiagram(Diagram diagram) {
        }

        protected void retrievePackagesAndClassesFromJars(URL[] jarURLs) throws JarImporterException {
        }
    }
}