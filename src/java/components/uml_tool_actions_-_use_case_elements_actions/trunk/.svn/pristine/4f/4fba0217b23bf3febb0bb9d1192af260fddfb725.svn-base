/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutActorAction;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>CutActorAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCutActorAction extends TestCase {

    /**
     * The <code>Actor</code> instance used for test.
     */
    private Actor actor;

    /**
     * The <code>Clipboard</code> instance used for test.
     */
    private Clipboard clipboard = null;

    /**
     * The <code>CutActorAction</code> instance used to test against.
     */
    private CutActorAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        actor = new ActorImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        action = new CutActorAction(actor);
    }

    /**
     * Test the constructor <code>CutActorAction(Actor)</code>.
     */
    public void testConstructor() {
        CutActorAction cutActorAction = new CutActorAction(actor);
        assertNotNull("Instance of CutActorAction should be created.", cutActorAction);
    }

    /**
     * Test the constructor <code>CutActorAction(Actor, Clipboard)</code>.
     */
    public void testConstructorWithNamespace() {
        CutActorAction cutActorAction = new CutActorAction(actor, clipboard);
        assertNotNull("Instance of CutActorAction should be created.", cutActorAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Cut Actor"));
    }
}
