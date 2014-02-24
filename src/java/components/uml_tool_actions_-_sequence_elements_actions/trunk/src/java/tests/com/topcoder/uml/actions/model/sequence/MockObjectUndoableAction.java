/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.util.actionmanager.*;

/**
 * <p>
 * This class is the mock extension of ObjectUndoableAction used for testing.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MockObjectUndoableAction extends ObjectUndoableAction {

    /**
     * <p>
     * Mock Stub. Calls the super constructor.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public MockObjectUndoableAction(Object object) {
        super(object);
    }

    /**
     * <p>
     * Mock Stub. Calls the super constructor.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>transferable</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             if transferable contains incorrect data flavor
     */
    public MockObjectUndoableAction(Transferable transferable) throws SequenceConfigurationException {
        super(transferable);
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
