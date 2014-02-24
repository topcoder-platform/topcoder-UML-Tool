/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.gui.diagramviewer.edges.WayPointListener;

/**
 * This is a mock implementation of <code>WayPointListener</code> interface.
 *
 * @author vividmxx
 * @version 1.0
 */
public class MockWayPointListener implements WayPointListener {

    /**
     * Represents the last way point event sent to this listener.
     */
    private WayPointEvent event;

    /**
     * The default constructor.
     */
    public MockWayPointListener() {
    }

    /**
     * Implements the method defined in <code>WayPointListener</code> interface. Simply sets the argument to event
     * field.
     *
     * @param event
     *            the way point event
     */
    public void wayPointDragged(WayPointEvent event) {
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