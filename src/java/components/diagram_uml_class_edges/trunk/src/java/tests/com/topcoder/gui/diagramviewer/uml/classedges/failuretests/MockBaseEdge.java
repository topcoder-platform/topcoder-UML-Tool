/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;
import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.IllegalGraphElementException;
/**
 * Package private mock BaseEdge class used in failure test.
 *
 * @author still
 * @version 1.0
 */
final class MockBaseEdge extends BaseEdge {
    /**
     * MockBaseEdge default constructor.
     *
     * @param graphEdge
     *            the graphEdge representing this Edge.
     * @param lineStyle
     *            The style of line representing the edge.
     * @param leftEnding
     *            The ending attached to the left end of the edge.
     * @param rightEnding
     *            The ending attached to the right end of the edge.
     * @throws IllegalArgumentException
     *             if graphEdge or lineStyle is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure.
     */
    protected MockBaseEdge(GraphEdge graphEdge, LineStyle lineStyle,
        EdgeEnding leftEnding, EdgeEnding rightEnding) throws IllegalGraphElementException {
        super(graphEdge, lineStyle, leftEnding, rightEnding);
    }

    /**
     * Empty implementation of method notifyGraphEdgeChange.
     * @param message
     *            message telling how the GraphNode is changed
     *
     * @throws IllegalGraphElementException
     *             if the structure of GraphNode is invalid
     */
    public void notifyGraphEdgeChange(String message) throws IllegalGraphElementException {

    }

}