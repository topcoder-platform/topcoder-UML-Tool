/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.Rectangle;
import java.util.EventObject;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.Utils;

/**
 * <p>
 * This is an event object used to indicate bound of node (including node container) is changed. It contains four
 * properties. They are the Node whose bound is changed, the old bound value, the new bound value, and some message.
 * Note, the Node property can be retrieved by getSource().
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
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
     * Construct a bound changed event.
     * </p>
     *
     * @param node the node whose bound changed
     * @param oldBound the old bound value
     * @param newBound the new bound value.
     * @throws IllegalArgumentException if any argument is null.
     */
    public BoundaryChangedEvent(Node node, Rectangle oldBound, Rectangle newBound) {
        this(node, oldBound, newBound, null);
    }

    /**
     * <p>
     * Construct a bound changed event.
     * </p>
     *
     * @param node the node whose bound changed
     * @param oldBound the old bound value
     * @param newBound the new bound value.
     * @param message the message(can be null or empty)
     * @throws IllegalArgumentException if node or oldBound or newBound is null
     */
    public BoundaryChangedEvent(Node node, Rectangle oldBound, Rectangle newBound, String message) {
        super(node);
        Utils.checkNull(oldBound, "oldBound");
        Utils.checkNull(newBound, "newBound");
        this.message = message;
        this.oldBoundary = oldBound;
        this.newBoundary = newBound;
    }

    /**
     * <p>
     * Getter of oldBound field. See field document for explanation.
     * </p>
     *
     * @return the oldBound value.
     */
    public Rectangle getOldBoundary() {
        return oldBoundary;
    }

    /**
     * <p>
     * Getter of newBound field. See field document for explanation.
     * </p>
     *
     * @return the newBound value.
     */
    public Rectangle getNewBoundary() {
        return newBoundary;
    }

    /**
     * <p>
     * Getter of message field. See field document for explanation.
     * </p>
     *
     * @return the message string.
     */
    public String getMessage() {
        return message;
    }
}
