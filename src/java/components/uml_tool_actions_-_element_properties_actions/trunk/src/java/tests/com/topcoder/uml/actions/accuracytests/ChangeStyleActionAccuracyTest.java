/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.uml.actions.general.ChangeStyleAction;

/**
 * Accuracy test cases for ChangeStyleAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeStyleActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangeStyleAction instance used for tests.
     */
    private ChangeStyleAction instance;

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
        AccuracyHelper.loadDefaultConfig();
        DiagramElement element = new GraphNode();
        property = new Property();
        oldValue = "oldValue";
        newValue = "newValue";
        property.setKey("testKey");
        property.setValue(oldValue);
        element.addProperty(property);
        instance = new ChangeStyleAction(element, "testKey", newValue);

    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldValue, property.getValue());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newValue, property.getValue());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {
        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newValue, property.getValue());

    }

    /**
     * Test constructor.
     */
    public void testChangeStyleAction1() {
        assertEquals("property is incorrect.", property, AccuracyHelper.getObjectFieldValue(
            instance, "property"));
        assertEquals("oldValue is incorrect.", oldValue, AccuracyHelper.getObjectFieldValue(
            instance, "oldValue"));
        assertEquals("newValue is incorrect.", newValue, AccuracyHelper.getObjectFieldValue(
            instance, "newValue"));
    }

    /**
     * Test constructor.
     */
    public void testChangeStyleAction2() {
        ChangeStyleAction instance2 = new ChangeStyleAction(new GraphNode(), "NotExist", newValue);
        assertEquals("oldValue is incorrect.", null, AccuracyHelper.getObjectFieldValue(instance2,
            "oldValue"));
        assertEquals("newValue is incorrect.", newValue, AccuracyHelper.getObjectFieldValue(
            instance2, "newValue"));
    }
}
