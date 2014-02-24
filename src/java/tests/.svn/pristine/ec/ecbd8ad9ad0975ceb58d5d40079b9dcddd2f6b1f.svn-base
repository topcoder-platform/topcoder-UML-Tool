/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IncludeEdge;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>ChangeRelationshipPathHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeRelationshipPathHandlerTest extends TestCase {

    /** Start position of the graph edge. Used for testing only. */
    private static final Point START_POSITION = new Point(100, 150);

    /** End position of the graph edge. Used for testing only. */
    private static final Point END_POSITION = new Point(180, 100);

    /** New position of the graph node for testing. */
    private Point newPosition = new Point(200, 200);

    /** An instance of <code>ChangeRelationshipPathAction</code> for testing. */
    private ChangeRelationshipPathAction action;

    /** An instance of <code>ChangeRelationshipPathHandler</code> for testing. */
    private ChangeRelationshipPathHandler handler;

    /** Event for executing. */
    private EventObject event;

    /** Event for undoing. */
    private UndoChangesEvent undoEvent;

    /** Event for redoing. */
    private RedoChangesEvent redoEvent;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        handler = new ChangeRelationshipPathHandler(TestHelper.getMainFrame());
        Include include = new IncludeImpl();
        List<Point> wayPoints = new ArrayList<Point>();
        wayPoints.add(START_POSITION);
        wayPoints.add(END_POSITION);
        GraphEdge graphEdge = DeployHelper.createGraphEdgeForUseCase(include, wayPoints, "test");
        List<com.topcoder.diagraminterchange.Point> newPath = new ArrayList<com.topcoder.diagraminterchange.Point>();
        newPath.add(DeployHelper.createPoint(START_POSITION));
        newPath.add(DeployHelper.createPoint(newPosition));
        newPath.add(DeployHelper.createPoint(END_POSITION));
        action = new ChangeRelationshipPathAction(graphEdge, newPath);
        Edge edge = new IncludeEdge(graphEdge);
        event = new EventObject(edge);
        undoEvent = new UndoChangesEvent(action, edge);
        redoEvent = new RedoChangesEvent(action, edge);
    }

    /**
     * Test method for 'ChangeRelationshipPathHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testChangeRelationshipPathHandler_Accuracy() {
        assertNotNull("Test method for 'ChangeRelationshipPathHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ChangeRelationshipPathHandler(MainFrame)'. The argument is null, IllegalArgumentException should
     * be thrown.
     */
    public void testChangeRelationshipPathHandler_null() {
        try {
            new ChangeRelationshipPathHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'actionPerformed(EventObject, EventValidation)'. Valid event is given, should perform
     * successfully.
     */
    public void testActionPerformed_Accuracy() {
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
    }

    /**
     * Test method for 'actionPerformed(EventObject, EventValidation)'. Null event is given, IllegalArgumentException
     * should be thrown.
     */
    public void testActionPerformed_null() {
        try {
            handler.actionPerformed(null, EventValidation.SUCCESSFUL);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent, UndoableAction)'. Valid event is given, should perform
     * successfully.
     */
    public void testUndoActionPerformed_Accuracy() {
        handler.undoActionPerformed(undoEvent, action);
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent, UndoableAction)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testUndoActionPerformed_null() {
        try {
            handler.undoActionPerformed(null, action);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent, UndoableAction)'. Valid event is given, should perform
     * successfully.
     */
    public void testRedoActionPerformed_Accuracy() {
        handler.redoActionPerformed(redoEvent, action);
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent, UndoableAction)'. Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed_null() {
        try {
            handler.redoActionPerformed(null, action);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        newPosition = null;

        action = null;

        handler = null;

        event = null;

        undoEvent = null;

        redoEvent = null;
    }
}
