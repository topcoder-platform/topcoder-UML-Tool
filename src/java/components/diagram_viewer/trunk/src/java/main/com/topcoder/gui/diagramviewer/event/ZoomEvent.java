/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventObject;

import com.topcoder.gui.panels.zoom.ZoomPanel;

/**
 * <p>
 * This event indicates that a DiagramView is zoomed in (or out). It is
 * triggered when the user clicks the zoom spin buttons on lower right corner of
 * DiagramViewer.
 * </p>
 * <p>
 * It has only one property represents the new zoom factor. Note, the ZoomPanel
 * can be retrieved by method getSource(), the DiagramView can be retrieved as
 * child of the ZoomPanel, and the Diagram can be retrieved by method
 * DiagramView.getDiagram().
 * </p>
 * <p>
 * Thread safety: This class is immutable and thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ZoomEvent extends EventObject {

    /**
     * <p>
     * Represents the new zoom factor of the DiagramView after being zoomed.
     * </p>
     * <p>
     * Initialized in ctor and never changed later. Can not be non-positive.
     * </p>
     */
    private final double newZoomFactor;

    /**
     * <p>
     * Constructor, simply assigns arguments to fields.
     * </p>
     *
     * @param source the ZoomPanel which is to be zoomed
     * @param newZoomFactor the new zoom factor, should be positive
     * @throws IllegalArgumentException if the source is null or newZoomFactor
     *             is non-positive
     */
    public ZoomEvent(ZoomPanel source, double newZoomFactor) {
        super(source);
        if (newZoomFactor > 0) {
            this.newZoomFactor = newZoomFactor;
        } else {
            throw new IllegalArgumentException("The newZoomFactor should be positive.");
        }
    }

    /**
     * <p>
     * Getter of the newZoomFactor, see field doc for explanation.
     * </p>
     *
     * @return the new zoom factor
     */
    public double getNewZoomFactor() {
        return newZoomFactor;
    }
}
