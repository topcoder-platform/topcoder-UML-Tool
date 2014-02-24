/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.RemoveObjectAction;
/**
 * <p>
 * Failure test for RemoveObjectAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveObjectActionFailureTest extends TestCase {
    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure Test for the
     * <code>RemoveObjectAction(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullStimulus() {
        try {
            new RemoveObjectAction(null);
            fail("object is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
