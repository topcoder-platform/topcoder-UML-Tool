/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.AddPackageAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * Accuracy tests for AddPackageAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class AddPackageActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
        action = new AddPackageAction(new PackageImpl(), new UMLModelManager());
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
     * AddPackageAction instance.
     */
    private AddPackageAction action;

    /**
     * Test method for
     * {@link AddPackageAction#AddPackageAction(Package, UMLModelManager)}.
     */
    public void testAddPackageAction1() {
        new AddPackageAction(new PackageImpl(), new UMLModelManager());
    }

    /**
     * Test method for
     * {@link AddPackageAction#AddPackageAction(Package, UMLModelManager, Namespace)}.
     */
    public void testAddPackageAction2() {
        new AddPackageAction(new PackageImpl(), new UMLModelManager(),
                new UMLModelManager().getModel());
    }

    /**
     * Test method for {@link AddPackageAction#getPresentationName()}.
     */
    public void testGetPresentationName() {
        assertEquals("Presentation name is incorrect.", "Add Package", action
                .getPresentationName());
    }
}
