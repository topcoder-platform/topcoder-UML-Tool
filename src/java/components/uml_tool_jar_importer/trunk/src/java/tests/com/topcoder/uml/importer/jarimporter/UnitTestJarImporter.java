/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * This class contains unit tests for <code>JarImporter</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTestJarImporter extends TestCase {
    /**
     * <p>
     * Represents the path of jar file used to test against.
     * </p>
     */
    private static final String JARPATH = "test_files/base_exception.jar";

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> instance used to test against.
     * </p>
     */
    private UMLModelManager umlMgr = null;

    /**
     * <p>
     * Represents the <code>JarImporter</code> instance used to test against.
     * </p>
     */
    private JarImporter importer = null;

    /**
     * <p>
     * Represents the <code>Diagram</code> instance used to test against.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * Set Up the test environment before testing.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        umlMgr = new UMLModelManager();
        diagram = new Diagram();
        diagram.setName("diagram");
        umlMgr.addDiagram(diagram);
        importer = new MockJarImporter(umlMgr);
    }

    /**
     * Clean up the test environment after testing.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        importer = null;
    }

    /**
     * Tests <code>JarImporter(UMLModelManager modelManager)</code> method for failure with null
     * UMLModelManager. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testJarImporterNullUMLModelManager() throws Exception {
        try {
            new MockJarImporter(null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>JarImporter(UMLModelManager modelManager)</code> method for
     * accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testJarImporterAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer);
        assertEquals("Should not be umlMgr.", umlMgr, importer.getModelManager());
    }

    /**
     * Tests <code>importJars(String[] jarPaths)</code> method for failure with null JarPaths.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsNullJarPaths() throws Exception {
        try {
            importer.importJars((String[]) null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(String[] jarPaths)</code> method for failure with null in JarPaths.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsNullWithJarPaths() throws Exception {
        try {
            importer.importJars(new String[] {null});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(String[] jarPaths)</code> method for failure with empty string in
     * JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsEmptyStringWithJarPaths() throws Exception {
        try {
            importer.importJars(new String[] {"    "});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(String[] jarPaths)</code> method for failure with empty JarPaths.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsEmptyJarPaths() throws Exception {
        try {
            importer.importJars(new String[0]);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(String[] jarPaths)</code> method for failure with not exist path in
     * JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsNotExistPathWithJarPaths() throws Exception {
        try {
            importer.importJars(new String[] {"I am not existing jar."});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJars(String[] jarPaths)</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsAAccuracy() throws Exception {
        importer.importJars(new String[] {JARPATH});

        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());
    }

    /**
     * Tests <code>importJars(URL[] jarURLs)</code> method for failure with null JarURLs.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsNullJarURLs() throws Exception {
        try {
            importer.importJars((URL[]) null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(URL[] jarURLs)</code> method for failure with null in JarURLs.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsNullWithJarURLs() throws Exception {
        try {
            importer.importJars(new URL[] {null});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(URL[] jarURLs)</code> method for failure with empty JarURLs.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsEmptyJarURLs() throws Exception {
        try {
            importer.importJars(new URL[0]);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJars(URL[] jarURLs)</code> method for failure with not exist url in
     * JarURLs. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsNotExistURLInJarURLs() throws Exception {
        try {
            importer.importJars(new URL[] {new File("not e").toURI().toURL()});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJars(URL[] jarURLs)</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsAccuracy() throws Exception {
        importer.importJars(new URL[] {new File(JARPATH).toURI().toURL()});
        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());
    }

    /**
     * Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method for
     * failure with null JarURLs. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramANullJarURLs() throws Exception {
        try {
            importer.importJarsToDiagram((URL[]) null, "diagramName");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method for
     * failure with empty JarURLs. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramAEmptyJarURLs() throws Exception {
        try {
            importer.importJarsToDiagram(new URL[0], "diagramName");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method for
     * failure with not exist url in JarURLs. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramANotExistURLInJarURLs() throws Exception {
        try {
            importer.importJarsToDiagram(new URL[] {new File("not e").toURI().toURL()},
                "diagramName");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method for
     * failure with null DiagramName. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramANullDiagramName() throws Exception {
        try {
            importer.importJarsToDiagram(new URL[] {new File(JARPATH).toURI().toURL()}, null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method for
     * failure with empty DiagramName, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramAEmptyDiagramName() throws Exception {
        try {
            importer.importJarsToDiagram(new URL[] {new File(JARPATH).toURI().toURL()}, "    ");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code> method for
     * failure with not exist DiagramName, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramANotExistDiagramName() throws Exception {
        try {
            importer.importJarsToDiagram(new URL[] {new File(JARPATH).toURI().toURL()},
                "notexist");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJarsToDiagram(URL[] jarURLs, String diagramName)</code>
     * method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramAAccuracy() throws Exception {
        importer.importJarsToDiagram(new URL[] {new File(JARPATH).toURI().toURL()}, "diagram");

        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());

        boolean isChecked = false;

        // Check importToDiagram is called.
        for (Diagram d : importer.getModelManager().getDiagrams()) {
            if ("diagram".equals(d.getName())) {
                assertEquals("Should be 1.", 1, d.getContaineds().size());
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            fail("Must be checked.");
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with null JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramNullJarPaths() throws Exception {
        try {
            importer.importJarsToDiagram((String[]) null, "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with empty JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramEmptyJarPaths() throws Exception {
        try {
            importer.importJarsToDiagram(new String[0], "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with null path in JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramNullPathInJarPaths() throws Exception {
        try {
            importer.importJarsToDiagram(new String[] {null}, "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with null path in JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramEmptyPathInJarPaths() throws Exception {
        try {
            importer.importJarsToDiagram(new String[] {"   "}, "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with not existing path in JarPaths. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramNotExistPathInJarPaths() throws Exception {
        try {
            importer.importJarsToDiagram(new String[] {"not exist"}, "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with null DiagramName. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramNullDiagramName() throws Exception {
        try {
            importer.importJarsToDiagram(new String[] {JARPATH}, null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with empty DiagramName, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramEmptyDiagramName() throws Exception {
        try {
            importer.importJarsToDiagram(new String[] {JARPATH}, "   ");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code> method for
     * failure with not exist DiagramName, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramNotExistDiagramName() throws Exception {
        try {
            importer.importJarsToDiagram(new String[] {JARPATH}, "notexist");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJarsToDiagram(String[] jarPaths, String diagramName)</code>
     * method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarsToDiagramAccuracy() throws Exception {
        importer.importJarsToDiagram(new String[] {JARPATH}, "diagram");

        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());

        boolean isChecked = false;

        // Check importToDiagram is called.
        for (Diagram d : importer.getModelManager().getDiagrams()) {
            if ("diagram".equals(d.getName())) {
                assertEquals("Should be 1.", 1, d.getContaineds().size());
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            fail("Must be checked.");
        }
    }

    /**
     * Tests <code>importJar(String jarPath)</code> method for failure with null JarPath.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarANullJarPath() throws Exception {
        try {
            importer.importJar((String) null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJar(String jarPath)</code> method for failure with empty JarPath,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarAEmptyJarPath() throws Exception {
        try {
            importer.importJar("   ");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJar(String jarPath)</code> method for failure with empty JarPath,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarANotExistJarPath() throws Exception {
        try {
            importer.importJar("not exist");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJar(String jarPath)</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarAAccuracy() throws Exception {
        importer.importJar(JARPATH);

        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());
    }

    /**
     * Tests <code>importJar(URL jarURL)</code> method for failure with null JarURL.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarBNullJarURL() throws Exception {
        try {
            importer.importJar((URL) null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJar(URL jarURL)</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarAccuracy() throws Exception {
        importer.importJar(new File(JARPATH).toURI().toURL());
        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());
    }

    /**
     * Tests <code>importJarToDiagram(URL jarURL, String diagramName)</code> method for failure
     * with null JarURL. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramANullJarURL() throws Exception {
        try {
            importer.importJarToDiagram((URL) null, "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarToDiagram(URL jarURL, String diagramName)</code> method for failure
     * with null DiagramName. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramANullDiagramName() throws Exception {
        try {
            importer.importJarToDiagram(new File(JARPATH).toURI().toURL(), null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarToDiagram(URL jarURL, String diagramName)</code> method for failure
     * with empty DiagramName, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramAEmptyDiagramName() throws Exception {
        try {
            importer.importJarToDiagram(new File(JARPATH).toURI().toURL(), "   ");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJarToDiagram(URL jarURL, String diagramName)</code>
     * method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramAAccuracy() throws Exception {
        importer.importJarToDiagram(new File(JARPATH).toURI().toURL(), "diagram");

        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());

        boolean isChecked = false;

        // Check importToDiagram is called.
        for (Diagram d : importer.getModelManager().getDiagrams()) {
            if ("diagram".equals(d.getName())) {
                assertEquals("Should be 1.", 1, d.getContaineds().size());
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            fail("Must be checked.");
        }
    }

    /**
     * Tests <code>importJarToDiagram(String jarPath, String diagramName)</code> method for
     * failure with null JarPath. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramBNullJarPath() throws Exception {
        try {
            importer.importJarToDiagram((String) null, "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarToDiagram(String jarPath, String diagramName)</code> method for
     * failure with empty JarPath, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramBEmptyJarPath() throws Exception {
        try {
            importer.importJarToDiagram("   ", "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarToDiagram(String jarPath, String diagramName)</code> method for
     * failure with not exist JarPath, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramBNotExistJarPath() throws Exception {
        try {
            importer.importJarToDiagram("not exist", "diagram");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarToDiagram(String jarPath, String diagramName)</code> method for
     * failure with null DiagramName. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramNullDiagramName() throws Exception {
        try {
            importer.importJarToDiagram(JARPATH, null);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>importJarToDiagram(String jarPath, String diagramName)</code> method for
     * failure with empty DiagramName, IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramEmptyDiagramName() throws Exception {
        try {
            importer.importJarToDiagram(JARPATH, "    ");
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>importJarToDiagram(String jarPath, String diagramName)</code>
     * method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testImportJarToDiagramAccuracy() throws Exception {
        importer.importJarToDiagram(JARPATH, "diagram");

        assertEquals("Should not be 1.", 1, importer.getPackages().size());
        assertEquals("Should not be 2.", 2, importer.getClasses().size());
        assertEquals("Should not be 3.", 3, importer.getExternalClasses().size());
        assertEquals("Should not be 4.", 4, importer.getRelationships().size());

        boolean isChecked = false;

        // Check importToDiagram is called.
        for (Diagram d : importer.getModelManager().getDiagrams()) {
            if ("diagram".equals(d.getName())) {
                assertEquals("Should be 1.", 1, d.getContaineds().size());
                isChecked = true;
                break;
            }
        }

        if (!isChecked) {
            fail("Must be checked.");
        }
    }

    /**
     * Function test : Tests <code>getModelManager()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetModelManagerAccuracy() throws Exception {
        assertEquals("Should not be umlMgr.", umlMgr, importer.getModelManager());
    }

    /**
     * Function test : Tests <code>getPackages()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetPackagesAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getPackages());
        assertEquals("Should be 0.", 0, importer.getPackages().size());
    }

    /**
     * Function test : Tests <code>getClasses()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetClassesAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getClasses());
        assertEquals("Should be 0.", 0, importer.getClasses().size());
    }

    /**
     * Function test : Tests <code>getExternalClasses()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetExternalClassesAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getExternalClasses());
        assertEquals("Should be 0.", 0, importer.getExternalClasses().size());
    }

    /**
     * Function test : Tests <code>getModelPackages()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetModelPackagesAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getModelPackages());
        assertEquals("Should be 0.", 0, importer.getModelPackages().size());
    }

    /**
     * Function test : Tests <code>getModelClasses()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetModelClassesAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getModelClasses());
        assertEquals("Should be 0.", 0, importer.getModelClasses().size());
    }

    /**
     * Function test : Tests <code>getRelationships()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetRelationshipsAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getRelationships());
        assertEquals("Should be 0.", 0, importer.getRelationships().size());
    }

    /**
     * Function test : Tests <code>getClassesToRelationships()</code> method for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testGetClassesToRelationshipsAccuracy() throws Exception {
        assertNotNull("Should not be null.", importer.getClassesToRelationships());
        assertEquals("Should be 0.", 0, importer.getClassesToRelationships().size());
    }
}
