/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyClassAction;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy tests for CopyClassAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyClassActionTest extends TestCase {
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
     * Test method for {@link CopyClassAction#CopyClassAction(Class)}.
     */
    public void testCopyClassActionClass() {
        new CopyClassAction(new ClassImpl());
    }

    /**
     * Test method for {@link CopyClassAction#CopyClassAction(Class, Clipboard)}.
     */
    public void testCopyClassActionClassClipboard() {
        new CopyClassAction(new ClassImpl(), TestUtil.CLIPBORAD);
    }
}
