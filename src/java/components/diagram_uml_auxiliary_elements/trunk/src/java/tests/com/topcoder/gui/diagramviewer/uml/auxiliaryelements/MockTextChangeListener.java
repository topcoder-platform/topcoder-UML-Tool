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
class MockTextChangeListener implements TextChangeListener {
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
     * Handle the text change event.
     * The event parameter could tell which node's text is changed,
     * and what is the old text and new text value.
     * </p>
     *
     * @param e - the text change event (null should be ignored)
     */
    public void textChanged(TextChangeEvent e) {
        changed = true;
    }
}
