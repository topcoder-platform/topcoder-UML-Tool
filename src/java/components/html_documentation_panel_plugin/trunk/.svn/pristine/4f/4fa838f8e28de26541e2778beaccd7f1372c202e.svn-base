/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HelperTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.configuration.ConfigurationObject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>Unit tests for <code>Helper</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HelperTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HelperTest.class);
    }

    /**
     * <p>Accuracy test for method <code>getPropInt</code>.</p>
     *  <p>Verify that can get integer field value correctly.</p>
     *  <p>Get existed required field value.</p>
     *  <p>Get not existed optional field value, use default value.</p>
     */
    public void testGetPropIntAccuracy() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            int value1 = Helper.getPropInt(config, "exist_field", true, -1);
            assertEquals("values should be equal.", 717, value1);

            int value2 = Helper.getPropInt(config, "not_exist_field", false, 717);
            assertEquals("values should be equal.", 717, value2);
        } catch (HTMLDocumentationEditorException e) {
            fail("HTMLDocumentationEditorException should not be thrown.");
        }
    }

    /**
     * <p>Failure test for method <code>getPropInt</code>.</p>
     *  <p>Get not existed required field value, HTMLDocumentationEditorException should be thrown.</p>
     */
    public void testGetPropIntFailure1() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            Helper.getPropInt(config, "not_exist_field", true, -1);
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getPropInt</code>.</p>
     *  <p>Filed value is not an integer, HTMLDocumentationEditorException should be thrown.</p>
     */
    public void testGetPropIntFailure2() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            Helper.getPropInt(config, "not_a_number_field", true, -1);
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getPropInt</code>.</p>
     *  <p>Filed value is empty, HTMLDocumentationEditorException should be thrown.</p>
     */
    public void testGetPropIntFailure3() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            Helper.getPropInt(config, "empty_field", true, -1);
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Accuracy test for method <code>getPropString</code>.</p>
     *  <p>Verify that can get string field value correctly.</p>
     *  <p>Get existed required field value.</p>
     *  <p>Get not existed optional field value, use default value.</p>
     */
    public void testGetPropStringAccuracy() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            String value1 = Helper.getPropString(config, "exist_field", true, null);
            assertEquals("values should be equal.", "717", value1);

            String value2 = Helper.getPropString(config, "not_exist_field", false, "717");
            assertEquals("values should be equal.", "717", value2);
        } catch (HTMLDocumentationEditorException e) {
            fail("HTMLDocumentationEditorException should not be thrown.");
        }
    }

    /**
     * <p>Failure test for method <code>getPropString</code>.</p>
     *  <p>Get not existed required field value, HTMLDocumentationEditorException should be thrown.</p>
     */
    public void testGetPropStringFailure1() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            Helper.getPropString(config, "not_exist_field", true, null);
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getPropString</code>.</p>
     *  <p>Get empty value for required field, HTMLDocumentationEditorException should be thrown.</p>
     */
    public void testGetPropStringFailure2() {
        ConfigurationObject config = TestHelper.getDefaultConfig("valid1");

        try {
            Helper.getPropString(config, "empty_field", true, null);
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Accuracy test for method <code>getPropConfigObject</code>.</p>
     *  <p>Verify that can get child configuration object correctly.</p>
     */
    public void testGetPropConfigObjectAccuracy() {
        ConfigurationObject config = TestHelper.getConfig("valid1");

        try {
            ConfigurationObject child = Helper.getPropConfigObject(config, "test_child");
            assertTrue("Should be instance of ConfigurationObject", child instanceof ConfigurationObject);
        } catch (HTMLDocumentationEditorException e) {
            fail("HTMLDocumentationEditorException should not be thrown.");
        }
    }

    /**
     * <p>Failure test for method <code>getPropConfigObject</code>.</p>
     *  <p>Specified child configuration object not exists, HTMLDocumentationEditorException will be thrown.</p>
     */
    public void testGetPropConfigObjectFailure() {
        ConfigurationObject config = TestHelper.getConfig("valid1");

        try {
            Helper.getPropConfigObject(config, "not_exist_child");
            fail("HTMLDocumentationEditorException should not be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }
}
