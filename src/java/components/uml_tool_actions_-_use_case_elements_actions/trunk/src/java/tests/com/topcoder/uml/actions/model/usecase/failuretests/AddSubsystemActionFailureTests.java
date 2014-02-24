/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.AddSubsystemAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddSubsystemAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddSubsystemActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager)}</code>
     * </p>
     * <p>
     * If actor is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullActor() {
        assertConstructorException(AddSubsystemAction.class, new Class[] {Subsystem.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager)}</code>
     * </p>
     * <p>
     * If umlModelManager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullUMLModelManager() {
        assertConstructorException(AddSubsystemAction.class, new Class[] {Subsystem.class, UMLModelManager.class},
            new Object[] {new SubsystemImpl(), null}, IllegalArgumentException.class,
            "If umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullSubsystem() {
        assertConstructorException(AddSubsystemAction.class, new Class[] {Subsystem.class, UMLModelManager.class,
            Namespace.class}, new Object[] {null, new UMLModelManager(), new MockNamespace()},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullManager() {
        assertConstructorException(AddSubsystemAction.class, new Class[] {Subsystem.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new SubsystemImpl(), null, new MockNamespace()},
            IllegalArgumentException.class, "If umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddSubsystemAction#AddSubsystemAction(Subsystem, UMLModelManager, Namespace)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullNamespace() {
        assertConstructorException(AddSubsystemAction.class, new Class[] {Subsystem.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new SubsystemImpl(), new UMLModelManager(), null},
            IllegalArgumentException.class, "If namespace is null, should throw IllegalArgumentException.");
    }
}
