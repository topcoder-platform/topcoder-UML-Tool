/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveClassAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveClassActionTest extends TestCase {

    /**
     * Test Constructor, with correct class.
     */
    public void testCtor() {
        com.topcoder.uml.model.core.classifiers.Class classs = new ClassImpl();

        RemoveClassAction removeAction = new RemoveClassAction(classs);

        assertEquals("Should return ModelElement instance.", classs, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null class. IllegalArgumentException is expected.
     */
    public void testCtorWithNullClass() {
        try {
            new RemoveClassAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        com.topcoder.uml.model.core.classifiers.Class classs = new ClassImpl();

        RemoveClassAction removeAction = new RemoveClassAction(classs);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Class", removeAction.getPresentationName());
    }
}