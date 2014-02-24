/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.PasteMessageActionImpl;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
/**
 * <p>
 * Failure test for PasteMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteMessageActionFailureTest extends TestCase {
    /**
     * <p>
     * Transferable instance created for testing.
     * </p>
     */
    private Transferable transferable;

    /**
     * <p>
     * Collaboration instance created for testing.
     * </p>
     */
    private Collaboration collaboration;

    /**
     * <p>
     * DataFlavor instance created for testing.
     * </p>
     */
    private DataFlavor dataFlavor = new DataFlavor();

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
        collaboration = new CollaborationImpl();
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
     * Failure Test for the
     * <code>
     * PasteMessageActionImpl(Transferable transferable, Collaboration collaboration, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * transferable is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullTransferable() {
        try {
            new PasteMessageActionImpl(null, collaboration, dataFlavor);
            fail("transferable is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }


    /**
     * <p>
     * Failure Test for the
     * <code>
     * PasteMessageActionImpl(Transferable transferable, Collaboration collaboration, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * collaboration is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullCollaboration() {
        try {
            new PasteMessageActionImpl(transferable, null, dataFlavor);
            fail("transferable is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }
    /**
     * <p>
     * Failure Test for the
     * <code>
     * PasteMessageActionImpl(Transferable transferable, Collaboration collaboration, DataFlavor dataFlavor)</code>.
     * </p>
     * <p>
     * dataFlavor is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullDataFlavor() {
        try {
            new PasteMessageActionImpl(transferable, collaboration, null);
            fail("dataFlavor is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }
}
