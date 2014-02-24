/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyInterfaceAction;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

/**
 * Accuracy tests for CopyInterfaceAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyInterfaceActionTest extends TestCase {
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
     * {@link CopyInterfaceAction#CopyInterfaceAction(Interface)}.
     */
    public void testCopyInterfaceActionInterface() {
        new CopyInterfaceAction(new InterfaceImpl());
    }

    /**
     * Test method for
     * {@link CopyInterfaceAction#CopyInterfaceAction(Interface, Clipboard)}.
     */
    public void testCopyInterfaceActionInterfaceClipboard() {
        new CopyInterfaceAction(new InterfaceImpl(), TestUtil.CLIPBORAD);
    }
}
