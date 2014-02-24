/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifier.feature;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the AddAttributeAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class AddAttributeActionUnitTests extends TestCase {
    /**
     * Represents the AddAttributeAction instance used for tests.
     */
    private AddAttributeAction testAddAttributeAction;

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
        classifier = new ClassImpl();
        attribute = new AttributeImpl();
        testAddAttributeAction = new AddAttributeAction(classifier, attribute);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The attribute should be removed
     * from the classifier.
     */
    public void testUndoAction() {
        testAddAttributeAction.undoAction();
        assertFalse("AddAttributeAction undoAction incorrectly", classifier.containsFeature(attribute));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The attribute should be added to
     * the classifier.
     */
    public void testRedoAction() {
        testAddAttributeAction.redoAction();
        assertTrue("AddAttributeAction redoAction incorrectly", classifier.containsFeature(attribute));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The attribute should be added
     * to the classifier.
     */
    public void testExecuteAction() {
        testAddAttributeAction.executeAction();
        assertTrue("AddAttributeAction executeAction incorrectly", classifier.containsFeature(attribute));
    }

    /**
     * Test AddAttributeAction constructor.
     */
    public void testAddAttributeAction() {
        UndoableAbstractAction action = new AddAttributeAction(classifier, attribute);
        assertNotNull("Create AddAttributeAction incorrectly.", action);
        assertEquals("Create AddAttributeAction incorrectly.", classifier,
                UnitTestsHelper.getObjectFieldValue(action, "classifier"));
        assertEquals("Create AddAttributeAction incorrectly.", attribute,
                UnitTestsHelper.getObjectFieldValue(action, "attribute"));
    }

    /**
     * Test AddAttributeAction constructor with null classifier. Should throw
     * IllegalArgumentException.
     */
    public void testAddAttributeActionNullClassifier() {
        try {
            new AddAttributeAction(null, attribute);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test AddAttributeAction constructor with null attribute. Should throw
     * IllegalArgumentException.
     */
    public void testAddAttributeActionNullAttribute() {
        try {
            new AddAttributeAction(classifier, null);
            fail("IllegalArgumentException should be thrown when the passed attribute is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
