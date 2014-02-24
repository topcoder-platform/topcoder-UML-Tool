/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RemoveForkNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveForkNodeActionTests extends TestCase {

    /**
     * <p>
     * The RemoveForkNodeAction instance for testing.
     * </p>
     */
    private RemoveForkNodeAction action;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate state;

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

        state = new PseudostateImpl();
        state.setContainer(new CompositeStateImpl());
        state.setKind(PseudostateKind.FORK);
        action = new RemoveForkNodeAction(state);
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
        return new TestSuite(RemoveForkNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveForkNodeAction#RemoveForkNodeAction(Pseudostate) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveForkNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveForkNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveForkNodeAction#RemoveForkNodeAction(Pseudostate) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveForkNodeAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor RemoveForkNodeAction#RemoveForkNodeAction(Pseudostate) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state kind attribute doesn't equal
     * to PseudostateKind.FORK and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongKind() {
        state = new PseudostateImpl();
        try {
            new RemoveForkNodeAction(state);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}