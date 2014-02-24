/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;


/**
 * <p>
 * Unit tests for {@link RemoveDiagramAction}. It tests the constructor and <code>executeAction</code>,
 * <code>undoAction</code>, <code>redoAction</code> methods.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveDiagramActionTest extends BaseTestCase {
    /**
     * <p>
     * RemoveDiagramAction instance used for testing.
     * </p>
     */
    private RemoveDiagramAction action;

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
        return new TestSuite(RemoveDiagramActionTest.class);
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
        diagram.setName("Name");
        action = new MockRemoveDiagramAction(diagram);
        // add the diagram at first.
        UML_MODEL_MANAGER.addDiagram(diagram);
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
     * Tests constructor for 'RemoveDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveDiagramAction(Diagram) is correct and the instance should not be null.
     * </p>
     */
    public void testRemoveDiagramAction() {
        assertNotNull("The RemoveDiagramAction instance should not be null.", action);
        assertEquals("The presentation name is incorrect.",
                "Remove diagram " + diagram.getName(), action.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'RemoveDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the name of the diagram is null and verify that RemoveDiagramAction(Diagram) is correct.
     * </p>
     */
    public void testRemoveDiagramActionWithDiagramWithNullName() {
        MockRemoveDiagramAction removeAction = new MockRemoveDiagramAction(new Diagram());
        assertNotNull("The RemoveDiagramAction instance should not be null.", removeAction);
        assertEquals("The presentation name is incorrect.",
                "Remove diagram untitled", removeAction.getPresentationName());
    }

    /**
     * <p>
     * Tests constructor for 'RemoveDiagramAction(Diagram)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that RemoveDiagramAction is a subclass of UndoableAbstractAction.
     * </p>
     */
    public void testRemoveDiagramActionForInheritance() {
        assertNotNull("The RemoveDiagramAction should be a subclass of UndoableAbstractAction",
                action instanceof UndoableAbstractAction);
    }

    /**
     * <p>
     * Tests constructor for 'RemoveDiagramAction(Diagram)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the Diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveDiagramActionWithNullDiagram() {
        try {
            new MockRemoveDiagramAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests method for 'undoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify undoAction() is correct. A newly created Diagram has been added again to the UMLModelManager.
     * </p>
     */
    public void testUndoAction() {
        action.executeAction();
        action.undoAction();
        // check whether the diagram is added again
        assertTrue("The diagram should be added again to the UMLModelManager.",
                UML_MODEL_MANAGER.containsDiagram(diagram));
    }

    /**
     * <p>
     * Tests method for 'redoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redoAction() is correct. The newly created Diagram has been removed again from the UMLModelManager.
     * </p>
     */
    public void testRedoAction() {
        action.redoAction();
        // check whether the diagram is removed
        assertFalse("The diagram should be removed.", UML_MODEL_MANAGER.containsDiagram(diagram));
    }

    /**
     * <p>
     * Tests method for 'executeAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify executeAction() is correct. A newly created Diagram has been removed from the UMLModelManager.
     * </p>
     */
    public void testExecuteAction() {
        action.executeAction();
        // check whether the diagram is removed
        assertFalse("The diagram should be removed.", UML_MODEL_MANAGER.containsDiagram(diagram));
    }
}
