/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.accuracytests.Helper;
import com.topcoder.gui.diagramviewer.elements.accuracytests.MyCornerDragListener;
import com.topcoder.gui.diagramviewer.elements.accuracytests.MyNode;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>SelectionCornerMouseListener </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestSelectionCornerMouseListenerAccuracy extends TestCase {

    /**
     * Represents the SelectionCornerMouseListener instance for testing.
     */
    private SelectionCornerMouseListener listener = null;

    /**
     * Represents the Node for testing.
     */
    private Node node = null;

    /**
     * Set up.
     */
    public void setUp() {
        node = new MyNode(new GraphNode(), new Point(1, 100), new Rectangle(1, 2, 10, 100), Helper.getCollection());

        listener = new SelectionCornerMouseListener(node);
    }

    /**
     * Test the constructor <code>SelectionCornerMouseListener(Node node) </code>.
     */
    public void testSelectionCornerMouseListener() {
        assertNotNull("The SelectionCornerMouseListener should be created.", listener);
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_NullMouseEvent() {
        listener.mousePressed(null);
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_2() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 5, 15, 1, false);

        listener.mousePressed(event);
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_3() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 10, 100, 1, false);
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.EAST, new Point(5, 5));
        event.setSource(corner);

        listener.mousePressed(event);

        // the last point should be saved.
        assertEquals("Equal is exected.", new Point(10, 100), listener.getLastPoint());

        // check for the Cursor
        Cursor c = corner.getCursor();

        assertEquals("Equal is expected.", Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR), c);
    }

    /**
     * Test method <code> void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_4() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 10, 100, 1, false);
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.NORTH, new Point(5, 5));
        event.setSource(corner);

        listener.mousePressed(event);

        // the last point should be saved.
        assertEquals("Equal is exected.", new Point(10, 100), listener.getLastPoint());

        // check for the Cursor
        Cursor c = corner.getCursor();

        assertEquals("Equal is expected.", Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR), c);
    }

    /**
     * Test method <code>void mouseReleased(MouseEvent e) </code>.
     *
     */
    public void testMouseReleasedMouseEvent_1() {
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.NORTH, new Point(1, 1));

        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 10, 100, 1, false);

        event.setSource(corner);

        listener.mouseReleased(event);

        assertEquals("Equal is expected.", Cursor.getDefaultCursor(), corner.getCursor());
    }

    /**
     * Test method <code>void mouseReleased(MouseEvent e) </code>.
     *
     */
    public void testMouseReleasedMouseEvent_2() {
        listener.mouseReleased(null);
    }

    /**
     * Test method <code>void mouseReleased(MouseEvent e) </code>.
     *
     */
    public void testMouseReleasedMouseEvent_3() {
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.NORTH, new Point(1, 1));

        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 10, 100, 1, false);

        listener.mouseReleased(event);
    }

    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     *
     */
    public void testMouseDragged_1() {
        listener.mouseDragged(null);
    }


    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     *
     */
    public void testMouseDragged_2() {
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.NORTH, new Point(1, 1));

        MouseEvent event = new MouseEvent(corner, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 10, 100, 1, false);

        listener.mouseDragged(event);
    }


    /**
     * Test method <code>void mouseDragged(MouseEvent e) </code>.
     *
     * <p>
     * This test case is a bit complex, since we can not retrieve the SelectionBoundEvent, a simple listener class
     * is mocked for testing. The mocked class MyCornerDragListener will store the SelectionBoundEvent instance
     * and retrieved back for testing.
     * </p>
     *
     */
    public void testMouseDragged_3() {
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.NORTH, new Point(1, 1));

        MouseEvent pressEvent = new MouseEvent(corner, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 1, 2, 1, false, MouseEvent.BUTTON1);

        listener.mousePressed(pressEvent);

        MouseEvent dragEvent = new MouseEvent(corner, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 5, 10, 1, false, MouseEvent.BUTTON1);


        MyCornerDragListener cornerDragListener = new MyCornerDragListener();

        node.addCornerDragListener(cornerDragListener);

        node.setSelectionBound(new Rectangle(1, 2, 5, 15));

        listener.mouseDragged(dragEvent);

        SelectionBoundEvent e =  cornerDragListener.getSelectionBoundEvent();

        assertEquals("Equal is expected.", node, e.getSource());

        // verify the old bound if successful.
        assertEquals("Equal is expected.", new Rectangle(1, 2, 5, 15), e.getOldBound());

        // verify the new bound.
        assertEquals("The x should be 1.", 1, e.getNewBound().x);
        assertEquals("The Y should be 10.", 10, e.getNewBound().y);
    }
}
