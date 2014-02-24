/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link CutUseCaseAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutUseCaseActionTest extends TestCase {
    /** The UseCase instance for testing. */
    private UseCase useCase;

    /** The CutUseCaseAction instance for testing. */
    private CutUseCaseAction cutUseCaseAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        useCase.setNamespace(new MockNamespaceAbstractImpl());
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutUseCaseAction = new CutUseCaseAction(useCase, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase)}</code> with null useCase. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_UseCase_NullUseCase() {
        try {
            useCase = null;
            new CutUseCaseAction(useCase);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase)}</code> with success process.
     * </p>
     */
    public void testConstructor_UseCase_Success() {
        cutUseCaseAction = new CutUseCaseAction(useCase);
        assertNotNull(cutUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase, Clipboard)}</code> with null useCase. Should throw
     * an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseClipboard_NullUseCase() {
        try {
            useCase = null;
            new CutUseCaseAction(useCase, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CutUseCaseAction(useCase, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#CutUseCaseAction(UseCase, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_UseCaseClipboard_Success() {
        cutUseCaseAction = new CutUseCaseAction(useCase, clipboard);
        assertNotNull(cutUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Cut Use Case", cutUseCaseAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //add the element to model
        cutUseCaseAction.redo();
        cutUseCaseAction.undo();
        //execute the cut action
        cutUseCaseAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        cutUseCaseAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link CutUseCaseAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        cutUseCaseAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CutUseCaseActionTest.class);
    }
}
