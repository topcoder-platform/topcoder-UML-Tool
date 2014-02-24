/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link PasteAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteActionTest extends TestCase {
    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The DataFlavor instance for testing. */
    private DataFlavor dataFlavor;

    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The PasteAction instance for testing. */
    private PasteAction pasteAction;

    /**
     * Set up the initial values.
     *
     * @throws Exception to junit.
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new ActorImpl());
        dataFlavor = ModelTransfer.ACTOR_FLAVOR;
        usecaseToolUtil = new ActorUtil();
        namespace = new MockNamespaceAbstractImpl();
        pasteAction = new MockPasteAction(transferable, dataFlavor, usecaseToolUtil, namespace);
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#PasteAction(Transferable, DataFlavor, UsecaseToolUtil, Namespace)}</code> with
     * null transferable. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtilNamespace_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            new MockPasteAction(transferable, dataFlavor, usecaseToolUtil, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#PasteAction(Transferable, DataFlavor, UsecaseToolUtil, Namespace)}</code> with
     * null dataFlavor. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtilNamespace_NullDataFlavor()
        throws Exception {
        try {
            dataFlavor = null;
            new MockPasteAction(transferable, dataFlavor, usecaseToolUtil, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#PasteAction(Transferable, DataFlavor, UsecaseToolUtil, Namespace)}</code> with
     * null usecaseToolUtil. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtilNamespace_NullUsecaseToolUtil()
        throws Exception {
        try {
            usecaseToolUtil = null;
            new MockPasteAction(transferable, dataFlavor, usecaseToolUtil, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#PasteAction(Transferable, DataFlavor, UsecaseToolUtil, Namespace)}</code> with
     * null namespace. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtilNamespace_nullNamespace()
        throws Exception {
        try {
            namespace = null;
            new MockPasteAction(transferable, dataFlavor, usecaseToolUtil, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#PasteAction(Transferable, DataFlavor, UsecaseToolUtil, Namespace)}</code> with
     * success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtilNamespace_Success()
        throws Exception {
        pasteAction = new MockPasteAction(transferable, dataFlavor, usecaseToolUtil, namespace);
        assertNotNull(pasteAction);
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        pasteAction.execute();
        assertTrue(usecaseToolUtil.removeElementFromModel(pasteAction.getModelElement()));
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        //set the redo flag to true
        pasteAction.undo();
        pasteAction.redo();
        assertTrue(usecaseToolUtil.removeElementFromModel(pasteAction.getModelElement()));
    }

    /**
     * <p>
     * Test <code>{@link PasteAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        //set the undo flag to true
        pasteAction.redo();
        pasteAction.undo();
        assertFalse(usecaseToolUtil.removeElementFromModel(pasteAction.getModelElement()));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(PasteActionTest.class);
    }
}
