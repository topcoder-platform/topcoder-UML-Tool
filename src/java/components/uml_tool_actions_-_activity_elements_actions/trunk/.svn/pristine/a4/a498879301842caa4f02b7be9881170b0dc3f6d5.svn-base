/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>AbstractActivityUndoableAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AbstractActivityUndoableActionFailureTest extends TestCase {
    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
    }

    /**
     * <p>
     * Clear the namespace.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }
    /**
     * <p>
     * Failure test for <code>AbstractActivityUndoableAction(String name)</code>.
     * </p>
     * <p>
     * name is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAbstractActivityUndoableActionFailureNullName() {
        try {
            new MockedAbstractActivityUndoableAction(null);
            fail("name is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AbstractActivityUndoableAction(String name)</code>.
     * </p>
     * <p>
     * name is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testAbstractActivityUndoableActionEmptyName() {
        try {
            new MockedAbstractActivityUndoableAction(" ");
            fail("name is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>logException(String message, Throwable exception)</code>.
     * </p>
     * <p>
     * exception is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testLogException() {
        try {
            new MockedAbstractActivityUndoableAction("name").logException("message", null);
            fail("exception is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

}
