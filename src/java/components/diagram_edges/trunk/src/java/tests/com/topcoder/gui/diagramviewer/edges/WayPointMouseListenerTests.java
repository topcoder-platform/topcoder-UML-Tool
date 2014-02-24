/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for WayPointMouseListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class WayPointMouseListenerTests extends TestCase {
    /**
     * <p>
     * WayPointMouseListener instance for testing.
     * </p>
     */
    private WayPointMouseListener listener;

    /**
     * <p>
     * Edge instance for helping testing.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * SelectionCorner instance for helping testing.
     * </p>
     */
    private SelectionCorner corner;

    /**
     * <p>
     * WayPointListener instance for helping testing.
     * </p>
     */
    private SimpleWayPointListener wayPointListener;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "DiagramViewer.xml");

        edge = TestHelper.createEdge();
        corner = edge.getWayPoints().get(0);
        wayPointListener = new SimpleWayPointListener();
        edge.addWayPointDragListener(wayPointListener);

        listener = new WayPointMouseListener(edge);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();

        wayPointListener = null;
        edge = null;
        corner = null;
        listener = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(WayPointMouseListenerTests.class);
    }

    /**
     * <p>
     * Tests WayPointMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointMouseListener#mouseDragged(MouseEvent) is correct.
     * </p>
     */
    public void testMouseDragged() {
        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent draggedEvent = new MouseEvent(corner, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mousePressed(event);
        listener.mouseDragged(draggedEvent);

        // verify the way point event
        WayPointEvent wayPointEvent = wayPointListener.getLastEvent();
        assertSame("The edge should be set as source.", edge, wayPointEvent.getSource());
        assertEquals("Failed to get the correct index.", 0, wayPointEvent.getIndex());
        assertEquals("Failed to get the old position.", corner.getCenter(), wayPointEvent.getOldPosition());
        assertEquals("Failed to get the offset.", new Point(20, 20), wayPointEvent.getOffset());
    }

    /**
     * <p>
     * Tests WayPointMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testMouseDragged_NullE() {
        listener.mouseDragged(null);
    }

    /**
     * <p>
     * Tests WayPointMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : WayPointMouseListener#mousePressed(MouseEvent) is correct.
     * </p>
     */
    public void testMousePressed() {
        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        listener.mousePressed(event);

        MouseEvent draggedEvent = new MouseEvent(corner, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mouseDragged(draggedEvent);

        // verify the point should be recorded
        WayPointEvent wayPointEvent = wayPointListener.getLastEvent();
        assertEquals("Failed to get the offset.", new Point(20, 20), wayPointEvent.getOffset());
    }

    /**
     * <p>
     * Tests WayPointMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when e is null and expects no exception.
     * </p>
     */
    public void testMousePressed_NullE() {
        listener.mouseDragged(null);
    }
}