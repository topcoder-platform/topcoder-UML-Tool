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
 * Unit test cases for RemoveAcceptEventActionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveAcceptEventActionActionTests extends TestCase {

    /**
     * <p>
     * The RemoveAcceptEventActionAction instance for testing.
     * </p>
     */
    private RemoveAcceptEventActionAction action;

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
        state.setContainer(new CompositeStateImpl());
        state.addTaggedValue(TestHelper.createTaggedValue("AcceptEventAction", "True"));
        action = new RemoveAcceptEventActionAction(state);
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
        return new TestSuite(RemoveAcceptEventActionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor RemoveAcceptEventActionAction#RemoveAcceptEventActionAction(SimpleState) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created RemoveAcceptEventActionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new RemoveAcceptEventActionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor RemoveAcceptEventActionAction#RemoveAcceptEventActionAction(SimpleState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new RemoveAcceptEventActionAction(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor RemoveAcceptEventActionAction#RemoveAcceptEventActionAction(SimpleState) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [AcceptEventAction]
     * (The data value should be True) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        state = new SimpleStateImpl();
        try {
            new RemoveAcceptEventActionAction(state);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}