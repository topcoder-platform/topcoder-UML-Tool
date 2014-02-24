/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.edges.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;

/**
 * <p>
 * Test the functionality of <code>WayPointMouseHanler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class WayPointMouseHanlerTest extends TestCase {

    /** An instance of <code>WayPointMouseHanler</code> for testing. */
    private WayPointMouseHandler handler;

    /** An instance of IncludeEdge for testing. */
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
        handler = new WayPointMouseHandler(TestHelper.getMainFrame());
        TestHelper.getDiagramView(DiagramType.USECASE);

        wayPoints.add(new Point(100, 100));
        wayPoints.add(new Point(200, 200));
        wayPoints.add(new Point(300, 300));

        edge = TestHelper.addIncludeEdge(wayPoints);
    }

    /**
     * Test method for 'WayPointMouseHanler(MainFrame)'. The instance should be created successfully.
     */
    public void testWayPointMouseHanler() {
        assertNotNull("Test method for 'WayPointMouseHanler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'WayPointMouseHanler(MainFrame)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testWayPointMouseHanler_null() {
        try {
            new WayPointMouseHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'mousePressed(MouseEvent)'. A valid event is given, should perform successfully.
     */
    public void testMousePressedMouseEvent_Accuracy() {
        SelectionCorner corner = edge.getWayPoints().get(1);
        Point point = new Point(250, 100);
        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_RELEASED, 1000, MouseEvent.ALT_DOWN_MASK, point.x,
                point.y, 2, true, MouseEvent.BUTTON1);
        handler.mousePressed(event);
    }

    /**
     * Test method for 'mousePressed(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testMousePressedMouseEvent_null() {
        handler.mousePressed(null);
    }

    /**
     * Test method for 'mouseReleased(MouseEvent)'.A valid event is given, should perform successfully.
     */
    public void testMouseReleasedMouseEvent_Accuracy() {
        SelectionCorner corner = edge.getWayPoints().get(1);
        Point point = new Point(250, 100);
        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_RELEASED, 1000, MouseEvent.ALT_DOWN_MASK, point.x,
                point.y, 2, true, MouseEvent.BUTTON1);
        handler.mouseReleased(event);
    }

    /**
     * Test method for 'mouseReleased(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testmouseReleasedMouseEvent_null() {
        handler.mouseReleased(null);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        handler = null;
        TestHelper.getDiagramView(DiagramType.USECASE).removeAll();
        edge = null;
        wayPoints.clear();
        wayPoints = null;
    }

}
