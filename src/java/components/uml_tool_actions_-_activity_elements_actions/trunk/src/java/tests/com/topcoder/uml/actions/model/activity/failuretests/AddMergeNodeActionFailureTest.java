/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import com.topcoder.uml.actions.model.activity.AddMergeNodeAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>AddMergeNodeAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddMergeNodeActionFailureTest extends TestCase {

    /**
     * <p>
     * The Pseudostate instance created for testing.
     * </p>
     */
    private Pseudostate state;

    /**
     * <p>
     * The ActivityGraph instance created for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

    /**
     * <p>
     * The UMLModelManager instance created for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        state = new PseudostateImpl();
        activityGraph = new ActivityGraphImpl();
        manager = new UMLModelManager();
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
     * Failure test for <code>AddMergeNodeAction
     * (Pseudostate state, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddMergeNodeActionNullState() {
        try {
            new AddMergeNodeAction(null, activityGraph, manager);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddMergeNodeAction
     * (Pseudostate state, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * state argument's kind attribute is null, IllegalArgumentException is
     * expected.
     * </p>
     */
    public void testAddMergeNodeActionInvalidState1() {
        try {
            new AddMergeNodeAction(state, activityGraph, manager);
            fail("state is invalid, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddMergeNodeAction
     * (Pseudostate state, ActivityGraph activityGraph, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * state is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddMergeNodeActionInvalidState2() {
        try {
            // kind is invalid
            state.setKind(PseudostateKind.CHOICE);
            new AddMergeNodeAction(state, activityGraph, manager);
            fail("state is invalid, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddMergeNodeAction
     * (Pseudostate state,ActivityGraph activityGraph,UMLModelManager manager)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddMergeNodeActionNullActivityGraph() {
        try {
            new AddMergeNodeAction(state, (ActivityGraph) null, manager);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for <code>AddMergeNodeAction
     * (Pseudostate state,ActivityGraph activityGraph,UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAddMergeNodeActionNullManager() {
        try {
            new AddMergeNodeAction(state, activityGraph, (UMLModelManager) null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
