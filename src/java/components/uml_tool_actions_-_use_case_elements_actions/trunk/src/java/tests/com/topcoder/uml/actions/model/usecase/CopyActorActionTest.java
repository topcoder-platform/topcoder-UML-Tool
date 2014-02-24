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
 * Unit test cases for <code>{@link CopyActorAction}</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyActorActionTest extends TestCase {
    /** The Actor instance for testing. */
    private Actor actor;

    /** The CopyActorAction instance for testing. */
    private CopyActorAction copyActorAction;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        actor = new ActorImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyActorAction = new CopyActorAction(actor, clipboard);
    }

    /**
     * <p>
     * Test <code>{@link CopyActorAction#CopyActorAction(Actor)}</code> with null actor. Should throw an Exception
     * here.
     * </p>
     */
    public void testConstructor_Actor_NullActor() {
        try {
            actor = null;
            new CopyActorAction(actor);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyActorAction#CopyActorAction(Actor)}</code> with success process.
     * </p>
     */
    public void testConstructor_Actor_Success() {
        copyActorAction = new CopyActorAction(actor);
        assertNotNull(copyActorAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyActorAction#CopyActorAction(Actor, Clipboard)}</code> with null actor. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ActorClipboard_NullActor() {
        try {
            actor = null;
            new CopyActorAction(actor, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyActorAction#CopyActorAction(Actor, Clipboard)}</code> with null clipboard. Should throw an
     * Exception here.
     * </p>
     */
    public void testConstructor_ActorClipboard_NullClipboard() {
        try {
            clipboard = null;
            new CopyActorAction(actor, clipboard);
            fail("Should throw an IllegalArgumentException here.");
        } catch (IllegalArgumentException iae) {
            //success
        }
    }

    /**
     * <p>
     * Test <code>{@link CopyActorAction#CopyActorAction(Actor, Clipboard)}</code> with success process.
     * </p>
     */
    public void testConstructor_ActorClipboard_Success() {
        copyActorAction = new CopyActorAction(actor, clipboard);
        assertNotNull(copyActorAction);
    }

    /**
     * <p>
     * Test <code>{@link CopyActorAction#execute()}</code> with success process.
     * </p>
     */
    public void testExecute_Success() {
        copyActorAction.execute();
        assertNotNull(clipboard.getContents(null));
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(CopyActorActionTest.class);
    }
}
