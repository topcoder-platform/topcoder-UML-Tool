/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests;

import java.awt.event.ActionEvent;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.ZoomAction;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test cases for <c>ZoomAction</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class ZoomActionAccuracyTests extends TestCase {
    /**
     * The DiagramViewer for testing.
     */
    private DiagramViewer diagramViewer;

    /**
     * ZoomAction instance for testing.
     */
    private ZoomAction za;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DefaultConfig);
        diagramViewer = new DiagramViewer();
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DIR + "zoomAction0.xml");
        za = new ZoomAction(diagramViewer);
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
     * This is the accuracy test for constructor: ZoomAction(String namespace, DiagramViewer viewer).
     * Positive increment is acceptable.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1() throws Exception {
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DIR + "zoomAction2.xml");
        za = new ZoomAction(diagramViewer);
        assertNotNull("Failed to create ZoomAction instance.", za);
        assertEquals("Failed to create ZoomAction instance.", za.getIncrement(), 36.0);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ZoomAction(String namespace, DiagramViewer viewer).
     * Zero increment is acceptable.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2() throws Exception {
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DIR + "zoomAction3.xml");
        za = new ZoomAction(diagramViewer);
        assertNotNull("Failed to create ZoomAction instance.", za);
        assertEquals("Failed to create ZoomAction instance.", za.getIncrement(), 0.0);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ZoomAction(String namespace, DiagramViewer viewer).
     * Negative increment is acceptable.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor3() throws Exception {
        AccuracyTestsHelper.loadConfig(AccuracyTestsHelper.DIR + "zoomAction1.xml");
        za = new ZoomAction(diagramViewer);
        assertNotNull("Failed to create ZoomAction instance.", za);
        assertEquals("Failed to create ZoomAction instance.", za.getIncrement(), -10.0);
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
        this.za.actionPerformed(null);

        this.za.actionPerformed(new ActionEvent(za, 0, ZoomAction.class.getName()));
    }

    /**
     * <p>
     * This is the Accuracy test for Method: setIncrement(int increment).
     * </p>
     */
    public void testSetIncrementAccuracy() {
        za.setIncrement(10);
        assertEquals("Fail to call Method:  setIncrement()", 10.0, za.getIncrement());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getIncrement().
     * </p>
     *
     * @throws Exception if any error occur.
     */
    public void testGetIncrementAccuracy() throws Exception {
        assertEquals("Fail to call Method:  getIncrement()", 0.0, za.getIncrement());
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagramViewer().
     * </p>
     */
    public void testGetDiagramViewerAccuracy() {
        assertEquals("Fail to call Method:  getDiagramViewer().", this.diagramViewer, za.getDiagramViewer());
    }

}
