/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddAbstractionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddAbstractionActionTest extends TestCase {

    /**
     * Test Constructor, with correct abstraction and manager.
     */
    public void testCtor() {
        Abstraction abstraction = new AbstractionImpl();

        AddAbstractionAction addAction = new AddAbstractionAction(abstraction, new UMLModelManager());

        assertEquals("Should return ModelElement instance.", abstraction, addAction.getModelElement());
    }

    /**
     * Test Constructor, with null abstraction. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullAbstraction() {
        try {
            new AddAbstractionAction(null, new UMLModelManager());
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
            new AddAbstractionAction(new AbstractionImpl(), null);
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

        AddAbstractionAction addAction = new AddAbstractionAction(abstraction, new UMLModelManager());

        assertEquals("Should return PRESENTATION_NAME.", "Add Abstraction", addAction.getPresentationName());
    }
}