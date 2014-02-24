/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.event;

import java.awt.Rectangle;
import java.util.EventObject;

import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;

/**
 * <p>
 * This is an event object used to indicate bound of node (including node container) is changed. It contains four
 * properties. They are the Node whose bound is changed, the old bound value, the new bound value, and some message.
 * Note, the Node property can be retrieved by getSource().
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangedEvent extends EventObject {

    /**
     * Represents some information about why this event occurs. Could be null.
     */
    private final String message;

    /**
     * Represents the old boundary value. Initialized in constructor, never changed later. Can't be null.
     */
    private final Rectangle oldBoundary;

    /**
     * Represents the new boundary value. Initialized in constructor, never changed later. Can't be null.
     */
    private final Rectangle newBoundary;

    /**
     * <p>
     * Creates an instance of <code>BoundaryChangedEvent</code>.
     * </p>
     * @param source
     *            the node whose bound changed
     * @param message
     *            the message about this event, could be null
     * @param oldBoundary
     *            the old boundary value
     * @param newBoundary
     *            the new boundary value
     * @throws IllegalArgumentException
     *             if source, oldBoundary or newBoundary is null
     */
    public BoundaryChangedEvent(BaseNode source, String message, Rectangle oldBoundary, Rectangle newBoundary) {
        super(source);
        if (oldBoundary == null) {
            throw new IllegalArgumentException("oldBoundary should not be null.");
        }
        if (newBoundary == null) {
            throw new IllegalArgumentException("newBoundary should not be null.");
        }
        this.message = message;
        this.oldBoundary = oldBoundary;
        this.newBoundary = newBoundary;
    }

    /**
     * <p>
     * Gets the event message.
     * </p>
     * @return the event message
     */
    public String getMessage() {
        return message;
    }

    /**
     * <p>
     * Gets the oldBoundary field.
     * </p>
     * @return the old boundary
     */
    public Rectangle getOldBoundary() {
        return oldBoundary;
    }

    /**
     * Gets the newBoundary field.
     * @return the new boundary
     */
    public Rectangle getNewBoundary() {
        return newBoundary;
    }
}
