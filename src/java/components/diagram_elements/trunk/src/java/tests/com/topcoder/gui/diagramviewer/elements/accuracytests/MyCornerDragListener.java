/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;

/**
 * Create a CornerDragListener class to obtain the SelectionBoundEvent for testing.
 *
 * @author Chenhong
 * @version 1.0
 */
public class MyCornerDragListener implements CornerDragListener {

    /**
     * Represents the SelectionBoundEvent instance for testing.
     */
    private SelectionBoundEvent event = null;

    /**
     * Store the SelectionBoundEvent instance.
     */
    public void cornerDragged(SelectionBoundEvent event) {
        this.event = event;
    }

    /**
     * Get the SelectionBoundEvent instance which is fired in SelectionCornerMouseListener#mouseDragged.
     *
     * @return The SelectionBoundEvent instance.
     */
    public SelectionBoundEvent getSelectionBoundEvent() {
        return event;
    }
}
