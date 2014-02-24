/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyExceptionAction;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;

/**
 * Accuracy tests for CopyExceptionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyExceptionActionTest extends TestCase {
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
     * Test method for
     * {@link CopyExceptionAction#CopyExceptionAction(Exception)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to Junit.
     */
    public void testCopyExceptionActionException()
            throws InvalidDataContentException {
        new CopyExceptionAction(TestUtil.getInstance().getException());
    }

    /**
     * Test method for
     * {@link CopyExceptionAction#CopyExceptionAction(Exception, Clipboard)}.
     * 
     * @throws InvalidDataContentException
     *             Exception to JUnit.
     */
    public void testCopyExceptionActionExceptionClipboard()
            throws InvalidDataContentException {
        new CopyExceptionAction(TestUtil.getInstance().getException(),
                TestUtil.CLIPBORAD);
    }
}
