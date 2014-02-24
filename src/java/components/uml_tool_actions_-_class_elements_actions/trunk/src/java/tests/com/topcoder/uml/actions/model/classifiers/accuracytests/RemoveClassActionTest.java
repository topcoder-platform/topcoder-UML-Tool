/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveClassAction;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * Accuracy tests for RemoveClassAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveClassActionTest extends TestCase {
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
     * RemoveClassAction instance used for test.
     */
    private RemoveClassAction action;

    /**
     * Test method for {@link RemoveClassAction#RemoveClassAction(Class)}.
     */
    public void testRemoveClassAction() {
        action = new RemoveClassAction(new ClassImpl());
    }

    /**
     * Test method for {@link RemoveClassAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveClassAction();

        assertEquals("Presentation name is incorrect.", "Remove Class", action
                .getPresentationName());
    }

}
