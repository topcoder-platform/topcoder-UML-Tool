/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.event;

import java.awt.Rectangle;
import java.util.EventObject;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.Util;

/**
 * <p>
 * This is an event object used to indicate bound of node (including node container) is changed. It contains four
 * properties. They are the Node whose bound is changed, the old bound value, the new bound value, and some message.
 * Note, the Node property can be retrieved by getSource().
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangedEvent extends EventObject {

    /**
     * <p>
     * Represents the old bound value. Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final Rectangle oldBoundary;

    /**
     * <p>
     * Represents the new bound value. Initialized in constructor, never changed later. Can't be null.
     * </p>
     */
    private final Rectangle newBoundary;

    /**
     * <p>
     * Represents the bound changing message. E.g. The message may be the reason. Initialized in constructor, never
     * changed later. Can be null or empty.
     * </p>
     */
    private final String message;

    /**
     * <p>
     * Constructs a boundary changed event.
     * </p>
     * @param node
     *            the node whose bound changed
     * @param oldBound
     *            the old bound value
     * @param newBound
     *            the new bound value
     * @throws IllegalArgumentException
     *             if given node, oldBound, or newBound is null
     */
    public BoundaryChangedEvent(Node node, Rectangle oldBound, Rectangle newBound) {
        this(node, oldBound, newBound, null);
    }

    /**
     * <p>
     * Constructs a boundary changed event.
     * </p>
     * @param node
     *            the node whose bound changed
     * @param oldBound
     *            the old bound value
     * @param newBound
     *            the new bound value
     * @param message
     *            the message(can be null or empty)
     * @throws IllegalArgumentException
     *             if given node, oldBound or newBound is null
     */
    public BoundaryChangedEvent(Node node, Rectangle oldBound, Rectangle newBound, String message) {
        super(node);
        Util.checkNotNull(oldBound, "oldBound");
        Util.checkNotNull(newBound, "newBound");
        this.message = message;
        this.oldBoundary = oldBound;
        this.newBoundary = newBound;
    }

    /**
     * <p>
     * Gets the oldBound.
     * </p>
     * @return the oldBound value
     */
    public Rectangle getOldBoundary() {
        return oldBoundary;
    }

    /**
     * <p>
     * Gets the newBound.
     * </p>
     * @return the newBound value
     */
    public Rectangle getNewBoundary() {
        return newBoundary;
    }

    /**
     * <p>
     * Gets the message.
     * </p>
     * @return the message string
     */
    public String getMessage() {
        return message;
    }
}
