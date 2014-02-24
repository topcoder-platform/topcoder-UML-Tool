/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.auxiliary.AbstractRemoveGraphElementAction;

/**
 * <p>
 * This class extends the <code>AbstractRemoveGraphElementAction</code> abstract class,
 * and it is responsible for removing the polyline graph edge from its contained
 * diagram graph node.
 * </p>
 * <p>
 * Thread-safety: This class is stateless, but as its base class is not thread-safe,
 * it is not thread-safe too.
 * </p>
 * @version 1.0
 * @author Standlove, TCSDEVELOPER
 */
public class RemovePolylineAction extends AbstractRemoveGraphElementAction {
    /**
     * <p>
     * Represents the presentation of this action.
     * </p>
     */
    private static final String NAME = "Remove Polyline";
    /**
     * <p>
     * Create a new <code>RemovePolylineAction</code> with given polylineGraphEdge.
     * </p>
     * @param polylineGraphEdge
     *            the polyline graph edge.
     * @throws IllegalArgumentException if the argument is null, or its container is null, or
     *          the polylineGraphEdge doesn't contain a Polyline object. in its contained
     *          attribute.
     */
    public RemovePolylineAction(GraphEdge polylineGraphEdge) {
        super(NAME, polylineGraphEdge);
        // Validate the polylineGraphEdge
        Helper.validateGraphEdgeForPolylineAction(polylineGraphEdge);
    }
}
