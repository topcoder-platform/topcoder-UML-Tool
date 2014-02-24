/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventListener;

/**
 * <p>
 * The listener interface for receiving selection events occurs in the
 * DiagramView. The class that is interested in processing a selection event
 * implements this interface, and the object created with that class is
 * registered with a DiagramViewer (which holds the instances of DiagramView),
 * using the method addSelectionListener. When the selection event occurs, that
 * object's selectionRectangleChanged method is invoked.
 * </p>
 * <p>
 * Thread safety: The implementations of this interface are not required to be
 * thread-safe. They could be used in a thread safe manner in this component.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public interface SelectionListener extends EventListener {

    /**
     * <p>
     * This method is invoked when a selection event occurs. The implementation
     * should check which elements of the DiagramView intersect the rectangle
     * and update the list of selected elements. The DiagramView can be obtained
     * from the event as event.getSource().
     * </p>
     *
     * @param event the selection event
     * @throws IllegalArgumentException if the argument is null
     */
    public void selectionRectangleChanged(SelectionEvent event);
}
