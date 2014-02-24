/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UtilTests extends TestCase {
    /**
     * <p>
     * This constant represents the namespace for testing.
     * </p>
     */
    private static final String NAMESPACE = "com.topcoder.uml.projectconfiguration.Util";

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull("", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for accuracy.
     * </p>
     */
    public void testCheckString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullArg() {
        try {
            Util.checkString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyArg() {
        try {
            Util.checkString("", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for accuracy.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetString() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE, "test_files" + File.separator + "AbstractElementFormatter.xml");

        try {
            String value = Util.getString(NAMESPACE, "exceptionStereotypeName");

            assertEquals("Failed to get correct property value from configuration manager.", "exception", value);

        } finally {
            TestHelper.clearConfigFile(NAMESPACE);
        }

    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetString_NullNamespace() throws ProjectConfigurationException {
        try {
            Util.getString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException to JUnit
     */
    public void testGetString_EmptyNamespace() throws ProjectConfigurationException {
        try {
            Util.getString("", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyName is null and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException
     */
    public void testGetString_NullPropertyName() throws ProjectConfigurationException {
        try {
            Util.getString(NAMESPACE, null);

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when propertyName is empty and expects IllegalArgumentException.
     * </p>
     * @throws ProjectConfigurationException
     */
    public void testGetString_EmptyPropertyName() throws ProjectConfigurationException {
        try {
            Util.getString(NAMESPACE, "");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the unknown namespace was passed in and expects ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGetString_ProjectConfigurationException1() throws Exception {
        try {
            Util.getString(NAMESPACE, "exceptionStereotypeName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the no property  value was passed in and expects ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGetString_ProjectConfigurationException2() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE + ".Test", "test_files" + File.separator
            + "AbstractElementFormatterNoValue.xml");

        try {
            Util.getString(NAMESPACE, "exceptionStereotypeName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(NAMESPACE + ".Test");
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the empty property value was passed in and expects ProjectConfigurationException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGetString_ProjectConfigurationException3() throws Exception {
        TestHelper.loadSingleXMLConfig(NAMESPACE + ".Test", "test_files" + File.separator
            + "AbstractElementFormatterEmptyValue.xml");

        try {
            Util.getString(NAMESPACE, "exceptionStereotypeName");

            fail("ProjectConfigurationException expected.");
        } catch (ProjectConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(NAMESPACE + ".Test");
        }
    }

}