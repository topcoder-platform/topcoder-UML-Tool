/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;

/**
 * <p>
 * This helper class provides several utility methods
 * for action implementations defined in package <code>com.topcoder.uml.actions.auxiliary.comment.diagram</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
class Helper {
    /**
     * <p>
     * Constant for text "CommentLink".
     * </p>
     */
    private static final String COMMENT_LINK = "CommentLink";
    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    private Helper() {
    }
    /**
     * <p>
     * Validate if the commentGraphNode is valid for actions that relates to
     * Comment graph nodes.
     * </p>
     * @param commentGraphNode the commentGraphNode to validate.
     * @throws IllegalArgumentException if any argument is null, or
     *          the commentGraphNode doesn't contains a semanticModel attribute
     *          (Uml1SemanticModelBridge object), which in turn should contain a Comment
     *          object as its element attribute.
     */
    static void validateGraphNodeForComment(GraphNode commentGraphNode) {
        if (commentGraphNode == null) {
            throw new IllegalArgumentException("commentGraphNode cannot be null!");
        }
        // Validate the SemanticModel
        SemanticModelBridge smb = commentGraphNode.getSemanticModel();
        if (!(smb instanceof Uml1SemanticModelBridge)) {
            throw new IllegalArgumentException(
                    "SemanticModel of the commentGraphNode should be Uml1SemanticModelBridge!");
        }
        Uml1SemanticModelBridge usmb = (Uml1SemanticModelBridge) smb;
        // Validate if the Uml1SemanticModelBridge contains a Comment as its element attribute.
        if (usmb.getElement() == null || !(usmb.getElement() instanceof Comment)) {
            throw new IllegalArgumentException(
                    "The Uml1SemanticModelBridge of the commentGraphNode should contain a Comment as its element!");
        }
    }

    /**
     * <p>
     * Validate if the commentGraphEdge is valid for actions that relates to
     * Comment Relationship graph nodes.
     * </p>
     * @param commentGraphEdge the commentGraphEdge to validate.
     * @throws IllegalArgumentException if any argument is null, or
     *          the commentGraphEdge doesn't contains a semanticModel attribute
     *          (SimpleSemanticModelElement object) with its typeInfo attribute equal to
     *          "CommentLink".
     */
    static void validateGraphEdgeForCommentRelationship(GraphEdge commentGraphEdge) {
        if (commentGraphEdge == null) {
            throw new IllegalArgumentException("commentGraphEdge cannot be null!");
        }
        // Validate the SemanticModel
        SemanticModelBridge smb = commentGraphEdge.getSemanticModel();
        if (!(smb instanceof SimpleSemanticModelElement)) {
            throw new IllegalArgumentException(
                    "SemanticModel of the commentGraphEdge should be SimpleSemanticModelElement!");
        }
        SimpleSemanticModelElement ssme = (SimpleSemanticModelElement) smb;
        if (!COMMENT_LINK.equals(ssme.getTypeInfo())) {
            throw new IllegalArgumentException("typeInfo of commentGraphEdge's SemanticModel should be '"
                    + COMMENT_LINK + "'!");
        }
    }
}
