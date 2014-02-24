/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.MessageUndoableActionImpl;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
/**
 * <p>
 * Failure test for MessageUndoableAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MessageUndoableActionFailureTest extends TestCase {
    /**
     * <p>
     * Transferable instance created for testing.
     * </p>
     */
    private Transferable transferable;

    /**
     * <p>
     * DataFlavor instance created for testing.
     * </p>
     */
    private DataFlavor dataFlavor;

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        transferable = new TransferableImpl();
        dataFlavor = new DataFlavor();
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
     * Failure Test for <code>MessageUndoableAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullStimulus() {
        try {
            new MessageUndoableActionImpl(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>MessageUndoableActionImpl(Transferable transferable, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * transferable is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullTransferable() {
        try {
            new MessageUndoableActionImpl(null, dataFlavor);
            fail("transferable is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("transferable is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>MessageUndoableActionImpl(Transferable transferable, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * dataFlavor is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullDataFlavor() {
        try {
            new MessageUndoableActionImpl(transferable, null);
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        }
    }
}
