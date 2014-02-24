/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>{@link Helper}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {

    /**
     * <p>
     * Unit test for <code>{@link Helper#validateObject(Object, String)}</code> method.
     * </p>
     * <p>
     * If the object parameter is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testValidateObject_IAE() {
        try {
            Helper.validateObject(null, "test");
            fail("If the object parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link Helper#validateObject(Object, String)}</code> method.
     * </p>
     * <p>
     * If the object parameter is not null, should not throw IllegalArgumentException.
     * </p>
     */
    public void testValidateObject_Accuracy() {
        try {
            Helper.validateObject(new Object(), "test");
        } catch (IllegalArgumentException e) {
            fail("If the object parameter is not null, should not throw IllegalArgumentException.");
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link Helper#validateString(String, String)}</code> method.
     * </p>
     * <p>
     * If the value parameter is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testValidateString_NullValue() {
        try {
            Helper.validateString(null, "test");
            fail("If the value parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link Helper#validateString(String, String)}</code> method.
     * </p>
     * <p>
     * If the value parameter is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testValidateString_EmptyValue() {
        try {
            Helper.validateString("", "test");
            fail("If the value parameter is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link Helper#validateString(String, String)}</code> method.
     * </p>
     * <p>
     * If the value parameter is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testValidateString_TrimmedEmptyValue() {
        try {
            Helper.validateString("  ", "test");
            fail("If the value parameter is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link Helper#validateString(String, String)}</code> method.
     * </p>
     * <p>
     * If the value parameter is not null or empty, should not throw IllegalArgumentException.
     * </p>
     */
    public void testValidateString_Accuracy() {
        try {
            Helper.validateString("test", "test");
        } catch (IllegalArgumentException e) {
            fail("If the value parameter is not null or empty, should not throw IllegalArgumentException.");
        }
    }

}
