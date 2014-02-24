/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractAddGraphElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class extends the <code>AbstractAddGraphElementAction</code> abstract class,
 * and it is responsible for adding the free text graph node into the diagram graph
 * node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not
 * thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AddFreeTextAction extends AbstractAddGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Add Free Text";
    /**
     * <p>
     * Create a new <code>AddFreeTextAction</code> with the child graph element to add,
     * the parent graph node and the UML model manager.
     * </p>
     * @param freeTextGraphNode
     *            the free text graph node.
     * @param diagram
     *            the diagram graph node.
     * @param modelManager
     *            the UMLModelManager object to apply initial formatting.
     * @throws IllegalArgumentException if any argument is null, or the freeTextGraphNode doesn't
     *      contain a semanticModel attribute (<code>SimpleSemanticModelElement</code> object) with typeInfo
     *      attribute equal to "FreeText", or it doesn't contain a <code>TextElement</code> object in its
     *      contained attribute.
     */
    public AddFreeTextAction(GraphNode freeTextGraphNode, GraphNode diagram, UMLModelManager modelManager) {
        // Call super constructor
        super(NAME, freeTextGraphNode, diagram, modelManager);
        // Validate the freeTextGraphNode
        Helper.validateGraphNodeForFreeTextAction(freeTextGraphNode);
    }
}
