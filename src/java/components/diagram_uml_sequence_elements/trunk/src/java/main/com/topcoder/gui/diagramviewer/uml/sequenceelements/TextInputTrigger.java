/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.panels.zoom.ZoomPane;

// added
/**
 * This class can trigger text input control of diagram viewer when some component is double clicked. A TextField
 * instance should be given to this class to tell which text field should be edited.
 * <p>
 * For example, this trigger can be registered to an edge, and the text field representing name compartment will
 * be associated with this trigger. As a result, when the text is clicked, the name compartment will be editable.
 * </p>
 * <p>
 * Note, the class is expected only be used in this component. No warranty is provided to use it outside this component.
 * </p>
 * <p>
 * This class is immutable and thread-safe.
 * </p>
 * @author ly, TCSDEVELOPER
 * @version 1.0
 */
public class TextInputTrigger extends MouseAdapter {

    /**
     * <p>
     * Represents the text field which will be edited by the edit box. It is initialized in constructor, and never
     * changed later. When this trigger is notified, the text input control of diagram viewer will be displayed on top
     * of this text field, and the text field will be hidden.
     * </p>
     */
    private final TextField textField;

    /**
     * <p>
     * Creates an instance of <code>TextInputTrigger</code>.
     * </p>
     * @param textField
     *            the text field to be edited
     * @throws IllegalArgumentException
     *             if the textField is null
     */
    public TextInputTrigger(TextField textField) {
        if (textField == null) {
            throw new IllegalArgumentException("textField should not be null.");
        }
        this.textField = textField;
    }

    /**
     * <p>
     * Handles the mouse click event.
     * </p>
     * @param event
     *            the mouse clicked event. (null should be ignored).
     */
    public void mouseClicked(MouseEvent event) {
        if (event == null || event.getButton() != MouseEvent.BUTTON1 || event.getClickCount() != 2) {
            return;
        }
        textField.setVisible(false);
        JComponent viewer = (JComponent) event.getSource();

        while (viewer != null) {
            viewer = (JComponent) viewer.getParent();
            if (viewer instanceof DiagramViewer) {
                break;
            }
        }
        if (viewer == null) {
            return;
        }
        TextInputBox textInputBox = ((DiagramViewer) viewer).getTextInputBox();
        textInputBox.addTextInputListener(new TextInputListener(textField));
        textInputBox.setText(textField.getText());

        textInputBox.setSize(textField.getPreferredSize());

        Container view = textField.getParent().getParent();

        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();

        Point pos = SwingUtilities.convertPoint(textField, 0, 0, view);
        textInputBox.show(zoomPane, (int) Math.round((view.getX() + pos.x) * zoomFactor), (int) Math.round((view.getY() + pos.y) * zoomFactor));

        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }
}
