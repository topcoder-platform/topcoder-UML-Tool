/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;

import junit.framework.TestCase;


/**
 * Unit tests for XMLStereotypeLoader class.
 *
 * @author crackme
 * @version 1.0
 */
public class TestXMLStereotypeLoader extends TestCase {
    /** A XMLStereotypeLoader used to test. */
    private XMLStereotypeLoader loader;

    /**
     * Setup the environment for each testcase.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigFile("test_files/failure/conf.xml");
        loader = new XMLStereotypeLoader("XMLStereotypeLoader.acc");
    }

    /**
     * Setup the environment for each testcase.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig();
    }

    /**
     * Tests XMLStereotypeLoader(String namespace) method with null String namespace,
     * Expected IllegalArgumentException.
     */
    public void testXMLStereotypeLoader_NullNamespace() {
        try {
            new XMLStereotypeLoader(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests XMLStereotypeLoader(String namespace) method with empty String namespace,
     * Expected IllegalArgumentException.
     */
    public void testXMLStereotypeLoader_EmptyNamespace() {
        try {
            new XMLStereotypeLoader(" ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with null String
     * language, Expected IllegalArgumentException.
     */
    public void testGetStereotypes_NullLanguage() {
        try {
            loader.getStereotypes(null, "t");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with empty String
     * language, Expected IllegalArgumentException.
     */
    public void testGetStereotypes_EmptyLanguage() {
        try {
            loader.getStereotypes(" ", "t");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with null String
     * elementType, Expected IllegalArgumentException.
     */
    public void testGetStereotypes_NullElementType() {
        try {
            loader.getStereotypes("java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with empty String
     * elementType, Expected IllegalArgumentException.
     */
    public void testGetStereotypes_EmptyElementType() {
        try {
            loader.getStereotypes("java", " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with invalid
     * configurable file, Expected ProjectConfigurationException.
     */
    public void testGetStereotypes_Invalid1() {
        XMLStereotypeLoader l = new XMLStereotypeLoader(
                "XMLStereotypeLoader.fail1");

        try {
            l.getStereotypes("Java", "Class");
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with invalid
     * configurable file, Expected ProjectConfigurationException.
     */
    public void testGetStereotypes_Invalid2() {
        XMLStereotypeLoader l = new XMLStereotypeLoader(
                "XMLStereotypeLoader.fail2");

        try {
            l.getStereotypes("Java", "Class");
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStereotypes(String language, String elementType) method with invalid
     * configurable file, Expected ProjectConfigurationException.
     */
    public void testGetStereotypes_Invalid3() {
        XMLStereotypeLoader l = new XMLStereotypeLoader(
                "XMLStereotypeLoader.fail3");

        try {
            l.getStereotypes("Java", "Class");
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }
}
