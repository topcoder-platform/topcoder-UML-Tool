/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.MockedStateVertex;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * <p>
 * Failure test for <code>RemoveStateNodeAbstractAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveStateNodeAbstractActionFailureTest extends TestCase {
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
     * Set up the environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        state = new MockedStateVertex(name);
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
     * <code>RemoveStateNodeAbstractAction(String name, StateVertex state)</code>.
     * </p>
     * <p>
     * name is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStateNodeAbstractActionNullName() {
        try {
            new MockedRemoveStateNodeAbstractAction(null, state);
            fail("name is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>RemoveStateNodeAbstractAction(String name, StateVertex state)</code>.
     * </p>
     * <p>
     * name is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStateNodeAbstractActionEmptyName() {
        try {
            new MockedRemoveStateNodeAbstractAction(" ", state);
            fail("name is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>RemoveStateNodeAbstractAction(String name, StateVertex state)</code>.
     * </p>
     * <p>
     * state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStateNodeAbstractActionNullState() {
        try {
            new MockedRemoveStateNodeAbstractAction(name, null);
            fail("state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test for
     * <code>RemoveStateNodeAbstractAction(String name, StateVertex state)</code>.
     * </p>
     * <p>
     * container of state is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testRemoveStateNodeAbstractActionNullContainer() {
        try {
            new MockedRemoveStateNodeAbstractAction(name, state);
            fail("container of state is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
