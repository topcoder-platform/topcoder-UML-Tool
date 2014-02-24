/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.NodeContainer;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

/**
 * A mockek class for testing.
 *
 * @author Chenhong
 * @version 1.0
 */
public class MyNodeContainer extends NodeContainer {

    /**
     * Construct a MyNodeContainer instance.
     *
     * @param graphNode
     *            the graphNode associated to this NodeContainer.
     * @param position
     *            the relative position of visual node.
     * @param bound
     *            the selection bound of corners.
     * @param corners
     *            all the supported selection corners.
     * @throws IllegalArgumentException
     *             if any arg is null, or corners contains null element, or corners contains duplicated element.
     */
    public MyNodeContainer(GraphNode graphNode, Point position, Rectangle bound,
            Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
    }

    /**
     * implementation for abstract method.
     */
    protected boolean consumeEvent(MouseEvent event) {
        return false;
    }
}
