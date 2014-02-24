/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.WayPointEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>WayPointHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class WayPointHandlerTest extends TestCase {

    /** An instance of <code>WayPointHandler</code> for testing. */
    private WayPointHandler handler;

    /** An instance of <code>IncludeEdge</code> for testing. */
    private IncludeEdge edge;

    /** Way points for the edge. */
    private List<Point> wayPoints = new ArrayList<Point>();

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        handler = new WayPointHandler(TestHelper.getMainFrame());

        wayPoints.add(new Point(100, 100));
        wayPoints.add(new Point(200, 200));
        wayPoints.add(new Point(300, 300));

        edge = TestHelper.addIncludeEdge(wayPoints);
    }

    /**
     * Test method for 'WayPointHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testWayPointHandler_Accuracy() {
        assertNotNull("Test method for 'WayPointHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'WayPointHandler(MainFrame)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testWayPointHandler_null() {
        try {
            new WayPointHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'wayPointDragged(WayPointEvent)'. A valid argument is given, should perform correctly.
     */
    public void testWayPointDragged_Accuracy() {
        Point offset = new Point(50, 50);
        Point oldLocation = wayPoints.get(1).getLocation();
        Point newLocation = new Point(oldLocation);
        newLocation.x += offset.x;
        newLocation.y += offset.y;
        WayPointEvent event = new WayPointEvent(edge, 1, offset);
        handler.wayPointDragged(event);
        Point location = new Point();
        GraphEdge graphEdge = edge.getGraphEdge();
        location.x = (int) graphEdge.getWaypoints().get(1).getX();
        location.y = (int) graphEdge.getWaypoints().get(1).getY();
        assertEquals("Way point should be moved correctly.", location, newLocation);
    }

    /**
     * Test method for 'wayPointDragged(WayPointEvent)'. The argument is null, should be ignored.
     */
    public void testWayPointDragged_null() {

        handler.wayPointDragged(null);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        handler = null;
        edge = null;
        wayPoints.clear();
        wayPoints = null;
    }
}
