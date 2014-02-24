/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.Utils;
import com.topcoder.gui.panels.zoom.ZoomPane;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * <p>
 * This class can trigger text input box of diagram viewer when some component is double clicked. A
 * <code>TextField</code> instance should be given to this class to tell which text field should be edited.
 * </p>
 *
 * <p>
 * For example, this trigger can be registered to a dependency node, and the text field representing name compartment
 * will be associated with this trigger. As a result, when the dependency node is clicked, the name compartment will be
 * editable.
 * </p>
 *
 * <p>
 * Note, the class is expected only be used in this component. No warranty is provided to use it outside this component.
 * </p>
 *
 * <p>
 * <b>Changes:</b> this class has renamed from <tt>EditBoxTrigger</tt> to <tt>TextInputTrigger</tt>, and rewritten.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread-safe.
 * </p>
 *
 * @author MiG-29, littlebull
 * @version 1.0
 */
public class TextInputTrigger extends MouseAdapter {

    /**
     * <p>
     * Represents the text field which will be edited by the edit box.
     * </p>
     *
     * <p>
     * It is initialized in constructor, and never changed later. It can not be null. When this trigger is notified, the
     * edit box of diagram viewer will be displayed on top of this text field, and the text field will be hidden.
     * </p>
     */
    private final TextField textField;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param textField
     *            the text field to be edited
     *
     * @throws IllegalArgumentException
     *             if the argument is null.
     */
    public TextInputTrigger(TextField textField) {
        Utils.checkObjectNotNull(textField, "textField");
        this.textField = textField;
    }

    /**
     * <p>
     * Handle the double left <tt>MOUSE_CLICKED</tt> event.
     * </p>
     *
     * @param event
     *            the mouse clicked event. (null should be ignored).
     */
    public void mouseClicked(MouseEvent event) {
        if (event == null || event.getButton() != MouseEvent.BUTTON1 || event.getClickCount() != 2) {
            return;
        }

        // hidden the textField
        textField.setVisible(false);

        // retrieve the DiagramViewer
        JComponent viewer = (JComponent) event.getSource();
        while (viewer != null) {
            viewer = (JComponent) viewer.getParent();
            if (viewer instanceof DiagramViewer) {
                break;
            }
        }

        // get the TextInputBox
        TextInputBox textInputBox = ((DiagramViewer) viewer).getTextInputBox();

        // create a TextInputListener and add to the TextInputBox
        TextInputListener listener = new TextInputListener(textField);
        textInputBox.addTextInputListener(listener);

        // set the text of TextInputBox
        //BUGR-120 clear text for new edge
        if(textField.getText() != null && textField.getText().trim().length()> 0){
        	textInputBox.setText(textField.getText());
        }else{
        	textInputBox.clearText();
        }
        
        // BugFix: UML-10001
        // set the size of TextInputBox
        textInputBox.setSize(textField.getPreferredSize());

        // show the TextInputBox
        /*
         * BugFix: UML-9707
         * To support adding elements when at different zoom levels, don't show the text input box
         * on the diagram view, but on the zoom pane, as the diagram view is invisible when zoomed.
         */
        // old code
//        textInputBox.show(viewer, event.getX(), event.getY());
        Container view = textField.getParent().getParent();
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        Point pos = SwingUtilities.convertPoint(textField, 0, 0, view);
        int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
        int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
        textInputBox.show(zoomPane, x, y);

        // BugFix: UML-10001
        // Select old text
        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }
}
