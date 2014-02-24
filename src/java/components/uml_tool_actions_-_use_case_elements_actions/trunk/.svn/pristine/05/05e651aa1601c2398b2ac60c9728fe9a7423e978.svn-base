/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link PasteSubsystemAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteSubsystemActionTest extends TestCase {
    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The PasteSubsystemAction instance for testing. */
    private PasteSubsystemAction pasteSubsystemAction;

    /**
     * Set up the initial values.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new SubsystemImpl());
        namespace = new MockNamespaceAbstractImpl();
        pasteSubsystemAction = new PasteSubsystemAction(transferable, namespace);
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#PasteSubsystemAction(Transferable, Namespace)}</code> with null
     * transferable. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            new PasteSubsystemAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#PasteSubsystemAction(Transferable, Namespace)}</code> with null
     * namespace. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_NullNamespace()
        throws Exception {
        try {
            namespace = null;
            new PasteSubsystemAction(transferable, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#PasteSubsystemAction(Transferable, Namespace)}</code> with success
     * process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableNamespace_Success()
        throws Exception {
        pasteSubsystemAction = new PasteSubsystemAction(transferable, namespace);
        assertNotNull(pasteSubsystemAction);
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Paste Subsystem", pasteSubsystemAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        pasteSubsystemAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        pasteSubsystemAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link PasteSubsystemAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        pasteSubsystemAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(PasteSubsystemActionTest.class);
    }
}
