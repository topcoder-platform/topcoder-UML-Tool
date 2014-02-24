/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifier.feature;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the AddOperationAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class AddOperationActionUnitTests extends TestCase {
    /**
     * Represents the AddOperationAction instance used for tests.
     */
    private AddOperationAction testAddOperationAction;

    /**
     * Represents the classifier to add operation.
     */
    private Classifier classifier;

    /**
     * Represents the operation to be add to the classifier.
     */
    private Operation operation;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        classifier = new ClassImpl();
        operation = new OperationImpl();
        testAddOperationAction = new AddOperationAction(classifier, operation);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The operation should be removed
     * from the classifier.
     */
    public void testUndoAction() {
        testAddOperationAction.undoAction();
        assertFalse("AddOperationAction undoAction incorrectly", classifier.containsFeature(operation));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The operation should be added to
     * the classifier.
     */
    public void testRedoAction() {
        testAddOperationAction.redoAction();
        assertTrue("AddOperationAction redoAction incorrectly", classifier.containsFeature(operation));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The operation should be added
     * to the classifier.
     */
    public void testExecuteAction() {
        testAddOperationAction.executeAction();
        assertTrue("AddOperationAction executeAction incorrectly", classifier.containsFeature(operation));
    }

    /**
     * Test AddOperationAction constructor.
     */
    public void testAddOperationAction() {
        UndoableAbstractAction action = new AddOperationAction(classifier, operation);
        assertNotNull("Create AddOperationAction incorrectly.", action);
        assertEquals("Create AddOperationAction incorrectly.", classifier,
                UnitTestsHelper.getObjectFieldValue(action, "classifier"));
        assertEquals("Create AddOperationAction incorrectly.", operation,
                UnitTestsHelper.getObjectFieldValue(action, "operation"));
    }

    /**
     * Test AddOperationAction constructor with null classifier. Should throw
     * IllegalArgumentException.
     */
    public void testAddOperationActionNullClassifier() {
        try {
            new AddOperationAction(null, operation);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test AddOperationAction constructor with null operation. Should throw
     * IllegalArgumentException.
     */
    public void testAddOperationActionNullAttribute() {
        try {
            new AddOperationAction(classifier, null);
            fail("IllegalArgumentException should be thrown when the passed attribute is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
