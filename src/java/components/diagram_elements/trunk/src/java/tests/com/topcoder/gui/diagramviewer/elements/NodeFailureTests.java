/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class aggregates failure tests for Node abstract class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class NodeFailureTests extends TestCase {

    /**
     * A Node used for testing purposes.
     */
    private Node test;

    /**
     * A GraphNode used for testing purposes.
     */
    private GraphNode graphNode;

    /**
     * A Point used for testing purposes.
     */
    private Point position = new Point(1, 1);

    /**
     * A Rectangle used for testing purposes.
     */
    private Rectangle bound = new Rectangle(1, 1, 5, 5);

    /**
     * A List used for testing purposes.
     */
    private List<SelectionCornerType> corners;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        graphNode = new GraphNode();
        corners = new ArrayList<SelectionCornerType>();
        test = new MockNodeFailure(graphNode, position, bound, corners);
    }

    /**
     * Tests constructor with null graphNode argument. IllegalArgumentException is expected.
     */
    public void testNode_NullGraphNodeArgument() {
        try {
            new MockNodeFailure(null, position, bound, corners);
            fail("Did not throw IAE with null graphNode argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null position argument. IllegalArgumentException is expected.
     */
    public void testNode_NullPositionArgument() {
        try {
            new MockNodeFailure(graphNode, null, bound, corners);
            fail("Did not throw IAE with null position argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null bound argument. IllegalArgumentException is expected.
     */
    public void testNode_NullBoundArgument() {
        try {
            new MockNodeFailure(graphNode, position, null, corners);
            fail("Did not throw IAE with null bound argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null corners argument. IllegalArgumentException is expected.
     */
    public void testNode_NullCornersArgument() {
        try {
            new MockNodeFailure(graphNode, position, bound, null);
            fail("Did not throw IAE with null corners argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null element in corners argument. IllegalArgumentException is expected.
     */
    public void testNode_NullElementInCorners1() {
        corners.add(null);
        try {
            new MockNodeFailure(graphNode, position, bound, corners);
            fail("Did not throw IAE with null element in corners argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with null element in corners argument. IllegalArgumentException is expected.
     */
    public void testNode_NullElementInCorners2() {
        corners.add(SelectionCornerType.EAST);
        corners.add(null);
        try {
            new MockNodeFailure(graphNode, position, bound, corners);
            fail("Did not throw IAE with null element in corners argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with duplicated element in corners argument. IllegalArgumentException is expected.
     */
    public void testNode_DuplicatedElementInCorners1() {
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.EAST);
        try {
            new MockNodeFailure(graphNode, position, bound, corners);
            fail("Did not throw IAE with duplicated element in corners argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests constructor with duplicated element in corners argument. IllegalArgumentException is expected.
     */
    public void testNode_DuplicatedElementInCorners2() {
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.WEST);
        try {
            new MockNodeFailure(graphNode, position, bound, corners);
            fail("Did not throw IAE with duplicated element in corners argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setRelativePosition method with null position argument. IllegalArgumentException is expected.
     */
    public void testSetRelativePosition_NullPositionArgument() {
        try {
            test.setRelativePosition(null);
            fail("Did not throw IAE with null position argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests setSelectionBound with null bound argument. IllegalArgumentException is expected.
     */
    public void testSetSelectionBound_NullBoundArgument() {
        try {
            test.setSelectionBound(null);
            fail("Did not throw IAE with null bound argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }
}
