/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.AddTransitionAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * This class aggregates accuracy tests for AddTransitionAction class.
 *
 * @author ch_music
 * @version 1.0
 */
public class AddTransitionActionAccuracyTests extends TestCase {

    /**
     * An AddTransitionAction implementation instance for testing purposes.
     */
    private AddTransitionAction test;

    /**
     * An ActivityGraph instance used for testing purposes.
     */
    private ActivityGraph activityGraph;

    /**
     * A Transition instance used for testing purposes.
     */
    private Transition transition;

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
        transition = AccuracyTestHelper.createTransition();
        modelManager = AccuracyTestHelper.createModelManager();

        test = new AddTransitionAction(transition, activityGraph, modelManager);
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
    public void testAddTransitionAction() {
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set presentation name.", "Add Transition", test.getPresentationName());
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
        assertEquals("execute method fails.", transition,
                new ArrayList<Transition>(activityGraph.getTransitions()).get(0));
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
