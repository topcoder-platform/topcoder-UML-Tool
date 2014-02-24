/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * Unit tests for <code>AbstractZUMLActivityDiagram</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class AbstractZUMLActivityDiagramUnitTest extends TestCase {
    /**
     * <p>The AbtractZUMLActivityDiagram instance to test.</p>
     */
    private AbstractZUMLActivityDiagram diagram;

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(AbstractZUMLActivityDiagramUnitTest.class);
    }

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        diagram = new MockZUMLActivityDiagram();
    }

    /**
     * <p>
     * Accuracy test for constructor <code>AbstractZUMLActivityDiagram()</code>.
     * </p>
     *
     * <p>
     * Verify that the nodes and edges are initialized as empty list.
     * </p>
     */
    public void testCtor() {
        diagram = new MockZUMLActivityDiagram();

        assertNotNull("Unable to create MockZUMLActivityDiagram instance.",
            diagram);

        assertTrue("The nodes list is empty.", diagram.getNodes().isEmpty());
        assertTrue("The edges list is empty.", diagram.getEdges().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>getNodes()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned list should contain the same element as the Diagram has.
     * </p>
     */
    public void testGetNodes_Accuracy1() {
        ZUMLActivityNode node1 = new ZUMLInitialNodeImpl();
        diagram.addNode(node1);

        ZUMLActivityNode node2 = new ZUMLInitialNodeImpl();
        diagram.addNode(node2);

        List<ZUMLActivityNode> list = diagram.getNodes();
        assertEquals("The returned list should have 2 elements.", 2, list.size());
        assertEquals("The node should match.", node1, list.get(0));
        assertEquals("The node should match.", node2, list.get(1));
    }

    /**
     * <p>
     * Accuracy test for <code>getNodes()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned list is a shadow copy of the original list.
     * </p>
     */
    public void testGetNodes_Accuracy2() {
        ZUMLActivityNode node1 = new ZUMLInitialNodeImpl();
        diagram.addNode(node1);

        ZUMLActivityNode node2 = new ZUMLInitialNodeImpl();
        diagram.addNode(node2);

        List<ZUMLActivityNode> list = diagram.getNodes();
        assertEquals("The returned list should have 2 elements.", 2, list.size());

        list.clear();
        assertEquals("The original list should not change.", 2,
            diagram.getNodes().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addNode(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Verify that the node is added to the list.
     * </p>
     */
    public void testAddNode_Accuracy1() {
        assertEquals("The list's size is 0 now.", 0, diagram.getNodes().size());

        ZUMLActivityNode node1 = new ZUMLInitialNodeImpl();
        diagram.addNode(node1);
        assertEquals("The list's size is 1 now.", 1, diagram.getNodes().size());

        ZUMLActivityNode node2 = new ZUMLInitialNodeImpl();
        diagram.addNode(node2);
        assertEquals("The list's size is 2 now.", 2, diagram.getNodes().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addNode(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Verify that duplicated node can be added successfully.
     * </p>
     */
    public void testAddNode_Accuracy2() {
        assertEquals("The list's size is 0 now.", 0, diagram.getNodes().size());

        ZUMLActivityNode node1 = new ZUMLInitialNodeImpl();
        diagram.addNode(node1);
        assertEquals("The list's size is 1 now.", 1, diagram.getNodes().size());

        //Add a duplicated node
        diagram.addNode(node1);
        assertEquals("The list's size is 2 now.", 2, diagram.getNodes().size());
    }

    /**
     * <p>
     * Failure test for <code>addNode(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the node to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddNode_Failure() {
        try {
            diagram.addNode(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>addNodes(ZUMLActivityNode[] nodes)</code>.
     * </p>
     *
     * <p>
     * Verify that the array is added to the list.
     * </p>
     */
    public void testAddNodes_Accuracy() {
        ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
        nodes[0] = new ZUMLInitialNodeImpl();
        nodes[1] = new ZUMLInitialNodeImpl();

        diagram.addNodes(nodes);
        assertEquals("The array should be added to the list.", 2,
            diagram.getNodes().size());
    }

    /**
     * <p>
     * Failure test for <code>addNodes(ZUMLActivityNode[] nodes)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddNodes_Failure1() {
        try {
            diagram.addNodes(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>addNodes(ZUMLActivityNode[] nodes)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array to be added contains null element, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddNodes_Failure2() {
        try {
            ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
            nodes[0] = new ZUMLInitialNodeImpl();
            nodes[1] = null;

            diagram.addNodes(nodes);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeNode(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Verify that the specified existed node is removed successfully.
     * </p>
     */
    public void testRemoveNode_Accuracy1() {
        ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
        nodes[0] = new ZUMLInitialNodeImpl();
        nodes[1] = new ZUMLInitialNodeImpl();

        diagram.addNodes(nodes);

        diagram.removeNode(nodes[0]);
        assertEquals("The list's size should be 1 now.", 1,
            diagram.getNodes().size());

        diagram.removeNode(nodes[1]);
        assertEquals("The list's size should be 0 now.", 0,
            diagram.getNodes().size());
    }

    /**
     * <p>
     * Accuracy test for <code>removeNode(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Verify that removing an unexisted node doesn't have any effect.
     * </p>
     */
    public void testRemoveNode_Accuracy2() {
        ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
        nodes[0] = new ZUMLInitialNodeImpl();
        nodes[1] = new ZUMLInitialNodeImpl();

        diagram.addNodes(nodes);

        diagram.removeNode(new ZUMLInitialNodeImpl());
        assertEquals("The list should not change.", 2, diagram.getNodes().size());
    }

    /**
     * <p>
     * Failure test for <code>removeNode(ZUMLActivityNode)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the node to be removed is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveNode_Failure() {
        try {
            diagram.removeNode(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>clearNodes()</code>.
     * </p>
     *
     * <p>
     * Verify that all the nodes in the list are removed.
     * </p>
     */
    public void testClearNodes() {
        ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
        nodes[0] = new ZUMLInitialNodeImpl();
        nodes[1] = new ZUMLInitialNodeImpl();

        diagram.addNodes(nodes);

        diagram.clearNodes();
        assertTrue("The nodes are cleared.", diagram.getNodes().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>getEdges()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned list should contain the same element as the Diagram has.
     * </p>
     */
    public void testGetEdges_Accuracy1() {
        ZUMLActivityEdge edge1 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge1);

        ZUMLActivityEdge edge2 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge2);

        List<ZUMLActivityEdge> list = diagram.getEdges();
        assertEquals("The returned list should have 2 elements.", 2, list.size());
        assertEquals("The edge should match.", edge1, list.get(0));
        assertEquals("The edge should match.", edge2, list.get(1));
    }

    /**
     * <p>
     * Accuracy test for <code>getEdges()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned list is a shadow copy of the original list.
     * </p>
     */
    public void testGetEdges_Accuracy2() {
        ZUMLActivityEdge edge1 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge1);

        ZUMLActivityEdge edge2 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge2);

        List<ZUMLActivityEdge> list = diagram.getEdges();
        assertEquals("The returned list should have 2 elements.", 2, list.size());

        list.clear();
        assertEquals("The original list should not change.", 2,
            diagram.getEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that the edge is added to the list.
     * </p>
     */
    public void testAddEdge_Accuracy1() {
        assertEquals("The list's size is 0 now.", 0, diagram.getEdges().size());

        ZUMLActivityEdge edge1 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge1);
        assertEquals("The list's size is 1 now.", 1, diagram.getEdges().size());

        ZUMLActivityEdge edge2 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge2);
        assertEquals("The list's size is 2 now.", 2, diagram.getEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that duplicated edge can be added successfully.
     * </p>
     */
    public void testAddEdge_Accuracy2() {
        assertEquals("The list's size is 0 now.", 0, diagram.getEdges().size());

        ZUMLActivityEdge edge1 = new ZUMLActivityEdgeImpl();
        diagram.addEdge(edge1);
        assertEquals("The list's size is 1 now.", 1, diagram.getEdges().size());

        //Add a duplicated edge
        diagram.addEdge(edge1);
        assertEquals("The list's size is 2 now.", 2, diagram.getEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>addEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the edge to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddEdge_Failure() {
        try {
            diagram.addEdge(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>addEdges(ZUMLActivityEdge[])</code>.
     * </p>
     *
     * <p>
     * Verify that the array is added to the list.
     * </p>
     */
    public void testAddEdges_Accuracy() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();

        diagram.addEdges(edges);
        assertEquals("The array should be added to the list.", 2,
            diagram.getEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>addEdges(ZUMLActivityEdge[])</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddEdges_Failure1() {
        try {
            diagram.addEdges(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>addEdges(ZUMLActivityEdge[])</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array to be added contains null element, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddEdges_Failure2() {
        try {
            ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
            edges[0] = new ZUMLActivityEdgeImpl();
            edges[1] = null;

            diagram.addEdges(edges);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that the specified existed edge is removed successfully.
     * </p>
     */
    public void testRemoveEdge_Accuracy1() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();

        diagram.addEdges(edges);

        diagram.removeEdge(edges[0]);
        assertEquals("The list's size should be 1 now.", 1,
            diagram.getEdges().size());

        diagram.removeEdge(edges[1]);
        assertEquals("The list's size should be 0 now.", 0,
            diagram.getEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>removeEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that removing an unexisted edge doesn't have any effect.
     * </p>
     */
    public void testRemoveEdge_Accuracy2() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();

        diagram.addEdges(edges);

        diagram.removeEdge(new ZUMLActivityEdgeImpl());
        assertEquals("The list should not change.", 2, diagram.getEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>removeEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the edge to be removed is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveEdge_Failure() {
        try {
            diagram.removeEdge(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>clearEdges()</code>.
     * </p>
     *
     * <p>
     * Verify that all the edges in the list are removed.
     * </p>
     */
    public void testClearEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();

        diagram.addEdges(edges);

        diagram.clearEdges();
        assertTrue("The edges are cleared.", diagram.getEdges().isEmpty());
    }
}
