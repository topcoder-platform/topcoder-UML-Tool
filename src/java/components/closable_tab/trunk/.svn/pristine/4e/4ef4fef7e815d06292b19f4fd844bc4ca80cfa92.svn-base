/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.TextArea;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * UnitTest for ClosableTabbedPaneHelper class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPaneHelperUnitTest extends TestCase {
    /** Prepare a default ClosableTabbedPane for testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** Prepare two events for testing. */
    private ClosableTabbedPaneEvent event1, event2;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ClosableTabbedPaneHelperUnitTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        pane.insertTab("title", null, new TextArea(), null, 0);
        event1 = new ClosableTabbedPaneEvent(0, pane);
        event2 = new ClosableTabbedPaneEvent(0, pane);
    }

    /**
     * <p>
     * Accuracy test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check with a single event.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayAccuracy1() throws Exception {
        ClosableTabbedPaneHelper.checkArray(new ClosableTabbedPaneEvent[] {event1});
    }

    /**
     * <p>
     * Accuracy test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check with duplicates.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayAccuracy3() throws Exception {
        ClosableTabbedPaneHelper.checkArray(new ClosableTabbedPaneEvent[] {event1, event1});
    }

    /**
     * <p>
     * Accuracy test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check with two events.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayAccuracy2() throws Exception {
        ClosableTabbedPaneHelper.checkArray(new ClosableTabbedPaneEvent[] {event1, event2});
    }

    /**
     * <p>
     * Failure test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayFailure1() throws Exception {
        try {
            ClosableTabbedPaneHelper.checkArray(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check with empty.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayFailure2() throws Exception {
        try {
            ClosableTabbedPaneHelper.checkArray(new ClosableTabbedPaneEvent[0]);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check when contains null only.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayFailure3() throws Exception {
        try {
            ClosableTabbedPaneHelper.checkArray(new ClosableTabbedPaneEvent[] {null});
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>checkArray(ClosableTabbedPaneEvent[] events)</code> method.
     * </p>
     * <p>
     * Check when contains null in the middle.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testCheckArrayFailure4() throws Exception {
        try {
            ClosableTabbedPaneHelper.checkArray(new ClosableTabbedPaneEvent[] {event1, null, event2});
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
