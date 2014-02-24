/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.AddActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddActorAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddActorActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager)}</code>
     * </p>
     * <p>
     * If actor is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullActor() {
        assertConstructorException(AddActorAction.class, new Class[] {Actor.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager)}</code>
     * </p>
     * <p>
     * If umlModelManager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullUMLModelManager() {
        assertConstructorException(AddActorAction.class, new Class[] {Actor.class, UMLModelManager.class},
            new Object[] {new ActorImpl(), null}, IllegalArgumentException.class,
            "If umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullActor() {
        assertConstructorException(AddActorAction.class, new Class[] {Actor.class, UMLModelManager.class,
            Namespace.class}, new Object[] {null, new UMLModelManager(), new MockNamespace()},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullManager() {
        assertConstructorException(AddActorAction.class, new Class[] {Actor.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new ActorImpl(), null, new MockNamespace()},
            IllegalArgumentException.class, "If umlModelManager is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_nullNamespace() {
        assertConstructorException(AddActorAction.class, new Class[] {Actor.class, UMLModelManager.class,
            Namespace.class}, new Object[] {new ActorImpl(), new UMLModelManager(), null},
            IllegalArgumentException.class, "If namespace is null, should throw IllegalArgumentException.");
    }
}
