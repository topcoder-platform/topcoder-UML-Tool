/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>PasteActorAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestPasteActorAction extends TestCase {

    /**
     * The <code>Transferable</code> instance used for test.
     */
    private Transferable transferable;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>PasteActorAction</code> instance used to test against.
     */
    private PasteActorAction action;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new ActorImpl());
        namespace = new MockNamespaceImpl();
        action = new PasteActorAction(transferable, namespace);
    }

    /**
     * Test the constructor <code>PasteActorAction(Transferable, Namespace)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructor() throws Exception {
        PasteActorAction pasteActorAction = new PasteActorAction(transferable, namespace);
        assertNotNull("Instance of PasteActorAction should be created.", pasteActorAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Paste Actor"));
    }
}
