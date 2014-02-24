/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeEntityVisibilityAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeEntityVisibilityActionUnitTests extends TestCase {
    /**
     * Represents the ChangeEntityVisibilityAction instance used for tests.
     */
    private ChangeEntityVisibilityAction testChangeEntityVisibilityAction;

    /**
     * Represents the model element to change the visibility.
     */
    private ModelElement element;

    /**
     * Represents the old visibility of the model element before this action performed.
     */
    private final VisibilityKind oldVisibility = VisibilityKind.PACKAGE;

    /**
     * Represents the new visibility of the model element this action will perform.
     */
    private final VisibilityKind newVisibility = VisibilityKind.PUBLIC;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        element.setVisibility(oldVisibility);
        testChangeEntityVisibilityAction = new ChangeEntityVisibilityAction(element, newVisibility);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The Visibility value of the
     * ModelElememt should be set to oldVisibility.
     */
    public void testUndoAction() {
        testChangeEntityVisibilityAction.undoAction();
        assertEquals("ChangeEntityVisibilityAction undoAction incorrectly", oldVisibility, element.getVisibility());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The Visibility value of the
     * ModelElememt should be set to newVisibility.
     */
    public void testRedoAction() {
        testChangeEntityVisibilityAction.redoAction();
        assertEquals("ChangeEntityVisibilityAction redoAction incorrectly", newVisibility, element.getVisibility());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The Visibility value of the
     * ModelElememt should be set to newVisibility.
     */
    public void testExecuteAction() {
        testChangeEntityVisibilityAction.executeAction();
        assertEquals("ChangeEntityVisibilityAction executeAction incorrectly", newVisibility,
                element.getVisibility());
    }

    /**
     * Test ChangeEntityVisibilityAction constructor.
     */
    public void testChangeEntityVisibilityActionConstructor() {
        UndoableAbstractAction action = new ChangeEntityVisibilityAction(element, VisibilityKind.PRIVATE);
        assertNotNull("Create ChangeEntityVisibilityAction incorrectly.", action);
        assertEquals("Create ChangeEntityVisibilityAction incorrectly.",
                VisibilityKind.PRIVATE, UnitTestsHelper.getObjectFieldValue(action, "newVisibility"));
        assertEquals("Create ChangeEntityVisibilityAction incorrectly.", element,
                UnitTestsHelper.getObjectFieldValue(action, "element"));
    }

    /**
     * Test ChangeEntityVisibilityAction constructor with null element. Should throw
     * IllegalArgumentException.
     */
    public void testChangeEntityVisibilityActionConstructorNullElement() {
        try {
            new ChangeEntityVisibilityAction(null, VisibilityKind.PRIVATE);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeEntityVisibilityAction constructor with null VisibilityKind. Should throw
     * IllegalArgumentException.
     */
    public void testChangeEntityVisibilityActionConstructorNullKind() {
        try {
            new ChangeEntityVisibilityAction(element, null);
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
