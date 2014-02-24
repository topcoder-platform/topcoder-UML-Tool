/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.event;

import java.util.EventListener;

/**
 * <p>
 * The listener interface for receiving zoom events after a DiagramView is
 * zoomed. The class that is interested in processing a zoom event implements
 * this interface, and the object created with that class is registered with a
 * DiagramViewer instance, using the method addSelectionListener. After the one
 * of the DiagramView hold by that DiagramViewer is zoomed, that object's
 * diagramViewZoomed method is invoked. It is the responsibility of the
 * implementation to change the zoom factor actually, and note after changing
 * the zoom factor, the content of the zoom text field in bottom bar of
 * DiagramViewer should also be updated, the text field can be updated by
 * calling DiagramViewer#getZoomTextFieldAction()#updateZoomFactorText() method.
 * </p>
 * <p>
 * Thread safety: The implementations of this interface are not required to be
 * thread-safe. They could be used in a thread safe manner in this component.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public interface ZoomListener extends EventListener {
    /**
     * <p>
     * Handle the zoom event. The event tells which DiagramView is zoomed, and
     * the new zoom factor.
     * </p>
     *
     * @param event the zoom event
     */
    public void diagramViewZoomed(ZoomEvent event);
}
