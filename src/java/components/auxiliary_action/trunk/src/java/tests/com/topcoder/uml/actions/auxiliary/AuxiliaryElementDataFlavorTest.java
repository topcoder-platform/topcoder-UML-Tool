/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
/**
 * <p>
 * Unit tests on class <code>AuxiliaryElementDataFlavor</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AuxiliaryElementDataFlavorTest extends TestCase {
    /**
     * <p>
     * Tests static constant <code>COMMENT</code> for accuracy.
     * </p>
     */
    public void testComment() {
        assertEquals("Incorrect class.", Comment.class,
                AuxiliaryElementDataFlavor.COMMENT.getRepresentationClass());
        assertEquals("Incorrect name.", "Comment",
                AuxiliaryElementDataFlavor.COMMENT.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests static constant <code>NOTE_RELATIONSHIP</code> for accuracy.
     * </p>
     */
    public void testNoteRelationship() {
        assertEquals("Incorrect class.", Comment.class,
                AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP.getRepresentationClass());
        assertEquals("Incorrect name.", "NoteRelationship",
                AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests static constant <code>COMMENT_GRAPH_NODE</code> for accuracy.
     * </p>
     */
    public void testCommentGraphNode() {
        assertEquals("Incorrect class.", GraphNode.class,
                AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE.getRepresentationClass());
        assertEquals("Incorrect name.", "CommentGraphNode",
                AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests static constant <code>COMMENT_RELATIONSHIP_GRAPH_EDGE</code> for accuracy.
     * </p>
     */
    public void testCommentRelationshipGraphEdge() {
        assertEquals("Incorrect class.", GraphEdge.class,
                AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE.getRepresentationClass());
        assertEquals("Incorrect name.", "CommentRelationshipGraphEdge",
                AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests static constant <code>FREE_TEXT</code> for accuracy.
     * </p>
     */
    public void testFreeText() {
        assertEquals("Incorrect class.", GraphNode.class,
                AuxiliaryElementDataFlavor.FREE_TEXT.getRepresentationClass());
        assertEquals("Incorrect name.", "FreeText",
                AuxiliaryElementDataFlavor.FREE_TEXT.getHumanPresentableName());
    }

    /**
     * <p>
     * Tests static constant <code>POLYLINE</code> for accuracy.
     * </p>
     */
    public void testPolyline() {
        assertEquals("Incorrect class.", GraphEdge.class,
                AuxiliaryElementDataFlavor.POLYLINE.getRepresentationClass());
        assertEquals("Incorrect name.", "Polyline",
                AuxiliaryElementDataFlavor.POLYLINE.getHumanPresentableName());
    }


}
