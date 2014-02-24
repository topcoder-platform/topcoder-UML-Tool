/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.accuracytests;

import com.topcoder.uml.actions.model.usecase.AddActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Accuracy test for the <code>AddActorAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestAddActorAction extends TestCase {

    /**
     * The <code>Actor</code> instance used for test.
     */
    private Actor actor;

    /**
     * The <code>UMLModelManager</code> instance used for test.
     */
    private UMLModelManager manager;

    /**
     * The <code>Namespace</code> instance used for test.
     */
    private Namespace namespace;

    /**
     * The <code>AddActorAction</code> instance used to test against.
     */
    private AddActorAction action;

    /**
     * Set up the test environment.
     */
    public void setUp() {
        actor = new ActorImpl();
        manager = new UMLModelManager();
        namespace = new MockNamespaceImpl();
        action = new AddActorAction(actor, manager);
    }

    /**
     * Test the constructor <code>AddActorAction(Actor, UMLModelManager)</code>.
     */
    public void testConstructor() {
        AddActorAction addActorAction = new AddActorAction(actor, manager);
        assertNotNull("Instance of AddActorAction should be created.", addActorAction);
    }

    /**
     * Test the constructor <code>AddActorAction(Actor, UMLModelManager, Namespace)</code>.
     */
    public void testConstructorWithNamespace() {
        AddActorAction addActorAction = new AddActorAction(actor, manager, namespace);
        assertNotNull("Instance of AddActorAction should be created.", addActorAction);
    }

    /**
     * Test the method <code>getPresentationName()</code>.
     */
    public void testGetPresentationName() {
        assertTrue("The presentation name should be correct.",
            action.getPresentationName().equals("Add Actor"));
    }
}
