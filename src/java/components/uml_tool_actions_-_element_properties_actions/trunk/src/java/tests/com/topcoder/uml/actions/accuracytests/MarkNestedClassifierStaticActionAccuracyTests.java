/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.MarkNestedClassifierStaticAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

/**
 * Accuracy test cases for MarkNestedClassifierStaticAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class MarkNestedClassifierStaticActionAccuracyTests extends TestCase {
    /**
     * Represents the MarkNestedClassifierStaticAction instance used for tests.
     */
    private MarkNestedClassifierStaticAction instance;

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
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        oldIsStatic = false;
        newIsStatic = true;
        Classifier classifier = new ClassImpl();

        TagDefinition definition2 = new TagDefinitionImpl();
        TaggedValue taggedValue2 = new TaggedValueImpl();
        definition2.setTagType("Not_static");
        taggedValue2.setType(definition2);
        taggedValue2.setDataValue(Boolean.toString(newIsStatic));
        classifier.addTaggedValue(taggedValue2);

        taggedValue = new TaggedValueImpl();
        TagDefinition definition = new TagDefinitionImpl();
        definition.setTagType("static");
        taggedValue.setType(definition);
        taggedValue.setDataValue(Boolean.toString(oldIsStatic));
        classifier.addTaggedValue(taggedValue);

        instance = new MarkNestedClassifierStaticAction(classifier, newIsStatic);
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
        assertEquals("undoAction() is incorrect.", Boolean.toString(oldIsStatic), taggedValue
            .getDataValue());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction()is incorrect.", Boolean.toString(newIsStatic), taggedValue
            .getDataValue());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", Boolean.toString(newIsStatic), taggedValue
            .getDataValue());
    }

    /**
     * Test constructor.
     */
    public void testMarkNestedClassifierStaticAction() {
        assertEquals("oldIsStatic is incorrect.", oldIsStatic, AccuracyHelper.getObjectFieldValue(
            instance, "oldIsStatic"));
        assertEquals("newIsStatic is incorrect.", newIsStatic, AccuracyHelper.getObjectFieldValue(
            instance, "newIsStatic"));
    }
}
