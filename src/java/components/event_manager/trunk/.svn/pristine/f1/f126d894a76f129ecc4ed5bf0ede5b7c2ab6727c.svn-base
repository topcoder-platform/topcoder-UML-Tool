/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.TestCase;


/**
 * <p>
 * Test the functionality of <code>RedoChangesEvent</code>class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RedoChangesEventTest extends TestCase {
    /** An instance of <code>Action</code> for testing. */
    private UndoableAction action = new MockUndoableAction();

    /** Represents an <code>RedoChangesEvent</code> source. */
    private Object source = new String("Source");

    /** An instance of <code>RedoChangesEvent</code> for testing. */
    private RedoChangesEvent redoChangesEvent = null;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        redoChangesEvent = new RedoChangesEvent(action, source);
    }

    /**
     * Test method for 'RedoChangesEvent(Action, Object)'. The instance should be created successfully.
     */
    public void testRedoChangesEvent_Accuracy() {
        assertTrue("Test method for RedoChangesEvent(Action, Object) failed.", redoChangesEvent instanceof ActionEvent);
    }

    /**
     * Test method for 'RedoChangesEvent(Action, Object)'. The argument 'action' is null, IllegalArgumentException
     * should be thrown.
     */
    public void testRedoChangesEvent_null1() {
        try {
            new RedoChangesEvent(null, source);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RedoChangesEvent(Action, Object)'. The argument 'source' is null, IllegalArgumentException
     * should be thrown.
     */
    public void testRedoChangesEvent_null2() {
        try {
            new RedoChangesEvent(action, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'RedoChangesEvent.getAction()'. The action should be returned correctly.
     */
    public void testGetAction_Accuracy() {
        assertEquals("Test method for 'RedoChangesEvent.getAction()' failed.", action, redoChangesEvent.getAction());
    }
}
