/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.sequence.CollaborationTransfer;
import com.topcoder.uml.actions.model.sequence.PasteReturnMessageAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;

/**
 * <p>
 * Accuracy test for <code>{@link PasteReturnMessageAction}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class PasteReturnMessageActionAccuracyTests extends BaseTestCase {

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
     * Represents the <code>PasteReturnMessageAction</code> instance used in
     * tests.
     * </p>
     */
    private PasteReturnMessageAction action;

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
        transferable = new CollaborationTransfer(AccuracyTestHelper.createStimulusForReturnMessage());
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteReturnMessageAction#PasteReturnMessageAction(Transferable, Collaboration)}</code>
     * constructor.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testPasteReturnMessageActionAccuracy() throws Exception {
        action = new PasteReturnMessageAction(transferable, collaboration);
        assertNotNull("object not successfully created.", action);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link PasteReturnMessageAction#getPresentationName()}</code>
     * method.
     * </p>
     *
     * @throws Exception pass any unexpected exception to JUnit.
     */
    public void testGetPresentationNameAccuracy() throws Exception {
        action = new PasteReturnMessageAction(transferable, collaboration);

        assertEquals("incorrect presentation name", "Paste Return Message Action", action.getPresentationName());
    }
}
