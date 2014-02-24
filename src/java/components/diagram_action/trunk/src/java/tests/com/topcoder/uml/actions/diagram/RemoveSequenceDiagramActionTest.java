/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * Unit tests for {@link RemoveSequenceDiagramAction}. It tests the constructor and the <code>executeAction</code>,
 * <code>undoAction</code>, <code>redoAction</code> methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveSequenceDiagramActionTest extends BaseTestCase {

    /**
     * <p>
     * RemoveSequenceDiagramAction instance used for testing.
     * </p>
     */
    private RemoveSequenceDiagramAction action;

    /**
     * <p>
     * Diagram instance used for testing.
     * </p>
     */
    private Diagram diagram;

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(RemoveSequenceDiagramActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void setUp() throws Exception {
        super.setUp();
        diagram = new Diagram();
        diagram.setName("Sequence Diagram");
        action = new RemoveSequenceDiagramAction(diagram);
    }

    /**
     * <p>
     * Tears down environment.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void tearDown() throws Exception {
        super.tearDown();
        diagram = null;
        action = null;
    }


    /**
     * <p>
     * Tests constructor for 'RemoveSequenceDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveSequenceDiagramAction(Diagram) is correct and the instance should not be null.
     * </p>
     */
    public void testRemoveSequenceDiagramAction() {
        assertNotNull("The RemoveSequenceDiagramAction instance should not be null.", action);
        assertEquals("The presentation name is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'RemoveSequenceDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveSequenceDiagramAction is a subclass of RemoveDiagramAction.
     * </p>
     */
    public void testRemoveSequenceDiagramActionForInheritance() {
        assertNotNull("The RemoveSequenceDiagramAction should be a subclass of RemoveDiagramAction",
                action instanceof RemoveDiagramAction);
    }

    /**
     * <p>
     * Tests constructor for 'RemoveSequenceDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the Diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveSequenceDiagramActionWithNullDiagram() {
        try {
            new RemoveSequenceDiagramAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}
