/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.PasteCreateMessageAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;

/**
 * <p>
 * Accuracy test for <code>{@link PasteCreateMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class PasteCreateMessageActionAccuracyTests extends BaseTestCase {

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
     * Represents the <code>PasteCreateMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private PasteCreateMessageAction action;

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
        transferable = new CollaborationTransfer(AccuracyTestHelper.createStimulusForCreateMessage());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteCreateMessageAction#PasteCreateMessageAction(Transferable, Collaboration)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testPasteCreateMessageActionAccuracy() throws Exception {
        action = new PasteCreateMessageAction(transferable, collaboration);
        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteCreateMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new PasteCreateMessageAction(transferable, collaboration);

        assertEquals("incorrect presentation name", "Paste Create Message", action.getPresentationName());
    }
}
