/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractRemoveGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractRemoveGraphElementAction</code> abstract class,
 * and it is responsible for removing the comment graph node from its parent diagram
 * graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is
 * not thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class RemoveCommentGraphNodeAction extends AbstractRemoveGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Remove Comment GraphNode";

    /**
     * <p>
     * Create a new <code>RemoveCommentGraphNodeAction</code> with given commentGraphNode.
     * </p>
     * @param commentGraphNode
     *            the comment graph node.
     * @throws IllegalArgumentException if the argument is null, or its container is null, or
     *          the commentGraphNode doesn't contains a semanticModel attribute
     *          (Uml1SemanticModelBridge object), which in turn should contain a Comment
     *          object as its element attribute.
     */
    public RemoveCommentGraphNodeAction(GraphNode commentGraphNode) {
        super(NAME, commentGraphNode);
        // Validate the commentGraphNode
        Helper.validateGraphNodeForComment(commentGraphNode);
    }
}
