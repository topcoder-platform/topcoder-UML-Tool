/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * RemovePolylineActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.diagram.RemovePolylineAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;

/**
 * <p>
 * This is a failure tests for <code>RemovePolylineAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class RemovePolylineActionFailureTest extends TestCase {

    /**Polyline GraphEdge that is used for testing.*/
    private GraphEdge polylineGraphEdge;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        Helper.clearNamespace();
        Helper.initNamespace();

        polylineGraphEdge = new GraphEdge();
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor RemovePolylineAction(polylineGraphEdge) if polylineGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNull() {
        try {
            new RemovePolylineAction(null);
            fail("IllegalArgumentException is expected because polylineGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor RemovePolylineAction(polylineGraphEdge) if polylineGraphEdge
     * doesn't contain a Polyline object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNotContainedPolylineObject() {
        try {
            new RemovePolylineAction(polylineGraphEdge);
            fail("IllegalArgumentException is expected because polylineGraphEdge must contain a Polyline "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}