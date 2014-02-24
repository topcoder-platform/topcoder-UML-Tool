/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeListener;

/**
 * <p>
 * Accuracy test of <code>BoundaryChangeListener</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class MockBoundaryChangeListener implements BoundaryChangeListener {

    /**
     * public integer to record the number of changes.
     */
    public int flag;

    /**
     * constructor.
     */
    public MockBoundaryChangeListener() {
        flag = 0;
    }

    /**
     * Each time boundary changed, the flag is increased by one. 
     */
    public void boundaryChanged(BoundaryChangeEvent e) {
        flag++;
    }
}
