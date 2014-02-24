/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.stresstests;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.model.usecase.ModelTransfer;
import com.topcoder.uml.actions.model.usecase.PasteActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.TestCase;

/**
 * Stress test case for class <code>PasteAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class StressTestPasteAction extends TestCase {

    /**
     * Stress test case for method <code>execute() </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testPasteActionExecute() throws Exception {

        Transferable transferable = new ModelTransfer(new ActorImpl());
        Namespace namespace = new MyNamespaceAbstractImpl();

        for (int i = 0; i < 100; i++) {
            PasteActorAction action = new PasteActorAction(transferable, namespace);

            // invoke execute method for paste.
            action.execute();

            // after execute we can undo and redo it.
            action.undo();
            action.redo();
        }
    }
}