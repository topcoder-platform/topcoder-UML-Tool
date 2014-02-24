/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Point;

import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddListener;

/**
 * <p>
 * Mocked BoundaryChangedListener class for testing.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockedNodeAddListener implements NodeAddListener {

    /**
     * Represents the location where the new node will be added. Initialized in constructor, never changed later. Can't
     * be null.
     */
    private Point location;

    /**
     * Gets the location.
     * @return the location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * <p>
     * Processes node add event.
     * </p>
     * @param e
     *            a NodeAddEvent
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void nodeAdd(NodeAddEvent e) {
        location = e.getLocation();
    }
}
