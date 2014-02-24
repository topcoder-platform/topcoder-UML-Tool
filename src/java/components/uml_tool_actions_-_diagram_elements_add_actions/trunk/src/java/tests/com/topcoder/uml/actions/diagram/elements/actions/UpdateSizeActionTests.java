/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for UpdateSizeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UpdateSizeActionTests extends TestCase {
    /**
     * <p>
     * UpdateSizeAction instance for testing.
     * </p>
     */
    private UpdateSizeAction action;

    /**
     * <p>
     * GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode element;

    /**
     * <p>
     * Dimension instance for helping testing.
     * </p>
     */
    private Dimension newSize;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        // Set up the graph node
        element = new GraphNode();
        Dimension oldSize = new Dimension();
        oldSize.setHeight(10D);
        oldSize.setWidth(10D);
        element.setSize(oldSize);

        // Set up the new size for the graph node
        newSize = new Dimension();
        newSize.setHeight(100D);
        newSize.setWidth(100D);

        action = new UpdateSizeAction(element, newSize);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        element = null;
        newSize = null;
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
        return new TestSuite(UpdateSizeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor UpdateSizeAction#UpdateSizeAction(GraphElement,Dimension) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created UpdateSizeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new UpdateSizeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor UpdateSizeAction#UpdateSizeAction(GraphElement,Dimension) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when element is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullElement() {
        try {
            new UpdateSizeAction(null, newSize);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor UpdateSizeAction#UpdateSizeAction(GraphElement,Dimension) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newSize is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNewSize() {
        try {
            new UpdateSizeAction(element, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests UpdateSizeAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The size is updated and the action can be un-done.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        assertEquals("The size should be updated.", newSize, element.getSize());
        assertTrue("The action should can be un-done.", action.canUndo());
    }

    /**
     * <p>
     * Tests UpdateSizeAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the element is not of GraphNode type and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_ActionExecutionException() {
        action = new UpdateSizeAction(new GraphEdge(), newSize);

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }
}