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
 * Unit test for the MarkClassifierFinalAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class MarkClassifierFinalActionUnitTests extends TestCase {
    /**
     * Represents the MarkClassifierFinalAction instance used for tests.
     */
    private MarkClassifierFinalAction testMarkClassifierFinalAction;

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
        classifier = new ClassImpl();
        newIsLeaf = false;
        oldIsLeaf = true;
        classifier.setLeaf(oldIsLeaf);
        testMarkClassifierFinalAction = new MarkClassifierFinalAction(classifier, newIsLeaf);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The classifier should be set to
     * oldIsAbstract.
     */
    public void testUndoAction() {
        testMarkClassifierFinalAction.undoAction();
        assertEquals("MarkClassifierFinalAction undoAction incorrectly", oldIsLeaf, classifier.isLeaf());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The classifier should be set to
     * newIsLeaf.
     */
    public void testRedoAction() {
        testMarkClassifierFinalAction.redoAction();
        assertEquals("MarkClassifierFinalAction redoAction incorrectly", newIsLeaf, classifier.isLeaf());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The classifier should be set to
     * newIsLeaf.
     */
    public void testExecuteAction() {
        testMarkClassifierFinalAction.executeAction();
        assertEquals("MarkClassifierFinalAction executeAction incorrectly", newIsLeaf, classifier.isLeaf());
    }

    /**
     * Test MarkClassifierFinalAction constructor.
     */
    public void testMarkClassifierFinalAction() {
        UndoableAbstractAction action = new MarkClassifierFinalAction(classifier, newIsLeaf);
        assertNotNull("Create MarkClassifierFinalAction incorrectly.", action);
        assertEquals("Create MarkClassifierFinalAction incorrectly.", classifier,
                UnitTestsHelper.getObjectFieldValue(action, "classifier"));
        assertEquals("Create MarkClassifierFinalAction incorrectly.", newIsLeaf,
                UnitTestsHelper.getObjectFieldValue(action, "newIsLeaf"));
        assertEquals("Create MarkClassifierFinalAction incorrectly.", oldIsLeaf,
                UnitTestsHelper.getObjectFieldValue(action, "oldIsLeaf"));
    }

    /**
     * Test MarkClassifierFinalAction constructor with null classifier. Should throw
     * IllegalArgumentException.
     */
    public void testMarkClassifierFinalActionNullClassifier() {
        try {
            new MarkClassifierFinalAction(null, newIsLeaf);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
