/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractAddGraphElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class extends the <code>AbstractAddGraphElementAction</code> abstract class,
 * and it is responsible for adding the comment graph node into the diagram graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not
 * thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AddCommentGraphNodeAction extends AbstractAddGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Add Comment GraphNode";
    /**
     * <p>
     * Create a new <code>AddCommentGraphNodeAction</code> with the given comment graph element to add,
     * the diagram and the UML model manager.
     * </p>
     * @param commentGraphNode
     *            the comment graph node.
     * @param diagram
     *            the diagram graph node.
     * @param modelManager
     *            the UMLModelManager object to apply initial formatting.
     * @throws IllegalArgumentException if any argument is null, or
     *          the commentGraphNode doesn't contains a semanticModel attribute
     *          (Uml1SemanticModelBridge object), which in turn should contain a Comment
     *          object as its element attribute.
     */
    public AddCommentGraphNodeAction(GraphNode commentGraphNode, GraphNode diagram, UMLModelManager modelManager) {
        super(NAME, commentGraphNode, diagram, modelManager);
        // Validate the commentGraphNode
        Helper.validateGraphNodeForComment(commentGraphNode);
    }
}
