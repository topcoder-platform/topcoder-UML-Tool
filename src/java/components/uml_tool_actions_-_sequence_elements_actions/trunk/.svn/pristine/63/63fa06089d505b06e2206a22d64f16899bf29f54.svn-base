/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.sequence.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.sequence.accuracytests.BaseTestCase;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;

/**
 * <p>
 * Accuracy test for <code>{@link CopyMessageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>CopyMessageAction</code> instance used in tests.
     * </p>
     */
    private CopyMessageAction copyMessageAction;

    /**
     * <p>
     * Accuracy test for <code>{@link CopyMessageAction#CopyMessageAction(Stimulus)}</code> constructor.
     * </p>
     */
    public void testCopyMessageActionAccuracy1() {
        copyMessageAction = new AccuracyCopyMessageAction(new StimulusImpl());

        assertNotNull("object not created successfully.", copyMessageAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CopyMessageAction#CopyMessageAction(Stimulus,Clipboard)}</code> constructor.
     * </p>
     */
    public void testCopyMessageActionAccuracy2() {
        copyMessageAction = new AccuracyCopyMessageAction(new StimulusImpl(), Toolkit.getDefaultToolkit()
            .getSystemClipboard());

        assertNotNull("object not created successfully.", copyMessageAction);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CopyMessageAction#execute()}</code> method.
     * </p>
     */
    public void testExecuteAccuracy() {
        copyMessageAction = new AccuracyCopyMessageAction(AccuracyTestHelper.createStimulusForAsynchronousMessage());
        copyMessageAction.execute();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link CopyMessageAction#getMessageUtil()}</code> method.
     * </p>
     */
    public void testGetMessageUtilAccuracy() {
        copyMessageAction = new AccuracyCopyMessageAction(new StimulusImpl());
        assertNotNull(copyMessageAction.getMessageUtil());
    }

    /**
     * <p>
     * mock class used only for testing purpose.
     * </p>
     */
    private class AccuracyCopyMessageAction extends CopyMessageAction {

        protected AccuracyCopyMessageAction(Stimulus stimulus) {
            super(stimulus);
        }

        protected AccuracyCopyMessageAction(Stimulus stimulus, Clipboard clipboard) {
            super(stimulus, clipboard);
        }
    }
}
