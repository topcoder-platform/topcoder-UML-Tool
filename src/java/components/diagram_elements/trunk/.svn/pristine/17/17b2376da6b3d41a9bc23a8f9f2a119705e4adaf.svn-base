/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;

/**
 * Unit test for the <code>NodeContainer</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class NodeContainerUnitTests extends TestCase {

    /**
     * Represents the mock node container class used for test.
     */
    private class MockNodeContainer extends NodeContainer {

        /**
         * <p>
         * Constructs a <code>MockNodeContainer</code> instance.
         * </p>
         *
         * @param graphNode
         *            the <code>GraphNode</code> instance associated to this node
         * @param position
         *            the relative position of visual node
         * @param bound
         *            the selection bound of corners
         * @param corners
         *            all the supported selection corners
         * @throws IllegalArgumentException
         *             if <code>graphNode</code>, <code>position</code>, <code>bound</code> or <code>corners</code>
         *             is null, or <code>corners</code> contains null element or duplicated elements
         */
        public MockNodeContainer(GraphNode graphNode, Point position, Rectangle bound,
                Collection<SelectionCornerType> corners) {
            super(graphNode, position, bound, corners);
        }

        /**
         * Simply return false.
         *
         * @param event
         *            ignore
         * @return always false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }
    }

    /**
     * Represents the mock node class used for test.
     */
    private class MockNode extends Node {

        /**
         * <p>
         * Constructs a <code>MockNode</code> instance.
         * </p>
         *
         * @param graphNode
         *            the <code>GraphNode</code> instance associated to this node
         * @param position
         *            the relative position of visual node
         * @param bound
         *            the selection bound of corners
         * @param corners
         *            all the supported selection corners
         * @throws IllegalArgumentException
         *             if <code>graphNode</code>, <code>position</code>, <code>bound</code> or <code>corners</code>
         *             is null, or <code>corners</code> contains null element or duplicated elements
         */
        public MockNode(GraphNode graphNode, Point position, Rectangle bound, Collection<SelectionCornerType> corners) {
            super(graphNode, position, bound, corners);
        }

        /**
         * Simply return false.
         *
         * @param event
         *            ignore
         * @return always false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }
    }

    /**
     * Represents the <code>GraphNode</code> instance used for test.
     */
    private final GraphNode graphNode = new GraphNode();

    /**
     * Represents the <code>Point</code> instance used for test.
     */
    private final Point position = new Point(100, 200);

    /**
     * Represents the <code>Rectangle</code> instance used for test.
     */
    private final Rectangle bound = new Rectangle(50, 150, 100, 100);

    /**
     * Represents the <code>SelectionCornerType</code> collection used for test.
     */
    private Collection<SelectionCornerType> corners;

    /**
     * Represents the <code>MockNodeContainer</code> instance used to test against.
     */
    private MockNodeContainer container = null;

    /**
     * Represents the <code>Node</code> collection used for test.
     */
    private Node nodeA = null;

    /**
     * Represents the <code>Node</code> collection used for test.
     */
    private Node nodeB = null;

    /**
     * Represents the <code>Node</code> collection used for test.
     */
    private Node nodeC = null;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        corners = new ArrayList<SelectionCornerType>();
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.NORTHEAST);
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.SOUTHEAST);
        corners.add(SelectionCornerType.SOUTHWEST);

        container = new MockNodeContainer(graphNode, position, bound, corners);

        nodeA = new MockNode(graphNode, position, bound, corners);
        nodeB = new MockNode(graphNode, position, bound, corners);
        nodeC = new MockNode(graphNode, position, bound, corners);

        container.addNode("ComA", nodeA);
        container.addNode("ComB", nodeB);
        container.addNode(nodeB);
    }

    /**
     * Test for the inheritance, <code>NodeContainer</code> class should extend from the <code>Node</code> class.
     */
    public void testInheritanceFromNode() {
        assertTrue("NodeContainer class should extend from the Node class.",
            Node.class.isAssignableFrom(NodeContainer.class));
    }

    /**
     * Test the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code> with null
     * <code>graphNode</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullGraphNode() {
        try {
            new MockNodeContainer(null, position, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code> with null
     * <code>position</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullPosition() {
        try {
            new MockNodeContainer(graphNode, null, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code> with null
     * <code>bound</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullBound() {
        try {
            new MockNodeContainer(graphNode, position, null, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code> with null
     * <code>corners</code>, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullCorners() {
        try {
            new MockNodeContainer(graphNode, position, bound, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code> with invalid
     * <code>corners</code> which contains null, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithInvalidCornersContainNull() {
        corners.add(null);
        try {
            new MockNodeContainer(graphNode, position, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code> with invalid
     * <code>corners</code> which contains duplicated elements, IllegalArgumentException should be thrown.
     */
    public void testConstructorWithInvalidCornersContainDuplicate() {
        corners.add(SelectionCornerType.EAST);
        try {
            new MockNodeContainer(graphNode, position, bound, corners);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the constructor <code>NodeContainer(GraphNode, Point, Rectangle, Collection)</code>,
     * instance should be created.
     */
    public void testConstructorAccuracy() {
        NodeContainer n = new MockNodeContainer(graphNode, position, bound, corners);
        assertNotNull("NodeContainer instance should be created.", n);
        assertTrue("The graphNode field should be set.",
            TestHelper.getPrivateField(Node.class, n, "graphNode").equals(graphNode));
        assertTrue("The relativePosition field should be set.",
            TestHelper.getPrivateField(Node.class, n, "relativePosition").equals(position));
        assertTrue("The selectionBound field should be set.",
            TestHelper.getPrivateField(Node.class, n, "selectionBound").equals(bound));
        assertTrue("MouseListener should be registered.", n.getMouseListeners().length == 1);
        assertTrue("MouseMotionListener should be registered.", n.getMouseMotionListeners().length == 1);
        // validate corners
        Collection<SelectionCorner> c
            = (Collection<SelectionCorner>) TestHelper.getPrivateField(Node.class, n, "corners");
        assertTrue("The corners should contain eight elements.", corners.size() == 8);
        for (SelectionCorner corner : c) {
            assertTrue("MouseListener should be registered.", corner.getMouseListeners().length == 1);
            assertTrue("MouseMotionListener should be registered.", corner.getMouseMotionListeners().length == 1);
        }
    }

    /**
     * Test the method <code>addNode(String, Node)</code> with null <code>compartment</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testAddNodeWithNullCompartment() {
        try {
            container.addNode(null, nodeC);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>addNode(String, Node)</code> with null <code>node</code>, IllegalArgumentException should
     * be thrown.
     */
    public void testAddNodeWithNullNode() {
        try {
            container.addNode("ComC", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>addNode(String, Node)</code> when the node does not exist, the node should
     * be added to the given compartment, true should be returned.
     */
    public void testAddNodeWhenInexistAccuracy() {
        Map<String, Set<Node>> compartments
            = (Map<String, Set<Node>>) TestHelper.getPrivateField(NodeContainer.class, container, "compartments");

        assertTrue("True should be returned.", container.addNode("ComA", nodeB));
        assertTrue("The node should be added.", compartments.get("ComA").contains(nodeB));

        // the compartment dose not exist before
        assertTrue("True should be returned.", container.addNode("ComC", nodeC));
        assertTrue("The node should be added.", compartments.get("ComC").contains(nodeC));
    }

    /**
     * Accuracy test for the method <code>addNode(String, Node)</code> when the node exists, the node should not be
     * added, false should be returned.
     */
    public void testAddNodeWhenExistAccuracy() {
        assertFalse("False should be returned.", container.addNode("ComA", nodeA));
    }

    /**
     * Test the method <code>removeNode(String, Node)</code> with null <code>compartment</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveNodeWithNullCompartment() {
        try {
            container.removeNode(null, nodeA);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>removeNode(String, Node)</code> with null <code>node</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testRemoveNodeWithNullNode() {
        try {
            container.removeNode("ComA", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>removeNode(String, Node)</code> when the node does not exist, false should
     * be returned.
     */
    public void testRemoveNodeWhenInexistAccuracy() {
        assertFalse("False should be returned.", container.removeNode("ComA", nodeB));
        // the compartment dose not exist before
        assertFalse("False should be returned.", container.removeNode("ComC", nodeA));
    }

    /**
     * Accuracy test for the method <code>removeNode(String, Node)</code> when the node exists, the node should be
     * removed from the given compartment, true should be returned.
     */
    public void testRemoveNodeWhenExistAccuracy() {
        assertTrue("True should be returned.", container.removeNode("ComA", nodeA));
        Map<String, Set<Node>> compartments
            = (Map<String, Set<Node>>) TestHelper.getPrivateField(NodeContainer.class, container, "compartments");
        assertFalse("The node should be removed.", compartments.get("ComA").contains(nodeA));
    }

    /**
     * Test the method <code>clearNodes(String)</code> with null <code>compartment</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testClearNodesWithNullCompartment() {
        try {
            container.clearNodes(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>clearNodes(String)</code>, all nodes in the given compartment should be
     * cleared.
     */
    public void testClearNodesAccuracy() {
        container.clearNodes("ComA");
        Map<String, Set<Node>> compartments
            = (Map<String, Set<Node>>) TestHelper.getPrivateField(NodeContainer.class, container, "compartments");
        assertTrue("The nodes should be cleared.", compartments.get("ComA").isEmpty());
    }

    /**
     * Test the method <code>getNodes(String)</code> with null <code>compartment</code>, IllegalArgumentException
     * should be thrown.
     */
    public void testGetNodesWithNullCompartment() {
        try {
            container.getNodes(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>getNodes(String)</code> when the compartment exists, all nodes in the given
     * compartment should be returned.
     */
    public void testGetNodesAccuracy() {
        Set<Node> nodes = container.getNodes("ComA");
        assertTrue("The nodes set should contain one node.", nodes.size() == 1);
        assertTrue("The content of nodes set should be correct.", nodes.contains(nodeA));
    }

    /**
     * Accuracy test for the method <code>getNodes(String)</code> when the compartment dose not exist, null should be
     * returned.
     */
    public void testGetNodesInexistentAccuracy() {
        assertNull("Null should be returned.", container.getNodes("ComC"));
    }

    /**
     * Test the method <code>addNode(Node)</code> with null <code>node</code>, IllegalArgumentException should be
     * thrown.
     */
    public void testAddNodeDirectWithNullNode() {
        try {
            container.addNode(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>addNode(Node)</code> when the node does not exist, the node should be added,
     * true should be returned.
     */
    public void testAddNodeDirectWhenInexistAccuracy() {
        assertTrue("True should be returned.", container.addNode(nodeC));
        assertTrue("The node should be added.",
            ((Set<Node>) TestHelper.getPrivateField(NodeContainer.class, container, "nodes")).contains(nodeC));
    }

    /**
     * Accuracy test for the method <code>addNode(Node)</code> when the node exists, the node should not be added,
     * false should be returned.
     */
    public void testAddNodeDirectWhenExistAccuracy() {
        assertFalse("False should be returned.", container.addNode(nodeB));
    }

    /**
     * Test the method <code>removeNode(Node)</code> with null <code>node</code>, IllegalArgumentException should be
     * thrown.
     */
    public void testRemoveNodeDirectWithNullNode() {
        try {
            container.removeNode(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>removeNode(Node)</code> when the node does not exist, false should be
     * returned.
     */
    public void testRemoveNodeDirectWhenInexistAccuracy() {
        assertFalse("False should be returned.", container.removeNode(nodeA));
    }

    /**
     * Accuracy test for the method <code>removeNode(Node)</code> when the node exists, the node should be removed,
     * true should be returned.
     */
    public void testRemoveNodeDirectWhenExistAccuracy() {
        assertTrue("True should be returned.", container.removeNode(nodeB));
        assertFalse("The node should be removed.",
            ((Set<Node>) TestHelper.getPrivateField(NodeContainer.class, container, "nodes")).contains(nodeB));
    }

    /**
     * Accuracy test for the method <code>clearNodes()</code>, all direct nodes should be cleared.
     */
    public void testClearNodesDirectAccuracy() {
        container.clearNodes();
        assertTrue("Nodes should be cleared.",
            ((Set<Node>) TestHelper.getPrivateField(NodeContainer.class, container, "nodes")).isEmpty());
    }

    /**
     * Accuracy test for the method <code>getNodes()</code>, all direct nodes should be returned.
     */
    public void testGetNodesDirectAccuracy() {
        Set<Node> nodes = container.getNodes();
        assertTrue("The nodes set should contain one node.", nodes.size() == 1);
        assertTrue("The content of nodes set should be correct.", nodes.contains(nodeB));
    }

    /**
     * Accuracy test for the method <code>getCompartments()</code>, all compartments should be returned.
     */
    public void testGetCompartmentsAccuracy() {
        Set<String> compartments = container.getCompartments();
        assertTrue("The compartments set should contain two compartments.", compartments.size() == 2);
        assertTrue("The content of compartments set should be correct.", compartments.contains("ComA"));
        assertTrue("The content of compartments set should be correct.", compartments.contains("ComB"));
    }

    /**
     * Accuracy test for the method <code>clearCompartments()</code>, all compartments should be cleared.
     */
    public void testClearCompartments() {
        container.clearCompartments();
        Map<String, Set<Node>> compartments
            = (Map<String, Set<Node>>) TestHelper.getPrivateField(NodeContainer.class, container, "compartments");
        assertTrue("All compartments should be cleared.", compartments.isEmpty());
    }

    /**
     * Test the method <code>removeCompartment(String)</code> with null <code>compartment</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testRemoveCompartmentWithNullCompartment() {
        try {
            container.removeCompartment(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the method <code>removeCompartment(String)</code>, the compartment should be removed.
     */
    public void testRemoveCompartmentAccuracy() {
        container.removeCompartment("ComA");
        Map<String, Set<Node>> compartments
            = (Map<String, Set<Node>>) TestHelper.getPrivateField(NodeContainer.class, container, "compartments");
        assertFalse("The compartment should be removed.", compartments.containsKey("ComA"));
    }

    /**
     * Accuracy test for the method <code>getAllNodes()</code>, all nodes should be returned.
     */
    public void testGetAllNodesAccuracy() {
        Set<Node> nodes = container.getAllNodes();
        assertTrue("The nodes set should contain two nodes.", nodes.size() == 2);
        assertTrue("The content of nodes set should be correct.", nodes.contains(nodeA));
        assertTrue("The content of nodes set should be correct.", nodes.contains(nodeB));
    }
}
