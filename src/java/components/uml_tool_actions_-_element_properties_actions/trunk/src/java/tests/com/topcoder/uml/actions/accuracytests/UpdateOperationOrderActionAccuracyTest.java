/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationOrderAction;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy test cases for UpdateOperationOrderAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UpdateOperationOrderActionAccuracyTest extends TestCase {
    /**
     * Represents the UpdateOperationOrderAction instance used for tests.
     */
    private UpdateOperationOrderAction instance;

    /**
     * Represents the classifier to update attribute order.
     */
    private Classifier classifier;

    /**
     * Represents the attribute to be updated position.
     */
    private Operation operation;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        classifier = new ClassImpl();
        operation = new OperationImpl();

        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(operation);
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());

        instance = new UpdateOperationOrderAction(classifier, operation, 2);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", 2, classifier.getFeatures().indexOf(operation));
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", 4, classifier.getFeatures().indexOf(operation));
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", 4, classifier.getFeatures()
            .indexOf(operation));
    }

    /**
     * Test UpdateAttributeOrderAction constructor.
     */
    public void testUpdateAttributeOrderAction1() {
        assertEquals("oldPosition is incorrect.", 2, AccuracyHelper.getObjectFieldValue(instance,
            "oldPosition"));
        assertEquals("newPosition is incorrect.", 4, AccuracyHelper.getObjectFieldValue(instance,
            "newPosition"));
    }

    /**
     * Test UpdateAttributeOrderAction constructor.
     */
    public void testUpdateAttributeOrderAction2() {
        classifier = new ClassImpl();
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());

        instance = new UpdateOperationOrderAction(classifier, operation, 1);
        assertEquals("oldPosition is incorrect.", -1, AccuracyHelper.getObjectFieldValue(instance,
            "oldPosition"));
        assertEquals("newPosition is incorrect.", -1, AccuracyHelper.getObjectFieldValue(instance,
            "newPosition"));
    }


}
