/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS GraphConnector_Interchange Version 1.0 Accuracytests.
 *
 * @ GraphConnectorAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;


/**
 * <p>
 * The <code>GraphConnector</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>GraphConnector</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class GraphConnectorAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>GraphConnector</code> used for tests.
     * </p>
     */
    private GraphConnector test = null;

    /**
     * <p>
     * Test suite of <code>GraphConnectorAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>GraphConnectorAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphConnectorAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new GraphConnector();
    }

    /**
     * <p>
     * Accuracy Test of the <code>GraphConnector()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new GraphConnector());

        // get the original value of position to check the constructor
        assertNull("The position expected to be null", test.getPosition());

        // get the original value of graphElement to check the constructor
        assertNull("The graphElement expected to be null",
            test.getGraphElement());

        // get the original value of graphEdges collection to check the constructor
        assertEquals("The graphEdges collection expected to be empty", 0,
            test.countGraphEdges());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setPosition(Point)</code> method and
     * <code>getPosition()</code>.
     * </p>
     */
    public void testPosition_Operation() {
        // creat a new point.
        Point point = new Point();

        // set the position.
        test.setPosition(point);

        // get the position.
        assertEquals("The position expected to be equal", point,
            test.getPosition());

        // set the position to null.
        test.setPosition(null);
        assertNull("The position expected to be null", test.getPosition());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setGraphElement(GraphElement)</code> method and
     * <code>getGraphElement()</code>.
     * </p>
     */
    public void testGraphElement_Operation() {
        // creat a new GraphElement.
        GraphElement element = new GraphEdge();

        // set the graphElement.
        test.setGraphElement(element);

        // get the graphElement.
        assertEquals("The graphElement expected to be equal", element,
            test.getGraphElement());

        // set the graphElement to null.
        test.setGraphElement(null);
        assertNull("The graphElement expected to be null",
            test.getGraphElement());
    }

    /**
     * <p>
     * Accuracy Test of the diagramLinks correlative method, such like :
     * <code>addGraphEdge(GraphEdge)</code> method, <code>getGraphEdges()</code> and also other method.
     * </p>
     */
    public void testGraphEdges_Operation() {
        // creat some new GraphEdges.
        GraphEdge graphEdge = new GraphEdge();
        GraphEdge graphEdge2 = new GraphEdge();

        // add the graphEdge.
        test.addGraphEdge(graphEdge);

        // get the elements of graphEdges collection to test.
        assertEquals("The graphEdges collection expected to be 1 element", 1,
            test.countGraphEdges());
        assertTrue("The graphEdges expected to be in the collection",
            test.containsGraphEdge(graphEdge));

        // get a copy of the collection.
        Collection <GraphEdge> newGraphEdges = test.getGraphEdges();

        // get the elements of graphEdges collection to test.
        assertEquals("The graphEdges collection expected to be 1 element", 1,
            newGraphEdges.size());
        assertTrue("The graphEdges expected to be in the collection",
            newGraphEdges.contains(graphEdge));

        // clear the new collection.
        newGraphEdges.clear();

        // still one element in graphEdges collection.
        assertEquals("The graphEdges collection expected to be 1 element", 1,
            test.countGraphEdges());

        // non exist eiement can not be removed.
        assertFalse("The graphEdges can not be removed",
            test.removeGraphEdge(graphEdge2));
        assertTrue("The graphEdges expected to be removed",
            test.removeGraphEdge(graphEdge));

        // add the graphEdge then clear it.
        test.addGraphEdge(graphEdge);
        test.clearGraphEdges();

        // get the elements of graphEdges collection to test.
        assertEquals("The graphEdges collection expected to be empty", 0,
            test.countGraphEdges());
    }
}
