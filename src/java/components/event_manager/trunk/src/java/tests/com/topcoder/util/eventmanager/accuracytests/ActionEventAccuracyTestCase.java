/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.eventmanager.ActionEvent;
import java.util.EventObject;

import junit.framework.TestCase;

/**
 * This <code>TestCase</code> aggregates all accuracy test cases for <code>ActionEvent</code>.
 *
 * @author daiwb
 * @version 1.0
 */
public class ActionEventAccuracyTestCase extends TestCase {

    /**
     * <code>Action</code> instance used for tests.
     */
    private Action action;

    /**
     * <code>Object</code> instance used for tests.
     */
    private Object obj;

    /**
     * <code>ActionEvent</code> instance used for tests.
     */
    private ActionEvent event;

    /**
     * Sets up the testing environment, initializes the instances used for tests.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        action = new DummyAction();
        obj = new Object();
        event = new ActionEvent(action, obj);
    }

    /**
     * Cleans up the testing environment, disposes the instances used for tests.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        action = null;
        obj = null;
        event = null;
    }

    /**
     * Tests accuracy of <code>ActionEvent(Action, Object)</code>, the <code>ActionEvent</code> instance should be
     * created successfully.
     */
    public void testActionEvent() {
        assertNotNull("The ActionEvent instance should be created successfully.", event);
        assertTrue("ActionEvent should extend EventObject", event instanceof EventObject);
    }

    /**
     * Tests accuracy of <code>getAction()</code>, corresponding <code>Action</code> instance in
     * <code>ActionEvent</code> is expected.
     */
    public void testGetAction() {
        assertEquals("Corresponding Action instance in ActionEvent is expected.", action, event.getAction());
    }

}
