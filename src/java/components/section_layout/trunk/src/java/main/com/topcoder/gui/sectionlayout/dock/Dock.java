/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.Cursor;
import java.awt.Point;
import java.util.List;

/**
 * <p>
 * <code>Dock</code> represents an item can be docked into dock container.
 * It is designed to be used as a wrapper of swing component which implements the <code>Dockable</code> interface.
 * When creating an instance of it with a specific swing component,
 * the instance should setup any necessary mechanism to enable the dock functionality.
 * It also accepts listeners to listen whether the dock is docked or undocked.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is in swing framework, and  the implementation is not required to be thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public interface Dock {

    /**
     * <p>
     * Return the inner Dockable instance.
     * </p>
     *
     * @return the inner Dockable instance
     */
    public Dockable getDockable();

    /**
     * <p>
     * Getter of the gesture cursor when dragging.
     * </p>
     *
     * @return the gesture cursor when dragging
     */
    public Cursor getGestureCursor();

    /**
     * <p>
     * Setter of the gesture cursor when dragging.
     * </p>
     *
     * @param gestureCursor
     *        the gesture cursor when dragging
     */
    public void setGestureCursor(Cursor gestureCursor);

    /**
     * <p>
     * Setter of the floatable property of the dock.
     * </p>
     *
     * @param floatable
     *        whether the dock is floatable
     */
    public void setFloatable(boolean floatable);

    /**
     * <p>
     * Getter of the floatable property of the dock.
     * </p>
     *
     * @return whether the dock is floatable
     */
    public boolean isFloatable();

    /**
     * <p>
     * Setter of the dragEnabled property of the dock.
     * </p>
     *
     * @param enable
     *        whether the dock is drag enabled
     */
    public void setDragEnabled(boolean enable);

    /**
     * <p>
     * Getter of the dragEnabled property of the dock.
     * </p>
     *
     * @return whether the dock is drag enabled
     */
    public boolean isDragEnabled();

    /**
     * <p>
     * Float the dock to the specific location.
     * Note that the location is the point of dragging cursor,
     * so it may need to translate the drag start location.
     * </p>
     *
     * @param location
     *        the location of dragging cursor
     */
    public void floatTo(Point location);

    /**
     * <p>
     * Setter of the dragStartLocation property of the dock.
     * </p>
     *
     * @param location
     *        the relative location of the dockable component when the drag started
     * @throws IllegalArgumentException
     *         if location is null
     */
    public void setDragStartLocation(Point location);

    /**
     * <p>
     * Getter of the dragStartLocation property of the dock.
     * </p>
     *
     * @return the relative location of the dockable component when the drag started
     */
    public Point getDragStartLocation();

    /**
     * <p>
     * Add a DockListener instance.
     * </p>
     *
     * @param listener
     *        the listener to listen when this dock is docked or undocked
     * @throws IllegalArgumentException
     *         if listener is null
     */
    public void addDockListener(DockListener listener);

    /**
     * <p>
     * Remove a DockListener instance.
     * </p>
     *
     * @param listener
     *        the listener to listen when this dock is docked or undocked
     * @throws IllegalArgumentException
     *         if listener is null
     */
    public void removeDockListener(DockListener listener);

    /**
     * <p>
     * Return the shallow copy of all the DockListener instances in this dock.
     * </p>
     *
     * @return the shallow copy of all the DockListener instances in this dock
     */
    public List<DockListener> getDockListeners();

    /**
     * <p>
     * Fire the docked event, invoke the docked method of all the listeners in this dock.
     * This method should also save the current dock container, position, and index in this dock.
     * </p>
     *
     * @param event
     *        the docked event
     */
    public void fireDocked(DockEvent event);

    /**
     * <p>
     * Fire the undocked event, invoke the undocked method of all the listeners in this dock.
     * This method should also clear the current dock container, position, and index in this dock.
     * </p>
     *
     * @param event
     *        the undocked event
     */
    public void fireUndocked(DockEvent event);

    /**
     * <p>
     * Return the current dock container of this dock.
     * </p>
     *
     * @return the current dock container of this dock
     */
    public DockContainer getCurrentDockContainer();

    /**
     * <p>
     * Return the location in current dock container of this dock.
     * </p>
     *
     * @return the location in current dock container of this dock
     */
    public Point getCurrentLocationInContainer();

    /**
     * <p>
     * Return the index in current dock container of this dock.
     * </p>
     *
     * @return the index in current dock container of this dock
     */
    public int getCurrentIndexInContainer();
}
