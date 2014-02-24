/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;


/**
 * Accuracy test for the <code>AddAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestAddAction extends TestCase {
    /**
     * Test the constructor <code>AddAction(ModelElement, UsecaseToolUtil, UMLModelManager, Namespace)</code>.
     */
    public void testConstructor() {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MockNamespaceImpl();

        AddAction action = new MockAddAction(useCase, util, manager, namespace);
        assertNotNull("Instance of AddAction should be created.", action);
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "usecaseToolUtil").equals(util));
        assertTrue("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "modelElement").equals(useCase));
        assertTrue("The manager field should be set.",
            AccuracyTestHelper.getPrivateField(AddAction.class, action, "manager").equals(manager));
        assertTrue("The namespace field should be set.",
            AccuracyTestHelper.getPrivateField(AddAction.class, action, "namespace").equals(namespace));
    }

    /**
     * Test the method <code>execute()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testExecute() throws Exception {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MockNamespaceImpl();
        AddAction action = new MockAddAction(useCase, util, manager, namespace);

        action.execute();
        assertTrue("Element should be added.", namespace.getOwnedElements().contains(useCase));
        assertTrue("Namespace should be set.", useCase.getNamespace().equals(namespace));
    }

    /**
     * Test the method <code>undo()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testUndo() throws Exception {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MockNamespaceImpl();
        AddAction action = new MockAddAction(useCase, util, manager, namespace);
        action.execute();

        action.undo();
        assertFalse("Element should not be added.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * Test the method <code>redo()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testRedo() throws Exception {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        UMLModelManager manager = new UMLModelManager();
        Namespace namespace = new MockNamespaceImpl();
        AddAction action = new MockAddAction(useCase, util, manager, namespace);
        action.execute();
        action.undo();

        action.redo();
        assertTrue("Element should be added.", namespace.getOwnedElements().contains(useCase));
        assertTrue("Namespace should be set.", useCase.getNamespace().equals(namespace));
    }

    /**
     * This is a mock implementation of <code>RemoveAction</code>, it is only used in test.
     */
    private class MockAddAction extends AddAction {
        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param modelElement passed to super class.
         * @param usecaseToolUtil passed to super class.
         * @param manager passed to super class.
         * @param namespace passed to super class.
         */
        public MockAddAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, UMLModelManager manager,
            Namespace namespace) {
            super(modelElement, usecaseToolUtil, manager, namespace);
        }
    }
}
