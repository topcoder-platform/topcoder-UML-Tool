/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.actions.model.sequence.RemoveMessageAction;
import com.topcoder.uml.actions.model.sequence.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveMessageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveMessageAction</code> instance used in tests.
     * </p>
     */
    private RemoveMessageAction removeMessageAction;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        removeMessageAction = new AccuracyRemoveMessageAction(AccuracyTestHelper.createStimulusForAsynchronousMessage());
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveMessageAction#RemoveMessageAction(Message)}</code> constructor.
     * </p>
     */
    public void testRemoveMessageActionAccuracy1() {
        removeMessageAction = new AccuracyRemoveMessageAction(AccuracyTestHelper.createStimulusForReturnMessage());
        assertNotNull(removeMessageAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveMessageAction#exeremovee()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testExeremoveeAccuracy() throws Exception {
        removeMessageAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy1() throws Exception {
        removeMessageAction.die();
        removeMessageAction.undo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveMessageAction#undo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testUndoAccuracy2() throws Exception {
        removeMessageAction.execute();
        removeMessageAction.undo();
        assertFalse("should not logged warn as can undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy1() throws Exception {
        removeMessageAction.die();
        removeMessageAction.redo();
        assertTrue("should logged warn as can not undo.", confirmFileContents("WARN"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link RemoveMessageAction#redo()}</code> method.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testRedoAccuracy2() throws Exception {
        removeMessageAction.execute();
        removeMessageAction.undo();
        removeMessageAction.redo();
        assertFalse("should not logged warn as can redo.", confirmFileContents("WARN"));
    }

    private class AccuracyRemoveMessageAction extends RemoveMessageAction {

        protected AccuracyRemoveMessageAction(Stimulus stimulus) {
            super(stimulus);
        }

    }
}
