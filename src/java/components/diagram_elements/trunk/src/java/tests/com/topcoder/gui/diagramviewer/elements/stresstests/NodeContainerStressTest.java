/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


/**
 * <p>This class tests the <code>NodeContainer</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>NodeContainer</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class NodeContainerStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode graphNode = new GraphNode();

    /**
     * <p>The <code>Rectangle</code> instance used for test.</p>
     */
    private Rectangle bound = new Rectangle(50, 150, 100, 100);

    /**
     * <p>The <code>SelectionCornerType</code> collection used for test.</p>
     */
    private Collection<SelectionCornerType> corners = null;

    /**
     * <p>The instance of <code>NodeContainer</code> for test.</p>
     */
    private NodeContainer container = null;

    /**
     * <p>Return test suite of <code>NodeContainerStressTest</code>.</p>
     *
     * @return Test suite of <code>NodeContainerStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(NodeContainerStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create the SelectionCorner type here.
        corners = new ArrayList<SelectionCornerType>();
        corners.add(SelectionCornerType.EAST);
        corners.add(SelectionCornerType.SOUTH);
        corners.add(SelectionCornerType.WEST);
        corners.add(SelectionCornerType.NORTH);
        corners.add(SelectionCornerType.NORTHEAST);
        corners.add(SelectionCornerType.NORTHWEST);
        corners.add(SelectionCornerType.SOUTHEAST);
        corners.add(SelectionCornerType.SOUTHWEST);

        // create the NodeContainer here.
        container = new SimpleNodeContainer(graphNode, new Point(10, 20), bound, corners);
    }

    /**
     * <p>Basic stress test of <code>addNode(String compartment, Node node)</code> and
     * <code>addNode(Node node)</code> methods.</p>
     */
    public void testMethod_addNode() {
        // add some compartment nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;
            Point position = new Point(100 + i, 200);
            Node node = new SimpleNode(graphNode, position, bound, corners);

            assertTrue("The addNode method is incorrect", container.addNode(compartment, node));
            assertFalse("The addNode method is incorrect", container.addNode(compartment, node));
        }

        // add some direct nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            Point position = new Point(100, 200 + i);
            Node node = new SimpleNode(graphNode, position, bound, corners);

            assertTrue("The addNode method is incorrect", container.addNode(node));
        }
        
        assertEquals("The addNode method is incorrect.", 2 * LOOPTIMES,
                container.getAllNodes().size());

        // add some compartment nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;
            Point position = new Point(100, 200 - i);
            Node node = new SimpleNode(graphNode, position, bound, corners);

            assertTrue("The addNode method is incorrect", container.addNode(compartment, node));
        }

        //  add the duplicated direct nodes here.
        for (Node node : container.getNodes()) {
            assertFalse("The addNode method is incorrect", container.addNode(node));
        }

        // check the compartment nodes result here.
        Set<String> getCompartments = container.getCompartments();
        assertEquals("The addNode method is incorrect.", LOOPTIMES, getCompartments.size());

        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;

            Set<Node> getNodes = container.getNodes(compartment);
            assertEquals("The addNode method is incorrect.", 2, getNodes.size());

            for (Node node : getNodes) {
                assertEquals("The addNode method is incorrect.", 100 - i,
                    (node.getRelativePosition().y - node.getRelativePosition().x));
            }
        }

        // check the direct nodes result here.
        Set<Node> getNodes = container.getNodes();
        assertEquals("The addNode method is incorrect.", LOOPTIMES, getNodes.size());
        assertEquals("The addNode method is incorrect.", LOOPTIMES * 3,
            container.getAllNodes().size());

        // check the inexistent result here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment*" + i;
            assertNull("The addNode method is incorrect.", container.getNodes(compartment));
        }
    }

    /**
     * <p>Basic stress test of <code>removeNode(String compartment, Node node)</code> and
     * <code>removeNode(Node node)</code> methods.</p>
     */
    public void testMethod_removeNode() {
        ArrayList<Node> comNodeList = new ArrayList<Node>();
        ArrayList<Node> nodeList = new ArrayList<Node>();

        // add some compartment nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;

            Point position = new Point(100 + i, 200);
            Node node = new SimpleNode(graphNode, position, bound, corners);
            comNodeList.add(node);
            assertTrue("The addNode method is incorrect", container.addNode(compartment, node));

            position = new Point(100, 200 - i);
            node = new SimpleNode(graphNode, position, bound, corners);
            assertTrue("The addNode method is incorrect", container.addNode(compartment, node));
            comNodeList.add(node);
        }

        // add some direct nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            Point position = new Point(100, 200 + i);
            Node node = new SimpleNode(graphNode, position, bound, corners);
            nodeList.add(node);

            assertTrue("The addNode method is incorrect", container.addNode(node));
        }

        // remove the compartment nodes here.
        Set<String> getCompartments = container.getCompartments();
        assertEquals("The removeNode method is incorrect.", LOOPTIMES, getCompartments.size());

        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;

            Set<Node> getNodes = container.getNodes(compartment);
            assertEquals("The removeNode method is incorrect.", 2, getNodes.size());

            for (int j = 0; j < 2; j++) {
                assertTrue("The removeNode method is incorrect.",
                    container.removeNode(compartment, (Node) comNodeList.get((i * 2) + j)));
                assertFalse("The removeNode method is incorrect.",
                    container.removeNode(compartment, (Node) comNodeList.get((i * 2) + j)));
                assertEquals("The removeNode method is incorrect.", 1 - j,
                    container.getNodes(compartment).size());
            }
        }

        // empty compartment node set should not be removed.
        assertEquals("The removeNode method is incorrect.", LOOPTIMES,
            container.getCompartments().size());

        // remove the inexistent result here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment*" + i;
            assertFalse("The addNode method is incorrect.",
                container.removeNode(compartment, (Node) comNodeList.get(i)));
        }

        // remove the  direct nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            assertTrue("The removeNode method is incorrect.",
                container.removeNode((Node) nodeList.get(i)));
            assertFalse("The removeNode method is incorrect.",
                container.removeNode((Node) nodeList.get(i)));
        }

        assertEquals("The removeNode method is incorrect.", 0, container.getNodes().size());

        // check the inexistent result here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment*" + i;
            assertNull("The addNode method is incorrect.", container.getNodes(compartment));
        }
    }

    /**
     * <p>Basic stress test of <code>removeCompartment(String compartment)</code> method.</p>
     */
    public void testMethod_removeCompartment() {
        // add some compartment nodes here.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;
            Point position = new Point(100 + i, 200);
            Node node = new SimpleNode(graphNode, position, bound, corners);

            assertTrue("The addNode method is incorrect", container.addNode(compartment, node));
            assertFalse("The addNode method is incorrect", container.addNode(compartment, node));

            position = new Point(100, 200 - i);
            node = new SimpleNode(graphNode, position, bound, corners);
            assertTrue("The addNode method is incorrect", container.addNode(compartment, node));
        }

        assertEquals("The addNode method is incorrect.", 2 * LOOPTIMES,
            container.getAllNodes().size());

        // remove each compartment here and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            String compartment = "compartment#" + i;
            assertEquals("The addNode method is incorrect.", 2 * (LOOPTIMES - i),
                container.getAllNodes().size());

            Set<Node> removeNodes = container.removeCompartment(compartment);
            assertEquals("The removeCompartment method is incorrect.", 2, removeNodes.size());
            assertNull("The removeCompartment method is incorrect.", container.getNodes(compartment));
        }

        assertEquals("The addNode method is incorrect.", 0, container.getAllNodes().size());
    }
}
