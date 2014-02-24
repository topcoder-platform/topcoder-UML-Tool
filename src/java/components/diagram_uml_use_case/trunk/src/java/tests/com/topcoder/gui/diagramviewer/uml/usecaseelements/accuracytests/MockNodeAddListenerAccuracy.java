/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.accuracytests;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.NodeAddListener;

/**
 * This is Mock NodeAddListener for testing.
 * @author radium
 * @version 1.0
 */
public class MockNodeAddListenerAccuracy implements NodeAddListener {
    /**
     * Denotes whether it is excuted.
     */
    private boolean isExcuted = false;

    /**
     * Return the isExcuted field.
     *
     * @return isExcuted.
     */
    public boolean getIsExcuted() {
        return isExcuted;
    }

    /**
     * Change the isExcuted Field.
     */
    public void nodeAdd(NodeAddEvent e) {
        this.isExcuted = true;

    }

}
