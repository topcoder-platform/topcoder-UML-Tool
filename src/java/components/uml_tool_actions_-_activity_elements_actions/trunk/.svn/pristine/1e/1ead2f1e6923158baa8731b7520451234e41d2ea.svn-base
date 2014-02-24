/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import com.topcoder.uml.actions.model.activity.RemoveTransitionAction;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;

/**
 * This class aggregates accuracy tests for RemoveTransitionAction.
 *
 * @author ch_music
 * @version 1.0
 */
public class RemoveTransitionActionAccuracyTests extends TestCase {

    /**
     * A RemoveTransitionAction instance used for testing.
     */
    private RemoveTransitionAction test;

    /**
     * A Transition instance used for testing.
     */
    private Transition transition = null;

    /**
     * Sets up testing environment.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);
        transition = AccuracyTestHelper.createTransition();
        test = new RemoveTransitionAction(transition);
    }

    /**
     * Tears down testing environment.
     *
     * @throws Exception to JUnit
     */
    public void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testRemoveTransitionAction() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set presentation name.", "Remove Transition", test
                .getPresentationName());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        test.execute();
        assertFalse("execute method fails.", transition.getStateMachine().containsTransition(transition));
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        test.execute();
        test.undo();
        assertTrue("undo method fails.", transition.getStateMachine().containsTransition(transition));
    }
}
