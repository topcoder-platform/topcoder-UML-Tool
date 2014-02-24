/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.BoundaryChangedListener;

/**
 * <p>
 * This is a mock implementation of BoundaryChangedEvent interface for testing.
 * </p>
 * 
 * @author radium
 * @version 1.0
 */
public class MockBoundaryChangeListenerAccuracy implements BoundaryChangedListener {

    /**
     * <p>
     * The BoundaryChangedEvent.
     * </p>
     */
    private BoundaryChangedEvent boundaryChangedEvent;

    /**
     * <p>
     * Constructs this listener with the given event.
     * </p>
     * 
     * @param e
     *            The instance of the BoundaryChangedEvent class.
     */
    public void boundaryChanged(BoundaryChangedEvent e) {
        isExecute = true;
        boundaryChangedEvent = e;
    }

    /**
     * <p>
     * The flag denotes whether it is excuted or not.
     * </p>
     */
    private boolean isExecute = false;

    /**
     * <p>
     * Returns the isExcute field.
     * </p>
     * 
     * @return the isExecute.
     */
    public boolean getIsExecute() {
        return isExecute;
    }

    /**
     * <p>
     * Return the BoundaryChangedEvent field.
     * </p>
     * 
     * @return the BoundaryChangedEvent.
     */
    public BoundaryChangedEvent getBoundaryChangedEvent() {
        return boundaryChangedEvent;
    }
}
