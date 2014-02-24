/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.actions.model.usecase.accuracytests.MockNamespaceImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


/**
 * Accuracy test for the <code>PasteAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestPasteAction extends TestCase {
    /**
     * Test the constructor <code>PasteAction(Transferable, DataFlavor, UsecaseToolUtil, Namespace)</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testConstructor() throws Exception {
        UseCaseImpl useCase = new UseCaseImpl();
        Transferable transferable = new ModelTransfer(useCase);
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();

        PasteAction action = new MockPasteAction(transferable, ModelTransfer.USECASE_FLAVOR, util, namespace);
        assertNotNull("Instance of AddAction should be created.", action);
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "usecaseToolUtil").equals(util));
        assertNotNull("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "modelElement"));
        assertTrue("The namespace field should be set.",
            AccuracyTestHelper.getPrivateField(PasteAction.class, action, "namespace").equals(namespace));
    }

    /**
     * Test the method <code>execute()</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testExecute() throws Exception {
        UseCaseImpl useCase = new UseCaseImpl();
        Transferable transferable = new ModelTransfer(useCase);
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();
        PasteAction action = new MockPasteAction(transferable, ModelTransfer.USECASE_FLAVOR, util, namespace);

        action.execute();
        assertTrue("Element should be added.", namespace.getOwnedElements().contains(useCase));
        assertTrue("Namespace should be set.", useCase.getNamespace().equals(namespace));
    }

    /**
     * Test the method <code>undo</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testUndo() throws Exception {
        UseCaseImpl useCase = new UseCaseImpl();
        Transferable transferable = new ModelTransfer(useCase);
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();
        PasteAction action = new MockPasteAction(transferable, ModelTransfer.USECASE_FLAVOR, util, namespace);
        action.execute();

        action.undo();
        assertFalse("Element should not be added.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * Test the method <code>redo</code>.
     *
     * @throws Exception throws to JUnit
     */
    public void testRedo() throws Exception {
        UseCaseImpl useCase = new UseCaseImpl();
        Transferable transferable = new ModelTransfer(useCase);
        UsecaseToolUtil util = new UseCaseUtil();
        Namespace namespace = new MockNamespaceImpl();
        PasteAction action = new MockPasteAction(transferable, ModelTransfer.USECASE_FLAVOR, util, namespace);
        action.execute();
        action.undo();

        action.redo();
        assertTrue("Element should be added.", namespace.getOwnedElements().contains(useCase));
        assertTrue("Namespace should be set.", useCase.getNamespace().equals(namespace));
    }

    /**
     * This is a mock implementation of <code>PasteAction</code>, it is only used in test.
     */
    private class MockPasteAction extends PasteAction {
        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param transferable passed to super class.
         * @param dataFlavor passed to super class.
         * @param usecaseToolUtil passed to super class.
         * @param namespace passed to super class.
         *
         * @throws InvalidDataContentException if fails to load ModelElement from Transferable
         */
        protected MockPasteAction(Transferable transferable, DataFlavor dataFlavor, UsecaseToolUtil usecaseToolUtil,
            Namespace namespace) throws InvalidDataContentException {
            super(transferable, dataFlavor, usecaseToolUtil, namespace);
        }
    }
}
