/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityDiagram;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy test for the class AbstractZUMLActivityDiagram.
 *
 * @author KLW
 * @version 1.0
 */
public class AbstractZUMLActivityDiagramAccuracyTests extends TestCase {
    /**
     * the AbstractZUMLActivityDiagram instance for accuracy tests.
     */
    private AbstractZUMLActivityDiagram instance;

    /**
     * set up the test environment.
     */
    protected void setUp() {
        instance = new ZUMLActivityDiagramImpl();
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
        assertTrue("The nodes list should empty.", instance.getNodes().isEmpty());
        assertTrue("The edges list should empty.", instance.getEdges().isEmpty());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#getNodes()}.
     *
     */
    public void testGetNodes() {
        assertTrue("The nodes list should empty.", instance.getNodes().isEmpty());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#addNode(ZUMLActivityNode)}.
     */
    public void testAddNode() {
        ZUMLActivityNode node = new ZUMLInitialNodeImpl();
        instance.addNode(node);
        assertEquals(1, instance.getNodes().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#addNodes(ZUMLActivityNode[])}.
     */
    public void testAddNodes() {
        ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
        nodes[0] = new ZUMLInitialNodeImpl();
        nodes[1] = new ZUMLInitialNodeImpl();
        instance.addNodes(nodes);
        assertEquals(2, instance.getNodes().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#removeNode(ZUMLActivityNode)}.
     */
    public void testRemoveNode() {
        ZUMLActivityNode node = new ZUMLInitialNodeImpl();
        instance.addNode(node);
        assertEquals(1, instance.getNodes().size());
        instance.removeNode(node);
        assertEquals(0, instance.getNodes().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#clearNodes()}.
     */
    public void testClearNodes() {
        ZUMLActivityNode[] nodes = new ZUMLActivityNode[2];
        nodes[0] = new ZUMLInitialNodeImpl();
        nodes[1] = new ZUMLInitialNodeImpl();
        instance.addNodes(nodes);
        assertEquals(2, instance.getNodes().size());
        instance.clearNodes();
        assertEquals(0, instance.getNodes().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#getEdges()}.
     *
     */
    public void testGetEdges() {
        assertTrue("The nodes list should empty.", instance.getEdges().isEmpty());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#addEdge(ZUMLActivityEdge)}.
     */
    public void testAddEdge() {
        ZUMLActivityEdge node = new ZUMLActivityEdgeImpl();
        instance.addEdge(node);
        assertEquals(1, instance.getEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#addEdges(ZUMLActivityEdge[])}.
     */
    public void testAddEdges() {
        ZUMLActivityEdge[] nodes = new ZUMLActivityEdge[2];
        nodes[0] = new ZUMLActivityEdgeImpl();
        nodes[1] = new ZUMLActivityEdgeImpl();
        instance.addEdges(nodes);
        assertEquals(2, instance.getEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#removeEdge(ZUMLActivityEdge)}.
     */
    public void testRemoveEdge() {
        ZUMLActivityEdge node = new ZUMLActivityEdgeImpl();
        instance.addEdge(node);
        assertEquals(1, instance.getEdges().size());
        instance.removeEdge(node);
        assertEquals(0, instance.getEdges().size());
    }

    /**
     * the accuracy test for the method {@link AbstractZUMLActivityDiagram#clearEdges()}.
     */
    public void testClearEdges() {
        ZUMLActivityEdge[] nodes = new ZUMLActivityEdge[2];
        nodes[0] = new ZUMLActivityEdgeImpl();
        nodes[1] = new ZUMLActivityEdgeImpl();
        instance.addEdges(nodes);
        assertEquals(2, instance.getEdges().size());
        instance.clearEdges();
        assertEquals(0, instance.getEdges().size());
    }
}
