/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.gui.diagramviewer.TextInputBox;

import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;


/**
 * <p>
 * This listener is used to listen to events from edit box in diagram viewer.
 * It must be attached to a <code>TextNode</code>.
 * It would fire a text change event when new text is entered,
 * Or display the original text if new text is canceled.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxListener implements TextInputListener {
    /**
     * <p>
     * Represents the text node which registers this listener to edit box.
     * It will be used in event handling methods.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be <code>null</code>.
     * </p>
     */
    private final TextNode textNode;

    /**
     * <p>
     * Constructs a TextNode. Set the textNode.
     * </p>
     *
     * @param textNode - the text node which registers this listener to edit box.
     *
     * @throws IllegalArgumentException - if any arg is null
     */
    public EditBoxListener(TextNode textNode) {
        // Checks whether the textNode is null,
        // if it is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(textNode, "textNode");

        // Assigns value.
        this.textNode = textNode;
    }

    /**
     * <p>
     * Handles text entered event.
     * </p>
     *
     * @param e - the text entered event.(null will be ignored)
     */
    public void textEntered(TextInputEvent e) {
        // removes this listener
        ((TextInputBox) e.getSource()).removeTextInputListener(this);

        // Constructs TextChangeEvent with appropriate args
        TextChangeEvent textChangeEvent =
            new TextChangeEvent(this.textNode, this.textNode.getText(), e.getText());

        // fires text change event.
        this.textNode.fireTextChange(textChangeEvent);

        // displays the text.
        this.textNode.setDisplayText(true);
    }

    /**
     * <p>
     * Handles text canceled event.
     * </p>
     *
     * @param e - the canceled event.(null will be ignored)
     */
    public void textCancelled(TextInputEvent e) {
        // removes this listener attached to the diagram viewer
        ((TextInputBox) e.getSource()).removeTextInputListener(this);

        // displays the origninal text
        this.textNode.setDisplayText(true);
    }
}
