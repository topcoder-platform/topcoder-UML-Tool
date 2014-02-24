/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeRelationshipPathAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeRelationshipPathActionUnitTests extends TestCase {
    /**
     * Represents the ChangeRelationshipPathAction instance used for tests.
     */
    private ChangeRelationshipPathAction testChangeRelationshipPathAction;

    /**
     * Represents the edge to change the path.
     */
    private GraphEdge edge;

    /**
     * Represents the new waypoints of the edge after this action performed.
     */
    private List<Point> newWaypoints;

    /**
     * Represents the old waypoints of the edge before this action performed.
     */
    private List<Point> oldWaypoints;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        edge = new GraphEdge();
        oldWaypoints = new ArrayList<Point>();
        newWaypoints = new ArrayList<Point>();
        for (int i = 0; i < 3; ++i) {
            Point point = new Point();
            edge.addWaypoint(point);
            oldWaypoints.add(point);
            newWaypoints.add(new Point());
        }
        testChangeRelationshipPathAction = new ChangeRelationshipPathAction(edge, newWaypoints);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The oldWaypoints should be set to
     * the GraphEdge.
     */
    public void testUndoAction() {
        assertEquals("ChangeRelationshipPathAction undoAction incorrectly", oldWaypoints, edge.getWaypoints());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The newWaypoints should be set to
     * the GraphEdge.
     */
    public void testRedoAction() {
        testChangeRelationshipPathAction.redoAction();
        assertEquals("ChangeRelationshipPathAction redoAction incorrectly", newWaypoints, edge.getWaypoints());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The newWaypoints should be set
     * to the GraphEdge.
     */
    public void testExecuteAction() {
        testChangeRelationshipPathAction.executeAction();
        assertEquals("ChangeRelationshipPathAction executeAction incorrectly", newWaypoints, edge.getWaypoints());
    }

    /**
     * Test ChangeRelationshipPathAction constructor.
     */
    public void testChangeRelationshipPathAction() {
        UndoableAbstractAction action = new ChangeRelationshipPathAction(edge, newWaypoints);
        assertNotNull("Create ChangeRelationshipPathAction incorrectly.", action);
        assertEquals("Create ChangeRelationshipPathAction incorrectly.", newWaypoints,
                UnitTestsHelper.getObjectFieldValue(action, "newWaypoints"));
        assertEquals("Create ChangeRelationshipPathAction incorrectly.", edge,
                UnitTestsHelper.getObjectFieldValue(action, "edge"));
    }

    /**
     * Test ChangeRelationshipPathAction constructor with null edge. Should throw
     * IllegalArgumentException.
     */
    public void testChangeRelationshipPathActionNullEdge() {
        try {
            new ChangeRelationshipPathAction(null, newWaypoints);
            fail("IllegalArgumentException should be thrown when the passed newWaypoints is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeRelationshipPathAction constructor with null newPoints. Should throw
     * IllegalArgumentException.
     */
    public void testChangeRelationshipPathActionNullNewPoints() {
        try {
            new ChangeRelationshipPathAction(edge, null);
            fail("IllegalArgumentException should be thrown when the passed new points is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeRelationshipPathAction constructor with newPoints contains null. Should throw
     * IllegalArgumentException.
     */
    public void testChangeRelationshipPathActionCointainNull() {
        try {
            List<Point> points = new ArrayList<Point>();
            points.add(null);
            new ChangeRelationshipPathAction(edge, points);
            fail("IllegalArgumentException should be thrown when the passed points contains null element.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
