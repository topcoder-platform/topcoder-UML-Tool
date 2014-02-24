/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.ZoomTextFieldAction;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test cases for ZoomTextFieldAction.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class ZoomTextFieldActionAccuracyTests extends TestCase {

    /**
     * The DiagramViewer for testing.
     */
    private DiagramViewer diagramViewer;

    /**
     * The JTextField for testing.
     */
    private JTextField textField;

    /**
     * ZoomTextFieldAction instance for testing.
     */
    private ZoomTextFieldAction ztfa;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DefaultConfig);
        diagramViewer = new DiagramViewer();
        textField = new JTextField("TestField");
        ztfa = new ZoomTextFieldAction(diagramViewer, textField);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewer().
     * </p>
     */
    public void testGetDiagramViewerAccuracy() {
        assertEquals("Fail to get DiagramViewer", diagramViewer, ztfa.getDiagramViewer());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: updateZoomFactorText(int newFactor).
     * </p>
     */
    public void testUpdateZoomFactorTextAccuracy() {
        ztfa.updateZoomFactorText(3.0);
        assertEquals("UpdateZoomFactorText failed.", "3.0", textField.getText());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: actionPerformed(ActionEvent event).
     * </p>
     */
    public void testActionPerformedAccuracy2() {
        textField.setText("30.0");
        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        diagram.setName("Test");
        diagramViewer.setTabShortenedTitleMaxLength(4);
        diagramViewer.setTabTitleDisplayedInFullVersion(false);
        diagramViewer.openDiagramView(diagram);
        ztfa.actionPerformed(new ActionEvent(ztfa, 0, "fName"));

        assertNotSame("StateChanged failed.",
                diagramViewer.getZoomFactorForCurrentTab(), 30.0);
    }

}
