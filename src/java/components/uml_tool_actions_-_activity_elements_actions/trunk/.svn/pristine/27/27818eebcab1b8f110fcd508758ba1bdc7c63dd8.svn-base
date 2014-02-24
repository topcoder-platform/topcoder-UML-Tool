/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.PasteStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * This class aggregates accuracy tests for PasteStateNodeAbstractAction abstract class.
 *
 * @author ch_music
 * @version 1.0
 */
public class PasteStateNodeAbstractActionAccuracyTests extends TestCase {

    /**
     * A PasteStateNodeAbstractAction instance used for testing.
     */
    private PasteStateNodeAbstractAction test;

    /**
     * An ActivityGraph instance used for testing.
     */
    private ActivityGraph activityGraph;

    /**
     * A StateVertex instance used for testing.
     */
    private StateVertex state;

    /**
     * Sets up the environment for testing.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        activityGraph = new ActivityGraphImpl();
        activityGraph.setTop(new CompositeStateImpl());
        state = AccuracyTestHelper.createActionState();

        test = new MockPasteStateNodeAbstractAction(state, activityGraph);
    }

    /**
     * Tears down the environment.
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testPasteStateNodeAbstractAction() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set presentation name.", "Test Presentation Name", test
                .getPresentationName());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute1() throws Exception {
        test.execute();
        assertEquals("execute method fails.", state, new ArrayList<StateVertex>(((CompositeState) activityGraph
                .getTop()).getSubVertexes()).get(0));
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        test.execute();
        assertEquals("execute method fails to set state's container.", activityGraph.getTop(), state
                .getContainer());
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo1() throws Exception {
        test.execute();
        test.undo();

        assertEquals("undo method fails.", 0, ((CompositeState) activityGraph.getTop()).getSubVertexes().size());
    }

    /**
     * Tests undo method error logging.
     *
     * @throws Exception to JUnit
     */
    public void testUndo2() throws Exception {
        test.execute();
        activityGraph.setTop(AccuracyTestHelper.createActionState());
        test.undo();
    }

    /**
     * This is a mock class used to test PasteStateNodeAbstractAction class.
     *
     * @author ch_music
     * @version 1.0
     */
    private static class MockPasteStateNodeAbstractAction extends PasteStateNodeAbstractAction {

        /**
         * Constructs an instance of this class.
         *
         * @param content the content to be pasted
         * @param activityGraph the ActivityGraph instance to which the content is to beo pasted
         * @throws IllegalArgumentException if any argument is null, or content is not of StateVertex instance
         */
        public MockPasteStateNodeAbstractAction(Object content, ActivityGraph activityGraph) {
            super("Test Presentation Name", content, activityGraph);
        }
    }
}
