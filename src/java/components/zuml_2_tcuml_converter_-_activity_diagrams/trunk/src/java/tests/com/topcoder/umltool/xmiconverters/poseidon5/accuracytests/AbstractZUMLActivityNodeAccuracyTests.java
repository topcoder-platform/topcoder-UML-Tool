/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLAcceptEventActionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl;

import junit.framework.TestCase;


/**
 * The accuracy test for the class AbstractZUMLActivityNode.
 *
 * @author KLW
 * @version 1.0
 */
public class AbstractZUMLActivityNodeAccuracyTests extends TestCase {
    /**
     * the AbstractZUMLActivityNode instance for accuracy tests.
     */
    private AbstractZUMLActivityNode instance;

    /**
     * set up the test environment.
     */
    protected void setUp() {
        instance = new ZUMLAcceptEventActionImpl();
    }

    /**
     * tear down the test environment.
     */
    protected void tearDown() {
        instance = null;
    }

    /**
     * the accuracy test for the constructor.
     *
     */
    public void testCtor() {
        assertNotNull("The instance should not be null.", instance);
        assertTrue("The list should empty.", instance.getIncomingEdges().isEmpty());
        assertTrue("The list should empty.", instance.getOutgoingEdges().isEmpty());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#getIncomingEdges()}.
     *
     */
    public void testGetIncomingEdges() {
        assertTrue("The nodes list should empty.", instance.getIncomingEdges().isEmpty());
    }

    /**
     * the accuracy test for the method
     * {@link AbstractZUMLActivityNode#addIncomingEdge(
     * com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge)}.
     */
    public void testAddIncomingEdge() {
        ZUMLActivityEdge edge = new ZUMLActivityEdgeImpl();
        instance.addIncomingEdge(edge);
        assertEquals(1, instance.getIncomingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#addIncomingEdges(ZUMLActivityEdge[])}.
     */
    public void testAddIncomingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();
        instance.addIncomingEdges(edges);
        assertEquals(2, instance.getIncomingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#removeIncomingEdge(ZUMLActivityEdge)}.
     */
    public void testRemoveIncomingEdge() {
        ZUMLActivityEdge edge = new ZUMLActivityEdgeImpl();
        instance.addIncomingEdge(edge);
        assertEquals(1, instance.getIncomingEdges().size());
        instance.removeIncomingEdge(edge);
        assertEquals(0, instance.getIncomingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#clearIncomingEdges()}.
     */
    public void testClearIncomingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();
        instance.addIncomingEdges(edges);
        assertEquals(2, instance.getIncomingEdges().size());
        instance.clearIncomingEdges();
        assertEquals(0, instance.getIncomingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#getOutgoingEdges()}.
     *
     */
    public void testGetOutgoingEdges() {
        assertTrue("The nodes list should empty.", instance.getOutgoingEdges().isEmpty());
    }

    /**
     * the accuracy test for the method
     * {@link AbstractZUMLActivityNode#addOutgoingEdge(
     * com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge)}.
     */
    public void testAddOutgoingEdge() {
        ZUMLActivityEdge edge = new ZUMLActivityEdgeImpl();
        instance.addOutgoingEdge(edge);
        assertEquals(1, instance.getOutgoingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#addOutgoingEdges(ZUMLActivityEdge[])}.
     */
    public void testAddOutgoingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();
        instance.addOutgoingEdges(edges);
        assertEquals(2, instance.getOutgoingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#removeOutgoingEdge(ZUMLActivityEdge)}.
     */
    public void testRemoveOutgoingEdge() {
        ZUMLActivityEdge edge = new ZUMLActivityEdgeImpl();
        instance.addOutgoingEdge(edge);
        assertEquals(1, instance.getOutgoingEdges().size());
        instance.removeOutgoingEdge(edge);
        assertEquals(0, instance.getOutgoingEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityNode#clearOutgoingEdges()}.
     */
    public void testClearOutgoingEdges() {
        ZUMLActivityEdge[] edges = new ZUMLActivityEdge[2];
        edges[0] = new ZUMLActivityEdgeImpl();
        edges[1] = new ZUMLActivityEdgeImpl();
        instance.addOutgoingEdges(edges);
        assertEquals(2, instance.getOutgoingEdges().size());
        instance.clearOutgoingEdges();
        assertEquals(0, instance.getOutgoingEdges().size());
    }
}
