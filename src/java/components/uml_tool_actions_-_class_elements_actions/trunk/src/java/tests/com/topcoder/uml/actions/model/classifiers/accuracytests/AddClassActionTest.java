/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddClassAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddClassAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddClassActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new AddClassAction(new ClassImpl(), new UMLModelManager());
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
     * AddClassAction instance.
     */
    private AddClassAction action;

    /**
     * Test method for
     * {@link AddClassAction#AddClassAction(Class, UMLModelManager)}.
     */
    public void testAddClassAction1() {
        new AddClassAction(new ClassImpl(), new UMLModelManager());
    }

    /**
     * Test method for
     * {@link AddClassAction#AddClassAction(Class, UMLModelManager,Namespace)}.
     */
    public void testAddClassAction2() {
        new AddClassAction(new ClassImpl(), new UMLModelManager(),
                new UMLModelManager().getModel());
    }

    /**
     * Test method for {@link AddClassAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Class", action
                .getPresentationName());
    }
}
