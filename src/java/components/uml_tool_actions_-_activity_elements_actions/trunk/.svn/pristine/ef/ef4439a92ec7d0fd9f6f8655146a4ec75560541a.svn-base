/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import junit.framework.TestCase;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * Failure test for <code>ActivityObjectCloneUtility</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class ActivityObjectCloneUtilityFailureTest extends TestCase {

    /**
     * <p>
     * Failure Test for <code>clone(Pseudostate state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testClonePseudostateNullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((Pseudostate) null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(Pseudostate state)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is
     * expected.
     * </p>
     */
    public void testClonePseudostateInvalidState() {
        try {
            ActivityObjectCloneUtility.clone(new MockedPseudostate("name"));
            fail("No default constructor is present, ActivityObjectCloneException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(SimpleState state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneSimpleStateNullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((SimpleState) null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(SimpleState state)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is
     * expected.
     * </p>
     */
    public void testCloneSimpleStateInvalidState() {
        try {
            ActivityObjectCloneUtility.clone(new MockedSimpleState("name"));
            fail("No default constructor is present, ActivityObjectCloneException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(ActionState state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneActionStateNullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((ActionState) null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(ActionState state)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is
     * expected.
     * </p>
     */
    public void testCloneActionStateInvalidState() {
        try {
            ActivityObjectCloneUtility.clone(new MockedActionState("name"));
            fail("No default constructor is present, ActivityObjectCloneException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(FinalState state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneFinalStateNullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((FinalState) null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(FinalState state)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is
     * expected.
     * </p>
     */
    public void testCloneFinalStateInvalidState() {
        try {
            ActivityObjectCloneUtility.clone(new MockedFinalState("name"));
            fail("No default constructor is present, ActivityObjectCloneException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(Transition transition)</code>.
     * </p>
     * <p>
     * transition is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneTransitionNullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((Transition) null);
            fail("transition is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(Transition transition)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is
     * expected.
     * </p>
     */
    public void testCloneTransitionInvalidTransition1() {
        try {
            ActivityObjectCloneUtility.clone(new MockedTransition("name"));
            fail("No default constructor is present, IllegalArgumentException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(ObjectFlowState state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     *
     * @throws ActivityObjectCloneException to JUnit
     */
    public void testCloneObjectFlowStateNullState() throws ActivityObjectCloneException {
        try {
            ActivityObjectCloneUtility.clone((ObjectFlowState) null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for <code>clone(ObjectFlowState state)</code>.
     * </p>
     * <p>
     * No default constructor is present, ActivityObjectCloneException is
     * expected.
     * </p>
     */
    public void testCloneObjectFlowState() {
        try {
            ActivityObjectCloneUtility.clone(new MockedObjectFlowState("name"));
            fail("No default constructor is present, ActivityObjectCloneException is expected.");
        } catch (ActivityObjectCloneException e) {
            // expect
        }
    }
}
