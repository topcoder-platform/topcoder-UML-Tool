/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventListener;

/**
 * <p>
 * The listener interface for receiving scroll events occurred when user
 * scrolling a DiagramView. The class that is interested in processing a scroll
 * event implements this interface, and the object created with that class is
 * registered with a DiagramViewer instance, using the method
 * addSelectionListener. When the scroll event occurs, that object's
 * diagramViewScrolled method is invoked.
 * </p>
 * <p>
 * Thread safety: The implementations of this interface are not required to be
 * thread-safe. They could be used in a thread safe manner in this component.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public interface ScrollListener extends EventListener {
    /**
     * <p>
     * Handle the scroll event. The event tells which DiagramView is scrolled.
     * </p>
     *
     * @param event the scroll event
     */
    public void diagramViewScrolled(ScrollEvent event);
}
