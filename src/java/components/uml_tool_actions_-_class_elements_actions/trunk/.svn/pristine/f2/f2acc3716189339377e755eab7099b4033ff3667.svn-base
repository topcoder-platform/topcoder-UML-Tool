/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import com.topcoder.uml.actions.model.classifiers.AddEnumerationAction;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Accuracy tests for AddEnumerationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddEnumerationActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new AddEnumerationAction(new EnumerationImpl(),
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
     * AddEnumerationAction instance.
     */
    private AddEnumerationAction action;

    /**
     * Test method for
     * {@link AddEnumerationAction#AddEnumerationAction(Enumeration, UMLModelManager)}.
     */
    public void testAddEnumerationAction() {
        action = new AddEnumerationAction(new EnumerationImpl(),
                new UMLModelManager());
    }

    /**
     * Test method for {@link AddEnumerationAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Enumeration",
                action.getPresentationName());
    }
}
