/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>AddCollaborationAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AddCollaborationActionTest extends TestCase {
    /** Reference to main frame for testing */
    MainFrame mainFrame;

    /** An instance of <code>AddCollaborationAction</code> for testing. */
    private AddCollaborationAction action;

    /** The instance of Collaboration in this action */
    private Collaboration collaboration;

    /** Root model gets from uml model manager */
    private Model model;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        mainFrame = TestHelper.getMainFrame();
        action = new AddCollaborationAction(mainFrame);
        collaboration = action.getCollaboration();
        model = mainFrame.getUmlModelManager().getModel();
    }

    /**
     * Test method for 'AddCollaborationAction.AddCollaborationAction(MainFrame)'. The action instance should not be
     * null.
     */
    public void testAddCollaborationAction_Accuracy() {
        assertNotNull("Test method for 'AddCollaborationAction(MainFrame)' failed.", action);
    }

    /**
     * Test method for 'AddCollaborationAction.AddCollaborationAction(MainFrame)'. The argument is null,
     * IllegalArgumentException should be thrown.
     */
    public void testAddCollaborationAction_Null() {
        try {
            new AddCollaborationAction(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'AddCollaborationAction.executeAction()'. Collaboration should be added to model.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertTrue("Collaboration should added to model", model.containsOwnedElement(collaboration));
        action.undoAction();
    }

    /**
     * Test method for 'AddCollaborationAction.undoAction()'. Collaboration should be removed from model.
     */
    public void testUndoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        assertFalse("Collaboration should removed from model", model.containsOwnedElement(collaboration));
    }

    /**
     * Test method for 'AddCollaborationAction.redoAction()'. Collaboration should be added to model.
     */
    public void testRedoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        action.redoAction();
        assertTrue("Collaboration should added to model", model.containsOwnedElement(collaboration));
        action.undoAction();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        mainFrame = null;
        action = null;
        collaboration = null;
        model = null;
    }

}
