/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.util.Map;

import com.topcoder.gui.diagramviewer.elements.Node;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class DVHelper.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */

public class DVHelperUnitTests extends TestCase {
    /**
     * Test of method validateNotNull with not Null object. All works well.
     */
    public void testValidateNotNullWithNotNullObject() {
        Object obj = new Object();
        assertEquals("Failed to implement validateNotNull.", obj, DVHelper.validateNotNull(obj, "test"));
    }

    /**
     * Test of method ValidateNotNull with Null object. IllegalArgumentException
     * is expected.
     */
    public void testValidateNotNullWithNullObject() {
        try {
            DVHelper.validateNotNull(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of method validateEmpty with normal string. All works well.
     */
    public void testValidateEmptyWithNormalStrimg() {
        DVHelper.validateEmpty("123", "test");
    }

    /**
     * Test of method validateEmpty with null. All works well.
     */
    public void testValidateEmptyWithNull() {
        DVHelper.validateEmpty(null, "test");
    }

    /**
     * Test of method validateEmpty with empty string. IllegalArgumentException
     * is expected.
     */
    public void testValidateEmptyWithEmptyString() {
        try {
            DVHelper.validateEmpty("", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of method validateEmpty with trimmed empty string.
     * IllegalArgumentException is expected.
     */
    public void testValidateEmptyWithTrimmedEmptyString() {
        try {
            DVHelper.validateEmpty("  ", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateString with normal string.
     */
    public void testValidateStringWithNormalString() {
        assertEquals("Failed to implement validateString.", "test", DVHelper.validateString("test", "test"));
    }

    /**
     * Test of validateString with empty string. IllegalArgumentException is
     * expected.
     */
    public void testValidateStringWithEmptyString() {
        try {
            DVHelper.validateString("", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateString with trimmed empty string.
     * IllegalArgumentException is expected.
     */
    public void testValidateStringWithTrimmedEmptyString() {
        try {
            DVHelper.validateString("  ", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateString with null string. IllegalArgumentException is
     * expected.
     */
    public void testValidateStringWithNullString() {
        try {
            DVHelper.validateString(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of ValidateNotPositive with value 1.
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testValidatePositive() throws Exception {
        assertEquals("fail to implement the method validatePostive", 1, DVHelper.validatePositive(1, "test"));
    }

    /**
     * <p>
     * Test of ValidateNotPositive with value 0,IllegalArgumentException is
     * expected..
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testValidatePositiveWithZero() throws Exception {
        try {
            DVHelper.validatePositive(0, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of ValidateNotPositive with value -12,IllegalArgumentException is
     * expected..
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testValidatePositiveWithNegative() throws Exception {
        try {
            DVHelper.validatePositive(-12, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of validateClassType with classType Node.
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testValidateClassType() throws Exception {
        assertEquals("fail to implement the method validateNotPostive", Node.class, DVHelper.validateClassType(
                Node.class, "test"));
    }

    /**
     * <p>
     * Test of validateClassType with value null,IllegalArgumentException is
     * expected..
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testValidateClassTypeWithNull() throws Exception {
        try {
            DVHelper.validateClassType(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of validateClassType with value Map.class,IllegalArgumentException
     * is expected..
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testValidateClassTypeWithInValidClass() throws Exception {
        try {
            DVHelper.validateClassType(Map.class, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of configGet.
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testConfigGet() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");
        assertEquals("Fail to call method configGet.", DVHelper.configGet(
                "com.topcoder.gui.diagramviewer.DiagramViewer", "max_open_tabs", "10"), "5");
    }

    /**
     * <p>
     * Test of configGet with value null,IllegalArgumentException is expected..
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testConfigGetWithNullNamespace() throws Exception {
        try {
            DVHelper.configGet(null, "property", "defaultValue");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of configGet with value null,IllegalArgumentException is expected..
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testConfigGetWithEmptyNamespace() throws Exception {
        try {
            DVHelper.configGet("", "property", "defaultValue");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of configGet with value invalid namespace,ConfigurationException is
     * expected.
     * </p>
     *
     * @throws Exception when errors occur.
     */
    public void testConfigGetWithInValidNamespace() throws Exception {
        try {
            DVHelper.configGet("INVALIDNAMESPACE", "property", "defaultValue");
            fail("ConfigurationException is expected.");
        } catch (ConfigurationException iae) {
            // good
        }
    }

}
