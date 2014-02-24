/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.mock;

import javax.swing.JToggleButton;

import com.topcoder.gui.toolbars.elements.ElementSelectedListener;
import com.topcoder.gui.toolbars.elements.SectionPanel;

/**
 * Mock for <code>ElementSelectedListener</code>. Used in test only.
 *
 * @author enefem21
 * @version 1.0
 */
public class MockElementSelectedListener implements ElementSelectedListener {

    /** Whether the listener has been executed or not. */
    private boolean isExecuted = false;

    /** How many times the listener is called. */
    private int numberOfExecution = 0;

    /**
     * <p>
     * The method to be called when an specified element is selected. In this mock, do nothing.
     * </p>
     *
     * @param sectionPanel
     *            the SectionPanel instance that the button is added into.
     * @param button
     *            the ToggleButton instance that is registered by this listener
     */
    public void elementSelected(JToggleButton button, SectionPanel sectionPanel) {
        isExecuted = true;
        numberOfExecution++;
    }

    /**
     * Checks if the listener has been executed.
     *
     * @return true, if the listener has been executed
     */
    public boolean isExecuted() {
        return isExecuted;
    }

    /**
     * Gets the number of execution.
     *
     * @return the number of execution
     */
    public int getNumberOfExecution() {
        return numberOfExecution;
    }

}
