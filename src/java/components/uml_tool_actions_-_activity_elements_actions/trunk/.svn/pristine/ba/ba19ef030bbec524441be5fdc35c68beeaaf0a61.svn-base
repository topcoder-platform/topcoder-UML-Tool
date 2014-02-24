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
 * Unit test cases for PasteJoinNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteJoinNodeActionTests extends TestCase {

    /**
     * <p>
     * The PasteJoinNodeAction instance for testing.
     * </p>
     */
    private PasteJoinNodeAction action;

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
        content.setKind(PseudostateKind.JOIN);
        activityGraph = new ActivityGraphImpl();
        action = new PasteJoinNodeAction(content, activityGraph);
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
        return new TestSuite(PasteJoinNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor PasteJoinNodeAction#PasteJoinNodeAction(Object,ActivityGraph) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PasteJoinNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new PasteJoinNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor PasteJoinNodeAction#PasteJoinNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when content is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContent() {
        try {
            new PasteJoinNodeAction(null, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteJoinNodeAction#PasteJoinNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when activityGraph is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullActivityGraph() {
        try {
            new PasteJoinNodeAction(content, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteJoinNodeAction#PasteJoinNodeAction(Object,ActivityGraph) for failure.
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
            new PasteJoinNodeAction(transition, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor PasteJoinNodeAction#PasteJoinNodeAction(Object,ActivityGraph) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the content kind attribute doesn't equal
     * to PseudostateKind.JOIN and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_WrongKind() {
        content = new PseudostateImpl();
        try {
            new PasteJoinNodeAction(content, activityGraph);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}