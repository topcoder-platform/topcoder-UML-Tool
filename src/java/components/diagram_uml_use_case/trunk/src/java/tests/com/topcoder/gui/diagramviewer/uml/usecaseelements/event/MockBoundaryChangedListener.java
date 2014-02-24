/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

/**
 * <p>
 * This is a mock implementation of BoundaryChangedEvent interface. It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockBoundaryChangedListener implements BoundaryChangedListener {
    /**
     * <p>
     * The flag denotes whether boundaryChanged(BoundaryChangedEvent) method is executed.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * The instance to hold the BoundaryChangedEvent.
     * </p>
     */
    private BoundaryChangedEvent boundaryChangedEvent;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     *
     * @param e The instance of the BoundaryChangedEvent class.
     */
    public void boundaryChanged(BoundaryChangedEvent e) {
        isExecute = true;
        boundaryChangedEvent = e;
    }

    /**
     * <p>
     * Returns the state of isExecute.
     * </p>
     *
     * @return the state of isExecute.
     */
    public boolean getIsExecute() {
        return isExecute;
    }

    /**
     * <p>
     * Return the instance of BoundaryChangedEvent.
     * </p>
     *
     * @return the instance of BoundaryChangedEvent
     */
    public BoundaryChangedEvent getBoundaryChangedEvent() {
        return boundaryChangedEvent;
    }
}
