/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.Container;
import java.awt.Point;
import java.util.List;

/**
 * <p>
 * This interface defines a container which can dock or undock a <code>Dock</code> instance.
 * It is defined as a wrapper of swing <code>Container</code>.
 * When an instance of this is created,
 * it will setup any necessary mechanism to enable the dock functionality in the specific swing container.
 * It also accepts listeners to listen whether a dock is docked or undocked to/from this container.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is in swing framework, and the implementation is not required to be thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public interface DockContainer {

    /**
     * <p>
     * Dock the specific dock instance.
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     */
    public void dock(Dock dock);

    /**
     * <p>
     * Dock the specific dock instance to specific location.
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param location
     *        the preferred location in the container where the dock should be docked
     */
    public void dock(Dock dock, Point location);

    /**
     * <p>
     * Dock the specific dock instance to specific index.
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param index
     *        the preferred index in the container where the dock should be docked
     */
    public void dock(Dock dock, int index);

    /**
     * <p>
     * Dock the specific dock instance to specific location or index(up to the implementation).
     * It should also undock the dock first if necessary.
     * It should also fire the docked event both in the container and the dock.
     * </p>
     *
     * @param dock
     *        the dock instance to be docked
     * @param location
     *        the preferred location in the container where the dock should be docked
     * @param index
     *        the preferred index in the container where the dock should be docked
     */
    public void dock(Dock dock, Point location, int index);

    /**
     * <p>
     * Undock the specific dock instance from this container.
     * It should also fire the undocked event both in the container and the dock.
     * If the dock is not docked before, do nothing.
     * </p>
     *
     * @param dock
     *        the specific dock to be undocked
     */
    public void undock(Dock dock);

    /**
     * <p>
     * Mark the dock gesture to the location for the given dock instance.
     * There should be a visual indicator when docking to
     * show the user where the given dock is going to be placed in the dock container.
     * </p>
     *
     * @param dock
     *        the given dock being docked
     * @param location
     *        the location of the dock being docked
     */
    public void markDockGesture(Dock dock, Point location);

    /**
     * <p>
     * Clear the gesture (the visual indicator) marked in markDockGesture method.
     * </p>
     */
    public void clearDockGesture();

    /**
     * <p>
     * Return the current docks in this container.
     * </p>
     *
     * @return the shallow copy of the current docks in this container
     */
    public List<Dock> getCurrentDocks();

    /**
     * <p>
     * Return whether the given dock can be docked in this container.
     * </p>
     *
     * @param dock
     *        the given dock
     * @return whether the given dock can be docked in this container
     */
    public boolean canDock(Dock dock);

    /**
     * <p>
     * The setter of dockEnabled property in this container.
     * </p>
     *
     * @param enable
     *        whether the dock container is enabled,
     *        false means the dock container is disabled and can't accept any dock.
     */
    public void setDockEnabled(boolean enable);

    /**
     * <p>
     * The getter of dockEnabled property in this container.
     * </p>
     *
     * @return whether the dock container is enabled,
     *         false means the dock container is disabled and can't accept any dock.
     */
    public boolean isDockEnabled();

    /**
     * <p>
     * Return native swing container where the dockable components docked.
     * </p>
     *
     * @return native swing container where the dockable components docked
     */
    public Container getDockTarget();

    /**
     * <p>
     * Add a DockListener instance.
     * </p>
     *
     * @param listener
     *        the listener to listen when a dock is docked or undocked in this container
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
     *        the listener to listen when a dock is docked or undocked in this container
     * @throws IllegalArgumentException
     *         if listener is null
     */
    public void removeDockListener(DockListener listener);

    /**
     * <p>
     * Return the shallow copy of all the DockListener instances in this dock container.
     * </p>
     *
     * @return the shallow copy of all the DockListener instances in this dock container
     */
    public List<DockListener> getDockListeners();

    /**
     * <p>
     * Fire the docked event, invoke the docked method of all the listeners in this dock container.
     * </p>
     *
     * @param event
     *        the docked event
     */
    public void fireDocked(DockEvent event);

    /**
     * <p>
     * Fire the undocked event, invoke the undocked method of all the listeners in this dock container.
     * </p>
     *
     * @param event
     *        the undocked event
     */
    public void fireUndocked(DockEvent event);
}
