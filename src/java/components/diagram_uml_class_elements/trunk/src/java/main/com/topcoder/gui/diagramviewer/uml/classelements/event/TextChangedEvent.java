/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.Util;

/**
 * <p>
 * This is an event object used to indicate text of text field is changed. It contains three properties. They are the
 * TextField whose text is changed, the old text value, the new text value. Note, the TextField property can be
 * retrieved by getSource().
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class TextChangedEvent extends EventObject {

    /**
     * <p>
     * Represents the old text value.
     * </p>
     * <p>
     * Initialized in constructor, never changed later. Can't be null, and empty value is allowed.
     * </p>
     */
    private final String oldText;

    /**
     * <p>
     * Represents the new text value.
     * </p>
     * <p>
     * Initialized in constructor, never changed later. Can't be null, and empty value is allowed.
     * </p>
     */
    private final String newText;

    /**
     * <p>
     * Creates an instance of <code>TextChangedEvent</code>.
     * </p>
     * @param source
     *            the source of this event (a TextFiled instance)
     * @param oldText
     *            the old text value
     * @param newText
     *            the new text value
     * @throws IllegalArgumentException
     *             if source, oldText or newText is null
     */
    public TextChangedEvent(TextField source, String oldText, String newText) {
        super(source);

        Util.checkNotNull(oldText, "oldText");
        Util.checkNotNull(newText, "newText");
        this.oldText = oldText;
        this.newText = newText;
    }

    /**
     * <p>
     * Getter of oldText field.
     * </p>
     * @return the old text value
     */
    public String getOldText() {
        return oldText;
    }

    /**
     * <p>
     * Getter of newText field.
     * </p>
     * @return the new text value
     */
    public String getNewText() {
        return newText;
    }
}
