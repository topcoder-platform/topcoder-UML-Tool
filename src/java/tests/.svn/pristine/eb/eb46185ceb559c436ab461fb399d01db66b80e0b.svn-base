/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.eventmanager.EventValidation;

/**
 * <p>
 * Test the functionality of <code>ChangePropertyHandlerTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangePropertyHandlerTest extends TestCase {
    /** Main frame window for testing. */
    private MainFrame MAINFRAME = TestHelper.getMainFrame();

    /** An instance of <code>ChangeEntityNameHandler</code> for testing. */
    private ChangePropertyHandler handler;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        handler = new ChangePropertyHandler(MAINFRAME);
    }

    /**
     * Test method for 'ChangePropertyHandler(MainFrame)'.Valid mainframe, the handler should be created successfully.
     * thrown.
     */
    public void testChangePropertyHandler_Accuracy() {
        assertNotNull("Test method for 'ChangePropertyHandler(MainFrame)' failed.", handler);
    }

    /**
     * Test method for 'ChangePropertyHandler(MainFrame)'.The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testChangePropertyHandler_null() {
        try {
            new ChangePropertyHandler(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }

    }

    /**
     * Test method for 'actionPerformed(EventObject,EventValidation)'.Null event is given, IllegalArgumentException
     * should be thrown.
     */
    public void testActionPerformed() {
        try {
            handler.actionPerformed(null, EventValidation.SUCCESSFUL);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'undoActionPerformed(UndoChangesEvent,UndoableAction)'.Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testUndoActionPerformed() {
        try {
            handler.undoActionPerformed(null, new ChangeSizeAction(new GraphNode(), new Dimension()));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'redoActionPerformed(RedoChangesEvent,UndoableAction)'.Null event is given,
     * IllegalArgumentException should be thrown.
     */
    public void testRedoActionPerformed() {
        try {
            handler.redoActionPerformed(null, new ChangeSizeAction(new GraphNode(), new Dimension()));
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

}
