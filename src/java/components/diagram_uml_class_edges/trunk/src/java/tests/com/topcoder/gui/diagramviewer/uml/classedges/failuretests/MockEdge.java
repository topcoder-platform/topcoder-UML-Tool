/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;

/**
 * <p>This class is a simple mock of class Edge.</p>
 *
 * @author still
 * @version 1.0
 */
@SuppressWarnings("serial")
final class MockEdge extends Edge {
    /**
     * <p>Constructor with only GraphEdge argument.</p>
     *
     * @param graphEdge the graphEdge passed to constructor of Edge.
     */
    public MockEdge(GraphEdge graphEdge) {
        super(graphEdge, new LineStyle(1, 1), new MockEdgeEnding(), new MockEdgeEnding());
    }

    /**
     * <p>Constructor with all arguments.</p>
     *
     * @param graphEdge the graphEdge passed to constructor of Edge.
     * @param lineStyle the lineStyle passed to constructor of Edge.
     * @param leftEnding the leftEnding passed to constructor of Edge.
     * @param rightEnding the rightEnding passed to constructor of Edge.
     */
    protected MockEdge(GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding, EdgeEnding rightEnding) {
        super(graphEdge, lineStyle, leftEnding, rightEnding);
    }

    /**
     * <p>Mock method always returns false.</p>
     *
     * @param event not used.
     * @return false always.
     */
    @Override
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }
}
