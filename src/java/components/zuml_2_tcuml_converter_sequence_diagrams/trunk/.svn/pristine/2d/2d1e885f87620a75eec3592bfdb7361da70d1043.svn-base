/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;
import java.util.LinkedList;


/**
 * <p>
 * Unit tests for <code>Helper</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HelperUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for <code>checkNull(Object, String)</code>
     * </p>
     *
     * <p>
     * Target: Verify that <code>checkNull(Object, String)</code> is correct.
     * </p>
     */
    public void testCheckNull_Accuracy() {
        Helper.checkNull("test", "name");
    }

    /**
     * <p>
     * Failure test for <code>checkNull(Object, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: the obj to be checked is null.<br>
     * Expected: <code>IllegalArgumentException</code>.
     * </p>
     */
    public void testCheckNull_Failure() {
        try {
            Helper.checkNull(null, "null");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkCollection(Collection, String)</code>.
     * </p>
     */
    public void testCheckCollection_Accuracy() {
        Collection<String> col = new LinkedList<String>();
        col.add("one");

        Helper.checkCollection(col, "col");
    }

    /**
     * <p>
     * Failure test for <code>checkCollection(Collection, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the collection is null, IllegalArgumentException is excepted.
     * </p>
     */
    public void testCheckCollection_Failure1() {
        try {
            Helper.checkCollection(null, "col");

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkCollection(Collection, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the collection is empty, IllegalArgumentException is excepted.
     * </p>
     */
    public void testCheckCollection_Failure2() {
        try {
            Collection<String> col = new LinkedList<String>();

            Helper.checkCollection(col, "col");

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkCollection(Collection, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the collection contains null, IllegalArgumentException is excepted.
     * </p>
     */
    public void testCheckCollection_Failure3() {
        try {
            Collection<String> col = new LinkedList<String>();
            col.add(null);

            Helper.checkCollection(col, "col");

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}
