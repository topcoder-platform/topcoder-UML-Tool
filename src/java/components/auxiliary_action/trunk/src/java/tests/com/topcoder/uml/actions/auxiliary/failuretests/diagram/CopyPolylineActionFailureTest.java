/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * CopyPolylineActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.diagram;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.*;
import com.topcoder.uml.actions.auxiliary.diagram.CopyPolylineAction;

/**
 * <p>
 * This is a failure tests for <code>CopyPolylineAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class CopyPolylineActionFailureTest extends TestCase {

    /**Polyline GraphEdge that is used for testing.*/
    private GraphEdge polylineGraphEdge;

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        polylineGraphEdge = new GraphEdge();
    }

    /**
     * <p>
     * Tests constructor CopyPolylineAction(polylineGraphEdge, clipboard) if polylineGraphEdge is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNull() {
        try {
            new CopyPolylineAction(null, null);
            fail("IllegalArgumentException is expected because polylineGraphEdge cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor CopyPolylineAction(polylineGraphEdge, clipboard) if polylineGraphEdge
     * doesn't contain a Polyline object in its contained attribute.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPolylineGraphEdgeNotContainedPolylineObject() {
        try {
            new CopyPolylineAction(polylineGraphEdge, null);
            fail("IllegalArgumentException is expected because polylineGraphEdge must contain a Polyline "
                    + "object in its contained attribute.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}