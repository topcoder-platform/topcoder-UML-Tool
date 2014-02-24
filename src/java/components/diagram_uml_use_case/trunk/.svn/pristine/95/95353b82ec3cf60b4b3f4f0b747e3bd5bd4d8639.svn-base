/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

/**
 * <p>
 * This is a mock implementation of NodeAddEvent interface. It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockNodeAddListener implements NodeAddListener {
    /**
     * <p>
     * The flag denotes whether nodeAdd(NodeAddEvent) method is executed.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * The instance to hold the NodeAddEvent.
     * </p>
     */
    private NodeAddEvent nodeAddEvent;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     *
     * @param e The instance of the NodeAddEvent class.
     */
    public void nodeAdd(NodeAddEvent e) {
        isExecute = true;
        nodeAddEvent = e;
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
     * Return the instance of NodeAddEvent.
     * </p>
     *
     * @return the instance of NodeAddEvent
     */
    public NodeAddEvent getNodeAddEvent() {
        return nodeAddEvent;
    }
}
