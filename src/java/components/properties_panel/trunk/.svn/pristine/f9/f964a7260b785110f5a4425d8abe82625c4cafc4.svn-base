/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.util.EventListener;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This interface extends <code>EventListener</code> interface and provides a contract
 * for a listener for event when the selected elements change to another
 * <code>ModelElement</code> due to actions within Properties Panel component.
 * </p>
 *
 * <p>
 * The interface can be implemented by the application to contain the application logic.
 * </p>
 *
 * <p>
 * Once the implementation is registered with <code>PropertiesPanel</code>, the listener will be notified
 * whenever a the panel initiates a change of focus to another <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * Note that external changes (outside the panel) will not result in any notification.
 * </p>
 *
 * <p>
 * Thread-safety: Implementations are not required to be thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public interface ModelElementSelectionListener extends EventListener {
    /**
     * <p>
     * Invoked when a different <code>ModelElement</code> is selected due to action
     * within the Properties Panel component.
     * </p>
     *
     * @param modelElement the newly selected ModelElement
     *
     * @throws IllegalArgumentException if modelElement is null
     */
    public void selectionChanged(ModelElement modelElement);
}
