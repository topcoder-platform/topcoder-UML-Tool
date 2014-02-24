/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.PasteMessageAction;
import com.topcoder.uml.actions.model.sequence.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;

/**
 * <p>
 * Accuracy test for <code>{@link PasteMessageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class PasteMessageActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>PasteMessageAction</code> object used in tests.
     * </p>
     */
    private PasteMessageAction pasteMessageAction;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        pasteMessageAction = new AccuracyPasteMessageAction(new CollaborationTransfer(AccuracyTestHelper
            .createStimulusForAsynchronousMessage()), new CollaborationImpl(),
            CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteMessageAction#PasteMessageAction(Transferable, Collaboration)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testPasteMessageActionAccuracy() throws Exception {
        pasteMessageAction = new AccuracyPasteMessageAction(new CollaborationTransfer(AccuracyTestHelper
            .createStimulusForCreateMessage()), new CollaborationImpl(), CollaborationTransfer.CREATE_MESSAGE_FLAVOR);
        assertNotNull("object not created successfully.", pasteMessageAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteMessageAction#execute()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testExecuteAccuracy() throws Exception {
        pasteMessageAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        pasteMessageAction.die();
        pasteMessageAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        pasteMessageAction.execute();
        pasteMessageAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        pasteMessageAction.die();
        pasteMessageAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        pasteMessageAction.execute();
        pasteMessageAction.undo();
        pasteMessageAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    private class AccuracyPasteMessageAction extends PasteMessageAction {

        protected AccuracyPasteMessageAction(Transferable transferable, Collaboration collaboration,
            DataFlavor dataFlavor) throws SequenceConfigurationException {
            super(transferable, collaboration, dataFlavor);
        }
    }
}
