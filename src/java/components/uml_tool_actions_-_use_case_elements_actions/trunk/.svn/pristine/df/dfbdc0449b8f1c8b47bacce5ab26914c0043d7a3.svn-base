/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link PasteActorAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteActorActionTest extends TestCase {
    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The PasteActorAction instance for testing. */
    private PasteActorAction pasteActorAction;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /**
     * Set up the initial values.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new ActorImpl());
        namespace = new MockNamespaceAbstractImpl();
        pasteActorAction = new PasteActorAction(transferable, namespace);
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#PasteActorAction(Transferable, Namespace)}</code> with null transferable.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            new PasteActorAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#PasteActorAction(Transferable, Namespace)}</code> with null namespace. Should
     * throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullNamespace()
        throws Exception {
        try {
            namespace = null;
            new PasteActorAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#PasteActorAction(Transferable, Namespace)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_Success()
        throws Exception {
        pasteActorAction = new PasteActorAction(transferable, namespace);
        assertNotNull(pasteActorAction);
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Paste Actor", pasteActorAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        pasteActorAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        pasteActorAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link PasteActorAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        pasteActorAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(PasteActorActionTest.class);
    }
}
