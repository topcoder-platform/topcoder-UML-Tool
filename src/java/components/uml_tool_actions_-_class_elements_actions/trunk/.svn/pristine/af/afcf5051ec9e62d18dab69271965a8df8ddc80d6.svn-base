/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveDependencyAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveDependencyActionTest extends TestCase {

    /**
     * Test Constructor, with correct dependency.
     */
    public void testCtor() {
        Dependency dependency = new DependencyImpl();

        RemoveDependencyAction removeAction = new RemoveDependencyAction(dependency);

        assertEquals("Should return ModelElement instance.", dependency, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null dependency. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullDependency() {
        try {
            new RemoveDependencyAction(null);
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

        RemoveDependencyAction removeAction = new RemoveDependencyAction(dependency);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Dependency", removeAction.getPresentationName());
    }
}