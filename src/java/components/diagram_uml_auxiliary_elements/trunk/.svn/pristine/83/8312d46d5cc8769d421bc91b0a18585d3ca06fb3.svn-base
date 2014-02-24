/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphEdge;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.LineStyle;

import java.awt.event.MouseEvent;


/**
 * <p>
 * This class represents CommentLink edge.
 * It is rather simple that neither edge ending nor text field is required.
 * This edge has a dashed line.
 * </p>
 *
 * <p>
 * This class is not thread safe, since the super class is not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class CommentLinkEdge extends Edge {
    /**
     * <p>
     * Constant for default dash length.
     * </p>
     */
    private static final int DEFAULT_LENGTH = 10;

    /**
     * <p>
     * Constructs a <code>CommentLinkEdge</code>.
     * </p>
     *
     * @param graphEdge - the graphEdge instance defining this Edge.
     *
     * @throws IllegalArgumentException - if graphEdge is null
     */
    public CommentLinkEdge(GraphEdge graphEdge) {
        // Passes graphEdge to super constructor.
        // the super constructor will check whether the graphEdge is null,
        // and if the graphEdge is null, a IAE will be thrown.
        // configures the two endings as null.
        // configures the line style as a dashed line.
        super(graphEdge, new LineStyle(DEFAULT_LENGTH, DEFAULT_LENGTH), null, null);

        // Registers the PopupMenuTrigger.
        this.addMouseListener(new PopupMenuTrigger());
    }

    /**
     * <p>
     * Consumes the event when the diagram viewer is in the status of adding new element.
     * </p>
     *
     * <p>
     * Always return <code>false</code>, indicating the event can't be consumed in this Edge.
     * </p>
     *
     * @return always false
     *
     * @param event - the event to be consumed (null will be ignored)
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }
}
