/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.Point;

import com.topcoder.gui.sectionlayout.Helper;

/**
 * <p>
 * Represents the event of whether a dock is docked or undocked.
 * The <code>Dock</code> instance, <code>DockContainer</code> instance
 * and the location/index of the dock is wrapped into this event.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is immutable and thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class DockEvent {

    /**
     * <p>
     * The Dock instance in this event, initialized in the constructor and never changed later.
     * Can't be null. Accessed in the getter.
     * </p>
     */
    private final Dock dock;

    /**
     * <p>
     * The DockContainer instance in this event, initialized in the constructor and never changed later.
     * Can't be null. Accessed in the getter.
     * </p>
     */
    private final DockContainer container;

    /**
     * <p>
     * The location of the dock in the dock container in this event,
     * initialized in the constructor and never changed later.
     * If it is a docked event, the location is the location of dock when docked.
     * If it is a undocked event, the location is the location of dock before undocked.
     * Can be null. Accessed in the getter.
     * </p>
     */
    private final Point location;

    /**
     * <p>
     * The index of the dock in the dock container in this event,
     * initialized in the constructor and never changed later.
     * If it is a docked event, the index is the index of dock when docked.
     * If it is a undocked event, the index is the index of dock before undocked.
     * It can be negative, the meaning of it is depended on the implementation of DockContainer.
     * Accessed in the getter.
     * </p>
     */
    private final int index;

    /**
     * <p>
     * Constructs a DockEvent instance with dock, dock container, location and index.
     * </p>
     *
     * @param dock
     *        the Dock instance of the event
     * @param container
     *        the dock container of the event
     * @param location
     *        the location of the dock in the dock container
     * @param index
     *        the index of the dock in dock container,
     *        it can be negative, the meaning of it is depended on the implementation of DockContainer.
     * @throws IllegalArgumentException
     *         if dock or container is null
     */
    public DockEvent(Dock dock, DockContainer container, Point location, int index) {
        Helper.checkNull(dock, "dock");
        Helper.checkNull(container, "container");

        this.dock = dock;
        this.container = container;
        this.location = location;
        this.index = index;
    }

    /**
     * <p>
     * The getter of dock property of this event.
     * </p>
     *
     * @return the dock property
     */
    public Dock getDock() {
        return dock;
    }

    /**
     * <p>
     * The getter of dock container property of this event.
     * </p>
     *
     * @return the container property
     */
    public DockContainer getContainer() {
        return container;
    }

    /**
     * <p>
     * The getter of location property of this event.
     * </p>
     *
     * @return the location property
     */
    public Point getLocation() {
        return location;
    }

    /**
     * <p>
     * The getter of index property of this event.
     * </p>
     *
     * @return the index property
     */
    public int getIndex() {
        return index;
    }
}
