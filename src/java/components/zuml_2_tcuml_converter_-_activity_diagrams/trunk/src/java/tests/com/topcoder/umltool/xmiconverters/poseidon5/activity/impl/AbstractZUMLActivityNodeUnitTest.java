/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;


/**
 * <p>
 * Unit tests for <code>AbstractZUMLActivityNode</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class AbstractZUMLActivityNodeUnitTest extends TestCase {
    /**
     * <p>The AbstractZUMLActivityEdge instance for test.</p>
     */
    private AbstractZUMLActivityNode node;

    /**
     * <p>Set up the environment.</p>
     */
    protected void setUp() {
        node = new MockZUMLActivityNode();
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(AbstractZUMLActivityNodeUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>AbstractZUMLActivityNode()</code>.
     * </p>
     *
     * <p>
     * Verify that the incomingEdges and outgoingEdges are initialized as empty list.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Unable to create MockZUMLActivityNode instance.", node);

        assertTrue("The default incomingEdges is empty.",
            node.getIncomingEdges().isEmpty());
        assertTrue("The default outgoingEdges is empty.",
            node.getOutgoingEdges().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>getIncomingEdges()</code>.
     * </p>
     *
     * <p>
     * Verfiy that the returned list has the same elements to the node has.
     * </p>
     */
    public void testGetIncomingEdges_Accuracy1() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge1);

        ZUMLActivityEdge edge2 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge2);

        List<ZUMLActivityEdge> list = node.getIncomingEdges();

        assertEquals("The returned list should have 2 elements.", 2, list.size());
        assertEquals("The edge should match.", edge1, list.get(0));
        assertEquals("The edge should match.", edge2, list.get(1));
    }

    /**
     * <p>
     * Accuracy test for <code>getIncomingEdges()</code>.
     * </p>
     *
     * <p>
     * Verfiy that the returned list is a shadow copy of the original list.
     * </p>
     */
    public void testGetIncomingEdges_Accuracy2() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge1);

        ZUMLActivityEdge edge2 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge2);

        List<ZUMLActivityEdge> list = node.getIncomingEdges();

        //It should not change the original list.
        list.clear();

        assertEquals("The original list should not be changed.", 2,
            node.getIncomingEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addIncomingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that the edge is added to the node successfully.
     * </p>
     */
    public void testAddIncomingEdge_Accuracy1() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge1);
        assertEquals("The size of the list is 1 now.", 1,
            node.getIncomingEdges().size());

        ZUMLActivityEdge edge2 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge2);
        assertEquals("The size of the list is 2 now.", 2,
            node.getIncomingEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addIncomingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that duplicated edge can be added successfully.
     * </p>
     */
    public void testAddIncomingEdge_Accuracy2() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addIncomingEdge(edge1);
        assertEquals("The size of the list is 1 now.", 1,
            node.getIncomingEdges().size());

        node.addIncomingEdge(edge1);
        assertEquals("The size of the list is 2 now.", 2,
            node.getIncomingEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>addIncomingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the edge to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddIncomingEdge_Failure() {
        try {
            node.addIncomingEdge(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>addIncomingEdges(ZUMLActivityEdge[])</code>.
     * </p>
     * <p>
     * Verify that the array is added to the incoming edges.
     * </p>
     */
    public void testAddIncomingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addIncomingEdges(edges);
        assertEquals("The incoming edges should have 2 elements now.", 2,
            node.getIncomingEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>addIncomingEdges(ZUMLActivityEdge[])</code>.
     * </p>
     * <p>
     * Failure cause: If the array to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddIncomingEdges_Failure1() {
        try {
            node.addIncomingEdges(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>addIncomingEdges(ZUMLActivityEdge[])</code>.
     * </p>
     * <p>
     * Failure cause: If the array to be added contains null elements, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddIncomingEdges_Failure2() {
        try {
            ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
            edges[0] = new MockZUMLActivityEdge();
            edges[1] = null;

            node.addIncomingEdges(edges);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeIncomingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that the existed edge is removed successfully.
     * </p>
     */
    public void testRemoveIncomingEdge_Accuracy1() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addIncomingEdges(edges);

        node.removeIncomingEdge(edges[1]);
        assertEquals("The incoming edges should have 1 element now.", 1,
            node.getIncomingEdges().size());

        node.removeIncomingEdge(edges[0]);
        assertTrue("The incoming edges should have 0 element now.",
            node.getIncomingEdges().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>removeIncomingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that removing unexisted edge from the node doesn't have any effect to the node.
     * </p>
     */
    public void testRemoveIncomingEdge_Accuracy2() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addIncomingEdges(edges);

        node.removeIncomingEdge(new MockZUMLActivityEdge());
        assertEquals("The incoming edges should not change.", 2,
            node.getIncomingEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>removeIncomingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the edge to be removed is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveIncomingEdge_Failure() {
        try {
            node.removeIncomingEdge(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>clearIncomingEdges()</code>.
     * </p>
     *
     * <p>
     * Verify that all the edges are removed from the node.
     * </p>
     */
    public void testClearIncomingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addIncomingEdges(edges);

        node.clearIncomingEdges();
        assertTrue("The incoming edges should be cleared.",
            node.getIncomingEdges().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>getOutgoingEdges()</code>.
     * </p>
     *
     * <p>
     * Verfiy that the returned list has the same elements to the node has.
     * </p>
     */
    public void testGetOutgoingEdges_Accuracy1() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge1);

        ZUMLActivityEdge edge2 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge2);

        List<ZUMLActivityEdge> list = node.getOutgoingEdges();

        assertEquals("The returned list should have 2 elements.", 2, list.size());
        assertEquals("The edge should match.", edge1, list.get(0));
        assertEquals("The edge should match.", edge2, list.get(1));
    }

    /**
     * <p>
     * Accuracy test for <code>getOutgoingEdges()</code>.
     * </p>
     *
     * <p>
     * Verfiy that the returned list is a shadow copy of the original list.
     * </p>
     */
    public void testGetOutgoingEdges_Accuracy2() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge1);

        ZUMLActivityEdge edge2 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge2);

        List<ZUMLActivityEdge> list = node.getOutgoingEdges();

        //It should not change the original list.
        list.clear();

        assertEquals("The original list should not be changed.", 2,
            node.getOutgoingEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addOutgoingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that the edge is added to the node successfully.
     * </p>
     */
    public void testAddOutgoingEdge_Accuracy1() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge1);
        assertEquals("The size of the list is 1 now.", 1,
            node.getOutgoingEdges().size());

        ZUMLActivityEdge edge2 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge2);
        assertEquals("The size of the list is 2 now.", 2,
            node.getOutgoingEdges().size());
    }

    /**
     * <p>
     * Accuracy test for <code>addOutgoingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that duplicated edge can be added successfully.
     * </p>
     */
    public void testAddOutgoingEdge_Accuracy2() {
        ZUMLActivityEdge edge1 = new MockZUMLActivityEdge();
        node.addOutgoingEdge(edge1);
        assertEquals("The size of the list is 1 now.", 1,
            node.getOutgoingEdges().size());

        node.addOutgoingEdge(edge1);
        assertEquals("The size of the list is 2 now.", 2,
            node.getOutgoingEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>addOutgoingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the edge to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOutgoingEdge_Failure() {
        try {
            node.addOutgoingEdge(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>addOutgoingEdges(ZUMLActivityEdge[])</code>.
     * </p>
     * <p>
     * Verify that the array is added to the outgoing edges.
     * </p>
     */
    public void testAddOutgoingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addOutgoingEdges(edges);
        assertEquals("The outgoing edges should have 2 elements now.", 2,
            node.getOutgoingEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>addOutgoingEdges(ZUMLActivityEdge[])</code>.
     * </p>
     * <p>
     * Failure cause: If the array to be added is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOutgoingEdges_Failure1() {
        try {
            node.addOutgoingEdges(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>addOutgoingEdges(ZUMLActivityEdge[])</code>.
     * </p>
     * <p>
     * Failure cause: If the array to be added contains null elements, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddOutgoingEdges_Failure2() {
        try {
            ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
            edges[0] = new MockZUMLActivityEdge();
            edges[1] = null;

            node.addOutgoingEdges(edges);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>removeOutgoingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that the existed edge is removed successfully.
     * </p>
     */
    public void testRemoveOutgoingEdge_Accuracy1() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addOutgoingEdges(edges);

        node.removeOutgoingEdge(edges[1]);
        assertEquals("The outgoing edges should have 1 element now.", 1,
            node.getOutgoingEdges().size());

        node.removeOutgoingEdge(edges[0]);
        assertTrue("The outgoing edges should have 0 element now.",
            node.getOutgoingEdges().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>removeOutgoingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Verify that removing unexisted edge from the node doesn't have any effect to the node.
     * </p>
     */
    public void testRemoveOutgoingEdge_Accuracy2() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addOutgoingEdges(edges);

        node.removeOutgoingEdge(new MockZUMLActivityEdge());
        assertEquals("The outgoing edges should not change.", 2,
            node.getOutgoingEdges().size());
    }

    /**
     * <p>
     * Failure test for <code>removeOutgoingEdge(ZUMLActivityEdge)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the edge to be removed is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveOutgoingEdge_Failure() {
        try {
            node.removeOutgoingEdge(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>clearOutgoingEdges()</code>.
     * </p>
     *
     * <p>
     * Verify that all the edges are removed from the node.
     * </p>
     */
    public void testClearOutgoingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new MockZUMLActivityEdge();
        edges[1] = new MockZUMLActivityEdge();

        node.addOutgoingEdges(edges);

        node.clearOutgoingEdges();
        assertTrue("The outgoing edges should be cleared.",
            node.getOutgoingEdges().isEmpty());
    }
}
