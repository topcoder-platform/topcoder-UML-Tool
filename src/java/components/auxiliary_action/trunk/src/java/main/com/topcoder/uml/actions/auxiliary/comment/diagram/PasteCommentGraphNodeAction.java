/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractPasteGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractPasteGraphElementAction</code> abstract class,
 * and it is responsible for pasting the comment graph node into the diagram graph
 * node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not
 * thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class PasteCommentGraphNodeAction extends AbstractPasteGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Paste Comment GraphNode";
    /**
     * <p>
     * Create a new <code>PasteCommentGraphNodeAction</code> with given content
     * and diagram.
     * </p>
     * @param content
     *            the comment graph node to paste.
     * @param diagram
     *            the diagram graph node.
     * @throws IllegalArgumentException if any argument is null, or
     *          the content is not a GraphNode object, or it doesn't contains a
     *          semanticModel attribute (Uml1SemanticModelBridge object), which in turn
     *          should contain a Comment object as its element attribute.
     */
    public PasteCommentGraphNodeAction(Object content, GraphNode diagram) {
        super(NAME, content, diagram);
        if (!(content instanceof GraphNode)) {
            throw new IllegalArgumentException("content should be instance of GraphNode!");
        }
        // Validate the content
        Helper.validateGraphNodeForComment((GraphNode) content);
    }
}
