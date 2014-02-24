/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * ExtendEdgeFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.ExtendEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;

/**
 * <p>
 * This is a failure tests for <code>ExtendEdge</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class ExtendEdgeFailureTest extends TestCase {

    /**GraphEdge instance that is used for testing.*/
    private GraphEdge graphEdge;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        graphEdge = Helper.createGraphEdge();
    }

    /**
     * <p>
     * Tests constructor ExtendEdge(graphEdge) if graphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphEdgeNull() throws Exception {
        try {
            new ExtendEdge(null);
            fail("IllegalArgumentException is expected because graphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor ExtendEdge(graphEdge) if graphEdge does not contain two compartments.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphEdgeInvalid1() throws Exception {
        graphEdge.removeContained(1);
        try {
            new ExtendEdge(graphEdge);
            fail("IllegalGraphElementException is expected because GraphEdge is invalid.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor ExtendEdge(graphEdge) if graphEdge contains less than 2 waypoints.
     * IllegalGraphElementException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfGraphEdgeInvalid2() throws Exception {
        graphEdge.removeWaypoint(0);
        try {
            new ExtendEdge(graphEdge);
            fail("IllegalGraphElementException is expected because GraphEdge is invalid.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }
}