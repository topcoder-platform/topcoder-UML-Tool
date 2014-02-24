/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for RemoveSendSignalActionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveSendSignalActionActionTests extends TestCase {

    /**
     * <p>
     * The RemoveSendSignalActionAction instance for testing.
     * </p>
     */
    private RemoveSendSignalActionAction action;

    /**
     * <p>
     * The SimpleState instance for testing.
     * </p>
     */
    private SimpleState state;

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

        state = new SimpleStateImpl();
        state.addTaggedValue(TestHelper.createTaggedValue("SendSignalAction", "True"));
        state.setContainer(new CompositeStateImpl());
        action = new RemoveSendSignalActionAction(state);
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
        return new TestSuite(RemoveSendSignalActionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveSendSignalActionAction#RemoveSendSignalActionAction(SimpleState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveSendSignalActionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveSendSignalActionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveSendSignalActionAction#RemoveSendSignalActionAction(SimpleState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveSendSignalActionAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor RemoveSendSignalActionAction#RemoveSendSignalActionAction(SimpleState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [SendSignalAction]
     * (The data value should be True) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        state = new SimpleStateImpl();
        try {
            new RemoveSendSignalActionAction(state);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}