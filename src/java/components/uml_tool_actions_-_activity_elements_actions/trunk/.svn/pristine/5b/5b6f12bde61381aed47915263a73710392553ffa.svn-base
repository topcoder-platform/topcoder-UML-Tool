/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.RemoveStateNodeAbstractAction;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * This class aggregates accuracy tests for RemoveStateNodeAbstractAction abstract class.
 *
 * @author ch_music
 * @version 1.0
 */
public class RemoveStateNodeAbstractActionAccuracyTests extends TestCase {

    /**
     * A RemoveStateNodeAbstractAction instance used for testing.
     */
    private RemoveStateNodeAbstractAction test;

    /**
     * A StateVertex instance used for testing.
     */
    private StateVertex state;

    /**
     * Sets up the testing environment
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);
        state = AccuracyTestHelper.createActionState();
        test = new MockRemoveStateNodeAbstractAction(state);
    }

    /**
     * Tears down the testing environment
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testRemoveStateNodeAbstractAction() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set presentation name.", "Test Presentation Name", test
                .getPresentationName());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        test.execute();
        assertFalse("execute method fails.", state.getContainer().containsSubVertex(state));
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        test.execute();
        test.undo();

        assertTrue("undo method fails.", state.getContainer().containsSubVertex(state));
    }

    /**
     * This is a mock class used to test RemoveStateNodeAbstractAction class.
     *
     * @author ch_music
     * @version 1.0
     */
    private static class MockRemoveStateNodeAbstractAction extends RemoveStateNodeAbstractAction {

        /**
         * Constructs an instance of this class.
         *
         * @param state the StateVertex object to be removed
         * @throws IllegalArgumentException if the state argument is null, or system clipboard could not be
         *             retrieved
         */
        public MockRemoveStateNodeAbstractAction(StateVertex state) {
            super("Test Presentation Name", state);
        }
    }
}
