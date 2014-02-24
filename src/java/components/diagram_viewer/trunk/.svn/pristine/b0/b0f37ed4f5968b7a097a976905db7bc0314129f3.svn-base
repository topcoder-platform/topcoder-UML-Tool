/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.panels.zoom.ZoomPanel;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for ZoomEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ZoomEventUnitTests extends TestCase {

    /**
     * <p>
     * newZoomFactor value for testing.
     * </p>
     */
    private final double newZoomFactor = 100;

    /**
     * ZoomEvent instance for testing.
     */
    private ZoomEvent ze;

    /**
     * ZoomPanel instance for testing.
     */
    private ZoomPanel zoomPanel;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        UnitTestsHelper.loadConfig("config.xml");

        Diagram diagram = new Diagram();
        Dimension dimension = new Dimension();
        dimension.setWidth(500.0);
        dimension.setHeight(500.0);
        diagram.setSize(dimension);

        Point point = new Point();
        point.setX(5);
        point.setY(5);
        diagram.setPosition(point);

        this.zoomPanel = new ZoomPanel(new DiagramViewer().createDiagramView(diagram));
        ze = new ZoomEvent(zoomPanel, this.newZoomFactor);
    }

    /**
     * <p>
     * This is the accuracy test for constructor: ZoomEvent(ZoomPanel source,
     * int newZoomFactor). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create ZoomEvent instance.", ze);
        assertEquals("Failed to create ZoomEvent instance.", (ZoomPanel) ze.getSource(), this.zoomPanel);
    }

    /**
     * <p>
     * This is the failure test for constructor: ZoomEvent(ZoomPanel source, int
     * newZoomFactor).<br>
     * Failure condition: the source is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithNullSource() throws Exception {
        try {
            new ZoomEvent(null, newZoomFactor);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the failure test for constructor: ZoomEvent(ZoomPanel source, int
     * newZoomFactor).<br>
     * Failure condition: the newZoomFactor is non-positive. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithNonPositiveZoomFactor() throws Exception {
        try {
            new ZoomEvent(this.zoomPanel, 0);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

        try {
            new ZoomEvent(this.zoomPanel, -1);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }

    }

    /**
     * <p>
     * This is the accuracy test for Method:getNewZoomFactor(). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetNewZoomFactorAccuracy() throws Exception {
        assertTrue("Failed to call Method: getNewZoomFactor.", ze.getNewZoomFactor() == 100.0);
    }

}
