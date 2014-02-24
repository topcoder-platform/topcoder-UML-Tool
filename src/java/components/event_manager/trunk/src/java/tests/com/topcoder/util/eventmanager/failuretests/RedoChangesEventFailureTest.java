/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import com.topcoder.util.eventmanager.RedoChangesEvent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for RedoChangesEvent class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class RedoChangesEventFailureTest extends TestCase {
    /**
     * Represents a source object that is used in the test.
     */
    private Object source = new Object();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(RedoChangesEventFailureTest.class);
    }

    /**
     * Failure test of <code>RedoChangesEvent(UndoableAction action, Object source)</code> constructor.
     *
     * <p>
     * action is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRedoChangesEventFailureNullAction() throws Exception {
        try {
            new RedoChangesEvent(null, source);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
