/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeAbstractAction</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeAbstractActionTest extends TestCase {
    /**
     * Represents the ChangeAbstractAction instance used for tests.
     */
    private ChangeAbstractAction testChangeAbstractAction;

    /**
     * Represents the operation model element to change the abstract.
     */
    private Operation element;

    /**
     * Represents the old abstract of the model element before the action performed.
     */
    private final boolean oldAbstract = true;

    /**
     * Represents the new abstract of the model element the action will performed.
     */
    private final boolean newAbstract = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        element.setAbstract(oldAbstract);
        testChangeAbstractAction = new ChangeAbstractAction(element, newAbstract);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The abstract value of the ModelElememt should be set
     * to oldAbstract;
     */
    public void testUndoAction() {
        testChangeAbstractAction.undoAction();
        assertEquals("ChangeAbstractAction undoAction incorrectly.", oldAbstract, element.isAbstract());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The abstract value of the ModelElememt should be set
     * to newAbstract;
     */
    public void testRedoAction() {
        testChangeAbstractAction.redoAction();
        assertEquals("ChangeAbstractAction redoAction incorrectly.", newAbstract, element.isAbstract());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The abstract value of the ModelElememt should be
     * set to newAbstract;
     */
    public void testExecuteAction() {
        testChangeAbstractAction.executeAction();
        assertEquals("ChangeAbstractAction executeAction incorrectly.", newAbstract, element.isAbstract());
    }

    /**
     * Test ChangeAbstractAction constructor.
     */
    public void testChangeAbstractActionConstructor() {
        UndoableAbstractAction action = new ChangeAbstractAction(element, oldAbstract);
        assertNotNull("Create ChangeAbstractAction incorrectly.", action);
    }

    /**
     * Test ChangeAbstractAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeAbstractActionConstructorNullElement() {
        try {
            new ChangeAbstractAction(null, oldAbstract);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
