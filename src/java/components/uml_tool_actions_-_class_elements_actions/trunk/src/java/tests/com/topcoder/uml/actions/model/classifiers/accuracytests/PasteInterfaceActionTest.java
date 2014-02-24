/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteInterfaceAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

/**
 * Accuracy tests for PasteInterfaceAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteInterfaceActionTest extends TestCase {
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
     * PasteInterfaceAction instance used for test.
     */
    private PasteInterfaceAction action;

    /**
     * Test method for
     * {@link PasteInterfaceAction#PasteInterfaceAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteInterfaceAction() throws InvalidDataContentException {
        action = new PasteInterfaceAction(new ClassElementsTransfer(
                new InterfaceImpl()), TestUtil.getInstance().getNamespace());
    }

    /**
     * Test method for {@link PasteInterfaceAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteInterfaceAction();

        assertEquals("Presentation name is incorrect.", "Paste Interface",
                action.getPresentationName());
    }

}
