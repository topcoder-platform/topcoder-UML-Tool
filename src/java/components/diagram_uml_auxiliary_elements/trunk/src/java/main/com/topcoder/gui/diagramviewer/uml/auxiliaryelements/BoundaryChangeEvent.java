/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.gui.diagramviewer.elements.Node;

import java.awt.Rectangle;
import java.util.EventObject;


/**
 * <p>
 * This is an event object used to indicate bound of node is changed.
 * It contains four properties.
 * They are the <code>Node</code> whose bound is changed,
 * The old bound value, the new bound value, and some message.
 * Note, the <code>Node</code> property can be retrieved by <code>getSource()</code>.
 * </p>
 *
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangeEvent extends EventObject {
    /**
     * <p>
     * Represents the old boundary value of some node.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be <code>null</code>.
     * </p>
     */
    private final Rectangle oldBoundary;

    /**
     * <p>
     * Represents the new boundary value of some node.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can't be <code>null</code>.
     * </p>
     */
    private final Rectangle newBoundary;

    /**
     * <p>
     * Represents the bound changing message.
     * E.g. the message may be the reason.
     * </p>
     *
     * <p>
     * Initialized in constructor, never changed later. Can be <code>null</code> or empty.
     * </p>
     */
    private final String message;

    /**
     * <p>
     * Constructs a bounding change event.
     * </p>
     *
     * @param oldBoundary - the old bound value
     * @param newBoundary - the new bound value.
     *
     * @throws IllegalArgumentException - if any arg is null.
     */
    public BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary) {
        // simply call the other constructor
        this(node, oldBoundary, newBoundary, null);
    }

    /**
     * <p>
     * Constructs a bounding change event. Assign the params to corresponding fields.
     * </p>
     *
     * @param oldBoundary - the old bound value
     * @param newBoundary - the new bound value.
     * @param message - the message (can be null or empty)
     *
     * @throws IllegalArgumentException - if node or oldBoundary or newBoundary is null
     */
    public BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message) {
        // Passes node to super constructor.
        // the super constructor will check whether the node is null,
        // and if the node is null, a IAE will be thrown.
        super(node);

        // Checks whether the oldBoundary and the newBoundary is null,
        // if any one is null, a IAE will be thrown.
        AuxiliaryElementsHelper.checkNotNull(oldBoundary, "oldBoundary");
        AuxiliaryElementsHelper.checkNotNull(newBoundary, "newBoundary");

        // Assigns values
        this.message = message;
        this.oldBoundary = oldBoundary;
        this.newBoundary = newBoundary;
    }

    /**
     * <p>
     * Gets the oldBoundary field. See field doc for explanation.
     * </p>
     *
     * @return the oldBoundary value.
     */
    public Rectangle getOldBoundary() {
        return this.oldBoundary;
    }

    /**
     * <p>
     * Gets the newBoundary field. See field doc for explanation.
     * </p>
     *
     * @return the newBoundary value.
     */
    public Rectangle getNewBoundary() {
        return this.newBoundary;
    }

    /**
     * <p>
     * Gets the message field. See field doc for explanation.
     * </p>
     *
     * @return the message string.
     */
    public String getMessage() {
        return this.message;
    }
}
