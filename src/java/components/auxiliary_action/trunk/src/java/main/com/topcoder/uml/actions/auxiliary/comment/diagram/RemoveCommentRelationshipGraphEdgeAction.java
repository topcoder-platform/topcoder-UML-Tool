/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.AbstractRemoveGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractRemoveGraphElementAction</code> abstract class,
 * and it is responsible for removing the comment relationship graph edge from its
 * parent diagram graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its
 * base class is not thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class RemoveCommentRelationshipGraphEdgeAction extends AbstractRemoveGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Remove Comment Relationship GraphEdge";
    /**
     * <p>
     * Create a new <code>RemoveCommentRelationshipGraphEdgeAction</code> with given commentGraphEdge.
     * </p>
     * @param commentGraphEdge
     *            the comment graph edge to remove.
     * @throws IllegalArgumentException if the argument is null, or its container is null, or
     *          the commentGraphEdge doesn't contains a semanticModel attribute
     *          (SimpleSemanticModelElement object) with its typeInfo attribute equal to
     *          "CommentLink".
     */
    public RemoveCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge) {
        super(NAME, commentGraphEdge);
        // Validate the commentGraphEdge
        Helper.validateGraphEdgeForCommentRelationship(commentGraphEdge);
    }
}
