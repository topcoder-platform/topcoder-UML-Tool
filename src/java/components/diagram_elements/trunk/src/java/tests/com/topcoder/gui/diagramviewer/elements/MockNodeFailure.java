/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collection;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * This class is a mock Node used to test Node class. The class is also used to test other classes that require a
 * Node arguments.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class MockNodeFailure extends Node {

    /**
     * Construct a Node instance.
     * 
     * @param graphNode the graphNode assocciated to this Node
     * @param position the relative position of visual node
     * @param bound the selection bound of corners
     * @param corners all the supported selection corners
     * @throws IllegalArgumentException if any argument is null, or corners contains null element, or corners
     *             contains duplicated element
     */
    public MockNodeFailure(GraphNode graphNode, Point position, Rectangle bound, Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
    }

    /**
     * Consumes an event.
     * 
     * @param event the event to be consumed
     */
    public boolean consumeEvent(MouseEvent event) {
        // Always return false.
        return false;
    }

}
