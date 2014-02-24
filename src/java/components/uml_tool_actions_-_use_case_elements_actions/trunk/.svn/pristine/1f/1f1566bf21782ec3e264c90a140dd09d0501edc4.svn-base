/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;


/**
 * Unit test cases for <code>{@link ModelTransfer}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ModelTransferTest extends TestCase {
    /** The ModelTransfer instance for testing. */
    private ModelTransfer modelTransfer;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /** The Transferable instance for testing. */
    private Transferable transferable;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        modelTransfer = new ModelTransfer(new ActorImpl());
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        transferable = modelTransfer;
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Actor)}</code> with null Actor. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_Actor_Null() {
        try {
            new ModelTransfer((Actor) null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Actor)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_Actor_Success() throws Exception {
        Actor actor = new ActorImpl();
        modelTransfer = new ModelTransfer(actor);
        assertNotNull(modelTransfer);
        assertEquals(ModelTransfer.ACTOR_FLAVOR, modelTransfer.getTransferDataFlavors()[0]);
        assertEquals(actor, modelTransfer.getTransferData(ModelTransfer.ACTOR_FLAVOR));
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(UseCase)}</code> with null UseCase. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_UseCase_Null() {
        try {
            new ModelTransfer((UseCase) null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(UseCase)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_UseCase_Success() throws Exception {
        UseCase useCase = new UseCaseImpl();
        modelTransfer = new ModelTransfer(useCase);
        assertNotNull(modelTransfer);
        assertEquals(ModelTransfer.USECASE_FLAVOR, modelTransfer.getTransferDataFlavors()[0]);
        assertEquals(useCase, modelTransfer.getTransferData(ModelTransfer.USECASE_FLAVOR));
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Subsystem)}</code> with null Subsystem. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_Subsystem_Null() {
        try {
            new ModelTransfer((Subsystem) null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Subsystem)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_Subsystem_Success() throws Exception {
        Subsystem subsystem = new SubsystemImpl();
        modelTransfer = new ModelTransfer(subsystem);
        assertNotNull(modelTransfer);
        assertEquals(ModelTransfer.SUBSYSTEM_FLAVOR, modelTransfer.getTransferDataFlavors()[0]);
        assertEquals(subsystem, modelTransfer.getTransferData(ModelTransfer.SUBSYSTEM_FLAVOR));
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Include)}</code> with null Include. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_Include_Null() {
        try {
            new ModelTransfer((Include) null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Include)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_Include_Success() throws Exception {
        Include include = new IncludeImpl();
        modelTransfer = new ModelTransfer(include);
        assertNotNull(modelTransfer);
        assertEquals(ModelTransfer.INCLUDE_FLAVOR, modelTransfer.getTransferDataFlavors()[0]);
        assertEquals(include, modelTransfer.getTransferData(ModelTransfer.INCLUDE_FLAVOR));
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Extend)}</code> with null Extend. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_Extend_Null() {
        try {
            new ModelTransfer((Extend) null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#ModelTransfer(Extend)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testConstructor_Extend_Success() throws Exception {
        Extend extend = new ExtendImpl();
        modelTransfer = new ModelTransfer(extend);
        assertNotNull(modelTransfer);
        assertEquals(ModelTransfer.EXTEND_FLAVOR, modelTransfer.getTransferDataFlavors()[0]);
        assertEquals(extend, modelTransfer.getTransferData(ModelTransfer.EXTEND_FLAVOR));
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#lostOwnership(Clipboard, Transferable)}</code> with null clipboard. Should throw
     * an Exception here.
     * </p>
     */
    public void testLostOwnership_ClipboardTransferable_NullClipboard() {
        try {
            modelTransfer.lostOwnership(null, transferable);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#lostOwnership(Clipboard, Transferable)}</code> with null transferable. Should
     * throw an Exception here.
     * </p>
     */
    public void testLostOwnership_ClipboardTransferable_NullTransferable() {
        try {
            modelTransfer.lostOwnership(clipboard, null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#lostOwnership(Clipboard, Transferable)}</code> with success process.
     * </p>
     */
    public void testLostOwnership_ClipboardTransferable_Success() {
        modelTransfer.lostOwnership(clipboard, transferable);
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#getTransferDataFlavors()}</code> with success process.
     * </p>
     */
    public void testGetTransferDataFlavors_Success() {
        assertEquals(ModelTransfer.ACTOR_FLAVOR, modelTransfer.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)}</code> with null
     * dataFlavor. Should throw an Exception here.
     * </p>
     */
    public void testIsDataFlavorSupported_DataFlavor_Null() {
        try {
            modelTransfer.isDataFlavorSupported(null);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)}</code> with success
     * process.
     * </p>
     */
    public void testIsDataFlavorSupported_DataFlavor_Success() {
        assertTrue(modelTransfer.isDataFlavorSupported(ModelTransfer.ACTOR_FLAVOR));
        assertFalse(modelTransfer.isDataFlavorSupported(ModelTransfer.SUBSYSTEM_FLAVOR));
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#getTransferData(java.awt.datatransfer.DataFlavor)}</code> with null dataFlavor.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testGetTransferData_DataFlavor_Null() throws Exception {
        try {
            modelTransfer.getTransferData(null);
            fail("Should throw an IOException here.");
        } catch (IOException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#getTransferData(java.awt.datatransfer.DataFlavor)}</code> with wrong dataFlavor.
     * Should throw an Exception here.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetTransferData_DataFlavor_Exception()
        throws Exception {
        try {
            modelTransfer.getTransferData(ModelTransfer.EXTEND_FLAVOR);
            fail("Should throw an UnsupportedFlavorException here.");
        } catch (UnsupportedFlavorException ufe) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link ModelTransfer#getTransferData(java.awt.datatransfer.DataFlavor)}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testGetTransferData_DataFlavor_Success()
        throws Exception {
        Actor actor = new ActorImpl();
        modelTransfer = new ModelTransfer(actor);
        assertEquals(actor, modelTransfer.getTransferData(ModelTransfer.ACTOR_FLAVOR));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(ModelTransferTest.class);
    }
}
