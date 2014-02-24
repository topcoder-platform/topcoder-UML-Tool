/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddDependencyAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddDependencyActionTest extends TestCase {

    /**
     * Test Constructor, with correct dependency and manager.
     */
    public void testCtor() {
        Dependency dependency = new DependencyImpl();

        AddDependencyAction addAction = new AddDependencyAction(dependency, new UMLModelManager());

        assertEquals("Should return ModelElement instance.", dependency, addAction.getModelElement());
    }

    /**
     * Test Constructor, with null dependency. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullDependency() {
        try {
            new AddDependencyAction(null, new UMLModelManager());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor, with null manager. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullManager() {
        try {
            new AddDependencyAction(new DependencyImpl(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        Dependency dependency = new DependencyImpl();

        AddDependencyAction addAction = new AddDependencyAction(dependency, new UMLModelManager());

        assertEquals("Should return PRESENTATION_NAME.", "Add Dependency", addAction.getPresentationName());
    }
}