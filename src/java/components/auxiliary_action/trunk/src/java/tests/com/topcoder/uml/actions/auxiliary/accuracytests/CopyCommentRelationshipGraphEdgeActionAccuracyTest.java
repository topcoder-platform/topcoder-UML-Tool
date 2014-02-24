/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentRelationshipGraphEdgeAction;

/**
 * <p>
 * Set of accuracy tests for CopyCommentRelationshipGraphEdgeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyCommentRelationshipGraphEdgeActionAccuracyTest extends TestCase {

    /**
     * Instance of GraphNode for testing.
     */
    private GraphEdge commentRelationshipGraphEdge;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CopyCommentRelationshipGraphEdgeAction for testing.
     */
    private CopyCommentRelationshipGraphEdgeAction copyCommentRelationshipGraphEdgeAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        commentRelationshipGraphEdge = AccuracyTestsHelper.getCommentRelationshipGraphEdge();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        copyCommentRelationshipGraphEdgeAction =
            new CopyCommentRelationshipGraphEdgeAction(commentRelationshipGraphEdge, clipboard);
    }

    /**
     * Constructor under test CopyCommentRelationshipGraphEdgeAction(GraphNode,
     * Clipboard). Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyCommentRelationshipGraphEdgeAction() throws Exception {
        CopyCommentRelationshipGraphEdgeAction currentCopyCommentRelationshipGraphEdgeAction =
            new CopyCommentRelationshipGraphEdgeAction(commentRelationshipGraphEdge, clipboard);
        assertSame("nodes must be the same", commentRelationshipGraphEdge, AccuracyTestsHelper.getFieldValue(
            currentCopyCommentRelationshipGraphEdgeAction, "commentGraphEdge"));
        assertSame("clipboads must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCopyCommentRelationshipGraphEdgeAction, "clipboard"));
    }

    /**
     * Method under test CopyCommentRelationshipGraphEdgeAction.execute().
     * Accuracy testing of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        copyCommentRelationshipGraphEdgeAction.execute();
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
        assertTrue("comment relationship graph edge was not successfully copied", object instanceof GraphEdge);
        assertFalse("copied comment relationship graph edge was not cloned",
            ((GraphEdge) object) == commentRelationshipGraphEdge);
    }
}