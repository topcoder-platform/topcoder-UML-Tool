/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import junit.framework.TestCase;

/**
 * Test cases for class <code>DragEventAdapter </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestDragEventAdapterAccuracy extends TestCase {

    /**
     * Represents the DragEventAdapter instance for testing.
     */
    private MyDragEventAdapter t = null;

    /**
     * Set up.
     */
    public void setUp() {
        t = new MyDragEventAdapter();
    }

    /**
     * Test method <code>Point getLastPoint() </code>.
     *
     */
    public void testGetLastPoint_1() {
        assertNull("The lastPoint should be null.", t.getLastPoint());
    }

    /**
     * Test method <code>Point getLastPoint() </code>.
     *
     */
    public void testGetLastPoint_2() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 1000, 5000, 50, true);

        t.mousePressed(event);
        Point p = t.getLastPoint();
        assertNotNull("Should not be null.", p);
        assertEquals("Equal is expected.", 1000.0, p.getX());
        assertEquals("Equal is expected.", 5000.0, p.getY());

    }

    /**
     * Test method <code> void setLastPoint(Point lastPoint) </code>.
     *
     */
    public void testSetLastPoint_1() {
        t.setLastPoint(null);
        assertNull("The lastPoint should be null.", t.getLastPoint());
    }

    /**
     * Test method <code> void setLastPoint(Point lastPoint) </code>.
     *
     */
    public void testSetLastPoint_2() {
        t.setLastPoint(new Point(1000, 5000));
        Point p = t.getLastPoint();
        assertNotNull("Should not be null.", p);
        assertEquals("Equal is expected.", 1000.0, p.getX());
        assertEquals("Equal is expected.", 5000.0, p.getY());
    }

    /**
     * Test method <code>void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_1() {
        t.mouseDragged(null);
        assertNull("The lastPoint should be null.", t.getLastPoint());
    }

    /**
     * Test method <code>void mousePressed(MouseEvent e) </code>.
     *
     */
    public void testMousePressedMouseEvent_2() {
        MouseEvent event = new MouseEvent(new JButton(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                MouseEvent.BUTTON1_MASK, 1, 2, 50, true);

        t.mousePressed(event);
        Point p = t.getLastPoint();
        assertNotNull("Should not be null.", p);
        assertEquals("Equal is expected.", 1.0, p.getX());
        assertEquals("Equal is expected.", 2.0, p.getY());

    }
}
