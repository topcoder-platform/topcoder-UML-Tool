/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * <p>
 * This is an action class to be used to change zoom factor for ZoomPanel, it is
 * used as ActionListener for a JTextField, and ChangeListener for a
 * JTabbedPane. When the JTextField triggers ActionEvent, this action read the
 * content of that JTextField and trigger a zoom event for DiagramViewer, the
 * content must be an positive integer otherwise nothing would happen. When the
 * JTabbedPane switches tab, this action listens to the ChangeEvent and change
 * the content of the JTextField to the value of zoom factor of current active
 * tab (a ZoomPanel).
 * </p>
 * <p>
 * Thread safety: This class is immutable, but its method may changes the inner
 * TextField field which is not thread safe, so this class is not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ZoomTextFieldAction extends AbstractAction implements ChangeListener {

    /**
     * <p>
     * Represents the DiagramViewer that holds this action.
     * </p>
     * <p>
     * Initialized in ctor and never changed. Can not be null. Can be accessed
     * by getter.
     * </p>
     */
    private final DiagramViewer diagramViewer;

    /**
     * <p>
     * Represents the text field for which this action works.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be null. The content
     * of it will be changed in method updateZoomFactorText, the content must be
     * in form of integer.
     * </p>
     */
    private final JTextField textField;

    /**
     * <p>
     * Constructor, assigns the arguments to fields.
     * </p>
     *
     * @param viewer the DiagramViewer that creates this action
     * @param textField the text field for which this action works
     * @throws IllegalArgumentException if any argument is null
     */
    public ZoomTextFieldAction(DiagramViewer viewer, JTextField textField) {
        DVHelper.validateNotNull(viewer, "viewer");
        DVHelper.validateNotNull(textField, "textField");
        this.diagramViewer = viewer;
        this.textField = textField;
    }

    /**
     * <p>
     * Getter of diagramViewer, see field doc for explanation.
     * </p>
     *
     * @return the DiagramViewer that holds this action
     */
    public DiagramViewer getDiagramViewer() {
        return diagramViewer;
    }

    /**
     * <p>
     * Updates the content of the text field with the argument.
     * </p>
     *
     * @param newFactor the new zoom factor, must be positive
     * @throws IllegalArgumentException if the argument is non-positive
     */
    /*
	 * BugFix: BUGID UML-7154
	 * Description:
	 * The zoom factor should have been a double.  This needs to be updated.
	 */
    // old code
//    public void updateZoomFactorText(int newFactor) {
    public void updateZoomFactorText(double newFactor) {
        DVHelper.validatePositive(newFactor, "newFactor");
        textField.setText(String.valueOf(newFactor));
    }

    /**
     * <p>
     * Trigger a ZoomEvent for the DiagramView contained in currently enabled
     * tab of the DiagramViewer.
     * </p>
     *
     * @param event the action event (ignore null)
     */
    public void actionPerformed(ActionEvent event) {
        try {
        	/*
        	 * BugFix: BUGID UML-7154
        	 * Description:
        	 * The zoom factor should have been a double.  This needs to be updated.
        	 */
            // old code
//            diagramViewer.fireZoom(Integer.parseInt(textField.getText()) - diagramViewer.getZoomFactorForCurrentTab());
            diagramViewer.fireZoom(Double.parseDouble(textField.getText()) - diagramViewer.getZoomFactorForCurrentTab());
        } catch (NumberFormatException e) {
            updateZoomFactorText(diagramViewer.getZoomFactorForCurrentTab());
        }

    }

    /**
     * <p>
     * This method is triggered when the tab of the DiagramViewer is switched,
     * so here we should update the content of the textField to the zoom factor
     * of the new tab.
     * </p>
     *
     * @param event the action event (ignore null)
     */
    public void stateChanged(ChangeEvent event) {
        textField.setText(String.valueOf(diagramViewer.getZoomFactorForCurrentTab()));
    }
}
