/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

/**
 * <p>
 * The listener is used to listen a <code>Dock</code> instance to know
 * whether it is docked or undocked to/from a dock container.
 * When a dock is docked,
 * the docked method will be fired, when a dock is undocked, the undocked method will be fired.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public interface DockListener {

    /**
     * <p>
     * This method will be invoked when the listened Dock or DockContainer fired the docked event.
     * </p>
     *
     * @param event
     *        the docked event. will never be null
     */
    public void docked(DockEvent event);

    /**
     * <p>
     * This method will be invoked when the listened Dock or DockContainer fired the undocked event.
     * </p>
     *
     * @param event
     *        the undocked event. will never be null
     */
    public void undocked(DockEvent event);
}
