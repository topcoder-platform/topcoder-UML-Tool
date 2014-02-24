/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.impl.DefaultJarImporter;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * The demo class is used to show the usage of this component.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * <p>
     * Represents the path of demo jar file used to test against.
     * </p>
     */
    private static final String JARPATH = "test_files/demo.jar";

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
     * Set Up the test environment before testing.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        umlMgr = UMLModelManager.getInstance();
        diagram = new Diagram();
        diagram.setName("Main Class Diagram");
        umlMgr.addDiagram(diagram);
    }

    /**
     * Clean up the test environment after testing.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        umlMgr = null;
    }

    /**
     * <p>
     * This test case demonstrates the usage of working with this component.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDemo() throws Exception {
        // Create DefaultJarImporter instance.
        JarImporter importer = new DefaultJarImporter(umlMgr, new String[] {JARPATH});

        // you also can create DefaultJarImporter with URLs
        importer = new DefaultJarImporter(umlMgr, new URL[] {new File(JARPATH).toURI().toURL()});

        // only import the JARs to Model
        importer.importJars(new String[] {JARPATH, "test_files/extractExternalClasses.jar"});

        // import JARs with specified URLs to Model
        importer.importJars(new URL[] {new File(JARPATH).toURI().toURL()});

        // import the JARs to model, and then import all the entities into specified
        // diagram. Here assume there is a class diagram named with "Main Class Diagram"
        importer.importJarsToDiagram(new String[] {JARPATH,
            "test_files/extractExternalClasses.jar"}, "Main Class Diagram");

        // use URLs instead.
        importer.importJarsToDiagram(new URL[] {new File(JARPATH).toURI().toURL()},
            "Main Class Diagram");

    }
}
