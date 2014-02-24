/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Dimension;
import java.awt.Point;
import java.util.EventObject;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.UseCaseNode;
import com.topcoder.uml.actions.diagram.elements.AddDiagramElementAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.DiagramType;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>AddDiagramElementHandler</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddDiagramElementHandlerTest extends TestCase {

    /** The position of the graph node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the graph node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(180, 100);

    /** An instance of <code>AddDiagramElementAction</code> for testing. */
    private AddDiagramElementAction action;

    /** An instance of <code>AddDiagramElementHandler</code> for testing. */
    private AddDiagramElementHandler handler;

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
        handler = new AddDiagramElementHandler(TestHelper.getMainFrame());
        UseCase usecase = new UseCaseImpl();
        GraphNode child = DeployHelper.createGraphNodeForUseCase(usecase, POSITION, SIZE);
        action = new AddDiagramElementAction(TestHelper.getDiagramView(DiagramType.USECASE).getDiagram(), child,
                UMLModelManager.getInstance().getProjectConfigurationManager());
        Node node = new UseCaseNode(child, DeployHelper.createProperties());

        event = new EventObject(node);
        undoEvent = new UndoChangesEvent(action, node);
        redoEvent = new RedoChangesEvent(action, node);
    }

    /**
     * Test method for 'AddDiagramElementHandler(MainFrame)'. The instance should be created successfully.
     */
    public void testAddDiagramElementHandler_Accuracy() {
        assertNotNull("Test method for 'AddDiagramElementHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'AddDiagramElementHandler(MainFrame)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testAddDiagramElementHandler_null() {
        try {
            new AddDiagramElementHandler(null);
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
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
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
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
        action.undo();
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
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        handler.actionPerformed(event, EventValidation.SUCCESSFUL);
        action.undo();
        handler.undoActionPerformed(undoEvent, action);
        action.redo();
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

        TestHelper.getDiagramView(DiagramType.USECASE).removeAll();

        action = null;

        handler = null;

        event = null;

        undoEvent = null;

        redoEvent = null;
    }
}
