/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for ZoomTextFieldAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZoomTextFieldActionUnitTests extends TestCase {

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
        UnitTestsHelper.loadConfig("config.xml");
        diagramViewer = new DiagramViewer();
        this.textField = new JTextField("Test");
        ztfa = new ZoomTextFieldAction(diagramViewer, this.textField);
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.removeAllNamespaces();
    }

    /**
     * <p>
     * This is the accuracy test for constructor:
     * ZoomTextFieldAction(diagramViewer,this.textField). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        assertNotNull("Failed to create ZoomTextFieldAction instance.", ztfa);

    }

    /**
     * <p>
     * This is the failure test for constructor:
     * ZoomTextFieldAction(diagramViewer,this.textField). <br>
     * Failure condition: at least one arg is null. <br>
     * Excepted: IllegalArgumentException.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithNullValue() throws Exception {
        try {
            new ZoomTextFieldAction(diagramViewer, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new ZoomTextFieldAction(null, this.textField);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new ZoomTextFieldAction(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewer().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramViewerAccuracy() throws Exception {
        assertEquals("Fail to get DiagramViewer", this.diagramViewer, this.ztfa.getDiagramViewer());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: updateZoomFactorText(int
     * newFactor).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testUpdateZoomFactorTextAccuracy() throws Exception {
        this.ztfa.updateZoomFactorText(3.0);
    }

    /**
     * <p>
     * This is the failure test for method:updateZoomFactorText(int newFactor),
     * DiagramViewer viewer).<br>
     * Failure condition: the newFactor is non-positive. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testUpdateZoomFactorTextWithNonPositiveVaule() throws Exception {
        try {
            this.ztfa.updateZoomFactorText(-1.0);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            this.ztfa.updateZoomFactorText(0.0);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

    /**
     * <p>
     * This is the Accuracy test for Method: actionPerformed(ActionEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testActionPerformedAccuracy() throws Exception {
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
        this.diagramViewer.setTabShortenedTitleMaxLength(4);
        this.diagramViewer.setTabTitleDisplayedInFullVersion(false);
        this.diagramViewer.openDiagramView(diagram);
        this.ztfa.actionPerformed(null);
        this.ztfa.actionPerformed(new ActionEvent(ztfa, 0, "fName"));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: stateChanged(ChangeEvent event).
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testStateChangedAccuracy() throws Exception {
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
        this.diagramViewer.setTabShortenedTitleMaxLength(4);
        this.diagramViewer.setTabTitleDisplayedInFullVersion(false);
        this.diagramViewer.openDiagramView(diagram);
        this.ztfa.stateChanged(null);
        ChangeEvent event = new ChangeEvent(this.diagramViewer);
        this.ztfa.stateChanged(event);
    }

}
