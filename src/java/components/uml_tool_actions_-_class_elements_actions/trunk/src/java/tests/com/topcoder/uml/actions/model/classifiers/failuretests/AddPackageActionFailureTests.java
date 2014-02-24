/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddPackageAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddPackageAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddPackageActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddPackageAction#AddPackageAction(Package, UMLModelManager)}</code> constructor.
     * </p>
     */
    public void testCtor_1_NullPackage() {
        assertConstructorException(AddPackageAction.class, new Class[] {Package.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the package is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddPackageAction#AddPackageAction(Package, UMLModelManager)}</code> constructor.
     * </p>
     */
    public void testCtor_1_NullUMLModelManager() {
        assertConstructorException(AddPackageAction.class, new Class[] {Package.class, UMLModelManager.class},
            new Object[] {new PackageImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddPackageAction#AddPackageAction(Package, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullPackage() {
        assertConstructorException(AddPackageAction.class, new Class[] {Package.class, UMLModelManager.class,
            Namespace.class}, new Object[] {null, new UMLModelManager(), new PackageImpl()},
            IllegalArgumentException.class, "If the package is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddPackageAction#AddPackageAction(Package, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullUMLModelManager() {
        assertConstructorException(AddPackageAction.class, new Class[] {Package.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new PackageImpl(), null, new PackageImpl()},
            IllegalArgumentException.class, "If the umlModelManager is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddPackageAction#AddPackageAction(Package, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullNamespace() {
        assertConstructorException(AddPackageAction.class, new Class[] {Package.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new PackageImpl(), new UMLModelManager(), null},
            IllegalArgumentException.class, "If the namespace is null, should throw IllegalArgumentException");
    }
}
