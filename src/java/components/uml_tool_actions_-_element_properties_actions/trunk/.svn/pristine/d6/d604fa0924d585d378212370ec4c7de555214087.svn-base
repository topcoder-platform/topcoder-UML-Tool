/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.ChangeEntityNameAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;

/**
 * Accuracy test cases for ChangeEntityNameAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeEntityNameActionAccuracyTest extends TestCase {

    /**
     * Represents the ChangeEntityNameAction instance used for tests.
     */
    private ChangeEntityNameAction instance;

    /**
     * Represents the model element to change the name.
     */
    private ModelElement element;

    /**
     * Represents the old name of the model element before the action performed.
     */
    private final String oldName = "oldName";

    /**
     * Represents the new name of the model element the action will performed.
     */
    private final String newName = "newName";

    /**
     * Set up the test environment.
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        AccuracyHelper.loadDefaultConfig();
        element = new OperationImpl();
        element.setName(oldName);
        instance = new ChangeEntityNameAction(element, newName);
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
        assertEquals("undoAction() is incorrect.", oldName, element.getName());
    }

    /**
     * test redoAction();
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newName, element.getName());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newName, element.getName());
    }

    /**
     * Test constructor.
     */
    public void TestChangeEntityNameAction1() {

        ChangeEntityNameAction instance1 = new ChangeEntityNameAction(element, newName);
        assertEquals("oldName is incorrect.", oldName, AccuracyHelper.getObjectFieldValue(
            instance1, "oldName"));
        assertEquals("oldName is incorrect.", newName, AccuracyHelper.getObjectFieldValue(
            instance1, "newName"));
    }

    /**
     * Test constructor.
     */
    public void TestChangeEntityNameAction2() {
        element = new OperationImpl();
        ChangeEntityNameAction instance1 = new ChangeEntityNameAction(element, " ");
        assertEquals("oldName is incorrect.", null, AccuracyHelper.getObjectFieldValue(instance1,
            "oldName"));
        assertEquals("oldName is incorrect.", " ", AccuracyHelper.getObjectFieldValue(instance1,
            "newName"));
    }

}
