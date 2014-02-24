/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AddPackageAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddPackageActionTest extends TestCase {

    /**
     * The Package instance for the test.
     */
    private com.topcoder.uml.model.modelmanagement.Package packagee = new PackageImpl();

    /**
     * The UMLModelManager instance for the test.
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * Test Constructor(Package, UMLModelManager), with correct package and
     * manager.
     */
    public void testCtor1() {
        AddPackageAction addAction = new AddPackageAction(packagee, manager);

        assertEquals("Should return ModelElement instance.", packagee, addAction.getModelElement());
    }

    /**
     * Test Constructor(Package, UMLModelManager), with null package.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullPackage() {
        try {
            new AddPackageAction(null, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Package, UMLModelManager), with null manager.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullManager() {
        try {
            new AddPackageAction(packagee, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Package, UMLModelManager, Namespace), with correct
     * package, manager and namespace.
     */
    public void testCtor2() {
        AddPackageAction addAction = new AddPackageAction(packagee, manager, manager.getModel());

        assertEquals("Should return ModelElement instance.", packagee, addAction.getModelElement());
    }

    /**
     * Test Constructor(Package, UMLModelManager, Namespace), with null package.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullPackage() {
        try {
            new AddPackageAction(null, manager, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Package, UMLModelManager, Namespace), with null manager.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullManager() {
        try {
            new AddPackageAction(packagee, null, manager.getModel());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Package, UMLModelManager, Namespace), with null
     * namespace. IllegalArgumentException is expected.
     */
    public void testCtor2WithNullNamespace() {
        try {
            new AddPackageAction(packagee, manager, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        AddPackageAction addAction = new AddPackageAction(packagee, manager);

        assertEquals("Should return PRESENTATION_NAME.", "Add Package", addAction.getPresentationName());
    }
}