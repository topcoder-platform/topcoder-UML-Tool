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
 * Test the functionality of <code>ChangeFinalActionTest.java</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeFinalActionTest extends TestCase {
    /**
     * Represents the ChangeFinalAction instance used for tests.
     */
    private ChangeFinalAction testChangeFinalAction;

    /**
     * Represents the operation model element to change the final.
     */
    private Operation element;

    /**
     * Represents the old final of the model element before the action performed.
     */
    private final boolean oldFinal = true;

    /**
     * Represents the new final of the model element the action will performed.
     */
    private final boolean newFinal = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        element.setLeaf(oldFinal);
        testChangeFinalAction = new ChangeFinalAction(element, newFinal);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The final value of the ModelElememt should be set to
     * oldFinal;
     */
    public void testUndoAction() {
        testChangeFinalAction.undoAction();
        assertEquals("ChangeFinalAction undoAction incorrectly.", oldFinal, element.isLeaf());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The final value of the ModelElememt should be set to
     * newFinal;
     */
    public void testRedoAction() {
        testChangeFinalAction.redoAction();
        assertEquals("ChangeFinalAction redoAction incorrectly.", newFinal, element.isLeaf());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The final value of the ModelElememt should be set
     * to newFinal;
     */
    public void testExecuteAction() {
        testChangeFinalAction.executeAction();
        assertEquals("ChangeFinalAction executeAction incorrectly.", newFinal, element.isLeaf());
    }

    /**
     * Test ChangeFinalAction constructor.
     */
    public void testChangeFinalActionConstructor() {
        UndoableAbstractAction action = new ChangeFinalAction(element, oldFinal);
        assertNotNull("Create ChangeFinalAction incorrectly.", action);
    }

    /**
     * Test ChangeFinalAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeFinalActionConstructorNullElement() {
        try {
            new ChangeFinalAction(null, oldFinal);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
