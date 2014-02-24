/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PasteFlowFinalNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteFlowFinalNodeActionTests extends TestCase {

    /**
     * <p>
     * The PasteFlowFinalNodeAction instance for testing.
     * </p>
     */
    private PasteFlowFinalNodeAction action;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private FinalState content;

    /**
     * <p>
     * The ActivityGraph instance for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        content = new FinalStateImpl();
        content.addTaggedValue(TestHelper.createTaggedValue("FinalNodeType", "FlowFinalNode"));
        activityGraph = new ActivityGraphImpl();
        action = new PasteFlowFinalNodeAction(content, activityGraph);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        action = null;
        activityGraph = null;
        content = null;

        TestHelper.clearProjectConfiguration();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PasteFlowFinalNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor PasteFlowFinalNodeAction#PasteFlowFinalNodeAction(Object,ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PasteFlowFinalNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PasteFlowFinalNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor PasteFlowFinalNodeAction#PasteFlowFinalNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new PasteFlowFinalNodeAction(null, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteFlowFinalNodeAction#PasteFlowFinalNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new PasteFlowFinalNodeAction(content, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteFlowFinalNodeAction#PasteFlowFinalNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content object is not of FinalState
     * type and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongType() {
        Transition transition = new TransitionImpl();
        try {
            new PasteFlowFinalNodeAction(transition, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteFlowFinalNodeAction#PasteFlowFinalNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [FinalNodeType](The data value
     * should be FlowFinalNode) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        content = new FinalStateImpl();
        try {
            new PasteFlowFinalNodeAction(content, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}