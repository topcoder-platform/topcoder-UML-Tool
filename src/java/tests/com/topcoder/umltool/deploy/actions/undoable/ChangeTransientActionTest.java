/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeTransientActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeTransientActionTest extends TestCase {
    /**
     * Represents the ChangeTransientAction instance used for tests.
     */
    private ChangeTransientAction testChangeTransientAction;

    /**
     * Represents the association end model element to change the transient.
     */
    private AssociationEnd element;

    /**
     * Represents the old transient of the model element before the action performed.
     */
    private final boolean oldTransient = true;

    /**
     * Represents the new transient of the model element the action will performed.
     */
    private final boolean newTransient = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        TagDefinitionImpl tagDefinitionImpl = new TagDefinitionImpl();
        tagDefinitionImpl.setTagType("transient");
        TaggedValueImpl taggedValueImpl = new TaggedValueImpl();
        taggedValueImpl.setType(tagDefinitionImpl);
        taggedValueImpl.setDataValue(String.valueOf(oldTransient));
        element.addTaggedValue(taggedValueImpl);
        testChangeTransientAction = new ChangeTransientAction(element, newTransient);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The transient value of the ModelElememt should be set
     * to oldTransient;
     */
    public void testUndoAction() {
        testChangeTransientAction.undoAction();
        assertEquals("ChangeTransientAction undoAction incorrectly.", String.valueOf(oldTransient),
                getTaggedValue("transient"));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The transient value of the ModelElememt should be set
     * to newTransient;
     */
    public void testRedoAction() {
        testChangeTransientAction.redoAction();
        assertEquals("ChangeTransientAction redoAction incorrectly.", String.valueOf(newTransient),
                getTaggedValue("transient"));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The transient value of the ModelElememt should be
     * set to newTransient;
     */
    public void testExecuteAction() {
        testChangeTransientAction.executeAction();
        assertEquals("ChangeTransientAction executeAction incorrectly.", String.valueOf(newTransient),
                getTaggedValue("transient"));
    }

    /**
     * Test ChangeTransientAction constructor.
     */
    public void testChangeTransientActionConstructor() {
        UndoableAbstractAction action = new ChangeTransientAction(element, oldTransient);
        assertNotNull("Create ChangeTransientAction incorrectly.", action);
    }

    /**
     * Test ChangeTransientAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeTransientActionConstructorNullElement() {
        try {
            new ChangeTransientAction(null, oldTransient);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Gets the tagged value's data value.
     * @param type
     *            the tagged value's type
     * @return the data value
     */
    private String getTaggedValue(String type) {
        for (TaggedValue taggedValue : element.getTaggedValues()) {
            TagDefinition tagDefinition = taggedValue.getType();
            if (type.equals(tagDefinition.getTagType())) {
                // The TaggedValue is found
                return taggedValue.getDataValue();
            }
        }
        return "";
    }
}
