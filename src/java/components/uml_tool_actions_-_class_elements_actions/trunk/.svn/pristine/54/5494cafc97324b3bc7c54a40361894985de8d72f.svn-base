/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddInterfaceAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddInterfaceAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddInterfaceActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_NullInterface() {
        assertConstructorException(AddInterfaceAction.class, new Class[] {Interface.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the interface is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_1_NullUMLModelManager() {
        assertConstructorException(AddInterfaceAction.class, new Class[] {Interface.class, UMLModelManager.class},
            new Object[] {new InterfaceImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullInterface() {
        assertConstructorException(AddInterfaceAction.class, new Class[] {Interface.class, UMLModelManager.class,
            Namespace.class}, new Object[] {null, new UMLModelManager(), new PackageImpl()},
            IllegalArgumentException.class, "If the interface is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullUMLModelManager() {
        assertConstructorException(AddInterfaceAction.class, new Class[] {Interface.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new InterfaceImpl(), null, new PackageImpl()},
            IllegalArgumentException.class, "If the umlModelManager is null, should throw IllegalArgumentException");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddInterfaceAction#AddInterfaceAction(Interface, UMLModelManager, Namespace)}</code>
     * </p>
     */
    public void testCtor_2_NullNamespace() {
        assertConstructorException(AddInterfaceAction.class, new Class[] {Interface.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new InterfaceImpl(), new UMLModelManager(), null},
            IllegalArgumentException.class, "If the namespace is null, should throw IllegalArgumentException");
    }
}
