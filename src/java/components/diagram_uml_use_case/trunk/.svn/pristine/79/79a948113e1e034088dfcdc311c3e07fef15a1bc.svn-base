/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.Utils;

import java.util.EventObject;

/**
 * <p>
 * This is an event object used to indicate text of text field is changed. It contains three properties. They are the
 * TextField whose text is changed, the old text value, the new text value. Note, the TextField property can be
 * retrieved by getSource().
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class TextChangeEvent extends EventObject {

    /**
     * Represents the old text value.
     * <p>
     * Initialized in constructor, never changed later. Can't be null, and empty value is allowed.
     * </p>
     */
    private final String oldText;

    /**
     * Represents the new text value.
     * <p>
     * Initialized in constructor, never changed later. Can't be null, and empty value is allowed.
     * </p>
     */
    private final String newText;

    /**
     * Construct a text change event.
     *
     * @param source the source of this event (a TextFiled instance).
     * @param oldText the old text value
     * @param newText the new text value.
     * @throws IllegalArgumentException if any argument is null (empty string is allowed).
     */
    public TextChangeEvent(TextField source, String oldText, String newText) {
        super(source);
        Utils.checkNull(oldText, "oldText");
        Utils.checkNull(newText, "newText");
        this.oldText = oldText;
        this.newText = newText;
    }

    /**
     * Getter of oldText field. See field document for explanation.
     *
     * @return the old text value.
     */
    public String getOldText() {
        return oldText;
    }

    /**
     * Getter of newText field. See field document for explanation.
     *
     * @return the new text value.
     */
    public String getNewText() {
        return newText;
    }
}
