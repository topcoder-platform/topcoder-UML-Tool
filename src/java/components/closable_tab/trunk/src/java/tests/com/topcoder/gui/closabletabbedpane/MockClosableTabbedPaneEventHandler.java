/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

/**
 * A mock handler that actually does nothing. Used in Unit Test.
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockClosableTabbedPaneEventHandler implements ClosableTabbedPaneEventHandler {
    /**
     * Does nothing.
     * @param e
     *            useless
     */
    public void tabAdded(ClosableTabbedPaneEvent e) {
    }

    /**
     * Does nothing.
     * @param e
     *            useless
     * @return always an array of false
     */
    public boolean[] tabsClosing(ClosableTabbedPaneEvent[] e) {
        return new boolean[e.length];
    }

    /**
     * Does nothing.
     * @param e
     *            useless
     */
    public void tabsClosed(ClosableTabbedPaneEvent[] e) {
    }

}
