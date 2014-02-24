/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddAssociationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddAssociationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new AddAssociationAction(new AssociationImpl(),
                new UMLModelManager());
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
     * AddAssociationAction instance.
     */
    private AddAssociationAction action;

    /**
     * Test method for
     * {@link AddAssociationAction#AddAssociationAction(Association, UMLModelManager)}.
     */
    public void testAddAssociationAction() {
        new AddAssociationAction(new AssociationImpl(), new UMLModelManager());
    }

    /**
     * Test method for {@link AddAssociationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Association",
                action.getPresentationName());
    }
}
