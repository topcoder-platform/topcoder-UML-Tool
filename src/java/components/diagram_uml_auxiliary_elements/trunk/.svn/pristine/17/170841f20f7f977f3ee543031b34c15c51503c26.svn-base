/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.util.EventObject;


/**
 * <p>
 * This is an event object used to indicate text of text node is changed.
 * It contains three properties.
 * They are the Node whose text is changed, the old text value, the new text value.
 * Note, the Node property can be retrieved by <code>getSource()</code>.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class TextChangeEvent extends EventObject {
    /**
     * <p>
     * Represents the old value before the text is changed.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be <code>null</code>.
     * </p>
     */
    private final String oldText;

    /**
     * <p>
     * Represents the new value after the text is changed.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be <code>null</code>.
     * </p>
     */
    private final String newText;

    /**
     * <p>
     * Constructs a TextChangeEvent. Set the oldText and the newText.
     * </p>
     *
     * @param source - the source of this event
     * @param oldText - the old text value
     * @param newText - the new text value.
     *
     * @throws IllegalArgumentException - if any arg is null (empty string is allowed here)
     */
    public TextChangeEvent(TextNode source, String oldText, String newText) {
        // Passes source to super constructor.
        // the super constructor will check whether the source is null,
        // and if the source is null, a IAE will be thrown.
        super(source);

        // Checks whether the oldText and the newText is null,
        // if any one is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(oldText, "oldText");
        AuxiliaryElementsHelper.checkNotNull(newText, "newText");

        // Assigns values.
        this.oldText = oldText;
        this.newText = newText;
    }

    /**
     * <p>
     * Gets the oldText field. See field doc for explanation.
     * </p>
     *
     * @return the old text value.
     */
    public String getOldText() {
        return this.oldText;
    }

    /**
     * <p>
     * Gets the newText field. See field doc for explanation.
     * </p>
     *
     * @return the new text value.
     */
    public String getNewText() {
        return this.newText;
    }
}
