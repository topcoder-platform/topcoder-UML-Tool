/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeEntityNameAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeEntityNameActionUnitTests extends TestCase {
    /**
     * Represents the ChangeEntityNameAction instance used for tests.
     */
    private ChangeEntityNameAction testChangeEntityNameAction;

    /**
     * Represents the model element to change the name.
     */
    private ModelElement element;

    /**
     * Represents the old name of the model element before the action performed.
     */
    private final String oldName = "oldName";

    /**
     * Represents the new name of the model element the action will performed.
     */
    private final String newName = "newName";

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        element.setName(oldName);
        testChangeEntityNameAction = new ChangeEntityNameAction(element, newName);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The name of the ModelElememt
     * should be set to oldName;
     */
    public void testUndoAction() {
        testChangeEntityNameAction.undoAction();
        assertEquals("ChangeEntityNameAction undoAction incorrectly.", oldName, element.getName());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The name of the ModelElememt
     * should be set to newName;
     */
    public void testRedoAction() {
        testChangeEntityNameAction.redoAction();
        assertEquals("ChangeEntityNameAction redoAction incorrectly.", newName, element.getName());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The name of the ModelElememt
     * should be set to newName;
     */
    public void testExecuteAction() {
        testChangeEntityNameAction.executeAction();
        assertEquals("ChangeEntityNameAction executeAction incorrectly.", newName, element.getName());
    }

    /**
     * Test ChangeEntityNameAction constructor.
     */
    public void testChangeEntityNameActionConstructor() {
        UndoableAbstractAction action = new ChangeEntityNameAction(element, "new name");
        assertNotNull("Create ChangeEntityNameAction incorrectly.", action);
        assertEquals("Create ChangeEntityNameAction incorrectly.", "new name",
                UnitTestsHelper.getObjectFieldValue(action, "newName"));
        assertEquals("Create ChangeEntityNameAction incorrectly.", element,
                UnitTestsHelper.getObjectFieldValue(action, "element"));
    }

    /**
     * Test ChangeEntityNameAction constructor with null element. Should throw
     * IllegalArgumentException.
     */
    public void testChangeEntityNameActionConstructorNullElement() {
        try {
            new ChangeEntityNameAction(null, "new name");
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeEntityNameAction constructor with null new name. Should throw
     * IllegalArgumentException.
     */
    public void testChangeEntityNameActionConstructorNullNewName() {
        try {
            new ChangeEntityNameAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new name is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
