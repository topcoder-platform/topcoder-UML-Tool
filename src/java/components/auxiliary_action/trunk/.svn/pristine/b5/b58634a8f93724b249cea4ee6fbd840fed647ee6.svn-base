/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractAddGraphElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class extends the <code>AbstractAddGraphElementAction</code> abstract class,
 * and it is responsible for adding the comment <code>Relationship</code> <code>GraphEdge</code>
 * into the diagram graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is
 * not thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AddCommentRelationshipGraphEdgeAction extends AbstractAddGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Add Comment Relationship GraphEdge";
    /**
     * <p>
     * Create a new <code>AddCommentRelationshipGraphEdgeAction</code> with the given comment graph edge to add,
     * the diagram and the UML model manager.
     * </p>
     * @param commentGraphEdge
     *            the comment graph edge
     * @param diagram
     *            the diagram graph node.
     * @param modelManager
     *            the UMLModelManager object to apply initial formatting.
     * @throws IllegalArgumentException if any argument is null, or
     *          the commentGraphEdge doesn't contains a semanticModel attribute
     *          (SimpleSemanticModelElement object) with its typeInfo attribute equal to
     *          "CommentLink".
     */
    public AddCommentRelationshipGraphEdgeAction(GraphEdge commentGraphEdge, GraphNode diagram,
            UMLModelManager modelManager) {
        super(NAME, commentGraphEdge, diagram, modelManager);
        // Validate the commentGraphNode
        Helper.validateGraphEdgeForCommentRelationship(commentGraphEdge);
    }
}
