/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This handler listens to the mouse event on diagram view, it will be used to scroll the diagram automatically when
 * dragging.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DiagramViewDragHandler extends MouseAdapter implements MouseMotionListener {

    /**
     * <p>
     * Scrolls the diagram if the event point hits bounds of diagram window.
     * </p>
     * @param e
     *            mouse event (ignore null)
     */
    public void mouseDragged(MouseEvent e) {
        if (e == null) {
            return;
        }
        // auto scroll
        // Obtain the DiagramView from the event:
        DiagramView view = (DiagramView) e.getSource();
        Point newLocation = new Point(e.getX(), e.getY());

        ZoomPane zoomPane = (ZoomPane) view.getParent();
        JViewport viewport = (JViewport) zoomPane.getParent();
        Point viewPos = viewport.getViewPosition();
        int viewHeight = viewport.getExtentSize().height;
        int viewWidth = viewport.getExtentSize().width;

        int offsetx = 0, offsety = 0;
        if (newLocation.x - viewPos.x < 0) {
            offsetx = newLocation.x - viewPos.x;
        } else if (viewPos.x + viewWidth - newLocation.x < 20) {
            offsetx = newLocation.x + 20 - viewPos.x - viewWidth;
        }
        if (newLocation.y - viewPos.y < 0) {
            offsety = newLocation.y - viewPos.y;
        } else if (viewPos.y + viewHeight - newLocation.y < 20) {
            offsety = newLocation.y + 20 - viewPos.y - viewHeight;
        }

        if ((offsetx != 0) || (offsety != 0)) {
            viewport.setViewPosition(new Point(viewPos.x + offsetx, viewPos.y + offsety));
            if ((viewPos.x + offsetx < 0) || (viewPos.y + offsety < 0)
                    || (viewPos.x + offsetx > view.getWidth() + 40 - viewWidth)
                    || (viewPos.y + offsety > view.getHeight() + 40 - viewHeight)) { // resize diagram view
                Dimension size = new Dimension();
                size.setWidth(view.getWidth() + Math.abs(offsetx));
                size.setHeight(view.getHeight() + Math.abs(offsety));
                view.getDiagram().setSize(size);

                DeployHelper.resizeDiagramView(view);
            }
        }
    }

    /**
     * This is a mummy method.
     * @param e
     *            the mouse event (ignore null).
     */
    public void mouseMoved(MouseEvent e) {
        // do nothing
    }
}
