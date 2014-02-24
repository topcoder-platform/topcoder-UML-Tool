/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.RemoveActionStateAction;

/**
 * <p>
 * Failure test for <code>RemoveActionStateAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveActionStateActionFailureTest extends TestCase {
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
     * Failure test for <code>RemoveActionStateAction(ActionState state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveAcceptEventActionAction() {
        try {
            new RemoveActionStateAction(null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
