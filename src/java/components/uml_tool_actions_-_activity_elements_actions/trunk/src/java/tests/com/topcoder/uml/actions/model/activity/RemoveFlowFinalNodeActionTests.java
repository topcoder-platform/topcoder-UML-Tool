/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RemoveFlowFinalNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveFlowFinalNodeActionTests extends TestCase {

    /**
     * <p>
     * The RemoveFlowFinalNodeAction instance for testing.
     * </p>
     */
    private RemoveFlowFinalNodeAction action;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private FinalState state;

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

        state = new FinalStateImpl();
        state.setContainer(new CompositeStateImpl());
        state.addTaggedValue(TestHelper.createTaggedValue("FinalNodeType", "FlowFinalNode"));
        action = new RemoveFlowFinalNodeAction(state);
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
        state = null;

        TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(RemoveFlowFinalNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveFlowFinalNodeAction#RemoveFlowFinalNodeAction(Pseudostate) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveFlowFinalNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveFlowFinalNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveFlowFinalNodeAction#RemoveFlowFinalNodeAction(Pseudostate) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveFlowFinalNodeAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor RemoveFlowFinalNodeAction#RemoveFlowFinalNodeAction(Pseudostate) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [FinalNodeType]
     * (The data value should be FlowFinalNode) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        state = new FinalStateImpl();
        try {
            new RemoveFlowFinalNodeAction(state);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}