/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.failuretests;

import java.io.File;
import java.net.URL;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.JarImporter;
import com.topcoder.uml.importer.jarimporter.impl.DefaultJarImporter;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for DefaultJarImporter class.
 * @author King_Bette
 * @version 1.0
 */
public class DefaultJarImporterFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private JarImporter jarImporter;

    /**
     * Aggregates all tests in this class.
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DefaultJarImporterFailureTest.class);
    }

    /**
     * Sets up the environment for the TestCase.
     * @throws Exception throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        UMLModelManager modelManager = new UMLModelManager();
        Diagram diagram = new Diagram();
        diagram.setName("diagram1");
        modelManager.addDiagram(diagram);
        jarImporter = new DefaultJarImporter(modelManager, new String[0]);
    }

    /**
     * Tears down the environment for the TestCase.
     * @throws Exception throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // do nothing
    }

    /**
     * Failure test of <code>DefaultJarImporter(UMLModelManager modelManager, URL[] classpath)</code> constructor.
     * <p>
     * modelManager is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporter1_failure_null_modelManager() throws Exception {
        try {
            new DefaultJarImporter(null, new URL[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>DefaultJarImporter(UMLModelManager modelManager, URL[] classpath)</code> constructor.
     * <p>
     * classpath contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporter1_failure_classpath_contains_null() throws Exception {
        try {
            new DefaultJarImporter(UMLModelManager.getInstance(), new URL[] { null });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * constructor.
     * <p>
     * modelManager is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporter2_failure_null_modelManager() throws Exception {
        try {
            new DefaultJarImporter(null, new String[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * constructor.
     * <p>
     * classpath contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporter2_failure_classpath_contains_null() throws Exception {
        try {
            new DefaultJarImporter(UMLModelManager.getInstance(), new String[] { null });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * constructor.
     * <p>
     * classpath contains empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporter2_failure_classpath_contains_empty() throws Exception {
        try {
            new DefaultJarImporter(UMLModelManager.getInstance(), new String[] { "  " });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * constructor.
     * <p>
     * invalid classpath.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporter2_failure_invalid_classpath() throws Exception {
        try {
            new DefaultJarImporter(UMLModelManager.getInstance(), new String[] { "xxx" });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(String[] jarPaths)</code> method.
     * <p>
     * jarPaths is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars1_failure_null_jarPaths() throws Exception {
        try {
            jarImporter.importJars((String[]) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(String[] jarPaths)</code> method.
     * <p>
     * jarPaths is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars1_failure_empty_jarPaths() throws Exception {
        try {
            jarImporter.importJars(new String[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(String[] jarPaths)</code> method.
     * <p>
     * jarPaths contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars1_failure_jarPaths_contains_null() throws Exception {
        try {
            jarImporter.importJars(new String[] { null });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(String[] jarPaths)</code> method.
     * <p>
     * jarPaths contains empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars1_failure_jarPaths_contains_empty() throws Exception {
        try {
            jarImporter.importJars(new String[] { "  " });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(String[] jarPaths)</code> method.
     * <p>
     * jarPaths is invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars1_failure_invalid_jarPaths() throws Exception {
        try {
            jarImporter.importJars(new String[] { "xxx" });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(URL[] jarURLs)</code> method.
     * <p>
     * jarURLs is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars2_failure_null_jarURLs() throws Exception {
        try {
            jarImporter.importJars((URL[]) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(URL[] jarURLs)</code> method.
     * <p>
     * jarURLs is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars2_failure_empty_jarURLs() throws Exception {
        try {
            jarImporter.importJars(new URL[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(URL[] jarURLs)</code> method.
     * <p>
     * jarURLs contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars2_failure_jarURLs_contains_null() throws Exception {
        try {
            jarImporter.importJars(new URL[] { null });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJars(URL[] jarURLs)</code> method.
     * <p>
     * invalid jarURLs
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJars2_failure_invalid_jarURLs() throws Exception {
        try {
            jarImporter.importJars(new URL[] { new URL("file://test") });
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * jarURLs is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_null_jarURLs() throws Exception {
        try {
            jarImporter.importJarsToDiagram((URL[]) null, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * jarURLs is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_empty_jarURLs() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new URL[0], "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * jarURLs contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_jarURLs_contains_null() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new URL[] { null }, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * jarURLs is invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_invalid_jarURLs() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new URL[] { new URL("file://test") }, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * diagramName is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_null_diagramName() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new URL[] { new File("test_files/failuretests/test.jar").toURI()
                .toURL() }, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * diagramName is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_empty_diagramName() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new URL[] { new File("test_files/failuretests/test.jar").toURI()
                .toURL() }, "  ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method.
     * <p>
     * diagramName is not found.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram1_failure_diagramName_not_found() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new URL[] { new File("test_files/failuretests/test.jar").toURI()
                .toURL() }, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * jarPaths is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_null_jarPaths() throws Exception {
        try {
            jarImporter.importJarsToDiagram((String[]) null, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * jarPaths is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_empty_jarPaths() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[0], "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * jarPaths contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_jarPaths_contains_null() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[] { null }, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * jarPaths contains empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_jarPaths_contains_empty() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[] { "  " }, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * jarPaths contains invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_invalid_jarPaths() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[] { "test" }, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * diagramName is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_null_diagramName() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[] { "test_files/failuretests/test.jar" }, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * diagramName is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_empty_diagramName() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[] { "test_files/failuretests/test.jar" }, "  ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method.
     * <p>
     * diagramName is not found.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagram2_failure_diagramName_not_found() throws Exception {
        try {
            jarImporter.importJarsToDiagram(new String[] { "test_files/failuretests/test.jar" }, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJar(String jarPath)</code> method.
     * <p>
     * jarPath is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJar1_failure_null_jarPath() throws Exception {
        try {
            jarImporter.importJar((String) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJar(String jarPath)</code> method.
     * <p>
     * jarPath is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJar1_failure_empty_jarPath() throws Exception {
        try {
            jarImporter.importJar(" ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJar(String jarPath)</code> method.
     * <p>
     * jarPath is invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJar1_failure_invalid_jarPath() throws Exception {
        try {
            jarImporter.importJar("test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJar(URL jarURL)</code> method.
     * <p>
     * jarURL is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJar2_failure_null_jarURL() throws Exception {
        try {
            jarImporter.importJar((URL) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJar(URL jarURL)</code> method.
     * <p>
     * jarURL is invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJar2_failure_invalid_jarURL() throws Exception {
        try {
            jarImporter.importJar(new URL("file://test"));
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarToDiagram(URL jarURL, String diagramName)</code> method.
     * <p>
     * diagramName is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram1_failure_null_diagramName() throws Exception {
        try {
            jarImporter.importJarToDiagram(new File("test_files/failuretests/test.jar").toURI().toURL(),
                null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarToDiagram(URL jarURL, String diagramName)</code> method.
     * <p>
     * diagramName is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram1_failure_empty_diagramName() throws Exception {
        try {
            jarImporter.importJarToDiagram(new File("test_files/failuretests/test.jar").toURI().toURL(),
                "  ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarToDiagram(URL jarURL, String diagramName)</code> method.
     * <p>
     * diagramName is not found.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram1_failure_diagramName_not_found() throws Exception {
        try {
            jarImporter.importJarToDiagram(new File("test_files/failuretests/test.jar").toURI().toURL(),
                "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarToDiagram(URL jarURL, String diagramName)</code> method.
     * <p>
     * jarURL is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram1_failure_null_jarURL() throws Exception {
        try {
            jarImporter.importJarToDiagram((URL) null, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarToDiagram(URL jarURL, String diagramName)</code> method.
     * <p>
     * jarURL is invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram1_failure_invalid_jarURL() throws Exception {
        try {
            jarImporter.importJarToDiagram(new URL("file://test"), "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>importJarToDiagram(String jarPath, String diagramName)</code> method.
     * <p>
     * jarPath is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram2_failure_null_jarPath() throws Exception {
        try {
            jarImporter.importJarToDiagram((String) null, "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>importJarToDiagram(String jarPath, String diagramName)</code> method.
     * <p>
     * jarPath is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram2_failure_empty_jarPath() throws Exception {
        try {
            jarImporter.importJarToDiagram("  ", "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>importJarToDiagram(String jarPath, String diagramName)</code> method.
     * <p>
     * jarPath is invalid.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram2_failure_invalid_jarPath() throws Exception {
        try {
            jarImporter.importJarToDiagram("test", "diagram1");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>importJarToDiagram(String jarPath, String diagramName)</code> method.
     * <p>
     * diagramName is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram2_failure_null_diagramName() throws Exception {
        try {
            jarImporter.importJarToDiagram("test_files/failuretests/test.jar", null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>importJarToDiagram(String jarPath, String diagramName)</code> method.
     * <p>
     * diagramName is empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram2_failure_empty_diagramName() throws Exception {
        try {
            jarImporter.importJarToDiagram("test_files/failuretests/test.jar", " ");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>importJarToDiagram(String jarPath, String diagramName)</code> method.
     * <p>
     * diagramName is not found.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagram2_failure_diagramName_not_found() throws Exception {
        try {
            jarImporter.importJarToDiagram("test_files/failuretests/test.jar", "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
