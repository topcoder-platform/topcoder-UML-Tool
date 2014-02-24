/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.PasteAsynchronousMessageAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;

/**
 * <p>
 * Accuracy test for <code>{@link PasteAsynchronousMessageAction}</code>
 * class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class PasteAsynchronousMessageActionAccuracyTests extends BaseTestCase {

    /**
     * <p>
     * Represents the <code>Transferable</code> instance used in tests.
     * </p>
     */
    private Transferable transferable;

    /**
     * <p>
     * Represents the <code>Collaboration</code> instance used in tests.
     * </p>
     */
    private Collaboration collaboration;

    /**
     * <p>
     * Represents the <code>PasteAsynchronousMessageAction</code> instance
     * used in tests.
     * </p>
     */
    private PasteAsynchronousMessageAction action;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        collaboration = new CollaborationImpl();
        transferable = new CollaborationTransfer(AccuracyTestHelper.createStimulusForAsynchronousMessage());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteAsynchronousMessageAction#PasteAsynchronousMessageAction(Transferable, Collaboration)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testPasteAsynchronousMessageActionAccuracy() throws Exception {
        action = new PasteAsynchronousMessageAction(transferable, collaboration);
        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteAsynchronousMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new PasteAsynchronousMessageAction(transferable, collaboration);

        assertEquals("incorrect presentation name", "Paste Asynchronous Message", action.getPresentationName());
    }
}
