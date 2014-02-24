/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.accuracytests;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;


/**
 * <p>
 * This mock class extends <code>Edge</code> class used for
 * accuracy tests only.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
@SuppressWarnings("serial")
final class MockEdge extends Edge {
    /**
     * <p>
     * Creates an instance of <code>MockEdge</code> with the given params.
     * </p>
     *
     * @param graphEdge the associated graphEdge
     * @param lineStyle the line style of this edge
     * @param leftEnding the left ending of this edge
     * @param rightEnding the right ending of this edge.
     *
     * @throws IllegalArgumentException if graphEdge or lineStyle is null.
     */
    protected MockEdge(GraphEdge graphEdge, LineStyle lineStyle,
        EdgeEnding leftEnding, EdgeEnding rightEnding) {
        super(graphEdge, lineStyle, leftEnding, rightEnding);
    }

    /**
     * <p>
     * Cosume event when the diagram viewer is in the state of adding element
     * Here simply return true.
     * </p>
     *
     * @param event the mouse event
     *
     * @return true alwayes.
     */
    protected boolean consumeEvent(MouseEvent event) {
        return true;
    }
}
