/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveEnumerationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveEnumerationActionTest extends TestCase {

    /**
     * Test Constructor, with correct enumeration.
     */
    public void testCtor() {
        Enumeration enumeration = new EnumerationImpl();

        RemoveEnumerationAction removeAction = new RemoveEnumerationAction(enumeration);

        assertEquals("Should return ModelElement instance.", enumeration, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null enumeration. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullEnumeration() {
        try {
            new RemoveEnumerationAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        Enumeration enumeration = new EnumerationImpl();

        RemoveEnumerationAction removeAction = new RemoveEnumerationAction(enumeration);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Enumeration", removeAction.getPresentationName());
    }
}