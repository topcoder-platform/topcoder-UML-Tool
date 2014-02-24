/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

/**
 * <p>
 * A mock class for class <code>ClosableTabbedPaneEventHandler</code> used for stress
 * tests.
 * </p>
 *
 * @author Littleken
 * @version 1.0
 */
public class MockClosableTabbedPaneEventHandlerForStress implements ClosableTabbedPaneEventHandler {

    /**
     * <p>
     * Default constructor.
     * </p>
     */
    public MockClosableTabbedPaneEventHandlerForStress() {
        // Does nothing.
    }

    /**
     * <p>
     * Represents the event used for stress tests.
     * </p>
     *
     * @throws IllegalArgumentException If e is null.
     * @param e the event. Will not be null.
     */
    public void tabAdded(ClosableTabbedPaneEvent e) {
        // Does nothing.
    }

    /**
     * <p>
     * Represents the event of tab(s) about to close used for stress tests.
     * </p>
     *
     * @throws IllegalArgumentException if events is null/empty or contains
     *             nulls.
     * @param events the events, one per tab. Will not be null/empty or contain
     *            nulls.
     * @return An array of booleans, with the same length as e. The
     *         corresponding element is true to continue with closure of that
     *         tab, false otherwise.
     */
    public boolean[] tabsClosing(ClosableTabbedPaneEvent[] e) {
        return new boolean[e.length];
    }

    /**
     * <p>
     * Represents the event of tab(s) having closed used for stress tests.
     * </p>
     *
     * @throws IllegalArgumentException if events is null/empty or contains
     *             nulls.
     * @param events the events, one per tab. Will not be null/empty or contain
     *            nulls.
     */
    public void tabsClosed(ClosableTabbedPaneEvent[] e) {
        // Does nothing.
    }

}
