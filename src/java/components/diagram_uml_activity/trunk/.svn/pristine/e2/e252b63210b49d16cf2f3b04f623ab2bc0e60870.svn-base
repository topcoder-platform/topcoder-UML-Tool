/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;

/**
 * <p>
 * Encapsulates the related information when changing a node's name, the Node property can be retrieved by getSource(),
 * and the GraphNode can be retrieved from the Node.
 * </p>
 * <p>
 * Thread safety: this class is immutable so is thread safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class TextChangedEvent extends EventObject {

    /**
     * <p>
     * Represents the old value of the node name. Initialized in the constructor and can not be null.
     * </p>
     */
    private final String oldValue;

    /**
     * <p>
     * Represents the new value of the node name. Initialized in the constructor and can not be null.
     * </p>
     */
    private final String newValue;

    /**
     * <p>
     * Creates a new instance with fields initialized using the given arguments.
     * </p>
     * @param source
     *            the TextField to be changed
     * @param oldValue
     *            the old name
     * @param newValue
     *            the new name
     * @throws IllegalArgumentException
     *             if source, oldValue or newValue is null
     */
    public TextChangedEvent(TextField source, String oldValue, String newValue) {
        super(source);
        if (oldValue == null) {
            throw new IllegalArgumentException("oldValue should not be null.");
        }
        if (newValue == null) {
            throw new IllegalArgumentException("newValue should not be null.");
        }
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * <p>
     * Gets the old value.
     * </p>
     * @return the old value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * <p>
     * Gets the new value.
     * </p>
     * @return the new value
     */
    public String getNewValue() {
        return newValue;
    }
}
