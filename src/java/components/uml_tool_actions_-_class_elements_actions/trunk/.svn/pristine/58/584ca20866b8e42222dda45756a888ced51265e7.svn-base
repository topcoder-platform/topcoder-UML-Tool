/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveExceptionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveExceptionActionTest extends TestCase {

    /**
     * The Excpetion instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class exception = new ClassImpl();

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        // create a Exception
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName("Exception");
        exception.addStereotype(stereoType);
    }

    /**
     * Test Constructor, with correct class.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor() throws Exception {
        RemoveExceptionAction removeAction = new RemoveExceptionAction(exception);

        assertEquals("Should return ModelElement instance.", exception, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with wrong exception. InvalidDataContentException is
     * expected.
     */
    public void testCtor1WithWrongException() {
        try {
            new RemoveExceptionAction(new ClassImpl());
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test Constructor, with null exception. IllegalArgumentException is
     * expected.*
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorWithNullException() throws Exception {
        try {
            new RemoveExceptionAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testGetPresentationName() throws Exception {
        RemoveExceptionAction removeAction = new RemoveExceptionAction(exception);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Exception", removeAction.getPresentationName());
    }
}