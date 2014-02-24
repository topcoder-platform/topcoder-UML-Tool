/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.stresstests;

import java.net.URL;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.impl.DefaultJarImporter;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * The stress test for class StressDefaultJarImporter.
 *
 * @author extra
 * @version 1.0
 */
public class DefaultJarImporterStressTests extends TestCase {

    /**
     * The DefaultJarImporter instance for testing.
     */
    private StressDefaultJarImporter importer;

    /**
     * The UMLModelManager instance for testing.
     */
    private UMLModelManager modelManager;

    /**
     * The jarPaths for testing.
     */
    private String[] jarPaths;

    /**
     * Sets up test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        modelManager = UMLModelManager.getInstance();
        for (int i = 0; i < 10; i++) {
            Diagram diagram = new Diagram();
            diagram.setName("diagram" + i);
            modelManager.addDiagram(diagram);
        }
        jarPaths = new String[] {"test_files/stresstests/base_exception.jar",
            "test_files/stresstests/object_factory.jar", "test_files/stresstests/configuration_manager.jar" };
        importer = new StressDefaultJarImporter(modelManager, new String[0]);

        super.setUp();
    }

    /**
     * Stress test for method importJarsToDiagram(String[] jarPaths, String diagramName).
     *
     * @throws Exception
     *             to JUnit
     */
    public void testImportJarsToDiagram() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            importer.importJarsToDiagram(jarPaths, "diagram" + i);
        }

        System.out.println("Test method importJarsToDiagram(String[] jarPaths, String diagramName) "
                + "with 10 times, cost time:" + (System.currentTimeMillis() - start) + " miliseconds.");
    }

    /**
     * Mock class extends DefaultJarImporter for testing the protected methods.
     *
     * @author extra
     * @version 1.0
     */
    class StressDefaultJarImporter extends DefaultJarImporter {

        /**
         * Create a new DefaultJarImporter instance.
         *
         * @param modelManager
         *            the UMLModelManager instance
         * @param classpath
         *            the extra classpath to help importing the JARs, can be null.
         * @throws IllegalArgumentException
         *             if modelManager is null or the classpath contains null or the classpathLoader can't be
         *             initialized according the given classpath.
         */
        public StressDefaultJarImporter(UMLModelManager modelManager, URL[] classpath) {
            super(modelManager, classpath);
        }

        /**
         * Create a new DefaultJarImporter instance.
         *
         * @param classpath
         *            the extra classpath to help importing the JARs, can be null.
         * @param modelManager
         *            the UMLModelManager instance
         * @throws IllegalArgumentException
         *             if modelManager is null or the classpath contains null/empty string or the classpathLoader can't
         *             be initialized according the given classpath.
         */
        public StressDefaultJarImporter(UMLModelManager modelManager, String[] classpath) {
            super(modelManager, classpath);
        }

        /**
         * Protected getter for the classes field.
         *
         * @return the classes instance
         */
        protected Map<String, Class<?>> getClasses() {
            return super.getClasses();
        }

        /**
         * Protected getter for the classesToRelationships field.
         *
         * @return the classesToRelationships instance
         */
        protected Map<Classifier, List<Relationship>> getClassesToRelationships() {
            return super.getClassesToRelationships();
        }

        /**
         * Protected getter for the externalClasses field.
         *
         * @return the externalClasses instance
         */
        protected Map<String, Class<?>> getExternalClasses() {
            return super.getExternalClasses();
        }

        /**
         * Protected getter for the modelCLasses field.
         *
         * @return the modelCLasses instance
         */
        protected Map<String, Classifier> getModelClasses() {
            return super.getModelClasses();
        }

        /**
         * Protected getter for the modelManager field.
         *
         * @return the modelManager instance
         */
        protected UMLModelManager getModelManager() {
            return super.getModelManager();
        }

        /**
         * Protected getter for the modelPackages field.
         *
         * @return the modelPackages instance
         */
        protected Map<String, Package> getModelPackages() {
            return super.getModelPackages();
        }

        /**
         * Protected getter for the packages field.
         *
         * @return the packages instance
         */
        protected Map<String, java.lang.Package> getPackages() {
            return super.getPackages();
        }

        /**
         * Protected getter for the relationships field.
         *
         * @return the relationships instance
         */
        protected List<Relationship> getRelationships() {
            return super.getRelationships();
        }

    }
}
