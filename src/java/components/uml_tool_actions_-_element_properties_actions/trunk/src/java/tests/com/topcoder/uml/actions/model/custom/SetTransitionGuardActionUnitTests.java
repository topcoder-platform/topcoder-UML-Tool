/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the SetTransitionGuardAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class SetTransitionGuardActionUnitTests extends TestCase {
    /**
     * Represents the SetTransitionGuardAction instance used for tests.
     */
    private SetTransitionGuardAction testSetTransitionGuardAction;

    /**
     * <p>
     * Represents the transition to be updated. This variable is set in the constructor, is
     * immutable (the reference) and never be null. This variable is referenced in the redoAction
     * and executeAction methods.
     * </p>
     */
    private Transition transition;

    /**
     * <p>
     * Represents the old guard of the transition before this action performed. This variable is set
     * in the constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private Guard oldGuard;

    /**
     * <p>
     * Represents the new guard of the transition after this action performed. This variable is set
     * in the constructor, is immutable. This variable is referenced in the redoAction and execute
     * methods.
     * </p>
     */
    private Guard newGuard;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        transition = new TransitionImpl();
        oldGuard = new GuardImpl();
        newGuard = new GuardImpl();
        transition.setGuard(oldGuard);
        testSetTransitionGuardAction = new SetTransitionGuardAction(transition, newGuard);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The guard of the transition should
     * be set to oldGuard.
     */
    public void testUndoAction() {
        testSetTransitionGuardAction.undoAction();
        assertEquals("SetTransitionGuardAction undoAction incorrectly.", oldGuard, transition.getGuard());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The guard of the transition should
     * be set to newGuard.
     */
    public void testRedoAction() {
        testSetTransitionGuardAction.redoAction();
        assertEquals("SetTransitionGuardAction redoAction incorrectly.", newGuard, transition.getGuard());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The guard of the transition
     * should be set to newGuard.
     */
    public void testExecuteAction() {
        testSetTransitionGuardAction.executeAction();
        assertEquals("SetTransitionGuardAction executeAction incorrectly.", newGuard, transition.getGuard());
    }

    /**
     * Test SetTransitionGuardAction constructor.
     */
    public void testSetTransitionGuardAction() {
        UndoableAbstractAction action = new SetTransitionGuardAction(transition, newGuard);
        assertNotNull("Create SetTransitionGuardAction incorrectly.", action);
        assertEquals("Create SetTransitionGuardAction incorrectly.", transition,
                UnitTestsHelper.getObjectFieldValue(action, "transition"));
        assertEquals("Create SetTransitionGuardAction incorrectly.", newGuard,
                UnitTestsHelper.getObjectFieldValue(action, "newGuard"));
    }

    /**
     * Test SetTransitionGuardAction constructor with null transition. Should throw
     * IllegalArgumentException.
     */
    public void testSetTransitionGuardActionNullTransition() {
        try {
            new SetTransitionGuardAction(null, newGuard);
            fail("IllegalArgumentException should be thrown when the passed Transition is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
