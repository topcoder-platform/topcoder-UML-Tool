/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementClipboardUtility;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for AuxiliaryElementClipboardUtility class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AuxiliaryElementClipboardUtilityAccuracyTest extends TestCase {

    /**
     * Instance of Clipboard for testing.
     */
    private final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Method under test AuxiliaryElementClipboardUtility.copyComment().
     * Accuracy testing of correctly copied comment.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyComment() throws Exception {
        Comment comment = new CommentImpl();
        AuxiliaryElementClipboardUtility.copyComment(comment, clipboard);
        // getting copied comment
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT);
        assertTrue("comment was not successfully copied", object instanceof Comment);
        assertFalse("copied comment was not cloned", ((Comment) object) == comment);
    }

    /**
     * Method under test
     * AuxiliaryElementClipboardUtility.copyNoteRelationship(). Accuracy testing
     * of correctly copied note relationship.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyNoteRelationship() throws Exception {
        Comment comment = new CommentImpl();
        AuxiliaryElementClipboardUtility.copyNoteRelationship(comment, clipboard);
        // getting copied note relationship
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
        assertTrue("note relationship was not successfully copied", object instanceof Comment);
        assertFalse("copied note relationship was not cloned", ((Comment) object) == comment);
    }

    /**
     * Method under test
     * AuxiliaryElementClipboardUtility.copyCommentGraphNode(). Accuracy testing
     * of correctly copied comment graph node.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyCommentGraphNode() throws Exception {
        GraphNode graphNode = AccuracyTestsHelper.getCommentGraphNode();
        AuxiliaryElementClipboardUtility.copyCommentGraphNode(graphNode, clipboard);
        // getting copied comment graph node
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
        assertTrue("comment graph node was not successfully copied", object instanceof GraphNode);
        assertFalse("copied comment graph node was not cloned", ((GraphNode) object) == graphNode);
    }

    /**
     * Method under test
     * AuxiliaryElementClipboardUtility.copyCommentRelationshipGraphEdge().
     * Accuracy testing of correctly copied comment relationship graph edge.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyCommentRelationshipGraphEdge() throws Exception {
        GraphEdge graphEdge = AccuracyTestsHelper.getCommentRelationshipGraphEdge();
        AuxiliaryElementClipboardUtility.copyCommentRelationshipGraphEdge(graphEdge, clipboard);
        // getting copied comment relationship graph edge
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
        assertTrue("comment relationship graph edge was not successfully copied", object instanceof GraphEdge);
        assertFalse("copied comment relationship graph edge was not cloned", ((GraphEdge) object) == graphEdge);
    }

    /**
     * Method under test
     * AuxiliaryElementClipboardUtility.copyFreeTextGraphNode(). Accuracy
     * testing of correctly copied free text graph node.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyFreeTextGraphNode() throws Exception {
        GraphNode graphNode = AccuracyTestsHelper.getFreeTextGraphNode();
        AuxiliaryElementClipboardUtility.copyFreeTextGraphNode(graphNode, clipboard);
        // getting copied free text graph node
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.FREE_TEXT);
        assertTrue("free text graph node was not successfully copied", object instanceof GraphNode);
        assertFalse("copied free text graph node was not cloned", ((GraphNode) object) == graphNode);
    }

    /**
     * Method under test
     * AuxiliaryElementClipboardUtility.copyPolylineGraphEdge(). Accuracy
     * testing of correctly copied polyline graph edge.
     * @throws Exception wraps all exceptions
     */
    public final void testCopyPolylineGraphEdge() throws Exception {
        GraphEdge graphEdge = AccuracyTestsHelper.getPolylineGraphEdge();
        AuxiliaryElementClipboardUtility.copyPolylineGraphEdge(graphEdge, clipboard);
        // getting copied polyline graph edge
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.POLYLINE);
        assertTrue("polyline graph edge was not successfully copied", object instanceof GraphEdge);
        assertFalse("copied polyline graph edge was not cloned", ((GraphEdge) object) == graphEdge);
    }
}