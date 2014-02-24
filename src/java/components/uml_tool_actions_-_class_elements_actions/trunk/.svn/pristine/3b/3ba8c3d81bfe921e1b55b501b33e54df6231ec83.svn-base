/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.MockAbstractionUtil;
import com.topcoder.uml.actions.model.classifiers.MockCopyAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

/**
 * Accuracy tests for CopyAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyActionTest extends TestCase {
    /**
     * Load logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();
    }

    /**
     * Unload logging configuration.
     * 
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * The ModelElement instance for test.
     */
    private ModelElement modelElement = new AbstractionImpl();

    /**
     * The ClassToolUtil instance for test.
     */
    private MockAbstractionUtil classToolUtil = new MockAbstractionUtil();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = TestUtil.CLIPBORAD;

    /**
     * Test CopyAction#CopyAction(ModelElement, ClassToolUtil, Clipboard)
     */
    public void testCopyAction() {
        new MockCopyAction(modelElement, classToolUtil, clipboard);
    }

    /**
     * Test CopyAction#execute.
     * 
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testExecute() throws Exception {
        modelElement.setName("TC");

        MockCopyAction copyAction = new MockCopyAction(modelElement,
                classToolUtil, clipboard);
        copyAction.execute();

        Object transferData = clipboard.getContents(new Object())
                .getTransferData(ClassElementsTransfer.ABSTRACTION_FLAVOR);

        ModelElement newElement = (ModelElement) transferData;

        assertEquals("Name is incorrect.", modelElement.getName(), newElement
                .getName());
    }
}