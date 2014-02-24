/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.sequence.CutMessageAction;
import com.topcoder.uml.actions.model.sequence.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link CutMessageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>CutMessageAction</code> instance used in tests.
     * </p>
     */
    private CutMessageAction cutMessageAction;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        cutMessageAction = new AccuracyCutMessageAction(AccuracyTestHelper.createStimulusForAsynchronousMessage());

    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#CutMessageAction(Message)}</code> constructor.
     * </p>
     */
    public void testCutMessageActionAccuracy1() {
        cutMessageAction = new AccuracyCutMessageAction(AccuracyTestHelper.createStimulusForCreateMessage());
        assertNotNull(cutMessageAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#CutMessageAction(Message, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCutMessageActionAccuracy2() {
        cutMessageAction = new AccuracyCutMessageAction(AccuracyTestHelper.createStimulusForReturnMessage(), Toolkit
            .getDefaultToolkit().getSystemClipboard());
        assertNotNull(cutMessageAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#execute()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testExecuteAccuracy() throws Exception {
        cutMessageAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        cutMessageAction.die();
        cutMessageAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        cutMessageAction.execute();
        cutMessageAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        cutMessageAction.die();
        cutMessageAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CutMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        cutMessageAction.execute();
        cutMessageAction.undo();
        cutMessageAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    private class AccuracyCutMessageAction extends CutMessageAction {

        protected AccuracyCutMessageAction(Stimulus stimulus) {
            super(stimulus);
        }

        protected AccuracyCutMessageAction(Stimulus stimulus, Clipboard clipboard) {
            super(stimulus, clipboard);
        }

    }
}
