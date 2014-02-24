/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangePositionAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangePositionActionUnitTests extends TestCase {
    /**
     * Represents the ChangePositionAction instance used for tests.
     */
    private ChangePositionAction testChangePositionAction;

    /**
     * Represents the graph element to change the position.
     */
    private GraphElement element;

    /**
     * Represents the old position of the graph element before this action performed.
     */
    private Point oldPosition;

    /**
     * Represents the new position of the graph element after this action will perform.
     */
    private Point newPosition;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new GraphNode();
        oldPosition = new Point();
        oldPosition.setX(0.0);
        oldPosition.setY(1.1);
        newPosition = new Point();
        newPosition.setX(1.1);
        newPosition.setY(0.0);
        element.setPosition(oldPosition);
        testChangePositionAction = new ChangePositionAction(element, newPosition);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The position of the GraphElememt
     * should be set to oldPosition.
     */
    public void testUndoAction() {
        testChangePositionAction.undoAction();
        assertEquals("ChangePositionAction undoAction incorrectly", oldPosition, element.getPosition());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The position of the GraphElememt
     * should be set to newPosition.
     */
    public void testRedoAction() {
        testChangePositionAction.redoAction();
        assertEquals("ChangePositionAction redoAction incorrectly", newPosition, element.getPosition());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The position of the
     * GraphElememt should be set to newPosition.
     */
    public void testExecuteAction() {
        testChangePositionAction.executeAction();
        assertEquals("ChangePositionAction executeAction incorrectly", newPosition, element.getPosition());
    }

    /**
     * Test ChangePositionAction constructor.
     */
    public void testChangePositionActionConstructor() {
        UndoableAbstractAction action = new ChangePositionAction(element, newPosition);
        assertNotNull("Create ChangePositionAction incorrectly.", action);
        assertEquals("Create ChangePositionAction incorrectly.", newPosition,
                UnitTestsHelper.getObjectFieldValue(action, "newPosition"));
        assertEquals("Create ChangePositionAction incorrectly.", element,
                UnitTestsHelper.getObjectFieldValue(action, "element"));
    }

    /**
     * Test ChangePositionAction constructor with null GraphElement. Should throw
     * IllegalArgumentException.
     */
    public void testChangePositionActionConstructorNullElement() {
        try {
            new ChangePositionAction(null, newPosition);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangePositionAction constructor with null newPosition. Should throw
     * IllegalArgumentException.
     */
    public void testChangePositionActionConstructorNullNewPosition() {
        try {
            new ChangePositionAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new position is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
