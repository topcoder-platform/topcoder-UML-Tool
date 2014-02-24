/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;

import junit.framework.TestCase;

/**
 * Test cases for class <code>NodeContainer </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestNodeContainerAccuracy extends TestCase {
    /**
     * Represents the NodeContainer instance for testing.
     */
    private NodeContainer container = null;

    /**
     * Represents the Node instance for testing.
     */
    private Node node = null;

    /**
     * Set up.
     */
    public void setUp() {
        container = new MyNodeContainer(new GraphNode(), new Point(1, 100), new Rectangle(1, 2, 10, 100), Helper
                .getCollection());

        node = new MyNodeContainer(new GraphNode(), new Point(1, 2), new Rectangle(10, 20, 100, 1000), Helper
                .getCollection());
    }

    /**
     * Test the constructor.
     *
     */
    public void testNodeContainer() {
        assertNotNull("Should not be null.", container);
    }

    /**
     * Test method <code>boolean addNode(String compartment, Node node) </code>.
     *
     */
    public void testAddNodeStringNode() {
        assertTrue("Add should be ok.", container.addNode("test", node));

        // add again.
        assertFalse("Already added.", container.addNode("test", node));

        // Create a new Node instance and try to add again.
        node = new MyNodeContainer(new GraphNode(), new Point(10, 20), new Rectangle(10, 20, 100, 1000), Helper
                .getCollection());
        assertTrue("Add should be ok.", container.addNode("test", node));
    }

    /**
     * Test method <code>boolean removeNode(String compartment, Node node) </code>.
     *
     */
    public void testRemoveNodeStringNode() {
        // for an unknown compartment return false.
        assertFalse("false is expected.", container.removeNode("test", node));

        container.addNode("test", node);
        assertTrue("True is expected.", container.removeNode("test", node));
    }

    /**
     * Test method <code>void clearNodes(String compartment) </code>.
     *
     */
    public void testClearNodesString() {
        assertTrue("True is expected.", container.addNode("test", node));
        // clear the compartment.
        container.clearNodes("test");

        // try to add it again, should be ok.
        assertTrue("True is expected.", container.addNode("test", node));
    }

    /**
     * Test method <code>Set<Node> getNodes(String compartment) </code>.
     *
     */
    public void testGetNodesString() {
        assertTrue("True is expected.", container.addNode("test", node));

        Set<Node> nodes = container.getNodes("test");
        assertEquals("The size should be 1.", 1, nodes.size());
        assertTrue("Should contain.", nodes.contains(node));
    }

    /**
     * Test method <code>boolean addNode(Node node) </code>.
     *
     */
    public void testAddNodeNode() {
        assertTrue("True is expected.", container.addNode(node));
        assertFalse("False is expected when add it again.", container.addNode(node));
    }

    /**
     * Test method <code>boolean removeNode(Node node) </code>.
     *
     */
    public void testRemoveNodeNode() {
        assertTrue("True is expected.", container.addNode(node));
        assertFalse("False is expected when add it again.", container.addNode(node));

        container.removeNode(node);
        assertTrue("True is expected.", container.addNode(node));
    }

    /**
     * Test method <code>void clearNodes() </code>.
     *
     */
    public void testClearNodes() {
        assertTrue("True is expected.", container.addNode(node));
        assertFalse("False is expected when add it again.", container.addNode(node));

        container.clearNodes();
        assertTrue("True is expected.", container.addNode(node));
    }

    /**
     * Test method <code>Set<Node> getNodes() </code>.
     *
     */
    public void testGetNodes() {
        assertTrue("True is expected.", container.addNode(node));
        Set<Node> nodes = container.getNodes();
        assertTrue("True is expected.", nodes.size() == 1);
        assertTrue("True is expected.", nodes.contains(node));
    }

    /**
     * Test method <code>Set<String> getCompartments() </code>.
     *
     */
    public void testGetCompartments() {
        Set<String> con = container.getCompartments();
        assertTrue("Now is empty.", con.isEmpty());

        container.addNode("test", node);
        container.addNode("stress", node);
        container.addNode("accuracy", node);

        con = container.getCompartments();
        assertEquals("The size should be 3.", 3, con.size());
        assertTrue("True is expected.", con.contains("test"));
        assertTrue("True is expected.", con.contains("stress"));
        assertTrue("True is expected.", con.contains("accuracy"));

    }

    /**
     * Test method <code> void clearCompartments() </code>.
     *
     */
    public void testClearCompartments() {
        Set<String> con = container.getCompartments();
        assertTrue("Now is empty.", con.isEmpty());

        container.addNode("test", node);
        container.addNode("stress", node);
        container.addNode("accuracy", node);

        con = container.getCompartments();
        assertEquals("The size should be 3.", 3, con.size());
        assertTrue("True is expected.", con.contains("test"));
        assertTrue("True is expected.", con.contains("stress"));
        assertTrue("True is expected.", con.contains("accuracy"));

        container.clearCompartments();
        con = container.getCompartments();
        assertTrue("Now is empty.", con.isEmpty());
    }

    /**
     * Test method <code>Set<Node> removeCompartment(String compartment)  </code>.
     *
     */
    public void testRemoveCompartment() {
        container.addNode("test", node);
        container.addNode("stress", node);
        container.addNode("accuracy", node);

        Set<Node> nodes = container.removeCompartment("test");
        assertTrue("True is expected.", nodes.contains(node));

        Set<String> con = container.getCompartments();
        assertTrue("The size should be 2.", 2 == con.size());
        assertFalse("Should not contain 'test'", con.contains("test"));
    }

    /**
     * Test method <code> Set<Node> getAllNodes() </code>.
     *
     */
    public void testGetAllNodes() {
        container.addNode("test", node);
        container.addNode("stress", node);
        container.addNode("accuracy", node);

        Set<Node> nodes = container.getAllNodes();
        assertTrue("True is expected.", 1 == nodes.size());

        Node otherNode = new MyNodeContainer(new GraphNode(), new Point(10, 20), new Rectangle(10, 20, 100, 1000),
                Helper.getCollection());

        container.addNode("other", otherNode);
        nodes = container.getAllNodes();

        assertEquals("Should be 2.", 2, nodes.size());
        assertTrue("True is expected.", nodes.contains(node));
        assertTrue("True is expected.", nodes.contains(otherNode));

    }
}
