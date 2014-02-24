/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddEnumerationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddEnumerationActionTest extends TestCase {

    /**
     * The Enumeration instance for the test.
     */
    private Enumeration enumeration = new EnumerationImpl();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * Test Constructor(Enumeration, UMLModelManager), with correct enumeration
     * and manager.
     */
    public void testCtor1() {
        AddEnumerationAction addAction = new AddEnumerationAction(enumeration, manager);

        assertEquals("Should return ModelElement instance.", enumeration, addAction.getModelElement());
    }

    /**
     * Test Constructor(Enumeration, UMLModelManager), with null enumeration.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullEnumeration() {
        try {
            new AddEnumerationAction(null, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Enumeration, UMLModelManager), with null manager.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullManager() {
        try {
            new AddEnumerationAction(enumeration, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Enumeration, UMLModelManager, Namespace), with correct
     * enumeration, manager and namespace.
     */
    public void testCtor2() {
        AddEnumerationAction addAction = new AddEnumerationAction(enumeration, manager, manager.getModel());

        assertEquals("Should return ModelElement instance.", enumeration, addAction.getModelElement());
    }

    /**
     * Test Constructor(Enumeration, UMLModelManager, Namespace), with null
     * enumeration. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullEnumeration() {
        try {
            new AddEnumerationAction(null, manager, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Enumeration, UMLModelManager, Namespace), with null
     * manager. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullManager() {
        try {
            new AddEnumerationAction(enumeration, null, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Enumeration, UMLModelManager, Namespace), with null
     * namespace. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullNamespace() {
        try {
            new AddEnumerationAction(enumeration, manager, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        AddEnumerationAction addAction = new AddEnumerationAction(enumeration, manager);

        assertEquals("Should return PRESENTATION_NAME.", "Add Enumeration", addAction.getPresentationName());
    }
}