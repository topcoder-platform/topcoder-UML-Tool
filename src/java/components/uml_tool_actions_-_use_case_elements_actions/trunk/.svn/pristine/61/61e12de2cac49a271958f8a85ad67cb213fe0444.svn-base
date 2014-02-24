/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteExtendAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ExtendImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>PasteExtendAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestPasteExtendAction extends TestCase {

    /**
     * The <code>Transferable</code> instance used for test.
     */
    private Transferable transferable;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>PasteExtendAction</code> instance used to test against.
     */
    private PasteExtendAction action;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new ExtendImpl());
        namespace = new MockNamespaceImpl();
        action = new PasteExtendAction(transferable, namespace);
    }

    /**
     * Test the constructor <code>PasteExtendAction(Transferable, Namespace)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructor() throws Exception {
        PasteExtendAction pasteExtendAction = new PasteExtendAction(transferable, namespace);
        assertNotNull("Instance of PasteExtendAction should be created.", pasteExtendAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Paste Extend"));
    }
}
