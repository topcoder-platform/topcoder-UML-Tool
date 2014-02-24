/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.RemoveUseCaseAction;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>RemoveUseCaseAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestRemoveUseCaseAction extends TestCase {

    /**
     * The <code>UseCase</code> instance used for test.
     */
    private UseCase useCase;

    /**
     * The <code>RemoveUseCaseAction</code> instance used to test against.
     */
    private RemoveUseCaseAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        action = new RemoveUseCaseAction(useCase);
    }

    /**
     * Test the constructor <code>RemoveUseCaseAction(UseCase)</code>.
     */
    public void testConstructor() {
        RemoveUseCaseAction removeUseCaseAction = new RemoveUseCaseAction(useCase);
        assertNotNull("Instance of RemoveUseCaseAction should be created.", removeUseCaseAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Remove Use Case"));
    }
}
