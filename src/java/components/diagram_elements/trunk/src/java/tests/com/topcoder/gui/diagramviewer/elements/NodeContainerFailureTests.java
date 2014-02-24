/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;

/**
 * <p>
 * This class aggregates failure tests for NodeContainer abstract class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class NodeContainerFailureTests extends TestCase {

    /**
     * A NodeContainer used for testing purposes.
     */
    private NodeContainer test;

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
        test = new MockNodeContainerFailure(graphNode, position, bound, corners);
    }

    /**
     * Tests constructor with null graphNode argument. IllegalArgumentException is expected.
     */
    public void testNodeContainer_NullGraphNodeArgument() {
        try {
            new MockNodeContainerFailure(null, position, bound, corners);
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
    public void testNodeContainer_NullPositionArgument() {
        try {
            new MockNodeContainerFailure(graphNode, null, bound, corners);
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
    public void testNodeContainer_NullBoundArgument() {
        try {
            new MockNodeContainerFailure(graphNode, position, null, corners);
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
    public void testNodeContainer_NullCornersArgument() {
        try {
            new MockNodeContainerFailure(graphNode, position, bound, null);
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
    public void testNodeContainer_NullElementInCorners1() {
        corners.add(null);
        try {
            new MockNodeContainerFailure(graphNode, position, bound, corners);
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
    public void testNodeContainer_NullElementInCorners2() {
        corners.add(SelectionCornerType.EAST);
        corners.add(null);
        try {
            new MockNodeContainerFailure(graphNode, position, bound, corners);
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
    public void testNodeContainer_DuplicatedElementInCorners1() {
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.EAST);
        try {
            new MockNodeContainerFailure(graphNode, position, bound, corners);
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
    public void testNodeContainer_DuplicatedElementInCorners2() {
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.WEST);
        try {
            new MockNodeContainerFailure(graphNode, position, bound, corners);
            fail("Did not throw IAE with duplicated element in corners argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests addNode(String, Node) method with null compartment argument. IllegalArgumentException is expected.
     */
    public void testAddNodeStringNode_NullCompartmentArgument() {
        try {
            test.addNode(null, test);
            fail("Did not throw IAE with null compartment argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests addNode(String, Node) method with null node argument. IllegalArgumentException is expected.
     */
    public void testAddNodeStringNode_NullNodeArgument() {
        try {
            test.addNode("test", null);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests removeNode(String, Node) method with null compartment argument. IllegalArgumentException is expected.
     */
    public void testRemoveNodeStringNode_NullCompartmentArgument() {
        try {
            test.removeNode(null, test);
            fail("Did not throw IAE with null compartment argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests removeNode(String, Node) method with null node argument. IllegalArgumentException is expected.
     */
    public void testRemoveNodeStringNode_NullNodeArgument() {
        try {
            test.removeNode("test", null);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests clearNodes(String) method with null compartment argument. IllegalArgumentException is expected.
     */
    public void testClearNodesString_NullCompartmentArgument() {
        try {
            test.clearNodes(null);
            fail("Did not throw IAE with null compartment argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests getNodes(String) method with null compartment argument. IllegalArgumentException is expected.
     */
    public void testGetNodesString_NullCompartmentArgument() {
        try {
            test.getNodes(null);
            fail("Did not throw IAE with null compartment argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests addNode(Node) method with null node argument. IllegalArgumentException is expected.
     */
    public void testAddNodeNode_NullNodeArgument() {
        try {
            test.addNode(null);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests removeNode(Node) method with null node argument. IllegalArgumentException is expected.
     */
    public void testRemoveNodeNode_NullNodeArgument() {
        try {
            test.removeNode(null);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }

    /**
     * Tests removeCompartment with null compartment argument. IllegalArgumentException is expected.
     */
    public void testRemoveCompartment_NullCompartmentArgument() {
        try {
            test.removeCompartment(null);
            fail("Did not throw IAE with null compartment argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }
}
