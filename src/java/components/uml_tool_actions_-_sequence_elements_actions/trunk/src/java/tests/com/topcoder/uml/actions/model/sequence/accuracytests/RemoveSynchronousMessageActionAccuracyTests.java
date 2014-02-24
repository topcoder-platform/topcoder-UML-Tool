/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.RemoveSynchronousMessageAction;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveSynchronousMessageAction}</code>
 * class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class RemoveSynchronousMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveSynchronousMessageAction</code> instance
     * used in tests.
     * </p>
     */
    private RemoveSynchronousMessageAction action;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveSynchronousMessageAction#RemoveSynchronousMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRemoveSynchronousMessageActionAccuracy() throws Exception {
        action = new RemoveSynchronousMessageAction(AccuracyTestHelper.createStimulusForSynchronousMessage());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveSynchronousMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new RemoveSynchronousMessageAction(AccuracyTestHelper.createStimulusForSynchronousMessage());

        assertEquals("incorrect presentation name", "Remove Synchronous Message", action.getPresentationName());
    }
}
