/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link PasteIncludeAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteIncludeActionTest extends TestCase {
    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The PasteIncludeAction instance for testing. */
    private PasteIncludeAction pasteIncludeAction;

    /**
     * Set up the initial values.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new IncludeImpl());
        namespace = new MockNamespaceAbstractImpl();
        pasteIncludeAction = new PasteIncludeAction(transferable, namespace);
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#PasteIncludeAction(Transferable, Namespace)}</code> with null transferable.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            new PasteIncludeAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#PasteIncludeAction(Transferable, Namespace)}</code> with null namespace.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullNamespace()
        throws Exception {
        try {
            namespace = null;
            new PasteIncludeAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#PasteIncludeAction(Transferable, Namespace)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_Success()
        throws Exception {
        pasteIncludeAction = new PasteIncludeAction(transferable, namespace);
        assertNotNull(pasteIncludeAction);
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Paste Include", pasteIncludeAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        pasteIncludeAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        pasteIncludeAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link PasteIncludeAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        pasteIncludeAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(PasteIncludeActionTest.class);
    }
}
