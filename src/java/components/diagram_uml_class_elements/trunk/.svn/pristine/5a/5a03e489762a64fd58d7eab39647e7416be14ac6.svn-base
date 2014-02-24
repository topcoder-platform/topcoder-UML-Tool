/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.Util;
import com.topcoder.gui.panels.zoom.ZoomPane;

/**
 * <p>
 * This class can trigger edit box of diagram viewer when some component is double clicked. A TextField instance should
 * be given to this class to tell which text field should be edited.
 * </p>
 * <p>
 * For example, this trigger can be registered to a Class node, and the text field representing name compartment will be
 * associated with this trigger. As a result, when the Class node is clicked, the name compartment will be editable.
 * </p>
 * <p>
 * Note, the class is expected only be used in this component. No warranty is provided to use it outside this component.
 * </p>
 * <p>
 * This class is immutable and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxTrigger extends MouseAdapter {

    /**
     * <p>
     * Represents the text field which will be edited by the edit box.
     * </p>
     * <p>
     * It is initialized in constructor, and never changed later. Can not be null.
     * </p>
     * <p>
     * When this trigger is notified, the edit box of diagram viewer will be displayed on top of this text field, and
     * the text field will be hided. See #mouseClicked(MouseEvent)
     * </p>
     */
    private final TextField textField;

    /**
     * <p>
     * Creates an instance of <code>EditBoxTrigger</code>.
     * </p>
     * @param textField
     *            the text field to be edited
     * @throws IllegalArgumentException
     *             if textField is null
     */
    public EditBoxTrigger(TextField textField) {
        Util.checkNotNull(textField, "textField");
        this.textField = textField;
    }

    /**
     * <p>
     * Handles the MOUSE_CLICKED event.
     * </p>
     * @param e
     *            the mouse clicked event (null should be ignored)
     */
    public void mouseClicked(MouseEvent e) {
        if (e == null || e.getButton() != MouseEvent.BUTTON1 || e.getClickCount() != 2) {
            return;
        }
        textField.setVisible(false);
        Container view = (Container) e.getSource();

        // Get the diagram viewer
        while (view != null) {
            view = view.getParent();
            if (view instanceof DiagramView) {
                break;
            }
        }
        if (view == null) {
            return;
        }
        DiagramViewer viewer = ((DiagramView) view).getViewer();
        if (viewer == null) {
            return;
        }
        TextInputBox textInputBox = viewer.getTextInputBox();
        textInputBox.addTextInputListener(new EditBoxListener(textField));
        textInputBox.setText(textField.getText());
        // BugFix: UML-9998
        // set the size of TextInputBox
        textInputBox.setSize(textField.getPreferredSize());

        // Show the text input box
        /*
         * BugFix: UML-9706
         * To support adding elements when at different zoom levels, don't show the text input box
         * on the diagram view, but on the zoom pane, as the diagram view is invisible when zoomed.
         */
        // old code
//        textInputBox.show(textField.getParent(), textField.getX(), textField.getY());
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        Point pos = SwingUtilities.convertPoint(textField, 0, 0, view);
        int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
        int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
        textInputBox.show(zoomPane, x, y);

        // BugFix: UML-9998
        // Select old text
        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }
}
