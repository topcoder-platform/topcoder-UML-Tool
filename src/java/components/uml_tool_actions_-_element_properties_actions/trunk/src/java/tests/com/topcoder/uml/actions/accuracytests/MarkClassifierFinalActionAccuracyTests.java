/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.MarkClassifierFinalAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy test cases for MarkClassifierFinalAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class MarkClassifierFinalActionAccuracyTests extends TestCase {
    /**
     * Represents the MarkClassifierFinalAction instance used for tests.
     */
    private MarkClassifierFinalAction instance;

    /**
     * Represents the classifier to change the isLeaf attribute.
     */
    private Classifier classifier;

    /**
     * Represents the new isLeaf attribute of the classifier.
     */
    private boolean newIsLeaf;

    /**
     * Represents the old isLeaf attribute of the classifier before this action performed.
     */
    private boolean oldIsLeaf;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        classifier = new ClassImpl();
        newIsLeaf = false;
        oldIsLeaf = true;
        classifier.setLeaf(oldIsLeaf);
        instance = new MarkClassifierFinalAction(classifier, newIsLeaf);
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
        assertEquals("undoAction() is incorrect.", oldIsLeaf, classifier.isLeaf());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newIsLeaf, classifier.isLeaf());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("MarkClassifierFinalAction executeAction incorrectly", newIsLeaf, classifier
            .isLeaf());
    }

    /**
     * Test constructor.
     */
    public void testMarkClassifierFinalAction() {
        assertEquals("classifier is incorrect.", classifier, AccuracyHelper.getObjectFieldValue(
            instance, "classifier"));
        assertEquals("oldIsLeaf is incorrect.", oldIsLeaf, AccuracyHelper.getObjectFieldValue(
            instance, "oldIsLeaf"));
        assertEquals("newIsLeaf is incorrect.", newIsLeaf, AccuracyHelper.getObjectFieldValue(
            instance, "newIsLeaf"));

    }

}
