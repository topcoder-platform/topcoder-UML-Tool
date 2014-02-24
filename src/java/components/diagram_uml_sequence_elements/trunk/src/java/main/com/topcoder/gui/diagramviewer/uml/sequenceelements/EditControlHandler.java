/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;
import com.topcoder.gui.diagramviewer.DiagramViewer;

/**
 * <p>
 * The concrete implementation of the TextInputListener interface. This class is registered to
 * listen to the <code>textEntered</code> action on the name of the node.
 * </p>
 *
 * <p>
 * The TextInputBox component implements this action.
 * </p>
 *
 * <p>
 * The current class will implement required actions on the end of name editing.
 * </p>
 *
 * <p>
 * Change for v1.1: Because the EditControlEvent,EditControlListener and the related methods in
 * DiagramViewer do not exist in Diagram Viewer 1.0, EditControlHandler implements the
 * TextInputListener (EditControlListener in v1.0)interface instead.
 * </p>
 *
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 *
 *
 * @author MiG-29, TCSDEVELOPER
 * @author gniuxiao, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class EditControlHandler implements TextInputListener {
    /**
     * <p>
     * Represents the instance of the ObjectNode.
     * </p>
     *
     * <p>
     * The value is set in the constructor and is immutable. It can never be null.
     * </p>
     *
     * <p>
     * The related getter function returns the current value of the variable.
     * </p>
     */
    private final ObjectNode node;

    /**
     * <p>
     * Constructs the class and set related class variable by using the argument.
     * </p>
     *
     *
     * @param node The instance of the ObjectNode class.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public EditControlHandler(ObjectNode node) {
        Util.checkNull(node, "node");

        this.node = node;
    }

    /**
     * <p>
     * Gets the object node in this edit control handler.
     * </p>
     *
     * @return the object node in this edit control handler.
     */
    public ObjectNode getNode() {
        return this.node;
    }

    /**
     * <p>
     * This method is invoked when the text in the TextInputBox is cancelled. The event tells the
     * text in the TextInputBox.This method only check the parameter and does nothing else.
     * </p>
     *
     * @param event The instance of the TextInputEvent class
     *
     * @throws IllegalArgumentException if argument is null
     *
     * @since 1.1
     */
    public void textCancelled(TextInputEvent event) {
        Util.checkNull(event, "event");
        // do nothing
    }

    /**
     * <p>
     * This method is invoked when the text is entered into the TextInputBox. The event tells the
     * text entered in the TextInputBox.This method implement the required action on the end of name
     * editing
     * </p>
     *
     * @param event The instance of the TextInputEvent class
     *
     * @throws IllegalArgumentException if argument is null
     *
     * @since 1.1
     */
    public void textEntered(TextInputEvent event) {
        Util.checkNull(event, "event");

        // notify the name has been changed
        node.applyNewName(node.getName(), event.getText());

        // remove it from the TextInputBox
        TextInputBox inputbox = (TextInputBox) event.getSource();
        if (inputbox != null) {
            inputbox.removeTextInputListener(this);
        }

        // remove the TextInputBox from the DiagramViewer
        DiagramViewer diagview = (DiagramViewer) node.getParent();
        if (diagview != null) {
            diagview.remove(inputbox);
        }
    }
}
