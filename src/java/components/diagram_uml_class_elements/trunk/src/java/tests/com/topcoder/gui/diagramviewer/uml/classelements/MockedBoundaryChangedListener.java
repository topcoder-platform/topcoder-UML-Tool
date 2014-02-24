/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedListener;

/**
 * <p>
 * Mocked BoundaryChangedListener class for testing.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockedBoundaryChangedListener implements BoundaryChangedListener {

    /**
     * Message of event.
     */
    private String message;

    /**
     * The old boundary before changing.
     */
    private Rectangle oldBound;

    /**
     * The new boundary after changing.
     */
    private Rectangle newBound;

    /**
     * <p>
     * Handles the boundary changed event. The event parameter could tell which node's bound is changed, and what is the
     * old bound and new bound.
     * </p>
     * @param event
     *            the boundary change event
     */
    public void boundaryChanged(BoundaryChangedEvent event) {
        oldBound = event.getOldBoundary();
        newBound = event.getNewBoundary();
        message = event.getMessage();
    }

    /**
     * Gets the old boundary.
     * @return the old boundary
     */
    public Rectangle getOldBound() {
        return oldBound;
    }

    /**
     * Gets the new boundary.
     * @return the new boundary
     */
    public Rectangle getNewBound() {
        return newBound;
    }

    /**
     * Gets the message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
