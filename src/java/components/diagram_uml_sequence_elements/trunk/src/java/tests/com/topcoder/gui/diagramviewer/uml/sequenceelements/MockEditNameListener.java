/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

/**
 * <p>
 * This is a mock implementation of EditNameListener interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class MockEditNameListener implements EditNameListener {
    /**
     * <p>
     * The flag denotes whether nameEditStarted(EditNameEvent) method is executed.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     *
     * @param event The instance of the EditNameEvent class.
     */
    public void nameEditStarted(EditNameEvent event) {
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
