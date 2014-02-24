/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UpdateVisibilityAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UpdateVisibilityActionTests extends TestCase {
    /**
     * <p>
     * UpdateVisibilityAction instance for testing.
     * </p>
     */
    private UpdateVisibilityAction action;

    /**
     * <p>
     * GraphNode instance for testing.
     * </p>
     */
    private GraphNode node;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        node = new GraphNode();
        node.setVisible(true);

        action = new UpdateVisibilityAction(node, false);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        node = null;
        action = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UpdateVisibilityActionTests.class);
    }

    /**
     * <p>
     * Tests ctor UpdateVisibilityAction#UpdateVisibilityAction(GraphElement,boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateVisibilityAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new UpdateVisibilityAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor UpdateVisibilityAction#UpdateVisibilityAction(GraphElement,boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullElement() {
        try {
            new UpdateVisibilityAction(null, false);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateVisibilityAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The visibility should be updated to false and the action can be un-done.
     * </p>
     */
    public void testExecute() {
        action.execute();

        assertFalse("The visibility should be updated to false.", node.isVisible());
        assertTrue("The action should can be un-done.", action.canUndo());
    }
}