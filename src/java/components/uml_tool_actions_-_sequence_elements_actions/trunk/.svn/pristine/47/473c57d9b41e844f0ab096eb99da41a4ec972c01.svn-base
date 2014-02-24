/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.RemoveCreateMessageAction;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveCreateMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class RemoveCreateMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveCreateMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private RemoveCreateMessageAction action;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveCreateMessageAction#RemoveCreateMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRemoveCreateMessageActionAccuracy() throws Exception {
        action = new RemoveCreateMessageAction(AccuracyTestHelper.createStimulusForCreateMessage());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveCreateMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new RemoveCreateMessageAction(AccuracyTestHelper.createStimulusForCreateMessage());

        assertEquals("incorrect presentation name", "Remove Create Message", action.getPresentationName());
    }
}
