/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.GraphConnector;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for GraphConnector class.
 *
 * @author iamajia
 * @version 1.0
 */
public class GraphConnectorFailureTest extends TestCase {
    /**
     * Represents a {@link GraphConnector} instance that is used in the test.
     */
    private GraphConnector graphConnector = new GraphConnector();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(GraphConnectorFailureTest.class);
    }

    /**
     * Failure test of <code>addGraphEdge(GraphEdge graphEdge)</code> method.
     *
     * <p>
     * graphEdge is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddGraphEdgeFailureNullGraphEdge() throws Exception {
        try {
            graphConnector.addGraphEdge(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeGraphEdge(GraphEdge graphEdge)</code> method.
     *
     * <p>
     * graphEdge is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveGraphEdgeFailureNullGraphEdge() throws Exception {
        try {
            graphConnector.removeGraphEdge(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsGraphEdge(GraphEdge graphEdge)</code> method.
     *
     * <p>
     * graphEdge is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsGraphEdgeFailureNullGraphEdge() throws Exception {
        try {
            graphConnector.containsGraphEdge(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
