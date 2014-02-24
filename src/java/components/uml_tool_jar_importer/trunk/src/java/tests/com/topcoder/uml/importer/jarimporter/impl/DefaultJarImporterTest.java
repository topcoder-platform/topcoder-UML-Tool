/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * DefaultJarImporterTest.java
 */
package com.topcoder.uml.importer.jarimporter.impl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.JarImporterException;
import com.topcoder.uml.modelmanager.UMLModelManager;
/**
 * <p>Unit tests for <code>DefaultJarImporter</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class DefaultJarImporterTest extends TestCase {
    /**
     * <p>
     * Classpath for base_exception, used in testing.
     * </p>
     */
    private static final String testEntitiesClasspath = "test_files/base_exception.jar";

    /**
     * <p>
     * Path to first jar for sample test classes, used in testing.
     * </p>
     */
    private static final String testEntitiesJarPath1 = "test_files/test1.jar";

    /**
     * <p>
     * Path to second jar for sample test classes, used in testing.
     * </p>
     */
    private static final String testEntitiesJarPath2 = "test_files/test1.jar";

    /**
     * <p>
     * Path to corrupted jar.
     * </p>
     */
    private static final String corruptedJarPath = "test_files/corrupted.jar";

    /**
     * <p>
     * Path to unexisting jar.
     * </p>
     */
    private static final String unexistingJarPath = "unexisting_path/unexisting.jar";

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultJarImporterTest.class);
    }

    /**
     * <p>
     * UMLModelManager, used in creating JarImporter.
     * </p>
     * <p>
     * Instantinates in setUp method, can't be null.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Setup the tests. Instantinates UMLModelManager
     * </p>
     */
    public void setUp() {
        manager = UMLModelManager.getInstance();
    }

    /**
     * <p>
     * TearDown the tests.
     * </p>
     */
    public void tearDown() {
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>DefaultJarImporter(UMLModelManager, String[])</code>.
     * </p>
     */
    public void testCtorAccuracy1() {
        try {
            String[] urls = new String[1];
            urls[0] = testEntitiesClasspath;

            new DefaultJarImporter(manager, urls);
        } catch (IllegalArgumentException exception) {
            fail("IllegalArgumentException shouldn't be thrown");
        }
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>DefaultJarImporter(UMLModelManager, String[])</code>.
     * </p>
     * <p>
     * Passing classpath as null for constructor
     * </p>
     */
    public void testCtorWithNullClasspathAccuracy() {
        try {
            String[] urls = null;

            new DefaultJarImporter(manager, urls);
        } catch (IllegalArgumentException exception) {
            fail("IllegalArgumentException shouldn't be thrown");
        }
    }

    /**
     * <p>
     * Failure test for constructor
     * <code>DefaultJarImporter(UMLModelManager, String[])</code>.
     * </p>
     * <p>
     * Passing null as an element of classpath
     * </p>
     */
    public void testCtorForClasspathFailure1() {
        try {
            String[] classpath = new String[1];
            classpath[0] = null;
            new DefaultJarImporter(manager, classpath);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        }
    }

    /**
     * <p>
     * Failure test for constructor
     * <code>DefaultJarImporter(UMLModelManager, String[])</code>.
     * </p>
     * <p>
     * Passing unexisting element of classpath
     * </p>
     */
    public void testCtorForClasspathFailure2() {
        try {
            String[] classpath = new String[1];
            classpath[0] = unexistingJarPath;
            new DefaultJarImporter(manager, classpath);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        }
    }

    /**
     * <p>
     * Accuracy test for constructor
     * <code>DefaultJarImporter(UMLModelManager, URL[])</code>.
     * </p>
     */
    public void testURLCtorAccuracy() {
        try {
            URL[] urls = new URL[1];

            try {
                urls[0] = new File(testEntitiesClasspath).toURI().toURL();
            } catch (MalformedURLException exception) {
                fail("MalformedURLException shouldn't be thrown");
            }

            new DefaultJarImporter(manager, urls);
        } catch (IllegalArgumentException exception) {
            fail("IllegalArgumentException shouldn't be thrown");
        }
    }

    /**
     * <p>
     * Failure test for constructor
     * <code>DefaultJarImporter(UMLModelManager, URL[])</code>.
     * </p>
     * <p>
     * Passing classpath as null for constructor
     * </p>
     */
    public void testURLCtorWithNullClasspathAccuracy() {
        try {
            URL[] urls = null;

            new DefaultJarImporter(manager, urls);
        } catch (IllegalArgumentException exception) {
            fail("IllegalArgumentException shouldn't be thrown");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>retrievePackagesAndClassesFromJars(URL[])</code>.
     * </p>
     * <p>
     * Passing corrupted element of jars[]
     * </p>
     */
    public void testFailureRetrievePackagesAndClassesFromJars1() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            DefaultJarImporter importer = new DefaultJarImporter(manager,
                    classpath);

            String jarPaths[] = new String[1];
            jarPaths[0] = corruptedJarPath;
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) { /* expected */
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>retrievePackagesAndClassesFromJars(URL[])</code>.
     * </p>
     * <p>
     * Passing corrupted element of jars[]
     * </p>
     */
    public void testFailureRetrievePackagesAndClassesFromJars2() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            DefaultJarImporter importer = new DefaultJarImporter(manager,
                    classpath);

            String jarPaths[] = new String[1];
            jarPaths[0] = corruptedJarPath;
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) { /* expected */
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importToDiagram(Diagram)</code>.
     * </p>
     */
    public void testImportToDiagramAccuracy() {
        DefaultJarImporter importer = new DefaultJarImporter(manager,
                new String[] {testEntitiesClasspath});

        try {
            importer.importJars(new URL[] {new File(testEntitiesJarPath1)
                    .toURI().toURL()});
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        } catch (MalformedURLException exception) {
            fail("Shouldn't throw MalformedURLException");
        }

        Diagram diagram = new Diagram();
        diagram.setName("Main class diagram");
        try {
            importer.importToDiagram(diagram);
        } catch (JarImporterException e) {
            fail("Shouldn't throw JarImporterException");
        }

        try {
            importer.importToDiagram(diagram);
        } catch (JarImporterException e) {
            fail("Shouldn't throw JarImporterException");
        }

        assertTrue("diagram containeds size is 0. Import failed",
                diagram.getContaineds().size() > 0);
    }
}
