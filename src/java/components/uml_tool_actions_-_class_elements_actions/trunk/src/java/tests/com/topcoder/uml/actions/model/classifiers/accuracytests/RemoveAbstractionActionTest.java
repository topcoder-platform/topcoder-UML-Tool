/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveAbstractionAction;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

/**
 * Accuracy tests for RemoveAbstractionAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveAbstractionActionTest extends TestCase {
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
     * RemoveAbstractionAction instance used for test.
     */
    private RemoveAbstractionAction action;

    /**
     * Test method for
     * {@link RemoveAbstractionAction#RemoveAbstractionAction(Abstraction)}.
     */
    public void testRemoveAbstractionAction() {
        action = new RemoveAbstractionAction(new AbstractionImpl());
    }

    /**
     * Test method for {@link RemoveAbstractionAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveAbstractionAction();

        assertEquals("Presentation name is incorrect.", "Remove Abstraction",
                action.getPresentationName());
    }

}
