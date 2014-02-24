/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every boundary change event listener must follow.
 * </p>
 * <p>
 * It contains only one method to process the boundary changed event with a single BoundaryChangeEvent parameter.
 * </p>
 * <p>
 * <b>Thread Safety:</b> The implementations of this interface not required to be thread-safe. They could be used in a
 * thread safe manner in this component.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface BoundaryChangedListener extends EventListener {
    /**
     * <p>
     * Handle the boundary changed event.
     * </p>
     * <p>
     * The event parameter could tell which node's bound is changed, and what is the old bound and new bound.
     * </p>
     *
     * @param e the boundary change event
     */
    public void boundaryChanged(BoundaryChangedEvent e);

}
