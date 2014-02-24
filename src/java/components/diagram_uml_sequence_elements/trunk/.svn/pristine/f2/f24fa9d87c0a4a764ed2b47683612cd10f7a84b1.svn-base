/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.util.EventObject;

/**
 * <p>
 * This is an event object used to indicate text of text field is changed. It contains three properties. They are the
 * TextField whose text is changed, the old text value, the new text value. Note, the TextField property can be
 * retrieved by getSource().
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.1
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
     * @param source the TextField to be changed
     * @param oldValue the old name
     * @param newValue the new name
     * @throws IllegalArgumentException if source, oldValue or newValue is null
     */
    public TextChangedEvent(TextField source, String oldValue, String newValue) {
        super(source);
        Util.checkNull(oldValue, "oldValue");
        Util.checkNull(newValue, "newValue");

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
