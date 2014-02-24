/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.AddUseCaseAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddUseCaseAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddUseCaseActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager)}</code>
     * </p>
     * <p>
     * If actor is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullUseCase() {
        assertConstructorException(AddUseCaseAction.class, new Class[] {UseCase.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager)}</code>
     * </p>
     * <p>
     * If umlModelManager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullUMLModelManager() {
        assertConstructorException(AddUseCaseAction.class, new Class[] {UseCase.class, UMLModelManager.class},
            new Object[] {new UseCaseImpl(), null}, IllegalArgumentException.class,
            "If umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullUseCase() {
        assertConstructorException(AddUseCaseAction.class, new Class[] {UseCase.class, UMLModelManager.class,
            Namespace.class}, new Object[] {null, new UMLModelManager(), new MockNamespace()},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullManager() {
        assertConstructorException(AddUseCaseAction.class, new Class[] {UseCase.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new UseCaseImpl(), null, new MockNamespace()},
            IllegalArgumentException.class, "If umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddUseCaseAction#AddUseCaseAction(UseCase, UMLModelManager, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullNamespace() {
        assertConstructorException(AddUseCaseAction.class, new Class[] {UseCase.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new UseCaseImpl(), new UMLModelManager(), null},
            IllegalArgumentException.class, "If namespace is null, should throw IllegalArgumentException.");
    }
}
