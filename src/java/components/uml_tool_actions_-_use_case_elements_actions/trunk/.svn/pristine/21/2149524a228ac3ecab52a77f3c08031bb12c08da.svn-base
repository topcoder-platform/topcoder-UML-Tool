/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test cases for <code>{@link RemoveActorAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActorActionTest extends TestCase {
    /** The Actor instance for testing. */
    private Actor actor;

    /** The RemoveActorAction instance for testing. */
    private RemoveActorAction removeActorAction;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        actor = new ActorImpl();
        actor.setNamespace(new MockNamespaceAbstractImpl());
        removeActorAction = new RemoveActorAction(actor);
    }

    /**
     * <p>
     * Test <code>{@link RemoveActorAction#RemoveActorAction(Actor)}</code> with null actor. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_Actor_NullActor() {
        try {
            actor = null;
            new RemoveActorAction(actor);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link RemoveActorAction#RemoveActorAction(Actor)}</code> with success process.
     * </p>
     */
    public void testConstructor_Actor_Success() {
        removeActorAction = new RemoveActorAction(actor);
        assertNotNull(removeActorAction);
    }

    /**
     * <p>
     * Test <code>{@link RemoveActorAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Remove Actor", removeActorAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link RemoveActorAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        removeActorAction.redo();
        removeActorAction.undo();
        removeActorAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link RemoveActorAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        removeActorAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link RemoveActorAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        removeActorAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(RemoveActorActionTest.class);
    }
}
