/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * JarImporterTest.java
 */
package com.topcoder.uml.importer.jarimporter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.impl.DefaultJarImporter;
import com.topcoder.uml.modelmanager.UMLModelManager;
/**
 * <p>Unit tests for <code>JarImporter</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class JarImporterTest extends TestCase {
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
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(JarImporterTest.class);
    }

    /**
     * <p>
     * Failure test for method <code>importJars(URL[])</code>.
     * </p>
     * <p>
     * Passing null as parameter
     * </p>
     */
    public void testImportJarsURLFailure1() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL jarPaths[] = new URL[0];
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method
     * <code>importJars(URL[] jarURLs)</code>.
     * </p>
     */
    public void testImportJarsURLAccuracy() {
        JarImporter importer = new DefaultJarImporter(manager,
                new String[] {testEntitiesClasspath});

        try {
            importer.importJars(new URL[] {new File(testEntitiesJarPath1)
                    .toURI().toURL()});
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        } catch (MalformedURLException exception) {
            fail("Shouldn't throw MalformedURLException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJars(String[])</code>.
     * </p>
     * <p>
     * Passing null as parameter
     * </p>
     */
    public void testImportJarsStringFailure1() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String jarPaths[] = null;
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJars(String[])</code>.
     * </p>
     * <p>
     * Passing jars[] with 0 length
     * </p>
     */
    public void testImportJarsStringFailure2() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String jarPaths[] = new String[0];
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJars(String[])</code>.
     * </p>
     * <p>
     * Passing null as element of jars[]
     * </p>
     */
    public void testImportJarsStringFailure3() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String jarPaths[] = new String[1];
            jarPaths[0] = null;
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJars(String[])</code>.
     * </p>
     * <p>
     * Passing unexisting element of jars[]
     * </p>
     */
    public void testImportJarsStringFailure4() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String jarPaths[] = new String[1];
            jarPaths[0] = unexistingJarPath;
            importer.importJars(jarPaths);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importJars(String[])</code>.
     * </p>
     */
    public void testImportJarsStringAccuracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String jarPaths[] = new String[2];
            jarPaths[0] = testEntitiesJarPath1;
            jarPaths[1] = testEntitiesJarPath2;
            importer.importJars(jarPaths);
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing null jarURLs
     * </p>
     */
    public void testImportJarsToDiagramURLFailure1() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = null;
            importer.importJarsToDiagram(jarURLs, "diagramName");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing null diagramName
     * </p>
     */
    public void testImportJarsToDiagramURLFailure2() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[1];
            try {
                jarURLs[0] = new File(testEntitiesJarPath1).toURI().toURL();
            } catch (MalformedURLException e) {
                fail("Shouldn't throw MalformedURLException");
            }
            importer.importJarsToDiagram(jarURLs, null);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing empty diagramName
     * </p>
     */
    public void testImportJarsToDiagramURLFailure3() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[1];
            try {
                jarURLs[0] = new File(testEntitiesJarPath1).toURI().toURL();
            } catch (MalformedURLException e) {
                fail("Shouldn't throw MalformedURLException");
            }
            importer.importJarsToDiagram(jarURLs, "");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing empty jarURLs[] with length 0
     * </p>
     */
    public void testImportJarsToDiagramURLFailure4() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[0];

            importer.importJarsToDiagram(jarURLs, "diagramName");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing null element of jarURLs[]
     * </p>
     */
    public void testImportJarsToDiagramURLFailure5() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[1];
            jarURLs[0] = null;

            importer.importJarsToDiagram(jarURLs, "diagramName");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing unexisting element of jarURLs[]
     * </p>
     */
    public void testImportJarsToDiagramURLFailure6() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[1];
            try {
                jarURLs[0] = new File(unexistingJarPath).toURI().toURL();
            } catch (MalformedURLException e) {
                fail("Shouldn't throw MalformedURLException");
            }

            importer.importJarsToDiagram(jarURLs, "diagramName");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     * <p>
     * Passing unexisting diagram
     * </p>
     */
    public void testImportJarsToDiagramURLFailure7() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[1];
            try {
                jarURLs[0] = new File(unexistingJarPath).toURI().toURL();
            } catch (MalformedURLException e) {
                fail("Shouldn't throw MalformedURLException");
            }

            Diagram diagram = new Diagram();
            diagram.setName("Main Class Diagram");
            manager.addDiagram(diagram);

            importer.importJarsToDiagram(jarURLs, "Use Case Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importJarsToDiagram(URL[], String)</code>.
     * </p>
     */
    public void testImportJarsToDiagramURLAccuracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            URL[] jarURLs = new URL[1];
            try {
                jarURLs[0] = new File(testEntitiesJarPath1).toURI().toURL();
            } catch (MalformedURLException e) {
                fail("Shouldn't throw MalformedURLException");
            }
            Diagram diagram = new Diagram();
            diagram.setName("Main Class Diagram");

            manager.addDiagram(diagram);

            importer.importJarsToDiagram(jarURLs, "Main Class Diagram");
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing jarPaths as null
     * </p>
     */
    public void testImportJarsToDiagramStringFailure1() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = null;

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing diagram name as null
     * </p>
     */
    public void testImportJarsToDiagramStringFailure2() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = {testEntitiesJarPath1, testEntitiesJarPath2};

            importer.importJarsToDiagram(jarPaths, null);

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing diagram name as empty
     * </p>
     */
    public void testImportJarsToDiagramStringFailure3() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = {testEntitiesJarPath1, testEntitiesJarPath2};

            importer.importJarsToDiagram(jarPaths, "");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing jarPath with length 0.
     * </p>
     */
    public void testImportJarsToDiagramStringFailure4() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = new String[0];

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing jarPath with null element.
     * </p>
     */
    public void testImportJarsToDiagramStringFailure5() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = new String[1];
            jarPaths[0] = null;

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing jarPath with null element.
     * </p>
     */
    public void testImportJarsToDiagramStringFailure6() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = new String[1];
            jarPaths[0] = null;

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing jarPath with empty element.
     * </p>
     */
    public void testImportJarsToDiagramStringFailure7() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = new String[1];
            jarPaths[0] = "";

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Failure test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     * <p>
     * Passing jarPath with unexisting path.
     * </p>
     */
    public void testImportJarsToDiagramStringFailure8() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = {unexistingJarPath};

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");

            fail("Didn't throw an exception");
        } catch (IllegalArgumentException exception) { /* expected */
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method
     * <code>importJarsToDiagram(String[], String)</code>.
     * </p>
     */
    public void testImportJarsToDiagramStringAccurracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            String[] jarPaths = {testEntitiesJarPath1 };

            importer.importJarsToDiagram(jarPaths, "Main Class Diagram");
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importJarToDiagram(String, String)</code>.
     * </p>
     */
    public void testImportJarStringAccurracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            importer.importJar(testEntitiesJarPath1);
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importJar(URL, String)</code>.
     * </p>
     */
    public void testImportJarURLAccurracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            try {
                importer.importJar(new File(testEntitiesJarPath1).toURI()
                        .toURL());
            } catch (MalformedURLException exception) {
                fail("Shouldn't throw MalformedURLException");
            }
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importJarToDiagram(String, String)</code>.
     * </p>
     */
    public void testImportJarToDiagramStringAccurracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            Diagram diagram = new Diagram();
            diagram.setName("Main Class Diagram");
            manager.addDiagram(diagram);

            importer.importJarToDiagram(testEntitiesJarPath1,
                    "Main Class Diagram");
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }

    /**
     * <p>
     * Accuracy test for method <code>importJar(URL, String)</code>.
     * </p>
     */
    public void testImportJarToDiagramURLAccurracy() {
        try {
            String[] classpath = new String[1];

            classpath[0] = testEntitiesClasspath;
            JarImporter importer = new DefaultJarImporter(manager, classpath);

            Diagram diagram = new Diagram();
            diagram.setName("Main Class Diagram");
            manager.addDiagram(diagram);

            try {
                importer.importJarToDiagram(new File(testEntitiesJarPath1)
                        .toURI().toURL(), "Main Class Diagram");
            } catch (MalformedURLException exception) {
                fail("Shouldn't throw MalformedURLException");
            }
        } catch (IllegalArgumentException exception) {
            fail("Shouldn't throw IllegalArgumentException");
        } catch (JarImporterException exception) {
            fail("Shouldn't throw JarImporterException");
        }
    }
}
