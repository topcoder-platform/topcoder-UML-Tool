/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteTransitionAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

/**
 * This class aggregates accuracy tests for PasteTransitionAction class.
 *
 * @author ch_music
 * @version 1.0
 */
public class PasteTransitionActionAccuracyTests extends TestCase {

    /**
     * A PasteTransitionAction instance used for testing.
     */
    private PasteTransitionAction test;

    /**
     * An ActivityGraph instance used for testing.
     */
    private ActivityGraph activityGraph;

    /**
     * A Transition instance used for testing.
     */
    private Transition transition;

    /**
     * Sets up the environment for testing.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        activityGraph = new ActivityGraphImpl();
        transition = new TransitionImpl();

        test = new PasteTransitionAction(transition, activityGraph);
    }

    /**
     * Tears down the environment.
     *
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testPasteTransitionAction() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set presentation name.", "Paste Transition", test.getPresentationName());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute1() throws Exception {
        test.execute();
        assertEquals("execute method fails.", transition,
                new ArrayList<Transition>(activityGraph.getTransitions()).get(0));
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        test.execute();
        assertEquals("execute method fails to set Transition's StateMachine.", activityGraph, transition
                .getStateMachine());
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        test.execute();
        test.undo();

        assertEquals("undo method fails.", 0, activityGraph.getTransitions().size());
    }
}
