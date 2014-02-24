/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.PasteSynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
/**
 * <p>
 * Failure test for PasteSynchronousMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class PasteSynchronousMessageActionFailureTest extends TestCase {
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
     * <code>PasteSynchronousMessageAction(Transferable transferable, Collaboration collaboration)</code>.
     * </p>
     * <p>
     * transferable is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullTransferable() {
        try {
            new PasteSynchronousMessageAction(null, collaboration);
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
     * <code>PasteSynchronousMessageAction(Transferable transferable, Collaboration collaboration)</code>.
     * </p>
     * <p>
     * collaboration is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullCollaboration() {
        try {
            new PasteSynchronousMessageAction(transferable, null);
            fail("transferable is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }
}
