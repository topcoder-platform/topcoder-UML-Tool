/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.stresstests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.AddActorAction;
import com.topcoder.uml.actions.model.usecase.CutActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Stress test case for class <code>CutAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class StressTestCutAction extends TestCase {

    /**
     * Stress test case for method <code> execute </code>.
     *
     * @throws Exception
     *             to junit.
     */
    public void testCopyActionExecute() throws Exception {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MyNamespaceAbstractImpl();

        Actor actor = new ActorImpl();

        for (int i = 0; i < 100; i++) {
            // first we have to add model to namespace.
            AddActorAction addAction = new AddActorAction(actor, manager, namespace);
            addAction.execute();

            actor.setNamespace(namespace);

            CutActorAction cutAction = new CutActorAction(actor, clipboard);

            // we can perform cut action now.
            cutAction.execute();

            // we can also perform redo and undo action.
            cutAction.redo();
            cutAction.undo();
        }
    }
}