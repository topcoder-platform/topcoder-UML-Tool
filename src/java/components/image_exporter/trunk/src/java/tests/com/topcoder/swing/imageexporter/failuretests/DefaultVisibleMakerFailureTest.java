/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter.failuretests;

import javax.swing.JLabel;

import com.topcoder.swing.imageexporter.DefaultVisibleMaker;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for DefaultVisibleMaker class.
 *
 * @author iamajia
 * @version 1.0
 */
public class DefaultVisibleMakerFailureTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private DefaultVisibleMaker defaultVisibleMaker = new DefaultVisibleMaker();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DefaultVisibleMakerFailureTest.class);
    }

    /**
     * Failure test of <code>makeVisible(JComponent component)</code> method.
     *
     * <p>
     * component is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testMakeVisibleFailure_null_component() throws Exception {
        try {
            defaultVisibleMaker.makeVisible(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>restoreVisibility(JComponent component)</code> method.
     *
     * <p>
     * component is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRestoreVisibilityFailure_null_component() throws Exception {
        try {
            defaultVisibleMaker.restoreVisibility(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>restoreVisibility(JComponent component)</code> method.
     *
     * <p>
     * component is not exist.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRestoreVisibilityFailure_component_not_exist() throws Exception {
        try {
            defaultVisibleMaker.restoreVisibility(new JLabel("hello"));
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
