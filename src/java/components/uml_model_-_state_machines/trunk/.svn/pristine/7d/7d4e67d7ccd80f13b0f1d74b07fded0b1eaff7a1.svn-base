/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <code>Helper</code>.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class HelperUnitTests extends TestCase {
    /**
     * <p>
     * Test the method <code>checkNotNull(Object argument, String name)</code> with null Argument.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testCheckNotNullWithNullArgument() throws Exception {
        try {
            Helper.checkNotNull(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method <code>checkNotNull(Object argument, String name)</code> with unnull Argument.
     * </p>
     */
    public void testCheckNotNullWithUnNullArgument() {
        try {
            Helper.checkNotNull(new Object(), "test");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Test the method <code>chekCollection(Collection collection, String name)</code> with null Argument.
     * <code>IllegalArgumentException</code> should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testChekCollectionWithNull() throws Exception {
        try {
            Helper.chekCollection(null, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method <code>chekCollection(Collection collection, String name)</code> with unnull Argument.No
     * exception should be thrown.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testChekCollectionContainNull() throws Exception {
        try {
            Collection<Object> collection = new ArrayList<Object>();
            collection.add(null);
            Helper.chekCollection(collection, "test");
            fail("IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method <code>chekCollection(Collection collection, String name)</code> with unnull Argument.No
     * exception should be thrown.
     * </p>
     */
    public void testChekCollection() {
        try {
            Helper.chekCollection(new ArrayList(), "test");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
