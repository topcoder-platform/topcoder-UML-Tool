/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.Utils;

/**
 * <p>
 * This listener is used to listen to events from edit box in diagram viewer. It must be attached to a TextField. It
 * would fire a text change event when new text is entered, or display the original text if new text is canceled.
 * </p>
 * <p>
 * This class is expected be used internally. It will be created in EditBoxTrigger#mouseClicked method, and will be
 * registered to the edit box automatically.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 * <p>
 * BIG NOTE TO REVIEWER: This class implements EditBoxListener interface which is a mock, because the diagram viewer
 * component is not designed yet. Method parameters should be changed when it is designed.
 * </p>
 *
 * @author maone, TCSDEVELOPER
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
     * Constructor.
     * </p>
     *
     * @param textField the text field for which the edit box is used.
     * @throws IllegalArgumentException if any argument is null
     */
    public EditBoxListener(TextField textField) {
        Utils.checkNull(textField, "textField");
        this.textField = textField;
    }

    /**
     * <p>
     * Handle text entered event.
     * </p>
     * <p>
     * BIG NOTE: the parameter type should be changed due to diagram viewer.
     * </p>
     *
     * @param e the text entered event. (ignore null).
     */
    public void textEntered(TextInputEvent e) {
        if (e != null) {
            // remove it from the diagram viewer
            /*
             * BugFix: UML-7162
             */
            // old code
//            ((DiagramViewer) e.getSource()).removeEditBoxListener(this);
            removeListener(e);
            // notify text will be changed
            /*
             * BugFix: UML-7162
             */
            // old code
//            this.textField.notifyTextChange(e.getNewText());
            this.textField.notifyTextChange(e.getText());
            // reshow the text field
            this.textField.setVisible(true);
        }
    }

    /**
     * <p>
     * Handle text canceled event.
     * </p>
     * <p>
     * BIG NOTE: the parameter type should be changed due to diagram viewer.
     * </p>
     *
     * @param e the canceled event. (ignore null).
     */
    public void textCancelled(TextInputEvent e) {
        if (e != null) {
            // remove it from the diagram viewer
            /*
             * BugFix: UML-7162
             */
            // old code
//            ((DiagramViewer) e.getSource()).removeEditBoxListener(this);
            removeListener(e);
            // reshow the text field
            this.textField.setVisible(true);
        }
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
