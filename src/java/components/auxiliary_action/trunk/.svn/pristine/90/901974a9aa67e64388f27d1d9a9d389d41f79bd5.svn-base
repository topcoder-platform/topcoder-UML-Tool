/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.diagram.CopyFreeTextAction;

/**
 * <p>
 * Set of accuracy tests for CopyFreeTextAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyFreeTextActionAccuracyTest extends TestCase {

    /**
     * Instance of GraphNode for testing.
     */
    private GraphNode freeTextGraphNode;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CopyFreeTextAction for testing.
     */
    private CopyFreeTextAction copyFreeTextAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        freeTextGraphNode = AccuracyTestsHelper.getFreeTextGraphNode();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyFreeTextAction = new CopyFreeTextAction(freeTextGraphNode, clipboard);
    }

    /**
     * Constructor under test CopyFreeTextAction(GraphNode, Clipboard). Accuracy
     * testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyFreeTextAction() throws Exception {
        CopyFreeTextAction currentCopyFreeTextAction = new CopyFreeTextAction(freeTextGraphNode, clipboard);
        assertSame("nodes must be the same", freeTextGraphNode, AccuracyTestsHelper.getFieldValue(
            currentCopyFreeTextAction, "freeTextGraphNode"));
        assertSame("clipboads must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCopyFreeTextAction, "clipboard"));
    }

    /**
     * Method under test CopyFreeTextAction.execute(). Accuracy testing of
     * correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        copyFreeTextAction.execute();
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.FREE_TEXT);
        assertTrue("free text graph node was not successfully copied", object instanceof GraphNode);
        assertFalse("copied free text graph node was not cloned", ((GraphNode) object) == freeTextGraphNode);
    }
}