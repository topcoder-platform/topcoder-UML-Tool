/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * Unit tests for {@link RemoveClassDiagramAction}. It tests the constructor and the <code>executeAction</code>,
 * <code>undoAction</code>, <code>redoAction</code> methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveClassDiagramActionTest extends BaseTestCase {

    /**
     * <p>
     * RemoveClassDiagramAction instance used for testing.
     * </p>
     */
    private RemoveClassDiagramAction action;

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
        return new TestSuite(RemoveClassDiagramActionTest.class);
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
        diagram.setName("Class Diagram");
        action = new RemoveClassDiagramAction(diagram);
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
     * Tests constructor for 'RemoveClassDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveClassDiagramAction(Diagram) is correct and the instance should not be null.
     * </p>
     */
    public void testRemoveClassDiagramAction() {
        assertNotNull("The RemoveClassDiagramAction instance should not be null.", action);
        assertEquals("The presentation name is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'RemoveClassDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveClassDiagramAction is a subclass of RemoveDiagramAction.
     * </p>
     */
    public void testRemoveClassDiagramActionForInheritance() {
        assertNotNull("The RemoveClassDiagramAction should be a subclass of RemoveDiagramAction",
                action instanceof RemoveDiagramAction);
    }

    /**
     * <p>
     * Tests constructor for 'RemoveClassDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the Diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveClassDiagramActionWithNullDiagram() {
        try {
            new RemoveClassDiagramAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}
