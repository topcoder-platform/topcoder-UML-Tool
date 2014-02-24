/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;

import junit.framework.TestCase;

/**
 * Accuracy test cases for ChangeEntityVisibilityAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class ChangeEntityVisibilityActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangeEntityVisibilityAction instance used for tests.
     */
    private ChangeEntityVisibilityAction instance;

    /**
     * Represents the model element to change the visibility.
     */
    private ModelElement element;

    /**
     * Represents the old visibility of the model element before this action performed.
     */
    private final VisibilityKind oldVisibility = VisibilityKind.PACKAGE;

    /**
     * Represents the new visibility of the model element this action will perform.
     */
    private final VisibilityKind newVisibility = VisibilityKind.PUBLIC;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        element = new OperationImpl();
        element.setVisibility(oldVisibility);
        instance = new ChangeEntityVisibilityAction(element, newVisibility);
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
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldVisibility, element.getVisibility());
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.undoAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect", newVisibility, element.getVisibility());
    }

    /**
     * Test executeAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();

        assertEquals("executeAction() is incorrect.", newVisibility, element.getVisibility());

    }

    /**
     * Test constructor.
     */
    public void testChangeEntityVisibilityActionConstructor() {
        assertTrue("newVisibility is incorrect.", newVisibility.equals(AccuracyHelper
            .getObjectFieldValue(instance, "newVisibility")));
        assertTrue("oldVisibility is incorrect.", oldVisibility.equals(AccuracyHelper
            .getObjectFieldValue(instance, "oldVisibility")));
    }

}
