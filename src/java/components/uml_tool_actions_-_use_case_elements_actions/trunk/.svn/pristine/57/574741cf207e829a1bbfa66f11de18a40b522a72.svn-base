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

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;


/**
 * The demo of this component.This demo will be provided just for Actor actions.  Working with all other model elements
 * are practically the same. This component can not have  own scenario of running it used by the other component which
 * define its behavior. It just  simple example when user at first add component actor, then press undo, then press
 * redo,  then copy it and paste into new namespace. Now it has two actors  ? he delete actor from namespace and then
 * cut and paste into namespace actor from model (actually default namespace).
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /** The Actor instance for testing. */
    private Actor actor;

    /** The Clipboard instance for testing. */
    private Clipboard clipboard;

    /** The UMLModelManager instance for testing. */
    private UMLModelManager manager;

    /** The Namespace instance for testing. */
    private Namespace namespace;

    /** The Transferable instance for testing. */
    private Transferable transferable;

    /**
     * Set up the initial values.
     */
    public void setUp() {
        actor = new ActorImpl();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        manager = new UMLModelManager();
        namespace = new MockNamespaceAbstractImpl();
        transferable = new ModelTransfer(actor);
    }

    /**
     * The demo for Actor actions.
     *
     * @throws Exception to junit.
     */
    public void testActorDemo() throws Exception {
        //let’s create first add action without namespace
        AddActorAction addActor = new AddActorAction(actor, manager);
        //Note that it was just creation and actor don’t added to model
        addActor.execute();
        //After execution actor was add to model
        //Now we can use undo and redo actions
        addActor.undo();
        //As a result actor was deleted from model
        addActor.redo();

        //As a result actor was added to model again
        //Now let copy actor to namespace, for this target we should create copy action and execute it.
        CopyActorAction copyActor = new CopyActorAction(actor);
        copyActor.execute();

        /**
         * Now actor is in clipboard and we need to paste it in needed namespace.  Paste action has such requirement
         * that it can’t get actor from clipboard directly.  It just get Transferable instance and only than put actor
         * to model (it wait for some  action from graphical part). For now image that user click paste and we get
         * transferable  from clipboard Component may define which paste action should be created by using methods of
         * transferable
         */
        Transferable trans = clipboard.getContents(null);

        if (trans.isDataFlavorSupported(ModelTransfer.ACTOR_FLAVOR)) {
            PasteActorAction pasteActor = new PasteActorAction(transferable, namespace);
            pasteActor.execute();
        } else {
            throw new Exception();
        }

        /**
         * for now we actually create second actor let it be ? actor. Component may just receive  it for making some
         * action. It doesn’t have reference to it Then let provide deleting cutting and pasting actor as was mentioned
         * in scenario. Note  now we have two actors
         */
        RemoveActorAction removeActor = new RemoveActorAction(actor);
        removeActor.execute();

        //paste the actor
        PasteActorAction pasteActor = new PasteActorAction(transferable, namespace);
        pasteActor.execute();

        //we just deletes actor.
        CutActorAction cutActor = new CutActorAction(actor);
        cutActor.execute();
    }

    /**
     * Returns the test suite of this test case.
     *
     * @return the test suite of this test case.
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }
}
