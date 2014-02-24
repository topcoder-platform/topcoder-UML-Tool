/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddGeneralizationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddGeneralizationActionTest extends TestCase {

    /**
     * Test Constructor, with correct generalization and manager.
     */
    public void testCtor() {
        Generalization generalization = new GeneralizationImpl();

        AddGeneralizationAction addAction = new AddGeneralizationAction(generalization, new UMLModelManager());

        assertEquals("Should return ModelElement instance.", generalization, addAction.getModelElement());
    }

    /**
     * Test Constructor, with null generalization. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullGeneralization() {
        try {
            new AddGeneralizationAction(null, new UMLModelManager());
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
            new AddGeneralizationAction(new GeneralizationImpl(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        Generalization generalization = new GeneralizationImpl();

        AddGeneralizationAction addAction = new AddGeneralizationAction(generalization, new UMLModelManager());

        assertEquals("Should return PRESENTATION_NAME.", "Add Generalization", addAction.getPresentationName());
    }
}