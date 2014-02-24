/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.RemoveActorAction;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>RemoveActorAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestRemoveActorAction extends TestCase {

    /**
     * The <code>Actor</code> instance used for test.
     */
    private Actor actor;

    /**
     * The <code>RemoveActorAction</code> instance used to test against.
     */
    private RemoveActorAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        actor = new ActorImpl();
        action = new RemoveActorAction(actor);
    }

    /**
     * Test the constructor <code>RemoveActorAction(Actor)</code>.
     */
    public void testConstructor() {
        RemoveActorAction removeActorAction = new RemoveActorAction(actor);
        assertNotNull("Instance of RemoveActorAction should be created.", removeActorAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Remove Actor"));
    }
}
