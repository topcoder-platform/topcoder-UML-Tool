/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Test the functionality of <code>RemoveCollaborationAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveCollaborationActionTest extends TestCase {
    /** Reference to main frame for testing */
    private MainFrame mainFrame;

    /** An instance of <code>RemoveCollaborationAction</code> for testing. */
    private RemoveCollaborationAction action;

    /** The instance of Collaboration to remove */
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
        collaboration = new CollaborationImpl();
        model = mainFrame.getUmlModelManager().getModel();
        model.addOwnedElement(collaboration);

        action = new RemoveCollaborationAction(mainFrame, collaboration);
    }

    /**
     * Test method for 'RemoveCollaborationAction.RemoveCollaborationAction(MainFrame, Collaboration)'. The action
     * instance should not be null.
     */
    public void testRemoveCollaborationAction_Accuracy() {
        assertNotNull("Test method for 'RemoveCollaborationAction(MainFrame, Collaboration)' failed.", action);
    }

    /**
     * Test method for 'RemoveCollaborationAction.RemoveCollaborationAction(MainFrame, Collaboration)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRemoveCollaborationAction_Null_1() {
        try {
            new RemoveCollaborationAction(null, collaboration);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveCollaborationAction.RemoveCollaborationAction(MainFrame, Collaboration)'. The argument is
     * null, IllegalArgumentException should be thrown.
     */
    public void testRemoveCollaborationAction_Null_2() {
        try {
            new RemoveCollaborationAction(mainFrame, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RemoveCollaborationAction.executeAction()'. Collaboration should be removed from model.
     */
    public void testExecuteAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        assertFalse("Collaboration should removed from model", model.containsOwnedElement(collaboration));
        action.undoAction();
    }

    /**
     * Test method for 'RemoveCollaborationAction.undoAction()'. Collaboration should be added to model.
     */
    public void testUndoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        assertTrue("Collaboration should added to model", model.containsOwnedElement(collaboration));
    }

    /**
     * Test method for 'RemoveCollaborationAction.redoAction()'. Collaboration should be removed from model.
     */
    public void testRedoAction() {
        try {
            action.executeAction();
        } catch (ActionExecutionException e) {
            fail(e.getMessage());
        }
        action.undoAction();
        action.redoAction();
        assertFalse("Collaboration should removed from model", model.containsOwnedElement(collaboration));
        action.undoAction();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        model.removeOwnedElement(collaboration);
        collaboration = null;
        model = null;
        mainFrame = null;
        action = null;
    }

}
