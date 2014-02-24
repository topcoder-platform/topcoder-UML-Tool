/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteSubsystemAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>PasteSubsystemAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestPasteSubsystemAction extends TestCase {

    /**
     * The <code>Transferable</code> instance used for test.
     */
    private Transferable transferable;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>PasteSubsystemAction</code> instance used to test against.
     */
    private PasteSubsystemAction action;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void setUp() throws Exception {
        transferable = new ModelTransfer(new SubsystemImpl());
        namespace = new MockNamespaceImpl();
        action = new PasteSubsystemAction(transferable, namespace);
    }

    /**
     * Test the constructor <code>PasteSubsystemAction(Transferable, Namespace)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructor() throws Exception {
        PasteSubsystemAction pasteSubsystemAction = new PasteSubsystemAction(transferable, namespace);
        assertNotNull("Instance of PasteSubsystemAction should be created.", pasteSubsystemAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Paste Subsystem"));
    }
}
