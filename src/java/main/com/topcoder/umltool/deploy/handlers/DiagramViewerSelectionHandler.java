/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.event.SelectionEvent;
import com.topcoder.gui.diagramviewer.event.SelectionHandler;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This implementation of SelectionListener will checks which elements in the diagram viewer should be selected, and
 * update document tree, type panel, properties panel and documentation panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DiagramViewerSelectionHandler extends SelectionHandler {

    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of DiagramViewerSelectionHandler.
     * </p>
     * @param mainFrame
     *            the mainframe
     */
    public DiagramViewerSelectionHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Checks which element of the diagram view object intersects the selection rectangle and updates the selected
     * elements list of the diagram viewer object, then notify all related panels.
     * </p>
     * @param event
     *            the selection event that provides the information about the selection rectangle
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public void selectionRectangleChanged(SelectionEvent event) {
        DeployHelper.checkNotNull(event, "event");
        super.selectionRectangleChanged(event);
        DeployHelper.notifySelectionChanged(mainFrame, (DiagramView) event.getSource());
    }
}
