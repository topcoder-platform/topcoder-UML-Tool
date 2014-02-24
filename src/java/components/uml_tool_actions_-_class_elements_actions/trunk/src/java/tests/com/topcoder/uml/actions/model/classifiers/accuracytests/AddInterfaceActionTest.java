/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddInterfaceAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddInterfaceAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddInterfaceActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new AddInterfaceAction(new InterfaceImpl(),
                new UMLModelManager());
    }

    /**
     * Unload logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * AddInterfaceAction instance.
     */
    private AddInterfaceAction action;

    /**
     * Test method for
     * {@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager)}.
     */
    public void testAddInterfaceAction1() {
        new AddInterfaceAction(new InterfaceImpl(), new UMLModelManager());
    }

    /**
     * Test method for
     * {@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager,Namespace)}.
     */
    public void testAddInterfaceAction2() {
        new AddInterfaceAction(new InterfaceImpl(), new UMLModelManager(),
                new UMLModelManager().getModel());
    }

    /**
     * Test method for {@link AddInterfaceAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Interface", action
                .getPresentationName());
    }
}
