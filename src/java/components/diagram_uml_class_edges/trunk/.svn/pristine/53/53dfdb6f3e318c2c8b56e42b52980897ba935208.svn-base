/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.Utils;

import java.util.EventObject;

/**
 * <p>
 * This is an event object used to indicate text of text field is changed. It contains three properties. They are the
 * <code>TextField</code> whose text is changed, the old text value, the new text value.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable, and thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class TextChangeEvent extends EventObject {

    /**
     * <p>
     * Represents the old text value.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be null, and empty value is allowed.
     * </p>
     */
    private final String oldText;

    /**
     * <p>
     * Represents the new text value.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be null, and empty value is allowed.
     * </p>
     */
    private final String newText;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param source
     *            the source of this event (a TextFiled instance).
     * @param oldText
     *            the old text value
     * @param newText
     *            the new text value.
     *
     * @throws IllegalArgumentException
     *             if any argument is null (empty string is allowed).
     */
    public TextChangeEvent(TextField source, String oldText, String newText) {
        super(source);

        Utils.checkObjectNotNull(oldText, "oldText");
        Utils.checkObjectNotNull(newText, "newText");
        this.oldText = oldText;
        this.newText = newText;
    }

    /**
     * <p>
     * Getter of oldText field.
     * </p>
     *
     * @return the old text value.
     */
    public String getOldText() {
        return this.oldText;
    }

    /**
     * <p>
     * Getter of newText field.
     * </p>
     *
     * @return the new text value.
     */
    public String getNewText() {
        return this.newText;
    }
}
