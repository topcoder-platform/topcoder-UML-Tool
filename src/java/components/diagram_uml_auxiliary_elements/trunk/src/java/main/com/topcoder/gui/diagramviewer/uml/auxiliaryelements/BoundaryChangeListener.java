/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import java.util.EventListener;


/**
 * <p>
 * This interface defines the contract that every bound change event listener must follow.
 * </p>
 *
 * <p>
 * It contains only one method to process the bound changed event
 * with a single <code>BoundaryChangeEvent</code> parameter.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public interface BoundaryChangeListener extends EventListener {
    /**
     * <p>
     * Handles the bound changed event.
     * The event parameter could tell which node's bound is changed, and what the old bound and new bound is.
     * </p>
     *
     * @param e - the bound change event (null should be ignored)
     */
    public void boundaryChanged(BoundaryChangeEvent e);
}
