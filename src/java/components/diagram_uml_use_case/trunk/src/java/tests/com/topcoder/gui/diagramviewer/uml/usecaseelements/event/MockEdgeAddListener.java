/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

/**
 * <p>
 * This is a mock implementation of EdgeAddEvent interface. It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockEdgeAddListener implements EdgeAddListener {
    /**
     * <p>
     * The flag denotes whether edgeAdd(EdgeAddEvent) method is executed.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * The instance to hold the EdgeAddEvent.
     * </p>
     */
    private EdgeAddEvent edgeAddEvent;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     *
     * @param e The instance of the EdgeAddEvent class.
     */
    public void edgeAdd(EdgeAddEvent e) {
        isExecute = true;
        edgeAddEvent = e;
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
     * Return the instance of EdgeAddEvent.
     * </p>
     *
     * @return the instance of EdgeAddEvent
     */
    public EdgeAddEvent getEdgeAddEvent() {
        return edgeAddEvent;
    }
}
