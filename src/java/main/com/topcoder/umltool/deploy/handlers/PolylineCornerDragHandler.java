/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Rectangle;

import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.SelectionBoundEvent;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will resize a polyline node when its selection corner is dragged.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly
 * @version 1.0
 */
public class PolylineCornerDragHandler implements CornerDragListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>PolylineCornerDragHandler</code>.
     * </p>
     * @param mainFrame
     *            the mainframe
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public PolylineCornerDragHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Processes the corner dragged event.
     * </p>
     * @param event
     *            a <code>SelectionBoundEvent</code> instance used to indicate the corner drag event
     */
    public void cornerDragged(SelectionBoundEvent event) {
        if (event == null) {
            return;
        }
        PolylineNode node = (PolylineNode) event.getSource();
        Rectangle oldBound = event.getOldBound();
        Rectangle newBound = event.getNewBound();

        if (oldBound.equals(newBound)) {
            return;
        }

        if (newBound.width < SelectionCorner.DEFAULT_RADIUS * 3 || newBound.height < SelectionCorner.DEFAULT_RADIUS * 3) {
            return;
        }
        Polyline polyline = node.getPolyline();
        Point wayPoint = polyline.getWaypoints().get(0);

        wayPoint.setX(wayPoint.getX() + newBound.x - oldBound.x);
        wayPoint.setY(wayPoint.getY() + newBound.y - oldBound.y);
        wayPoint = polyline.getWaypoints().get(1);
        wayPoint.setX(wayPoint.getX() + newBound.x - oldBound.x + newBound.width - oldBound.width);
        wayPoint.setY(wayPoint.getY() + newBound.y - oldBound.y);
        wayPoint = polyline.getWaypoints().get(2);
        wayPoint.setX(wayPoint.getX() + newBound.x - oldBound.x + newBound.width - oldBound.width);
        wayPoint.setY(wayPoint.getY() + newBound.y - oldBound.y + newBound.height - oldBound.height);
        wayPoint = polyline.getWaypoints().get(3);
        wayPoint.setX(wayPoint.getX() + newBound.x - oldBound.x);
        wayPoint.setY(wayPoint.getY() + newBound.y - oldBound.y + newBound.height - oldBound.height);
        wayPoint = polyline.getWaypoints().get(4);
        wayPoint.setX(wayPoint.getX() + newBound.x - oldBound.x);
        wayPoint.setY(wayPoint.getY() + newBound.y - oldBound.y);

        DeployHelper.nodeNotifyChange(node, "Size changed", mainFrame);
    }

}
