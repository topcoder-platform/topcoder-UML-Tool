/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.AbstractAddGraphElementAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class extends the <code>AbstractAddGraphElementAction</code> abstract class,
 * and it is responsible for adding the polyline graph edge into the diagram graph
 * node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not
 * thread-safe, it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class AddPolylineAction extends AbstractAddGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Add Polyline";
    /**
     * <p>
     * Create a new <code>AddPolylineAction</code> with the child graph element to add,
     * the parent graph node and the UML model manager.
     * </p>
     * @param polylineGraphEdge
     *            the polyline graph edge.
     * @param diagram
     *            the diagram graph node.
     * @param modelManager
     *            the UMLModelManager object to apply initial formatting.
     * @throws IllegalArgumentException if any argument is null, or
     *      the polylineGraphEdge doesn't contain a <code>Polyline</code> object in its contained
     *      attribute.
     */
    public AddPolylineAction(GraphEdge polylineGraphEdge, GraphNode diagram, UMLModelManager modelManager) {
        // Call super constructor
        super(NAME, polylineGraphEdge, diagram, modelManager);
        // Validate the polylineGraphEdge
        Helper.validateGraphEdgeForPolylineAction(polylineGraphEdge);
    }
}
