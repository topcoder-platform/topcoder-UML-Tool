/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedListener;

/**
 * A dummy class extends the class: BoundaryChangedListener.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class DummyBoundaryChangedListener implements BoundaryChangedListener {

    /**
     * Represents the orignal rectangle.
     */
    private Rectangle oldBound;

    /**
     * Represents the new rectangle.
     */
    private Rectangle newBound;

    /**
     * Hanldes the event.
     * 
     * @param event the boundary change event
     */
    public void boundaryChanged(BoundaryChangedEvent event) {
        oldBound = event.getOldBoundary();
        newBound = event.getNewBoundary();
    }

    /**
     * Gets the original boundary.
     * 
     * @return the original boundary
     */
    public Rectangle getOldBoundary() {
        return oldBound;
    }

    /**
     * Gets the new boundary.
     * 
     * @return the new boundary
     */
    public Rectangle getNewBoundary() {
        return newBound;
    }
}
