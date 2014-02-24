/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Container;
import java.awt.Point;
import java.util.List;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;

/**
 * <p>
 * A mock implementation of <code>DockContainer</code> for failure test.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DockContainerImpl implements DockContainer {

    /**
     * <p>
     * Constructor.
     * </p>
     */
    public DockContainerImpl() {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param listener the parameter
     */
    public void addDockListener(DockListener listener) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the parameter
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
     * @param dock the parameter
     */
    public void dock(Dock dock) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the parameter
     * @param location the parameter
     */
    public void dock(Dock dock, Point location) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the parameter
     * @param index the parameter
     */
    public void dock(Dock dock, int index) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param dock the parameter
     * @param location the parameter
     * @param index the parameter
     */
    public void dock(Dock dock, Point location, int index) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param event the parameter
     */
    public void fireDocked(DockEvent event) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param event the parameter
     */
    public void fireUndocked(DockEvent event) {
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
    public List<DockListener> getDockListeners() {
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
     * @return null
     */
    public boolean isDockEnabled() {
        return false;
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
     * @param listener the parameter
     */
    public void removeDockListener(DockListener listener) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param enable the parameter
     */
    public void setDockEnabled(boolean enable) {
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
