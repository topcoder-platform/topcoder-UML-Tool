/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.event.ZoomEvent;
import com.topcoder.gui.diagramviewer.event.ZoomListener;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.uml.actions.diagram.AdjustDiagramZoomLevelAction;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * The handler listens for receiving zoom events after a DiagramView is zoomed.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class ZoomHandler implements ZoomListener {

    /**
     * <p>
     * Threshold to check zoom factor with zero.
     * </p>
     */
    private static final double EPSILON = 0.01;

    /**
     * <p>
     * Handles the zoom event. The event tells which DiagramView is zoomed, and the new zoom factor.
     * </p>
     * @param event
     *            the zoom event
     */
    public void diagramViewZoomed(ZoomEvent event) {
        if (event == null) {
            return;
        }

        ZoomPanel zoomPanel = (ZoomPanel) event.getSource();
        double zoomFactor = event.getNewZoomFactor();

        if (Math.abs(zoomFactor) < EPSILON) {
            return;
        }

        JViewport viewport = (JViewport) zoomPanel.getComponent(0);
        ZoomPane zoomPane = (ZoomPane) viewport.getComponent(0);
        DiagramView view = (DiagramView) zoomPane.getComponent(0);
        Diagram diagram = view.getDiagram();

        AdjustDiagramZoomLevelAction action = new AdjustDiagramZoomLevelAction(diagram, zoomFactor);
        action.execute();

        DeployHelper.updateZoomPane(view);
    }
}
