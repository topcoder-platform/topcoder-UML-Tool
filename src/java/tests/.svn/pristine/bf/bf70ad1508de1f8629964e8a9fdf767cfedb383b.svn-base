/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;

/**
 * <p>
 * Test the functionality of <code>ChangeConcurrencyActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeConcurrencyActionTest extends TestCase {
    /**
     * Represents the ChangeConcurrencyAction instance used for tests.
     */
    private ChangeConcurrencyAction testChangeConcurrencyAction;

    /**
     * Represents the operation model element to change the concurrency.
     */
    private Operation element;

    /**
     * Represents the old concurrency of the model element before the action performed.
     */
    private final CallConcurrencyKind oldConcurrency = CallConcurrencyKind.CONCURRENT;

    /**
     * Represents the new concurrency of the model element the action will performed.
     */
    private final CallConcurrencyKind newConcurrency = CallConcurrencyKind.GUARDED;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        element.setConcurrency(oldConcurrency);
        testChangeConcurrencyAction = new ChangeConcurrencyAction(element, newConcurrency);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The concurrency value of the ModelElememt should be
     * set to oldConcurrency;
     */
    public void testUndoAction() {
        testChangeConcurrencyAction.undoAction();
        assertEquals("ChangeConcurrencyAction undoAction incorrectly.", oldConcurrency, element.getConcurrency());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The concurrency value of the ModelElememt should be
     * set to newConcurrency;
     */
    public void testRedoAction() {
        testChangeConcurrencyAction.redoAction();
        assertEquals("ChangeConcurrencyAction redoAction incorrectly.", newConcurrency, element.getConcurrency());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The concurrency value of the ModelElememt should be
     * set to newConcurrency;
     */
    public void testExecuteAction() {
        testChangeConcurrencyAction.executeAction();
        assertEquals("ChangeConcurrencyAction executeAction incorrectly.", newConcurrency, element.getConcurrency());
    }

    /**
     * Test ChangeConcurrencyAction constructor.
     */
    public void testChangeConcurrencyActionConstructor() {
        UndoableAbstractAction action = new ChangeConcurrencyAction(element, oldConcurrency);
        assertNotNull("Create ChangeConcurrencyAction incorrectly.", action);
    }

    /**
     * Test ChangeConcurrencyAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeConcurrencyActionConstructorNullElement() {
        try {
            new ChangeConcurrencyAction(null, oldConcurrency);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeConcurrencyAction constructor with null new concurrency. Should throw IllegalArgumentException.
     */
    public void testChangeConcurrencyActionConstructorNullNewConcurrency() {
        try {
            new ChangeConcurrencyAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new concurrency is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
