/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.Action;

import junit.framework.TestCase;

import java.util.EventObject;


/**
 * <p>
 * Test the functionality of <code>ActionEvent</code>class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActionEventTest extends TestCase {
    /** An instance of <code>Action</code> for testing. */
    private Action action = new MockUndoableAction();

    /** Represents an <code>ActionEvent</code> source. */
    private Object source = new String("Source");

    /** An instance of <code>ActionEvent</code> for testing. */
    private ActionEvent actionEvent = null;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        actionEvent = new ActionEvent(action, source);
    }

    /**
     * Test method for 'ActionEvent(Action, Object)'. The instance should be created successfully.
     */
    public void testActionEvent_Accuracy() {
        assertTrue("Test method for ActionEvent(Action, Object) failed.", actionEvent instanceof EventObject);
    }

    /**
     * Test method for 'ActionEvent(Action, Object)'. The argument 'action' is null, IllegalArgumentException should be
     * thrown.
     */
    public void testActionEvent_null1() {
        try {
            new ActionEvent(null, source);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'ActionEvent(Action, Object)'. The argument 'source' is null, IllegalArgumentException should be
     * thrown.
     */
    public void testActionEvent_null2() {
        try {
            new ActionEvent(action, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'ActionEvent.getAction()'. The action should be returned correctly.
     */
    public void testGetAction_Accuracy() {
        assertEquals("Test method for 'ActionEvent.getAction()' failed.", action, actionEvent.getAction());
    }
}
