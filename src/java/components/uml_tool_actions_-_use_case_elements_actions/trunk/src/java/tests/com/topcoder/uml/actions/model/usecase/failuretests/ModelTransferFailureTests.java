/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.Toolkit;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * Failure test for <code>{@link com.topcoder.uml.actions.model.usecase.ModelTransfer}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ModelTransferFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#ModelTransfer(Actor)}</code> constructor.
     * </p>
     */
    public void testCtor_NullActor() {
        assertConstructorException(ModelTransfer.class, new Class[] {Actor.class}, new Object[] {null},
            IllegalArgumentException.class, "If the actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#ModelTransfer(UseCase)}</code> constructor.
     * </p>
     */
    public void testCtor_NullUseCase() {
        assertConstructorException(ModelTransfer.class, new Class[] {UseCase.class}, new Object[] {null},
            IllegalArgumentException.class, "If the usecase is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#ModelTransfer(Subsystem)}</code> constructor.
     * </p>
     */
    public void testCtor_NullSubsystem() {
        assertConstructorException(ModelTransfer.class, new Class[] {Subsystem.class}, new Object[] {null},
            IllegalArgumentException.class, "If the subsystem is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#ModelTransfer(Include)}</code> constructor.
     * </p>
     */
    public void testCtor_NullInclude() {
        assertConstructorException(ModelTransfer.class, new Class[] {Include.class}, new Object[] {null},
            IllegalArgumentException.class, "If the include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#ModelTransfer(Extend)}</code> constructor.
     * </p>
     */
    public void testCtor_NullExtend() {
        assertConstructorException(ModelTransfer.class, new Class[] {Extend.class}, new Object[] {null},
            IllegalArgumentException.class, "If the extend is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#lostOwnership(Clipboard, Transferable)}</code> method.
     * </p>
     */
    public void testLostOwnership_NullClipboard() {
        try {
            new ModelTransfer(new ActorImpl()).lostOwnership(null, new ModelTransfer(new ActorImpl()));
            fail("should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#lostOwnership(Clipboard, Transferable)}</code> method.
     * </p>
     */
    public void testLostOwnership_NullTransferable() {
        try {
            new ModelTransfer(new ActorImpl()).lostOwnership(Toolkit.getDefaultToolkit().getSystemClipboard(), null);
            fail("should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#isDataFlavorSupported(DataFlavor)}</code> method.
     * </p>
     */
    public void testIsDataFlavorSupported_NullDataFlavor() {
        try {
            new ModelTransfer(new ActorImpl()).isDataFlavorSupported(null);
            fail("should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#getTransferData(DataFlavor)}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetTransferData_NullDataFlavor() throws Exception {
        try {
            new ModelTransfer(new ActorImpl()).getTransferData(null);
            fail("should throw IOException.");
        } catch (IOException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link ModelTransfer#getTransferData(DataFlavor)}</code> method.
     * </p>
*@throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testGetTransferData_UnsupportedDataFlavor() throws Exception {
        ModelTransfer modelTransfer = new ModelTransfer(new ActorImpl()) {
            public boolean isDataFlavorSupported(java.awt.datatransfer.DataFlavor dataFlavor)
                throws IllegalArgumentException {
                return false;
            };
        };
        try {
            modelTransfer.getTransferData(ModelTransfer.ACTOR_FLAVOR);
            fail("should throw UnsupportedFlavorException.");
        } catch (UnsupportedFlavorException e) {
            // expected
        }
    }
}
