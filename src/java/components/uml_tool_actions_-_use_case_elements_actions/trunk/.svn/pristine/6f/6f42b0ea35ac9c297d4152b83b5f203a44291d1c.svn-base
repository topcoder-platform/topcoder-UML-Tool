/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteIncludeAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.IncludeImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>PasteIncludeAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestPasteIncludeAction extends TestCase {

    /**
     * The <code>Transferable</code> instance used for test.
     */
    private Transferable transferable;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>PasteIncludeAction</code> instance used to test against.
     */
    private PasteIncludeAction action;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new IncludeImpl());
        namespace = new MockNamespaceImpl();
        action = new PasteIncludeAction(transferable, namespace);
    }

    /**
     * Test the constructor <code>PasteIncludeAction(Transferable, Namespace)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructor() throws Exception {
        PasteIncludeAction pasteIncludeAction = new PasteIncludeAction(transferable, namespace);
        assertNotNull("Instance of PasteIncludeAction should be created.", pasteIncludeAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Paste Include"));
    }
}
