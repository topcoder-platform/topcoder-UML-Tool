/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.util.EventObject;

/**
 * <p>
 * This class represents a location event.
 * </p>
 * <p>
 * A location event indicates the change of the node location. It contains two attribute, old location and new location.
 * It can be used before or after the location changing.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is immutable and thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class LocationEvent extends EventObject {

    /**
     * <p>
     * Represents the old location of node.
     * </p>
     * <p>
     * It is initialized in the constructor, can't null. Never changed after set, can be accessed by getter.
     * </p>
     */
    private final Point oldLocation;

    /**
     * <p>
     * Represents the new location of node.
     * </p>
     * <p>
     * It is initialized in the constructor, can't null. Never changed after set, can be accessed by getter.
     * </p>
     */
    private final Point newLocation;

    /**
     * <p>
     * Construct a new <code>LocationEvent</code> instance.
     * </p>
     * <p>
     * Since the <code>Point</code> class is mutable, location arguments are cloned before set.
     * </p>
     *
     * @param node
     *            the node whose location change
     * @param oldLocation
     *            the old location of node
     * @param newLocation
     *            the new location of node
     * @throws IllegalArgumentException
     *             if <code>node</code>, <code>oldLocation</code> or <code>newLocation</code> is null
     */
    public LocationEvent(Node node, Point oldLocation, Point newLocation) {
        super(node);
        if (oldLocation == null) {
            throw new IllegalArgumentException("oldLocation should not be null.");
        }
        if (newLocation == null) {
            throw new IllegalArgumentException("newLocation should not be null.");
        }
        this.oldLocation = new Point(oldLocation);
        this.newLocation = new Point(newLocation);
    }

    /**
     * <p>
     * Gets the old location of node.
     * </p>
     * <p>
     * Since the <code>Point</code> class is mutable, a cloned object is returned.
     * </p>
     *
     * @return the old location of node
     */
    public Point getOldLocation() {
        return new Point(oldLocation);
    }

    /**
     * <p>
     * Gets the new location of node.
     * </p>
     * <p>
     * Since the <code>Point</code> class is mutable, a cloned object is returned.
     * </p>
     *
     * @return the new location of node
     */
    public Point getNewLocation() {
        return new Point(newLocation);
    }

    /**
     * <p>
     * Gets the location offset.
     * </p>
     *
     * @return the location offset
     */
    public Point getOffset() {
        return new Point(newLocation.x - oldLocation.x, newLocation.y - oldLocation.y);
    }
}
