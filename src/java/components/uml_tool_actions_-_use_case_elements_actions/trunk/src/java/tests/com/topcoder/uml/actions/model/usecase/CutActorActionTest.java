/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Unit test cases for <code>{@link CutActorAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutActorActionTest extends TestCase {
    /** The Actor instance for testing. */
    private Actor actor;

    /** The CutActorAction instance for testing. */
    private CutActorAction cutActorAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        actor = new ActorImpl();
        actor.setNamespace(new MockNamespaceAbstractImpl());
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutActorAction = new CutActorAction(actor, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#CutActorAction(Actor)}</code> with null actor. Should throw an Exception here.
     * </p>
     */
    public void testConstructor_Actor_NullActor() {
        try {
            actor = null;
            new CutActorAction(actor);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#CutActorAction(Actor)}</code> with success process.
     * </p>
     */
    public void testConstructor_Actor_Success() {
        cutActorAction = new CutActorAction(actor);
        assertNotNull(cutActorAction);
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#CutActorAction(Actor, Clipboard)}</code> with null actor. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ActorClipboard_NullActor() {
        try {
            actor = null;
            new CutActorAction(actor, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#CutActorAction(Actor, Clipboard)}</code> with null clipboard. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ActorClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CutActorAction(actor, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#CutActorAction(Actor, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_ActorClipboard_Success() {
        cutActorAction = new CutActorAction(actor, clipboard);
        assertNotNull(cutActorAction);
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#getPresentationName()}</code> with success process.
     * </p>
     */
    public void testGetPresentationName_Success() {
        assertEquals("Cut Actor", cutActorAction.getPresentationName());
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#execute()}</code> with success process.
     * </p>
     *
     * @throws Exception to junit.
     */
    public void testExecute_Success() throws Exception {
        //add the element to model 
        cutActorAction.redo();
        cutActorAction.undo();
        //execute the cut action
        cutActorAction.execute();
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#redo()}</code> with success process.
     * </p>
     */
    public void testRedo_Success() {
        cutActorAction.redo();
    }

    /**
     * <p>
     * Test <code>{@link CutActorAction#undo()}</code> with success process.
     * </p>
     */
    public void testUndo_Success() {
        cutActorAction.undo();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CutActorActionTest.class);
    }
}
