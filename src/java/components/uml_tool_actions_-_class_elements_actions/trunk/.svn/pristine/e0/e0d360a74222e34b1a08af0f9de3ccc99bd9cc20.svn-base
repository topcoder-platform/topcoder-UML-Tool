/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddClassAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddClassActionTest extends TestCase {

    /**
     * The Class instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class classs = new ClassImpl();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * Test Constructor(Class, UMLModelManager), with correct class and manager.
     */
    public void testCtor1() {
        AddClassAction addAction = new AddClassAction(classs, manager);

        assertEquals("Should return ModelElement instance.", classs, addAction.getModelElement());
    }

    /**
     * Test Constructor(Class, UMLModelManager), with null class.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullClass() {
        try {
            new AddClassAction(null, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager), with null manager.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullManager() {
        try {
            new AddClassAction(classs, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with correct class,
     * manager and namespace.
     */
    public void testCtor2() {
        AddClassAction addAction = new AddClassAction(classs, manager, manager.getModel());

        assertEquals("Should return ModelElement instance.", classs, addAction.getModelElement());
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with null class.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullClass() {
        try {
            new AddClassAction(null, manager, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with null manager.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullManager() {
        try {
            new AddClassAction(classs, null, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, UMLModelManager, Namespace), with null namespace.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullNamespace() {
        try {
            new AddClassAction(classs, manager, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        AddClassAction addAction = new AddClassAction(classs, manager);

        assertEquals("Should return PRESENTATION_NAME.", "Add Class", addAction.getPresentationName());
    }
}