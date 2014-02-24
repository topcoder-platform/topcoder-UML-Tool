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
 * Unit test cases for RemoveFinalNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveFinalNodeActionTests extends TestCase {

    /**
     * <p>
     * The RemoveFinalNodeAction instance for testing.
     * </p>
     */
    private RemoveFinalNodeAction action;

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
        action = new RemoveFinalNodeAction(state);

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
        return new TestSuite(RemoveFinalNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveFinalNodeAction#RemoveFinalNodeAction(FinalState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveFinalNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveFinalNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveFinalNodeAction#RemoveFinalNodeAction(FinalState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveFinalNodeAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}