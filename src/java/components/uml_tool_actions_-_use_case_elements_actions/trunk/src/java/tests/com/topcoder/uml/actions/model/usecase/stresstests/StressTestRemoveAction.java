/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.stresstests;

import com.topcoder.uml.actions.model.usecase.AddActorAction;
import com.topcoder.uml.actions.model.usecase.RemoveActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Stress test case for class <code>RemoveAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class StressTestRemoveAction extends TestCase {

    /**
     * Stress test case for method <code>execute() </code>.
     *
     * @throws Exception to juunit.
     *
     */
    public void testRemoveActionExecute() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MyNamespaceAbstractImpl();

        Actor actor = new ActorImpl();

        for (int i = 0; i < 100; i++) {
            // first we have to add model to namespace.
            AddActorAction addAction = new AddActorAction(actor, manager, namespace);
            addAction.execute();

            actor.setNamespace(namespace);

            // after add the model to namespace, we then perform remove action.
            RemoveActorAction action = new RemoveActorAction(actor);

            action.execute(); // the remove action should be succesfully executed.

            // we can also undo and redo this procedure.
            action.undo();
            action.redo();
        }
    }
}
