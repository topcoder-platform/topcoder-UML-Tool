/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

/**
 * Represents the mock <code>CornerDragListener</code> class used for test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockCornerDragListener implements CornerDragListener {

    /**
     * Represents the flag indicating whether this listener is fired.
     */
    private boolean isFired = false;

    /**
     * The default constructor.
     */
    public MockCornerDragListener() {
    }

    /**
     * Fires the listener.
     *
     * @param event
     *            ignore
     */
    public void cornerDragged(SelectionBoundEvent event) {
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
