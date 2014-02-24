/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.event.InputEvent;

/**
 * <p>
 * Mock implementation of <code>DragInitListener</code> interface.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * It is mutable and not thread-safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockDragInitListener implements DragInitListener {

    /**
     * <p>
     * If true, the dragInitialized is called.
     * </p>
     */
    private boolean draged = false;

    /**
     * <p>
     * Getter of draged.
     * </p>
     *
     * @return the draged flag
     */
    public boolean getDraged() {
        return draged;
    }

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
    public void dragInitialized(InputEvent event, Dockable dockable) {
        draged = true;
    }
}
