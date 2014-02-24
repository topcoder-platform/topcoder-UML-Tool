/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeOrderAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy test cases for UpdateAttributeOrderAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UpdateAttributeOrderActionAccuracyTests extends TestCase {
    /**
     * Represents the UpdateAttributeOrderAction instance used for tests.
     */
    private UpdateAttributeOrderAction instance;

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
        AccuracyHelper.loadDefaultConfig();
        classifier = new ClassImpl();
        attribute = new AttributeImpl();
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(attribute);
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());

        instance = new UpdateAttributeOrderAction(classifier, attribute, 2);
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
        assertEquals("undoAction() is incorrect.", 2, classifier.getFeatures().indexOf(attribute));
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", 4, classifier.getFeatures().indexOf(attribute));
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", 4, classifier.getFeatures()
            .indexOf(attribute));
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
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());

        instance = new UpdateAttributeOrderAction(classifier, attribute, 1);
        assertEquals("oldPosition is incorrect.", -1, AccuracyHelper.getObjectFieldValue(instance,
            "oldPosition"));
        assertEquals("newPosition is incorrect.", -1, AccuracyHelper.getObjectFieldValue(instance,
            "newPosition"));
    }

}
