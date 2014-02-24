/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests for {@link ChangeDiagramTitleAction}. It tests the constructor and the <code>execute</code> method.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ChangeDiagramTitleActionTest extends BaseTestCase {
    /**
     * <p>
     * ChangeDiagramTitleAction instance used for testing.
     * </p>
     */
    private ChangeDiagramTitleAction action;

    /**
     * <p>
     * String variable representing the new name of the diagram.
     * </p>
     */
    private String newName = "new Name";

    /**
     * <p>
     * String variable representing the old name of the diagram.
     * </p>
     */
    private String oldName = "old Name";

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
        return new TestSuite(ChangeDiagramTitleActionTest.class);
    }

    /**
     * <p>
     * Sets up environment.
     * </p>
     * @throws Exception to Junit
     */
    public void setUp() throws Exception {
        super.setUp();
        diagram = new Diagram();
        diagram.setName(oldName);
        action = new ChangeDiagramTitleAction(diagram, newName);
    }

    /**
     * <p>
     * Tears Down environment.
     * </p>
     * @throws Exception to Junit
     */
    public void tearDown() throws Exception {
        super.tearDown();
        diagram = null;
        action = null;
    }

    /**
     * <p>
     * Tests constructor for 'ChangeDiagramTitleAction(Diagram, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that ChangeDiagramTitleAction(Diagram, String) is correct and the instance should not be null.
     * </p>
     */
    public void testChangeDiagramTitleAction() {
        assertNotNull("ChangeDiagramTitleAction instance should not be null.", action);
    }

    /**
     * <p>
     * Tests constructor for 'ChangeDiagramTitleAction(Diagram, String)' for accuracy.
     * </p>
     *
     * <p>
     * Verify that ChangeDiagramTitleAction(Diagram, Double) is correct and the instance should be a subclass of
     * UndoableAbstractAction.
     * </p>
     */
    public void testChangeDiagramTitleActionForInheritace() {
        assertTrue("ChangeDiagramTitleAction instance should be a subclass of UndoableAbstractAction.",
                action instanceof UndoableAbstractAction);
    }

    /**
     * <p>
     * Tests constructor for 'ChangeDiagramTitleAction(Diagram, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the newName is null and expects no IllegalArgumentException.
     * </p>
     */
    public void testChangeDiagramTitleActionWithNullNewName() {
        assertNotNull("ChangeDiagramTitleAction instance should not be null.",
                new ChangeDiagramTitleAction(diagram, null));
    }

    /**
     * <p>
     * Tests constructor for 'ChangeDiagramTitleAction(Diagram, String)' for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that the newName is empty and expects no IllegalArgumentException.
     * </p>
     */
    public void testChangeDiagramTitleActionWithEmptyNewName() {
        assertNotNull("ChangeDiagramTitleAction instance should not be null.",
                new ChangeDiagramTitleAction(diagram, "  "));
    }

    /**
     * <p>
     * Tests constructor for 'ChangeDiagramTitleAction(Diagram, String)' for failure.
     * </p>
     *
     * <p>
     * It tests the case that the diagram is null and expects IllegalArgumentException.
     * </p>
     */
    public void testChangeDiagramTitleActionWithNullDiagram() {
        try {
            new ChangeDiagramTitleAction(null, newName);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }


    /**
     * <p>
     * Tests method for 'executeAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that executeAction() is correct and the title of the diagram is changed.
     * </p>
     *
     * @throws ActionExecutionException to Junit
     */
    public void testExecuteAction() throws ActionExecutionException {
        action.executeAction();
        assertEquals("The title of the diagram is incorrect.", newName, diagram.getName());
    }

    /**
     * <p>
     * Tests method for 'undoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify that undoAction() is correct and the title of the diagram is not changed.
     * </p>
     * @throws Exception to Junit
     */
    public void testUndoAction() throws Exception {
        action.executeAction();
        action.undoAction();
        assertEquals("The title of the diagram is incorrect.", oldName, diagram.getName());
    }

    /**
     * <p>
     * Tests method for 'redoAction()' for accuracy.
     * </p>
     *
     * <p>
     * Verify redoAction() is correct.
     * </p>
     *
     * @throws Exception to Junit
     */
    public void testRedoAction() throws Exception {
        action.executeAction();
        action.undoAction();
        action.redoAction();
        assertEquals("The title of the diagram is incorrect.", newName, diagram.getName());
    }
}
