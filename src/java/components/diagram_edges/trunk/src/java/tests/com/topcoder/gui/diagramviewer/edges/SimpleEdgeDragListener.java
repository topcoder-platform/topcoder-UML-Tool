/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

/**
 * <p>
 * This class implements EdgeDragListener interface and is used for testing purpose.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SimpleEdgeDragListener implements EdgeDragListener {
    /**
     * <p>
     * Represent the last way point event sent to this listener.
     * </p>
     */
    private WayPointEvent event;

    /**
     * <p>
     * Save the coming way point event for testing purpose.
     * </p>
     *
     * @param event the way point event
     */
    public void edgeDragged(WayPointEvent event) {
        this.event = event;
    }

    /**
     * <p>
     * Get the last way point event sent to this listener.
     * </p>
     *
     * @return the last way point event sent to this listener.
     */
    public WayPointEvent getLastEvent() {
        return event;
    }
}
