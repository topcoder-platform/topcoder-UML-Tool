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

import sun.awt.datatransfer.TransferableProxy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>CutAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCutAction extends TestCase {
    /**
     * Test the constructor <code>CutAction(ModelElement, UsecaseToolUtil, Clipboard)</code>.
     */
    public void testConstructor() {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        CutAction action = new MockCutAction(useCase, util, clipboard);
        assertNotNull("Instance of CutAction should be created.", action);
        assertTrue("The clipboard field should be set.",
            AccuracyTestHelper.getPrivateField(CutAction.class, action, "clipboard").equals(clipboard));
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "usecaseToolUtil").equals(util));
        assertTrue("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(UsecaseUndoableAction.class, action, "modelElement").equals(useCase));

        action = new MockCutAction(useCase, util, null);
        assertNotNull("Instance of CutAction should be created.", action);
        assertTrue("The clipboard field should be set.",
            AccuracyTestHelper.getPrivateField(CutAction.class, action, "clipboard").equals(clipboard));
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
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        CutAction action = new MockCutAction(useCase, util, clipboard);
        action.execute();

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.USECASE_FLAVOR));
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
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        CutAction action = new MockCutAction(useCase, util, clipboard);
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
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Namespace namespace = new MockNamespaceImpl();
        util.addElementToModel(useCase, namespace);

        CutAction action = new MockCutAction(useCase, util, clipboard);
        action.execute();
        action.undo();

        action.redo();

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.USECASE_FLAVOR));
        assertFalse("Element should be removed.", namespace.getOwnedElements().contains(useCase));
    }

    /**
     * This is a mock implementation of <code>CutAction</code>, it is only used in test.
     */
    private class MockCutAction extends CutAction {
        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param modelElement passed to super class.
         * @param usecaseToolUtil passed to super class.
         * @param clipboard passed to super class.
         */
        public MockCutAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, Clipboard clipboard) {
            super(modelElement, usecaseToolUtil, clipboard);
        }
    }
}
