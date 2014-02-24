/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeRootActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeRootActionTest extends TestCase {
    /**
     * Represents the ChangeRootAction instance used for tests.
     */
    private ChangeRootAction testChangeRootAction;

    /**
     * Represents the usecase model element to change the root.
     */
    private UseCase element;

    /**
     * Represents the old root of the model element before the action performed.
     */
    private final boolean oldRoot = true;

    /**
     * Represents the new root of the model element the action will performed.
     */
    private final boolean newRoot = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new UseCaseImpl();
        element.setRoot(oldRoot);
        testChangeRootAction = new ChangeRootAction(element, newRoot);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The root value of the ModelElememt should be set to
     * oldRoot;
     */
    public void testUndoAction() {
        testChangeRootAction.undoAction();
        assertEquals("ChangeRootAction undoAction incorrectly.", oldRoot, element.isRoot());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The root value of the ModelElememt should be set to
     * newRoot;
     */
    public void testRedoAction() {
        testChangeRootAction.redoAction();
        assertEquals("ChangeRootAction redoAction incorrectly.", newRoot, element.isRoot());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The root value of the ModelElememt should be set to
     * newRoot;
     */
    public void testExecuteAction() {
        testChangeRootAction.executeAction();
        assertEquals("ChangeRootAction executeAction incorrectly.", newRoot, element.isRoot());
    }

    /**
     * Test ChangeRootAction constructor.
     */
    public void testChangeRootActionConstructor() {
        UndoableAbstractAction action = new ChangeRootAction(element, oldRoot);
        assertNotNull("Create ChangeRootAction incorrectly.", action);
    }

    /**
     * Test ChangeRootAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeRootActionConstructorNullElement() {
        try {
            new ChangeRootAction(null, oldRoot);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
