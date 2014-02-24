/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

/**
 * Accuracy tests for RemoveDependencyAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveDependencyActionTest extends TestCase {
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
     * RemoveDependencyAction instance used for test.
     */
    private RemoveDependencyAction action;

    /**
     * Test method for
     * {@link RemoveDependencyAction#RemoveDependencyAction(Dependency)}.
     */
    public void testRemoveDependencyAction() {
        action = new RemoveDependencyAction(new DependencyImpl());
    }

    /**
     * Test method for {@link RemoveDependencyAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveDependencyAction();

        assertEquals("Presentation name is incorrect.", "Remove Dependency",
                action.getPresentationName());
    }

}
