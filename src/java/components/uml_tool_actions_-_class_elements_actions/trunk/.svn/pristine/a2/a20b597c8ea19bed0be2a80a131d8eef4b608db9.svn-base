/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import com.topcoder.uml.actions.model.classifiers.CopyEnumerationAction;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

import junit.framework.TestCase;

/**
 * Accuracy tests for CopyEnumerationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyEnumerationActionTest extends TestCase {
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
     * {@link CopyEnumerationAction#CopyEnumerationAction(Enumeration)}.
     */
    public void testCopyEnumerationActionEnumeration() {
        new CopyEnumerationAction(new EnumerationImpl());
    }

    /**
     * Test method for
     * {@link CopyEnumerationAction#CopyEnumerationAction(Enumeration, Clipboard)}.
     */
    public void testCopyEnumerationActionEnumerationClipboard() {
        new CopyEnumerationAction(new EnumerationImpl(), TestUtil.CLIPBORAD);
    }
}
