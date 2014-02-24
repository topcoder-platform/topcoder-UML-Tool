/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeTypeActionTest</code> class.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeTypeActionTest extends TestCase {
    /**
     * Represents the ChangeTypeAction instance used for tests.
     */
    private ChangeTypeAction testChangeTypeAction;

    /**
     * Represents the association end model element to change the type.
     */
    private AssociationEnd element;

    /**
     * Represents the old type of the model element before the action performed.
     */
    private final Classifier oldType = new ClassImpl();

    /**
     * Represents the new type of the model element the action will performed.
     */
    private final Classifier newType = new ClassImpl();

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setParticipant(oldType);
        testChangeTypeAction = new ChangeTypeAction(element, newType, false);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The type value of the ModelElememt should be set to
     * oldType;
     */
    public void testUndoAction() {
        testChangeTypeAction.undoAction();
        assertEquals("ChangeTypeAction undoAction incorrectly.", oldType, element.getParticipant());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The type value of the ModelElememt should be set to
     * newType;
     */
    public void testRedoAction() {
        testChangeTypeAction.redoAction();
        assertEquals("ChangeTypeAction redoAction incorrectly.", newType, element.getParticipant());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The type value of the ModelElememt should be set
     * to newType;
     */
    public void testExecuteAction() {
        testChangeTypeAction.executeAction();
        assertEquals("ChangeTypeAction executeAction incorrectly.", newType, element.getParticipant());
    }

    /**
     * Test ChangeTypeAction constructor.
     */
    public void testChangeTypeActionConstructor() {
        UndoableAbstractAction action = new ChangeTypeAction(element, oldType, false);
        assertNotNull("Create ChangeTypeAction incorrectly.", action);
    }

    /**
     * Test ChangeTypeAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeTypeActionConstructorNullElement() {
        try {
            new ChangeTypeAction(null, oldType, false);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeTypeAction constructor with null new type. Should throw IllegalArgumentException.
     */
    public void testChangeTypeActionConstructorNullNewType() {
        try {
            new ChangeTypeAction(element, null, false);
            fail("IllegalArgumentException should be thrown when the passed new type is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
