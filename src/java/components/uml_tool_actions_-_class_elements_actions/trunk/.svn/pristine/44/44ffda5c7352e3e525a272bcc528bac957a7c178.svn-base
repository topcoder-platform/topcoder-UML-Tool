/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveAbstractionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveAbstractionActionTest extends TestCase {

    /**
     * Test Constructor, with correct abstraction.
     */
    public void testCtor() {
        Abstraction abstraction = new AbstractionImpl();

        RemoveAbstractionAction removeAction = new RemoveAbstractionAction(abstraction);

        assertEquals("Should return ModelElement instance.", abstraction, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null abstraction. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullAbstraction() {
        try {
            new RemoveAbstractionAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        Abstraction abstraction = new AbstractionImpl();

        RemoveAbstractionAction removeAction = new RemoveAbstractionAction(abstraction);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Abstraction", removeAction.getPresentationName());
    }
}