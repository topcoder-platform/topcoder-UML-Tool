/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;


/**
 * Accuracy test for the <code>RemoveAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestRemoveAction extends TestCase {
    /**
     * Test the constructor <code>RemoveAction(ModelElement, UsecaseToolUtil)</code>.
     */
    public void testConstructor() {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();

        RemoveAction action = new MockRemoveAction(useCase, util);
        assertNotNull("Instance of RemoveAction should be created.", action);
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "usecaseToolUtil").equals(util));
        assertTrue("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "modelElement").equals(useCase));
    }

    /**
     * Test the method <code>execute()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testExecute() throws Exception {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        RemoveAction action = new MockRemoveAction(useCase, util);
        action.execute();
        assertFalse("Element should be removed.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * Test the method <code>undo()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testUndo() throws Exception {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        RemoveAction action = new MockRemoveAction(useCase, util);
        action.execute();

        action.undo();
        assertTrue("Element should not be removed.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * Test the method <code>redo()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testRedo() throws Exception {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        RemoveAction action = new MockRemoveAction(useCase, util);
        action.execute();
        action.undo();

        action.redo();
        assertFalse("Element should be removed.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * This is a mock implementation of <code>RemoveAction</code>, it is only used in test.
     */
    private class MockRemoveAction extends RemoveAction {
        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param modelElement passed to super class.
         * @param usecaseToolUtil passed to super class.
         */
        public MockRemoveAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil) {
            super(modelElement, usecaseToolUtil);
        }
    }
}
