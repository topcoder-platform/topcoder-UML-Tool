/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>SelectionBoundEvent </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestSelectionBoundEventAccuracy extends TestCase {

    /**
     * Represents the SelectionBoundEvent instance for testing.
     */
    private SelectionBoundEvent event = null;

    /**
     * Represents the old bound.
     */
    private Rectangle old = null;

    /**
     * Represents the new bound.
     */
    private Rectangle n = null;

    /**
     * Represents the Node instance for testing.
     */
    private Node node = null;

    /**
     * Set up.
     */
    public void setUp() {
        node = new MyNode(new GraphNode(), new Point(1, 100), new Rectangle(1, 2, 10, 100),
                Helper.getCollection());

        old = new Rectangle(1, 2, 3 , 4);
        n = new Rectangle(10, 20, 30, 40);
        event = new SelectionBoundEvent(node, old, n);
    }

    /**
     * Test the constructor.
     *
     */
    public void testSelectionBoundEvent() {
        assertNotNull("Should not be null.", event);
    }

    /**
     * Test method <code>Rectangle getOldBound() </code>.
     *
     */
    public void testGetOldBound() {
        Rectangle r = event.getOldBound();

        assertEquals("Equal is expected.", old, r);
    }

    /**
     * Test method <code>Rectangle getNewBound() </code>.
     *
     */
    public void testGetNewBound() {
        assertEquals("Equal is expected.", n, event.getNewBound());
    }

    /**
     * Test method <code>int getNorthOffset() </code>.
     *
     */
    public void testGetNorthOffset() {
        assertEquals("Equal is expected.", 18, event.getNorthOffset());
    }

    /**
     * Test method <code>int getSouthOffset() </code>.
     *
     */
    public void testGetSouthOffset() {
        assertEquals("Equal is expected.", 54, event.getSouthOffset());
    }

    /**
     * Test method <code>int getWestOffset() </code>.
     *
     */
    public void testGetWestOffset() {
        assertEquals("Equal is expected.", 9, event.getWestOffset());
    }

    /**
     * Test method <code>int getEastOffset() </code>.
     *
     */
    public void testGetEastOffset() {
        assertEquals("Equal is expected.", 36, event.getEastOffset());
    }
}
