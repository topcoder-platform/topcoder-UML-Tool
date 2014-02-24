/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.event.MouseEvent;

import com.topcoder.diagraminterchange.GraphEdge;

/**
 * <p>
 * This is a mock extends of BaseEdge class. It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockBaseEdge extends BaseEdge {
    /**
     * <p>
     * Construct a baseEdge instance.
     * </p>
     *
     * @param graphEdge the graphEdge representing this Edge.
     * @param keywordMetaclass the keyword metaclass of this edge
     * @throws IllegalArgumentException if <code>graphEdge</code> is null, or <code>keywordMetaclass</code> is empty
     * @throws IllegalGraphElementException if <code>graphEdge</code> has bad structure.
     */
    public MockBaseEdge(GraphEdge graphEdge, String keywordMetaclass) throws IllegalGraphElementException {
        super(graphEdge, keywordMetaclass);
    }

    /**
     * <p>
     * Consume the event when the diagram viewer is in the status of adding new element. Because all the edges in this
     * component don't react such events, we provide a default implementation here.
     * </p>
     * <p>
     * Always return false, indicating the event can't be consumed in this Edge.
     * </p>
     *
     * @return always false
     * @param event the mouse event
     */
    public boolean consumeEvent(MouseEvent event) {
        return super.consumeEvent(event);
    }
}
