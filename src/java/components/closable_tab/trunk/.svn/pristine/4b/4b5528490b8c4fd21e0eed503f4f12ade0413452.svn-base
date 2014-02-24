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
 * UnitTest for ClosableTabbedPaneEvent class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPaneEventUnitTest extends TestCase {
    /** Prepare a default ClosableTabbedPane for testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ClosableTabbedPaneEventUnitTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        pane.insertTab("title1", null, new TextArea(), null, 0);
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPaneEvent(int tabIndex, ClosableTabbedPane closableTabbedPane)</code>
     * constructor.
     * </p>
     * <p>
     * Simply call this constructor. No exception should be thrown.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneEventAccuracy() throws Exception {
        new ClosableTabbedPaneEvent(0, pane);
    }

    /**
     * <p>
     * Accuracy test of <code>ClosableTabbedPaneEvent(int tabIndex, ClosableTabbedPane closableTabbedPane)</code>
     * constructor.
     * </p>
     * <p>
     * Simply call this constructor. No exception should be thrown.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneEventComplex() throws Exception {
        pane.insertTab("title2", null, new TextArea(), null, 1);
        pane.insertTab("title3", null, new TextArea(), null, 2);
        assertEquals("ClosableTabbedPaneEvent incorrect", 0, new ClosableTabbedPaneEvent(0, pane).getTabIndex());
        assertEquals("ClosableTabbedPaneEvent incorrect", 1, new ClosableTabbedPaneEvent(1, pane).getTabIndex());
        assertEquals("ClosableTabbedPaneEvent incorrect", 2, new ClosableTabbedPaneEvent(2, pane).getTabIndex());
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPaneEvent(int tabIndex, ClosableTabbedPane closableTabbedPane)</code>
     * constructor.
     * </p>
     * <p>
     * Null pane.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneEventFailure1() throws Exception {
        try {
            new ClosableTabbedPaneEvent(1, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPaneEvent(int tabIndex, ClosableTabbedPane closableTabbedPane)</code>
     * constructor.
     * </p>
     * <p>
     * Simply make the index out of bound
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneEventFailure2() throws Exception {
        try {
            new ClosableTabbedPaneEvent(-1, pane);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>ClosableTabbedPaneEvent(int tabIndex, ClosableTabbedPane closableTabbedPane)</code>
     * constructor.
     * </p>
     * <p>
     * Simply make the index out of bound.
     * </p>
     * <p>
     * Expect IndexOutOfBoundsException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testClosableTabbedPaneEventFailure3() throws Exception {
        try {
            new ClosableTabbedPaneEvent(1, pane);
            fail("Expect IndexOutOfBoundsException.");
        } catch (IndexOutOfBoundsException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of <code>getTabIndex()</code> method.
     * </p>
     * <p>
     * Simply retrieve and verify.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetTabIndexAccuracy() throws Exception {
        assertEquals("getTabIndex incorrect", 0, new ClosableTabbedPaneEvent(0, pane).getTabIndex());
    }

    /**
     * <p>
     * Accuracy test of <code>getClosableTabbedPane()</code> method.
     * </p>
     * <p>
     * Test if the pane is retrieved properly.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testGetClosableTabbedPaneAccuracy() throws Exception {
        assertEquals("getCloseButtonPadding incorrect", pane, new ClosableTabbedPaneEvent(0, pane)
            .getClosableTabbedPane());
    }
}
