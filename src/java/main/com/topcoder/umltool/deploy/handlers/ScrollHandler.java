/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;
import com.topcoder.gui.diagramviewer.event.ScrollListener;
import com.topcoder.uml.actions.diagram.ScrollDiagramViewAction;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * The handler listens for receiving scroll events occurred when user scrolling a DiagramView.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ScrollHandler implements ScrollListener {

    /**
     * <p>
     * Handles the scroll event. The event tells which DiagramView is scrolled.
     * </p>
     * @param event
     *            the scroll event
     */
    public void diagramViewScrolled(ScrollEvent event) {
        if (event == null) {
            return;
        }

        Diagram diagram = ((ScrollEvent) event).getDiagram();
        JViewport viewport = (JViewport) event.getSource();
        ScrollDiagramViewAction action = new ScrollDiagramViewAction(diagram, DeployHelper.createPoint(viewport
                .getViewPosition()));
        action.execute();
    }

}
