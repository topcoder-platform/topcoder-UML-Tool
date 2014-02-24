/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the MarkNestedClassifierStaticAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class MarkNestedClassifierStaticActionUnitTests extends TestCase {
    /**
     * Represents the MarkNestedClassifierStaticAction instance used for tests.
     */
    private MarkNestedClassifierStaticAction testMarkNestedClassifierStaticAction;

    /**
     * Represents the classifier to change the static attributes.
     */
    private TaggedValue taggedValue;

    /**
     * Represents the old static attribute of the classifier before this action performed.
     */
    private boolean oldIsStatic;

    /**
     * Represents the new static attribute of the classifier after this action performed.
     */
    private boolean newIsStatic;

    /**
     * Represents the classifier which will be performed.
     */
    private Classifier classifier;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        oldIsStatic = false;
        newIsStatic = true;
        classifier = new ClassImpl();
        taggedValue = new TaggedValueImpl();
        TagDefinition definition = new TagDefinitionImpl();
        definition.setTagType("static");
        taggedValue.setType(definition);
        taggedValue.setDataValue(Boolean.toString(oldIsStatic));
        classifier.addTaggedValue(taggedValue);
        testMarkNestedClassifierStaticAction = new MarkNestedClassifierStaticAction(classifier, newIsStatic);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The classifier will be set to
     * oldIsStatic.
     */
    public void testUndoAction() {
        testMarkNestedClassifierStaticAction.undoAction();
        assertEquals("MarkNestedClassifierStaticAction undoAction incorrectly.", Boolean.toString(oldIsStatic),
                taggedValue.getDataValue());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The classifier will be set to
     * newIsStatic.
     */
    public void testRedoAction() {
        testMarkNestedClassifierStaticAction.redoAction();
        assertEquals("MarkNestedClassifierStaticAction redoAction incorrectly.", Boolean.toString(newIsStatic),
                taggedValue.getDataValue());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The classifier will be set to
     * newIsStatic.
     */
    public void testExecuteAction() {
        testMarkNestedClassifierStaticAction.executeAction();
        assertEquals("MarkNestedClassifierStaticAction executeAction incorrectly.", Boolean.toString(newIsStatic),
                taggedValue.getDataValue());
    }

    /**
     * Test MarkNestedClassifierStaticAction constructor. Should throw IllegalArgumentException.
     */
    public void testMarkNestedClassifierStaticActionConstructor() {
        assertNotNull("Create MarkNestedClassifierStaticAction incorrectly.", testMarkNestedClassifierStaticAction);
        assertEquals("Create MarkClassifierFinalAction incorrectly.", taggedValue,
                UnitTestsHelper.getObjectFieldValue(testMarkNestedClassifierStaticAction, "taggedValue"));
        assertEquals("Create MarkClassifierFinalAction incorrectly.", newIsStatic,
                UnitTestsHelper.getObjectFieldValue(testMarkNestedClassifierStaticAction, "newIsStatic"));
        assertEquals("Create MarkClassifierFinalAction incorrectly.", oldIsStatic,
                UnitTestsHelper.getObjectFieldValue(testMarkNestedClassifierStaticAction, "oldIsStatic"));
    }

    /**
     * Test MarkNestedClassifierStaticAction constructor with null classifier.
     */
    public void testMarkNestedClassifierStaticActionConstructorNullClassifier() {
        try {
            new MarkNestedClassifierStaticAction(null, newIsStatic);
            fail("IllegalArgumentException should be thrown when the passed classifier is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
