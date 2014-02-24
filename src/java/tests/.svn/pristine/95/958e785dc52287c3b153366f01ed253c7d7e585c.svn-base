/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeParametersActionTest</code> class.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeParametersActionTest extends TestCase {
    /**
     * Represents the ChangeAggregationAction instance used for tests.
     */
    private ChangeParametersAction testChangeParametersAction1, testChangeParametersAction2;

    /**
     * Represents the operation model element to change the parameter.
     */
    private Operation element;

    /**
     * Represents the changed parameter of the model element the action will performed.
     */
    private Parameter parameter1, parameter2;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new OperationImpl();
        parameter1 = new ParameterImpl();
        parameter2 = new ParameterImpl();
        element.addParameter(parameter2);
        testChangeParametersAction1 =
            new ChangeParametersAction(element, parameter1, ChangeParametersOperationType.ADD, false);
        testChangeParametersAction2 =
            new ChangeParametersAction(element, parameter2, ChangeParametersOperationType.REMOVE, false);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The parameter value of the ModelElememt should be
     * set to oldParameters;
     */
    public void testUndoAction() {
        testChangeParametersAction1.undoAction();
        assertEquals("ChangeParametersAction undoAction incorrectly.", false, element
            .containsParameter(parameter1));
        testChangeParametersAction2.undoAction();
        assertEquals("ChangeParametersAction undoAction incorrectly.", true, element.containsParameter(parameter2));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The parameter value of the ModelElememt should be
     * set to newParameters;
     */
    public void testRedoAction() {
        testChangeParametersAction1.redoAction();
        assertEquals("ChangeParametersAction redoAction incorrectly.", true, element.containsParameter(parameter1));
        testChangeParametersAction2.redoAction();
        assertEquals("ChangeParametersAction redoAction incorrectly.", false, element
            .containsParameter(parameter2));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The parameter value of the ModelElememt should be
     * set to newParameters;
     */
    public void testExecuteAction() {
        testChangeParametersAction1.executeAction();
        assertEquals("ChangeParametersAction executeAction incorrectly.", true, element
            .containsParameter(parameter1));
        testChangeParametersAction2.executeAction();
        assertEquals("ChangeParametersAction executeAction incorrectly.", false, element
            .containsParameter(parameter2));
    }

    /**
     * Test ChangeParametersAction constructor.
     */
    public void testChangeParametersActionConstructor() {
        UndoableAbstractAction action =
            new ChangeParametersAction(element, parameter1, ChangeParametersOperationType.ADD, false);
        assertNotNull("Create ChangeParametersAction incorrectly.", action);
    }

    /**
     * Test ChangeParametersAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeParametersActionConstructorNullElement() {
        try {
            new ChangeParametersAction(null, parameter1, ChangeParametersOperationType.ADD, false);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeParametersAction constructor with null new parameter. Should throw IllegalArgumentException.
     */
    public void testChangeParametersActionConstructorNullNewParameter() {
        try {
            new ChangeParametersAction(element, null, ChangeParametersOperationType.ADD, false);
            fail("IllegalArgumentException should be thrown when the passed new parameter is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeParametersAction constructor with null new operation type. Should throw IllegalArgumentException.
     */
    public void testChangeParametersActionConstructorNullOperationType() {
        try {
            new ChangeParametersAction(element, parameter1, null, false);
            fail("IllegalArgumentException should be thrown when the passed operation kind is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
