/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;

/**
 * <p>
 * This listener is used to listen to events from edit box in diagram viewer. It must be attached to a TextField. It
 * would fire a text change event when new text is entered, or display the original text if new text is cancelled.
 * </p>
 * <p>
 * This class is expected be used internally. It will be created in TextInputTrigger#mouseClicked method, and will be
 * registered to the text input control automatically.
 * </p>
 * <p>
 * Thread safety: this class is immutable, and thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class TextInputListener implements com.topcoder.gui.diagramviewer.event.TextInputListener {

    /**
     * <p>
     * Represents the text field for which the edit box is used. It will be used in event handling methods.
     * </p>
     * <p>
     * Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final TextField textField;

    /**
     * <p>
     * Creates an instance of <code>TextInputListener</code>.
     * </p>
     * @param textField
     *            the text field for which the edit box is used.
     * @throws IllegalArgumentException
     *             if the textField is null
     */
    public TextInputListener(TextField textField) {
        if (textField == null) {
            throw new IllegalArgumentException("textField should not be null.");
        }
        this.textField = textField;
    }

    /**
     * <p>
     * Handles text entered event.
     * </p>
     * @param event
     *            the text entered event, ignore null
     */
    public void textEntered(TextInputEvent event) {
        if (event == null) {
            return;
        }
        removeListener(event);
        textField.notifyTextChange(event.getText());
        textField.setVisible(true);
    }

    /**
     * <p>
     * Handles text cancelled event.
     * </p>
     * @param event
     *            the text cancelled event, ignore null
     */
    public void textCancelled(TextInputEvent event) {
        if (event == null) {
            return;
        }
        removeListener(event);
        textField.setVisible(true);
    }

    /**
     * <p>
     * Removes this listener from given event's source.
     * </p>
     * @param event
     *            the text cancelled event, will not be null
     */
    private void removeListener(TextInputEvent event) {
        if (!(event.getSource() instanceof TextInputBox)) {
            return;
        }
        TextInputBox source = (TextInputBox) event.getSource();
        source.removeTextInputListener(this);
    }
}
