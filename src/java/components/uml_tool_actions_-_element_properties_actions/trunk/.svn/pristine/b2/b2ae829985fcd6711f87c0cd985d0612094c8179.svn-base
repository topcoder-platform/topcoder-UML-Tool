/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.general;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.actions.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the ChangeStyleAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class ChangeStyleActionUnitTests extends TestCase {
    /**
     * Represents the ChangeStyleAction instance used for tests.
     */
    private ChangeStyleAction testChangeStyleAction;

    /**
     * Represents the property of the style.
     */
    private Property property;

    /**
     * Represents the old value of the property before this action performed.
     */
    private String oldValue;

    /**
     * Represents the new value of the property after this action performed.
     */
    private String newValue;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        DiagramElement element = new GraphNode();
        property = new Property();
        oldValue = "oldValue";
        newValue = "newValue";
        property.setKey("testKey");
        property.setValue(oldValue);
        element.addProperty(property);
        testChangeStyleAction = new ChangeStyleAction(element, "testKey", newValue);

    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The value of the Property should
     * be set to oldValue.
     */
    public void testUndoAction() {
        testChangeStyleAction.undoAction();
        assertEquals("ChangeStyleAction undoAction incorrectly", oldValue, property.getValue());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The value of the Property should
     * be set to newValue.
     */
    public void testRedoAction() {
        testChangeStyleAction.redoAction();
        assertEquals("ChangeStyleAction redoAction incorrectly", newValue, property.getValue());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The value of the Property
     * should be set to newValue.
     */
    public void testExecuteAction() {
        testChangeStyleAction.executeAction();
        assertEquals("ChangeStyleAction executeAction incorrectly", newValue, property.getValue());
    }

    /**
     * Test ChangeStyleAction constructor.
     */
    public void testChangeStyleAction() {
        GraphNode node = new GraphNode();
        UndoableAbstractAction action = new ChangeStyleAction(node, "key", "value");
        assertNotNull("Create ChangeStyleAction incorrectly.", action);
        assertEquals("Create ChangeStyleAction incorrectly.", "value",
                UnitTestsHelper.getObjectFieldValue(action, "newValue"));
        assertEquals("Create ChangeStyleAction incorrectly.", 1,
                node.getProperties().size());
    }

    /**
     * Test ChangeStyleAction constructor with null node. Should throw IllegalArgumentException.
     */
    public void testChangeStyleActionNullNode() {
        try {
            assertNotNull("Create ChangeStyleAction incorrectly.", new ChangeStyleAction(null, "key", "value"));
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeStyleAction constructor with null key. Should throw IllegalArgumentException.
     */
    public void testChangeStyleActionNullKey() {
        try {
            assertNotNull("Create ChangeStyleAction incorrectly.",
                    new ChangeStyleAction(new GraphNode(), null, "value"));
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeStyleAction constructor with null value. Should throw IllegalArgumentException.
     */
    public void testChangeStyleActionNullValue() {
        try {
            assertNotNull("Create ChangeStyleAction incorrectly.", new ChangeStyleAction(new GraphNode(), "key", null));
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
