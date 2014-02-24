/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeInitialValueActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeInitialValueActionTest extends TestCase {
    /**
     * Represents the ChangeInitialValueAction instance used for tests.
     */
    private ChangeInitialValueAction testChangeInitialValueAction;

    /**
     * Represents the attribute model element to change the initial value.
     */
    private Attribute element;

    /**
     * Represents the old initial value of the model element before the action performed.
     */
    private final String oldInitialValue = "oldvalue";

    /**
     * Represents the new initial value of the model element the action will performed.
     */
    private final String newInitialValue = "newvalue";

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AttributeImpl();
        Expression expression = new ExpressionImpl();
        expression.setBody((String) oldInitialValue);
        element.setInitialValue(expression);
        testChangeInitialValueAction = new ChangeInitialValueAction(element, newInitialValue);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The initial value value of the ModelElememt should be
     * set to oldInitialValue;
     */
    public void testUndoAction() {
        testChangeInitialValueAction.undoAction();
        assertEquals("ChangeInitialValueAction undoAction incorrectly.", oldInitialValue, element.getInitialValue()
                .getBody());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The initial value value of the ModelElememt should be
     * set to newInitialValue;
     */
    public void testRedoAction() {
        testChangeInitialValueAction.redoAction();
        assertEquals("ChangeInitialValueAction redoAction incorrectly.", newInitialValue, element.getInitialValue()
                .getBody());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The initial value value of the ModelElememt should
     * be set to newInitialValue;
     */
    public void testExecuteAction() {
        testChangeInitialValueAction.executeAction();
        assertEquals("ChangeInitialValueAction executeAction incorrectly.", newInitialValue, element.getInitialValue()
                .getBody());
    }

    /**
     * Test ChangeInitialValueAction constructor.
     */
    public void testChangeInitialValueActionConstructor() {
        UndoableAbstractAction action = new ChangeInitialValueAction(element, oldInitialValue);
        assertNotNull("Create ChangeInitialValueAction incorrectly.", action);
    }

    /**
     * Test ChangeInitialValueAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeInitialValueActionConstructorNullElement() {
        try {
            new ChangeInitialValueAction(null, oldInitialValue);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeInitialValueAction constructor with null new initial value. Should throw IllegalArgumentException.
     */
    public void testChangeInitialValueActionConstructorNullNewInitialValue() {
        try {
            new ChangeInitialValueAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new initial value is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
