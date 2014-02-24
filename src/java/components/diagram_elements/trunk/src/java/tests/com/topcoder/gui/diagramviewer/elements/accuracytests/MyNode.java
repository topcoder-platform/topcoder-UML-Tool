/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeDragListener;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

/**
 * A mocked class for testing.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class MyNode extends Node {

    /**
     * <p>
     * Construct a concrete instance with the graph node, relative position, selection bound
     * and selection corner types given.
     * </p>
     *
     * @param graphNode the graphNode associated to this Node
     * @param position the relative position of visual node
     * @param bound the selection bound of corners
     * @param corners all the supported selection corners.
     *
     * @throws IllegalArgumentException if any arg is null, or corners contains
     * null element, or corners contains duplicated element.
     */
    public MyNode(GraphNode graphNode, Point position, Rectangle bound, Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
    }

    /**
     * <p>
     * This method implements the abstract method of Node class.
     * </p>
     *
     * @param event the mouse event
     *
     * @return false always
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }

    /**
     * Get selectionCorners belonging to this node.
     *
     * @return a list of selection corners.
     */
    public Collection<SelectionCorner> getSelectionCorners() {
        return super.getSelectionCorners();
    }


    /**
     * Notifies all listeners registered interest for edge drag event.
     *
     * @param event the node drag event.
     */
    protected void fireNodeDrag(LocationEvent event) {
        super.fireNodeDrag(event);
    }


    /**
     * Notifies all listeners registered interest for edge drag event.
     *
     * @param event the node drag event.
     */
    protected void fireCornerDrag(SelectionBoundEvent event) {
        super.fireCornerDrag(event);
    }
}