/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.accuracytests;

import com.topcoder.gui.panels.properties.ModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.uml.model.core.ModelElement;

/**
 * This mock class is used in the test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ModelElementChangeListenerMock implements ModelElementChangeListener {
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
    public ModelElementChangeListenerMock() {
        // empty
    }

    /**
     * <p>
     * Executes the logic that occurs when a property value corresponding to this property panel is changed.
     * </p>
     *
     * @param modelElement the ModelElement whose properties were asked to be modified
     * @param kind the modified property name
     * @param operation the kind of operation to be done on the property
     * @param object the Object that will be added/removed or modify the property (depending on PropertyOperation type)
     */
    public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation, Object object) {
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
