/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CopyReturnMessageAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link CopyReturnMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CopyReturnMessageActionAccuracyTests extends BaseTestCase {

    /**
     * Represents the <code>Stimulus</code> instance used in tests.
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Represents the <code>CopyReturnMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private CopyReturnMessageAction action;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        stimulus = AccuracyTestHelper.createStimulusForReturnMessage();
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CopyReturnMessageAction#CopyReturnMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        action = new CopyReturnMessageAction(stimulus);

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CopyReturnMessageAction#CopyReturnMessageAction(Stimulus, Clipboard)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        action = new CopyReturnMessageAction(stimulus, Toolkit.getDefaultToolkit().getSystemClipboard());

        assertNotNull("object not successfully created.", action);
    }
}
