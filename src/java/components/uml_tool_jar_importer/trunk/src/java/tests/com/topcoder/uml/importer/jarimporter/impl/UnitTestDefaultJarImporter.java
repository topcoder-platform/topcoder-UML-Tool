/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.impl;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * This class contains unit tests for <code>DefaultJarImporter</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTestDefaultJarImporter extends TestCase {

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
     * Represents the <code>Diagram</code> instance used to test against.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * <p>
     * Represents the <code>MockDefaultJarImporter</code> instance used to test against.
     * </p>
     */
    private MockDefaultJarImporter importer = null;

    /**
     * <p>
     * Represents the list of <code>URL</code> instance used to test against.
     * </p>
     */
    private URL[] urls = null;

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

        urls = new URL[] {new File(JARPATH).toURI().toURL()};
        importer = new MockDefaultJarImporter(umlMgr, (String[]) null);
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
     * Tests <code>DefaultJarImporter(UMLModelManager modelManager, URL[] classpath)</code> method
     * for failure with null ModelManager. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterANullModelManager() throws Exception {
        try {
            new DefaultJarImporter(null, urls);
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>DefaultJarImporter(UMLModelManager modelManager, URL[] classpath)</code> method
     * for failure with null with classpath. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterANullWithClasspath() throws Exception {
        try {
            new DefaultJarImporter(umlMgr, new URL[] {null});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests
     * <code>DefaultJarImporter(UMLModelManager modelManager, URL[] classpath)</code> method for
     * accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterAAccuracy() throws Exception {
        DefaultJarImporter dj = new DefaultJarImporter(umlMgr, new URL[] {new File(JARPATH)
            .toURI().toURL()});
        assertNotNull("Should not be null.", dj);
    }

    /**
     * Tests <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * method for failure with null ModelManager. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterBNullModelManager() throws Exception {
        try {
            new DefaultJarImporter(null, new String[] {JARPATH});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * method for failure with null with Classpath. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterBNullWithClasspath() throws Exception {
        try {
            new DefaultJarImporter(umlMgr, new String[] {null});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * method for failure with empty string with Classpath. IllegalArgumentException should be
     * thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterBEmptyStringWithClasspath() throws Exception {
        try {
            new DefaultJarImporter(umlMgr, new String[] {"   "});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code>
     * method for failure with not exist path with Classpath. IllegalArgumentException should be
     * thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterBInvalidClasspath() throws Exception {

        try {
            new DefaultJarImporter(umlMgr, new String[] {"test_files/notexist.jar"});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Function test : Tests
     * <code>DefaultJarImporter(UMLModelManager modelManager, String[] classpath)</code> method
     * for accuracy.
     *
     * @throws Exception to JUnit.
     */
    public void testDefaultJarImporterBAccuracy() throws Exception {
        DefaultJarImporter dj = new DefaultJarImporter(umlMgr, (String[]) null);
        assertNotNull("Should not be null.", dj);

        dj = new DefaultJarImporter(umlMgr, new String[] {JARPATH});
        assertNotNull("Should not be null.", dj);
    }

    /**
     * Tests <code>retrievePackagesAndClassesFromJars(URL[] jarURLs)</code> method for failure
     * with not exist url in JarURLs. IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testRetrievePackagesAndClassesFromJarsNotExistURLInJarURLs() throws Exception {
        try {
            importer.retrievePackagesAndClassesFromJars(new URL[] {new File("not exist").toURI()
                .toURL()});
            fail("Must throw IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Tests <code>retrievePackagesAndClassesFromJars(URL[] jarURLs)</code> method for failure
     * with invalid class in jar. ClassFormatError should be thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testRetrievePackagesAndClassesFromJarsInvalidJar() throws Exception {
        try {
            importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
                "test_files/InvalidClass.jar").toURI().toURL()});
            fail("Must throw ClassFormatError.");
        } catch (ClassFormatError iae) {
            // error should be thrown.
        }
    }

    /**
     * Tests <code>retrievePackagesAndClassesFromJars(URL[] jarURLs)</code> method for failure
     * with invalid class in jar. The dependencies is missing. NoClassDefFoundError should be
     * thrown.
     *
     * @throws Exception to JUnit.
     */
    public void testRetrievePackagesAndClassesFromJarsInvalidJar2() throws Exception {
        try {
            importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
                "test_files/InvalidJar.jar").toURI().toURL()});
            fail("Must throw NoClassDefFoundError.");
        } catch (NoClassDefFoundError iae) {
            // pass
        }
    }

    /**
     * Function test : Tests <code>retrievePackagesAndClassesFromJars(URL[] jarURLs)</code> method
     * for accuracy. The class with/without package is tested.
     *
     * @throws Exception to JUnit.
     */
    public void testRetrievePackagesAndClassesFromJarsAccuracyA() throws Exception {
        importer
            .retrievePackagesAndClassesFromJars(new URL[] {new File(JARPATH).toURI().toURL()});
        Map<String, Class<?>> classes = importer.getClasses();
        assertEquals("Should be 10.", 10, classes.size());
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.BaseCriticalException"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.BaseError"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.BaseException"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.BaseNonCriticalException"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.BaseRuntimeException"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.CauseUtils"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.ExceptionData"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.util.errorhandling.ExceptionUtils"));

        assertTrue("Should be true.", classes.containsKey("MyEnum"));
        assertTrue("Should be true.", classes.containsKey("com.topcoder.pack.MyEnum"));

        Map<String, java.lang.Package> packages = importer.getPackages();
        assertEquals("Should be 3.", 3, packages.size());
        assertTrue("Should be true.", packages.containsKey("com.topcoder.util.errorhandling"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.pack"));
        assertTrue("Should be true.", packages.containsKey(""));
    }

    /**
     * Function test : Tests <code>retrievePackagesAndClassesFromJars(URL[] jarURLs)</code> method
     * for accuracy. It is the normal classes having complex relationships.
     *
     * @throws Exception to JUnit.
     */
    public void testRetrievePackagesAndClassesFromJarsAccuracyB() throws Exception {
        importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/extractExternalClasses.jar").toURI().toURL()});
        Map<String, Class<?>> classes = importer.getClasses();
        assertEquals("Should be 2.", 2, classes.size());
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.extractExternalClasses.a.TestExtractExternalClassesA"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.extractExternalClasses.b.TestExtractExternalClassesB"));

        Map<String, java.lang.Package> packages = importer.getPackages();
        assertEquals("Should be 2.", 2, packages.size());
        assertTrue("Should be true.", packages.containsKey("com.topcoder.extractExternalClasses.a"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.extractExternalClasses.b"));
    }

    /**
     * Function test : Tests <code>extractExternalClasses()</code> method for accuracy. It is the
     * normal classes having complex relationships.
     *
     * @throws Exception to JUnit.
     */
    public void testExtractExternalClassesAccuracy() throws Exception {
        importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/extractExternalClasses.jar").toURI().toURL()});
        assertEquals("Should be 2.", 2, importer.getClasses().size());
        assertEquals("Should be 2.", 2, importer.getPackages().size());

        // Put the external classes and packages.
        importer.extractExternalClasses();

        Map<String, Class<?>> externals = importer.getExternalClasses();
        assertEquals("Should be 10.", 10, externals.size());

        // interface of TestExtractExternalClassesA
        assertTrue("Should be true.", externals.containsKey("com.topcoder.pack.A"));

        // parameter type of TestExtractExternalClassesB#getA
        assertTrue("Should be true.", externals
            .containsKey("com.topcoder.pack.interfaces.InterfaceC"));

        // super class of TestExtractExternalClassesA and TestExtractExternalClassesB
        assertTrue("Should be true.", externals.containsKey("com.topcoder.pack.AAA"));
        assertTrue("Should be true.", externals.containsKey("java.lang.Object"));

        // interface of TestExtractExternalClassesB
        assertTrue("Should be true.", externals
            .containsKey("com.topcoder.pack.interfaces.InterfaceA"));

        // return of TestExtractExternalClassesA#AA and TestExtractExternalClassesB#getA
        assertTrue("Should be true.", externals.containsKey("java.util.List"));
        assertTrue("Should be true.", externals
            .containsKey("com.topcoder.pack.interfaces.InterfaceB"));

        // parameter type of TestExtractExternalClassesA#AA
        assertTrue("Should be true.", externals.containsKey("int"));
        assertTrue("Should be true.", externals.containsKey("long"));

        // field type of TestExtractExternalClassesA
        assertTrue("Should be true.", externals.containsKey("java.lang.Exception"));

        // The checking for packages.
        Map<String, java.lang.Package> packages = importer.getPackages();
        assertEquals("Should be 7.", 7, packages.size());

        assertTrue("Should be true.", packages.containsKey("com.topcoder.pack"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.pack.interfaces"));

        assertTrue("Should be true.", packages.containsKey("java.lang"));
        assertTrue("Should be true.", packages.containsKey("java.util"));

        assertTrue("Should be true.", packages.containsKey("com.topcoder.extractExternalClasses.a"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.extractExternalClasses.b"));

        // It maps the model package.
        assertTrue("Should be true.", packages.containsKey(""));
    }

    /**
     * Function test : Tests <code>importPackagesAndClassesToModel()</code> method for accuracy.
     * It should load the inner classes (refer to testRetrievePackagesAndClassesFromJarsAccuracyB())
     * and external classes (refer to testExtractExternalClassesAccuracy()).
     *
     * @throws Exception to JUnit.
     */
    public void testImportPackagesAndClassesToModelAccuracy() throws Exception {
        importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/extractExternalClasses.jar").toURI().toURL()});
        importer.extractExternalClasses();

        importer.importPackagesAndClassesToModel();

        Map<String, Package> packages = importer.getModelPackages();
        assertEquals("Should be 7.", 7, packages.size());

        // check the packages
        assertTrue("Should be true.", packages.containsKey("java.util"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.pack.interfaces"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.pack"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.extractExternalClasses.a"));
        assertTrue("Should be true.", packages.containsKey("com.topcoder.extractExternalClasses.b"));
        assertTrue("Should be true.", packages.containsKey("java.lang"));
        assertTrue("Should be true.", packages.containsKey(""));

        // check the model classes.
        Map<String, Classifier> classifiters = importer.getModelClasses();
        assertEquals("Should be 12.", 12, classifiters.size());
        // interface of TestExtractExternalClassesA
        assertTrue("Should be true.", classifiters.containsKey("com.topcoder.pack.A"));

        // parameter type of TestExtractExternalClassesB#getA
        assertTrue("Should be true.", classifiters
            .containsKey("com.topcoder.pack.interfaces.InterfaceC"));

        // super class of TestExtractExternalClassesA and TestExtractExternalClassesB
        assertTrue("Should be true.", classifiters.containsKey("com.topcoder.pack.AAA"));
        assertTrue("Should be true.", classifiters.containsKey("java.lang.Object"));

        // interface of TestExtractExternalClassesB
        assertTrue("Should be true.", classifiters
            .containsKey("com.topcoder.pack.interfaces.InterfaceA"));

        // return of TestExtractExternalClassesA#AA and TestExtractExternalClassesB#getA
        assertTrue("Should be true.", classifiters.containsKey("java.util.List"));
        assertTrue("Should be true.", classifiters
            .containsKey("com.topcoder.pack.interfaces.InterfaceB"));

        // parameter type of TestExtractExternalClassesA#AA
        assertTrue("Should be true.", classifiters.containsKey("int"));
        assertTrue("Should be true.", classifiters.containsKey("long"));

        // field type of TestExtractExternalClassesA
        assertTrue("Should be true.", classifiters.containsKey("java.lang.Exception"));

        // Two inner classes.
        assertTrue("Should be true.", classifiters
            .containsKey("com.topcoder.extractExternalClasses.a.TestExtractExternalClassesA"));
        assertTrue("Should be true.", classifiters
            .containsKey("com.topcoder.extractExternalClasses.b.TestExtractExternalClassesB"));

        Map<Classifier, List<Relationship>> ships = importer.getClassesToRelationships();
        assertEquals("Should be 2.", 2, ships.size());

        boolean passA = false;
        boolean passB = false;
        for (Iterator<Map.Entry<Classifier, List<Relationship>>> pkgss = ships.entrySet()
            .iterator(); pkgss.hasNext();) {
            Map.Entry<Classifier, List<Relationship>> cc = pkgss.next();
            if ("TestExtractExternalClassesA".equals(cc.getKey().getName())) {
                // One interface, one super class.
                assertEquals("Should be 2.", 2, cc.getValue().size());
                passA = true;
            }

            if ("TestExtractExternalClassesB".equals(cc.getKey().getName())) {
                // One interface, one super class and two dependencies.
                assertEquals("Should be 4.", 4, cc.getValue().size());
                passB = true;
            }
        }

        if (!passA || !passB) {
            fail("getClassesToRelationships is not correct.");
        }
    }

    /**
     * Function test : Tests <code>importToDiagram(Diagram diagram)</code> method for accuracy. It
     * is the normal classes having complex relationships.
     *
     * @throws Exception to JUnit.
     */
    public void testImportToDiagramAccuracy1() throws Exception {

        importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/extractExternalClasses.jar").toURI().toURL()});
        importer.extractExternalClasses();

        importer.importPackagesAndClassesToModel();

        Diagram outDia = new Diagram();
        importer.importToDiagram(outDia);

        List<DiagramElement> outData = outDia.getContaineds();

        // 6 relationship and 7 getModelClasses.
        assertEquals("Should be 13.", 13, outData.size());
    }

    /**
     * Function test : Tests <code>importToDiagram(Diagram diagram)</code> method for accuracy. It
     * has inner classes.
     *
     * @throws Exception to JUnit.
     */
    public void testImportToDiagramAccuracy2() throws Exception {

        importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/InnerClass.jar").toURI().toURL()});

        Map<String, Class<?>> classes = importer.getClasses();
        // two inner classes and itself.
        assertEquals("Should be 3.", 3, classes.size());
        assertTrue("Should be true.", classes.containsKey("com.test.ExternalTest$InnerClass2"));
        assertTrue("Should be true.", classes.containsKey("com.test.ExternalTest$InnerClass"));
        assertTrue("Should be true.", classes.containsKey("com.test.ExternalTest"));

        // only one package.
        Map<String, java.lang.Package> classPkg = importer.getPackages();
        assertEquals("Should be 1.", 1, classPkg.size());
        assertTrue("Should be true.", classPkg.containsKey("com.test"));

        // extract the external classes.
        importer.extractExternalClasses();

        // it contains the primitive classes.
        classes = importer.getExternalClasses();
        assertEquals("Should be 10.", 10, classes.size());
        assertTrue("Should be true.", classes.containsKey("boolean"));

        classPkg = importer.getPackages();
        // one empty key and with null value and java.* should be added here too.
        assertEquals("Should be 7.", 7, classPkg.size());
        assertTrue("Should be true.", classPkg.containsKey(""));
        assertTrue("Should be true.", classPkg.containsKey("java.util"));
        assertTrue("Should be true.", classPkg.containsKey("java.lang"));
        assertTrue("Should be true.", classPkg
            .containsKey("com.topcoder.uml.model.core.auxiliaryelements"));
        assertTrue("Should be true.", classPkg.containsKey("com.topcoder.uml.model.core"));
        assertTrue("Should be true.", classPkg
            .containsKey("com.topcoder.uml.model.core.classifiers"));
        assertTrue("Should be true.", classPkg.containsKey("com.test"));

        // import packages and classes to model
        importer.importPackagesAndClassesToModel();

        // Inner classes and external classes should all be imported to model.
        Map<String, Classifier> modelClasses = importer.getModelClasses();
        assertEquals("Should be 13.", 10 + 3, modelClasses.size());

        Map<String, Package> modelPkgs = importer.getModelPackages();

        // Same to above packages.
        assertEquals("Should be 7.", 7, modelPkgs.size());

        Map<Classifier, List<Relationship>> ships = importer.getClassesToRelationships();
        assertEquals("Should be 3.", 3, ships.size());

        boolean passA = false;
        boolean passB = false;
        boolean passC = false;
        for (Iterator<Map.Entry<Classifier, List<Relationship>>> pkgss = ships.entrySet()
            .iterator(); pkgss.hasNext();) {
            Map.Entry<Classifier, List<Relationship>> cc = pkgss.next();
            if ("InnerClass".equals(cc.getKey().getName())) {
                // One interface, one super class.
                assertEquals("Should be 4.", 4, cc.getValue().size());
                passA = true;
            }

            if ("ExternalTest".equals(cc.getKey().getName())) {
                // One interface, one super class and two dependencies.
                assertEquals("Should be 7.", 7, cc.getValue().size());
                passB = true;
            }
            if ("InnerClass2".equals(cc.getKey().getName())) {
                // One interface, one super class and two dependencies.
                assertEquals("Should be 2.", 2, cc.getValue().size());
                passC = true;
            }
        }

        if (!passA || !passB || !passC) {
            fail("getClassesToRelationships is not correct.");
        }

        Diagram outDia = new Diagram();
        importer.importToDiagram(outDia);

        List<DiagramElement> outData = outDia.getContaineds();
        assertEquals("Should be 22.", 22, outData.size());
    }

    /**
     * Function test : Tests <code>importToDiagram(Diagram diagram)</code> method for accuracy. It
     * has array classes.
     *
     * @throws Exception to JUnit.
     */
    public void testImportToDiagramAccuracy3() throws Exception {

        importer
            .retrievePackagesAndClassesFromJars(new URL[] {new File("test_files/ArrayTest.jar")
                .toURI().toURL()});

        Map<String, Class<?>> classes = importer.getClasses();
        // two inner classes and itself.
        assertEquals("Should be 2.", 2, classes.size());
        assertTrue("Should be true.", classes.containsKey("com.topcoder.pack.TestArray"));
        assertTrue("Should be true.", classes
            .containsKey("com.topcoder.pack.interfaces.ArrayInterface"));

        // only one package.
        Map<String, java.lang.Package> classPkg = importer.getPackages();
        assertEquals("Should be 2.", 2, classPkg.size());
        assertTrue("Should be true.", classPkg.containsKey("com.topcoder.pack"));
        assertTrue("Should be true.", classPkg.containsKey("com.topcoder.pack.interfaces"));

        // extract the external classes.
        importer.extractExternalClasses();

        // it contains the primitive classes.
        classes = importer.getExternalClasses();
        assertEquals("Should be 2.", 2, classes.size());
        assertTrue("Should be true.", classes.containsKey("java.lang.Object"));
        assertTrue("Should be true.", classes.containsKey("java.lang.String"));

        classPkg = importer.getPackages();
        // one empty key and with null value and java.* should be added here too.
        assertEquals("Should be 3.", 3, classPkg.size());
        assertTrue("Should be true.", classPkg.containsKey("java.lang"));
        assertTrue("Should be true.", classPkg.containsKey("com.topcoder.pack"));
        assertTrue("Should be true.", classPkg.containsKey("com.topcoder.pack.interfaces"));

        // import packages and classes to model
        importer.importPackagesAndClassesToModel();

        // Inner classes and external classes should all be imported to model.
        Map<String, Classifier> modelClasses = importer.getModelClasses();
        assertEquals("Should be 4.", 1 + 3, modelClasses.size());

        Map<String, Package> modelPkgs = importer.getModelPackages();

        // Same to above packages.
        assertEquals("Should be 3.", 3, modelPkgs.size());

        Map<Classifier, List<Relationship>> ships = importer.getClassesToRelationships();
        assertEquals("Should be 2.", 2, ships.size());

        Diagram outDia = new Diagram();
        importer.importToDiagram(outDia);

        List<DiagramElement> outData = outDia.getContaineds();
        assertEquals("Should be 5.", 5, outData.size());
    }

    /**
     * Function test : Tests <code>importToDiagram(Diagram diagram)</code> method for stress test.
     *
     * @throws Exception to JUnit.
     */
    public void testImportToDiagramStress() throws Exception {

        importer.retrievePackagesAndClassesFromJars(new URL[] {new File(
            "test_files/xerces-1.4.4.jar").toURI().toURL()});
        importer.extractExternalClasses();

        importer.importPackagesAndClassesToModel();

        importer.importToDiagram(new Diagram());
    }
}
