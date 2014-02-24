/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.RemoveReturnMessageAction;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveReturnMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class RemoveReturnMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveReturnMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private RemoveReturnMessageAction action;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveReturnMessageAction#RemoveReturnMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRemoveReturnMessageActionAccuracy() throws Exception {
        action = new RemoveReturnMessageAction(AccuracyTestHelper.createStimulusForReturnMessage());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveReturnMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new RemoveReturnMessageAction(AccuracyTestHelper.createStimulusForReturnMessage());

        assertEquals("incorrect presentation name", "Remove Return Message Action", action.getPresentationName());
    }
}
