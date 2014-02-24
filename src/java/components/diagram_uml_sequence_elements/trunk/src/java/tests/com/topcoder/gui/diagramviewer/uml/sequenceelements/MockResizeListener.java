/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

/**
 * <p>
 * This is a mock implementation of ResizeListener interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class MockResizeListener implements ResizeListener {
    /**
     * <p>
     * The flag denotes whether resizeNeeded(ResizeEvent) method is executed.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     *
     * @param event The instance of the ResizeEvent class.
     */
    public void resizeNeeded(ResizeEvent event) {
        isExecute = true;

    }
    /**
     * <p>
     * Returns the state of the isExecute.
     * </p>
     *
     * @return the state of the isExecute.
     */
    public boolean getIsExecute() {
        return isExecute;
    }
}
