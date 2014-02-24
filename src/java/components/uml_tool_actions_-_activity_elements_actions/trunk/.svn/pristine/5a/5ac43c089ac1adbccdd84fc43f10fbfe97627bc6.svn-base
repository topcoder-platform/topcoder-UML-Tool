/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RemoveObjectFlowStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveObjectFlowStateActionTests extends TestCase {

    /**
     * <p>
     * The RemoveObjectFlowStateAction instance for testing.
     * </p>
     */
    private RemoveObjectFlowStateAction action;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private ObjectFlowState state;

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

        state = new ObjectFlowStateImpl();
        state.setContainer(new CompositeStateImpl());
        action = new RemoveObjectFlowStateAction(state);
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
        return new TestSuite(RemoveObjectFlowStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveObjectFlowStateAction#RemoveObjectFlowStateAction(ObjectFlowState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveObjectFlowStateAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveObjectFlowStateAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveObjectFlowStateAction#RemoveObjectFlowStateAction(ObjectFlowState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveObjectFlowStateAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}