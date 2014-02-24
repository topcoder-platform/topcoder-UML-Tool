/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import java.awt.Point;
import java.util.EventObject;

/**
 * <p>
 * This class extends the EventObject class and represents an event which is related to way point on edge.
 * </p>
 *
 * <p>
 * It can be position changing of wayPoint or creating a new wayPoint.
 * <p>
 *
 * <p>
 * Thread Safety : This class is immutable and thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class WayPointEvent extends EventObject {
    /**
     * <p>
     * The index of way point in the edge.
     * </p>
     *
     * <p>
     * It is initialized in the constructor, can be accessed by getter.
     * </p>
     *
     * <p>
     * It can be any non-negative value, or -1.
     * When it is -1 it means a new way point may be created.
     * </p>
     */
    private final int index;

    /**
     * <p>
     * The offset of the way point.
     * </p>
     *
     * <p>
     * It is initialized in constructor and will never be null.
     * It can be accessed by getter.
     * </p>
     */
    private final Point offset;

    /**
     * <p>
     * The old position of way point.
     * </p>
     *
     * <p>
     * It is initialized in constructor and will never be null.
     * It can be accessed by getter.
     * </p>
     */
    private final Point oldPosition;

    /**
     * <p>
     * Construct a new WayPointEvent instance with the edge, index and offset given.
     * </p>
     *
     * <p>
     * Note, the given offset point is cloned.
     * </p>
     *
     * @param edge the edge containing the way point
     * @param index the index of way point
     * @param offset the position offset.
     *
     * @throws IllegalArgumentException if edge or offset is null
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public WayPointEvent(Edge edge, int index, Point offset) {
        super(edge);

        Util.checkNull(offset, "offset");

        this.index = index;
        this.oldPosition = new Point(edge.getWayPoints().get(index).getCenter());
        this.offset = new Point(offset);
    }

    /**
     * <p>
     * Construct a new WayPointEvent instance with the edge, new way point and offset given.
     * </p>
     *
     * <p>
     * This constructor is used for creating way point situation.
     * The newWaypoint is a point on edge, which will be used as a new way point.
     * </p>
     *
     * @param edge the Edge containing way point
     * @param newWayPoint the position on the edge, which will be created as a new way point
     * @param offset the offset of wayPOint.
     *
     * @throws IllegalArgumentException if any argument is null
     */
    public WayPointEvent(Edge edge, Point newWayPoint, Point offset) {
        super(edge);

        Util.checkNull(newWayPoint, "newWayPoint");
        Util.checkNull(offset, "offset");

        index = -1;
        oldPosition = new Point(newWayPoint);
        this.offset = new Point(offset);
    }

    /**
     * <p>
     * Get the index of way point in the edge.
     * </p>
     *
     * <p>
     * Note, it may be -1. When it is -1 it means a new way point may be created.
     * </p>
     *
     * @return the index of way point in the edge, it may be -1.
     */
    public int getIndex() {
        return index;
    }

    /**
     * <p>
     * Get the offset of the way point.
     * </p>
     *
     * <p>
     * Note, the offset is cloned.
     * </p>
     *
     * @return the offset of the way point.
     */
    public Point getOffset() {
        return new Point(offset);
    }

    /**
     * <p>
     * Get the old position of way point.
     * </p>
     *
     * <p>
     * Note, the point is cloned.
     * </p>
     *
     * @return the old position of way point..
     */
    public Point getOldPosition() {
        return new Point(oldPosition);
    }

    /**
     * <p>
     * Return the new location based on the old position and offset.
     * </p>
     *
     * @return the new position of way point.
     */
    public Point getNewPosition() {
        return new Point(offset.x + oldPosition.x, offset.y + oldPosition.y);
    }
}
