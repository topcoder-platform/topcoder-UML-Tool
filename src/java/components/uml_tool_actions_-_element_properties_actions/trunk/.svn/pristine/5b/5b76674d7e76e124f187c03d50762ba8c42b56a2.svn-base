/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.ChangeDocumentationAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

/**
 * Accuracy test cases for ChangeDocumentationAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeDocumentationActionAccuracyTest extends TestCase {

    /**
     * Represents the ChangeDocumentationAction instance used for tests.
     */
    private ChangeDocumentationAction instance;

    /**
     * Represents the &quot;documentation&quot; taggedValue of the model element to be change the
     * documentation.
     */
    private TaggedValue taggedValue;

    /**
     * Represents the old documentation of the model element before this action performed.
     */
    private final String oldDocument = "old document";

    /**
     * Represents the new documentation of the model element after this action performed.
     */
    private final String newDocument = "new document";

    /**
     * Set up the test environment.
     */
    protected void setUp() throws Exception {
        AccuracyHelper.loadDefaultConfig();
        ModelElement element = new OperationImpl();
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("documentation");
        taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(oldDocument);
        element.addTaggedValue(taggedValue);
        instance = new ChangeDocumentationAction(element, newDocument);
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
        assertEquals("undoAction() is incorrect.", oldDocument, taggedValue.getDataValue());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newDocument, taggedValue.getDataValue());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newDocument, taggedValue.getDataValue());
    }

    /**
     * Test constructor.
     *
     * @throws Exception exception to JUnit.
     */
    public void testChangeDocumentationAction1() throws Exception {
        ModelElement element = new OperationImpl();
        ChangeDocumentationAction instance1 = new ChangeDocumentationAction(element, newDocument);
        assertEquals("ChangeDocumentationAction() is incorrect.", newDocument, AccuracyHelper
            .getObjectFieldValue(instance1, "newDocumentation"));
        assertEquals("ChangeDocumentationAction() is incorrect.", null, AccuracyHelper
            .getObjectFieldValue(instance1, "oldDocumentation"));
    }

    /**
     * Test constructor.
     *
     * @throws Exception exception to JUnit.
     */
    public void testChangeDocumentationAction2() throws Exception {
        assertEquals("ChangeDocumentationAction() is incorrect.", newDocument, AccuracyHelper
            .getObjectFieldValue(instance, "newDocumentation"));
        assertEquals("ChangeDocumentationAction() is incorrect.", oldDocument, AccuracyHelper
            .getObjectFieldValue(instance, "oldDocumentation"));
    }
}
