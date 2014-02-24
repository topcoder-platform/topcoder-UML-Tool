/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddListener;
/**
 * This is the MockEdgeAddLisener for testing.
 * @author radium
 * @version 1.0
 */
public class MockEdgeAddListenerAccuracy implements EdgeAddListener {
    /**
     * Denotes whether it is excuted.
     */
    private boolean isExcuted = false;

    /**
     * Get the isExcuted field.
     *
     * @return isExcuted field.
     */
    public boolean getIsExcuted() {
        return this.isExcuted;
    }

    /**
     * Change isExcuted field.
     */
    public void edgeAdd(EdgeAddEvent e) {
        this.isExcuted = true;
    }
}
