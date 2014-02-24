/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.util.EventListener;

/**
 * <p>
 * The listener interface for adding new element event occurs in the
 * DiagramView. The class that is interested in processing the event implements
 * this interface. And the object created with that class is registered with a
 * DiagramViewer. When the the DiagramViewer has prepared to add new element
 * that object's addNewElement method is invoked. The new element is added to
 * the DiagramView by such a listener finally.
 * </p>
 * <p>
 * Thread safety: The implementations of this interface are not required to be
 * thread-safe. They could be used in a thread safe manner in this component.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public interface AddNewElementListener extends EventListener {

    /**
     * <p>
     * Invoked when the DiagramViewer has prepared to add new element. Should
     * add the new element to the DiagramView.
     * </p>
     * <p>
     * The DiagramView can be retrieved by event.getSource(), and the type of
     * the new element can be retrieved by event.getNewElementType().
     * </p>
     *
     * @param event the AddNewElementEvent to be registered.
     */
    public void addNewElement(AddNewElementEvent event);
}
