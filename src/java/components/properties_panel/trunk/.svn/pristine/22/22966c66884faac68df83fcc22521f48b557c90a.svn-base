/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.util.EventListener;

import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This interface extends <code>EventListener</code> interface and  provides a contract for
 * a listener that can be notified when a property of a <code>ModelElement</code> changes.
 * </p>
 *
 * <p>
 * The interface can be implemented by the application to contain the application logic.
 * </p>
 *
 * <p>
 * Once the implementation is registered with <code>PropertiesPanel</code>, the listener will be
 * notified whenever a property value is modified by the panel.
 * </p>
 *
 * <p>
 * Note that external modification (outside the panel) will not result in any notification.
 * </p>
 *
 * <p>
 * Thread-safety: Implementations are not required to be thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public interface ModelElementChangeListener extends EventListener {
    /**
     * <p>
     * Executes the logic that occurs when a property value corresponding to this property panel is changed.
     * </p>
     *
     * @param modelElement the ModelElement whose properties were asked to be modified
     * @param kind the modified property name
     * @param operation the kind of operation to be done on the property
     * @param object the Object that will be added/removed or modify the property (depending on PropertyOperation type)
     *
     * @throws IllegalArgumentException if modelElement, kind or operation is null
     */
    public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation, Object object);
}
