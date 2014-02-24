/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.SetTransitionGuardAction;
import com.topcoder.uml.model.statemachines.GuardImpl;

/**
 * Aggregates all failure tests for SetTransitionGuardAction class.
 * @author vilain
 * @version 1.0
 */
public class SetTransitionGuardActionFailureTest extends TestCase {

    /**
     * Constructor under test SetTransitionGuardAction(Transition, Guard).
     * Failure testing of exception in case transition is null.
     */
    public final void testSetTransitionGuardActionFailureTransitionNull() {
        try {
            new SetTransitionGuardAction(null, new GuardImpl());
            fail("IllegalArgumentException is expected since transition is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}