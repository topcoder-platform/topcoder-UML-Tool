/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteClassAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy tests for PasteClassAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteClassActionTest extends TestCase {
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
     * PasteClassAction instance used for test.
     */
    private PasteClassAction action;

    /**
     * Test method for
     * {@link PasteClassAction#PasteClassAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteClassAction() throws InvalidDataContentException {
        action = new PasteClassAction(
                new ClassElementsTransfer(new ClassImpl()), TestUtil
                        .getInstance().getNamespace());
    }

    /**
     * Test method for {@link PasteClassAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteClassAction();

        assertEquals("Presentation name is incorrect.", "Paste Class", action
                .getPresentationName());
    }

}
