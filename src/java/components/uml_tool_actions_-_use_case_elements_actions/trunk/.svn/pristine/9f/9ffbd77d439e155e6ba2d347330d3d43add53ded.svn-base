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
 * Unit test cases for <code>{@link CopyUseCaseAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyUseCaseActionTest extends TestCase {
    /** The UseCase instance for testing. */
    private UseCase useCase;

    /** The CopyUseCaseAction instance for testing. */
    private CopyUseCaseAction copyUseCaseAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        useCase = new UseCaseImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyUseCaseAction = new CopyUseCaseAction(useCase, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CopyUseCaseAction#CopyUseCaseAction(UseCase)}</code> with null useCase. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_UseCase_NullUseCase() {
        try {
            useCase = null;
            new CopyUseCaseAction(useCase);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyUseCaseAction#CopyUseCaseAction(UseCase)}</code> with success process.
     * </p>
     */
    public void testConstructor_UseCase_Success() {
        copyUseCaseAction = new CopyUseCaseAction(useCase);
        assertNotNull(copyUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyUseCaseAction#CopyUseCaseAction(UseCase, Clipboard)}</code> with null useCase. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseClipboard_NullUseCase() {
        try {
            useCase = null;
            new CopyUseCaseAction(useCase, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyUseCaseAction#CopyUseCaseAction(UseCase, Clipboard)}</code> with null clipboard. Should
     * throw an Exception here.
     * </p>
     */
    public void testConstructor_UseCaseClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CopyUseCaseAction(useCase, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyUseCaseAction#CopyUseCaseAction(UseCase, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_UseCaseClipboard_Success() {
        copyUseCaseAction = new CopyUseCaseAction(useCase, clipboard);
        assertNotNull(copyUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyUseCaseAction#execute()}</code> with success process.
     * </p>
     */
    public void testExecute_Success() {
        copyUseCaseAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CopyUseCaseActionTest.class);
    }
}
