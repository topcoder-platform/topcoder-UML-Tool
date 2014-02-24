/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutExceptionAction;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;

/**
 * Accuracy tests for CutExceptionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutExceptionActionTest extends TestCase {
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
     * CutExceptionAction instance for test.
     */
    private CutExceptionAction action;

    /**
     * Test method for {@link CutExceptionAction#CutExceptionAction(Exception)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to Junit.
     */
    public void testCutExceptionActionException()
            throws InvalidDataContentException {
        new CutExceptionAction(TestUtil.getInstance().getException());
    }

    /**
     * Test method for
     * {@link CutExceptionAction#CutExceptionAction(Exception, Clipboard)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testCutExceptionActionExceptionClipboard()
            throws InvalidDataContentException {
        new CutExceptionAction(TestUtil.getInstance().getException(),
                TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutExceptionAction#getPresentationName()}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testGetPresentationName() throws InvalidDataContentException {
        action = new CutExceptionAction(TestUtil.getInstance().getException());
        assertEquals("Presentation name is incorrect.", "Cut Exception", action
                .getPresentationName());
    }

}
