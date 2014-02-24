/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * UnitTest for Helper class.
 * </p>
 *
 * @author BLE
 * @version 1.0
 */
public class HelperTest extends TestCase {

    /**
     * <p>
     * Accuracy test of <code>assertNotNull(Object obj, String name)</code>.
     * </p>
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testAssertNotNullAccuracy() throws Exception {
        // no exception will be thrown.
        Helper.assertNotNull(new Object(), "test");
    }

    /**
     * <p>
     * Failure test of <code>assertNotNull(Object obj, String name)</code>.
     * </p>
     * <p>
     * obj is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testAssertNotNullFailure() throws Exception {
        try {
            Helper.assertNotNull(null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>assertNotNullOrContainsNull(Collection collection, String name)</code>.
     * </p>
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testAssertNotNullOrContainsNullAccuracy() throws Exception {
        // no exception will be thrown.
        Helper.assertNotNull(new ArrayList(), "test");
    }

    /**
     * <p>
     * Failure test of
     * <code>assertNotNullOrContainsNull(Collection collection, String name)</code>.
     * </p>
     * <p>
     * collection is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testAssertNotNullOrContainsNullFailure1() throws Exception {
        try {
            Helper.assertNotNullOrContainsNull(null, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>assertNotNullOrContainsNull(Collection collection, String name)</code>.
     * </p>
     * <p>
     * collection contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception throw exception to JUnit.
     */
    public void testAssertNotNullOrContainsNullFailure2() throws Exception {
        Collection collection = new ArrayList();
        collection.add(null);
        try {
            Helper.assertNotNullOrContainsNull(collection, "test");
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
