/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.Utils;
import com.topcoder.gui.panels.zoom.ZoomPane;

/**
 * <p>
 * This class can trigger edit box of diagram viewer when some component is double clicked. A TextField instance should
 * be given to this class to tell which text field should be edited.
 * </p>
 * <p>
 * For example, this trigger can be registered to a usecase node, and the text field representing name compartment will
 * be associated with this trigger. As a result, when the use case node is clicked, the name compartment will be
 * editable.
 * </p>
 * <p>
 * Note, the class is expected only be used in this component. No warranty is provided to use it outside this component.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class EditBoxTrigger extends MouseAdapter {

    /**
     * <p>
     * Represents the text field which will be edited by the edit box.
     * </p>
     * <p>
     * It is initialized in constructor, and never changed later.
     * </p>
     * <p>
     * When this trigger is notified, the edit box of diagram viewer will be displayed on top of this text field, and
     * the text field will be hidden. See {@link #mouseClicked(MouseEvent)}
     * </p>
     */
    private final TextField textField;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param textField the text field to be edited
     * @throws IllegalArgumentException if any argument is null.
     */
    public EditBoxTrigger(TextField textField) {
        Utils.checkNull(textField, "textField");
        this.textField = textField;
    }

    /**
     * <p>
     * Handle the MOUSE_CLICKED event.
     * </p>
     *
     * @param e the mouse clicked event. (null should be ignored).
     */
    public void mouseClicked(MouseEvent e) {
        if (e == null) {
            return;
        }
        if (e.getButton() != MouseEvent.BUTTON1 || e.getClickCount() != 2) {
            return;
        }
        // hide the text
        this.textField.setVisible(false);

        /*
         * BugFix: UML-9705
         * To support adding elements when at different zoom levels, don't show the text input box
         * on the diagram view, but on the zoom pane, as the diagram view is invisible when zoomed.
         */
//        // create a EditBoxListener and register it to the DiagramViewer
//        DiagramViewer diagramViewer = DiagramViewer.getInstance();
//        EditBoxListener listener = new EditBoxListener(this.textField);
//        diagramViewer.addEditBoxListener(listener);
//
//        // show the edit box
//        diagramViewer.showEditBox(this.textField.getText(), e.getPoint());
//
//        // FIXME above code is based on the mock of DiagramViewer, it should be fixed when DiagramViewer is ready
        DiagramView view;
        try {
            view = (DiagramView) textField.getParent().getParent();
        } catch (NullPointerException npe) {
            // not added to diagram view
            return;
        }
        DiagramViewer viewer = view.getViewer();
        TextInputBox textInputBox = ((DiagramViewer) viewer).getTextInputBox();
        textInputBox.addTextInputListener(new EditBoxListener(textField));
//      BUGR-120 clear text for new edge
        if(textField.getText() != null && textField.getText().trim().length()> 0){
        	textInputBox.setText(textField.getText());
        }else{
        	textInputBox.clearText();
        }
 
        // BugFix: UML-10000
        // set the size of TextInputBox
        textInputBox.setSize(textField.getPreferredSize());

        /* 
         * BugFix: BUGR-70
         * Use of Ctrl+Enter should be enabled.
         */
        textInputBox.setNewLineAccepted(true);
        
        // show the edit box
        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        Point pos = SwingUtilities.convertPoint(textField, 0, 0, view);
        int x = (int) Math.round((view.getX() + pos.x) * zoomFactor);
        int y = (int) Math.round((view.getY() + pos.y) * zoomFactor);
        textInputBox.show(zoomPane, x, y);

        // BugFix: UML-10000
        // Select old text
        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }
}
