/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;

/**
 * Accuracy test cases for ChangeRelationshipPathAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeRelationshipPathActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangeRelationshipPathAction instance used for tests.
     */
    private ChangeRelationshipPathAction instance;

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
        AccuracyHelper.loadDefaultConfig();
        edge = new GraphEdge();
        oldWaypoints = new ArrayList<Point>();
        newWaypoints = new ArrayList<Point>();
        for (int i = 0; i < 1; ++i) {
            Point point = new Point();
            edge.addWaypoint(point);
            oldWaypoints.add(point);
        }
        for (int i = 0; i < 3; i++) {
            newWaypoints.add(new Point());
        }
        instance = new ChangeRelationshipPathAction(edge, newWaypoints);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        assertEquals("undoAction() is incorrect.", oldWaypoints, edge.getWaypoints());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newWaypoints, edge.getWaypoints());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newWaypoints, edge.getWaypoints());
    }

    /**
     * Test ChangeRelationshipPathAction constructor.
     */
    public void testChangeRelationshipPathAction() {
        assertNotNull("Create ChangeRelationshipPathAction incorrectly.",
            new ChangeRelationshipPathAction(edge, newWaypoints));
    }

    /**
     * Test constructor.
     */
    public void testChangeRelationshipPathAction1() {
        assertEquals("edge is incorrect.", edge, AccuracyHelper.getObjectFieldValue(instance,
            "edge"));
        assertEquals("oldWaypoints is incorrect.", oldWaypoints, AccuracyHelper
            .getObjectFieldValue(instance, "oldWaypoints"));
        assertEquals("newWaypoints is incorrect.", newWaypoints, AccuracyHelper
            .getObjectFieldValue(instance, "newWaypoints"));
    }

}