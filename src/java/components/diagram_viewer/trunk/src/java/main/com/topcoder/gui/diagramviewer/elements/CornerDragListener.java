/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.util.EventListener;

/**
 * <p>
 * This interface defines the contract that every selection corner drag event listener must follow.
 * </p>
 * <p>
 * It contains only one method to process the selection corner dragged event with a single
 * <code>SelectionBoundEvent</code> parameter.
 * </p>
 * <p>
 * <b>Thread Safety:</b> Implementations of this interface are not required thread safe. As it is an event listener, it
 * will be used in a thread safe manner.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface CornerDragListener extends EventListener {

    /**
     * <p>
     * Processes the corner dragged event.
     * </p>
     *
     * @param event
     *            a <code>SelectionBoundEvent</code> instance used to indicate the corner drag event
     */
    void cornerDragged(SelectionBoundEvent event);
}
