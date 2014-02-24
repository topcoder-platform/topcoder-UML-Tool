/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddGeneralizationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddGeneralizationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new AddGeneralizationAction(new GeneralizationImpl(),
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
     * AddGeneralizationAction instance.
     */
    private AddGeneralizationAction action;

    /**
     * Test method for
     * {@link AddGeneralizationAction#AddGeneralizationAction(Generalization, UMLModelManager)}.
     */
    public void testAddGeneralizationAction() {
        new AddGeneralizationAction(new GeneralizationImpl(),
                new UMLModelManager());
    }

    /**
     * Test method for {@link AddGeneralizationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Generalization",
                action.getPresentationName());
    }
}
