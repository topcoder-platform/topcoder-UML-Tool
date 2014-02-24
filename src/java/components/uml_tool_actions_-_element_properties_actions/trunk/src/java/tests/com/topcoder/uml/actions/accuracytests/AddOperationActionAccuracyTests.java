/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy test cases for AddOperationAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class AddOperationActionAccuracyTests extends TestCase {
    /**
     * Represents the AddOperationAction instance used for tests.
     */
    private AddOperationAction instance;

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
        AccuracyHelper.loadDefaultConfig();
        classifier = new ClassImpl();
        operation = new OperationImpl();
        instance = new AddOperationAction(classifier, operation);
    }

    /**
     * Clear the environment.
     *
     * @throws Exception exception to JUnit.
     */
    protected void tearDown() throws Exception {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertFalse("undoAction() is incorrect.", classifier.containsFeature(operation));
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertTrue("redoAction() is incorrect", classifier.containsFeature(operation));
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception{

            instance.executeAction();
            assertTrue("executeAction is incorrect.", classifier.containsFeature(operation));
    }

    /**
     * Test constructor.
     */
    public void testAddOperationAction() {
        assertEquals("The classifier is incorrect.", classifier, AccuracyHelper
            .getObjectFieldValue(instance, "classifier"));
        assertEquals("The operation is incorrect.", operation, AccuracyHelper.getObjectFieldValue(
            instance, "operation"));

    }
}
