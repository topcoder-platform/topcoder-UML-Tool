/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every node add event listener must follow. Note, the event would be
 * triggered before the node is actually added. This kind of listener can be registered to PackageNode instances.
 * </p>
 * <p>
 * It contains only one method to process the node add event with a single NodeAddEvent parameter.
 * </p>
 * <p>
 * The implementations of this interface not required to be thread-safe. They could be used in a thread safe manner in
 * this component.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public interface NodeAddListener extends EventListener {
    /**
     * <p>
     * Processes node add event.
     * </p>
     * <p>
     * Note, the node hasn't been added actually. Application should use this method to add edge to the UML model and
     * diagram interchange.
     * </p>
     * @param e
     *            a NodeAddEvent
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void nodeAdd(NodeAddEvent e);
}
