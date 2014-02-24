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
 * Test the functionality of <code>EdgeDragHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class EdgeDragHandlerTest extends TestCase {

    /** An instance of <code>EdgeDragHandler</code> for testing. */
    private EdgeDragHandler handler;

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
        handler = new EdgeDragHandler(TestHelper.getMainFrame());

        wayPoints.add(new Point(100, 100));
        wayPoints.add(new Point(200, 200));
        wayPoints.add(new Point(300, 300));

        edge = TestHelper.addIncludeEdge(wayPoints);
    }

    /**
     * Test method for 'EdgeDragHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testEdgeDragHandler_Accuracy() {
        assertNotNull("Test method for 'EdgeDragHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'EdgeDragHandler(MainFrame)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testEdgeDragHandler_null() {
        try {
            new EdgeDragHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'edgeDragged(WayPointEvent)'. A valid event is passed, node's bound should be changed correctly.
     */
    public void testEdgeDragged_Accuracy() {
        Point offset = new Point(50, 50);
        WayPointEvent event = new WayPointEvent(edge, 1, offset);
        handler.edgeDragged(event);
        GraphEdge graphEdge = edge.getGraphEdge();
        int x = (int) graphEdge.getWaypoints().get(1).getX();
        int y = (int) graphEdge.getWaypoints().get(1).getY();
        Point position = wayPoints.get(1).getLocation();
        position.x += offset.x;
        position.y += offset.y;
        assertEquals("Way point should be moved correctly.", new Point(x, y), position);
    }

    /**
     * Test method for 'edgeDragged(WayPointEvent)'. The argument is null, should be ignored.
     */
    public void testEdgeDragged_null() {
        handler.edgeDragged(null);
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
