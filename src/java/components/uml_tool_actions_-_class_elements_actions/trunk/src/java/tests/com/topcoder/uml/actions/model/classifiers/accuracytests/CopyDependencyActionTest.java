/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CopyDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

/**
 * Accuracy tests for CopyDependencyAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyDependencyActionTest extends TestCase {
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
     * {@link CopyDependencyAction#CopyDependencyAction(Dependency)}.
     */
    public void testCopyDependencyActionDependency() {
        new CopyDependencyAction(new DependencyImpl());
    }

    /**
     * Test method for
     * {@link CopyDependencyAction#CopyDependencyAction(Dependency, Clipboard)}.
     */
    public void testCopyDependencyActionDependencyClipboard() {
        new CopyDependencyAction(new DependencyImpl(), TestUtil.CLIPBORAD);
    }
}
