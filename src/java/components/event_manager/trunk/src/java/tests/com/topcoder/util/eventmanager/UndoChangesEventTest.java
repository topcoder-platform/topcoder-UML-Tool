/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.TestCase;


/**
 * <p>
 * Test the functionality of <code>UndoChangesEvent</code>class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UndoChangesEventTest extends TestCase {
    /** An instance of <code>Action</code> for testing. */
    private UndoableAction action = new MockUndoableAction();

    /** Represents an <code>UndoChangesEvent</code> source. */
    private Object source = new String("Source");

    /** An instance of <code>UndoChangesEvent</code> for testing. */
    private UndoChangesEvent undoChangesEvent = null;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        undoChangesEvent = new UndoChangesEvent(action, source);
    }

    /**
     * Test method for 'UndoChangesEvent(Action, Object)'. The instance should be created successfully.
     */
    public void testUndoChangesEvent_Accuracy() {
        assertTrue("Test method for UndoChangesEvent(Action, Object) failed.", undoChangesEvent instanceof ActionEvent);
    }

    /**
     * Test method for 'UndoChangesEvent(Action, Object)'. The argument 'action' is null, IllegalArgumentException
     * should be thrown.
     */
    public void testUndoChangesEvent_null1() {
        try {
            new UndoChangesEvent(null, source);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'UndoChangesEvent(Action, Object)'. The argument 'source' is null, IllegalArgumentException
     * should be thrown.
     */
    public void testUndoChangesEvent_null2() {
        try {
            new UndoChangesEvent(action, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'UndoChangesEvent.getAction()'. The action should be returned correctly.
     */
    public void testGetAction_Accuracy() {
        assertEquals("Test method for 'UndoChangesEvent.getAction()' failed.", action, undoChangesEvent.getAction());
    }
}
