/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteAbstractionAction;
import com.topcoder.uml.model.core.Namespace;

/**
 * Accuracy tests for PasteAbstractionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteAssoicationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
    }

    /**
     * Unload logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * PasteAbstractionAction instance used for test.
     */
    private PasteAbstractionAction action;

    /**
     * Test method for
     * {@link PasteAbstractionAction#PasteAbstractionAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteAbstractionAction() throws InvalidDataContentException {
        action = new PasteAbstractionAction(TestUtil.getInstance()
                .getTransferable(), TestUtil.getInstance().getNamespace());
    }

    /**
     * Test method for {@link PasteAbstractionAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteAbstractionAction();

        assertEquals("Presentation name is incorrect.", "Paste Abstraction",
                action.getPresentationName());
    }

}
