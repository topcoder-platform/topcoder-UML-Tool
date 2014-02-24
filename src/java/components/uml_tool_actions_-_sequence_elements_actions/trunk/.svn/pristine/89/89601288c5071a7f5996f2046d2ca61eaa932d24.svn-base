/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.Toolkit;

import com.topcoder.uml.actions.model.sequence.CutAsynchronousMessageAction;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * Accuracy test for <code>{@link CutAsynchronousMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class CutAsynchronousMessageActionAccuracyTests extends BaseTestCase {

    /**
     * Represents the <code>Stimulus</code> instance used in tests.
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Represents the <code>CutAsynchronousMessageAction</code> instance used
     * in tests.
     * </p>
     */
    private CutAsynchronousMessageAction action;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        stimulus = AccuracyTestHelper.createStimulusForAsynchronousMessage();
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        action = new CutAsynchronousMessageAction(stimulus);

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutAsynchronousMessageAction#CutAsynchronousMessageAction(Stimulus, Clipboard)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        action = new CutAsynchronousMessageAction(stimulus, Toolkit.getDefaultToolkit().getSystemClipboard());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link CutAsynchronousMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new CutAsynchronousMessageAction(stimulus);

        assertEquals("incorrect presentation name", "Cut Asynchronous Message", action.getPresentationName());
    }
}
