/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.general.operationtypes.UpdateDocumentationTagsOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UpdateDocumentationTagsAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UpdateDocumentationTagsActionUnitTests extends TestCase {
    /**
     * Represents the UpdateDocumentationTagsAction instance used for tests.
     */
    private UpdateDocumentationTagsAction testUpdateDocumentationTagsAction;

    /**
     * Represents the TaggedValue to update the data value.
     */
    private TaggedValue taggedValue;

    /**
     * Represents the old documentations of the tags before this action performed.
     */
    private Map<TaggedValue, String> oldDocumentations;

    /**
     * Represents the new documentations of the tags after this action performed.
     */
    private Map<TaggedValue, String> newDocumentations;

    /**
     * Represents the element which will be tested with action.
     */
    private ModelElement element;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        oldDocumentations = new HashMap<TaggedValue, String>();
        newDocumentations = new HashMap<TaggedValue, String>();
        taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("oldValue");
        oldDocumentations.put(taggedValue, "oldValue");
        newDocumentations.put(taggedValue, "newValue");
        testUpdateDocumentationTagsAction = new UpdateDocumentationTagsAction(element, newDocumentations,
                UpdateDocumentationTagsOperationType.UPDATE);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The dataValue of the taggedValue
     * will be set to *oldValue*.
     */
    public void testUndoAction() {
        testUpdateDocumentationTagsAction.undoAction();
        assertEquals("UpdateDocumentationTagsAction undoAction incorrectly", "oldValue", taggedValue.getDataValue());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The dataValue of the taggedValue
     * will be set to *newValue*.
     */
    public void testRedoAction() {
        testUpdateDocumentationTagsAction.redoAction();
        assertEquals("UpdateDocumentationTagsAction redoAction incorrectly", "newValue", taggedValue.getDataValue());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The dataValue of the
     * taggedValue will be set to *newValue*.
     */
    public void testExecuteAction() {
        testUpdateDocumentationTagsAction.executeAction();
        assertEquals("UpdateDocumentationTagsAction executeAction incorrectly", "newValue",
                taggedValue.getDataValue());
    }

    /**
     * Test UpdateDocumentationTagsAction constructor.
     */
    public void testUpdateDocumentationTagsAction() {
        assertNotNull("Create UpdateDocumentationTagsAction incorrectly.", testUpdateDocumentationTagsAction);
        assertEquals("Create UpdateDocumentationTagsAction incorrectly.", element,
                UnitTestsHelper.getObjectFieldValue(testUpdateDocumentationTagsAction, "element"));
        assertEquals("Create UpdateDocumentationTagsAction incorrectly.", oldDocumentations,
                UnitTestsHelper.getObjectFieldValue(testUpdateDocumentationTagsAction, "oldDocumentations"));
        assertEquals("Create UpdateDocumentationTagsAction incorrectly.", newDocumentations,
                UnitTestsHelper.getObjectFieldValue(testUpdateDocumentationTagsAction, "newDocumentations"));
        assertEquals("Create UpdateDocumentationTagsAction incorrectly.", UpdateDocumentationTagsOperationType.UPDATE,
                UnitTestsHelper.getObjectFieldValue(testUpdateDocumentationTagsAction, "operationType"));
    }

    /**
     * Test UpdateDocumentationTagsAction constructor with null element. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateDocumentationTagsActionNullElement() {
        try {
            new UpdateDocumentationTagsAction(null, newDocumentations, UpdateDocumentationTagsOperationType.ADD);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateDocumentationTagsAction constructor with null newDocumentions. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateDocumentationTagsActionNullNewDocumentions() {
        try {
            new UpdateDocumentationTagsAction(new OperationImpl(), null, UpdateDocumentationTagsOperationType.ADD);
            fail("IllegalArgumentException should be thrown when the passed new document is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateDocumentationTagsAction constructor with null update kind. Should throw
     * IllegalArgumentException.
     */
    public void testUpdateDocumentationTagsActionNullUpdateKind() {
        try {
            new UpdateDocumentationTagsAction(new OperationImpl(), newDocumentations, null);
            fail("IllegalArgumentException should be thrown when the passed updateKind is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
