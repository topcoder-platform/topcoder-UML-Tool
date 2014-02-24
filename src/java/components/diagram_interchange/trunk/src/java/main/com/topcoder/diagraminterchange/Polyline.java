/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class represents the Polyline and extends GraphicPrimitive. It is a line passing through all ordered
 * waypoints.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class Polyline extends GraphicPrimitive {

    /**
     * <p>
     * This flag tells whether the Polyline is closed or not. Default to false.
     * </p>
     */
    private boolean closed;

    /**
     * <p>
     * Represents the waypoints of this Polyline. Can never be null. Can be empty. Elements cannot be null.
     * There can be duplicated elements. Default to empty.
     * </p>
     */
    private final List<Point> waypoints = new ArrayList<Point>();

    /**
     * <p>
     * Creates an instance of Polyline.
     * </p>
     */
    public Polyline() {
        super();
    }

    /**
     * <p>
     * Returns true if this Polyline is closed, false otherwise.
     * </p>
     *
     * @return true if this Polyline is closed, false otherwise
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * <p>
     * Sets true tells that this Polyline is closed, false otherwise.
     * </p>
     *
     * @param isClosed true tells that this Polyline is closed, false otherwise
     */
    public void setClosed(boolean isClosed) {
        this.closed = isClosed;
    }

    /**
     * <p>
     * Appends a waypoint to this Polyline at the end.
     * </p>
     *
     * @param waypoint the waypoint to be appended
     * @throws IllegalArgumentException if waypoint is null
     */
    public void addWaypoint(Point waypoint) {
        if (waypoint == null) {
            throw new IllegalArgumentException("the waypoint can not be null");
        }
        waypoints.add(waypoint);
    }

    /**
     * <p>
     * Inserts a waypoint to this Polyline at the given position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).
     * </p>
     *
     * @param index the index at which the waypoint is to be inserted
     * @param waypoint the waypoint to be inserted
     * @throws IllegalArgumentException if waypoint is null, or index is out of range (index < 0 || index >
     *         countWaypoints())
     */
    public void addWaypoint(int index, Point waypoint) {
        if (waypoint == null) {
            throw new IllegalArgumentException("the waypoint can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index > waypoints.size()) {
            throw new IllegalArgumentException("index can not be larger than size");
        }
        waypoints.add(index, waypoint);
    }

    /**
     * <p>
     * Replaces the waypoint in this Polyline at the given position with the specified one.
     * </p>
     *
     * @param index the waypoint to replace
     * @param waypoint the waypoint to be stored
     * @throws IllegalArgumentException if waypoint is null, or index is out of range (index < 0 || index >=
     *         countWaypoints())
     */
    public void setWaypoint(int index, Point waypoint) {
        if (waypoint == null) {
            throw new IllegalArgumentException("the waypoint can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= waypoints.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        waypoints.set(index, waypoint);
    }

    /**
     * <p>
     * Removes the waypoint from this Polyline at the specified position. All subsequent elements are shifted
     * to the left. Returns the removed waypoint.
     * </p>
     *
     * @param index the index of the waypoint to be removed
     * @return the removed waypoint
     * @throws IllegalArgumentException if index is out of range (index < 0 || index >= countWaypoints())
     */
    public Point removeWaypoint(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= waypoints.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        return waypoints.remove(index);
    }

    /**
     * <p>
     * Removes the waypoint from this Polyline. If the waypoint is a duplicated element, only the first one is
     * removed. Returns true if the waypoint is removed, false otherwise.
     * </p>
     *
     * @param waypoint the waypoint to be removed
     * @return true if the waypoint is removed, false otherwise
     * @throws IllegalArgumentException if waypoint is null
     */
    public boolean removeWaypoint(Point waypoint) {
        if (waypoint == null) {
            throw new IllegalArgumentException("the waypoint can not be null");
        }
        return waypoints.remove(waypoint);
    }

    /**
     * <p>
     * Removes all the waypoints from this Polyline.
     * </p>
     */
    public void clearWaypoints() {
        waypoints.clear();
    }

    /**
     * <p>
     * Returns a copy of the waypoints from this Polyline.
     * </p>
     *
     * @return a copy of the waypoints from this Polyline
     */
    public List<Point> getWaypoints() {
        return new ArrayList<Point>(waypoints);
    }

    /**
     * <p>
     * Returns true if the waypoint is in this Polyline, false otherwise.
     * </p>
     *
     * @param waypoint the waypoint to be checked for inclusion
     * @return true if the waypoint is in this Polyline, false otherwise
     * @throws IllegalArgumentException if waypoint is null
     */
    public boolean containsWaypoint(Point waypoint) {
        if (waypoint == null) {
            throw new IllegalArgumentException("the waypoint can not be null");
        }
        return waypoints.contains(waypoint);
    }

    /**
     * <p>
     * Returns the index of the first occurrence of the given waypoint in this Polyline.
     * </p>
     *
     * @param waypoint the waypoint to search for
     * @return the position of the waypoint, -1 if not found
     * @throws IllegalArgumentException if waypoint is null
     */
    public int indexOfWaypoint(Point waypoint) {
        if (waypoint == null) {
            throw new IllegalArgumentException("the waypoint can not be null");
        }
        return waypoints.indexOf(waypoint);
    }

    /**
     * <p>
     * Returns the number of the waypoints from this Polyline.
     * </p>
     *
     * @return the number of the waypoints from this Polyline
     */
    public int countWaypoints() {
        return waypoints.size();
    }
}
