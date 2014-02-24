/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.SetTransitionGuardAction;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

/**
 * Accuracy test cases for SetTransitionGuardAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class SetTransitionGuardActionAccuracyTests extends TestCase {
    /**
     * Represents the SetTransitionGuardAction instance used for tests.
     */
    private SetTransitionGuardAction instance;

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
        AccuracyHelper.loadDefaultConfig();
        transition = new TransitionImpl();
        oldGuard = new GuardImpl();
        newGuard = new GuardImpl();
        transition.setGuard(oldGuard);
        instance = new SetTransitionGuardAction(transition, newGuard);
    }

    /**
     * Clear the environment.
     *
     * @throws Exception exception to JUnit.
     */
    protected void tearDown() throws Exception {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldGuard, transition.getGuard());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newGuard, transition.getGuard());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newGuard, transition.getGuard());
    }

    /**
     * Test constructor.
     */
    public void testSetTransitionGuardAction() {
        assertEquals("transition is incorrect.", transition, AccuracyHelper.getObjectFieldValue(
            instance, "transition"));
        assertEquals("oldGuard is incorrect.", oldGuard, AccuracyHelper.getObjectFieldValue(
            instance, "oldGuard"));
        assertEquals("newGuard is incorrect.", newGuard, AccuracyHelper.getObjectFieldValue(
            instance, "newGuard"));
    }
}