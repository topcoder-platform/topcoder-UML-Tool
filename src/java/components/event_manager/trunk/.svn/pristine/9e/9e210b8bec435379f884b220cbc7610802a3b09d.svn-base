/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

import junit.framework.TestCase;

/**
 * This <code>TestCase</code> aggregates all accuracy test cases for <code>UndoChangesEvent</code>.
 *
 * @author daiwb
 * @version 1.0
 */
public class UndoChangesEventAccuracyTestCase extends TestCase {

    /**
     * <code>UndoableAction</code> instance used for tests.
     */
    private UndoableAction action;

    /**
     * <code>Object</code> instance used for tests.
     */
    private Object obj;

    /**
     * <code>RedoChangesEvent</code> instance used for tests.
     */
    private UndoChangesEvent event;

    /**
     * Sets up the testing environment, initializes the instances that will be used for tests.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        action = new DummyUndoableAction();
        obj = new Object();
        event = new UndoChangesEvent(action, obj);
    }

    /**
     * Cleans up the testing environment, disposes the instances that will be used for tests.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void tearDown() throws Exception {
        action = null;
        obj = null;
        event = null;
    }

    /**
     * Tests accuracy of <code>UndoChangesEvent(UndoableAction, Object)</code>, the <code>UndoChangesEvent</code>
     * instance should be created successfully.
     */
    public void testUndoChangesEvent() {
        assertNotNull("The UndoChangesEvent instance should be created successfully.", event);
        assertTrue("UndoChangesEvent should extend ActionEvent", event instanceof ActionEvent);
    }

    /**
     * Tests accuracy of <code>getAction()</code>, corresponding <code>UndoableAction</code> instance in
     * <code>UndoChangesEvent</code> is expected.
     */
    public void testGetAction() {
        assertEquals("Corresponding UndoableAction instance in UndoChangesEvent is expected.", action, event
                .getAction());
    }

}
