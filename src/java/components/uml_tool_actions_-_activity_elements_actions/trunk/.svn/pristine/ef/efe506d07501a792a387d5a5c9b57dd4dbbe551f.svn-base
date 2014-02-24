/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RemoveActionStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActionStateActionTests extends TestCase {

    /**
     * <p>
     * The RemoveActionStateAction instance for testing.
     * </p>
     */
    private RemoveActionStateAction action;

    /**
     * <p>
     * The ActionState instance for testing.
     * </p>
     */
    private ActionState state;

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

        state = new ActionStateImpl();
        state.setContainer(new CompositeStateImpl());
        action = new RemoveActionStateAction(state);
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
        return new TestSuite(RemoveActionStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveActionStateAction#RemoveActionStateAction(ActionState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveActionStateAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveActionStateAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveActionStateAction#RemoveActionStateAction(ActionState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveActionStateAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}