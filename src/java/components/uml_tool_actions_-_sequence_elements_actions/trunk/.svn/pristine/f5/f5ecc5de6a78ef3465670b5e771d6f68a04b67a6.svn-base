/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.RemoveAsynchronousMessageAction;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveAsynchronousMessageAction}</code>
 * class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class RemoveAsynchronousMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveAsynchronousMessageAction</code> instance
     * used in tests.
     * </p>
     */
    private RemoveAsynchronousMessageAction action;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveAsynchronousMessageAction#RemoveAsynchronousMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRemoveAsynchronousMessageActionAccuracy() throws Exception {
        action = new RemoveAsynchronousMessageAction(AccuracyTestHelper.createStimulusForAsynchronousMessage());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveAsynchronousMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new RemoveAsynchronousMessageAction(AccuracyTestHelper.createStimulusForAsynchronousMessage());

        assertEquals("incorrect presentation name", "Remove Asynchronous Message", action.getPresentationName());
    }
}
