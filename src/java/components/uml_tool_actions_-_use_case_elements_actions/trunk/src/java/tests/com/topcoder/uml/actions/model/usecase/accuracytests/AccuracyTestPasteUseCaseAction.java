/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteUseCaseAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>PasteUseCaseAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestPasteUseCaseAction extends TestCase {

    /**
     * The <code>Transferable</code> instance used for test.
     */
    private Transferable transferable;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>PasteUseCaseAction</code> instance used to test against.
     */
    private PasteUseCaseAction action;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new UseCaseImpl());
        namespace = new MockNamespaceImpl();
        action = new PasteUseCaseAction(transferable, namespace);
    }

    /**
     * Test the constructor <code>PasteUseCaseAction(Transferable, Namespace)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructor() throws Exception {
        PasteUseCaseAction pasteUseCaseAction = new PasteUseCaseAction(transferable, namespace);
        assertNotNull("Instance of PasteUseCaseAction should be created.", pasteUseCaseAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Paste Use Case Action"));
    }
}
