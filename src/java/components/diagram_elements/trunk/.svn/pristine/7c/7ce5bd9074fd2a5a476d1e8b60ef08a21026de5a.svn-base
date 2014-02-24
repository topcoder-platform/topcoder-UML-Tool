/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.elements.NodeDragListener;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;

import junit.framework.TestCase;

/**
 * Accuracy test cases for abstract class <code>Node</code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestNodeAccuracy extends TestCase {

    /**
     * Represents the Node instance for testing.
     */
    private MyNode node = null;

    /**
     * Set up.
     */
    public void setUp() {
        node = new MyNode(new GraphNode(), new Point(1, 100), new Rectangle(1, 2, 10, 100), Helper.getCollection());
    }

    /**
     * Test constructor.
     *
     */
    public void testNode() {
        assertNotNull("Should not be null.", node);
    }

    /**
     * Test method <code>GraphNode getGraphNode() </code>.
     *
     */
    public void testGetGraphNode() {
        GraphNode gn = new GraphNode();
        node = new MyNode(gn, new Point(1, 100), new Rectangle(1, 2, 10, 100), Helper.getCollection());
        assertEquals("Equal is expected.", gn, node.getGraphNode());
    }

    /**
     * Test method <code>void notifyUnselected() </code>.
     *
     */
    public void testNotifyUnselected() {
        for (SelectionCorner corner : node.getSelectionCorners()) {
            corner.setVisible(true);
        }

        node.notifyUnselected();

        for (SelectionCorner corner : node.getSelectionCorners()) {
            assertFalse("Should be false now.", corner.isVisible());
        }
    }

    /**
     * Test method <code>Point getLocation(Point point) </code>.
     * <p>
     * NO container is defined in this test case.
     * </p>
     */
    public void testGetLocationPoint_1() {
        node.setRelativePosition(new Point(0, 0));

        Point p = node.getLocation(null);
        assertEquals("Equal is expected.", 0, p.x);
        assertEquals("Equal is expected.", 0, p.y);
    }

    /**
     * Test method <code>Point getLocation(Point point) </code>.
     * <p>
     * No container is defined in this test case.
     * </p>
     */
    public void testGetLocationPoint_2() {
        node.setRelativePosition(new Point(10, 100));
        Point p = node.getLocation(null);
        assertEquals("Equal is expected.", -10, p.x);
        assertEquals("Equal is expected.", -100, p.y);
    }

    /**
     * Test method <code>Point getLocation(Point point) </code>.
     * <p>
     * There is container for the GraphNode instance.
     * </p>
     */
    public void testGetLocationPoint_3() {

        Diagram d = new Diagram();
        com.topcoder.diagraminterchange.Point p = new com.topcoder.diagraminterchange.Point();
        p.setX(10);
        p.setY(100);

        d.setPosition(p);

        GraphNode n = new GraphNode();

        // The node's Position is (1, 1);
        com.topcoder.diagraminterchange.Point p2 = new com.topcoder.diagraminterchange.Point();
        p2.setX(1);
        p2.setY(1);

        n.setPosition(p2);

        d.addContained(n);
        n.setContainer(d);

        node = new MyNode(n, new Point(1, 100), new Rectangle(1, 2, 10, 100), Helper.getCollection());

        node.setRelativePosition(new Point(10, 100));

        Point point = node.getLocation(null);
        assertEquals("Equal is expected.", -9, point.x);
        assertEquals("Equal is expected.", -99, point.y);
    }

    /**
     * Test method <code>Collection<SelectionCorner> getSelectionCorners() </code>.
     *
     */
    public void testGetSelectionCorners() {
        Collection<SelectionCorner> c = node.getSelectionCorners();
        assertEquals("Equal is expected.", 8, c.size());
    }

    /**
     * Test method <code>void setRelativePosition(Point position) </code>.
     *
     */
    public void testSetRelativePosition() {
        Point p = new Point(1, 1);
        node.setRelativePosition(p);

        Point ret = node.getRelativePosition();
        assertEquals("Equal is expected.", p, ret);
    }

    /**
     * Test method <code>Point getRelativePosition() </code>.
     *
     */
    public void testGetRelativePosition() {
        Point p = new Point(1000, 15);
        node.setRelativePosition(p);

        Point ret = node.getRelativePosition();
        assertEquals("Equal is expected.", p, ret);
    }

    /**
     * Test method <code>void setSelectionBound(Rectangle bound) </code>.
     *
     */
    public void testSetSelectionBound() {
        Rectangle r = new Rectangle(1, 2, 10, 100);
        node.setSelectionBound(r);

        assertEquals("Equal is expected.", r, node.getSelectionBound());
    }

    /**
     * Test method <code> Rectangle getSelectionBound() </code>.
     *
     */
    public void testGetSelectionBound() {
        Rectangle r = new Rectangle(1, 2, 1, 1);
        node.setSelectionBound(r);

        assertEquals("Equal is expected.", r, node.getSelectionBound());
    }

    /**
     * Test method <code>boolean consumeEvent(MouseEvent event) </code>.
     *
     */
    public void testConsumeEvent() {
        assertFalse("This method will return false always.", node.consumeEvent(null));
    }

    /**
     * Test method <code>void addNodeDragListener(NodeDragListener listener) </code>.
     *
     */
    public void testAddNodeDragListener() {
        NodeDragListener listener = new MyNodeDragListener();
        node.addNodeDragListener(listener);

        NodeDragListener[] listeners = node.getListeners(NodeDragListener.class);
        assertEquals("Failed to add the node drag listener.", 1, listeners.length);
        assertEquals("Failed to add the node drag listener.", listener, listeners[0]);
    }

    /**
     * Test method <code>void removeNodeDragListener(NodeDragListener listener) </code>.
     *
     */
    public void testRemoveNodeDragListener() {
        NodeDragListener listener = new MyNodeDragListener();
        node.addNodeDragListener(listener);

        NodeDragListener[] listeners = node.getListeners(NodeDragListener.class);
        assertEquals("Equal is expected.", 1, listeners.length);
        assertEquals("Equal is expected.", listener, listeners[0]);

        node.removeNodeDragListener(listener);
        listeners = node.getListeners(NodeDragListener.class);
        assertEquals("Equal is expected.", 0, listeners.length);

    }

    /**
     * Test method <code>void fireNodeDrag(LocationEvent event) </code>.
     *
     */
    public void testFireNodeDrag() {
        MyNodeDragListener listener = new MyNodeDragListener();
        node.addNodeDragListener(listener);

        LocationEvent event = new LocationEvent(node, new Point(1, 2), new Point(10, 100));

        node.fireNodeDrag(event);

        assertEquals("Equal is expected.", event, listener.getEvent());
    }

    /**
     * Test method <code>void addCornerDragListener(CornerDragListener listener) </code>.
     *
     */
    public void testAddCornerDragListener() {
        MyCornerDragListener listener = new MyCornerDragListener();
        node.addCornerDragListener(listener);

        CornerDragListener[] listeners = node.getListeners(CornerDragListener.class);
        assertEquals("Equal is expected.", 1, listeners.length);
        assertEquals("Equal is expected.", listener, listeners[0]);
    }

    /**
     * Test method <code>void removeCornerDragListener(CornerDragListener listener) </code>.
     *
     */
    public void testRemoveCornerDragListener() {
        MyCornerDragListener listener = new MyCornerDragListener();
        node.addCornerDragListener(listener);

        CornerDragListener[] listeners = node.getListeners(CornerDragListener.class);
        assertEquals("Equal is expected.", 1, listeners.length);
        assertEquals("Equal is expected.", listener, listeners[0]);

        node.removeCornerDragListener(listener);
        listeners = node.getListeners(CornerDragListener.class);
        assertEquals("Equal is expected.", 0, listeners.length);
    }

    /**
     * Test method <code>void fireCornerDrag(SelectionBoundEvent event) </code>.
     *
     */
    public void testFireCornerDrag() {
        MyCornerDragListener listener = new MyCornerDragListener();
        node.addCornerDragListener(listener);

        SelectionBoundEvent event = new SelectionBoundEvent(node, new Rectangle(1, 1, 1, 1),
                new Rectangle(1, 2, 10, 10));

        node.fireCornerDrag(event);

        assertEquals("Equal is expected.", event, listener.getSelectionBoundEvent());
    }
}
