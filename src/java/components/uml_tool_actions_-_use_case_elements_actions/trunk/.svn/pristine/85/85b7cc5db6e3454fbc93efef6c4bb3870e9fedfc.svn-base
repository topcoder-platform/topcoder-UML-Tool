/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link PasteUseCaseAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteUseCaseActionTest extends TestCase {
    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The PasteUseCaseAction instance for testing. */
    private PasteUseCaseAction pasteUseCaseAction;

    /**
     * Set up the initial values.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new UseCaseImpl());
        namespace = new MockNamespaceAbstractImpl();
        pasteUseCaseAction = new PasteUseCaseAction(transferable, namespace);
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#PasteUseCaseAction(Transferable, Namespace)}</code> with null transferable.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            new PasteUseCaseAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#PasteUseCaseAction(Transferable, Namespace)}</code> with null namespace.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullNamespace()
        throws Exception {
        try {
            namespace = null;
            new PasteUseCaseAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#PasteUseCaseAction(Transferable, Namespace)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_Success()
        throws Exception {
        pasteUseCaseAction = new PasteUseCaseAction(transferable, namespace);
        assertNotNull(pasteUseCaseAction);
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Paste Use Case Action", pasteUseCaseAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        pasteUseCaseAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        pasteUseCaseAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link PasteUseCaseAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        pasteUseCaseAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(PasteUseCaseActionTest.class);
    }
}
