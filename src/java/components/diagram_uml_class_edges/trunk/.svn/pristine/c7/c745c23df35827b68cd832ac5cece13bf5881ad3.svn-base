/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.edges.EdgeEnding;
import com.topcoder.gui.diagramviewer.edges.LineStyle;

/**
 * <p>
 * A mock class extends <code>BaseEdge</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class MockBaseEdge extends BaseEdge {

    /** The message. */
    private String message;

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param graphEdge
     *            the graphEdge representing this Edge.
     * @param lineStyle
     *            The style of line representing the edge. Actually two types only used: dashed (with dashLength=5,
     *            blankLength=5), and continuous (with dashLength=5, blankLength=0).
     * @param leftEnding
     *            The ending attached to the left end of the edge. Can be null for the open end.
     * @param rightEnding
     *            The ending attached to the right end of the edge. Can be null (for the open edge end).
     *
     * @throws IllegalArgumentException
     *             if graphEdge or lineStyle is null
     * @throws IllegalGraphElementException
     *             if graphEdge has bad structure.
     */
    protected MockBaseEdge(GraphEdge graphEdge, LineStyle lineStyle, EdgeEnding leftEnding, EdgeEnding rightEnding)
        throws IllegalGraphElementException {
        super(graphEdge, lineStyle, leftEnding, rightEnding);
    }

    /**
     * <p>
     * Reload diagram interchange information from contained graphEdge.
     * </p>
     *
     * @param message
     *            message telling how the <tt>GraphNode</tt> is changed
     */
    public void notifyGraphEdgeChange(String message) {
        this.message = message;
    }

    /**
     * <p>
     * Getter of message.
     * </p>
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
