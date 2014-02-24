/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import java.io.File;
import java.util.List;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.standardclassloader.implementations.XMLLanguageClassDataLoader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "sampleConfig.xml");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This method shows the functionality of the ClassDataLoaderStrategy.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testForClassDataLoaderStrategy() throws Exception {
        // construction using the sample configuration:
        StandardClassDataLoader loader = null;
        try {
            // constructs a new loader, which uses the object factory
            // to initialize the "Java" loader using the factory key "javaLoader"
            loader = new ClassDataLoaderStrategy("strategyClassDataLoader");
        } catch (ClassDataLoaderConfigurationException cdlce) {
            System.err.println("shouldn¡¯t happen...");
        }

        // should throw an exception if using an unrecognized language:
        try {
            loader.getNamespaces("VB.NET");
        } catch (UnknownLanguageException e) {
            // will print "The language [VB.NET] is unknown."
            System.err.println(e.getMessage());
        }

        // make sure we have the java loader:
        ClassDataLoaderStrategy strategy = (ClassDataLoaderStrategy) loader;
        assertTrue("The language [Java] should be loaded.", strategy.getLanguages().contains("Java"));

        // check some values in the list for java:
        List<Namespace> nslist = loader.getNamespaces("Java");

        // one top-level namespace and four primitives (using sample config)
        assertTrue("Expected the size of the list is five.", nslist.size() == 5);
        assertTrue("Expected the name of the first namespace is [java].", nslist.get(0).getName().equals("java"));
        assertTrue("Expected the name of the second namespace is [boolean].",
            nslist.get(1).getName().equals("boolean"));
        assertTrue("Expected the name of the third namespace is [char].", nslist.get(2).getName().equals("char"));
        assertTrue("Expected the name of the fourth namespace is [int].", nslist.get(3).getName().equals("int"));
        assertTrue("Expected the name of the fifth namespace is Primitive instance.",
            nslist.get(4) instanceof Primitive);
    }

    /**
     * <p>
     * This method shows the functionality of the XMLLanguageClassDataLoader.
     * </p>
     *
     * @throws ClassDataLoaderConfigurationException to JUnit
     */
    public void testForXMLLanguageClassDataLoader() throws ClassDataLoaderConfigurationException {
        // create a XMLLanguageClassDataLoader instance
        XMLLanguageClassDataLoader failed = new XMLLanguageClassDataLoader("noSuchFile.txt");
        try {
            failed.getNamespaces();
        } catch (ClassDataLoaderConfigurationException cdlce) {
            System.err.println("This should fail, need correct file format.");
        }

        // correctly configure an XML loader:
        XMLLanguageClassDataLoader xmlLoader = new XMLLanguageClassDataLoader("test_files" + File.separator
            + "sampleJavaFile.xml");

        // check that it does the same as before:
        List<Namespace> nslist = xmlLoader.getNamespaces();

        assertTrue("Expected the size of the list is five.", nslist.size() == 5);
        assertTrue("Expected the name of the first namespace is [java].", nslist.get(0).getName().equals("java"));
        assertTrue("Expected the name of the second namespace is [boolean].",
            nslist.get(1).getName().equals("boolean"));
        assertTrue("Expected the name of the third namespace is [char].", nslist.get(2).getName().equals("char"));
        assertTrue("Expected the name of the fourth namespace is [int].", nslist.get(3).getName().equals("int"));
        assertTrue("Expected the name of the fifth namespace is Primitive instance.",
            nslist.get(4) instanceof Primitive);
    }
}
