/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link PasteExtendAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteExtendActionTest extends TestCase {
    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The PasteExtendAction instance for testing. */
    private PasteExtendAction pasteExtendAction;

    /**
     * Set up the initial values.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new ExtendImpl());
        namespace = new MockNamespaceAbstractImpl();
        pasteExtendAction = new PasteExtendAction(transferable, namespace);
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#PasteExtendAction(Transferable, Namespace)}</code> with null transferable.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            new PasteExtendAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#PasteExtendAction(Transferable, Namespace)}</code> with null namespace.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullNamespace()
        throws Exception {
        try {
            namespace = null;
            new PasteExtendAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#PasteExtendAction(Transferable, Namespace)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_Success()
        throws Exception {
        pasteExtendAction = new PasteExtendAction(transferable, namespace);
        assertNotNull(pasteExtendAction);
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Paste Extend", pasteExtendAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        pasteExtendAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        pasteExtendAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link PasteExtendAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        pasteExtendAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(PasteExtendActionTest.class);
    }
}
