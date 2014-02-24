/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import com.topcoder.uml.actions.model.classifiers.RemoveEnumerationAction;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

import junit.framework.TestCase;

/**
 * Accuracy tests for RemoveEnumerationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveEnumerationActionTest extends TestCase {
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
     * RemoveEnumerationAction instance used for test.
     */
    private RemoveEnumerationAction action;

    /**
     * Test method for
     * {@link RemoveEnumerationAction#RemoveEnumerationAction(Enumeration)}.
     */
    public void testRemoveEnumerationAction() {
        action = new RemoveEnumerationAction(new EnumerationImpl());
    }

    /**
     * Test method for {@link RemoveEnumerationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveEnumerationAction();

        assertEquals("Presentation name is incorrect.", "Remove Enumeration",
                action.getPresentationName());
    }

}
