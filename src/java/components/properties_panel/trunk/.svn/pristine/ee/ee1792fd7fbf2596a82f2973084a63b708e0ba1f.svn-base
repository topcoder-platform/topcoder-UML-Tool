/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import com.topcoder.gui.panels.properties.ModelElementSelectionListener;
import com.topcoder.uml.model.core.ModelElement;

/**
 * This mock class is used in the test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ModelElementSelectionListenerMock implements ModelElementSelectionListener {
    /**
     * <p>
     * Represents the method is executed or not.
     * </P>
     */
    boolean flag = false;

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public ModelElementSelectionListenerMock() {
        // empty
    }

    /**
     * <p>
     * Invoked when a different ModelElement is selected due to action
     * within the Properties Panel component.
     * </p>
     *
     * @param modelElement the newly selected ModelElement
     */
    public void selectionChanged(ModelElement modelElement) {
        flag = true;

    }

    /**
     * <p>
     * Returns the flag for testing.
     * </p>
     *
     * @return the flag for testing
     */
    public boolean IsCalled() {
        return flag;
    }
}
