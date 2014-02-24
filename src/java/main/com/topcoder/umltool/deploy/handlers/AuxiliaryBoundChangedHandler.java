/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BoundaryChangeListener;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This implementation handles the boundary changed event of Auxiliary component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AuxiliaryBoundChangedHandler implements BoundaryChangeListener {

    /**
     * <p>
     * Handles the boundary changed event. The event parameter could tell which node's bound is changed, and what is the
     * old bound and new bound.
     * </p>
     * @param e
     *            the boundary change event
     */
    public void boundaryChanged(BoundaryChangeEvent e) {
        if (e == null) {
            return;
        }
        Node node = (Node) e.getSource();
        Point location = DeployHelper.getAbsoluteGraphNodePosition(node.getGraphNode());
        Dimension size = new Dimension();
        size.width = (int) Math.round(node.getGraphNode().getSize().getWidth());
        size.height = (int) Math.round(node.getGraphNode().getSize().getHeight());
        location.x -= SelectionCorner.DEFAULT_RADIUS;
        location.y -= SelectionCorner.DEFAULT_RADIUS;
        node.setSelectionBound(new Rectangle(node.getRelativePosition(), size));
        node.setLocation(location);
    }

}
