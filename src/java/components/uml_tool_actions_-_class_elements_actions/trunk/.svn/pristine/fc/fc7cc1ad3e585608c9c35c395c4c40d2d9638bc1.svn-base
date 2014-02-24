/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddAssociationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddAssociationActionTest extends TestCase {

    /**
     * Test Constructor, with correct association and manager.
     */
    public void testCtor() {
        Association association = new AssociationImpl();

        AddAssociationAction addAction = new AddAssociationAction(association, new UMLModelManager());

        assertEquals("Should return ModelElement instance.", association, addAction.getModelElement());
    }

    /**
     * Test Constructor, with null association. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullAssociation() {
        try {
            new AddAssociationAction(null, new UMLModelManager());
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
            new AddAssociationAction(new AssociationImpl(), null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        Association association = new AssociationImpl();

        AddAssociationAction addAction = new AddAssociationAction(association, new UMLModelManager());

        assertEquals("Should return PRESENTATION_NAME.", "Add Association", addAction.getPresentationName());
    }
}