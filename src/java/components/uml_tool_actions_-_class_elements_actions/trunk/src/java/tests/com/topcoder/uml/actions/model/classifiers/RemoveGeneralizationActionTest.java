/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveGeneralizationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveGeneralizationActionTest extends TestCase {

    /**
     * Test Constructor, with correct generalization.
     */
    public void testCtor() {
        Generalization generalization = new GeneralizationImpl();

        RemoveGeneralizationAction removeAction = new RemoveGeneralizationAction(generalization);

        assertEquals("Should return ModelElement instance.", generalization, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null generalization. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullGeneralization() {
        try {
            new RemoveGeneralizationAction(null);
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

        RemoveGeneralizationAction removeAction = new RemoveGeneralizationAction(generalization);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Generalization", removeAction.getPresentationName());
    }
}