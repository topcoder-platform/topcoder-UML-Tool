/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractPasteGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractPasteGraphElementAction</code> abstract class,
 * and it is responsible for pasting the <code>Comment</code> <code>Relationship</code>
 * <code>GraphEdge</code> into the diagram graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base
 * class is not thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class PasteCommentRelationshipGraphEdgeAction extends AbstractPasteGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Paste Comment Relationship GraphEdge";
    /**
     * <p>
     * Create a new <code>PasteCommentRelationshipGraphEdgeAction</code> with given content
     * and diagram.
     * </p>
     * @param content
     *            the comment graph edge to paste.
     * @param diagram
     *            the diagram graph node.
     * @throws IllegalArgumentException if any argument is null, or
     *          the content is not a GraphEdge object, or it doesn't contains a
     *          semanticModel attribute (SimpleSemanticModelElement object) with its
     *          typeInfo attribute equal to "CommentLink".
     */
    public PasteCommentRelationshipGraphEdgeAction(Object content, GraphNode diagram) {
        super(NAME, content, diagram);
        if (!(content instanceof GraphEdge)) {
            throw new IllegalArgumentException("content should be instance of GraphEdge!");
        }
        // Validate the content
        Helper.validateGraphEdgeForCommentRelationship((GraphEdge) content);
    }
}
