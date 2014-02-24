/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import java.util.Collection;


/**
 * <p>This is a simple mock class which extends the <code>Node</code> abstract class. It is
 * used for stress test here.</p>
 *
 * @author icyriver
 * @version 1.0
 */
@SuppressWarnings("serial")
final class SimpleNode extends Node {
/**
     * <p>
     * Creates an instance of <code>SimpleNode</code>.
     * </p>
     *
     * @param graphNode the <code>GraphNode</code> instance associated to this node
     * @param position  the relative position of visual node
     * @param bound the selection bound of corners
     * @param corners all the supported selection corners
     * @throws IllegalArgumentException if <code>graphNode</code>, <code>position</code>, 
     *                                  <code>bound</code> or <code>corners</code>
     *                                  is null, or <code>corners</code> contains null element,
     *                                  or duplicated elements
     */
    public SimpleNode(GraphNode graphNode, Point position, Rectangle bound,
        Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
    }

    /**
     * <p>This method will consume the event when the diagram viewer is in the state of
     * adding element. Here it simply return false.</p>
     *
     * @param event the mouse event to consume.
     *
     * @return always false here.
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * <p>Gets selection corners belonging to this node.</p>
     *
     * @return an unmodifiable collection of selection corners belonging to this node
     */
    public Collection<SelectionCorner> getSelectionCorners() {
        return super.getSelectionCorners();
    }
}
