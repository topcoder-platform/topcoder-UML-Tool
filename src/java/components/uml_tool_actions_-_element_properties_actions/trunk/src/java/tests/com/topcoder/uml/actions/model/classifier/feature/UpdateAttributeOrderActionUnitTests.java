/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifier.feature;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeOrderAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UpdateAttributeOrderAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UpdateAttributeOrderActionUnitTests extends TestCase {
    /**
     * Represents the UpdateAttributeOrderAction instance used for tests.
     */
    private UpdateAttributeOrderAction testUpdateAttributeOrderAction;

    /**
     * Represents the classifier to update attribute order.
     */
    private Classifier classifier;

    /**
     * Represents the attribute to be updated position.
     */
    private Attribute attribute;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        classifier = new ClassImpl();
        attribute = new AttributeImpl();
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(attribute);
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());
        // try to update the attribute position from 1 to 4 in the list.
        testUpdateAttributeOrderAction = new UpdateAttributeOrderAction(classifier, attribute, 1);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The attribute will be moved to
     * position 1.
     */
    public void testUndoAction() {
        testUpdateAttributeOrderAction.redoAction();
        testUpdateAttributeOrderAction.undoAction();
        assertEquals("UpdateAttributeOrderAction undoAction incorrectly", 1, classifier.getFeatures()
                .indexOf(attribute));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The attribute will be moved to
     * position 3.
     */
    public void testRedoAction() {
        testUpdateAttributeOrderAction.redoAction();
        assertEquals("UpdateAttributeOrderAction redoAction incorrectly", 3, classifier.getFeatures()
                .indexOf(attribute));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The attribute will be moved to
     * position 3.
     */
    public void testExecuteAction() {
        testUpdateAttributeOrderAction.redoAction();
        assertEquals("UpdateAttributeOrderAction executeAction incorrectly", 3, classifier.getFeatures().indexOf(
                attribute));
    }

    /**
     * Test UpdateAttributeOrderAction constructor.
     */
    public void testUpdateAttributeOrderAction() {
        assertNotNull("Create UpdateAttributeOrderAction incorrectly.", testUpdateAttributeOrderAction);
        assertEquals("Create UpdateAttributeOrderAction incorrectly.", classifier,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeOrderAction, "classifier"));
        assertEquals("Create UpdateAttributeOrderAction incorrectly.", 3,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeOrderAction, "newPosition"));
        assertEquals("Create UpdateAttributeOrderAction incorrectly.", 1,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeOrderAction, "oldPosition"));
    }

    /**
     * Test UpdateAttributeOrderAction constructor with null classifier. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateAttributeOrderActionNullClassifier() {
        try {
            new UpdateAttributeOrderAction(null, attribute, 1);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateAttributeOrderAction constructor with null attribute. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateAttributeOrderActionNullAttribute() {
        try {
            new UpdateAttributeOrderAction(classifier, null, 1);
            fail("IllegalArgumentException should be thrown when the passed attribute is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateAttributeOrderAction constructor with negative position. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateAttributeOrderActionNegativePosition() {
        try {
            new UpdateAttributeOrderAction(classifier, attribute, -1);
            fail("IllegalArgumentException should be thrown when the passed newPosition is negative.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateAttributeOrderAction constructor with too large position. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateAttributeOrderActionTooLargePosition() {
        try {
            new UpdateAttributeOrderAction(classifier, attribute, 2);
            fail("IllegalArgumentException should be thrown when the passed newPosition"
                    + " is greater than the attributes.size.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
