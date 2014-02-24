/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.RemoveAssociationAction;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * Accuracy tests for RemoveAssociationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveAssociationActionTest extends TestCase {
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
     * RemoveAssociationAction instance used for test.
     */
    private RemoveAssociationAction action;

    /**
     * Test method for
     * {@link RemoveAssociationAction#RemoveAssociationAction(Assoication)}.
     */
    public void testRemoveAssociationAction() {
        action = new RemoveAssociationAction(new AssociationImpl());
    }

    /**
     * Test method for {@link RemoveAssociationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        testRemoveAssociationAction();

        assertEquals("Presentation name is incorrect.", "Remove Association",
                action.getPresentationName());
    }

}
