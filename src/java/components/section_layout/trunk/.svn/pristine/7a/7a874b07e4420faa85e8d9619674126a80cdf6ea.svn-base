/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.event.InputEvent;

/**
 * <p>
 * It is a listener to listen whether a dockable component trigger an event to start drag.
 * It can be set to a <code>Dockable</code> instance.
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
public interface DragInitListener {

    /**
     * <p>
     * This method will be invoked when the listened dockable component triggered an event to start drag.
     * </p>
     *
     * @param event
     *        the input event to start drag
     * @param dockable
     *        the dockable component which is the source of the event
     * @throws IllegalArgumentException
     *         if any argument is null
     */
    public void dragInitialized(InputEvent event, Dockable dockable);
}
