/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.panels.zoom.ZoomPane;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


/**
 * <p>
 * This is a default listener for events from <code>TextNode</code>.
 * It will be registered to <code>TextNode</code> in <code>TextNode</code>'s constructor.
 * When the text node is double clicked, this listener will ask the diagram viewer to display the text box.
 * And it will register a listener to listen to the text box.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
final class TextNodeMouseListener extends MouseAdapter {
    /**
     * <p>
     * Constructs a empty listener.
     * </p>
     */
    public TextNodeMouseListener() {
        // empty
    }

    /**
     * <p>
     * Handles the <code>MOUSE_CLICKED</code> event.
     * </p>
     *
     * @param e - the mouse clicked event.(null will be ignored)
     */
    public void mouseClicked(MouseEvent e) {
        // if it is not double clicked by left button
        if (e.getButton() != MouseEvent.BUTTON1 || e.getClickCount() != 2) {
            return;
        }

        // if e.getSource is not TextNode
        if (!(e.getSource() instanceof TextNode)) {
            return;
        }

        // hides text of e.getSource()
        TextNode textNode = (TextNode) e.getSource();
        textNode.setDisplayText(false);

        // Gets the DiagramViewer and the TextInputBox
        DiagramView view = (DiagramView) textNode.getParent();
        DiagramViewer viewer = view.getViewer();
        TextInputBox textInputBox = viewer.getTextInputBox();

        /*
         * BugFix: UML-9708
         * To support adding elements when at different zoom levels, don't show the text input box
         * on the diagram view, but on the zoom pane, as the diagram view is invisible when zoomed.
         */
        // old code
//        // translates the point to the coordinate of diagram viewer
//        Point point = SwingUtilities.convertPoint(textNode, textNode.getX(), textNode.getY(), viewer);
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        Point point = SwingUtilities.convertPoint(textNode, 0, 0, view);
        int x = (int) Math.round((view.getX() + point.x) * zoomFactor);
        int y = (int) Math.round((view.getY() + point.y) * zoomFactor);

        // creates an event with position, old text, and pass to the diagram viewer
        textInputBox.setText(textNode.getText());
        textInputBox.setSize(textNode.getSize());

        /* 
         * BugFix: BUGR-69/70
         * Use of Ctrl+Enter should be enabled.
         */
        textInputBox.setNewLineAccepted(true);

        /*
         * BugFix: UML-9708
         * To support adding elements when at different zoom levels, don't show the text input box
         * on the diagram view, but on the zoom pane, as the diagram view is invisible when zoomed.
         */
        // old code
//        textInputBox.show(viewer, point.x, point.y);
        textInputBox.show(zoomPane, x, y);

        // creates a event listener to listen the event.
        textInputBox.addTextInputListener(new EditBoxListener(textNode));

        // BugFix: UML-9997
        // Select old text
        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }
}
