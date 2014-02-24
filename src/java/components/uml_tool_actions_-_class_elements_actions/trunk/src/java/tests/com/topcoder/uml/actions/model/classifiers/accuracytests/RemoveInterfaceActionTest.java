/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveInterfaceAction;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

/**
 * Accuracy tests for RemoveInterfaceAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveInterfaceActionTest extends TestCase {
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
     * RemoveInterfaceAction instance used for test.
     */
    private RemoveInterfaceAction action;

    /**
     * Test method for
     * {@link RemoveInterfaceAction#RemoveInterfaceAction(Interface)}.
     */
    public void testRemoveInterfaceAction() {
        action = new RemoveInterfaceAction(new InterfaceImpl());
    }

    /**
     * Test method for {@link RemoveInterfaceAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveInterfaceAction();

        assertEquals("Presentation name is incorrect.", "Remove Interface",
                action.getPresentationName());
    }

}
