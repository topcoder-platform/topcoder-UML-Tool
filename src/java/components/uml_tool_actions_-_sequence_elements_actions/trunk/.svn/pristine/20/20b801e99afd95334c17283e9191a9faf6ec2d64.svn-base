/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.PasteObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;

/**
 * <p>
 * Accuracy test for <code>{@link PasteObjectAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class PasteObjectActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the <code>PasteObjectAction</code> object used in tests.
     * </p>
     */
    private PasteObjectAction pasteObjectAction;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        pasteObjectAction = new PasteObjectAction(new CollaborationTransfer(new ObjectImpl()), new CollaborationImpl());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteObjectAction#PasteObjectAction(Transferable, Collaboration)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testPasteObjectActionAccuracy() throws Exception {
        pasteObjectAction = new PasteObjectAction(new CollaborationTransfer(new ObjectImpl()), new CollaborationImpl());
        assertNotNull("object not created successfully.", pasteObjectAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteObjectAction#execute()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testExecuteAccuracy() throws Exception {
        pasteObjectAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteObjectAction#undo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        pasteObjectAction.die();
        pasteObjectAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteObjectAction#undo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        pasteObjectAction.execute();
        pasteObjectAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteObjectAction#redo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        pasteObjectAction.die();
        pasteObjectAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link PasteObjectAction#redo()}</code> method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        pasteObjectAction.execute();
        pasteObjectAction.undo();
        pasteObjectAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteObjectAction#getPresentationName()}</code> method.
     * </p>
     */
    public void testGetPresentationNameAccuracy() {
        assertEquals("incorrect presentation name", "Paste Object", pasteObjectAction.getPresentationName());
    }
}
