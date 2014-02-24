/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;

/**
 * <p>
 * Test the functionality of <code>ChangeKindActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeKindActionTest extends TestCase {
    /**
     * Represents the ChangeKindAction instance used for tests.
     */
    private ChangeKindAction testChangeKindAction;

    /**
     * Represents the parameter model element to change the kind.
     */
    private Parameter element;

    /**
     * Represents the old kind of the model element before the action performed.
     */
    private final ParameterDirectionKind oldKind = ParameterDirectionKind.IN;

    /**
     * Represents the new kind of the model element the action will performed.
     */
    private final ParameterDirectionKind newKind = ParameterDirectionKind.OUT;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new ParameterImpl();
        element.setKind(oldKind);
        testChangeKindAction = new ChangeKindAction(element, newKind);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The kind value of the ModelElememt should be set to
     * oldKind;
     */
    public void testUndoAction() {
        testChangeKindAction.undoAction();
        assertEquals("ChangeKindAction undoAction incorrectly.", oldKind, element.getKind());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The kind value of the ModelElememt should be set to
     * newKind;
     */
    public void testRedoAction() {
        testChangeKindAction.redoAction();
        assertEquals("ChangeKindAction redoAction incorrectly.", newKind, element.getKind());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The kind value of the ModelElememt should be set to
     * newKind;
     */
    public void testExecuteAction() {
        testChangeKindAction.executeAction();
        assertEquals("ChangeKindAction executeAction incorrectly.", newKind, element.getKind());
    }

    /**
     * Test ChangeKindAction constructor.
     */
    public void testChangeKindActionConstructor() {
        UndoableAbstractAction action = new ChangeKindAction(element, oldKind);
        assertNotNull("Create ChangeKindAction incorrectly.", action);
    }

    /**
     * Test ChangeKindAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeKindActionConstructorNullElement() {
        try {
            new ChangeKindAction(null, oldKind);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeKindAction constructor with null new kind. Should throw IllegalArgumentException.
     */
    public void testChangeKindActionConstructorNullNewKind() {
        try {
            new ChangeKindAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new kind is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
