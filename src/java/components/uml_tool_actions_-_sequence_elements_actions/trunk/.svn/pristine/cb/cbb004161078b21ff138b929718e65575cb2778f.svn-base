/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.*;

/**
 * <p>
 * This class is the mock extension of MessageUndoableAction used for testing.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MockMessageUndoableAction extends MessageUndoableAction {

    /**
     * <p>
     * Mock Stub. Calls the super constructor.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the stimulus is <code>null</code>.
     */
    public MockMessageUndoableAction(Stimulus stimulus) {
        super(stimulus);
    }

    /**
     * <p>
     * Mock Stub. Calls the super constructor.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>
     * @param dataFlavor
     *            DataFlavor instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>transferable, dataFlavor</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             if transferable contains incorrect data flavor
     */
    public MockMessageUndoableAction(Transferable transferable, DataFlavor dataFlavor)
        throws SequenceConfigurationException {
        super(transferable, dataFlavor);
    }

    /**
     * <p>
     * Executes the Action and if there are any problems in the execution of the Action, it is reported by throwing
     * an ActionExecutionException.
     * </p>
     *
     * @throws ActionExecutionException if there are problems in the execution of the action
     */
    public void execute() throws ActionExecutionException {}

}
