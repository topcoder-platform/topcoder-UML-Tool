/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Container;
import java.awt.Point;
import java.util.List;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.BasicDockContainer;

/**
 * <p>
 * A mock implementation of <code>BasicDockContainer</code> for failure test.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class BasicDockContainerImpl extends BasicDockContainer {

    /**
     * <p>
     * The constructor.
     * </p>
     */
    public BasicDockContainerImpl() {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the dock
     * @return false
     */
    public boolean canDock(Dock dock) {
        return false;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     */
    public void clearDockGesture() {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the dock
     */
    public void dock(Dock dock) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the dock
     * @param location the location
     */
    public void dock(Dock dock, Point location) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the dock
     * @param index the index
     */
    public void dock(Dock dock, int index) {
        // empty

    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the dock
     * @param location the index
     * @param index the index
     */
    public void dock(Dock dock, Point location, int index) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public List<Dock> getCurrentDocks() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public Container getDockTarget() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the parameter
     * @param location the parameter
     */
    public void markDockGesture(Dock dock, Point location) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the parameter
     */
    public void undock(Dock dock) {
        // empty
    }

}
