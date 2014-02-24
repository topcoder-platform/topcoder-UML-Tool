/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class implements ModelElementSelectionListener interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockModelElementSelectionListener implements ModelElementSelectionListener {
    /**
     * <p>
     * Represents the method is executed or not.
     * </P>
     */
    private boolean isExecuted = false;

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public MockModelElementSelectionListener() {
        // empty
    }

    /**
     * <p>
     * Implements the selectionChanged(ModelElement) method.
     * </p>
     *
     * @param modelElement the newly selected ModelElement
     */
    public void selectionChanged(ModelElement modelElement) {
        isExecuted = true;

    }

    /**
     * <p>
     * Returns the state of isExecuted for testing.
     * </p>
     *
     * @return the state of isExecuted for testing
     */
    public boolean getIsExecuted() {
        return isExecuted;
    }
}
