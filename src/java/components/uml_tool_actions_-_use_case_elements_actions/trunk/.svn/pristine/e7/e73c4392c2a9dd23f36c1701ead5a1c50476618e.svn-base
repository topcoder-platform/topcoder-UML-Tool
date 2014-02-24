/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopyActorAction;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CopyActorAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCopyActorAction extends TestCase {

    /**
     * The <code>Actor</code> instance used for test.
     */
    private Actor actor;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        actor = new ActorImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test the constructor <code>CopyActorAction(Actor)</code>.
     */
    public void testConstructor() {
        CopyActorAction copyActorAction = new CopyActorAction(actor);
        assertNotNull("Instance of CopyActorAction should be created.", copyActorAction);
    }

    /**
     * Test the constructor <code>CopyActorAction(Actor, Clipboard)</code>.
     */
    public void testConstructorWithClipboard() {
        CopyActorAction copyActorAction = new CopyActorAction(actor, clipboard);
        assertNotNull("Instance of CopyActorAction should be created.", copyActorAction);
    }
}
