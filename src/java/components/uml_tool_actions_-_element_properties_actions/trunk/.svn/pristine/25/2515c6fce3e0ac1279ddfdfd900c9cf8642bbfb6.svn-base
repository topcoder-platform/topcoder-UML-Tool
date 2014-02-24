/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;

/**
 * Aggregates all failure tests for ChangeRelationshipPathAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeRelationshipPathActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeRelationshipPathAction(GraphEdge, List).
     * Failure testing of exception in case edge is null.
     */
    public final void testChangeRelationshipPathActionFailureEdgeNull() {
        try {
            new ChangeRelationshipPathAction(null, new ArrayList<Point>());
            fail("IllegalArgumentException is expected since edge is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeRelationshipPathAction(GraphEdge , List).
     * Failure testing of exception in case waypoints is null.
     */
    public final void testChangeRelationshipPathActionFailureRelationshipWaypointsNull() {
        try {
            new ChangeRelationshipPathAction(new GraphEdge() {
            }, null);
            fail("IllegalArgumentException is expected since waypoints is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}