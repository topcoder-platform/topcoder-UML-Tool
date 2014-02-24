/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the Helper class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class HelperUnitTests extends TestCase {
    /**
     * Accuracy test for the method <code>CheckNotNull(Object, String)</code>.
     */
    public void testCheckNotNull() {
        Helper.checkNotNull(new String(), "testString");
    }

    /**
     * Test the method <code>CheckNotNull(Object, String)</code> with null
     * object, IllegalArgumentException should be thrown.
     */
    public void testCheckNotNullWithNull() {
        try {
            Helper.checkNotNull(null, "null");
        } catch (IllegalArgumentException e) {
         // success
        }
    }

    /**
     * Accuracy test for the method <code>CheckNotNullAndNotContainsNull(Collection, String)</code>.
     */
    public void testCheckNotNullAndNotContainsNull() {
        Helper.checkNotNullAndNotContainsNull(new ArrayList(), "arraylist");
    }

    /**
     * Test the method <code>CheckNotNullAndNotContainsNull(Collection, String)</code> with null
     * collection, IllegalArgumentException should be thrown.
     */
    public void testCheckNotNullAndNotContainsNullWithNull() {
        try {
            Helper.checkNotNullAndNotContainsNull(null, "null");
        } catch (IllegalArgumentException e) {
         // success
        }
    }

    /**
     * Test the method <code>CheckNotNullAndNotContainsNull(Collection, String)</code> with
     * collection contains null, IllegalArgumentException should be thrown.
     */
    public void testCheckNotNullAndNotContainsNullContainNull() {
        try {
            ArrayList<String> list = new ArrayList<String>();
            list.add(null);
            Helper.checkNotNullAndNotContainsNull(list, "contain null list");
        } catch (IllegalArgumentException e) {
         // success
        }
    }

    /**
     * Accuracy test for the method <code>CheckNotNullAndNotEmpty(String, String)</code>.
     */
    public void testCheckNotNullAndNotEmpty() {
        Helper.checkNotNullAndNotEmpty("testString", "testString");
    }

    /**
     * Test the method <code>CheckNotNullAndNotEmpty(String, String)</code> with null
     * string, IllegalArgumentException should be thrown.
     */
    public void testCheckNotNullAndNotEmptyWithNull() {
        try {
            Helper.checkNotNullAndNotEmpty(null, "null");
        } catch (IllegalArgumentException e) {
         // success
        }
    }

    /**
     * Test the method <code>CheckNotNullAndNotEmpty(String, String)</code> with empty
     * object, IllegalArgumentException should be thrown.
     */
    public void testCheckNotNullAndNotEmptyWithEmptyString() {
        try {
            Helper.checkNotNullAndNotEmpty(" ", "empty");
        } catch (IllegalArgumentException e) {
         // success
        }
    }
}
