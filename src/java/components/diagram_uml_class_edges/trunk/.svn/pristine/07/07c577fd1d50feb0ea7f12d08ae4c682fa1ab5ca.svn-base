/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.BindingImpl;


/**
 * Failure test case of <code>AbstractionEdge</code> class.
 *
 *
 * @author still
 * @version 1.0
 */
public class AbstractionEdgeFailureTest extends TestCase {
    /** AbstractionEdge instance used in failure test. */
    private AbstractionEdge edge;

    /** GraphEdge used in AbstractionEdge. */
    private GraphEdge graphEdge;

    /**
     * Test suite of AbstractionEdge.
     *
     * @return Test suite of AbstractionEdge.
     */
    public static Test suite() {
        return new TestSuite(AbstractionEdgeFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        // set up for test
        graphEdge = new GraphEdge();
        graphEdge.addWaypoint(new Point());
        graphEdge.addWaypoint(new Point());

        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();

        node1.setPosition(new Point());
        node1.setSize(new Dimension());

        node2.setPosition(new Point());
        node2.setSize(new Dimension());

        graphEdge.addContained(node1);
        graphEdge.addContained(node2);

        Abstraction abstraction = new AbstractionImpl();

        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(abstraction);
        graphEdge.setSemanticModel(semanticModel);

        edge = new AbstractionEdge(graphEdge);
    }


    /**
     * <p>
     * Test of AbstractionEdge(GraphEdge) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphEdge.
     *
     * @throws Exception to JUnit
     */
    public void testAbstractionEdgeForException1() throws Exception {
        try {
            new AbstractionEdge(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of AbstractionEdge(GraphEdge) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering GraphEdge with not enough contained elements.
     *
     * @throws Exception to JUnit
     */
    public void testAbstractionEdgeForException2() throws Exception {
        try {
            graphEdge = new GraphEdge();
            graphEdge.addWaypoint(new Point());
            graphEdge.addWaypoint(new Point());

            new AbstractionEdge(graphEdge);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of AbstractionEdge(GraphEdge) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering GraphEdge with less than 2 way points.
     *
     * @throws Exception to JUnit
     */
    public void testAbstractionEdgeForException3() throws Exception {
        try {
            graphEdge = new GraphEdge();
            graphEdge.addContained(new GraphNode());
            graphEdge.addContained(new GraphNode());


            new AbstractionEdge(graphEdge);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of notifyGraphEdgeChange(String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null message.
     *
     * @throws Exception to JUnit
     */
    public void testNotifyGraphEdgeChangeForException1() throws Exception {
        try {
            edge.notifyGraphEdgeChange(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * <p>
     * Test of notifyGraphEdgeChange(String) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering invalid SemanticModelBridge structure.
     */
    public void testNotifyGraphEdgeChangeForException2() {
        Uml1SemanticModelBridge semanticModelBridge = new Uml1SemanticModelBridge();
        try {
            edge.getGraphEdge().setSemanticModel(null);
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
        try {
            edge.getGraphEdge().setSemanticModel(semanticModelBridge);
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
        try {
            semanticModelBridge.setElement(new BindingImpl());
            edge.getGraphEdge().setSemanticModel(semanticModelBridge);
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }
}
