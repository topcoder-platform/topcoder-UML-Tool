/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the MarkClassifierAbstractAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class MarkClassifierAbstractActionUnitTests extends TestCase {

    /**
     * Represents the MarkClassifierAbstractAction instance used for tests.
     */
    private MarkClassifierAbstractAction testMarkClassifierAbstractAction;

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
        classifier = new ClassImpl();
        oldIsAbstract = false;
        newIsAbstract = true;
        classifier.setAbstract(oldIsAbstract);
        testMarkClassifierAbstractAction = new MarkClassifierAbstractAction(classifier, newIsAbstract);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The classifier should be set to
     * oldIsAbstract.
     */
    public void testUndoAction() {
        testMarkClassifierAbstractAction.undoAction();
        assertEquals("MarkClassifierAbstractAction undoAction incorrectly", oldIsAbstract, classifier.isAbstract());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The classifier should be set to
     * newIsAbstract.
     */
    public void testRedoAction() {
        testMarkClassifierAbstractAction.redoAction();
        assertEquals("MarkClassifierAbstractAction redoAction incorrectly", newIsAbstract, classifier.isAbstract());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The classifier should be set to
     * newIsAbstract.
     */
    public void testExecuteAction() {
        testMarkClassifierAbstractAction.executeAction();
        assertEquals("MarkClassifierAbstractAction executeAction incorrectly", newIsAbstract,
                classifier.isAbstract());
    }

    /**
     * Test MarkClassifierAbstractAction constructor.
     */
    public void testMarkClassifierAbstractAction() {
        UndoableAbstractAction action = new MarkClassifierAbstractAction(classifier, newIsAbstract);
        assertNotNull("Create MarkClassifierAbstractAction incorrectly.", action);
        assertEquals("Create MarkClassifierAbstractAction incorrectly.", classifier,
                UnitTestsHelper.getObjectFieldValue(action, "classifier"));
        assertEquals("Create MarkClassifierAbstractAction incorrectly.", newIsAbstract,
                UnitTestsHelper.getObjectFieldValue(action, "newIsAbstract"));
        assertEquals("Create MarkClassifierAbstractAction incorrectly.", oldIsAbstract,
                UnitTestsHelper.getObjectFieldValue(action, "oldIsAbstract"));
    }

    /**
     * Test MarkClassifierAbstractAction constructor with null classifier. Should throw
     * IllegalArgumentException.
     */
    public void testMarkClassifierAbstractActionNullClassifier() {
        try {
            new MarkClassifierAbstractAction(null, newIsAbstract);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
