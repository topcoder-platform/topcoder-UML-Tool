/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

/**
 * Accuracy tests for RemoveGeneralizationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveGeneralizationActionTest extends TestCase {
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
     * RemoveGeneralizationAction instance used for test.
     */
    private RemoveGeneralizationAction action;

    /**
     * Test method for
     * {@link RemoveGeneralizationAction#RemoveGeneralizationAction(Generalization)}.
     */
    public void testRemoveGeneralizationAction() {
        action = new RemoveGeneralizationAction(new GeneralizationImpl());
    }

    /**
     * Test method for {@link RemoveGeneralizationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveGeneralizationAction();

        assertEquals("Presentation name is incorrect.",
                "Remove Generalization", action.getPresentationName());
    }

}
