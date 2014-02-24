/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.stresstests;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;

/**
 * <p>
 * A mock Edge for testing.
 * </p>
 * @author KLW
 * @version 1.0
 */

public class MockedEdge extends Edge {

    /**
     * <p>
     * Creates an instance of <code>MockedEdge</code>.
     * </p>
     * @param graphEdge
     *            the graphEdge representing this Edge
     */
    public MockedEdge(GraphEdge graphEdge) {
        super(graphEdge, new LineStyle(5, 0), null, null);
    }

    /**
     * <p>
     * Consumes event when the diagram viewer is in the state of adding element. Simply return false.
     * </p>
     * @param event
     *            the mouse event or mouse motion event
     * @return true if the event is consumed, otherwise false
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

}
