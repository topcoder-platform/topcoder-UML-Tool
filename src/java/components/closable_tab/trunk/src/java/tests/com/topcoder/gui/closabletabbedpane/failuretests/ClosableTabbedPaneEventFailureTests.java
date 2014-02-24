/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.failuretests;

import java.awt.TextArea;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;

import junit.framework.TestCase;

/**
 * Failure test for <c>ClosableTabbedPaneEvent</c> class.
 *
 * @author liulike
 * @version 1.0
 *
 */
public class ClosableTabbedPaneEventFailureTests extends TestCase {

    /**
     * The <c>ClosableTabbedPane</c> instance for test.
     */
    private ClosableTabbedPane pane;

    /**
     * Set up test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        pane = new ClosableTabbedPane();
        pane.insertTab("title1", null, new TextArea(), null, 0);
    }

    /**
     * Tear down test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for ClosableTabbedPaneEvent#ClosableTabbedPaneEvent(int,
     * ClosableTabbedPane). It tests the case that argument is null, and
     * IllegalArgumentException is expected.
     */
    public void testClosableTabbedPaneEvent1() {
        try {
            new ClosableTabbedPaneEvent(0, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test method for ClosableTabbedPaneEvent#ClosableTabbedPaneEvent(int,
     * ClosableTabbedPane). It tests the case that tabIndex is out of bounds,
     * and IndexOutOfBoundsException is expected.
     */
    public void testClosableTabbedPaneEvent2() {
        try {
            new ClosableTabbedPaneEvent(-1, pane);
            fail("IndexOutOfBoundsException is expected");
        } catch (IndexOutOfBoundsException iae) {
            // good
        }
    }
}
