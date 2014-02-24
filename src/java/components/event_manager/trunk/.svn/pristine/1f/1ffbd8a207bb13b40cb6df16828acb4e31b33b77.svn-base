/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.failuretests;

import com.topcoder.util.eventmanager.ActionEvent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for ActionEvent class.
 *
 * @author King_Bette
 * @version 1.0
 */
public class ActionEventFailureTest extends TestCase {
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
        return new TestSuite(ActionEventFailureTest.class);
    }

    /**
     * Failure test of <code>ActionEvent(Action action, Object source)</code> constructor.
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
    public void testActionEventFailure() throws Exception {
        try {
            new ActionEvent(null, source);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
