/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.ConfigurationException;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.accuracytests.Helper;
import com.topcoder.gui.diagramviewer.elements.accuracytests.MyNode;
import com.topcoder.gui.diagramviewer.elements.accuracytests.MyNodeDragListener;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>NodeMouseListener </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestNodeMouseListenerAccuracy extends TestCase {
    /**
     * Represents the NodeMouseListener instnace for testing.
     */
    private NodeMouseListener listener = null;

    /**
     * Represents the Node for testing.
     */
    private Node node = null;

    /**
     * Set up.
     * @throws Exception to junit
     */
    public void setUp() throws Exception {
        TestHelper.loadXMLConfig("test_files/DiagramViewer.xml");
        listener = new NodeMouseListener();
        node = new MyNode(new GraphNode(), new Point(1, 100), new Rectangle(1, 2, 10, 100), Helper.getCollection());
        DiagramViewer diagramViewer = new DiagramViewer("DiagramViewer");
        Diagram diagram = new Diagram();
        diagram.setPosition(TestHelper.createDiagramInterchangePoint(0, 0));
        diagram.setSize(TestHelper.createDiagramInterchangeDimension(100, 50));
        DiagramView diagramView = diagramViewer.createDiagramView(diagram);
        diagramView.add(node);
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
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_1() {
        assertNull("Should be null.", listener.getLastPoint());
        listener.mousePressed(null);
        assertNull("Should be null.", listener.getLastPoint());
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_2() {
        assertNull("Should be null.", listener.getLastPoint());
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 1000, 5000, 50, true);

        listener.mousePressed(event);
        assertNull("Should be null.", listener.getLastPoint());
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_3() {
        assertNull("Should be null.", listener.getLastPoint());
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 1000, 5000, 50, true);
        // set a Node instance as its resource.
        event.setSource(node);

        listener.mousePressed(event);
        assertNotNull("Should not be null.", listener.getLastPoint());
        Point p = listener.getLastPoint();
        assertNotNull("Should not be null.", p);
        assertEquals("Equal is expected.", 1000.0, p.getX());
        assertEquals("Equal is expected.", 5000.0, p.getY());
    }

    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     * <p>
     * This test case is complex.
     * </p>
     */
    public void testMouseDragged_1() {
        MouseEvent event = new MouseEvent(node, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 25, 35, 1, false);
        event.setSource(node);
        listener.mousePressed(event);
        listener.mouseDragged(event);
        assertNotNull("Should not be null.", listener.getLastPoint());
        // check for the last point.
        assertEquals("Equal is expected.", 25, listener.getLastPoint().x);
        assertEquals("Equal is expected.", 35, listener.getLastPoint().y);
    }

    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     *
     */
    public void testMouseDragged_2() {
        assertNull("Should be null.", listener.getLastPoint());
        listener.mouseDragged(null);
        assertNull("Should be null.", listener.getLastPoint());
    }

    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     *
     */
    public void testMouseDragged_3() {
        MouseEvent event = new MouseEvent(node, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        listener.mouseDragged(event);
        assertNull("Should be null.", listener.getLastPoint());
    }

    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     *
     */
    public void testMouseDragged_4() {
        MouseEvent event = new MouseEvent(node, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 25, 35, 1, false);

        event.setSource(node);
        listener.setLastPoint(null);

        listener.mouseDragged(event);
        assertNull("Should be null.", listener.getLastPoint());
    }

    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     * <p>
     * This test case is complex.
     * </p>
     */
    public void testMouseDragged_5() {
        MyNodeDragListener nodeDragListener = new MyNodeDragListener();
        node.addNodeDragListener(nodeDragListener);

        MouseEvent event1 = new MouseEvent(new JButton(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 1, 5, 50, true, MouseEvent.BUTTON1);
        event1.setSource(node);
        listener.mousePressed(event1);

        MouseEvent event2 = new MouseEvent(node, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 25, 35, 1, false, MouseEvent.BUTTON1);
        event2.setSource(node);
        listener.mouseDragged(event2);

        LocationEvent location = nodeDragListener.getEvent();
        assertEquals("Equal is expected.", 24, location.getNewLocation().x);
        assertEquals("Equal is expected.", 30, location.getNewLocation().y);
    }
}
