/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


/**
 * Unit test cases for <code>{@link UsecaseUndoableAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UsecaseUndoableActionTest extends TestCase {
    /** The ModelElement instance for testing. */
    private ModelElement modelElement;

    /** The UsecaseToolUtil instance for testing. */
    private UsecaseToolUtil usecaseToolUtil;

    /** The UsecaseUndoableAction instance for testing. */
    private UsecaseUndoableAction usecaseUndoableAction;

    /** The Transferable instance for testing. */
    private Transferable transferable;

    /** The DataFlavor instance for testing. */
    private DataFlavor dataFlavor;

    /** The Actor instance for testing. */
    private Actor actor;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        modelElement = new MockModelElementAbstractImpl();
        usecaseToolUtil = new ActorUtil();
        actor = new ActorImpl();
        transferable = new ModelTransfer(actor);
        dataFlavor = ModelTransfer.ACTOR_FLAVOR;
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(ModelElement, UsecaseToolUtil)}</code> with null
     * ModelElement. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtil_NullModelElement() {
        try {
            modelElement = null;
            usecaseUndoableAction = new MockUsecaseUndoableAction(modelElement, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(ModelElement, UsecaseToolUtil)}</code> with null
     * usecaseToolUtil. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtil_NullUsecaseToolUtil() {
        try {
            usecaseToolUtil = null;
            usecaseUndoableAction = new MockUsecaseUndoableAction(modelElement, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(ModelElement, UsecaseToolUtil)}</code> with
     * success process.
     * </p>
     */
    public void testConstructor_ModelElementUsecaseToolUtil_Success() {
        usecaseUndoableAction = new MockUsecaseUndoableAction(modelElement, usecaseToolUtil);
        assertNotNull(usecaseUndoableAction);
        assertEquals(modelElement, usecaseUndoableAction.getModelElement());
        assertEquals(usecaseToolUtil, usecaseUndoableAction.getUsecaseToolUtil());
        assertNotNull(usecaseUndoableAction.getLog());
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(Transferable, DataFlavor, UsecaseToolUtil)}</code>
     * with null transferable. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtil_NullTransferable()
        throws Exception {
        try {
            transferable = null;
            usecaseUndoableAction = new MockUsecaseUndoableAction(transferable, dataFlavor, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(Transferable, DataFlavor, UsecaseToolUtil)}</code>
     * with null dataFlavor. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtil_NullDataFlavor()
        throws Exception {
        try {
            dataFlavor = null;
            usecaseUndoableAction = new MockUsecaseUndoableAction(transferable, dataFlavor, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(Transferable, DataFlavor, UsecaseToolUtil)}</code>
     * with null usecaseToolUtil. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtil_NullUsecaseToolUtil()
        throws Exception {
        try {
            usecaseToolUtil = null;
            usecaseUndoableAction = new MockUsecaseUndoableAction(transferable, dataFlavor, usecaseToolUtil);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(Transferable, DataFlavor, UsecaseToolUtil)}</code>
     * with wrong dataFlavor. Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtil_Exception()
        throws Exception {
        try {
            dataFlavor = ModelTransfer.USECASE_FLAVOR;
            usecaseUndoableAction = new MockUsecaseUndoableAction(transferable, dataFlavor, usecaseToolUtil);
            fail("Should throw an InvalidDataContentException here.");
        } catch (InvalidDataContentException idce) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#UsecaseUndoableAction(Transferable, DataFlavor, UsecaseToolUtil)}</code>
     * with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_TransferableDataFlavorUsecaseToolUtil_Success()
        throws Exception {
        usecaseUndoableAction = new MockUsecaseUndoableAction(transferable, dataFlavor, usecaseToolUtil);
        assertEquals(actor, usecaseUndoableAction.getModelElement());
        assertEquals(usecaseToolUtil, usecaseUndoableAction.getUsecaseToolUtil());
        assertNotNull(usecaseUndoableAction.getLog());
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#getUsecaseToolUtil()}</code> with success process.
     * </p>
     */
    public void testGetUsecaseToolUtil_Success() {
        testConstructor_ModelElementUsecaseToolUtil_Success();
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#getModelElement()}</code> with success process.
     * </p>
     */
    public void testGetModelElement_Success() {
        testConstructor_ModelElementUsecaseToolUtil_Success();
    }

    /**
     * <p>
     * Test <code>{@link UsecaseUndoableAction#getLog()}</code> with success process.
     * </p>
     */
    public void testGetLog_Success() {
        testConstructor_ModelElementUsecaseToolUtil_Success();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(UsecaseUndoableActionTest.class);
    }
}
