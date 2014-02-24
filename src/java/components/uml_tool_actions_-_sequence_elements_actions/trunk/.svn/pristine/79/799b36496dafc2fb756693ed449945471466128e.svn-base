/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
/**
 * <p>
 * Failure test for CollaborationTransfer.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CollaborationTransferFailureTest extends TestCase {

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure Test for the <code>CollaborationTransfer(Object object)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullObject() {
        try {
            new CollaborationTransfer((Object) null);
            fail("object is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>CollaborationTransfer(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullStimulus() {
        try {
            new CollaborationTransfer((Stimulus) null);
            fail("Stimulus stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>lostOwnership(Clipboard clipboard, Transferable transferable)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testLostOwnershipNullClipboard() {
        try {
            Transferable trans = new TransferableImpl();
            new CollaborationTransfer(new ObjectImpl()).lostOwnership(null, trans);
            fail("clipboard is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>lostOwnership(Clipboard clipboard, Transferable transferable)</code>.
     * </p>
     * <p>
     * clipboard is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testLostOwnershipNullTransferable() {
        try {
            Clipboard clip = new Clipboard("name");
            new CollaborationTransfer(new ObjectImpl()).lostOwnership(clip, null);
            fail("clipboard is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the <code>getTransferData(DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * dataFlavor is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testIsDataFlavorSupported() {
        try {
            new CollaborationTransfer(new ObjectImpl()).isDataFlavorSupported(null);
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the <code>getTransferData(DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * dataFlavor is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testGetTransferData() {
        try {
            new CollaborationTransfer(new ObjectImpl()).getTransferData(new DataFlavor());
            fail("dataFlavor is invalid, UnsupportedFlavorException is expected.");
        } catch (IllegalArgumentException e) {
            fail("dataFlavor is invalid, UnsupportedFlavorException is expected.");
        } catch (UnsupportedFlavorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the <code>getTransferData(DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * dataFlavor is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testGetTransferData2() {
        try {
            new CollaborationTransfer(new ObjectImpl()).getTransferData(null);
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (UnsupportedFlavorException e) {
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        }
    }
}
