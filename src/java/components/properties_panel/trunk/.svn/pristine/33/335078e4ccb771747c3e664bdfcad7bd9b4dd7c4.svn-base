/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class implements ModelElementChangeListener interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockModelElementChangeListener implements ModelElementChangeListener {
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
    public MockModelElementChangeListener() {
        // empty
    }

    /**
     * <p>
     * Implements the stateChanged(ModelElement,PropertyKind,PropertyOperation,Object) method.
     * </p>
     *
     * @param modelElement - the ModelElement whose properties were asked to be modified
     * @param property - the modified property name
     * @param op - the kind of operation to be done on the property
     * @param o - the Object that will be added/removed or modify the property
     */
    public void stateChanged(ModelElement modelElement, PropertyKind property, PropertyOperation op, Object o) {
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
