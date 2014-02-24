/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class and GraphNode are the core classes of Diagram Interchange, and every visible model element is
 * represented by them. The base class of GraphEdge and GraphNode is GraphElement. A GraphEdge has two
 * GraphConnectors which are called anchors and are its connection end point. End points must correspond to
 * the first and the last waypoints. A GraphEdge can be connected to another GraphEdge or to a GraphNode
 * through a GraphConnector. Examples of GraphEdges in a class diagram are associations, aggregations,
 * extensions. For a GraphEdge position serves as origin for all contained DiagramElements. It is drawn with a
 * Bezier curve passing through all waypoints, which are of type BezierPoint.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable and is not thread-safe, since thread safety is not required.
 * Instead, the calling application is required to ensure thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class GraphEdge extends GraphElement {

    /**
     * <p>
     * The maximum number of anchors of this GraphEdge.
     * </p>
     */
    private static final int MAX_SIZE = 2;

    /**
     * <p>
     * Represents the waypoints of this GraphEdge. Can never be null. Can be empty. Elements cannot be null.
     * There can be duplicated elements. Default to empty.
     * </p>
     */
    private final List<Point> waypoints = new ArrayList<Point>();

    /**
     * <p>
     * Represents the two GraphConnectors that anchor this GraphEdge. They are ordered in the same way as the
     * waypoints. The first anchor corresponds to the first waypoint, the second anchor correspond to the last
     * waypoint, but this doesn't mean a GraphConnector is obliged to have the same position of the
     * corresponding end point. Can never be null. Can be empty. Elements cannot be null. There can be
     * duplicated elements. Default to empty.
     * </p>
     */
    private final List<GraphConnector> anchors = new ArrayList<GraphConnector>();

    /**
     * <p>
     * Creates an instance of GraphEdge.
     * </p>
     */
    public GraphEdge() {
        super();
    }

    /**
     * <p>
     * Appends a waypoint to this GraphEdge at the end.
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
     * Inserts a waypoint to this GraphEdge at the given position. Shifts the element currently at that
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
     * Replaces the waypoint in this GraphEdge at the given position with the specified one.
     * </p>
     *
     * @param index the index of the waypoint to replace
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
     * Removes the waypoint from this GraphEdge at the specified position. All subsequent elements are shifted
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
     * Removes the waypoint from this GraphEdge. If the waypoint is a duplicated element, only the first one
     * is removed. Returns true if the waypoint is removed, false otherwise.
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
     * Removes all the waypoints from this GraphEdge.
     * </p>
     */
    public void clearWaypoints() {
        waypoints.clear();
    }

    /**
     * <p>
     * Returns a copy of the waypoints from this GraphEdge.
     * </p>
     *
     * @return a copy of the waypoints from this GraphEdge
     */
    public List<Point> getWaypoints() {
        return new ArrayList<Point>(waypoints);
    }

    /**
     * <p>
     * Returns true if the waypoint is in this GraphEdge, false otherwise.
     * </p>
     *
     * @param waypoint the waypoint to be checked for inclusion
     * @return true if the waypoint is in this GraphEdge, false otherwise
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
     * Returns the index of the first occurrence of the given waypoint in this GraphEdge.
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
     * Returns the number of the waypoints from this GraphEdge.
     * </p>
     *
     * @return the number of the waypoints from this GraphEdge
     */
    public int countWaypoints() {
        return waypoints.size();
    }

    /**
     * <p>
     * Appends an anchor to this GraphEdge at the end. There should be at most two anchors.
     * </p>
     *
     * @param anchor the anchor to be appended
     * @throws IllegalArgumentException if anchor is null
     * @throws IllegalStateException if there are already two anchors
     */
    public void addAnchor(GraphConnector anchor) {
        if (anchors.size() == MAX_SIZE) {
            throw new IllegalStateException("there are already two anchors");
        }
        if (anchor == null) {
            throw new IllegalArgumentException("the anchor can not be null");
        }
        anchors.add(anchor);
    }

    /**
     * <p>
     * Inserts an anchor to this GraphEdge at the given position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices). There should be
     * at most two anchors.
     * </p>
     *
     * @param index the index at which the anchor is to be inserted
     * @param anchor the anchor to be inserted
     * @throws IllegalArgumentException if anchor is null, or index is out of range (index < 0 || index >
     *         countAnchors())
     * @throws IllegalStateException if there are already two anchors
     */
    public void addAnchor(int index, GraphConnector anchor) {
        if (anchors.size() == MAX_SIZE) {
            throw new IllegalStateException("there are already two anchors");
        }
        if (anchor == null) {
            throw new IllegalArgumentException("the anchor can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index > anchors.size()) {
            throw new IllegalArgumentException("index can not be larger than size");
        }
        anchors.add(index, anchor);
    }

    /**
     * <p>
     * Replaces the anchor in this GraphEdge at the given position with the specified one.
     * </p>
     *
     * @param index the index of the anchor to replace
     * @param anchor the anchor to be stored
     * @throws IllegalArgumentException if anchor is null, or index is out of range (index < 0 || index >=
     *         countAnchors())
     */
    public void setAnchor(int index, GraphConnector anchor) {
        if (anchor == null) {
            throw new IllegalArgumentException("the anchor can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= anchors.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        anchors.set(index, anchor);
    }

    /**
     * <p>
     * Removes the anchor from this GraphEdge at the specified positions. All subsequent elements are shifted
     * to the left. Returns the removed anchor.
     * </p>
     *
     * @param index the index of the anchor to be removed
     * @return the removed anchor
     * @throws IllegalArgumentException if index is out of range (index < 0 || index >= countAnchors())
     */
    public GraphConnector removeAnchor(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= anchors.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        return anchors.remove(index);
    }

    /**
     * <p>
     * Removes the anchor from this GraphEdge. If anchor is a duplicated element, only the first instance is
     * removed. Returns true if the anchor is removed, false otherwise.
     * </p>
     *
     * @param anchor the anchor to be removed
     * @return true if the anchor is removed, false otherwise
     * @throws IllegalArgumentException if anchor is null
     */
    public boolean removeAnchor(GraphConnector anchor) {
        if (anchor == null) {
            throw new IllegalArgumentException("the anchor can not be null");
        }
        return anchors.remove(anchor);
    }

    /**
     * <p>
     * Removes all the anchors of this GraphEdge.
     * </p>
     */
    public void clearAnchors() {
        anchors.clear();
    }

    /**
     * <p>
     * Returns a copy of the anchors of this GraphEdge.
     * </p>
     *
     * @return a copy of the anchors of this GraphEdge
     */
    public List<GraphConnector> getAnchors() {
        return new ArrayList<GraphConnector>(anchors);
    }

    /**
     * <p>
     * Returns true if the anchor is in this GraphEdge, false otherwise.
     * </p>
     *
     * @param anchor the anchor to be checked for inclusion
     * @return true if the anchor is in this GraphEdge, false otherwise
     * @throws IllegalArgumentException if anchor is null
     */
    public boolean containsAnchor(GraphConnector anchor) {
        if (anchor == null) {
            throw new IllegalArgumentException("the anchor can not be null");
        }
        return anchors.contains(anchor);
    }

    /**
     * <p>
     * Returns the index of the first occurrence of the given anchor in this GraphEdge.
     * </p>
     *
     * @param anchor the anchor to search for
     * @return the position of the anchor, -1 if not found
     * @throws IllegalArgumentException if anchor is null
     */
    public int indexOfAnchor(GraphConnector anchor) {
        if (anchor == null) {
            throw new IllegalArgumentException("the anchor can not be null");
        }
        return anchors.indexOf(anchor);
    }

    /**
     * <p>
     * Returns the number of the anchors of this GraphEdge.
     * </p>
     *
     * @return the number of the anchors of this GraphEdge
     */
    public int countAnchors() {
        return anchors.size();
    }
}