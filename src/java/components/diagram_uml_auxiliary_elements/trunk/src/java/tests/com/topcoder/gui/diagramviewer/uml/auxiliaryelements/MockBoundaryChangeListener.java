/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;


/**
 * <p>
 * Mock class for test.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
class MockBoundaryChangeListener implements BoundaryChangeListener {
    /**
     * <p>
     * If true, the boundaryChanged is called.
     * </p>
     */
    private boolean changed = false;

    /**
     * <p>
     * Getter of changed.
     * </p>
     *
     * @return the changed flag
     */
    public boolean getChanged() {
        return this.changed;
    }

    /**
     * <p>
     * Handle the bound changed event.
     * The event parameter could tell which node's bound is changed, and what is the old bound and new bound.
     * </p>
     *
     * @param e - the bound change event (null should be ignored)
     */
    public void boundaryChanged(BoundaryChangeEvent e) {
        changed = true;
    }
}
