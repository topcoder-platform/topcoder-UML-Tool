/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.Utils;

/**
 * <p>
 * This listener is used to listen to events from text input box in diagram viewer. It must be attached to a
 * <code>TextField</code>. It would fire a text change event when new text is entered, or display the original text
 * if new text is cancelled.
 * </p>
 *
 * <p>
 * This class is expected be used internally. It will be created in EditBoxTrigger#mouseClicked method, and will be
 * registered to the edit box automatically.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable, and thread-safe.
 * </p>
 *
 * <p>
 * <b>Changes:</b> this class has renamed from <tt>EditBoxListener</tt> to <tt>TextInputListener</tt>, and rewritten.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class TextInputListener implements com.topcoder.gui.diagramviewer.event.TextInputListener {

    /**
     * <p>
     * Represents the text field for which the edit box is used. It will be used in event handling methods.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final TextField textField;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param textField
     *            the text field for which the edit box is used.
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public TextInputListener(TextField textField) {
        Utils.checkObjectNotNull(textField, "textField");
        this.textField = textField;
    }

    /**
     * <p>
     * Invoked when the text is entered into the <code>TextInputBox</code>.
     * </p>
     *
     * @param event the text input event
     */
    public void textEntered(TextInputEvent event) {
        if (event == null) {
            return;
        }

        //Remove it from the TextInputBox
        ((TextInputBox) event.getSource()).removeTextInputListener(this);

        //Notify text will be changed
        textField.notifyTextChange(event.getText());

        //Re-show the text field
        textField.setVisible(true);
    }

    /**
     * <p>
     * Invoked when the text in the <code>TextInputBox</code> is cancelled.
     * </p>
     *
     * @param event the text input event
     */
    public void textCancelled(TextInputEvent event) {
        if (event == null) {
            return;
        }

        //Remove it from the TextInputBox
        ((TextInputBox) event.getSource()).removeTextInputListener(this);

        //Re-show the text field
        textField.setVisible(true);
    }
}
