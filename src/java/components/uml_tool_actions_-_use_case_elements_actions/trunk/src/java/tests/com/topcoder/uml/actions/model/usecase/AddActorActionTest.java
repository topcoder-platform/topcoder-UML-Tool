/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link AddActorAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddActorActionTest extends TestCase {
    /** The Actor instance for testing. */
    private Actor actor;

    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The AddActorAction instance for testing. */
    private AddActorAction addActorAction;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        actor = new ActorImpl();
        manager = new UMLModelManager();
        addActorAction = new AddActorAction(actor, manager);
        namespace = new MockNamespaceAbstractImpl();
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager)}</code> with null actor. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ActorUMLModelManager_NullActor() {
        try {
            actor = null;
            new AddActorAction(actor, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager)}</code> with null manager. Should throw
     * an Exception here.
     * </p>
     */
    public void testConstructor_ActorUMLModelManager_NullUMLModelManager() {
        try {
            manager = null;
            new AddActorAction(actor, manager);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager)}</code> with success process.
     * </p>
     */
    public void testConstructor_ActorUMLModelManager_Success() {
        addActorAction = new AddActorAction(actor, manager);
        assertNotNull(addActorAction);
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code> with null actor.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ActorUMLModelNamespace_NullActor() {
        try {
            actor = null;
            new AddActorAction(actor, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code> with null manager.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ActorUMLModelNamespace_NullUMLModel() {
        try {
            manager = null;
            new AddActorAction(actor, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code> with null namespace.
     * Should throw an Exception here.
     * </p>
     */
    public void testConstructor_ActorUMLModelNamespace_NullNamespace() {
        try {
            namespace = null;
            new AddActorAction(actor, manager, namespace);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#AddActorAction(Actor, UMLModelManager, Namespace)}</code> with success process.
     * </p>
     */
    public void testConstructor_ActorUMLModelNamespace_Success() {
        addActorAction = new AddActorAction(actor, manager, namespace);
        assertNotNull(addActorAction);
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Add Actor", addActorAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        addActorAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        addActorAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link AddActorAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        addActorAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(AddActorActionTest.class);
    }
}
