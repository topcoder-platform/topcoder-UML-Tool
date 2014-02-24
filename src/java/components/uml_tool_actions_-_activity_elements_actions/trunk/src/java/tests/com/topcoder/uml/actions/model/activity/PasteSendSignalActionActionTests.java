/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PasteSendSignalActionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteSendSignalActionActionTests extends TestCase {

    /**
     * <p>
     * The PasteSendSignalActionAction instance for testing.
     * </p>
     */
    private PasteSendSignalActionAction action;

    /**
     * <p>
     * The SimpleState instance for testing.
     * </p>
     */
    private SimpleState content;

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

        content = new SimpleStateImpl();
        content.addTaggedValue(TestHelper.createTaggedValue("SendSignalAction", "True"));
        activityGraph = new ActivityGraphImpl();
        action = new PasteSendSignalActionAction(content, activityGraph);
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
        return new TestSuite(PasteSendSignalActionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor PasteSendSignalActionAction#PasteSendSignalActionAction(Object,ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PasteSendSignalActionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PasteSendSignalActionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor PasteSendSignalActionAction#PasteSendSignalActionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new PasteSendSignalActionAction(null, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteSendSignalActionAction#PasteSendSignalActionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new PasteSendSignalActionAction(content, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteSendSignalActionAction#PasteSendSignalActionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content object is not of SimpleState
     * type and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongType() {
        Transition transition = new TransitionImpl();
        try {
            new PasteSendSignalActionAction(transition, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteSendSignalActionAction#PasteSendSignalActionAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [SendSignalAction](The data value
     * should be True) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        content = new SimpleStateImpl();
        try {
            new PasteSendSignalActionAction(content, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}