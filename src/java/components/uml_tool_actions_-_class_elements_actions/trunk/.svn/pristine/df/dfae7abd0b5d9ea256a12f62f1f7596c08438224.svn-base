/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddAssociationAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddDependencyActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();

        action = new AddDependencyAction(new DependencyImpl(),
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
     * DependencyAction instance.
     */
    private AddDependencyAction action;

    /**
     * Test method for
     * {@link DependencyAction#DependencyAction(Dependency, UMLModelManager)}.
     */
    public void testDependencyAction() {
        new AddDependencyAction(new DependencyImpl(), new UMLModelManager());
    }

    /**
     * Test method for {@link DependencyAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Dependency",
                action.getPresentationName());
    }
}
