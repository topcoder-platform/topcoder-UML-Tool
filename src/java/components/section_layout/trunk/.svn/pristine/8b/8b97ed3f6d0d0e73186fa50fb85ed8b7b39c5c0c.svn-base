/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

/**
 * <p>
 * Mock implementation of <code>DockListener</code> interface.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is mutable and not thread-safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockDockListener implements DockListener {

    /**
     * <p>
     * If true, the docked is called.
     * </p>
     */
    private boolean docked = false;

    /**
     * <p>
     * Getter of docked.
     * </p>
     *
     * @return the docked flag
     */
    public boolean getDocked() {
        return docked;
    }

    /**
     * <p>
     * This method will be invoked when the listened Dock or DockContainer fired the docked event.
     * </p>
     *
     * @param event
     *        the docked event. will never be null
     */
    public void docked(DockEvent event) {
        docked = true;
    }

    /**
     * <p>
     * This method will be invoked when the listened Dock or DockContainer fired the undocked event.
     * </p>
     *
     * @param event
     *        the undocked event. will never be null
     */
    public void undocked(DockEvent event) {
        docked = false;
    }
}
