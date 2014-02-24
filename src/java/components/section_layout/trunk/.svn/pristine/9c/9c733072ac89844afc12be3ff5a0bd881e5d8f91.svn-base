/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;


/**
 * Mock a DockListener for testing.
 *
 * @author Chenhong
 * @version 1.0
 */
public class MyDockListener implements DockListener {
    /** Represents if the dock method is called. */
    private boolean dockCalled = false;

    /** Represents if the undock method is called. */
    private boolean unDockCalled = false;

    /**
     * Get if the dock is called.s
     *
     * @return true or false
     */
    public boolean isDockCalled() {
        return dockCalled;
    }

    /**
     * Dock the event.
     *
     * @param event the event.
     */
    public void docked(DockEvent event) {
        System.out.println("Dock the event");
        this.dockCalled = true;
    }

    /**
     * Undock with event.
     *
     * @param event the event.
     */
    public void undocked(DockEvent event) {
        this.unDockCalled = true;
        System.out.println("undock the event");
    }

    /**
     * Return if the undock method is called.
     *
     * @return true if called.
     */
    public boolean isUndockCalled() {
        return this.unDockCalled;
    }
}
