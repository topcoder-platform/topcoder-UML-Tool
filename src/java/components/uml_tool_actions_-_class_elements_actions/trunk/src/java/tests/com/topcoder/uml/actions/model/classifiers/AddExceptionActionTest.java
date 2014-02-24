/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddExceptionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddExceptionActionTest extends TestCase {

    /**
     * The Excpetion instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class exception = new ClassImpl();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

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
     * Test Constructor(Class, UMLModelManager), with correct exception and
     * manager.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor1() throws Exception {
        AddExceptionAction addAction = new AddExceptionAction(exception, manager);

        assertEquals("Should return ModelElement instance.", exception, addAction.getModelElement());
    }

    /**
     * Test Constructor(Class, UMLModelManager), with wrong exception.
     * InvalidDataContentException is expected.
     */
    public void testCtor1WithWrongException() {
        try {
            new AddExceptionAction(new ClassImpl(), manager);
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager), with null exception.
     * IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor1WithNullException() throws Exception {
        try {
            new AddExceptionAction(null, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager), with null manager.
     * IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor1WithNullManager() throws Exception {
        try {
            new AddExceptionAction(exception, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with correct
     * exception, manager and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2() throws Exception {
        AddExceptionAction addAction = new AddExceptionAction(exception, manager, manager.getModel());

        assertEquals("Should return ModelElement instance.", exception, addAction.getModelElement());
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with wrong
     * exception. InvalidDataContentException is expected.
     */
    public void testCtor2WithWrongException() {
        try {
            new AddExceptionAction(new ClassImpl(), manager, manager.getModel());
            fail("InvalidDataContentException is expected.");
        } catch (InvalidDataContentException idce) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with null exception.
     * IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullException() throws Exception {
        try {
            new AddExceptionAction(null, manager, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with null manager.
     * IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullManager() throws Exception {
        try {
            new AddExceptionAction(exception, null, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with null namespace.
     * IllegalArgumentException is expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtor2WithNullNamespace() throws Exception {
        try {
            new AddExceptionAction(exception, manager, null);
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
        AddExceptionAction addAction = new AddExceptionAction(exception, manager);

        assertEquals("Should return PRESENTATION_NAME.", "Add Exception", addAction.getPresentationName());
    }
}