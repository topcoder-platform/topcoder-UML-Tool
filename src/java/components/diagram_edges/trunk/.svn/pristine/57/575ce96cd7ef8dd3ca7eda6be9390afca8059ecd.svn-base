/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import com.topcoder.gui.diagramviewer.edges.EdgeDragListener;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;

/**
 * This is a mock implementation of <code>EdgeDragListener</code> interface.
 *
 * @author vividmxx
 * @version 1.0
 */
public class MockEdgeDragListener implements EdgeDragListener {

    /**
     * Represents the last way point event sent to this listener.
     */
    private WayPointEvent event;

    /**
     * The default constructor.
     */
    public MockEdgeDragListener() {
    }

    /**
     * Implements the method defined in <code>EdgeDragListener</code> interface. Simply sets the argument to event
     * field.
     *
     * @param event
     *            the way point event
     */
    public void edgeDragged(WayPointEvent event) {
        this.event = event;
    }

    /**
     * Gets the last way point event sent to this listener.
     *
     * @return the last way point event sent to this listener
     */
    public WayPointEvent getLastEvent() {
        return event;
    }
}
