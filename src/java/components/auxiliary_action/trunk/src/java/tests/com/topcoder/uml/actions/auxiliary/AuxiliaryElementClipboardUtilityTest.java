/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>AuxiliaryElementClipboardUtility</code>.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AuxiliaryElementClipboardUtilityTest extends TestCase {
    /**
     * <p>
     * Test method
     * <code>copyComment(Comment comment, Clipboard clipboard)</code> for
     * failure with null comment, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws ActionExecutionException
     *             to JUnit
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCopyComment_NullComment() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            AuxiliaryElementClipboardUtility.copyComment(null, new Clipboard("Test"));
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>copyComment(Comment comment, Clipboard clipboard)</code> for
     * accuracy.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCopyComment_Accuracy() throws Exception {
        Comment comment = new CommentImpl();
        comment.setBody("Text");
        Clipboard clipboard = new Clipboard("Test");
        AuxiliaryElementClipboardUtility.copyComment(comment, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT);
        assertTrue("Failed to copy!", obj instanceof Comment);
        UnitTestHelper.assertEquals(comment, (Comment) obj, "Failed to clone!");
    }

    /**
     * <p>
     * Test method
     * <code>copyNoteRelationship(Comment comment, Clipboard clipboard)</code>
     * for failure with null comment, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws ActionExecutionException
     *             to JUnit
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCopyNoteRelationship_NullComment()
        throws AuxiliaryElementCloneException,ActionExecutionException {
        try {
            AuxiliaryElementClipboardUtility.copyNoteRelationship(null, new Clipboard("Test"));
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>copyNoteRelationship(Comment comment, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCopyNoteRelationship_Accuracy() throws Exception {
        Comment comment = new CommentImpl();
        comment.setBody("Text");
        Clipboard clipboard = new Clipboard("Test");
        AuxiliaryElementClipboardUtility.copyNoteRelationship(comment, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
        assertTrue("Failed to copy!", obj instanceof Comment);
        UnitTestHelper.assertEquals(comment, (Comment) obj, "Failed to clone!");
    }

    /**
     * <p>
     * Test method
     * <code>copyCommentGraphNode(GraphNode node, Clipboard clipboard)</code>
     * for failure with null node, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws ActionExecutionException
     *             to JUnit
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCopyCommentGraphNode_NullNode() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            AuxiliaryElementClipboardUtility.copyCommentGraphNode(null, new Clipboard("Test"));
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>copyCommentGraphNode(GraphNode node, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCopyCommentGraphNode_Accuracy() throws Exception {
        GraphNode commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        commentGraphNode.setSemanticModel(usmb);
        Clipboard clipboard = new Clipboard("Test");
        AuxiliaryElementClipboardUtility.copyCommentGraphNode(commentGraphNode, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
        assertTrue("Failed to copy!", obj instanceof GraphNode);
        UnitTestHelper.assertEquals(commentGraphNode, (GraphNode) obj, "Failed to clone!");
    }

    /**
     * <p>
     * Test method
     * <code>copyCommentRelationshipGraphEdge(GraphEdge edge, Clipboard clipboard)</code>
     * for failure with null edge, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws ActionExecutionException
     *             to JUnit
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCopyCommentRelationshipGraphEdge_NullEdge() throws AuxiliaryElementCloneException,
            ActionExecutionException {
        try {
            AuxiliaryElementClipboardUtility.copyCommentRelationshipGraphEdge(null, new Clipboard("Test"));
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>copyCommentRelationshipGraphEdge(GraphEdge edge, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCopyCommentRelationshipGraphEdge_Accuracy() throws Exception {
        GraphEdge commentGraphEdge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        commentGraphEdge.setSemanticModel(ssme);
        Clipboard clipboard = new Clipboard("Test");
        AuxiliaryElementClipboardUtility.copyCommentRelationshipGraphEdge(commentGraphEdge, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
        assertTrue("Failed to copy!", obj instanceof GraphEdge);
        UnitTestHelper.assertEquals(commentGraphEdge, (GraphEdge) obj, "Failed to clone!");
    }

    /**
     * <p>
     * Test method
     * <code>copyFreeTextGraphNode(GraphNode node, Clipboard clipboard)</code>
     * for failure with null node, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws ActionExecutionException
     *             to JUnit
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCopyFreeTextGraphNode_NullNode() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            AuxiliaryElementClipboardUtility.copyFreeTextGraphNode(null, new Clipboard("Test"));
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>copyFreeTextGraphNode(GraphNode node, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCopyFreeTextGraphNode_Accuracy() throws Exception {
        GraphNode freeTextGraphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        freeTextGraphNode.setSemanticModel(ssme);
        freeTextGraphNode.addContained(new TextElement());
        Clipboard clipboard = new Clipboard("Test");
        AuxiliaryElementClipboardUtility.copyFreeTextGraphNode(freeTextGraphNode, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.FREE_TEXT);
        assertTrue("Failed to copy!", obj instanceof GraphNode);
        UnitTestHelper.assertEquals(freeTextGraphNode, (GraphNode) obj, "Failed to clone!");
    }

    /**
     * <p>
     * Test method
     * <code>copyPolylineGraphEdge(GraphEdge edge, Clipboard clipboard)</code>
     * for failure with null edge, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     *
     * @throws ActionExecutionException
     *             to JUnit
     * @throws AuxiliaryElementCloneException
     *             to JUnit
     */
    public void testCopyPolylineGraphEdge_NullEdge() throws AuxiliaryElementCloneException, ActionExecutionException {
        try {
            AuxiliaryElementClipboardUtility.copyPolylineGraphEdge(null, new Clipboard("Test"));
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method
     * <code>copyPolylineGraphEdge(GraphEdge edge, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCopyPolylineGraphEdge_Accuracy() throws Exception {
        GraphEdge polylineGraphEdge = new GraphEdge();
        polylineGraphEdge.addContained(new Polyline());
        Clipboard clipboard = new Clipboard("Test");
        AuxiliaryElementClipboardUtility.copyPolylineGraphEdge(polylineGraphEdge, clipboard);
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.POLYLINE);
        assertTrue("Failed to copy!", obj instanceof GraphEdge);
        UnitTestHelper.assertEquals(polylineGraphEdge, (GraphEdge) obj, "Failed to clone!");
    }
}
