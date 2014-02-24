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
import com.topcoder.gui.diagramviewer.uml.classedges.DependencyEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;



/**
 * Failure test case of <code>DependencyEdge</code> class.
 *
 *
 * @author still
 * @version 1.0
 */
public class DependencyEdgeFailureTest extends TestCase {
    /** DependencyEdge instance used in failure test. */
    private DependencyEdge edge;

    /** GraphEdge used in DependencyEdge. */
    private GraphEdge graphEdge;

    /**
     * Test suite of DependencyEdge.
     *
     * @return Test suite of DependencyEdge.
     */
    public static Test suite() {
        return new TestSuite(DependencyEdgeFailureTest.class);
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

        Dependency dependency = new DependencyImpl();

        Uml1SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();
        semanticModel.setElement(dependency);
        graphEdge.setSemanticModel(semanticModel);

        edge = new DependencyEdge(graphEdge);
    }


    /**
     * <p>
     * Test of DependencyEdge(GraphEdge) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null GraphEdge.
     * @throws Exception to JUnit
     */
    public void testDependencyEdgeForException() throws Exception {
        try {
            new DependencyEdge(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of DependencyEdge(GraphEdge) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering GraphEdge with not enough contained elements.
     * @throws Exception to JUnit
     */
    public void testDependencyEdgeForException1() throws Exception {
        try {
            graphEdge = new GraphEdge();
            graphEdge.addWaypoint(new Point());
            graphEdge.addWaypoint(new Point());

            new DependencyEdge(graphEdge);
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of DependencyEdge(GraphEdge) for IllegalGraphElementException.
     * </p>
     * IllegalGraphElementException must be thrown when encountering GraphEdge with less than 2 way points.
     * @throws Exception to JUnit
     */
    public void testDependencyEdgeForException2() throws Exception {
        try {
            graphEdge = new GraphEdge();
            graphEdge.addContained(new GraphNode());
            graphEdge.addContained(new GraphNode());


            new DependencyEdge(graphEdge);
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
            semanticModelBridge.setElement(new Element() { });
            edge.getGraphEdge().setSemanticModel(semanticModelBridge);
            edge.notifyGraphEdgeChange("graph edge has been changed.");
            // should not be here
            fail("IllegalGraphElementException expected.");
        } catch (IllegalGraphElementException e) {
            // should be here
        }
    }
}
