/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeAsynchronousActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeAsynchronousActionTest extends TestCase {
    /**
     * Represents the ChangeAsynchronousAction instance used for tests.
     */
    private ChangeAsynchronousAction testChangeAsynchronousAction;

    /**
     * Represents the stimulus model element to change the asynchronous.
     */
    private Stimulus element;

    /**
     * Represents the old asynchronous of the model element before the action performed.
     */
    private final boolean oldAsynchronous = true;

    /**
     * Represents the new asynchronous of the model element the action will performed.
     */
    private final boolean newAsynchronous = false;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new StimulusImpl();
        Procedure procedure = new ProcedureImpl();
        CallOperationAction callOperationAction = new CallOperationActionImpl();
        callOperationAction.setAsynchronous(oldAsynchronous);
        procedure.setAction(callOperationAction);
        element.setDispatchAction(procedure);
        testChangeAsynchronousAction = new ChangeAsynchronousAction(element, newAsynchronous);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The asynchronous value of the ModelElememt should be
     * set to oldAsynchronous;
     */
    public void testUndoAction() {
        testChangeAsynchronousAction.undoAction();
        assertEquals("ChangeAsynchronousAction undoAction incorrectly.", oldAsynchronous,
                ((CallOperationAction) element.getDispatchAction().getAction()).isAsynchronous());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The asynchronous value of the ModelElememt should be
     * set to newAsynchronous;
     */
    public void testRedoAction() {
        testChangeAsynchronousAction.redoAction();
        assertEquals("ChangeAsynchronousAction redoAction incorrectly.", newAsynchronous,
                ((CallOperationAction) element.getDispatchAction().getAction()).isAsynchronous());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The asynchronous value of the ModelElememt should
     * be set to newAsynchronous;
     */
    public void testExecuteAction() {
        testChangeAsynchronousAction.executeAction();
        assertEquals("ChangeAsynchronousAction executeAction incorrectly.", newAsynchronous,
                ((CallOperationAction) element.getDispatchAction().getAction()).isAsynchronous());
    }

    /**
     * Test ChangeAsynchronousAction constructor.
     */
    public void testChangeAsynchronousActionConstructor() {
        UndoableAbstractAction action = new ChangeAsynchronousAction(element, oldAsynchronous);
        assertNotNull("Create ChangeAsynchronousAction incorrectly.", action);
    }

    /**
     * Test ChangeAsynchronousAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeAsynchronousActionConstructorNullElement() {
        try {
            new ChangeAsynchronousAction(null, oldAsynchronous);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
