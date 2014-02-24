/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase;

import com.topcoder.uml.actions.model.usecase.accuracytests.AccuracyTestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import junit.framework.TestCase;

import sun.awt.datatransfer.TransferableProxy;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;


/**
 * Accuracy test for the <code>CopyAction</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AccuracyTestCopyAction extends TestCase {
    /**
     * Test the constructor <code>CopyAction(ModelElement, UsecaseToolUtil, Clipboard)</code>.
     */
    public void testConstructor() {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        CopyAction action = new MockCopyAction(useCase, util, clipboard);
        assertNotNull("Instance of CopyAction should be created.", action);
        assertTrue("The clipboard field should be set.",
            AccuracyTestHelper.getPrivateField(CopyAction.class, action, "clipboard").equals(clipboard));
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(CopyAction.class, action, "usecaseToolUtil").equals(util));
        assertTrue("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(CopyAction.class, action, "modelElement").equals(useCase));

        action = new MockCopyAction(useCase, util, null);
        assertNotNull("Instance of CopyAction should be created.", action);
        assertTrue("The clipboard field should be set.",
            AccuracyTestHelper.getPrivateField(CopyAction.class, action, "clipboard").equals(clipboard));
        assertTrue("The usecaseToolUtil field should be set.",
            AccuracyTestHelper.getPrivateField(CopyAction.class, action, "usecaseToolUtil").equals(util));
        assertTrue("The modelElement field should be set.",
            AccuracyTestHelper.getPrivateField(CopyAction.class, action, "modelElement").equals(useCase));
    }

    /**
     * Test the method <code>execute()</code>.
     */
    public void testExecute() {
        ModelElement useCase = new UseCaseImpl();
        UsecaseToolUtil util = new UseCaseUtil();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        CopyAction action = new MockCopyAction(useCase, util, clipboard);
        action.execute();

        TransferableProxy transferable = (TransferableProxy) clipboard.getContents(null);
        assertTrue("The copied content should be correct.",
            transferable.getTransferDataFlavors()[0].equals(ModelTransfer.USECASE_FLAVOR));
    }

    /**
     * This is a mock implementation of <code>CopyAction</code>, it is only used in test.
     */
    private class MockCopyAction extends CopyAction {
        /**
         * The constructor which simply calls the constructor of super class.
         *
         * @param modelElement passed to super class.
         * @param usecaseToolUtil passed to super class.
         * @param clipboard passed to super class.
         */
        public MockCopyAction(ModelElement modelElement, UsecaseToolUtil usecaseToolUtil, Clipboard clipboard) {
            super(modelElement, usecaseToolUtil, clipboard);
        }
    }
}
