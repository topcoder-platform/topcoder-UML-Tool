/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every boundary changed event listener must follow.
 * </p>
 * <p>
 * It contains only one method to process the boundary changed event with a single BoundaryChangedEvent parameter.
 * </p>
 * <p>
 * The implementations of this interface not required to be thread-safe. They could be used in a thread safe manner in
 * this component.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public interface BoundaryChangedListener extends EventListener {
    /**
     * <p>
     * Handles the boundary changed event. The event parameter could tell which node's bound is changed, and what is the
     * old bound and new bound.
     * </p>
     * @param e
     *            the boundary changed event
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void boundaryChanged(BoundaryChangedEvent e);
}
