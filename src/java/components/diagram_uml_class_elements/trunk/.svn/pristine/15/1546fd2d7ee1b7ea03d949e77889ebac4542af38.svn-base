/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.Util;

/**
 * <p>
 * This listener is used to listen to events from edit box in diagram viewer. It must be attached to a TextField. It
 * would fire a text change event when new text is entered, or display the original text if new text is cancelled.
 * </p>
 * <p>
 * This class is expected be used internally. It will be created in EditBoxTrigger#mouseClicked method, and will be
 * registered to the edit box automatically.
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxListener implements TextInputListener {

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
     * Creates an instance of <code>EditBoxListener</code>.
     * </p>
     * @param textField
     *            the text field for which the edit box is used
     * @throws IllegalArgumentException
     *             if given textField is null
     */
    public EditBoxListener(TextField textField) {
        Util.checkNotNull(textField, "textField");
        this.textField = textField;
    }

    /**
     * <p>
     * Handles text entered event.
     * </p>
     * @param e
     *            the text entered event(ignore null)
     */
    public void textEntered(TextInputEvent e) {
        if (e == null) {
            return;
        }
        removeListener(e);
        textField.notifyTextChange(e.getText());
        textField.setVisible(true);
    }

    /**
     * <p>
     * Handles text cancelled event.
     * </p>
     * @param e
     *            the cancelled event(ignore null)
     */
    public void textCancelled(TextInputEvent e) {
        if (e == null) {
            return;
        }
        removeListener(e);
        textField.setVisible(true);
    }

    /**
     * <p>
     * Removes this listener from given event's source.
     * </p>
     * @param event
     *            the text input event, will not be null
     */
    private void removeListener(TextInputEvent event) {
        if (!(event.getSource() instanceof TextInputBox)) {
            return;
        }
        TextInputBox source = (TextInputBox) event.getSource();
        source.removeTextInputListener(this);
    }
}
