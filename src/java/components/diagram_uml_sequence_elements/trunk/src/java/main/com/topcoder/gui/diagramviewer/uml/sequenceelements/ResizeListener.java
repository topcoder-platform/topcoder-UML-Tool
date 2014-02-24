/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.util.EventListener;


/**
 * <p>
 * The interface for listening to the component resize requests.
 * The external component can implement this interface to be
 * registered by the ObjectNode.
 * </p>
 *
 * <p>
 * This is a child of the EventListener, so it works in the standard way.
 * The resizeNeeded message will occur when the ObjectNode need to be
 * resized and therefore sending the message to the top level component.
 * </p>
 *
 * <p>
 * Thread Safety : The interface implementations should be thread safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public interface ResizeListener extends EventListener {
    /**
     * <p>
     * Does the actions when the node requests resizing.
     * </p>
     *
     * @param event The instance of the ResizeEvent class.
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void resizeNeeded(ResizeEvent event);
}
