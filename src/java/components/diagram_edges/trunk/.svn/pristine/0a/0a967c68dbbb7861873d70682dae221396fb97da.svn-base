/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for EdgeMouseListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EdgeMouseListenerTests extends TestCase {
    /**
     * <p>
     * EdgeMouseListener instance for testing.
     * </p>
     */
    private EdgeMouseListener listener;

    /**
     * <p>
     * Edge instance for helping testing.
     * </p>
     */
    private Edge edge;

    /**
     * <p>
     * EdgeDragListener instance for helping testing.
     * </p>
     */
    private SimpleEdgeDragListener dragListener;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files" + File.separator + "DiagramViewer.xml");

        listener = new EdgeMouseListener();
        edge = TestHelper.createEdge();
        dragListener = new SimpleEdgeDragListener();
        edge.addEdgeDragListener(dragListener);

        DiagramViewer diagramViewer = new DiagramViewer("DiagramViewer");
        Diagram diagram = new Diagram();
        diagram.setPosition(TestHelper.createDiagramInterchangePoint(0, 0));
        diagram.setSize(TestHelper.createDiagramInterchangeDimension(100, 50));
        DiagramView diagramView = diagramViewer.createDiagramView(diagram);
        diagramView.add(edge);
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

        listener = null;
        edge = null;
        dragListener = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EdgeMouseListenerTests.class);
    }

    /**
     * <p>
     * Tests EdgeMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EdgeMouseListener#mouseDragged(MouseEvent) is correct.
     * </p>
     */
    public void testMouseDragged() {
        MouseEvent pressEvent = new MouseEvent(edge, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);
        MouseEvent draggedEvent = new MouseEvent(edge, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mousePressed(pressEvent);
        listener.mouseDragged(draggedEvent);

        WayPointEvent event = dragListener.getLastEvent();
        assertSame("The source should be set.", edge, event.getSource());
        assertEquals("Failed to set the last position.", new Point(5, 15), event.getOldPosition());
        assertEquals("Failed to set the offset.", new Point(20, 20), event.getOffset());
        assertEquals("Failed to get the new position.", new Point(25, 35), event.getNewPosition());
    }

    /**
     * <p>
     * Tests EdgeMouseListener#mouseDragged(MouseEvent) for accuracy.
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
     * Tests EdgeMouseListener#mouseDragged(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when the source of the event is not of Edge type and expects no exception.
     * </p>
     */
    public void testMouseDragged_NonEdgeSource() {
        MouseEvent draggedEvent = new MouseEvent(new JButton(), MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mouseDragged(draggedEvent);

    }

    /**
     * <p>
     * Tests EdgeMouseListener#mouseReleased(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : EdgeMouseListener#mouseReleased(MouseEvent) is correct.
     * </p>
     */
    public void testMouseReleased() {
        MouseEvent event = new MouseEvent(edge, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        listener.mouseReleased(event);

        // verify the edge should be active
        TestHelper.verifyEdgeActive(edge);
    }

    /**
     * <p>
     * Tests EdgeMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when event is null and expects no exception.
     * </p>
     */
    public void testMousePressed_NullE() {
        listener.mousePressed(null);
    }

    /**
     * <p>
     * Tests EdgeMouseListener#mousePressed(MouseEvent) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when the source for the event is not of Edge type and expects no exception.
     * </p>
     */
    public void testMousePressed_NonEdgeSource() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
            MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        listener.mousePressed(event);
    }

}