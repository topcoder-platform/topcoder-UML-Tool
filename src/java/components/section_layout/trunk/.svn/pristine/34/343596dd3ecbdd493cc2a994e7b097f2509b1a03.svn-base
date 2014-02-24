/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.Point;

/**
 * <p>
 * It is a floatable dock container.
 * When a dock is dropped not in a dock container, and if the dock is floatable,
 * it should be put in a float dock container.
 * The float dock container can be set to arbitrary location, can be closed,
 * when it is closed, the docks in it should be docked back to the original dock containers.
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
public interface FloatContainer extends DockContainer {

    /**
     * <p>
     * Move the floating dock container to the specific location,
     * the location is the absolute location in the screen.
     * </p>
     *
     * @param location
     *        the absolute location where the float container should be moved to
     */
    public void setLocation(Point location);

    /**
     * <p>
     * Close the float container.
     * It should also undock the containing docks and redock the docks back to there original dock containers.
     * If it is already closed, do nothing.
     * </p>
     */
    public void close();

    /**
     * <p>
     * Open a closed float container, if it is already opened, do nothing.
     * </p>
     */
    public void open();
}
