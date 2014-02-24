/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractRemoveGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractRemoveGraphElementAction</code> abstract class, and
 * it is responsible for removing the free text graph node from its contained
 * diagram graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not thread-safe,
 * it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class RemoveFreeTextAction extends AbstractRemoveGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Remove Free Text";
    /**
     * <p>
     * Create a new <code>RemoveFreeTextAction</code> with given freeTextGraphNode.
     * </p>
     * @param freeTextGraphNode
     *            the free text graph node.
     * @throws IllegalArgumentException if the argument is null, or its container is null, or
     *          the freeTextGraphNode doesn't contain a semanticModel attribute
     *          (SimpleSemanticModelElement object) with typeInfo attribute equal to
     *          "FreeText", or it doesn't contain a TextElement object in its contained
     *          attribute.
     */
    public RemoveFreeTextAction(GraphNode freeTextGraphNode) {
        super(NAME, freeTextGraphNode);
        // Validate the freeTextGraphNode
        Helper.validateGraphNodeForFreeTextAction(freeTextGraphNode);
    }
}
