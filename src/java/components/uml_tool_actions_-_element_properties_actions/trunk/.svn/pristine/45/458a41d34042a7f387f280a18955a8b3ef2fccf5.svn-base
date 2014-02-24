/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy test cases for AddAttributeAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class AddAttributeActionAccuracyTest extends TestCase {
    /**
     * Represents the AddAttributeAction instance used for tests.
     */
    private AddAttributeAction instance;

    /**
     * Represents the classifier to add attribute.
     */
    private Classifier classifier;

    /**
     * Represents the attribute to be add to the classifier.
     */
    private Attribute attribute;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        classifier = new ClassImpl();
        attribute = new AttributeImpl();
        instance = new AddAttributeAction(classifier, attribute);
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
        instance.undoAction();
        assertFalse("undoAction() is incorrect.", classifier.containsFeature(attribute));
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertTrue("redoAction() is incorrect", classifier.containsFeature(attribute));
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertTrue("executeAction() is incorrect.", classifier.containsFeature(attribute));
    }

    /**
     * Test constructor.
     */
    public void testAddAttributeAction() {
        assertEquals("The classifier is incorrect.", classifier, AccuracyHelper
            .getObjectFieldValue(instance, "classifier"));
        assertEquals("The attribute is incorrect.", attribute, AccuracyHelper.getObjectFieldValue(
            instance, "attribute"));
    }

}