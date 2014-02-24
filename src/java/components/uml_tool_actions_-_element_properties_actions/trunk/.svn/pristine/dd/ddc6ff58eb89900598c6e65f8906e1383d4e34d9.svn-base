/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeDocumentationAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeDocumentationActionUnitTests extends TestCase {
    /**
     * Represents the ChangeDocumentationAction instance used for tests.
     */
    private ChangeDocumentationAction testChangeDocumentationAction;

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
    protected void setUp() {
        ModelElement element = new OperationImpl();
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("documentation");
        taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(oldDocument);
        element.addTaggedValue(taggedValue);
        testChangeDocumentationAction = new ChangeDocumentationAction(element, newDocument);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The document value of the
     * ModelElememt should be set to oldDocument.
     */
    public void testUndoAction() {
        testChangeDocumentationAction.undoAction();
        assertEquals("ChangeDocumentationAction undoAction incorrectly", oldDocument, taggedValue.getDataValue());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The document value of the
     * ModelElememt should be set to newDocument.
     */
    public void testRedoAction() {
        testChangeDocumentationAction.redoAction();
        assertEquals("ChangeDocumentationAction redoAction incorrectly", newDocument, taggedValue.getDataValue());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The document value of the
     * ModelElememt should be set to newDocument.
     */
    public void testExecuteAction() {
        testChangeDocumentationAction.executeAction();
        assertEquals("ChangeDocumentationAction executeAction incorrectly",
                newDocument, taggedValue.getDataValue());
    }

    /**
     * Test ChangeDocumentationAction constructor.
     */
    public void testChangeDocumentationActionConstructor() {
        Operation operation = new OperationImpl();
        UndoableAbstractAction action = new ChangeDocumentationAction(operation, "new");
        assertNotNull("Create ChangeDocumentationAction incorrectly.", action);
        assertEquals("Create ChangeDocumentationAction incorrectly.", "new",
                UnitTestsHelper.getObjectFieldValue(action, "newDocumentation"));
    }

    /**
     * Test ChangeDocumentationAction constructor with null ModelElement. Should throw
     * IllegalArgumentException
     */
    public void testChangeDocumentationActionConstructorNullElement() {
        try {
            new ChangeDocumentationAction(null, "new");
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeDocumentationAction constructor with null newDocument. Should throw
     * IllegalArgumentException
     */
    public void testChangeDocumentationActionConstructorNullNewDocument() {
        try {
            new ChangeDocumentationAction(new OperationImpl(), null);
            fail("IllegalArgumentException should be thrown when the passed newDocument is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
