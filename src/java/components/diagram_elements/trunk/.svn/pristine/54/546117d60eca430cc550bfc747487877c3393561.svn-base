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
 * This class is a mock NodeContainer used to test NodeContainer class. The class is also used to test other
 * classes that require a NodeContainer arguments.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class MockNodeContainerFailure extends NodeContainer {

    /**
     * <p>
     * Creates a new MockNodeContainer.
     * </p>
     * 
     * @param graphNode the graphNode assocciated to this NodeContainer
     * @param position the relative position of visual node
     * @param bound the selection bound of corners
     * @param corners all the supported selection corners
     * @throws IllegalArgumentException if any arg is null, or corners contains null element, or corners contains
     *             duplicated element
     */
    public MockNodeContainerFailure(GraphNode graphNode, Point position, Rectangle bound,
            Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
    }

    /**
     * <p>
     * Consume event when the diagram viewer is in the state of adding element. This method should be implemented
     * by concrete Edge.
     * </p>
     * <p>
     * If true is returned, it means that the event is consumed in the element. if false is returned, it means that
     * the event should be passed behind.
     * </p>
     * 
     * @return true if the event is consumed, otherwise false.
     * @param event the mouse event or mouse motion event.
     */
    public boolean consumeEvent(MouseEvent event) {
        // Do nothing; simply return false.
        return false;
    }
}
