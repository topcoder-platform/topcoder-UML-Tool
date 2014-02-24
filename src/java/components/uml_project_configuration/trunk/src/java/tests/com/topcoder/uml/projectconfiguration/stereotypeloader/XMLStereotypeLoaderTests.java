/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stereotypeloader;

import java.io.File;
import java.util.List;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for XMLStereotypeLoader.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMLStereotypeLoaderTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace used for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration."
        + "stereotypeloader.XMLStereotypeLoaderTests";

    /**
     * <p>
     * XMLStereotypeLoader instance for helping testing.
     * </p>
     */
    private XMLStereotypeLoader xmlStereotypeLoader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        xmlStereotypeLoader = new XMLStereotypeLoader(NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        xmlStereotypeLoader = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(XMLStereotypeLoaderTests.class);
    }

    /**
     * <p>
     * Tests ctor XMLStereotypeLoader#XMLStereotypeLoader(String) for accuracy.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new instance of XMLStereotypeLoader.", xmlStereotypeLoader);
    }

    /**
     * <p>
     * Tests ctor XMLStereotypeLoader#XMLStereotypeLoader(String) for failure.
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new XMLStereotypeLoader(null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor XMLStereotypeLoader#XMLStereotypeLoader(String) for failure.
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new XMLStereotypeLoader("");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for accuracy.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGetStereotypes() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypes.xml");

        try {
            List<Stereotype> stereotypes = xmlStereotypeLoader.getStereotypes("Java", "Class");

            assertEquals("Expect only two element.", 2, stereotypes.size());
            assertEquals("Failed to get the correct value.", "exception", stereotypes.get(0).getName());
            assertEquals("Failed to get the correct value.", "abstract", stereotypes.get(1).getName());

        } finally {
            TestHelper.clearConfigFile(NAMESPACE);
        }

    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * It tests the case that when language is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testGetStereotypes_NullLanguage() throws ProjectConfigurationException {
        try {
            xmlStereotypeLoader.getStereotypes(null, "Class");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * It tests the case that when language is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testGetStereotypes_EmptyLanguage() throws ProjectConfigurationException {
        try {
            xmlStereotypeLoader.getStereotypes("", "Class");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * It tests the case that when elementType is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testGetStereotypes_NullElementType() throws ProjectConfigurationException {
        try {
            xmlStereotypeLoader.getStereotypes("Java", null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * It tests the case that when elementType is empty and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit.
     */
    public void testGetStereotypes_EmptyElementType() throws ProjectConfigurationException {
        try {
            xmlStereotypeLoader.getStereotypes("Java", "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests a unknown namespace was passed in and expect ProjectConfigurationException success.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetStereotypes_ProjectConfigurationException1() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE + ".Test", "test_files" + File.separator + "StandardStereotypes.xml");

        try {
            xmlStereotypeLoader.getStereotypes("Java", "Class");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(NAMESPACE + ".Test");
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests a wrong property name was passed in and expect ProjectConfigurationException success.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetStereotypes_ProjectConfigurationException2() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypes.xml");

        try {
            xmlStereotypeLoader.getStereotypes("CSharp", "Operation");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests no property value was passed in and expect ProjectConfigurationException success.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetStereotypes_ProjectConfigurationException3() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypesNoValue.xml");

        try {
            xmlStereotypeLoader.getStereotypes("Java", "Class");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests XMLStereotypeLoader#getStereotypes(String,String) for failure.
     * Expects ProjectConfigurationException.
     * </p>
     *
     * <p>
     * It tests empty property value was passed in and expect ProjectConfigurationException success.
     * </P>
     *
     * @throws Exception to JUnit.
     */
    public void testGetStereotypes_ProjectConfigurationException4() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "StandardStereotypesEmptyValue.xml");

        try {
            xmlStereotypeLoader.getStereotypes("Java", "Class");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(NAMESPACE);
        }
    }

}