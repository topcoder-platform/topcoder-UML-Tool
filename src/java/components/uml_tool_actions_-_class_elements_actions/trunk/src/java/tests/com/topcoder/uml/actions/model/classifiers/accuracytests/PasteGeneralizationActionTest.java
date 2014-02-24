/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteGeneralizationAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

/**
 * Accuracy tests for PasteGeneralizationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteGeneralizationActionTest extends TestCase {
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
     * PasteGeneralizationAction instance used for test.
     */
    private PasteGeneralizationAction action;

    /**
     * Test method for
     * {@link PasteGeneralizationAction#PasteGeneralizationAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteGeneralizationAction()
            throws InvalidDataContentException {
        action = new PasteGeneralizationAction(new ClassElementsTransfer(
                new GeneralizationImpl()), TestUtil.getInstance()
                .getNamespace());
    }

    /**
     * Test method for {@link PasteGeneralizationAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteGeneralizationAction();

        assertEquals("Presentation name is incorrect.", "Paste Generalization",
                action.getPresentationName());
    }

}
