/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeActiveActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeActiveActionTest extends TestCase {
    /**
     * Represents the ChangeActiveAction instance used for tests.
     */
    private ChangeActiveAction testChangeActiveAction;

    /**
     * Represents the class model element to change the active.
     */
    private Class element;

    /**
     * Represents the old active of the model element before the action performed.
     */
    private final boolean oldActive = true;

    /**
     * Represents the new active of the model element the action will performed.
     */
    private final boolean newActive = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new ClassImpl();
        element.setActive(oldActive);
        testChangeActiveAction = new ChangeActiveAction(element, newActive);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The active value of the ModelElememt should be set to
     * oldActive;
     */
    public void testUndoAction() {
        testChangeActiveAction.undoAction();
        assertEquals("ChangeActiveAction undoAction incorrectly.", oldActive, element.isActive());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The active value of the ModelElememt should be set to
     * newActive;
     */
    public void testRedoAction() {
        testChangeActiveAction.redoAction();
        assertEquals("ChangeActiveAction redoAction incorrectly.", newActive, element.isActive());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The active value of the ModelElememt should be set
     * to newActive;
     */
    public void testExecuteAction() {
        testChangeActiveAction.executeAction();
        assertEquals("ChangeActiveAction executeAction incorrectly.", newActive, element.isActive());
    }

    /**
     * Test ChangeActiveAction constructor.
     */
    public void testChangeActiveActionConstructor() {
        UndoableAbstractAction action = new ChangeActiveAction(element, oldActive);
        assertNotNull("Create ChangeActiveAction incorrectly.", action);
    }

    /**
     * Test ChangeActiveAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeActiveActionConstructorNullElement() {
        try {
            new ChangeActiveAction(null, oldActive);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
