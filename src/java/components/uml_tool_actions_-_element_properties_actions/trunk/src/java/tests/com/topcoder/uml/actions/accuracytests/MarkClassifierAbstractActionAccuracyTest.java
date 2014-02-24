/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.MarkClassifierAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy test cases for MarkClassifierAbstractAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class MarkClassifierAbstractActionAccuracyTest extends TestCase {
    /**
     * Represents the MarkClassifierAbstractAction instance used for tests.
     */
    private MarkClassifierAbstractAction instance;

    /**
     * Represents the classifier to change the isAbstract attributes.
     */
    private Classifier classifier;

    /**
     * Represents the old isAbstract attribute of the classifier before this action performed.
     */
    private boolean oldIsAbstract;

    /**
     * Represents the new isAbstract attribute of the classifier after this action performed.
     */
    private boolean newIsAbstract;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        classifier = new ClassImpl();
        oldIsAbstract = false;
        newIsAbstract = true;
        classifier.setAbstract(oldIsAbstract);
        instance = new MarkClassifierAbstractAction(classifier, newIsAbstract);
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
        assertEquals("undoAction() is incorrect.", oldIsAbstract, classifier.isAbstract());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newIsAbstract, classifier.isAbstract());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newIsAbstract, classifier.isAbstract());
    }

    /**
     * Test constructor.
     */
    public void testMarkClassifierAbstractAction() {
        assertEquals("classifier is incorrect.", classifier, AccuracyHelper.getObjectFieldValue(
            instance, "classifier"));
        assertEquals("oldIsAbstract is incorrect.", oldIsAbstract, AccuracyHelper
            .getObjectFieldValue(instance, "oldIsAbstract"));
        assertEquals("newIsAbstract is incorrect.", newIsAbstract, AccuracyHelper
            .getObjectFieldValue(instance, "newIsAbstract"));
    }

}
