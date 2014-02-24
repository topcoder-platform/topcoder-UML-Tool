/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CopyCreateMessageAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link CopyCreateMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CopyCreateMessageActionAccuracyTests extends BaseTestCase {

    /**
     * Represents the <code>Stimulus</code> instance used in tests.
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Represents the <code>CopyCreateMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private CopyCreateMessageAction action;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        stimulus = AccuracyTestHelper.createStimulusForCreateMessage();
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CopyCreateMessageAction#CopyCreateMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        action = new CopyCreateMessageAction(stimulus);

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CopyCreateMessageAction#CopyCreateMessageAction(Stimulus, Clipboard)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        action = new CopyCreateMessageAction(stimulus, Toolkit.getDefaultToolkit().getSystemClipboard());

        assertNotNull("object not successfully created.", action);
    }
}
