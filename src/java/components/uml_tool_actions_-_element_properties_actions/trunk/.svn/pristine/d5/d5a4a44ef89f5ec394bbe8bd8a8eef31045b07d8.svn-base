/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UpdateDocumentationTagsAction;
import com.topcoder.uml.actions.general.operationtypes.UpdateDocumentationTagsOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

/**
 * Accuracy test cases for UpdateDocumentationTagsAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UpdateDocumentationTagsActionAccuracyTest extends TestCase {
    /**
     * Represents the UpdateDocumentationTagsAction instance used for tests.
     */
    private UpdateDocumentationTagsAction instance;

    /**
     * Represents the TaggedValue to update the data value.
     */
    private TaggedValue taggedValue;

    /**
     * Represents the old documentation of the tags before this action performed.
     */
    private Map<TaggedValue, String> oldDocumentations;

    /**
     * Represents the new documentation of the tags after this action performed.
     */
    private Map<TaggedValue, String> newDocumentations;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        ModelElement element = new OperationImpl();
        oldDocumentations = new HashMap<TaggedValue, String>();
        newDocumentations = new HashMap<TaggedValue, String>();
        taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("oldValue");
        oldDocumentations.put(taggedValue, "oldValue");
        newDocumentations.put(taggedValue, "newValue");
        instance = new UpdateDocumentationTagsAction(element, newDocumentations,
            UpdateDocumentationTagsOperationType.UPDATE);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction()</code>.
     */
    public void testUndoAction() {
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", "oldValue", taggedValue.getDataValue());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", "newValue", taggedValue.getDataValue());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", "newValue", taggedValue.getDataValue());
    }

    /**
     * Test constructor.
     */
    public void testUpdateDocumentationTagsAction1() {
        ModelElement element = new OperationImpl();
        instance = new UpdateDocumentationTagsAction(element, newDocumentations,
            UpdateDocumentationTagsOperationType.ADD);

        assertEquals("operationType is incorrect.", UpdateDocumentationTagsOperationType.ADD,
            AccuracyHelper.getObjectFieldValue(instance, "operationType"));
        assertNull("oldDocumentations is incorrect.", AccuracyHelper.getObjectFieldValue(instance,
            "oldDocumentations"));
        HashMap documentations = (HashMap) AccuracyHelper.getObjectFieldValue(instance,
            "newDocumentations");
        assertEquals("newDocumentations is incorrect.", "newValue", documentations.get(taggedValue));
    }

    /**
     * Test constructor.
     */
    public void testUpdateDocumentationTagsAction2() {

        assertEquals("operationType is incorrect.", UpdateDocumentationTagsOperationType.UPDATE,
            AccuracyHelper.getObjectFieldValue(instance, "operationType"));
        assertNotNull("oldDocumentations is incorrect.", AccuracyHelper.getObjectFieldValue(
            instance, "oldDocumentations"));
        HashMap documentations = (HashMap) AccuracyHelper.getObjectFieldValue(instance,
            "newDocumentations");
        assertEquals("newDocumentations is incorrect.", "newValue", documentations.get(taggedValue));
    }

}
