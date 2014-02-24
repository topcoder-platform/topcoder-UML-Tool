/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.elements.NodeDragListener;

/**
 * Create a NodeDragListener class to obtain the LocationEvent for testing.
 * @author Chenhong
 * @version 1.0
 *
 */
public class MyNodeDragListener implements NodeDragListener {

    /**
     * Represents the LocationEvent fired.
     */
    private LocationEvent locationEvent = null;

    /**
     * Obtain the LocationEvent instance.
     */
    public void nodeDragged(LocationEvent event) {
        System.out.println("Invoke MyNodDragListner class.");
        this.locationEvent = event;
    }

    /**
     * Get the locationEvent for testing.
     * @return LocationEvent instance.
     */
    public LocationEvent getEvent() {
        return this.locationEvent;
    }

}
