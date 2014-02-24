/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.util.EventListener;

/**
 * <p>
 * This interface lays the contract for handling tabbed pane events (addition/removal of tabs). This is a handler -
 * and not just a passive listener - since it can prevent the closure of tabs. There are three events which can be
 * observed - the addition of a tab, the event just before the closing of tabs (which can be handled to prevent the
 * closure) and the event just after closing of tabs. We extend EventListener to allow easy usage of this handler
 * interface inside Swing components.
 * </p>
 * <p>
 * Thread Safety: Implementations need not be thread safe.
 * </p>
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public interface ClosableTabbedPaneEventHandler extends EventListener {
    /**
     * <p>
     * Represents the event of a tab having been added to the pane.
     * </p>
     * @param e
     *            The event. Will not be null.
     * @throws IllegalArgumentException
     *             If e is null.
     */
    public void tabAdded(ClosableTabbedPaneEvent e);

    /**
     * <p>
     * Represents the event of tab(s) about to close.
     * </p>
     * @return An array of booleans, with the same length as e. The corresponding element is true to continue with
     *         closure of that tab, false otherwise.
     * @param e
     *            The events, one per tab. Will not be null/empty or contain nulls.
     * @throws IllegalArgumentException
     *             If e is null/empty or contains nulls.
     */
    public boolean[] tabsClosing(ClosableTabbedPaneEvent[] e);

    /**
     * <p>
     * Represents the event of tab(s) having closed.
     * </p>
     * @throws IllegalArgumentException
     *             if e is null/empty or contains nulls.
     * @param e
     *            The events, one per tab. Will not be null/empty or contain nulls.
     */
    public void tabsClosed(ClosableTabbedPaneEvent[] e);
}
