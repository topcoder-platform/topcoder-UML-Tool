/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.*;
/**
 * <p>
 * Accuracy test for <code>{@link MessageUndoableAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class MessageUndoableActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>MessageUndoableAction</code> instance used in tests.
     * </p>
     */
    private MessageUndoableAction messageUndoableAction;

    /**
     * <p>
     * Accuracy test for <code>{@link MessageUndoableAction#MessageUndoableAction(Stimulus)}</code> constructor.
     * </p>
     */
    public void testMessageUndoableActionAccuracy1() {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForAsynchronousMessage();
        messageUndoableAction = new AccuracyMessageUndoableAction(stimulus);

        assertNotNull("object not created successfully.", messageUndoableAction);
        assertSame(stimulus, messageUndoableAction.getStimulus());
    }

    /**
     * <p>
     * Accuracy test for <code>{@link MessageUndoableAction#MessageUndoableAction(Transferable)}</code> constructor.
     * </p>
     */
    public void testMessageUndoableActionAccuracy2() throws Exception {
        Stimulus stimulus = AccuracyTestHelper.createStimulusForCreateMessage();
        messageUndoableAction = new AccuracyMessageUndoableAction(new CollaborationTransfer(stimulus),
            CollaborationTransfer.CREATE_MESSAGE_FLAVOR);

        assertNotNull("object not created successfully.", messageUndoableAction);
        assertSame(stimulus, messageUndoableAction.getStimulus());
    }

    /**
     * Mock class.
     * @author FireIce
     * @version 1.0
     */
    private class AccuracyMessageUndoableAction extends MessageUndoableAction {

        public AccuracyMessageUndoableAction(Transferable transferable, DataFlavor dataFlavor)
            throws SequenceConfigurationException {
            super(transferable, dataFlavor);
        }

        protected AccuracyMessageUndoableAction(Stimulus stimulus) {
            super(stimulus);
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
}
