/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.panels.zoom.ZoomPane;

/**
 * This class can trigger text input control of diagram viewer when some component is double clicked. A TextField
 * instance should be given to this class to tell which text field should be edited.
 * <p>
 * For example, this trigger can be registered to an InitialNode, and the text field representing name compartment will
 * be associated with this trigger. As a result, when the InitialNode is clicked, the name compartment will be editable.
 * </p>
 * <p>
 * Note, the class is expected only be used in this component. No warranty is provided to use it outside this component.
 * </p>
 * <p>
 * This class is immutable and thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
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
        //BUGR-120 clear text for new edge
        if(textField.getText() != null && textField.getText().trim().length()> 0){
        	textInputBox.setText(textField.getText());
        }else{
        	textInputBox.clearText();
        }
        
        // BugFix: UML-9996
        // set the size of TextInputBox
        textInputBox.setSize(textField.getPreferredSize());
        /*
         * BugFix: UML-9709
         * To support adding elements when at different zoom levels, don't show the text input box
         * on the diagram view, but on the zoom pane, as the diagram view is invisible when zoomed.
         */
        // old code
//        /*
//         * BugFix: BUGID UML-7183
//         * Description:
//         * The text input box should be shown in the parent coordinate system, not diagram viewer.
//         * Solution:
//         * Code is modified to show the box in the parent coordinate system.
//         */
//        // old code
////        int x = textField.getX() + textField.getParent().getX();
////        int y = textField.getY() + textField.getParent().getY();
////        textInputBox.show(viewer, x, y);
//        textInputBox.show(textField.getParent(), textField.getX(), textField.getY());
        Container view = textField.getParent().getParent();
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        Point pos = SwingUtilities.convertPoint(textField, 0, 0, view);
        int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
        int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
        textInputBox.show(zoomPane, x, y);

        // BugFix: UML-9996
        // Select old text
        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }
}
