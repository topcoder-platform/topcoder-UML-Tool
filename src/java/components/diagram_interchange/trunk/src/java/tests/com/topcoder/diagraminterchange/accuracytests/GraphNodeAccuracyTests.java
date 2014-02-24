/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ GraphNodeAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>GraphNode</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>GraphNode</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class GraphNodeAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>GraphNode</code> used for tests.
     * </p>
     */
    private GraphNode test = null;

    /**
     * <p>
     * Test suite of <code>GraphNodeAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>GraphNodeAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphNodeAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new GraphNode();
    }

    /**
     * <p>
     * Accuracy Test of the <code>GraphNode()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new GraphNode());

        // get the original value of size to check the constructor
        assertNull("The size expected to be null", test.getSize());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setSize(Dimension)</code> method and
     * <code>getSize()</code>.
     * </p>
     */
    public void testDimension_Operation() {
        // creat a new instance of Dimension.
        Dimension dimension = new Dimension();

        // set the size.
        test.setSize(dimension);

        // get the size.
        assertEquals("The size expected to be equal", dimension, test.getSize());

        // set the size to null.
        test.setSize(null);

        // get the size.
        assertNull("The size expected to be null", test.getSize());
    }
}
