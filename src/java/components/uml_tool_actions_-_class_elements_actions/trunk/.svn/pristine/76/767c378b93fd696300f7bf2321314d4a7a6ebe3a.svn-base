/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.PasteExceptionAction;
import com.topcoder.uml.model.core.Namespace;

/**
 * Accuracy tests for PasteExceptionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteExceptionActionTest extends TestCase {
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
     * PasteExceptionAction instance used for test.
     */
    private PasteExceptionAction action;

    /**
     * Test method for
     * {@link PasteExceptionAction#PasteExceptionAction(Transferable, Namespace)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testPasteExceptionAction() throws InvalidDataContentException {
        action = new PasteExceptionAction(new ClassElementsTransfer(TestUtil
                .getInstance().getException()), TestUtil.getInstance()
                .getNamespace());
    }

    /**
     * Test method for {@link PasteExceptionAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        testPasteExceptionAction();

        assertEquals("Presentation name is incorrect.", "Paste Exception",
                action.getPresentationName());
    }

}
