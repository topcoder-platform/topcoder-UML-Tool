/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

/**
 * Represents the mock <code>NodeDragListener</code> class used for test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockNodeDragListener implements NodeDragListener {

    /**
     * Represents the flag indicating whether this listener is fired.
     */
    private boolean isFired = false;

    /**
     * The default constructor.
     */
    public MockNodeDragListener() {
    }

    /**
     * Fires the listener.
     *
     * @param event
     *            ignore
     */
    public void nodeDragged(LocationEvent event) {
        isFired = true;
    }

    /**
     * Gets the flag indicating whether this listener is fired.
     *
     * @return the flag indicating whether this listener is fired
     */
    public boolean isFired() {
        return isFired;
    }
}
