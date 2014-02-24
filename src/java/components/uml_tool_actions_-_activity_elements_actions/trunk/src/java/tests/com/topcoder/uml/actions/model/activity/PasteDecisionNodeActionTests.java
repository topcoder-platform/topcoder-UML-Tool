/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for PasteDecisionNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteDecisionNodeActionTests extends TestCase {

    /**
     * <p>
     * The PasteDecisionNodeAction instance for testing.
     * </p>
     */
    private PasteDecisionNodeAction action;

    /**
     * <p>
     * The Pseudostate instance for testing.
     * </p>
     */
    private Pseudostate content;

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

        content = new PseudostateImpl();
        content.setKind(PseudostateKind.CHOICE);
        activityGraph = new ActivityGraphImpl();
        action = new PasteDecisionNodeAction(content, activityGraph);
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
        return new TestSuite(PasteDecisionNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor PasteDecisionNodeAction#PasteDecisionNodeAction(Object,ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PasteDecisionNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PasteDecisionNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor PasteDecisionNodeAction#PasteDecisionNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new PasteDecisionNodeAction(null, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteDecisionNodeAction#PasteDecisionNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new PasteDecisionNodeAction(content, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteDecisionNodeAction#PasteDecisionNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content object is not of Pseudostate
     * type and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongType() {
        Transition transition = new TransitionImpl();
        try {
            new PasteDecisionNodeAction(transition, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteDecisionNodeAction#PasteDecisionNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content kind attribute doesn't equal
     * to PseudostateKind.CHOICE and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongKind() {
        content = new PseudostateImpl();
        try {
            new PasteDecisionNodeAction(content, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}