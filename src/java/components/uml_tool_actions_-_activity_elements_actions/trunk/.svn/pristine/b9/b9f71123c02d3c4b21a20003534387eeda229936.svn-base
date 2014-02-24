/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.MockedStateVertex;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * <p>
 * Failure test for <code>PasteStateNodeAbstractAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteStateNodeAbstractActionFailureTest extends TestCase {

    /**
     * <p>
     * The name.
     * </p>
     */
    private String name = "name";

    /**
     * <p>
     * The StateVertex instance created for testing.
     * </p>
     */
    private StateVertex state;

    /**
     * <p>
     * The ActivityGraph instance created for testing.
     * </p>
     */
    private ActivityGraph activityGraph;

    /**
     * <p>
     * Set up the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        state = new MockedStateVertex(name);
        activityGraph = new ActivityGraphImpl();
    }

    /**
     * <p>
     * Clear the namespace.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * name is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullName() {
        try {
            new MockedPasteStateNodeAbstractAction(null, state, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * name is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionEmptyName() {
        try {
            new MockedPasteStateNodeAbstractAction(" ", state, activityGraph);
            fail("name is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullState() {
        try {
            new MockedPasteStateNodeAbstractAction(name, null, activityGraph);
            fail("content is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * activityGraph is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionNullActivityGraph() {
        try {
            new MockedPasteStateNodeAbstractAction(name, state, null);
            fail("activityGraph is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>PasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph)</code>.
     * </p>
     * <p>
     * content is not of type SimpleState, IllegalArgumentException is expected.
     * </p>
     */
    public void testPasteStateNodeAbstractActionInvalidObject() {
        try {
            new MockedPasteStateNodeAbstractAction(name, new Object(), null);
            fail("content is not of type SimpleState, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
