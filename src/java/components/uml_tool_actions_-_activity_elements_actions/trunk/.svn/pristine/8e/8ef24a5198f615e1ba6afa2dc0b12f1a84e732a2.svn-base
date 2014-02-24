/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityObjectCloneException;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * This class aggregates accuracy tests for ActivityObjectCloneException class.
 *
 * @author ch_music
 * @version 1.0
 */
public class ActivityObjectCloneExceptionAccuracyTests extends TestCase {

    /**
     * Placeholder for ActionExecutionException; it is used so that the unit test is capable to detect wrong
     * inheritance for ActivityObjectCloneException.
     */
    private ActionExecutionException test;

    /**
     * Tests single-argument constructor. No exception is expected.
     */
    public void testActivityObjectCloneExceptionString() {
        test = new ActivityObjectCloneException("test");
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage());
    }

    /**
     * Tests two-argument constructor. No exception is expected.
     */
    public void testActivityObjectCloneExceptionStringThrowable() {
        test = new ActivityObjectCloneException("test", new IllegalArgumentException());
        assertNotNull("Fails to create exception.", test);
        assertEquals("Wrong message.", "test", test.getMessage().substring(0, 4));
        assertEquals("Wrong cause.", IllegalArgumentException.class, test.getCause().getClass());
    }
}
