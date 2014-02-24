/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractPasteGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractPasteGraphElementAction</code> abstract class,
 * and it is responsible for pasting the free text graph node into the diagram graph
 * node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not
 * thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class PasteFreeTextAction extends AbstractPasteGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Paste Free Text";
    /**
     * <p>
     * Create a new <code>PasteFreeTextAction</code> with given content
     * and diagram.
     * </p>
     * @param content
     *            the free text graph node to paste.
     * @param diagram
     *            the diagram graph node.
     * @throws IllegalArgumentException if any argument is null, or
     *          the content is not a GraphNode object, or the content doesn't contain a
     *          semanticModel attribute (SimpleSemanticModelElement object) with typeInfo
     *          attribute equal to "FreeText", or it doesn't contain a TextElement object
     *          in its contained attribute.
     */
    public PasteFreeTextAction(Object content, GraphNode diagram) {
        super(NAME, content, diagram);
        if (!(content instanceof GraphNode)) {
            throw new IllegalArgumentException("content should be instance of GraphNode!");
        }
        // Validate the content graph node
        Helper.validateGraphNodeForFreeTextAction((GraphNode) content);
    }
}
