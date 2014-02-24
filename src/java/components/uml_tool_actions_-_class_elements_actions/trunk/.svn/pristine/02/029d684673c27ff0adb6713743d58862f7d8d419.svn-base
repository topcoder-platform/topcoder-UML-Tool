/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveAssociationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveAssociationActionTest extends TestCase {

    /**
     * Test Constructor, with correct association.
     */
    public void testCtor() {
        Association association = new AssociationImpl();

        RemoveAssociationAction removeAction = new RemoveAssociationAction(association);

        assertEquals("Should return ModelElement instance.", association, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null association. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullAssociation() {
        try {
            new RemoveAssociationAction(null);
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

        RemoveAssociationAction removeAction = new RemoveAssociationAction(association);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Association", removeAction.getPresentationName());
    }
}