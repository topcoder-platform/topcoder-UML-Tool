/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifier.feature;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationOrderAction;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UpdateOperationOrderAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UpdateOperationOrderActionUnitTests extends TestCase {
    /**
     * Represents the UpdateOperationOrderAction instance used for tests.
     */
    private UpdateOperationOrderAction testUpdateOperationOrderAction;

    /**
     * Represents the classifier to update operation order.
     */
    private Classifier classifier;

    /**
     * Represents the operation to be updated position.
     */
    private Operation operation;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        classifier = new ClassImpl();
        operation = new OperationImpl();
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(operation);
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());
        // try to update the operation position from 1 to 4 in the list.
        testUpdateOperationOrderAction = new UpdateOperationOrderAction(classifier, operation, 1);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The operation will be moved to
     * position 1.
     */
    public void testUndoAction() {
        testUpdateOperationOrderAction.redoAction();
        testUpdateOperationOrderAction.undoAction();
        assertEquals("UpdateOperationOrderAction undoAction incorrectly", 1, classifier.getFeatures()
                .indexOf(operation));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The operation will be moved to
     * position 3.
     */
    public void testRedoAction() {
        testUpdateOperationOrderAction.redoAction();
        assertEquals("UpdateOperationOrderAction redoAction incorrectly", 3, classifier.getFeatures()
                .indexOf(operation));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The operation will be moved to
     * position 3.
     */
    public void testExecuteAction() {
        testUpdateOperationOrderAction.redoAction();
        assertEquals("UpdateOperationOrderAction executeAction incorrectly", 3, classifier.getFeatures().indexOf(
                operation));
    }

    /**
     * Test UpdateOperationOrderAction constructor.
     */
    public void testUpdateOperationOrderAction() {
        assertNotNull("Create UpdateOperationOrderAction incorrectly.", testUpdateOperationOrderAction);
        assertEquals("Create UpdateOperationOrderAction incorrectly.", classifier,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationOrderAction, "classifier"));
        assertEquals("Create UpdateOperationOrderAction incorrectly.", 3,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationOrderAction, "newPosition"));
        assertEquals("Create UpdateOperationOrderAction incorrectly.", 1,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationOrderAction, "oldPosition"));
    }

    /**
     * Test UpdateOperationOrderAction constructor with null classifier. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateOperationOrderActionNullClassifier() {
        try {
            new UpdateOperationOrderAction(null, operation, 1);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateOperationOrderAction constructor with null Operation. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateOperationOrderActionNullOperation() {
        try {
            new UpdateOperationOrderAction(classifier, null, 1);
            fail("IllegalArgumentException should be thrown when the passed operation is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateOperationOrderAction constructor with negative position. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateOperationOrderActionNegativePosition() {
        try {
            new UpdateOperationOrderAction(classifier, operation, -1);
            fail("IllegalArgumentException should be thrown when the passed newPosition is negative.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateOperationOrderAction constructor with too large position. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateOperationOrderActionTooLargePosition() {
        try {
            new UpdateOperationOrderAction(classifier, operation, 2);
            fail("IllegalArgumentException should be thrown when the passed newPosition"
                    + "is greater than operations.size.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
