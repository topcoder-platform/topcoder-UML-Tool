/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentGraphNodeAction;

/**
 * <p>
 * Set of accuracy tests for CopyCommentGraphNodeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyCommentGraphNodeActionAccuracyTest extends TestCase {

    /**
     * Instance of GraphNode for testing.
     */
    private GraphNode commentGraphNode;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CopyCommentGraphNodeAction for testing.
     */
    private CopyCommentGraphNodeAction copyCommentGraphNodeAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        commentGraphNode = AccuracyTestsHelper.getCommentGraphNode();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyCommentGraphNodeAction = new CopyCommentGraphNodeAction(commentGraphNode, clipboard);
    }

    /**
     * Constructor under test CopyCommentGraphNodeAction(GraphNode, Clipboard).
     * Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyCommentGraphNodeAction() throws Exception {
        CopyCommentGraphNodeAction currentCopyCommentGraphNodeAction =
            new CopyCommentGraphNodeAction(commentGraphNode, clipboard);
        assertSame("nodes must be the same", commentGraphNode, AccuracyTestsHelper.getFieldValue(
            currentCopyCommentGraphNodeAction, "commentGraphNode"));
        assertSame("clipboads must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCopyCommentGraphNodeAction, "clipboard"));
    }

    /**
     * Method under test CopyCommentGraphNodeAction.execute(). Accuracy testing
     * of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        copyCommentGraphNodeAction.execute();
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
        assertTrue("comment graph node was not successfully copied", object instanceof GraphNode);
        assertFalse("copied comment graph node was not cloned", ((GraphNode) object) == commentGraphNode);
    }
}