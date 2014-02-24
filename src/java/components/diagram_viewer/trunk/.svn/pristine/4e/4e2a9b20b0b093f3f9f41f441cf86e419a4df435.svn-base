/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.topcoder.gui.diagramviewer.DiagramViewer;

/**
 * <p>
 * Trigger zoom event for the ZoomPanel if a mouse scroll event is received
 * while Ctrl is pressed. It implements MouseWheelListener to listen to mouse
 * wheel event, note only when the key "Ctrl" is pressed the event is processed.
 * When the mouse wheel is rotated up, zoom in the ZoomPanel; When the mouse
 * wheel is rotated down, zoom out the ZoomPanel.
 * </p>
 * <p>
 * Note, the increment of the zoom factor is set to (0 - mouse wheel rotation)
 * now (a positive rotation means the wheel is rotated down, negative value
 * means the wheel is rotated up), it can be set to a configurable value in
 * future. (If required, it can be down in final fix).
 * </p>
 * <p>
 * Thread safety: This class is immutable and thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class ZoomTrigger implements MouseWheelListener {

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public ZoomTrigger() {
        // empty.
    }

    /**
     * <p>
     * Listen to MouseWheelEvent if the field zooming is true, and trigger
     * ZoomEvent for ZoomPanel. The ZoomPanel can be retrieved by
     * event.getSource().
     * </p>
     *
     * @param event the mouse wheel event ( ignore null)
     */
    public void mouseWheelMoved(MouseWheelEvent event) {
        if (event.isControlDown()) {
            //Obtain the DiagramViewer:
            DiagramViewer viewer = (DiagramViewer) event.getSource();
            //Fire zoom event:
            int wheelRotation = event.getWheelRotation();
            if (wheelRotation > 0) {
                viewer.fireZoom(0 - viewer.getZoomRotateIncrement());
            }
            if (wheelRotation < 0) {
                viewer.fireZoom(viewer.getZoomRotateIncrement());
            }
        }
    }
}
