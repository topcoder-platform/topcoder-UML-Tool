/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;

// added
/**
 * <p>
 * This listener is used to listen to events from edit box in diagram viewer. It will be attached to a TextField or an
 * ObjectNode. It would fire a text change event when new text is entered, or display the original text if new text is
 * cancelled.
 * </p>
 * <p>
 * This class is expected be used internally. It will be created in TextInputTrigger#mouseClicked method and ObjectNode
 * #processMouseEvent method, and will be registered to the text input control automatically.
 * </p>
 * <p>
 * Thread safety: this class is immutable, and thread-safe.
 * </p>
 * @author ly, TCSDEVELOPER
 * @version 1.0
 */
public class TextInputListener implements com.topcoder.gui.diagramviewer.event.TextInputListener {

    /**
     * <p>
     * Represents the component for which the edit box is used. It will be used in event handling methods.
     * It will be ObjectNode or TextField in this component.
     * </p>
     * <p>
     * Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final JComponent component;

    /**
     * <p>
     * Creates an instance of <code>TextInputListener</code>.
     * </p>
     * @param component
     *            the component for which the edit box is used.
     * @throws IllegalArgumentException
     *             if the component is null
     */
    public TextInputListener(JComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("component should not be null.");
        }
        this.component = component;
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
        if (component instanceof ObjectNode) {
            ObjectNode node = (ObjectNode) component;
            node.applyNewName(node.getName(), event.getText());
            node.setNameEditedNow(false);
        } else if (component instanceof TextField) {
            TextField textField = (TextField) component;
            textField.notifyTextChange(event.getText());
            textField.setVisible(true);
        }
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
        if (component instanceof ObjectNode) {
            ((ObjectNode)component).setNameEditedNow(false);
        } else if (component instanceof TextField) {
            component.setVisible(true);
        }
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
