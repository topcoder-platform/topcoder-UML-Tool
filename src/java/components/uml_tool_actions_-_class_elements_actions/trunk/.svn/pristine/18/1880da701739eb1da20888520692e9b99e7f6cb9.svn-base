/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddInterfaceAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddInterfaceActionTest extends TestCase {

    /**
     * The Interface instance for the test.
     */
    private Interface interfacee = new InterfaceImpl();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * Test Constructor(Interface, UMLModelManager), with correct interface and
     * manager.
     */
    public void testCtor1() {
        AddInterfaceAction addAction = new AddInterfaceAction(interfacee, manager);

        assertEquals("Should return ModelElement instance.", interfacee, addAction.getModelElement());
    }

    /**
     * Test Constructor(Interface, UMLModelManager), with null interface.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullInterface() {
        try {
            new AddInterfaceAction(null, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Interface, UMLModelManager), with null manager.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullManager() {
        try {
            new AddInterfaceAction(interfacee, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Interface, UMLModelManager, Namespace), with correct
     * interface, manager and namespace.
     */
    public void testCtor2() {
        AddInterfaceAction addAction = new AddInterfaceAction(interfacee, manager, manager.getModel());

        assertEquals("Should return ModelElement instance.", interfacee, addAction.getModelElement());
    }

    /**
     * Test Constructor(Interface, UMLModelManager, Namespace), with null
     * interface. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullInterface() {
        try {
            new AddInterfaceAction(null, manager, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Interface, UMLModelManager, Namespace), with null
     * manager. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullManager() {
        try {
            new AddInterfaceAction(interfacee, null, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Interface, UMLModelManager, Namespace), with null
     * namespace. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullNamespace() {
        try {
            new AddInterfaceAction(interfacee, manager, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        AddInterfaceAction addAction = new AddInterfaceAction(interfacee, manager);

        assertEquals("Should return PRESENTATION_NAME.", "Add Interface", addAction.getPresentationName());
    }
}
