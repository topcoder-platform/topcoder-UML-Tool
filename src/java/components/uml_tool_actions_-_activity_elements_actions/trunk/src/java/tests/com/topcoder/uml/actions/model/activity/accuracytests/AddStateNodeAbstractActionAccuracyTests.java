/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.AddStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * This class aggregates accuracy tests for AddStateNodeAbstractAction abstract class.
 *
 * @author ch_music
 * @version 1.0
 */
public class AddStateNodeAbstractActionAccuracyTests extends TestCase {

    /**
     * An AddStateNodeAbstractAction implementation instance for testing purposes.
     */
    private AddStateNodeAbstractAction test;

    /**
     * An ActivityGraph instance used for testing purposes.
     */
    private ActivityGraph activityGraph;

    /**
     * A StateVertex instance used for testing purposes.
     */
    private StateVertex state;

    /**
     * The UMLModelManager instance used for testing purposes.
     */
    private UMLModelManager modelManager;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        activityGraph = new ActivityGraphImpl();
        activityGraph.setTop(new CompositeStateImpl());
        state = AccuracyTestHelper.createActionState();
        modelManager = AccuracyTestHelper.createModelManager();

        test = new MockAddStateNodeAbstractAction(state, activityGraph, modelManager);
    }

    /**
     * Tears down the testing environment.
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testAddStateNodeAbstractAction() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set presentation name.", "Test Presentation Name", test
                .getPresentationName());
        assertTrue("Constructor fails to format state.", ((MockProjectConfigurationManager) modelManager
                .getProjectConfigurationManager()).wasInitialFormatted());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        test.execute();
        assertEquals("execute method fails.", state, new ArrayList<StateVertex>(((CompositeState) activityGraph
                .getTop()).getSubVertexes()).get(0));
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
     * Tests undo method exception logging.
     *
     * @throws Exception to JUnit
     */
    public void testUndo2() throws Exception {
        test.execute();
        activityGraph.setTop(AccuracyTestHelper.createActionState());
        test.undo();
    }

    /**
     * A mock implementation of AddStateNodeAbstractAction abstract class.
     *
     * @author ch_music
     * @version 1.0
     */
    private static class MockAddStateNodeAbstractAction extends AddStateNodeAbstractAction {

        /**
         * Constructs an instance of this class.
         *
         * @param state the StateVertex instance to be added
         * @param activityGraph the target ActivityGraph instance
         * @param manager the UML Model Manager used
         * @throws IllegalArgumentException if the name, state, activityGraph, manager is null or if name is empty.
         *             Any exception thrown while formatting the state using the project configuration is also
         *             wrapped using this exception
         */
        public MockAddStateNodeAbstractAction(StateVertex state, ActivityGraph activityGraph,
                UMLModelManager manager) {
            super("Test Presentation Name", state, activityGraph, manager);
        }
    }
}
