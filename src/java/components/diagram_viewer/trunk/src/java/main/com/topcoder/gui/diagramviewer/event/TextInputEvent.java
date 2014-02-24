/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventObject;

import com.topcoder.gui.diagramviewer.DVHelper;
import com.topcoder.gui.diagramviewer.TextInputBox;

/**
 * <p>
 * An event which indicates that a TextInputBox has finished or cancelled its
 * text input process. It contains only one property which is the text inputted
 * in the TextInputBox.
 * </p>
 * <p>
 * Thread safety: this class is immutable and thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class TextInputEvent extends EventObject {

    /**
     * <p>
     * Represents the text inputted in the TextInputBox.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null but can be
     * empty. Can be accessed by getter.
     * </p>
     */
    private final String text;

    /**
     * <p>
     * Constructor. Simply assign the arguments to corresponding fields.
     * </p>
     *
     * @param text the text inputted in the TextInputBox
     * @param source the TextInputBox where this event occurs
     * @throws IllegalArgumentException if any arg is null
     */
    public TextInputEvent(TextInputBox source, String text) {
        super(source);
        DVHelper.validateNotNull(text, "text");
        this.text = text;
    }

    /**
     * <p>
     * Getter of the text, see field doc for explanation.
     * </p>
     *
     * @return the text inputted in TextInputBox
     */
    public String getText() {
        return text;
    }
}
