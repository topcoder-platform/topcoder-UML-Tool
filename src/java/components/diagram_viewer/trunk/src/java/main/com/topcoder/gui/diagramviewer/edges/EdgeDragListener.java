/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every edge drag event listener must follow.
 * </p>
 *
 * <p>
 * It contains the method to process the edge dragged event with the WayPointEvent given.
 * </p>
 *
 * <p>
 * Thread Safety : The implementations of this interface are not required to be thread safe.
 * It is expected to be used in a single thread.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface EdgeDragListener extends EventListener {
    /**
     * <p>
     * Process the edge dragged event.
     * </p>
     *
     * @param e a WayPointEvent instance used to indicate the edge drag event.
     */
    public void edgeDragged(WayPointEvent e);
}