/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddEnumerationAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddEnumerationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddEnumerationActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddEnumerationAction#AddEnumerationAction(Enumeration, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_NullEnumeration() {
        assertConstructorException(AddEnumerationAction.class, new Class[] {Enumeration.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the enumeration is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddEnumerationAction#AddEnumerationAction(Enumeration, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_NullUMLModelManager() {
        assertConstructorException(AddEnumerationAction.class, new Class[] {Enumeration.class, UMLModelManager.class},
            new Object[] {new EnumerationImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddEnumerationAction#AddEnumerationAction(Enumeration, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullEnumeration() {
        assertConstructorException(AddEnumerationAction.class, new Class[] {Enumeration.class, UMLModelManager.class,
            Namespace.class}, new Object[] {null, new UMLModelManager(), new PackageImpl()},
            IllegalArgumentException.class, "If the enumeration is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddEnumerationAction#AddEnumerationAction(Enumeration, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullUMLModelManager() {
        assertConstructorException(AddEnumerationAction.class, new Class[] {Enumeration.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new EnumerationImpl(), null, new PackageImpl()},
            IllegalArgumentException.class, "If the umlModelManager is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddEnumerationAction#AddEnumerationAction(Enumeration, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullNamespace() {
        assertConstructorException(AddEnumerationAction.class, new Class[] {Enumeration.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new EnumerationImpl(), new UMLModelManager(), null},
            IllegalArgumentException.class, "If the namespace is null, should throw IllegalArgumentException");
    }
}
