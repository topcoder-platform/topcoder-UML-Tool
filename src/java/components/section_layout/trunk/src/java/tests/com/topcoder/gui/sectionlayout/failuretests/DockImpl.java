/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Cursor;
import java.awt.Point;
import java.util.List;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockContainer;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;
import com.topcoder.gui.sectionlayout.dock.Dockable;

/**
 * <p>
 * A mock implementation of <code>Dock</code> for failure test.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DockImpl implements Dock {
    /**
     * <p>
     * The constructor.
     * </p>
     */
    public DockImpl() {
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
     * @param location the parameter
     */
    public void floatTo(Point location) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public DockContainer getCurrentDockContainer() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return 0
     */
    public int getCurrentIndexInContainer() {
        return 0;
    }


    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public Point getCurrentLocationInContainer() {
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
    public Dockable getDockable() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public Point getDragStartLocation() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return null
     */
    public Cursor getGestureCursor() {
        return null;
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return false
     */
    public boolean isDragEnabled() {
        return false;
    }


    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @return false
     */
    public boolean isFloatable() {
        return false;
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
    public void setDragEnabled(boolean enable) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param location the parameter
     */
    public void setDragStartLocation(Point location) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param floatable the parameter
     */
    public void setFloatable(boolean floatable) {
        // empty
    }

    /**
     * <p>
     * The mock stub.
     * </p>
     *
     * @param gestureCursor the parameter
     */
    public void setGestureCursor(Cursor gestureCursor) {
        // empty
    }

}
