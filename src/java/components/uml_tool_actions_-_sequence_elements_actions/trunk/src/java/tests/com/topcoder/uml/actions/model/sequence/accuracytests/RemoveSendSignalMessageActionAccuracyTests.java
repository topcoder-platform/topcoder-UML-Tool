/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.actions.model.sequence.RemoveSendSignalMessageAction;

/**
 * <p>
 * Accuracy test for <code>{@link RemoveSendSignalMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class RemoveSendSignalMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>RemoveSendSignalMessageAction</code> instance used
     * in tests.
     * </p>
     */
    private RemoveSendSignalMessageAction action;

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveSendSignalMessageAction#RemoveSendSignalMessageAction(Stimulus)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testRemoveSendSignalMessageActionAccuracy() throws Exception {
        action = new RemoveSendSignalMessageAction(AccuracyTestHelper.createStimulusForSendSignalMessage());

        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link RemoveSendSignalMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new RemoveSendSignalMessageAction(AccuracyTestHelper.createStimulusForSendSignalMessage());

        assertEquals("incorrect presentation name", "Remove Send Signal Message", action.getPresentationName());
    }
}
