/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.stresstests;

import com.topcoder.uml.actions.model.usecase.AddActorAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * Stress test cases for class <code>AddAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class StressTestAddActorAction extends TestCase {
    /**
     * Stress test for method <code> execute() </code>.
     *
     * <p>
     * After a large number of call, the accuracy result should be validated.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddActionExecute() throws Exception {
        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MyNamespaceAbstractImpl();

        for (int i = 0; i < 1000; i++) {
            AddActorAction action = new AddActorAction(new ActorImpl(), manager, namespace);
            action.execute();

            // after execute, one can undo and redo it.
            action.undo();
            action.redo();
        }

        // after running 1000 time, the size of namespace should be accumulated to 1000.
        // now we check the result.
        assertEquals("The size of the owned elements should be 1000.", 1000, namespace.getOwnedElements().size());
    }
}