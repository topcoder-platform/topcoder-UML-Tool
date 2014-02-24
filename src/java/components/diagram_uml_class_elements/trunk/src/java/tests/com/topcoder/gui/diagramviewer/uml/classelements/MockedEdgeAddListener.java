/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddListener;

/**
 * <p>
 * Mocked BoundaryChangedListener class for testing.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockedEdgeAddListener implements EdgeAddListener {

    /**
     * Represents the location where the edge ending should be added.
     */
    private Point location;

    /**
     * Represents a flag indicating whether the ending is a start or an end of edge.
     */
    private boolean isStart;

    /**
     * Gets the location.
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Gets whether is start.
     * @return whether is start
     */
    public boolean isStart() {
        return isStart;
    }

    /**
     * <p>
     * Processes edgeAdd event.
     * </p>
     * @param e
     *            a EdgeAddEvent
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void edgeAdd(EdgeAddEvent e) {
        location = e.getLocation();
        isStart = e.isStart();
    }
}
