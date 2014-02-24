/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Rectangle;
import java.util.EventObject;

/**
 * <p>
 * This class represents a selection bound event.
 * </p>
 * <p>
 * A selection bound event indicates the change of the node's selection bound. It contains two attribute, old selection
 * bound and new selection bound. It can be used before or after the selection bound changing.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class SelectionBoundEvent extends EventObject {

    /**
     * <p>
     * Represents the old selection bound of node.
     * </p>
     * <p>
     * It is initialized in the constructor, can't null. Never changed after set, can be accessed by getter.
     * </p>
     */
    private final Rectangle oldBound;

    /**
     * <p>
     * Represents the new selection bound of node.
     * </p>
     * <p>
     * It is initialized in the constructor, can't null. Never changed after set, can be accessed by getter.
     * </p>
     */
    private final Rectangle newBound;

    /**
     * <p>
     * Construct a new <code>SelectionBoundEvent</code> instance.
     * </p>
     * <p>
     * Since the <code>Rectangle</code> class is mutable, bound arguments are cloned before set.
     * </p>
     *
     * @param node
     *            the node whose selection bound change
     * @param oldBound
     *            the old selection bounds
     * @param newBound
     *            the new selection bounds
     * @throws IllegalArgumentException
     *             if <code>node</code>, <code>oldBound</code> or <code>newBound</code> is null
     */
    public SelectionBoundEvent(Node node, Rectangle oldBound, Rectangle newBound) {
        super(node);
        if (oldBound == null) {
            throw new IllegalArgumentException("oldBound should not be null.");
        }
        if (newBound == null) {
            throw new IllegalArgumentException("newBound should not be null.");
        }
        this.oldBound = new Rectangle(oldBound);
        this.newBound = new Rectangle(newBound);
    }

    /**
     * <p>
     * Gets the old selection bound of node.
     * </p>
     * <p>
     * Since the <code>Rectangle</code> class is mutable, a cloned object is returned.
     * </p>
     *
     * @return the old selection bound of node
     */
    public Rectangle getOldBound() {
        return new Rectangle(oldBound);
    }

    /**
     * <p>
     * Gets the new selection bound of node.
     * </p>
     * <p>
     * Since the <code>Rectangle</code> class is mutable, a cloned object is returned.
     * </p>
     *
     * @return the new selection bound of node
     */
    public Rectangle getNewBound() {
        return new Rectangle(newBound);
    }

    /**
     * <p>
     * Gets the offset value in the north direction.
     * </p>
     *
     * @return the offset value in the north direction
     */
    public int getNorthOffset() {
        return newBound.y - oldBound.y;
    }

    /**
     * <p>
     * Gets the offset value in the south direction.
     * </p>
     *
     * @return the offset value in the south direction
     */
    public int getSouthOffset() {
        return (newBound.y + newBound.height) - (oldBound.y + oldBound.height);
    }

    /**
     * <p>
     * Gets the offset value in the west direction.
     * </p>
     *
     * @return the offset value in the west direction
     */
    public int getWestOffset() {
        return newBound.x - oldBound.x;
    }

    /**
     * <p>
     * Gets the offset value in the east direction.
     * </p>
     *
     * @return the offset value in the east direction
     */
    public int getEastOffset() {
        return (newBound.x + newBound.width) - (oldBound.x + oldBound.width);
    }
}
