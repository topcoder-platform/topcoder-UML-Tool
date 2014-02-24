/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane;

import java.awt.Component;
import java.util.EventObject;

/**
 * <p>
 * Represents an event of the ClosableTabbedPane. It simply stores the index of the tab being affected and the source
 * pane which caused the event.
 * </p>
 * <p>
 * We extend EventObject to allow easy usage of this event inside of swing. The source is stored in the base class
 * while the tab index is stored in this class.
 * </p>
 * <p>
 * Thread Safety: This class is thread safe as it is immutable.
 * </p>
 * @author humblefool, TCSDEVELOPER
 * @version 1.0
 */
public class ClosableTabbedPaneEvent extends EventObject {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 9159426280641513726L;

    /**
     * <p>
     * Represents the tab index of this event. Must be &gt;=0 && &lt;getTabCount for the source closable tabbed pane.
     * It is frozen as it will not change after being set by the constructor. Retrieved by the getTabIndex method.
     * </p>
     */
    private final int tabIndex;

    private ClosableTabbedPane closableTabbedPane;

    /**
     * <p>
     * Constructs this event from the given tab index and source closable tabbed pane.
     * </p>
     * @param tabIndex
     *            the tabIndex of the event. Must be &gt;=0 && &lt;closableTabbedPane.getTabCount()
     * @param closableTabbedPane
     *            The source of the event. Must not be null.
     * @throws IllegalArgumentException
     *             if closableTabbedPane is null.
     * @throws IndexOutOfBoundsException
     *             if tabIndex is out of bounds.
     */
    public ClosableTabbedPaneEvent(int tabIndex, ClosableTabbedPane closableTabbedPane, Component source) {
        // Will check null in super constructor
        super(source);
        if (tabIndex < 0 || tabIndex >= closableTabbedPane.getTabCount()) {
            throw new IndexOutOfBoundsException("the given tabIndex is out of bounds");
        }
        this.tabIndex = tabIndex;
        this.closableTabbedPane = closableTabbedPane;
    }

    /**
     * <p>
     * Gets the tab index represented by this event.
     * </p>
     * @return the tab index represented by this event.
     */
    public int getTabIndex() {
        return tabIndex;
    }

    /**
     * <p>
     * Gets the source closable tabbed pane of this event.
     * </p>
     * @return the source closable tabbed pane of this event.
     */
    public ClosableTabbedPane getClosableTabbedPane() {
        return closableTabbedPane;
    }
}
