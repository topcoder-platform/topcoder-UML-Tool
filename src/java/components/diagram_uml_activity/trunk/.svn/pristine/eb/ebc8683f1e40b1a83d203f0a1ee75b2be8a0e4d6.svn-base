/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import java.util.EventListener;

/**
 * <p>
 * This interface provides a mechanism to let the application be notified when the name compartment of the nodes is
 * changed, there is only one method in this class and it will be called to process the name changed event, the
 * implementation should change the node's name to the new one by calling the method setName() of the node.
 * <p>
 * <p>
 * Thread safety : the implementation is not required to be thread safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public interface TextChangedListener extends EventListener {
    /**
     * <p>
     * Performs the name changed event and set the new name to the node.
     * </p>
     * @param event
     *            the new value of the name compartment
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public void textChanged(TextChangedEvent event);
}
