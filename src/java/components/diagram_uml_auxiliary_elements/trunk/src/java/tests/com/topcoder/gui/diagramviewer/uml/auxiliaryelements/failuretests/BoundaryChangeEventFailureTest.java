/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import java.awt.Rectangle;

import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.*;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>BoundaryChangeEvent</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class BoundaryChangeEventFailureTest extends TestCase {

    /**
     * <p>
     * The Node instance for helping testing.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * The Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle oldBoundary;

    /**
     * <p>
     * The Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle newBoundary;

    /**
     * <p>
     * The String instance for helping testing.
     * </p>
     */
    private String message;

    /**
     * <p>
     * The DiagramViewer instance for helping testing.
     * </p>
     */
    private DiagramViewer viewer;

    /**
     * <p>
     * The DiagramView instance for helping testing.
     * </p>
     */
    private DiagramView view;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        node = new PolylineNode(new Polyline(), new PropertyMapping());
        oldBoundary = new Rectangle();
        newBoundary = new Rectangle();
        message = "message";
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        node = null;
        oldBoundary = null;
        newBoundary = null;
        message = null;
    }

    /**
     * <p>
     * Tests constructor BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle
     * newBoundary) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBoundaryChangeEventNodeCtor1() throws Exception {
        try {
            new BoundaryChangeEvent(null, oldBoundary, newBoundary);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle
     * newBoundary) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBoundaryChangeEventNodeCtor2() throws Exception {
        try {
            new BoundaryChangeEvent(node, null, newBoundary);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle
     * newBoundary) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBoundaryChangeEventNodeCtor3() throws Exception {
        try {
            new BoundaryChangeEvent(node, oldBoundary, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle
     * newBoundary, String message) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBoundaryChangeEventNodeCtor4() throws Exception {
        try {
            new BoundaryChangeEvent(null, oldBoundary, newBoundary, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
    
    /**
     * <p>
     * Tests constructor BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle
     * newBoundary, String message) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBoundaryChangeEventNodeCtor5() throws Exception {
        try {
            new BoundaryChangeEvent(node, null, newBoundary, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
    
    /**
     * <p>
     * Tests constructor BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle
     * newBoundary, String message) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testBoundaryChangeEventNodeCtor6() throws Exception {
        try {
            new BoundaryChangeEvent(node, oldBoundary, null, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
}
