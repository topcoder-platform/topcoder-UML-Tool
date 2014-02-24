/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;

/**
 * This class is an implementation of <code>Edge</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class GeneralizationEdge extends Edge {

    /**
     * Creates a GeneralizationEdge instance.
     *
     * @param graphEdge
     *            the associated graph edge
     */
    public GeneralizationEdge(GraphEdge graphEdge) {
        super(graphEdge, new LineStyle(1, 0), null, new TriangleEdgeEnding());
    }

    /**
     * Implements the abstract method of Edge class.
     *
     * @param e
     *            the mouse event
     *
     * @return false always
     */
    protected boolean consumeEvent(MouseEvent e) {
        // always ignore the event
        return false;
    }
}