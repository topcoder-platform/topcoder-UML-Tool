/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link RemoveUseCaseAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveUseCaseActionTest extends TestCase {
    /** The UseCase instance for testing. */
    private UseCase useCase;

    /** The RemoveUseCaseAction instance for testing. */
    private RemoveUseCaseAction removeUseCaseAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        useCase.setNamespace(new MockNamespaceAbstractImpl());
        removeUseCaseAction = new RemoveUseCaseAction(useCase);
    }

    /**
     * <p>
     * Test <code>{@link RemoveUseCaseAction#RemoveUseCaseAction(UseCase)}</code> with null useCase. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_UseCase_NullUseCase() {
        try {
            useCase = null;
            new RemoveUseCaseAction(useCase);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveUseCaseAction#RemoveUseCaseAction(UseCase)}</code> with success process.
     * </p>
     */
    public void testConstructor_UseCase_Success() {
        removeUseCaseAction = new RemoveUseCaseAction(useCase);
        assertNotNull(removeUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link RemoveUseCaseAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Remove Use Case", removeUseCaseAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link RemoveUseCaseAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        removeUseCaseAction.redo();
        removeUseCaseAction.undo();
        removeUseCaseAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link RemoveUseCaseAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        removeUseCaseAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link RemoveUseCaseAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        removeUseCaseAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(RemoveUseCaseActionTest.class);
    }
}
