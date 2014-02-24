/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteEnumerationAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

/**
 * Accuracy tests for PasteEnumerationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteEnumerationActionTest extends TestCase {
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
     * PasteEnumerationAction instance used for test.
     */
    private PasteEnumerationAction action;

    /**
     * Test method for
     * {@link PasteEnumerationAction#PasteEnumerationAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteEnumerationAction() throws InvalidDataContentException {
        action = new PasteEnumerationAction(new ClassElementsTransfer(
                new EnumerationImpl()), TestUtil.getInstance().getNamespace());
    }

    /**
     * Test method for {@link PasteEnumerationAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteEnumerationAction();

        assertEquals("Presentation name is incorrect.", "Paste Enumeration",
                action.getPresentationName());
    }

}
