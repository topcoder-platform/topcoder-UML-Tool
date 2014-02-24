/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.CutDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

/**
 * Accuracy tests for CutDependencyAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutDependencyActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new CutDependencyAction(new DependencyImpl());
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
     * CutDependencyAction instance for test.
     */
    private CutDependencyAction action;

    /**
     * Test method for
     * {@link CutDependencyAction#CutDependencyAction(Dependency)}.
     */
    public void testCutDependencyActionDependency() {
        new CutDependencyAction(new DependencyImpl());
    }

    /**
     * Test method for
     * {@link CutDependencyAction#CutDependencyAction(Dependency, Clipboard)}.
     */
    public void testCutDependencyActionDependencyClipboard() {
        new CutDependencyAction(new DependencyImpl(), TestUtil.CLIPBORAD);
    }

    /**
     * Test method for {@link CutDependencyAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Cut Dependency",
                action.getPresentationName());
    }

}
